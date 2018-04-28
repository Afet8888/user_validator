package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Department;
import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.model.dto.DepartmentDTO;
import az.itstep.azjava.testapp.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(Integer id);
    EmployeeDTO findById(Integer id);
    List<EmployeeDTO> findAll();
}
