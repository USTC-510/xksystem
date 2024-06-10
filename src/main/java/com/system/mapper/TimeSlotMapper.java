package com.system.mapper;

import com.system.pojo.TimeSlot;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TimeSlotMapper {
    @Select("select * from timeslot where courseId = #{courseCode}")
    List<TimeSlot> getTimeByCourseCode(String courseCode);
}
