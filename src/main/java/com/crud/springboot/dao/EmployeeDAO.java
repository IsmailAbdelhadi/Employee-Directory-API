package com.crud.springboot.dao;

import com.crud.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findByID(Integer theId);
//    Employee update(Employee employee);
    void deleteById(Integer theId);
}
