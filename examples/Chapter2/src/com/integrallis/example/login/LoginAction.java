/*
 * Created on Dec 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.integrallis.example.login;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Out;

/**
 * @author NUSAIRJ
 * 
 */
@Stateless
public class LoginAction implements ILoginAction {

    @In
    String username;

    @In
    String password;

    @Out(scope = ScopeType.SESSION)
    String loggedInUser;

    public String login() {
        if (username.equals("test") && password.equals("password")) {
            loggedInUser = username;
            return "success";
        } else {
            return "failed";
        }
    }

}
