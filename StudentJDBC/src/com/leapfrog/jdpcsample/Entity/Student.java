/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdpcsample.Entity;

import java.util.Date;

/**
 *
 * @author milan
 */
public  class Student {
    
    private int id;
    private String studentName,majorSubject,minorSubject,teacherName;
    private int fee;
    private Date date;
    private boolean status;

    public Student() {
    }

    public Student(int id, String studentName, String majorSubject, String minorSubject, String teacherName, int fee, boolean status) {
        this.id = id;
        this.studentName = studentName;
        this.majorSubject = majorSubject;
        this.minorSubject = minorSubject;
        this.teacherName = teacherName;
        this.fee = fee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(String majorSubject) {
        this.majorSubject = majorSubject;
    }

    public String getMinorSubject() {
        return minorSubject;
    }

    public void setMinorSubject(String minorSubject) {
        this.minorSubject = minorSubject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentName=" + studentName + ", majorSubject=" + majorSubject + ", minorSubject=" + minorSubject + ", teacherName=" + teacherName + ", fee=" + fee + ", date=" + date + ", status=" + status + '}';
    }
    
    
    
    
           
          
    
    
    
    
}
