package com.crud.springboot.service;

import com.crud.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(Integer TheId);
//    Employee update(Employee employee);
    void deleteById(Integer TheId);
}
