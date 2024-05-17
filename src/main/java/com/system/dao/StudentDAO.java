package com.system.dao;
import com.system.pojo.Student;
import system.pojo.*;
public interface StudentDAO
{
    Student getStudentbyId(int id);     //通过id查找学生
    Student getStudentbyName(String name);   //通过名字查找学生
    void updateId(Student student);    //修改某学生的id
    void updateName(Student student);
    void updateGender(Student student);
    void updateFaculty(Student student);
    void updateCourse(Student student);
    void updatePassword(Student student);
    void updatePhonenumber(Student student);
    void insertStudent(Student student);   //增加学生
    void deleteStudent(Student student);   //删除学生
}
