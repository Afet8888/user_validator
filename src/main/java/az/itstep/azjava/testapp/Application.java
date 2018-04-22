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
    File {
        id, name, size, creationDate
    }
    Directory {
        id, name, List<File>
    }
    CRUD
    GET /api/directories/{id}/files ->
                    List<File> from directory with ID = {id}

    List<File> getFilesFromDirectory(Integer directoryId)


     */
    //https://spring.io/blog/2015/06/08/cors-support-in-spring-framework
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

