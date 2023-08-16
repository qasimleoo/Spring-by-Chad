package com.codingislove.REST_CRUD.dao;

import com.codingislove.REST_CRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "file")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's it ... no need to write any code

}
