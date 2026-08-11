package com.id.control.serviceimpl;

import com.id.control.dto.UsuarioGuardarDTO;
import com.id.control.entity.CatEstatusUsuario;
import com.id.control.entity.CodigoAsignacionUsuario;
import com.id.control.entity.Trabajador;
import com.id.control.entity.Usuario;
import com.id.control.entity.UsuarioSeguridad;
import com.id.control.exception.NotFoundException;
import com.id.control.repository.CatEstatusUsuarioRepository;
import com.id.control.repository.TrabajadorRepository;
import com.id.control.repository.UsuarioRepository;
import com.id.control.repository.UsuarioSeguridadRepository;
import com.id.control.service.UsuarioService;
import com.id.control.util.Response;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioSeguridadRepository usuarioSeguridadRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private CatEstatusUsuarioRepository catEstatusUsuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Register a user
    @Override
    public void registerUser(UsuarioGuardarDTO usuarioDTO) {

        //Buscar Trabajador por id
        Trabajador trabajador = trabajadorRepository.findById(usuarioDTO.getTrabajadorId()).get();
        //Buscar estatus Usuario por id
        CatEstatusUsuario estatusUsuario = catEstatusUsuarioRepository.findById(usuarioDTO.getEstatusUsuario()).get();
        Usuario usuarioNew = new Usuario();
        //Table usuario
        usuarioNew.setLoginEmail(usuarioDTO.getLoginEmail());
        usuarioNew.setLoginTelefono(usuarioDTO.getLoginTelefono());
        /*
            
        Desde las vistas ADMINISTRADOR - SUPERVISOR podran realizar el registro de un trabajador
        donde colocaran l
        
        Roles:
        
        # ADMINISTRADOR - ROL con todos los privilegios y manejo de catalogos.
        # SUPERVISOR    - Rol con privilegios, sin acceso a catalogos.
        # CAJA          - Rol con acceso a módulo de cobro de productos y generación de tickets
        # VENTANILLA    - Rol con acceso a atención de quejas, sugerencias de clientes
        # CAPTURISTA    - Rol con acceso al módulo de gestión administrativa (contadores)
        # USER          - Rol con acceso limitado(indefinido), solo mostrar un componente con la información de usuario, nomina y fechas de pago 
        (es trabajador, pero aun no lo asignan un rol especifico o sus funciones no corresponden con la funcionalidad del sistema )
         */
        usuarioNew.setUsername(usuarioDTO.getUsername()); //Posiblemente incorporar logica de nombre de usario con formato (primerNombre.primerApellido)
        usuarioNew.setTrabajador(trabajador);
        usuarioNew.setCatEstatusUsuario(estatusUsuario);
        usuarioNew.setFechaRegistro(LocalDateTime.now());
        usuarioNew.setRoles(usuarioDTO.getRoles());

        //Guardar registros en tabla Usuario
        usuarioRepository.save(usuarioNew);

        //Guardar registros en tabla seguridad_usuario
        saveUsuarioSeguridad(usuarioNew, usuarioDTO.getPassword());

        //Guardar registros en tabla codigo_asignacion_usuario
        saveCodigoAsignacionUsuario(usuarioNew);

    }

    //Guardar registro en tabla usuario_seguridad
    private void saveUsuarioSeguridad(Usuario usuario, String password) {
        UsuarioSeguridad usuarioSeugridad = new UsuarioSeguridad();
        usuarioSeugridad.setUsuario(usuario);
        usuarioSeugridad.setPassword(passwordEncoder.encode(password));
        usuarioSeugridad.setTelConfirmado(Boolean.FALSE);
        usuarioSeugridad.setEmailConfirmado(Boolean.FALSE);
        usuarioSeugridad.setUltimoCambioPWD(LocalDateTime.now());
        usuarioSeugridad.setIntentosFallidos((short) 0);
        usuarioSeguridadRepository.save(usuarioSeugridad);
    }

    //Guardar registro en tabla codigo_asignacion_usuario
    private void saveCodigoAsignacionUsuario(Usuario usuario) {
        CodigoAsignacionUsuario codigoAsignacionUsuario = new CodigoAsignacionUsuario();
        codigoAsignacionUsuario.setUsuario(usuario);
        //Generar un codigo de 6 digitos pero irrepetible, comparando primero en base de datos si el codigo generado ya existe,
        //en caso de que exista intentar de nuevo.
        int codigo = generarCodigo();
        codigoAsignacionUsuario.setCodigoVerificacion(codigo);
        codigoAsignacionUsuario.setCodigoUtilizado(Boolean.FALSE); //Valor por default al crear un nuevo usuario
        codigoAsignacionUsuario.setExpired(Boolean.FALSE);
        //Crear fecha de expiracion= fecha actual + 15 dias
        codigoAsignacionUsuario.setFechaExpiracion(LocalDateTime.now().plusDays(15)); //Asignar 15 dias a la fecha de expiración
    }

    //Generar codigo de 6 digitos
    private int generarCodigo() {
        return 100000 + SECURE_RANDOM.nextInt(900000);
    }

    @Override
    public UsuarioGuardarDTO loadUserByEmail(String loginEmail) {
        UsuarioGuardarDTO usuario = usuarioRepository.findUserByEmail(loginEmail);
        if (usuario == null) {
            throw new NotFoundException(Response.USUARIO_NO_ENCONTRADO.getMessage());
        } else {
            return usuario;

        }
    }

    @Override
    public Usuario loadByUsername(String username) {
        Usuario usuario = usuarioRepository.buscarPorEmailTelefonoUsername(username).get();
        if (usuario == null) {
            throw new NotFoundException(Response.USUARIO_NO_ENCONTRADO.getMessage());
        } else {
            return usuario;
        }
    }

    //Cargar usuario por optionLogin
    @Override
    public UsuarioSeguridad loadUserByOptionLogin(String optionLogin) {
        return usuarioSeguridadRepository.buscarPorEmailTelefonoUsername(optionLogin);
    }

}
