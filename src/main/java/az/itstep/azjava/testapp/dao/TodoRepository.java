package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<File, Integer> {
}
