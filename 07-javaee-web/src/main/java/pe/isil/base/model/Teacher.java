package pe.isil.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Teacher {
    private Integer id;
    private String name;
    private String lastName;
}
