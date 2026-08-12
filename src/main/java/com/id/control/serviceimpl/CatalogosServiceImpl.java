package com.id.control.serviceimpl;

import com.id.control.dto.CatEstatusUsuarioDTO;
import com.id.control.dto.CatGeneroDTO;
import com.id.control.entity.CatEstatusUsuario;
import com.id.control.entity.CatGenero;
import com.id.control.repository.CatEstatusUsuarioRepository;
import com.id.control.repository.CatGeneroRepository;
import com.id.control.service.CatalogosService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class CatalogosServiceImpl implements CatalogosService {

    private final CatGeneroRepository catGeneroRepository;
    private final CatEstatusUsuarioRepository catEstatusUsuarioRepository;

    public CatalogosServiceImpl(CatGeneroRepository catGeneroRepository, CatEstatusUsuarioRepository catEstatusUsuarioRepository) {
        this.catGeneroRepository = catGeneroRepository;
        this.catEstatusUsuarioRepository = catEstatusUsuarioRepository;
    }

    /*===================================================================000
     CATALOGO GENERO
     ==================================================================00*/
    //Listar todos los datos
    @Override
    public List<CatGeneroDTO> listAllCatGenero() {
        return catGeneroRepository.findAll().stream().map(catGenero -> new CatGeneroDTO(
                catGenero.getDescripcion(),
                catGenero.getEstatus())).toList();
    }

    //Guardar nuevo registro
    @Override
    public void guardarGenero(CatGeneroDTO catGeneroDTO) {
        CatGenero nuevoGenero = new CatGenero();
        nuevoGenero.setDescripcion(catGeneroDTO.getDescripcion());
        nuevoGenero.setEstatus(Boolean.TRUE);
        catGeneroRepository.save(nuevoGenero);
    }

    /*======================================================================
    CATALOGO ESTATUS USUARIO
    ========================================================================*/
    @Override
    public void guardarEstatusUsuario(CatEstatusUsuarioDTO catEstatusUsuarioDTO) {
        CatEstatusUsuario nuevoEstatusUsuario = new CatEstatusUsuario();
        nuevoEstatusUsuario.setDescripcion(catEstatusUsuarioDTO.getDescripcion());
        nuevoEstatusUsuario.setEstatus(Boolean.TRUE);
        catEstatusUsuarioRepository.save(nuevoEstatusUsuario);
    }

}
