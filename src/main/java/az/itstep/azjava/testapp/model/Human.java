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

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Human mother;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Human father;
}
/*

DROP TABLE IF EXIST people;

CREATE TABLE people (
    id SERIAL NOT NULL PRIMARY KEY,
    name TEXT,
    surname TEXT,
    gender TEXT,
    my_custom_date_field_name TIMESTAMP,
    mother_id SERIAL,
    father_id SERIAL
);


 */