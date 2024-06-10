package com.system.mapper;

import com.system.pojo.Course;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper
{
    @Select("select * from course")
    List<Course> selectAll();

    //根据学号返回学生已选的所有课程
    List<Course> getCoursesByStudentId(String code);

    @Select("select * from course where teacherid=#{code}")
    List<Course> getCoursesByTeacherId(String code);

    @Select("select * from course where name = #{name}")
    List<Course> selectByName(String name);

    @Select("select * from course where code = #{coursecode}")
    Course selectByCode(String coursecode);

    @Update("update course set number = number+1 where code = #{code}")
    void addNumber(String code);



}
