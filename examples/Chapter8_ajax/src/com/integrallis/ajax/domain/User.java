package com.integrallis.ajax.domain;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

@Name("user")
public class User {

    private String name;
    private String password;
    
    @NotNull
    @Length(min=5, max=15)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @NotNull
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
