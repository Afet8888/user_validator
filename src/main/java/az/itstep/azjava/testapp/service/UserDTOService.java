package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.dao.UserRepository;
import az.itstep.azjava.testapp.model.dto.UserDTO;
import az.itstep.azjava.testapp.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDTOService {

    UserRepository userRepository;

    public UserDTO userDTO (User user) {
        return new UserDTO(user.getId()
                ,user.getUsername()
                , user.getFirstname()
                , user.getLastname()
                 , user.getPhoneNumber());
    }

    public List <UserDTO> allUserToDTO (List<User> listUsers) {
        List<User> users = (List<User>) userRepository.findAll();
        return users.parallelStream()
                .map(this::userDTO).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
