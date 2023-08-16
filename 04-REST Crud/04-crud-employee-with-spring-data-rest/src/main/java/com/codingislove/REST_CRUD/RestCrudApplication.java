package com.codingislove.REST_CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// http://localhost:8080/employees
//Base path is set in .properties so
// http://localhost:8080/magic-api/employees

// Whatever you will pass in JpaRepository it will be made plural

// So to handle the complex one we can pass paths on our own using annotation
// @RepositoryRestResource(path="")

@SpringBootApplication
public class RestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudApplication.class, args);
	}

}
