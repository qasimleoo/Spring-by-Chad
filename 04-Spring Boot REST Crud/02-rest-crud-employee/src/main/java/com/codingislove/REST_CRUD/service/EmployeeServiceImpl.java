package com.codingislove.REST_CRUD.service;

import com.codingislove.REST_CRUD.dao.EmployeeDAO;
import com.codingislove.REST_CRUD.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    // Constructor Injection
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteByID(int theID) {
        employeeDAO.deleteByID(theID);
    }
}
