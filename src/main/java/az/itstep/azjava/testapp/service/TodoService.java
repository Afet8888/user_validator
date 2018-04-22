package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Todo;

import java.util.List;

/**
 *
 */
public interface TodoService {
    List<Todo> getAll();
    Todo save(Todo todo);
    Todo update(Todo todo);
    Todo getOne(Integer id);
    void delete(Integer id);
    Todo switchDone(Integer id);

}
