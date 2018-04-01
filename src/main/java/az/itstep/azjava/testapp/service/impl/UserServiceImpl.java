package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String username) {
        return users.stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveUser(User user) {
        if(checkExist(user.getUsername()))
            return;

        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.removeIf(u ->
                Objects.equals(user.getUsername(), u.getUsername())
                && Objects.equals(user.getPassword(), u.getPassword())
                && Objects.equals(user.getEmail(), u.getEmail())
        );
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if(Objects.equals(user.getUsername(), u.getUsername())) {
                u.setPassword(user.getPassword());
                u.setEmail(user.getEmail());
            }
        }
    }

    /**
     * True if username exists in list of users
     * Else false
     *
     * @param username
     * @return exist or not
     */
    private boolean checkExist(String username) {
//        for (User user : users) {
//            if(Objects.equals(username, user.getUsername())) {
//                return true;
//            }
//        }
//        return false;


        return users
                .stream()
                .anyMatch(u -> Objects.equals(username, u.getUsername()));
    }

    @Autowired
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
