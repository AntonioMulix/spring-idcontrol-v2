package com.id.control.service;

import com.id.control.dto.request.RegistrationOptionsRequestDTO;
import com.id.control.dto.response.RegistrationOptionsResponseDTO;

/**
 *
 * @author marco-romero
 */
public interface PasskeyService {

    /*
        * This services are made as an other method to login to the app,
        It's a web service that contains all the logic to mantain all the data and the relation of passkeys 
        to an a register account in the applicative, its a service that is made to login and also
        a service that save data about the user that is login whit this method.
     */

    // Method for first step of webauthn - Generating WebAuthn credentialKeyPair
    public RegistrationOptionsResponseDTO optionsPasskey(RegistrationOptionsRequestDTO registratioOptionRequestDTO);

    // This methos is implemented for registration a passkey, it's important return
    // in the response all the basic necessary data that needs to be saved in the
    // pĺatform that is consuming the service
    // Metho
    // public RegisterPasskeyResponseDTO registerPasskey(RegisterPasskeyRequestDTO registerPasskeyRequestDTO);
}
