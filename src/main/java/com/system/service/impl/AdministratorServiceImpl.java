package com.system.service.impl;

import com.system.controller.ChangeCoursesDTO;
import com.system.mapper.AdministratorMapper;
import com.system.pojo.TimeSlot;
import com.system.service.AdministratorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

            String[] parts = time.split("，");
            List<TimeSlot> timeSlots = new ArrayList<>();

            for (String part : parts) {
                String[] subParts = part.split("第");
                int dayOfWeek = getDayOfWeek(subParts[0]);
                String[] times = subParts[1].substring(0, subParts[1].length() - 1).split(",");
                int startTime = Integer.parseInt(times[0]);
                int endTime = Integer.parseInt(times[1]);
                timeSlots.add(new TimeSlot(dayOfWeek, startTime, endTime,changeCoursesDTO.getCode().get(i)));
            }
            administratorMapper.changeTimeByCode(changeCoursesDTO.getCode().get(i),timeSlots);

        }
        return 1;

    }
    private static int getDayOfWeek(String dayOfWeekStr) {
        switch (dayOfWeekStr) {
            case "周一":
                return 1;
            case "周二":
                return 2;
            case "周三":
                return 3;
            case "周四":
                return 4;
            case "周五":
                return 5;
            default:
                throw new IllegalArgumentException("Invalid day of week: " + dayOfWeekStr);
        }
    }

    }

