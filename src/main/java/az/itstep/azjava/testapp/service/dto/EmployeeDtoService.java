package az.itstep.azjava.testapp.service.dto;

import az.itstep.azjava.testapp.dao.DepartmentRepository;
import az.itstep.azjava.testapp.model.Department;
import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeDtoService {

    private DepartmentRepository departmentRepository;

    public EmployeeDTO convertToDto(Employee employee) {
        if(Objects.isNull(employee))
            return null;

        Department department = departmentRepository.
                            findById(employee.getDepartmentId())
                            .orElse(null);

        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .dateOfBirth(employee.getDateOfBirth())
                .position(employee.getPosition())
                .salary(employee.getSalary())
                .department(department)
                .build();

    }

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
