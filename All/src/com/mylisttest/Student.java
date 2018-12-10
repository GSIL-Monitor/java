package com.mylisttest;

import java.util.HashSet;
import java.util.Set;

public class Student {
    public String id;
    public String name;
    public Set<Course> coursesT;


    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.coursesT = new HashSet<Course>();



    }
}
