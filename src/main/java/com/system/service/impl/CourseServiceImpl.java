package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
   @Resource
    CourseMapper courseMapper;

    public List<Course> getAllCourses()
    {
        List<Course> courses = courseMapper.selectAll();
        if (ObjectUtils.isEmpty(courses)) {return null;}
        else {return courses;}
    }

    public List<Course> getCourseByName(String name)
    {
        List<Course> courses = courseMapper.selectByName(name);
        if (ObjectUtils.isEmpty(courses)) {return null;}
        else {return courses;}
    }

    public List<Course> getCoursesByStudentId(String code)
    {
        return courseMapper.getCoursesByStudentId(code);
    }

    //选课时，时间冲突的判断
    public int ifCanCheck(String studentcode,String coursecode)
    {
        List<Course> courses=courseMapper.getCoursesByStudentId(studentcode);
        Course course=courseMapper.selectByCode(coursecode);
        String[] strArray1 = course.day.split(",");
        String[] strArray2 = course.startTime.split(",");
        String[] strArray3 = course.endTime.split(",");

        int[][] intArray = new int[3][];
        intArray[0] = new int[strArray1.length];
        intArray[1] = new int[strArray2.length];
        intArray[2] = new int[strArray3.length];

        for (int i = 0; i < strArray1.length; i++) {
            intArray[0][i] = Integer.parseInt(strArray1[i]);
        }
        for (int i = 0; i < strArray2.length; i++) {
            intArray[1][i] = Integer.parseInt(strArray2[i]);
        }
        for (int i = 0; i < strArray3.length; i++) {
            intArray[2][i] = Integer.parseInt(strArray3[i]);
        }
        //将course的时间信息分割到一个三行数组中


        for (Course selectedCourse : courses)
        {
            String[] courseDay = selectedCourse.day.split(",");
            String[] courseStartTime = selectedCourse.startTime.split(",");
            String[] courseEndTime = selectedCourse.endTime.split(",");
            int[][] courseIntArray = new int[3][];
            courseIntArray[0] = new int[courseDay.length];
            courseIntArray[1] = new int[courseStartTime.length];
            courseIntArray[2] = new int[courseEndTime.length];
            for (int i = 0; i < courseDay.length; i++) {
                courseIntArray[0][i] = Integer.parseInt(courseDay[i]);
            }
            for (int i = 0; i < courseStartTime.length; i++) {
                courseIntArray[1][i] = Integer.parseInt(courseStartTime[i]);
            }
            for (int i = 0; i < courseEndTime.length; i++) {
                courseIntArray[2][i] = Integer.parseInt(courseEndTime[i]);
            }

            boolean isValid = true;
            for (int i=0;i< intArray.length;i++)
            {
                for (int j=0;j<courseIntArray.length;j++)
                {
                    if(intArray[0][i] == courseIntArray[0][j])
                    {
                        if ((intArray[1][i]>courseIntArray[2][j])||(intArray[2][i]<courseIntArray[1][j]))
                        {
                            continue;
                        }
                        else
                        {
                            isValid=false;
                            return 0;
                        }
                    }
                }

            }
           continue;
        }
        return 1;
    }

}

