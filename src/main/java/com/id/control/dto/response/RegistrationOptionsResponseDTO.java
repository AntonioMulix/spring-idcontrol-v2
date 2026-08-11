package com.id.control.dto.response;

import java.util.List;

/**
 *
 * @author marco-romero
 */
public record RegistrationOptionsResponseDTO(
        Rp rp,
        User user,
        String challenge,
        List<PubKeyCredParam> pubKeyCredParams,
        Long timeout,
        List<ExcludeCredential> excludeCredentials,
        AuthenticatorSelection authenticatorSelection,
        String attestation,
        Extensions extensions
        ) {

    public record Rp(
            String name,
            String id) {

    }

    public record User(
            Long id,
            String curp,
            String displayName) {

    }

    public record PubKeyCredParam(
            String type,
            Integer alg) {

    }

    public record ExcludeCredential(
            String id,
            String type,
            List<String> transports) {

    }

    public record AuthenticatorSelection(
            String residentKey,
            String userVerification,
            String authenticatorAttachment) {

    }

    public record Extensions(
            Boolean credProps) {

    }
}
