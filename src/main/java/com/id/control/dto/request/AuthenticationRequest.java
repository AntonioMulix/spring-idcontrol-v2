package com.id.control.dto.request;

/**
 *
 * @author marco-romero
 */
public class AuthenticationRequest {

    //Opciones de autenticacion (email, telefono o username)
    private String loginOption; //(email, telefono o username)
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String loginOption, String password) {
        this.loginOption = loginOption;
        this.password = password;
    }

    public String getLoginOption() {
        return loginOption;
    }

    public void setLoginOption(String loginOption) {
        this.loginOption = loginOption;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
