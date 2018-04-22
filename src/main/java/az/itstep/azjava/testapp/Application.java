package az.itstep.azjava.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ComponentScan - base package gosterir
 * @EnableAutoConfiguration
 */
@SpringBootApplication
public class Application {

    /*
    Todo {
        id
        title,
        text,
        isDone(by default false, can't create with
                        true value),
        creationDate
    }

    /todo
        GET -> List<Todo>
        POST Todo -> save to db
        PUT Todo -> Update in db (can't change isDone
                                or creationDate)
        /{id}
            GET -> Todo with id
            DELETE -> delete todo with id
            PUT -> switch isDone status

     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

