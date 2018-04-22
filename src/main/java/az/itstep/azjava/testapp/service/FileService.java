package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.File;

import java.util.List;

/**
 *
 */
public interface FileService {
    List<File> getAll();
    File save(File file);
    File update(File file);
    File getOne(Integer id);
    void delete(Integer id);
}
