package com.integrallis.school.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    
    @Id
    private long studentId;
    private String studentName;
}
