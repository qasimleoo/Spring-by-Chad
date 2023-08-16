package com.codingislove.REST_CRUD.service;

import com.codingislove.REST_CRUD.dao.EmployeeRepository;
import com.codingislove.REST_CRUD.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    // Constructor Injection
    @Autowired
    public EmployeeServiceImpl (EmployeeRepository theEmployeeRespository){
        employeeRepository = theEmployeeRespository;
    }
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find the id - " + theId);
        }
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteByID(int theID) {
        employeeRepository.deleteById(theID);
    }
}
