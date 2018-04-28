package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Department;
import az.itstep.azjava.testapp.model.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    Department update(Department department);
    void delete(Integer id);
    DepartmentDTO findById(Integer id);
    List<DepartmentDTO> findAll();
}
