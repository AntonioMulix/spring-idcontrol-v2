package com.id.control.serviceimpl;

import com.id.control.dto.MenuNavDTO;
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
        } else {
            MenuNav newMenu = new MenuNav();
            newMenu.setDescripcion(menuDTO.getDescripcion());
            newMenu.setEstatus(true); //Por defecto al crearlo es activo.
            menuNavRepository.save(newMenu);
        }
    }

    //Actualizar
    @Override
    public void updateMenu(Integer idMenu, MenuNavDTO menuDTO) {
        if (menuDTO == null) {
            throw new BadRequestException("No se ingresaron datos");
        } else {
            MenuNav updateMenu = menuNavRepository.findById(idMenu).get();
            if (updateMenu == null) {
                throw new NotFoundException("No se encontraron resultados");
            } else {
                updateMenu.setDescripcion(menuDTO.getDescripcion());
                updateMenu.setEstatus(true); //Por defecto al actualizar es activo.
                menuNavRepository.save(updateMenu);
            }

        }
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
            newSubmenu.setMenuNav(findMenu);
            newSubmenu.setEstatus(true); //Por defecto al crearlo es activo.
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
                updateSubmenu.setMenuNav(findMenu);
                updateSubmenu.setEstatus(true); //Por defecto al actualizar es activo.
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
