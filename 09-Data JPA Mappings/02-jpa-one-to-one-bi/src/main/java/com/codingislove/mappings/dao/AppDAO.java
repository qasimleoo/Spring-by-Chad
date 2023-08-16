package com.codingislove.mappings.dao;

import com.codingislove.mappings.entity.Instructor;
import com.codingislove.mappings.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructor(int theID);

    InstructorDetail findInstructorDetailByID(int theID);
    void deleteInstructorDetails(int theID);

}
