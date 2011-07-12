package com.integrallis.ec.domain;

import javax.interceptor.Interceptors;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.ejb.SeamInterceptor;

@Name("person")
@Interceptors(SeamInterceptor.class)
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
}
