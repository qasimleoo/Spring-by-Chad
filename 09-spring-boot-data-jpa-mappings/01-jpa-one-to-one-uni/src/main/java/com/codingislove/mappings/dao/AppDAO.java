package com.codingislove.mappings.dao;

import com.codingislove.mappings.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void delete(int theID);
}
