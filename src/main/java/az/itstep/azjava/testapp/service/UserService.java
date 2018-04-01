package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(String username);

    void saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

}
