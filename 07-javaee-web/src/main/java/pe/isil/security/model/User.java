package pe.isil.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private boolean isActive;
    private LocalDate expirationDate;
}
