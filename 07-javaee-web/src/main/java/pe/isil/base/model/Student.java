package pe.isil.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor


public class Student {
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
