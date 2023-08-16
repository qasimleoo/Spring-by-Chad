package com.codingislove.mappings.dao;

import com.codingislove.mappings.entity.Course;
import com.codingislove.mappings.entity.Instructor;
import com.codingislove.mappings.entity.InstructorDetail;
import com.codingislove.mappings.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructor(int theID);

    InstructorDetail findInstructorDetailByID(int theID);
    void deleteInstructorDetails(int theID);

    List<Course> findCoursesByInstructorID(int theId);

    Instructor findInstructorByJoinFetch(int theId);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int theId);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);

    void saveCourse(Course course);

    Course findCourseAndAddReviewById(int id);

    Course findStudentAndCourseByCourseId(int theId);

    Student findStudentAndCourseByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudentById(int id);
}
