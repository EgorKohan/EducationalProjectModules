package ru.javarush.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class SignupRequestDto {

    private String username;
    private String email;
    private Set<String> roles;
    private String password;

}
