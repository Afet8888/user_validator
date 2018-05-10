package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.dto.UserDTO;
import az.itstep.azjava.testapp.model.entities.User;
import az.itstep.azjava.testapp.service.UserDTOService;
import az.itstep.azjava.testapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserServiceImpl userService;
    UserDTOService userDTOService;

    @PostMapping
    public User save(@RequestBody User user) {
            return userService.save(user);
    }

    @GetMapping("/{id}")
    public UserDTO findUserById (@PathVariable Integer id) {
        User user = userService.findById(id);
        return userDTOService.userDTO(user);
    }

    @GetMapping
    public List<UserDTO> findAll () {
       List<User> users = userService.findAll();
        return userDTOService.allUserToDTO(users);
    }

   @DeleteMapping ("/{id}")
   void delete(@PathVariable Integer id) {
        userService.delete(id);
   }



//    //***Good practice
//    //Eger her hansi bir klass exception tullasa
//    //bu metod cagirilacey
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException() {
        return "Wrong user";
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired

    public void setUserDTOService(UserDTOService userDTOService) {
        this.userDTOService = userDTOService;
    }
}
