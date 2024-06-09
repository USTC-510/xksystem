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

}
