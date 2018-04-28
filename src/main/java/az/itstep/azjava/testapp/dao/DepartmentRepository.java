package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
