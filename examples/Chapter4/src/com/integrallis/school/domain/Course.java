package com.integrallis.school.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private long courseId;
    private String courseName;
    
    @ManyToMany
    @JoinTable(name="COURSE_TO_STUDENT_TBL",
        joinColumns=@JoinColumn(name="courseId"),
        inverseJoinColumns=@JoinColumn(name="studentId"))
    private Collection<Student> students;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
    
    
}
