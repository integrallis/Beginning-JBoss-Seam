package com.integrallis.misc.business;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Name("nextPage")
public class NextPageAction {

    @In
    private String userName;
    
    @Logger
    Log log;
    
    public String contineToNextPage() {
        log.info("User name - #{userName}");
        return "/pageTwo.jsp";
    }
    
}
