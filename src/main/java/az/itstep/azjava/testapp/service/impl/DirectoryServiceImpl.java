package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.DirectoryRepository;
import az.itstep.azjava.testapp.dao.FileRepository;
import az.itstep.azjava.testapp.model.Directory;
import az.itstep.azjava.testapp.model.File;
import az.itstep.azjava.testapp.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    private DirectoryRepository directoryRepository;

    private FileRepository fileRepository;

    @Override
    public List<Directory> getAll() {
        return (List<Directory>) directoryRepository.findAll();
    }

    @Override
    public Directory save(Directory directory) {
        //faylar listi null ve yaxud size 0 olmalidi
        //id olmali deyil
        return directoryRepository.save(directory);
    }

    @Override
    public Directory update(Directory directory) {
        //faylarin database-de olmasini yoxlamaq,
        //olmadiqi halda faylari save etmek
        //directory id olmalidi
        return directoryRepository.save(directory);
    }

    @Override
    public Directory getOne(Integer id) {
        return directoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        directoryRepository.findById(id)
                .ifPresent(
                        d -> d.getFiles()
                                .forEach(fileRepository::delete));

        directoryRepository.deleteById(id);
    }

    @Override
    public List<File> getAllFilesFromDirectory(Integer directoryId) {
        return directoryRepository
                .findById(directoryId)
                .map(Directory::getFiles)
                .orElse(null);
    }

    @Autowired
    public void setDirectoryRepository(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Autowired
    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
}
