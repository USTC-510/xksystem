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
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        HashSet<String> set3 = new HashSet<>();
        HashSet<String> set4 = new HashSet<>();
        HashSet<String> set5 = new HashSet<>();
        for (Course selectedCourse : courses) {
            String Monday = selectedCourse.getTime_1();
            String Tuesday = selectedCourse.getTime_2();
            String Wednesday = selectedCourse.getTime_3();
            String Thursday = selectedCourse.getTime_4();
            String Friday = selectedCourse.getTime_5();

            String[] strArray1 = Monday.split(",");
            String[] strArray2 = Tuesday.split(",");
            String[] strArray3 = Wednesday.split(",");
            String[] strArray4 = Thursday.split(",");
            String[] strArray5 = Friday.split(",");

            set1.addAll(Arrays.asList(strArray1));
            set2.addAll(Arrays.asList(strArray2));
            set3.addAll(Arrays.asList(strArray3));
            set4.addAll(Arrays.asList(strArray4));
            set5.addAll(Arrays.asList(strArray5));

        }
        String day1 = course.getTime_1();
        String day2 = course.getTime_2();
        String day3 = course.getTime_3();
        String day4 = course.getTime_4();
        String day5 = course.getTime_5();

        String[] newArray1 = day1.split(",");
        String[] newArray2 = day2.split(",");
        String[] newArray3 = day3.split(",");
        String[] newArray4 = day4.split(",");
        String[] newArray5 = day5.split(",");


        HashSet<String> newSet1 = new HashSet<>();
        HashSet<String> newSet2 = new HashSet<>();
        HashSet<String> newSet3 = new HashSet<>();
        HashSet<String> newSet4 = new HashSet<>();
        HashSet<String> newSet5 = new HashSet<>();

        newSet1.addAll(Arrays.asList(newArray1));
        newSet2.addAll(Arrays.asList(newArray2));
        newSet3.addAll(Arrays.asList(newArray3));
        newSet4.addAll(Arrays.asList(newArray4));
        newSet5.addAll(Arrays.asList(newArray5));

        boolean hasIntersection1 = set1.retainAll(newSet1);
        boolean hasIntersection2 = set2.retainAll(newSet2);
        boolean hasIntersection3 = set3.retainAll(newSet3);
        boolean hasIntersection4 = set4.retainAll(newSet4);
        boolean hasIntersection5 = set5.retainAll(newSet5);

        if (hasIntersection1 == false && hasIntersection2 == false && hasIntersection3 == false && hasIntersection4 == false && hasIntersection5 == false) {
            return 1;
        } else {
            return 0;
        }
    }

}

