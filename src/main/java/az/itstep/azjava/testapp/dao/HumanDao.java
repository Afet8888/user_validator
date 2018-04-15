package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.Human;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface HumanDao extends CrudRepository<Human, Integer> {
    List<Human> findAllByDateOfBirthAfter(Date date);
}
