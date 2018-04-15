package az.itstep.azjava.testapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Human {
    private Integer id;
    private String name;
    private String surname;
    private String gender;
    private Date dateOfBirth;
    private Human mother;
    private Human father;
}
