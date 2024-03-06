package com.crud.springboot.service;

import com.crud.springboot.dao.EmployeeDAO;
import com.crud.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
       return employeeDAO.save(employee);

    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer TheId) {
        return employeeDAO.findByID(TheId);
    }

//    @Override
//    public Employee update(Employee employee) {
//        return employeeDAO.update(employee);
//    }

    @Transactional
    @Override
    public void deleteById(Integer TheId) {
        employeeDAO.deleteById(TheId);
    }
}
