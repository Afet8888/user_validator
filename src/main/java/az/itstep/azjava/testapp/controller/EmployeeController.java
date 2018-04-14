package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.Employee;
import az.itstep.azjava.testapp.service.EmployeeService;
import az.itstep.azjava.testapp.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *   /employee
 *       GET -> list<employee>
 *       POST employee -> saved employee with generated ID
 *       PUT employee -> updated employee
 *
 *       /{id}
 *           DELETE -> delete employee with ID == {id}
 *           GET -> get employee with ID == {id}
 *
 */
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}


/*
HTTP/2
PUT
/employee
BODY: ""
 */
