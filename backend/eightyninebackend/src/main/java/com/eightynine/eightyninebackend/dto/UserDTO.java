package com.eightynine.eightyninebackend.dto;

public class UserDTO {
    private String password;
    private String email;


    public UserDTO() {}

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

}
