package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher extends User
{
    private String major;//研究方向
    private String faculty;//学院
}
