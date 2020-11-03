package com.thoughtworks.capability.gtb.entrancequiz.dto;

//TODO GTB-知识点: * 了解下Lombok
public class Student {
    //TODO GTB-工程实践: - Student.java:4 已经属于Student了，那么变量可以直接命名为name，无需加前缀
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
