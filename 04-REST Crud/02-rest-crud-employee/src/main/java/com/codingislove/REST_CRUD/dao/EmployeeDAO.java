package com.codingislove.REST_CRUD.dao;

import com.codingislove.REST_CRUD.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById (int theId);
    Employee save(Employee theEmployee);

    void deleteByID(int theID);
}
