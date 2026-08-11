package com.id.control.service;

import com.id.control.dto.MenuNavDTO;
import com.id.control.dto.SubmenuNavDTO;
import com.id.control.entity.SubmenuNav;
import java.util.List;

/**
 *
 * @author marco-romero
 */
public interface MenuNavService {

    //********************************* MENU-NAV ****************************
    //Guardar
    public void saveMenu(MenuNavDTO menuDTO);

    //Actualizar
    public void updateMenu(Integer idMenu, MenuNavDTO menuDTO);

    //Change Estatus
    public void updateEstatusMenu(Integer idMenu);

    //Eliminar Menu
    public void deleteMenu(Integer idMenu);

    //******************************** SUBMENU-NAV *****************************
    //Listar todo Menu y Submenu
    public List<SubmenuNav> listAllMenuNav();

    //Guardar
    public void saveSubmenu(SubmenuNavDTO subMenuNavDTO);

    //Actualizar
    public void updateSubmenu(Integer idSubmenu, SubmenuNavDTO subMenuNavDTO);

    //Cambiar estatus
    public void updateEstatusSubmenu(Integer idSubmenu);

    //Eliminar Submenu
    public void deleteSubmenu(Integer idSubmenu);
}
