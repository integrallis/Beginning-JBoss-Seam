package com.integrallis.ajax.business;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.integrallis.ajax.domain.Person;
import com.integrallis.ajax.service.HelloWorld;

@Stateless
@Name("helloAction") 
public class HelloWorldAction implements HelloWorld {
    
    @Logger
    Log log;
    
    public String sayHelloWithPerson(Person user) {
        log.info("sayHello - person " + user);      
        return "Hello World, " + user.getFirstName() + " " + user.getLastName();
    }
    
    public String sayHelloWithName(String name) {
        log.info("sayHello - name " + name);
        return "Hello World, " + name;
    }
    
    public String sayHello() {
        log.info("sayHello - ");
        return "Hello World!";
    }
}
