package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.mapper.TimeSlotMapper;
import com.system.pojo.Course;
import com.system.pojo.TimeSlot;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseMapper courseMapper;

    @Resource
    TimeSlotMapper timeSlotMapper;



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


    public void deleteConnection(String studentCode, String courseCode){
        courseMapper.deleteConnection(studentCode,courseCode);
    }


    //选课时，冲突的判断
    public int ifCanCheck(String studentCode, String courseCode) {
        List<Course> courses = courseMapper.getCoursesByStudentId(studentCode);
        Course courseToCheck = courseMapper.selectByCode(courseCode);

        if (courseToCheck.getNumber() >= courseToCheck.getMaxnum()) {
            return -2; // 选课人数已达到上限
        }

        if (!ObjectUtils.isEmpty(courses))
        {
            for (Course course : courses) {
                if (course.getName().equals(courseToCheck.getName())){
                    return -1; // 有同名课程
                }
                for (TimeSlot timeSlot1 : timeSlotMapper.getTimeByCourseCode(course.getCode())) {
                    for (TimeSlot timeSlot2 : timeSlotMapper.getTimeByCourseCode(courseToCheck.getCode())) {

                        if (timeSlot1.getDayOfWeek() == timeSlot2.getDayOfWeek()){
                            if(timeSlot1.getStartTime() > timeSlot2.getEndTime() || timeSlot1.getEndTime() < timeSlot2.getStartTime()){
                                continue;
                            }
                            else {
                                return 0;
                            }
                    }
                }
            }
        }

        courseMapper.addNumber(courseCode);
        courseMapper.connectStudentCourse(studentCode,courseCode);
        return 1; // 无时间冲突
    }


    public String connectTime(Course course){
        List<TimeSlot> timeSlot = timeSlotMapper.getTimeByCourseCode(course.getCode());
        return convertTimeSlotsToString(timeSlot);
    }
    public String convertTimeSlotsToString(List<TimeSlot> timeSlots) {
        StringBuilder result = new StringBuilder();
        for (TimeSlot timeSlot : timeSlots) {
            result.append(convertDayOfWeekToString(timeSlot.getDayOfWeek()));
            result.append("第").append(timeSlot.getStartTime()).append(",").append(timeSlot.getEndTime()).append("节");
            result.append("，");
        }
        // 删除最后一个逗号
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
    private String convertDayOfWeekToString(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                return "周一";
            case 2:
                return "周二";
            case 3:
                return "周三";
            case 4:
                return "周四";
            case 5:
                return "周五";
            default:
                return "";
        }
    }

}

