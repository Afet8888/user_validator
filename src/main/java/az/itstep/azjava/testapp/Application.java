package az.itstep.azjava.testapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
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

