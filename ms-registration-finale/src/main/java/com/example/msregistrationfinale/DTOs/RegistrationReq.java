package com.example.msregistrationfinale.DTOs;

import lombok.Data;

@Data
public class RegistrationReq {
    private String name;
    private String email;
    private String password;
    private String role;
}
