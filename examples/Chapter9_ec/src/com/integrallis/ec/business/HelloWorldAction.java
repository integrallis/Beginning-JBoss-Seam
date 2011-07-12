package com.integrallis.ec.business;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.ejb.SeamInterceptor;

import com.integrallis.ec.domain.Person;
import com.integrallis.ec.service.HelloWorld;

@Stateful
@Name("helloWorld")
@Interceptors(SeamInterceptor.class)
public class HelloWorldAction implements HelloWorld {

    @In(create = true)
    Person person;
    
    @Out
    String display;
    
    public String createHello() {
        System.out.println("DISPLAY HELLO WORLD!");
        display = "Hello World, " + person.getName() + "!";
        
        System.out.println(display);
        
        return "/display.jsp";
    }
    
    @Destroy
    @Remove
    public void destroy() {
        // do nothing
    }
    
}
