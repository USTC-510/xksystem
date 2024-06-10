package com.system.mapper;

import com.system.pojo.TimeSlot;

import java.util.List;

public interface TimeSlotMapper {
    @Select("select * from timeslot where courseId=#{courseCode}")
    List<TimeSlot> getTimeByCourseCode(String courseCode);
}
