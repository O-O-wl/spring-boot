package dev.east0.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    int id;
    String userid;
    String password;
    String email;
    String name;
    int departmentId;
}
