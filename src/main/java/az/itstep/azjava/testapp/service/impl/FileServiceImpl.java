package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.FileRepository;
import az.itstep.azjava.testapp.model.File;
import az.itstep.azjava.testapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    @Override
    public List<File> getAll() {
        return (List<File>) fileRepository.findAll();
    }

    @Override
    public File save(File file) {
        if(Objects.isNull(file)
                || Objects.nonNull(file.getId()))
            return null;

        file.setCreationDate(new Date());
        return fileRepository.save(file);
    }

    @Override
    public File update(File file) {
        if(Objects.isNull(file)
                || Objects.isNull(file.getId()))
            return null;
        Optional<File> last = fileRepository.findById(file.getId());
        if(last.isPresent()) {
            File lastFile = last.get();
            String newName = file.getName();

            if(Objects.nonNull(newName))
                lastFile.setName(newName);

            fileRepository.save(lastFile);
            return lastFile;
        }
        return null;
    }

    @Override
    public File getOne(Integer id) {
        return fileRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        fileRepository.deleteById(id);
    }

    @Autowired
    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
}
