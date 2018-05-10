package az.itstep.azjava.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /*
     * User {
     *  username, password, email, firstName,
     *  lastName, phoneNumber
     * }
     *
     * Check phoneNumber (AZ pattern)
     * Check firstname and lastname
     * Check email
     * Username and password NOT NULL
     *
     * Use DTO pattern
     * /api/users(CRUD)
     *
     * /api/statistics/password/length ->
     *                          userlerin arasinda
     *                          shifrenin uzunluqunun
     *                          orta qiymeti
     * /api/statistics/firstname ->
     *                          userlerin arasinda
     *                          firstname null olanlarin
     *                          fayizi
     *
     *
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

