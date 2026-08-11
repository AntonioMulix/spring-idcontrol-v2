package com.id.control.serviceimpl;

import com.id.control.dto.PersonaDTO;
import com.id.control.entity.CatGenero;
import com.id.control.entity.Persona;
import com.id.control.repository.CatGeneroRepository;
import com.id.control.repository.PersonaRepository;
import com.id.control.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CatGeneroRepository catGeneroRepository;

    @Override
    public void guardarPersona(PersonaDTO personaDTO) {
        Persona nuevaPersona = new Persona();

        //Recuperar el valor de genero por ID
        CatGenero genero = catGeneroRepository.findById(personaDTO.getCatGeneroId()).get();

        nuevaPersona.setNombre(personaDTO.getNombre());
        nuevaPersona.setPrimerApellido(personaDTO.getPrimerApellido());
        nuevaPersona.setSegundoApellido(personaDTO.getSegundoApellido());
        nuevaPersona.setCatGenero(genero);
        nuevaPersona.setDomicilio(personaDTO.getDomicilio());
        nuevaPersona.setEmail(personaDTO.getEmail());
        nuevaPersona.setTelefono(personaDTO.getTelefono());

        //Guardar persona
        personaRepository.save(nuevaPersona);
    }

}
