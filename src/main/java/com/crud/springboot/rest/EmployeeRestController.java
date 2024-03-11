package com.crud.springboot.rest;

import com.crud.springboot.entity.Employee;
import com.crud.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/id={emoployeeId}")
    public Employee FindById(@PathVariable int emoployeeId) {

        Employee theEmployee = employeeService.findById(emoployeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + theEmployee);
        }

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/id={emoployeeId}")
    public String deleteById(@PathVariable int emoployeeId) {
       Employee theEmployee = employeeService.findById(emoployeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + theEmployee);
        }

       employeeService.deleteById(emoployeeId);
       return "Delete employee id - " + emoployeeId;
    }
}
