package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
    private int dayOfWeek; // 周一到周五，用数字表示，例如1表示周一，5表示周五
    private int startTime; // 开始时间，第几节课
    private int endTime; // 结束时间，第几节课
    private String courseId;
}
