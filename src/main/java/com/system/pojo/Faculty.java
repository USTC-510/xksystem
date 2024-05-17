package com.system.pojo;



public class Faculty
{
    private String name;   //学院名

    public Faculty(){

    }

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}


    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}
