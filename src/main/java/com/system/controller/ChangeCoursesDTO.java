package com.system.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeCoursesDTO{
    private List<String> name;
    private List<String> spot;
    private List<String> teacher;
    private List<Integer> credit;
    private List<Integer> hour;
    private List<Integer> maxnum;
    private List<String> code;
    private List<String> time;

}
