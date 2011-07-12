package com.integrallis.security.business;

import javax.ejb.Stateless;

import org.jboss.seam.Seam;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.core.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.AuthenticationException;
import org.jboss.seam.security.authenticator.Authenticator;

import com.integrallis.security.domain.User;
import com.integrallis.security.service.Login;

@Stateless
@Name("login")
public class LoginAction implements Login
{

    @Logger
    Log log;
    
    @In(value = "user", required = false) @Out(required = false)
    User user;

    public String login()
    {
        try
        {
            log.info("is it user - " +user);
            Authenticator.instance().authenticate(user.getUsername(), user.getPassword());
            return "main";  
        }
        catch (AuthenticationException ex)
        {
            FacesMessages.instance().add(ex.getMessage());
            return "login";
        }
    }

    public String logout()
    {
        Authenticator.instance().unauthenticateSession();
        Seam.invalidateSession();
        return "login";
    }
}
