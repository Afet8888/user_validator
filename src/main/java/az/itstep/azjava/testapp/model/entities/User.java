package az.itstep.azjava.testapp.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "its_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

//    @JsonIgnore
    private String password;

    private String firstname;

    private String lastname;

    private String email;

    private String phoneNumber;
}
