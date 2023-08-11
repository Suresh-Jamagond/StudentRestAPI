package com.school.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @Column(name="Student_ID")
    private int studentId;

    @Column(name="Student_Name")
    private String studentName;

    @Column(name="Student_Class")
    private String studentClass;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Student() {
    }
    public Student(int studentId, String studentName, String studentClass) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }
}
