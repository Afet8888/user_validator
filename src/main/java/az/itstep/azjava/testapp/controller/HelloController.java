package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String myFirstMethod() {
        return helloService.getMessage();
    }
}
