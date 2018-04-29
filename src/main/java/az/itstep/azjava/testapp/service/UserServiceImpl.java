package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.dao.UserRepository;
import az.itstep.azjava.testapp.model.entities.User;
import az.itstep.azjava.testapp.service.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserValidator userValidator;

    private UserRepository userRepository;

    public User save(User user) {
        /*
        user sehfdise -> exception
         */
        userValidator.validateUser(user);
        return userRepository.save(user);
    }


    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
