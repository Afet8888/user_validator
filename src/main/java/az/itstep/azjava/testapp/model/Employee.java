package az.itstep.azjava.testapp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String department;
}
