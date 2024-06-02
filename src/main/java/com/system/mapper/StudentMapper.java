package com.system.mapper;

import com.system.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper
{
    List<Student> selectAll();

    List<Student> selectbyId(@Param("username")String username);

    Student selectbyName(String name);

    void insertStudent(Student student);
}
