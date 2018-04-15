package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.AuthorizationService;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private Map<String, User> authenticatedUsers;

    @Autowired
    private UserService userService;

    @Override
    public String getToken(User user) {
        User search = userService.getUser(user.getUsername());
        if(Objects.nonNull(search)
                && Objects.equals(search.getPassword(), user.getPassword()))  {
            String key = UUID.randomUUID().toString();
            authenticatedUsers.put(key, search);
            return key;
        }
        return "";
    }

    @Override
    public boolean isAuthorized(String token) {
        return authenticatedUsers.containsKey(token);
    }

    @Override
    public User getAuthorizedUser(String token) {
        return authenticatedUsers.get(token);
    }
}
