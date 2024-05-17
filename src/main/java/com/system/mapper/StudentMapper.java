package com.system.mapper;
import java.util.List;
import com.system.pojo.Student;

public interface StudentMapper
{
    List<Student> selectAll();
    Student selectbyId(int id);
    Student selectbyName(String name);
}
