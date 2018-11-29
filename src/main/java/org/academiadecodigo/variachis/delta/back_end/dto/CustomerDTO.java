package org.academiadecodigo.variachis.delta.back_end.dto;

import javax.validation.constraints.*;

public class CustomerDTO {

    private Integer id;

    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    @Size(min = 4, max = 20)
    private String username;

    @Size(min = 6, max = 20)
    private String password;

    @Email
    @NotBlank(message = "email is mandatory")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private String phone;

    private String addiction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddiction() {
        return addiction;
    }

    public void setAddiction(String addiction) {
        this.addiction = addiction;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
