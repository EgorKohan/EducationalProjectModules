package ru.javarush.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import ru.javarush.models.Role;

import java.util.Set;

@Data
public class JwtResponse {

    private String token;
    @Setter(value = AccessLevel.NONE)
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;

    public JwtResponse(String token, Long id, String username, String email, Set<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

}
