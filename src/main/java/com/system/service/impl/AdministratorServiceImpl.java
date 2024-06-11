package com.system.service.impl;

import com.system.controller.ChangeCoursesDTO;
import com.system.mapper.AdministratorMapper;
import com.system.pojo.Course;
import com.system.pojo.TimeSlot;
import com.system.service.AdministratorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
    private AdministratorMapper administratorMapper;

    public int deleteCourses(String courses[]) {
        for (int i=0;i<courses.length;i++) {
            String code=courses[i];
            if(administratorMapper.deleteCourse(code)==1) {
                continue;
            }
            else {
                return 0;
            }
        }
        return 1;
    }


    public int addCourses(Course course) {
        administratorMapper.addCourses(course.getCode(),course.getName(),course.getCredit(),course.getHour(),course.getSpot(),course.getTeacher(),course.getMaxnum());
        return 0;
    }

    public int changeCourses(ChangeCoursesDTO changeCoursesDTO){
        int length=changeCoursesDTO.getCode().size();

        for (int i=0;i<length;i++){
            administratorMapper.changeInfoByCode(changeCoursesDTO.getCode().get(i),
                    changeCoursesDTO.getName().get(i),
                    changeCoursesDTO.getCredit().get(i),
                    changeCoursesDTO.getHour().get(i),
                    changeCoursesDTO.getSpot().get(i),
                    changeCoursesDTO.getTeacher().get(i),
                    changeCoursesDTO.getMaxnum().get(i));

            String time=changeCoursesDTO.getTime().get(i);
            List<TimeSlot> timeSlots =parseTimeSlots(time);

            administratorMapper.dropTimeInfo(changeCoursesDTO.getCode().get(i));

            for (int j=0;j<timeSlots.size();j++){
                administratorMapper.changeTimeByCode(changeCoursesDTO.getCode().get(i),timeSlots.get(i).getDayOfWeek(),timeSlots.get(i).getStartTime(),timeSlots.get(i).getEndTime());
            }
        }
        return 1;
    }
    public static List<TimeSlot> parseTimeSlots(String time) {
        List<TimeSlot> timeSlots = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w+)第(\\d+)-(\\d+)节");
        Matcher matcher = pattern.matcher(time);

        while (matcher.find()) {
            String dayOfWeekStr = matcher.group(1);
            int dayOfWeek = getDay(dayOfWeekStr);
            int startTime = Integer.parseInt(matcher.group(2));
            int endTime = Integer.parseInt(matcher.group(3));
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setDayOfWeek(dayOfWeek);
            timeSlot.setEndTime(endTime);
            timeSlot.setStartTime(startTime);
            timeSlots.add(timeSlot);
        }
        return timeSlots;
    }

    public static int getDay(String dayOfWeekStr) {
        String[] days = {"周一", "周二", "周三", "周四", "周五"};
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(dayOfWeekStr)) {
                return i+1;
            }
        }
        return 0;
    }
}

