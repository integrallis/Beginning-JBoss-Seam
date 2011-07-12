package com.integrallis.security.business;

import org.jboss.seam.annotations.Name;

//@Secure(roles = {"admin"}, onfail="/failure.jsp")
@Name("adminPage")
public class AdminPageAction {

    public String go() {
        System.out.println("Admin Page");
        return "admin";
    }
    
}
