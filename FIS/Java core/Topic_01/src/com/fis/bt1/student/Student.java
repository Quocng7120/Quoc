package com.fis.bt1.student;

import java.util.Date;

public class Student implements Comparable<Student>{

    private int code;
    private String name;
    private Date birthDay;
    private int tuoi;

    public Student(int code, String name, Date birthDay, int tuoi) {
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.tuoi = tuoi;
    }

    public Student() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
