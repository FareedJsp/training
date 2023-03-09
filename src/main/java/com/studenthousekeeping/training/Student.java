package com.studenthousekeeping.training;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Student_FirstName")
    private String first_name;
    @Column(name = "Student_LastName")
    private String last_name;
    @Column(name = "Department")
    private String department;
    @Column(name = "Grade")
    private String grade;
    @Column(name = "DateOfBirth")
    private LocalDate date_of_birth;   

    

    public Student(String first_name, String last_name, String department, String grade, LocalDate date_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.department = department;
        this.grade = grade;
        this.date_of_birth = date_of_birth;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(date_of_birth, today).getYears();
    }
}
