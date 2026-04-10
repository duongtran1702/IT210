package org.example.minipj.model;

import java.time.LocalDate;

public class Course {
    private String code;
    private String name;
    private String level;
    private Double tuitionFee;
    private String description;
    private String instructor;
    private String duration;
    private int studentCount;
    private boolean isFull;
    private LocalDate startDate;

    public Course(String code, String name, String level, Double tuitionFee, String description, String instructor, String duration, int studentCount, boolean isFull, LocalDate startDate) {
        this.code = code;
        this.name = name;
        this.level = level;
        this.tuitionFee = tuitionFee;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.studentCount = studentCount;
        this.isFull = isFull;
        this.startDate = startDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}


