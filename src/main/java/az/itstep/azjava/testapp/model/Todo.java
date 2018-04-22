package az.itstep.azjava.testapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Getters and setters
 */
@Data
/**
 * JavaEE -> JPA (java persistence api)
 */
@Entity
public class Todo {
    @Id /*Primary key*/
    /*database depend*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;/*varchar(255)*/
    private String text;/*varchar(255)*/
    private Boolean isDone;
    private Date creationDate;/*timestamp  new Date()*/
}
