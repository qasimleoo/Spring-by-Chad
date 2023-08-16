package com.codingislove.mappings;

import com.codingislove.mappings.dao.AppDAO;
import com.codingislove.mappings.entity.Instructor;
import com.codingislove.mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->
				// createInstructor(appDAO);
				// findInstructorById(appDAO);
				deleteInstructor(appDAO);
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Deleting instructor with id - " + id);

		appDAO.delete(id);
		System.out.println("Done!!! Deleted Instructor.");
	}

	private void findInstructorById(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding the element by id - " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor with id - " + id + " is = " + instructor);
		System.out.println("And the associated instructorDetail only: " + instructor.getInstructorDetail());
		System.out.println("Done!!!!");
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
//		Instructor instructor = new Instructor("Chad", "Darby", "chad@luv2code.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.luve2code.com/youtube", "Luv 2 Code!!");

		Instructor instructor = new Instructor("Qasim", "Ai", "qasim@jfreaks.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.jfreaks.com/youtube", "Coding Coding!!");

		// Associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		// this will save the details related to objects
		// because of CascadingType.ALL

		System.out.println("Saving the instructor ... " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!!!!");
	}

}
