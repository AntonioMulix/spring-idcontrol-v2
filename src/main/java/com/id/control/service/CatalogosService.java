package com.id.control.service;

import com.id.control.dto.CatEstatusUsuarioDTO;
import com.id.control.dto.CatGeneroDTO;
import com.id.control.entity.CatGenero;
import java.util.List;

/**
 *
 * @author marco-romero
 */
public interface CatalogosService {

    /*=================================================================  
    CATALOGO GENERO 
    ===================================================================*/
    //Listar todos los campos
    public List<CatGeneroDTO> listAllCatGenero();

    //Guardar
    public void guardarGenero(CatGeneroDTO catGeneroDTO);

    /*=================================================================
    CATALOGO ESTATUS USUARIO
    ===================================================================*/
    public void guardarEstatusUsuario(CatEstatusUsuarioDTO catEstatusUsuarioDTO);
}
