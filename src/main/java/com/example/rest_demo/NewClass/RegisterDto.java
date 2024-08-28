package com.example.rest_demo.NewClass;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String Password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

