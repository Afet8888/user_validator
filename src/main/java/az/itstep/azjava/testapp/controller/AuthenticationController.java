package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.User;
import az.itstep.azjava.testapp.service.AuthorizationService;
import az.itstep.azjava.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    AuthorizationService authorizationService;


    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        return ResponseEntity.ok(authorizationService.getToken(user));
    }

    @PutMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestHeader HttpHeaders httpHeaders) {
        String key = "";
        List<String> token = httpHeaders.get("token");
        if(token != null && token.size() > 0) {
            key = token.get(0);
        }
        User user = authorizationService.getAuthorizedUser(key);
        if(Objects.nonNull(user)) {
            String res = "Hello, " + user.getUsername();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(res);//200 OK other style
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();//HTTP STATUS 401
    }
}