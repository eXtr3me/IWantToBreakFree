package org.academiadecodigo.variachis.delta.back_end.dto;

import javax.validation.constraints.*;

public class AuthCustomerDTO {

    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    @Size(min = 4, max = 20)
    private String username;

    @Size(min = 6, max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthCustomerDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
