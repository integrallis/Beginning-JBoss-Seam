package com.integrallis.misc.business;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.RequestParameter;
import org.jboss.seam.annotations.Scope;

@Name("statelessHelloWorld")
@Scope(ScopeType.STATELESS)
public class StatelessHelloWorld {

    @RequestParameter("name")
    String userName;
    
    public String getText() {
        return "Hello World! - " + userName;
    }
}

