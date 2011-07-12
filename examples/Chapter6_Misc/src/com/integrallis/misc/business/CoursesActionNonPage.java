package com.integrallis.misc.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.misc.domain.Course;
import com.integrallis.misc.service.Courses;

@Stateless
@Name("coursesActionNonPage")
public class CoursesActionNonPage implements Courses {

    @Logger
    Log log;
    
    @Out(scope = ScopeType.SESSION, value = "courseListNonPage", required=true)
    private List<Course> courseList;

    public String createCourseList() {
        log.info("create course list - nonpage");
        courseList = new ArrayList<Course>();
        courseList.add(new Course("CS-101", "Intro to Java"));
        courseList.add(new Course("CS-201", "Programming Languages"));
        courseList.add(new Course("CS-361", "Data Structures"));
        
        return "/displayCourses.jsp";
    }
    
    /**
     * Call backs to the page.
     *
     */
    public void callBack() {
        log.info("#{courseList}");
        log.info("call back to the page");
    }
}
