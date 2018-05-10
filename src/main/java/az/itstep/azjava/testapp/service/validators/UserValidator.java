package az.itstep.azjava.testapp.service.validators;

import az.itstep.azjava.testapp.model.entities.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserValidator {

    public void validateUser(User user) {
        if (Objects.isNull(user)
                || Objects.isNull(user.getUsername())
                || Objects.isNull(user.getPassword()))
            throw new RuntimeException("wrong username");

        validateName(user.getFirstname());
        validateName(user.getLastname());
        validateEmail(user.getEmail());
        validatePhoneNumber(user.getPhoneNumber());
    }

    public void validateName(String name) {
        if (Objects.isNull(name)) return;

        if(!name.matches("[A-ZА-Я]{1}[a-zа-я]+"))
            throw new RuntimeException("Wrong firstname or lastname");
    }


    public void validateEmail(String email) {
        if (Objects.isNull(email)) return;

        if (!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            throw new RuntimeException("Wrong E-mail");
        }
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (Objects.isNull(phoneNumber)) return;
        if (!phoneNumber.matches("[+]?994[0517]{2}[0-9]{7}")) {
            throw new RuntimeException("Wrong number");
        }
    }
}

