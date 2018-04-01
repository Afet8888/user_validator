package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    @Override
    public List<User> getUsers() {
        User u1 = new User("admin", "admin", "admin@localhost.com");
        User u2 = new User("moder", "moder", "moder@localhost.com");
        User u3 = new User("user", "user", "user@localhost.com");
        List<User> users = new ArrayList<>(3);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }

    @Autowired
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
