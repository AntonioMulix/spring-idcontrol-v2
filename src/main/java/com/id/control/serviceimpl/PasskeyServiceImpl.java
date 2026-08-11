package com.id.control.serviceimpl;

import com.id.control.config.properties.WebAuthnProperties;
import com.id.control.dto.request.RegistrationOptionsRequestDTO;
import com.id.control.dto.response.RegistrationOptionsResponseDTO;
import com.id.control.entity.ChallengePasskey;
import com.id.control.repository.ChallengePasskeyRepository;
import com.id.control.service.PasskeyService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marco-romero
 */
@Service
public class PasskeyServiceImpl implements PasskeyService {

    @Autowired
    private ChallengePasskeyRepository challengePasskeyRepository;

    @Autowired
    private WebAuthnProperties webAuthnProperties;

    @Override
    @Transactional
    public RegistrationOptionsResponseDTO optionsPasskey(
            RegistrationOptionsRequestDTO registratiionOptionsRequestDTO) {

        byte[] challengeBytes = new byte[32];
        new SecureRandom().nextBytes(challengeBytes);

        // Crear nueva instancia para registrar challenge en base de datos
        ChallengePasskey challengePasskey = new ChallengePasskey();

        String challenge = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(challengeBytes);
        challengePasskey.setChallenge(challenge);
        challengePasskey.setUsuarioId(registratiionOptionsRequestDTO.getIdUsuario());

        /* Guardar challenge temporalmente */
        challengePasskeyRepository.save(challengePasskey);

        // Construir respuesta
        return new RegistrationOptionsResponseDTO(
                new RegistrationOptionsResponseDTO.Rp(
                        webAuthnProperties.getRpName(),
                        webAuthnProperties.getRpId()),
                new RegistrationOptionsResponseDTO.User(
                        registratiionOptionsRequestDTO.getIdUsuario(),
                        registratiionOptionsRequestDTO.getCurp(),
                        registratiionOptionsRequestDTO.getNombreCompleto()),
                challenge,
                List.of(
                        new RegistrationOptionsResponseDTO.PubKeyCredParam(
                                "public-key",
                                -7),
                        new RegistrationOptionsResponseDTO.PubKeyCredParam(
                                "public-key",
                                -257)),
                60000L,
                List.of(),
                new RegistrationOptionsResponseDTO.AuthenticatorSelection(
                        "preferred",
                        "preferred",
                        "platform"),
                "none",
                new RegistrationOptionsResponseDTO.Extensions(
                        true));
    }
}
