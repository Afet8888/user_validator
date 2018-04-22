package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.Directory;
import az.itstep.azjava.testapp.model.File;
import az.itstep.azjava.testapp.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/directories")
public class DirectoryController {
    private DirectoryService directoryService;

    @GetMapping
    public List<Directory> getAll() {
        return directoryService.getAll();
    }

    @PostMapping
    public Directory save(@RequestBody Directory directory) {
        return directoryService.save(directory);
    }

    @PutMapping
    public Directory update(@RequestBody Directory directory) {
        return directoryService.update(directory);
    }

    @GetMapping("/{id}")
    public Directory getOne(@PathVariable Integer id) {
        return directoryService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        directoryService.delete(id);
    }

    @GetMapping("/{id}/files")
    public List<File> getFiles(@PathVariable Integer id) {
        return directoryService.getAllFilesFromDirectory(id);
    }

    @Autowired
    public void setDirectoryService(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }
}
