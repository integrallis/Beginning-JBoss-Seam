package com.integrallis.security.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jboss.seam.annotations.Name;

@Entity
@Name("user")
public class User {
    
    @Id @GeneratedValue
    private long id;
    private String username;
    private String password;
    String[] roles;
    
   
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String[] getRoles() {
        return roles;
    }
    public void setRoles(String[] roles) {
        this.roles = roles;
    }
    
    public String toString() {
        return username + "/" + password + "/" + roles;
    }
    
}
