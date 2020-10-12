package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudents();

    public int insertStudent(Student student);
}
