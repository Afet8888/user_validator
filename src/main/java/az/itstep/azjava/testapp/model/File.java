package az.itstep.azjava.testapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long size;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name="directory_id")
    private Directory directory;


//    private Integer directoryId;//directory_id
}
