package com.integrallis.misc.business;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.misc.service.MultiServiceCall;
import com.integrallis.misc.service.SessionExample;

@Stateless
@Name("sessionExample")
public class SessionExampleAction implements SessionExample {

    @Out(scope = ScopeType.SESSION, required = true)
    private String userName;
    
    @Logger
    Log log;
    
    @In(create = true)
    MultiServiceCall multiServiceCall;
    
    public String login() {
        log.info("login");
        
        System.out.println("Hello 1 - " + multiServiceCall.getValue());
        multiServiceCall.callOne();
        System.out.println("Hello 2 - " + multiServiceCall.getValue());
        multiServiceCall.callTwo();
        System.out.println("Hello 3 - " + multiServiceCall.getValue());
        
        userName = "Joseph";
        return "/pageOne.jsp";
    }
}
