package com.system.mapper;
import com.system.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper
{
    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where id = #{id}")
    Student selectById(String id);

    @Select("select * from student where name = #{name}")
    Student selectByName(String name);

    @Insert("insert into student(name,id,gender,phonenumber,password,age,level) values(#{name},#{id},#{gender},#{phonenumber},#{password},#{age},#{level}")
    void insertStudent(Student student);

    @Delete("delete from student where id = #{id}")
    void deleteById(String id);

    @Delete("delete from student where name = #{name}")
    void deleteByName(String name);

    @Update("update student set phonenumber=#{phonenumber} where id = #{id}")
    void updatePhonenumberById(@Param("phonenumber")String phonenumber, @Param("id")String id);

    @Update("update student set password=#{password} where id = #{id}")
    void updatePasswordById(@Param("password")String password, @Param("id")String id);
}
