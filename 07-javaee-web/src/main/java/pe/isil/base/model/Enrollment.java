package pe.isil.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Enrollment {
    private Integer id;
    private Integer courseId;
    private Integer studentId;
    private LocalDate createDate;
    private Integer credit;
}
