package az.itstep.azjava.testapp.service.validators;

import az.itstep.azjava.testapp.model.entities.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserValidator {

    public void validateUser(User user) {
        if(Objects.isNull(user)
                || Objects.isNull(user.getUsername())
                || Objects.isNull(user.getPassword()))
            throw new RuntimeException("wrong username");

        validateFirstname(user.getFirstname());
        validateLastname(user.getLastname());
        validateEmail(user.getEmail());
        validatePhoneNumber(user.getPhoneNumber());
    }

    public void validateFirstname(String firstname) {
        if(Objects.isNull(firstname)) return;

        if(firstname.length() < 2)
            throw new RuntimeException("short name");

        char firstLetter = firstname.charAt(0);

        if(Character.isLowerCase(firstLetter))
            throw new RuntimeException("first letter");

        for (int i = 1; i < firstname.length(); i++) {
            char c = firstname.charAt(i);
            if(!Character.isLetter(c))
                throw new RuntimeException("only letters");

            if(!Character.isLowerCase(c))
                throw new RuntimeException("only first character");

        }
    }

    public void validateLastname(String secondname) {

    }

    public void validateEmail(String email) {

    }

    public void validatePhoneNumber(String phoneNumber) {

    }

}
