package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseMapper courseMapper;

    public List<Course> getAllCourses() {
        List<Course> courses = courseMapper.selectAll();
        if (ObjectUtils.isEmpty(courses)) {
            return null;
        } else {
            return courses;
        }
    }

    public List<Course> getCourseByName(String name) {
        List<Course> courses = courseMapper.selectByName(name);
        if (ObjectUtils.isEmpty(courses)) {
            return null;
        } else {
            return courses;
        }
    }

    public List<Course> getCoursesByStudentId(String code) {
        return courseMapper.getCoursesByStudentId(code);
    }

    //选课时，时间冲突的判断
    public int ifCanCheck(String studentcode, String coursecode) {
        List<Course> courses = courseMapper.getCoursesByStudentId(studentcode);
        Course course = courseMapper.selectByCode(coursecode);
        HashSet<String>[] sets = new HashSet[5];
        for (int i = 0; i < 5; i++) {
            sets[i] = new HashSet<>();
        }

        for (Course selectedCourse : courses) {
            String[] timeArrays = {selectedCourse.getTime_1(), selectedCourse.getTime_2(), selectedCourse.getTime_3(), selectedCourse.getTime_4(), selectedCourse.getTime_5()};
            for (int i = 0; i < 5; i++) {
                String[] strArray = timeArrays[i].split(",");
                sets[i].addAll(Arrays.asList(strArray));
            }
        }

        String[] newArrays = {course.getTime_1(), course.getTime_2(), course.getTime_3(), course.getTime_4(), course.getTime_5()};
        HashSet<String>[] newSets = new HashSet[5];
        for (int i = 0; i < 5; i++) {
            newSets[i] = new HashSet<>();
            newSets[i].addAll(Arrays.asList(newArrays[i].split(",")));
        }

        boolean hasIntersection = true;
        for (int i = 0; i < 5; i++) {
            if (sets[i].retainAll(newSets[i])) {
                hasIntersection = false;
                break;
            }
        }

        return hasIntersection ? 1 : 0;
    }

}

