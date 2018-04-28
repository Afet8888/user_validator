package az.itstep.azjava.testapp.service.dto;

import az.itstep.azjava.testapp.dao.EmployeeRepository;
import az.itstep.azjava.testapp.model.Department;
import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.model.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentDtoService {

    private EmployeeRepository employeeRepository;

    public DepartmentDTO convertToDto(Department department) {
        if(Objects.isNull(department))
            return null;
        List<Employee> employees = employeeRepository.findAllByDepartmentId(department.getId());
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .employees(employees)
                .build();
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
