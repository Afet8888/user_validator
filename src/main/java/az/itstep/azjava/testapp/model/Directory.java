package az.itstep.azjava.testapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "directory")
    private List<File> files;
}
