package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
