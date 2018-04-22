package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<File, Integer> {
}
