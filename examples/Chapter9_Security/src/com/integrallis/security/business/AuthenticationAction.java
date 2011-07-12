package com.integrallis.security.business;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.Actor;
import org.jboss.seam.core.FacesMessages;

import com.integrallis.security.domain.User;

    
/**
 * This class contains the authentication information.
 * 
 * @author Joseph F Nusairat
 *
 */
@Name("authenticationAction") 
public class AuthenticationAction {
 
    @In 
    EntityManager entityManager; 
    
    @In(create = true)
    Actor actor;
    
    public boolean authenticate(String username, String password, Set<String> roles) { 
        
        try {
            // query the user
            User user =
                (User)entityManager.createQuery("Select u from User u where u.name = :name and u.password = :password")
                    .setParameter("name", username)
                    .setParameter("password", password)
                    .getSingleResult();
            
            // add the roles the user is in
            // this is for authentication purposes
            roles.add(user.getRole());
            
            // save the actor information based on the login information
            actor.setId(String.valueOf(user.getId()));
            actor.getGroupActorIds().add(user.getRole());
        } catch (NoResultException ex)  { 
            FacesMessages.instance().add("Invalid username/password"); 
            return false; 
        } 
        return true;
        
    }
}
