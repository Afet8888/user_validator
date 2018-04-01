package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.service.HelloService;
import az.itstep.azjava.testapp.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService helloService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String myFirstMethod() {
        return helloService.getMessage();
    }

    @PostMapping("/hello")
    public String mySecondMathod() {
        return "123";
    }

    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
/**
 GET /hello var: {}

 >> Status: 200, body: "Hello user"
 */