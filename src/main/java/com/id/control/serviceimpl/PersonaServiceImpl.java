package com.id.control.serviceimpl;

import com.id.control.dto.PersonaDTO;
import com.id.control.entity.CatGenero;
import com.id.control.entity.Persona;
import com.id.control.repository.CatGeneroRepository;
import com.id.control.repository.PersonaRepository;
import com.id.control.service.PersonaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final CatGeneroRepository catGeneroRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository, CatGeneroRepository catGeneroRepository) {
        this.personaRepository = personaRepository;
        this.catGeneroRepository = catGeneroRepository;
    }

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
