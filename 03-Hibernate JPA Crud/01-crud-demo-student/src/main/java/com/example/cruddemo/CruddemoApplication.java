package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	Code to run via command line
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryToFindByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on it's ID
		int stdID = 6;
		System.out.println("Getting student with id : " + stdID);
		Student student = studentDAO.findById(stdID);

		// change first name to "John"
		System.out.println("Updating the student ...");
		student.setFirstName("John");

		// update the student
		studentDAO.updateStudent(student);

		// display the updated student
		System.out.println("Updated student with id " + stdID + " = " + student);
	}

	private void queryToFindByLastName(StudentDAO studentDAO) {
		// get list of students
		List<Student> temp = studentDAO.findByLastName("Ali");

		// display list of students
		for (Student student:temp) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student element:students) {
			System.out.println(element);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student obj
		System.out.println("Creating a new student object ...");
		Student student1 = new Student("Duffy", "Duck", "duffy@jfreaks.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(student1);

		// display id of student
		int theId = student1.getId();
		System.out.println("Generation id is : " + theId) ;

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with ID: ");
		Student student = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student : " + student);

	}

	private void createMultipleStudents(StudentDAO studentDAO){
		// Create student object
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Manto", "Gwen", "gwen@google.com");
		Student tempStudent2 = new Student("Julia", "Xavier", "julia@google.com");
		Student tempStudent3 = new Student("Nitra", "Rao", "rao@google.com");

		// save the object
		System.out.println("Saving the objects ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		// Create student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Qasim", "Ali", "qasim@jfreaks.com");

		// save the object
		System.out.println("Saving the object ...");
		studentDAO.save(tempStudent);

		// display id of the saved object
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
