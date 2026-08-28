package com.id.control.serviceimpl;

import com.id.control.dto.MenuNavDTO;
import com.id.control.dto.MenuNavItemDTO;
import com.id.control.dto.SubmenuNavDTO;
import com.id.control.entity.MenuNav;
import com.id.control.entity.SubmenuNav;
import com.id.control.exception.BadRequestException;
import com.id.control.exception.NotFoundException;
import com.id.control.repository.MenuNavRepository;
import com.id.control.service.MenuNavService;
import org.springframework.stereotype.Service;
import com.id.control.repository.SubmenuNavRepository;
import com.id.control.util.Response;
import java.util.List;

/**
 *
 * @author marco-romero
 */
@Service
public class MenuNavServiceImpl implements MenuNavService {
    
    private final MenuNavRepository menuNavRepository;
    private final SubmenuNavRepository submenuNavRepository;
    
    public MenuNavServiceImpl(MenuNavRepository menuNavRepository, SubmenuNavRepository submenuNavRepository) {
        this.menuNavRepository = menuNavRepository;
        this.submenuNavRepository = submenuNavRepository;
    }

    //Guardar
    @Override
    public void saveMenu(MenuNavDTO menuDTO) {
        
        if (menuDTO == null) {
            throw new BadRequestException("No se ingresaron los datos");
        }
        
        MenuNav findOrdenMenu = menuNavRepository.findLastOneOrder();
        MenuNav existeNumOrden = menuNavRepository.findByOrderNum(menuDTO.getOrden());
        
        MenuNav newMenu = new MenuNav();
        newMenu.setDescripcion(menuDTO.getDescripcion());
        newMenu.setUrl(menuDTO.getUrl());
        newMenu.setIcon(menuDTO.getIcon());
        newMenu.setEstatus(true);

        // Determinar el siguiente consecutivo
        Integer siguienteOrden = 1;
        
        if (findOrdenMenu != null && findOrdenMenu.getOrden() != null) {
            siguienteOrden = findOrdenMenu.getOrden() + 1;
        }

        // Si no se especificó orden, colocar el siguiente consecutivo
        if (menuDTO.getOrden() == null) {
            
            newMenu.setOrden(siguienteOrden);
            
        } else if (existeNumOrden != null) {

            // El nuevo menú toma el orden solicitado
            newMenu.setOrden(menuDTO.getOrden());

            // El menú que ya tenía ese orden pasa al final
            existeNumOrden.setOrden(siguienteOrden);
            
            menuNavRepository.save(existeNumOrden);
            
        } else {

            // El orden solicitado está disponible
            newMenu.setOrden(menuDTO.getOrden());
        }
        
        menuNavRepository.save(newMenu);
    }

    //Actualizar
    @Override
    public void updateMenu(Integer idMenu, MenuNavDTO menuDTO) {
        
        if (menuDTO == null) {
            throw new BadRequestException("No se ingresaron datos");
        }
        
        MenuNav updateMenu = menuNavRepository.findById(idMenu)
                .orElseThrow(()
                        -> new NotFoundException("No se encontraron resultados"));
        
        Integer nuevoOrden = menuDTO.getOrden();
        Integer ordenAnterior = updateMenu.getOrden();
        
        MenuNav existeNumOrden = null;
        
        if (nuevoOrden != null) {
            existeNumOrden = menuNavRepository.findByOrderNum(nuevoOrden);
        }
        
        updateMenu.setDescripcion(menuDTO.getDescripcion());
        updateMenu.setUrl(menuDTO.getUrl());
        updateMenu.setIcon(menuDTO.getIcon());
        updateMenu.setEstatus(true);

        // El orden no cambió
        if (nuevoOrden == null || nuevoOrden.equals(ordenAnterior)) {
            
            updateMenu.setOrden(ordenAnterior);
            
        } else if (existeNumOrden == null) {

            // El nuevo orden está disponible
            updateMenu.setOrden(nuevoOrden);
            
        } else {

            // El nuevo orden pertenece a otro menú:
            // intercambiar las posiciones.
            existeNumOrden.setOrden(ordenAnterior);
            updateMenu.setOrden(nuevoOrden);
            
            menuNavRepository.save(existeNumOrden);
        }
        
        menuNavRepository.save(updateMenu);
    }

    //Cambiar estatus
    @Override
    public void updateEstatusMenu(Integer idMenu) {
        MenuNav updateEstatus = menuNavRepository.findById(idMenu).get();
        if (updateEstatus == null) {
            throw new NotFoundException("No se encontraron resultados");
        } else {
            if (updateEstatus.isEstatus()) {
                updateEstatus.setEstatus(false);
                menuNavRepository.save(updateEstatus);
            } else {
                updateEstatus.setEstatus(true);
                menuNavRepository.save(updateEstatus);
            }
            
        }
        
    }

    //Eliminar registro
    @Override
    public void deleteMenu(Integer idMenu) {
        menuNavRepository.deleteById(idMenu);
        
    }

    // Listar Menu
    @Override
    public List<MenuNavItemDTO> listAllMenu() {
        
        List<MenuNav> menus = menuNavRepository.findAllMenusWithSubmenus();
        
        return menus.stream()
                .map(menu -> new MenuNavItemDTO(
                menu.getIdMenuNav(),
                menu.getDescripcion(),
                menu.getUrl(),
                menu.getIcon(),
                menu.isEstatus(),
                menu.getOrden(),
                menu.getSubmenus()
                        .stream()
                        .map(submenu -> new SubmenuNavDTO(
                        submenu.getDescripcion(),
                        submenu.getUrl(),
                        submenu.getMenuNav().getIdMenuNav(),
                        submenu.getIcon(),
                        submenu.isEstatus(),
                        submenu.getOrden()
                ))
                        .toList()
        ))
                .toList();
    }

    //***************************** SERVICIOS - SUBMENU ***************************
    //Listar todo
    @Override
    public List<SubmenuNav> listAllMenuNav() {
        return submenuNavRepository.findAll();
    }

    //GUARDAR
    @Override
    public void saveSubmenu(SubmenuNavDTO subMenuNavDTO) {
        if (subMenuNavDTO == null) {
            throw new BadRequestException(Response.DATOS_INVALIDOS.getMessage());
        } else {
            SubmenuNav newSubmenu = new SubmenuNav();
            MenuNav findMenu = menuNavRepository.findById(subMenuNavDTO.getMenuNavId()).get();
            if (findMenu == null) {
                throw new BadRequestException(Response.MENU_NOT_FOUND.getMessage());
            }
            newSubmenu.setDescripcion(subMenuNavDTO.getDescripcion());
            newSubmenu.setUrl(subMenuNavDTO.getUrl());
            newSubmenu.setMenuNav(findMenu);
            newSubmenu.setIcon(subMenuNavDTO.getIconSubmenu());
            newSubmenu.setEstatus(true); //Por defecto al crearlo es activo.
            newSubmenu.setOrden(subMenuNavDTO.getOrden());
            submenuNavRepository.save(newSubmenu);
        }
    }

    //ACTUALIZAR
    @Override
    public void updateSubmenu(Integer idSubmenu, SubmenuNavDTO subMenuNavDTO) {
        if (subMenuNavDTO == null) {
            throw new BadRequestException("No se ingresaron datos");
        } else {
            SubmenuNav updateSubmenu = submenuNavRepository.findById(idSubmenu).get();
            if (updateSubmenu == null) {
                throw new NotFoundException(Response.NOT_FOUND.getMessage());
            } else {
                MenuNav findMenu = menuNavRepository.findById(subMenuNavDTO.getMenuNavId()).get();
                if (findMenu == null) {
                    throw new BadRequestException(Response.MENU_NOT_FOUND.getMessage());
                }
                updateSubmenu.setDescripcion(subMenuNavDTO.getDescripcion());
                updateSubmenu.setUrl(subMenuNavDTO.getUrl());
                updateSubmenu.setMenuNav(findMenu);
                updateSubmenu.setIcon(subMenuNavDTO.getIconSubmenu());
                updateSubmenu.setEstatus(true); //Por defecto al actualizar es activo.
                updateSubmenu.setOrden(subMenuNavDTO.getOrden());
                submenuNavRepository.save(updateSubmenu);
            }
            
        }
    }

    //Cambiar estatus
    @Override
    public void updateEstatusSubmenu(Integer idSubmenu) {
        SubmenuNav updateEstatus = submenuNavRepository.findById(idSubmenu).get();
        if (updateEstatus == null) {
            throw new NotFoundException(Response.NOT_FOUND.getMessage());
        } else {
            if (updateEstatus.isEstatus()) {
                updateEstatus.setEstatus(false);
                submenuNavRepository.save(updateEstatus);
            } else {
                updateEstatus.setEstatus(true);
                submenuNavRepository.save(updateEstatus);
            }
            
        }
    }

    //Eliminar Submenu
    @Override
    public void deleteSubmenu(Integer idSubmenu) {
        SubmenuNav deleteSubmenu = submenuNavRepository.findById(idSubmenu).get();
        if (deleteSubmenu == null) {
            throw new NotFoundException(Response.NOT_FOUND.getMessage());
        }
        menuNavRepository.deleteById(idSubmenu);
    }
}
