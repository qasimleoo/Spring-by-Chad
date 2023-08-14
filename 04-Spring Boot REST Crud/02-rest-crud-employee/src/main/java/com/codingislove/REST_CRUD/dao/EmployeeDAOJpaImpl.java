package com.codingislove.REST_CRUD.dao;

import com.codingislove.REST_CRUD.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee employee = entityManager.merge(theEmployee);
        // (if id == 0) then insert/save else update

        // return the results
        return employee;
    }

    @Override
    public void deleteByID(int theID) {

        // find employee ID
        Employee employee = entityManager.find(Employee.class, theID);

        // remove the remployee
        entityManager.remove(employee);
    }
}
