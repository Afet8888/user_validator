package az.itstep.azjava.testapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "people")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String gender;
    @Column(name = "my_custom_date_field_name")
    private Date dateOfBirth;//date_of_birth
    private Human mother;
    private Human father;
}
