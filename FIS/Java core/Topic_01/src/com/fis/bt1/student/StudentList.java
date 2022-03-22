package com.fis.bt1.student;

import com.fis.bt1.sortStrategy.ISortStrategy;

import java.util.ArrayList;

public class StudentList {
   private ArrayList<IStudent> students = new ArrayList<>();
   private int count;
   private ISortStrategy sortStrategy;


   public void addStudent(IStudent student){}
   public Student removeStudent(int code){return new Student();}
   public void display(){}

   public void sort(){}
   public void setSortStrategy(ISortStrategy sortStrategy){}

}
