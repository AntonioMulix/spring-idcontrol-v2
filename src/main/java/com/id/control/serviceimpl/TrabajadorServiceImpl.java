package com.id.control.serviceimpl;

import com.id.control.dto.TrabajadorDTO;
import com.id.control.entity.Persona;
import com.id.control.entity.Trabajador;
import com.id.control.repository.PersonaRepository;
import com.id.control.repository.TrabajadorRepository;
import com.id.control.service.TrabajadorService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private PersonaRepository personaRepository;

    //Guardar nuevo trabajador
    @Override
    public void guardarTrabajador(TrabajadorDTO trabajadorDTO) {

        Trabajador nuevoTrabajador = new Trabajador();
        Persona persona = personaRepository.findById(trabajadorDTO.getPersonaId()).get();

        // Obtener el último registro
        Trabajador ultimoRegistroTrabajador = trabajadorRepository.findLastRegisterTrabajador();

        Long numeroEmpleado = (ultimoRegistroTrabajador == null)
                ? 1L
                : ultimoRegistroTrabajador.getNumEmpleado() + 1;

        nuevoTrabajador.setPersona(persona);

        // Número consecutivo
        nuevoTrabajador.setNumEmpleado(numeroEmpleado);

        /*
     * Formato del folio:
     * YYMM0000
     * Ejemplo:
     * 20070001
         */
        LocalDate fechaActual = LocalDate.now();

        // Año (2 dígitos) y mes (2 dígitos)
        String periodo = fechaActual.format(DateTimeFormatter.ofPattern("yyMM"));

        // Número de empleado con 4 dígitos
        String consecutivo = String.format("%04d", numeroEmpleado);

        // Folio completo
        String folioEmpleado = periodo + consecutivo;

        nuevoTrabajador.setFolioEmpleado(folioEmpleado);

        //Fecha de registro del usuario
        nuevoTrabajador.setFechaRegistro(LocalDateTime.now());
        trabajadorRepository.save(nuevoTrabajador);
    }

}
