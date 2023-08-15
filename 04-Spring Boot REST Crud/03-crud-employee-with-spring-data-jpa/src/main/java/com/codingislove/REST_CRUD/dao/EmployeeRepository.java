package com.codingislove.REST_CRUD.dao;

import com.codingislove.REST_CRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's it ... no need to write any code

}
