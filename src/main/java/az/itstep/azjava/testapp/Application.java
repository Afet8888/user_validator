package az.itstep.azjava.testapp;


import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class Application {
    /*
        /books/page/1
        /books/page/2

    --------------------------------

        /books/getNextPage

     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /*
    POST /signin {username:..., password:...}
    RETURNING Token (JWT)

    PUT /hello {key: ...}
    RETURNING IF Authenticated -> Hello {username}
    ELSE ERROR

     */

    @Bean
    public List<User> getUsers() {
        return new ArrayList<>();
    }

    @Bean
    public List<Employee> getEmployees() {
        return new ArrayList<>();
    }

    @Bean
    public AtomicInteger idValue() {
        return new AtomicInteger(1);
    }

    @Bean
    public Map<String, User> authenticatedUsers() {
        return new HashMap<>();
    }

    /*
    Family tree

    Human {
        id, name, surname, birth date, gender, mother, father
    }

    /api/family/human
        POST - CREATE,
        PUT - UPDATE
        GET - List<Human>
        /{id} GET - Human with ID

        /{id} DELETE - delete human with ID

     1. Create service interface with CRUD
     2. Create controller with API.
     3. Create service impl
     4. Autowire service in controller


     */


}

