package com.crud.springboot.dao;

import com.crud.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee", Employee.class);

        List<Employee> theEmployees = typedQuery.getResultList();

        return theEmployees;
    }

    @Override
    public Employee findByID(Integer TheId) {
        Employee theEmployee = entityManager.find(Employee.class, TheId);
        return theEmployee;
    }

//    @Override
//    public Employee update(Employee employee) {
//        Employee theEmployee = entityManager.merge(employee);
//        return theEmployee;
//    }

    @Override
    public void deleteById(Integer TheId) {
        Employee thEployee = entityManager.find(Employee.class, TheId);
        entityManager.remove(thEployee);
    }
}
