package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.TodoRepository;
import az.itstep.azjava.testapp.model.File;
import az.itstep.azjava.testapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * ITodoService
 * FileService
 *
 * FileService
 * FileServiceImpl
 */
@Service
public class FileServiceImpl implements FileService {

    private TodoRepository todoRepository;

    @Override
    public List<File> getAll() {
        return (List<File>) todoRepository.findAll();
    }

    @Override
    public File save(File file) {
        if(Objects.isNull(file)
                || Objects.nonNull(file.getId()))
            return null;

        file.setCreationDate(new Date());
        return todoRepository.save(file);
    }

    @Override
    public File update(File file) {
        if(Objects.isNull(file)
                || Objects.isNull(file.getId()))
            return null;
        Optional<File> last = todoRepository.findById(file.getId());
        if(last.isPresent()) {
            File lastFile = last.get();
            String newName = file.getName();

            if(Objects.nonNull(newName))
                lastFile.setName(newName);

            todoRepository.save(lastFile);
            return lastFile;
        }
        return null;
    }

    @Override
    public File getOne(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }

    @Autowired
    public void setTodoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}
