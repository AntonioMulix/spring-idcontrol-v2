package com.id.control.controller;

import com.id.control.dto.request.RegistrationOptionsRequestDTO;
import com.id.control.dto.response.RegistrationOptionsResponseDTO;
import com.id.control.exception.ApiResponse;
import com.id.control.service.PasskeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("/v1/passkeys")
public class PasskeyController {

    @Autowired
    private PasskeyService passkeyService;

    //AttestationOptions
    @PostMapping("/attestationOptions")
    public ResponseEntity<ApiResponse<RegistrationOptionsResponseDTO>> optionPasskey(
            @RequestBody RegistrationOptionsRequestDTO registrationOptionsRequestDTO) {
        RegistrationOptionsResponseDTO result = passkeyService.optionsPasskey(registrationOptionsRequestDTO);
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

}
