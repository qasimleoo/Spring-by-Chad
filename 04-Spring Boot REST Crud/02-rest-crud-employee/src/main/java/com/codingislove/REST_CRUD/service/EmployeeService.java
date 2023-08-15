package com.codingislove.REST_CRUD.service;

import com.codingislove.REST_CRUD.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById (int theId);
    Employee save(Employee theEmployee);
    void deleteByID(int theID);
}