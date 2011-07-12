package com.integrallis.hib.business;

import java.util.List;

import org.hibernate.Session;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.log.Log;

import com.integrallis.hib.domain.User;
import com.integrallis.hib.service.UserManager;

@Scope(ScopeType.STATELESS)
@Name("userManager")
public class UserManagerAction implements UserManager {

    @In(create=true, value="userDatabase")
    private Session userDatabase;
    
    @In(required = false)
    User user;
    
    @DataModel
    private List<User> users;
    
    @Logger
    Log log;
    
    @Factory("users")
    @SuppressWarnings("unchecked")
    public void findUsers() {
        log.info("Find the Users");
        users = userDatabase.createQuery("From User u order by u.name").list();
    }
    
    public String saveUser() {
        log.info("Save user - #{user}");
        userDatabase.save(user);
        return "/index.jsp";
    }
}
