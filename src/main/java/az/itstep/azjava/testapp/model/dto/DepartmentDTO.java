package az.itstep.azjava.testapp.model.dto;

import az.itstep.azjava.testapp.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {
    private Integer id;
    private String name;
    private List<Employee> employees;
}
