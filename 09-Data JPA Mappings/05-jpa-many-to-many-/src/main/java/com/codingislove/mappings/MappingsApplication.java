package com.codingislove.mappings;

import com.codingislove.mappings.dao.AppDAO;
import com.codingislove.mappings.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
				// deleteInstructor(appDAO);
				// findInstructorDetailById(appDAO);
				// deleteInstructorDetail(appDAO);
				// createInstructorWithCourses(appDAO);
				// findInstructorWithCourses(appDAO);
				// findCoursesForInstructor(appDAO);
				// findInstructorWithCoursesJoinFetch(appDAO);
				// updateInstructor(appDAO);
				// updateCourse(appDAO);
				// deleteInstructor(appDAO);
				// deleteCourse(appDAO);
				// createCourseAndReviews(appDAO);
				// retrieveCourseAndReviews(appDAO);
				// deleteCourseAndReviews(appDAO);
				// createStudentAndCourses(appDAO);
				// findStudentsAndCourseByCourseId(appDAO);
				// findStudentsAndCourseByStudentId(appDAO);
				// addMoreCoursesForStudent(appDAO);
				// deleteCourse(appDAO);
				deleteStudent(appDAO);
	}

	private void deleteStudent(AppDAO appDAO) {

		int id = 1;

		System.out.println("Deleting the student with id - " + id);
		appDAO.deleteStudentById(id);
		System.out.println("Done!!!!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 1;

		Student student = appDAO.findStudentAndCourseByStudentId(theId);

		// create more courses
		Course course1 = new Course("Physics");
		Course course2 = new Course("Maths");
		Course course3 = new Course("Astronomy");
		Course course4 = new Course("Biology");

		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);
		student.addCourse(course4);

		System.out.println("Updating courses for student - " + student);
		System.out.println("Updated courses are - " + student.getCourses());

		appDAO.updateStudent(student);

		System.out.println("Done!!!");
	}

	private void findStudentsAndCourseByStudentId(AppDAO appDAO) {

		int id = 1;

		Student student = appDAO.findStudentAndCourseByStudentId(id);

		System.out.println("Loaded student is : " + student);
		System.out.println("Courses are : " + student.getCourses());

		System.out.println("Done!!!");
	}

	private void findStudentsAndCourseByCourseId(AppDAO appDAO) {

		int id = 10;

		Course course = appDAO.findStudentAndCourseByCourseId(id);

		System.out.println("Loaded course is : " + course);
		System.out.println("Students are : " + course.getStudents());

		System.out.println("Done!!!");
	}

	private void createStudentAndCourses(AppDAO appDAO) {

		// Create a course
		Course course = new Course("English");

		// Create the students
		Student student1 = new Student("Qasim", "Ali", "qasim@jfreaks.com");
		Student student2 = new Student("Imran", "Babar", "imran@jfreaks.com");
		Student student3 = new Student("Umar", "Farooq", "uamr@jfreaks.com");
		Student student4 = new Student("Hanan", "Ahmad", "hani@jfreaks.com");

		// add students to the course
		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);
		course.addStudent(student4);

		// save the course and associated students
		System.out.println("Saving the course : " + course);
		System.out.println("Saving the students : " + course.getStudents());

		appDAO.saveCourse(course);

		System.out.println("Done!!!!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		System.out.println("Deleting the course and it's reviews too.");

		appDAO.deleteCourseById(id);
		System.out.println("Done!!!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get course and reviews
		int id = 10;
		Course course = appDAO.findCourseAndAddReviewById(id);

		// print the courses
		System.out.println("Course : "  +course);

		// Printing the reviews
		System.out.println("Reviews : " + course.getReviews());
		System.out.println("Done!!!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course course = new Course("Object Oriented Programming");

		// add reviews
		Review review1 = new Review("Loved this course. Amazing one!!");
		Review review2 = new Review("Nah man didn't liked it. Still It's useful!!");
		Review review3 = new Review("Keep it up bruh...");
		course.addReview(review1);
		course.addReview(review2);
		course.addReview(review3);

		// save course
		System.out.println("Saving the course : " + course);
		appDAO.saveCourse(course);

		System.out.println("Done!!!!!");
	}

	private void deleteCourse(AppDAO appDAO) {

		// Set initial id
		int id = 12;

		System.out.println("Deleting course with id - " + id);

		appDAO.deleteCourseById(id);
		System.out.println("Done!!! Course has been deleted...");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding Course with id : " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Update the course with id : " + id);
		course.setTitle("Software Engineering");

		appDAO.updateCourse(course);

		System.out.println("Done!!!! Updated the course.");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor with id : " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);

		System.out.println("Update the Instructor with id : " + theId);
		instructor.setFirstName("Tester");

		appDAO.updateInstructor(instructor);

		System.out.println("Done!!!! Updated the instructor.");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor id : " + theId);
		Instructor instructor = appDAO.findInstructorByJoinFetch(theId);

		System.out.println("Instructor : " + instructor);
		System.out.println("Details of Instructor : " + instructor.getInstructorDetail());
		System.out.println("Courses : " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id - " + theId);

		Instructor instructor = appDAO.findInstructorById(theId);

		// print instructor
		System.out.println("Instructor = "+ instructor);

		// find the Courses using Instructor Id
		System.out.println("Finding the course for id : " + theId);

		List<Course> courses = appDAO.findCoursesByInstructorID(theId);

		// associate the objects
		instructor.setCourses(courses);
		System.out.println("The associated courses are : " + instructor.getCourses());

		System.out.println("Done!!!!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 1;
		System.out.println("Finding instructor id - " + theId);

		Instructor instructor = appDAO.findInstructorById(theId);

		// print instructor
		System.out.println("Instructor = "+ instructor);

		// print the associated instructor details
		System.out.println("The Associated instructor details are : " + instructor.getInstructorDetail());

		// print the related courses
		System.out.println("The Associated courses are : " + instructor.getCourses());

		System.out.println("Done!!!!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Susan", "Public", "suan@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.susan.com/freaks", "Video Gamer!!!");

		// Associate the objects
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Programming Fundamental");
		Course course2 = new Course("Data Structures and Algo");
		Course course3 = new Course("Operating Systems");

		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		// save the instructor
		// this will save the details related to objects
		// because of CascadingType.ALL

		System.out.println("Saving the instructor ... " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!!!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting details with id - " + id);

		appDAO.deleteInstructorDetails(id);
		System.out.println("Done!!!! Deleted details of instructor.");
	}

	private void findInstructorDetailById(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 3;
		System.out.println("Finding the details with id - " + theId);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailByID(theId);

		// print instructor detail
		System.out.println("InstructorDetail = "+ instructorDetail);

		// print the associated instructor
		System.out.println("The Associated instructor is : " + instructorDetail.getInstructor());
		System.out.println("Done!!!!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Deleting instructor with id - " + id);

//		appDAO.deleteInstructor(id);
		appDAO.deleteInstructorById(id); // for courses
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

//		Instructor instructor = new Instructor("Qasim", "Ai", "qasim@jfreaks.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.jfreaks.com/youtube", "Coding Coding!!");

//		Instructor instructor = new Instructor("Nimra", "Sohail", "nam@jfreaks.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.nimra.com/youtube", "Nimra's art book!!");

		Instructor instructor = new Instructor("Iqra", "Baloch", "baloch@jfreaks.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.balochis.com/freaks", "Travelling!!!");

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
