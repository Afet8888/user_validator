package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.Todo;
import az.itstep.azjava.testapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PostMapping
    public Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable Integer id) {
        return todoService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        todoService.delete(id);
    }

    @PutMapping("/{id}")
    public Todo switchDone(@PathVariable Integer id) {
        return todoService.switchDone(id);
    }

    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
