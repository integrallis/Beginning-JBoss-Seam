package com.integrallis.ajax.service;

import javax.ejb.Local;

import org.jboss.seam.annotations.WebRemote;

import com.integrallis.ajax.domain.Person;

@Local
public interface HelloWorld {
    @WebRemote
    String sayHelloWithPerson(Person user);
    
    @WebRemote
    String sayHelloWithName(String name);
        
    @WebRemote
    String sayHello();
}
