package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String getMessage() {
        return "Hello, user. From service";
    }
}
