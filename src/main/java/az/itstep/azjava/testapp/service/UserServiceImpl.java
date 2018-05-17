package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.dao.UserRepository;
import az.itstep.azjava.testapp.model.entities.User;
import az.itstep.azjava.testapp.service.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl {

    private UserValidator userValidator;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserValidator userValidator, UserRepository userRepository) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    public User save(User user) {
        /*
        user sehfdise -> exception
         */
        userValidator.validateUser(user);
        if(Objects.isNull(user)
                || Objects.isNull(user.getUsername())
                || Objects.isNull(user.getPassword()))
                throw new RuntimeException("Wrong Username or Password");
                return userRepository.save(user);
    }

    public void delete(Integer id){
        if(Objects.isNull(id))throw new RuntimeException("No id entered");
        if(id<0)throw new RuntimeException("Must be bigger than -1");
        userRepository.deleteById(id);
    }

    public User findById(Integer id){
        if(Objects.isNull(id))throw new RuntimeException("No id entered");
        if(id<0)throw new RuntimeException("Must be bigger than -1");
        Optional<User> user =  userRepository.findById(id);
        if(!user.isPresent()) throw new RuntimeException("User not found");
        return user.get();
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

}
