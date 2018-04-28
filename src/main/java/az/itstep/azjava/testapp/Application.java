package az.itstep.azjava.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ComponentScan - base package gosterir
 * @EnableAutoConfiguration
 */
@SpringBootApplication
public class Application {

    /*  ***DTO***
     * Employee {
     *     id, name, surname, salary, position
     *     dateOfBirth, department
     * }
     * Department {
     *     id, name, List<Employee>
     * }
     *
     *
     * /api/department (CRUD)
     *
     * /api/employee (CRUD)
     *
     * /api/salary GET -> maashlarin cemi
     * /api/salary/department/{id}/ GET
     *         -> departamentde olan ishcilerin
     *              maashlarinin cemi
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

