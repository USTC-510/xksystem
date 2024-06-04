package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Student extends User {
    private int level;  //年级
}

