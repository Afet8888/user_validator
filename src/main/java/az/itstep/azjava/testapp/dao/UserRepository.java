package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
}
