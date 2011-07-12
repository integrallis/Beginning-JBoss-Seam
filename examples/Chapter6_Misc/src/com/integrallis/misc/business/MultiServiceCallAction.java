package com.integrallis.misc.business;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;

import com.integrallis.misc.service.MultiServiceCall;

@Stateless
@Name("multiServiceCall")
public class MultiServiceCallAction implements MultiServiceCall {

    private String value = "Value ";
    
    public void callOne() {
        value += "One ";
    }

    public void callTwo() {
        value += "Two ";
    }

    public String getValue() {
        return value;
    }

}
