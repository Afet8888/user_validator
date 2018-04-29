package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.entities.User;
import az.itstep.azjava.testapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserServiceImpl userService;

    @PostMapping
    public User save(@RequestBody User user) {
        //***Bad practice
//        try {
            //bu metod exception ata biler
            return userService.save(user);
//        } catch (Exception ex) {
//            return null;
//        }
    }

    //***Good practice
    //Eger her hansi bir klass exception tullasa
    //bu metod cagirilacey
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException() {
        return "WRONG REQUEST!!!";
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
