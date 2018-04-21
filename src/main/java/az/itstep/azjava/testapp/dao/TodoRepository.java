package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
