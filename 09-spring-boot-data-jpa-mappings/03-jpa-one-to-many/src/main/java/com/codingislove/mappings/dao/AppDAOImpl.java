package com.codingislove.mappings.dao;

import com.codingislove.mappings.entity.Course;
import com.codingislove.mappings.entity.Instructor;
import com.codingislove.mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for the entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Save/Persist method
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructor(int theID) {

        // retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, theID);

        // delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailByID(int theID) {
        return entityManager.find(InstructorDetail.class, theID);
    }

    @Override
    @Transactional
    public void deleteInstructorDetails(int theID) {

        // Retrieve the instructor
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theID);

        // to detach from instructor (for deleting details only purpose)
        instructorDetail.getInstructor().setInstructorDetail(null);

        // delete those details
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorID(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );

        // Set Param
        query.setParameter("data", theId);

        // execute the query
        List<Course> courses = query.getResultList();
        return courses;
    }
}
