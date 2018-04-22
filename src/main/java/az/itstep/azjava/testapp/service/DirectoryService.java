package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Directory;
import az.itstep.azjava.testapp.model.File;

import java.util.List;

public interface DirectoryService {
    List<Directory> getAll();
    Directory save(Directory directory);
    Directory update(Directory directory);
    Directory getOne(Integer id);
    void delete(Integer id);
    List<File> getAllFilesFromDirectory(Integer directoryId);
}
