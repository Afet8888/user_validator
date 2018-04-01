package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
