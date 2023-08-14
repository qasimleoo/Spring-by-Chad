package com.codingislove.REST_CRUD.rest;

import com.codingislove.REST_CRUD.entity.Employee;
import com.codingislove.REST_CRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty: inject employee dao
    // private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
            throw new RuntimeException("Employee ID not found - " + employeeId);
        return employee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){

        // also just in case they pass an id in JSON... set id to 0
        // this is to force save of new items... instead of doing an update
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if(employee == null)
            throw new RuntimeException("Employee with id " + id + " not found");

        employeeService.deleteByID(id);
        return "Deleted employee with id - " + id;
    }
}
