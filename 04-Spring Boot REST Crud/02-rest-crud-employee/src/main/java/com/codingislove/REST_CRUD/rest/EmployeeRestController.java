package com.codingislove.REST_CRUD.rest;

import com.codingislove.REST_CRUD.dao.EmployeeDAO;
import com.codingislove.REST_CRUD.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;
    // quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
