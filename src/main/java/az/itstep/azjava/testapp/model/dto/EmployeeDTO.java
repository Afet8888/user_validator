package az.itstep.azjava.testapp.model.dto;

import az.itstep.azjava.testapp.model.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer salary;
    private String position;
    private Date dateOfBirth;
    private Department department;

}
