package com.system.mapper;
import com.system.pojo.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseMapper
{
    @Select("select * from course")
    List<Course> selectAll();

    //根据学号返回学生已选的所有课程
    List<Course> getCoursesByStudentId(int code);

    @Select("select * from course where name = #{name}")
    List<Course> selectByName(String name);

}
