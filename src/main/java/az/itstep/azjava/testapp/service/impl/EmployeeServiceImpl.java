package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.EmployeeRepository;
import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.model.dto.EmployeeDTO;
import az.itstep.azjava.testapp.service.EmployeeService;
import az.itstep.azjava.testapp.service.dto.EmployeeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDtoService employeeDtoService;

    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(Objects.isNull(employee)
                || Objects.nonNull(employee.getId()))
            return null;
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        if(Objects.isNull(employee)
                || Objects.isNull(employee.getId()))
            return null;
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        return employeeRepository
                .findById(id)
                .map(employeeDtoService::convertToDto)
                .orElse(null);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return employees
                .stream()
                .map(employeeDtoService::convertToDto)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setEmployeeDtoService(EmployeeDtoService employeeDtoService) {
        this.employeeDtoService = employeeDtoService;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
