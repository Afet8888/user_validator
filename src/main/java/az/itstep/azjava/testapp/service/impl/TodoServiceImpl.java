package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.TodoRepository;
import az.itstep.azjava.testapp.model.Todo;
import az.itstep.azjava.testapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        if(Objects.isNull(todo)
                || Objects.nonNull(todo.getId()))
            return null;

        todo.setDone(false);
        todo.setCreationDate(new Date());
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        if(Objects.isNull(todo)
                || Objects.isNull(todo.getId()))
            return null;
        Optional<Todo> last = todoRepository.findById(todo.getId());
        if(last.isPresent()) {
            Todo lastTodo = last.get();

            String newTitle = todo.getTitle();
            String newText = todo.getText();

            if(Objects.nonNull(newTitle)) {
                lastTodo.setTitle(newTitle);
            }

            if(Objects.nonNull(newText)) {
                lastTodo.setText(newText);
            }

            todoRepository.save(lastTodo);
            return lastTodo;
        }
        return null;
    }

    @Override
    public Todo getOne(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo switchDone(Integer id) {
        Optional<Todo> todoOpt = todoRepository.findById(id);
        if(todoOpt.isPresent()) {
            Todo todo = todoOpt.get();
            boolean isDone = todo.isDone();
            todo.setDone(!isDone);
            todoRepository.save(todo);
            return todo;
        }
        return null;
    }

    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}
