package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.File;
import az.itstep.azjava.testapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private FileService fileService;

    @GetMapping
    public List<File> getAll() {
        return fileService.getAll();
    }

    @PostMapping
    public File save(@RequestBody File file) {
        return fileService.save(file);
    }

    @PutMapping
    public File update(@RequestBody File file) {
        return fileService.update(file);
    }

    @GetMapping("/{id}")
    public File getOne(@PathVariable Integer id) {
        return fileService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fileService.delete(id);
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
