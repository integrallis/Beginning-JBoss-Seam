package com.integrallis.security.business;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;

import com.integrallis.security.service.GenericPage;

//@Secure(roles = {"access"}, onfail="/failure.jsp")
//@Restrict("${true}")
@Name("normalPage")
@Stateless
public class NormalPageAction implements GenericPage {

   
    public String go() {
        System.out.println("Normal Page");
        return "normal";
    }
}
