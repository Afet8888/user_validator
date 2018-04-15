package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.User;

public interface AuthorizationService {
    String getToken(User user);
    boolean isAuthorized(String token);
    User getAuthorizedUser(String token);
}
