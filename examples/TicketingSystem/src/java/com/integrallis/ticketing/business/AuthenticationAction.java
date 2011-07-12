package com.integrallis.ticketing.business;

import static org.jboss.seam.ScopeType.SESSION;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.jboss.seam.Seam;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.core.Actor;
import org.jboss.seam.security.Identity;

import com.integrallis.ticketing.domain.User;
    
/**
 * This class contains the authentication information.
 * 
 * @author Joseph F Nusairat
 *
 */
@Name("authenticationAction") 
public class AuthenticationAction {
 
    private final String LOGGED_IN_ROLE = "logged-in";
    
    @In 
    EntityManager entityManager; 
    
    @In(create = true)
    Actor actor;
    
    @Out(required = false, scope = SESSION)
    User authUser;
    
    @In
    private Identity identity;
    
    public boolean authenticate() { 
        
        try {
            // query the user
            User user =
                (User)entityManager.createQuery("Select u from User u where u.name = :name and u.password = :password")
                    .setParameter("name", identity.getUsername())
                    .setParameter("password", identity.getPassword())
                    .getSingleResult();
            
            // add the roles the user is in
            // this is for authentication purposes
            identity.addRole(user.getRole());
            
            // save the actor information based on the login information
            actor.setId(String.valueOf(user.getUserId()));
            actor.getGroupActorIds().add(user.getRole());
            // add a generic logged in role
            actor.getGroupActorIds().add(LOGGED_IN_ROLE);
            
            // set our authenticated user
            authUser = user;
        } catch (NoResultException ex)  { 
            return false; 
        }         
        return true;        
    }
    
    public String logout() {
        // first log out of the identity
        identity.logout();
        
        // then invalidate the session to clean anything upp
        Seam.invalidateSession();
        
        // return back to login papge
        return "/login.xhtml";
    }
}
