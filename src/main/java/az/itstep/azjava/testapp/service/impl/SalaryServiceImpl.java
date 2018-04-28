package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.EmployeeRepository;
import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    EmployeeRepository employeeRepository;


    @Override
    public Integer getSalariesSum() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return sumSalaries(employees);
    }

    @Override
    public Integer getSalariesSum(Integer departmentId) {
        List<Employee> departmentEmployees = employeeRepository.findAllByDepartmentId(departmentId);
        return sumSalaries(departmentEmployees);
    }

    private int sumSalaries(List<Employee> employees) {
        return employees
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
