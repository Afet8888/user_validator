package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.Key;
import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    private Map<String, User> authenticatedUsers;

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String signIn(@RequestBody User user) {
        User search = userService.getUser(user.getUsername());
        if(Objects.nonNull(search)
                && Objects.equals(search.getPassword(), user.getPassword()))  {
            String key = UUID.randomUUID().toString();
            authenticatedUsers.put(key, search);
            return key;
        }
        return "";
    }

    @PutMapping("/hello")
    public String sayHello(@RequestBody Key key) {
        User user = authenticatedUsers.get(key.getValue());
        if(Objects.nonNull(user)) {
            return "Hello, " + user.getUsername();
        }
        return "ERROR";
    }

}
