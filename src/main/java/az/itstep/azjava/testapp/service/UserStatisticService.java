package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.dao.UserRepository;
import az.itstep.azjava.testapp.model.entities.User;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserStatisticService {

    private final UserRepository userRepository;

    public Integer midLength(){
        List<User> userList = (List<User>) userRepository.findAll();
        return userList.parallelStream()
                .map(User::getPassword)
                .mapToInt(String::length)
                .sum()/userList.size();
    }

    public double percentOfFirstnameNulls() {
        List<User> userList = (List<User>) userRepository.findAll();
        int nullCount = (int) userList.parallelStream()
                .map(User::getFirstname)
                .filter(Objects::isNull)
                .count();

        int size = userList.size();

        return (double)nullCount / (double) size;
    }


    @Autowired
    public UserStatisticService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
