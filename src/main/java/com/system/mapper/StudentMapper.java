package com.system.mapper;

import com.system.pojo.Student;

import java.util.List;

public interface StudentMapper
{
    List<Student> selectAll();
    Student selectbyId(int id);
    Student selectbyName(String name);
    void insertStudent(Student student);
}
