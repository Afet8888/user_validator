package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.Directory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends CrudRepository<Directory, Integer> {
}
