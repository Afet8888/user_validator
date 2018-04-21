package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();
    Todo save(Todo todo);
    Todo update(Todo todo);
    Todo getOne(@PathVariable Integer id);
    void delete(@PathVariable Integer id);
    Todo switchDone(Integer id);

}
