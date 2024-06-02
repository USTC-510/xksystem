package com.system.mapper;

import com.system.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper
{
    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where id = #{id}")
    List<Student> selectbyId(int id);

    @Select("select * from student where name = #{name}")
    List<Student> selectbyName(String name);

    @Insert("insert into student(name,id,gender,password,phonenumber,age,level) values(#{name},#{id},#{gender},#{password},#{phonenumber},#{age},#{level})")
    void insertStudent(Student student);

    @Delete("delete from student where id = #{id}")
    void deleteStudentById(String id);

    @Delete("delete from student where name = #{name}")
    void deleteStudentByName(String name);
}
