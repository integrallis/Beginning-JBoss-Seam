package com.integrallis.ajax.domain;


//@Name("person")
public class Person {

    private String lastName;
    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString() {
        return firstName + lastName;
    }
}

