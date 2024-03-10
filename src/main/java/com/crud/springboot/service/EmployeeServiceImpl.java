package com.crud.springboot.service;

import com.crud.springboot.dao.EmployeeRepository;
import com.crud.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
       return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer TheId) {
        Optional<Employee> result = employeeRepository.findById(TheId);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not find Employee id - " + TheId);
        }
        return theEmployee;
    }



    @Transactional
    @Override
    public void deleteById(Integer TheId) {
        employeeRepository.deleteById(TheId);
    }
}
