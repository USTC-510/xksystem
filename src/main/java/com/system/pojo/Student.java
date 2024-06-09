package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student extends User {
    private int level;  //年级
    private String major; //专业
    private String faculty;//学院
}

