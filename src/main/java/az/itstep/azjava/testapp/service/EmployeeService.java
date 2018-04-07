package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.model.User;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(Integer id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee updateEmployee(Employee employee);

}
