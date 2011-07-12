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


/**
 * This page will display a list of courses for a person to take.
 * 
 * @author Joseph F Nusairat
 *
 */
@Name("coursesActionPage")
@Stateless
public class CoursesActionPage implements Courses {
    @Logger
    Log log;
    
    @Out(scope = ScopeType.PAGE, value = "courseListPage", required=true)
    private List<Course> courseList;
    
    public String createCourseList() {
        log.info("create course list");
        courseList = new ArrayList<Course>();
        courseList.add(new Course("CS101", "Intro to Java"));
        courseList.add(new Course("CS201", "Programming Languages"));
        courseList.add(new Course("CS361", "Data Structures"));
        
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
