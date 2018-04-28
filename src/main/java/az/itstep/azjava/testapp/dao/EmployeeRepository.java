package az.itstep.azjava.testapp.dao;

import az.itstep.azjava.testapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAllByDepartmentId(Integer departmentId);

}
