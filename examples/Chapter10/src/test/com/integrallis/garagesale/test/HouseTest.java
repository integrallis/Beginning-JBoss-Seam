package com.integrallis.garagesale.test;

import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

public class HouseTest extends SeamTest {

    @Test 
    public void testAddHouse() throws Exception 
    { 
        new FacesRequest() { 
            @Override 
            protected void processValidations() throws Exception 
            { 
                validateValue("#{house.address}", "123 Main Street"); 
                validateValue("#{house.city}", "Columbus"); 
                validateValue("#{house.state}", "OH"); 
                assert !isValidationFailure(); 
            } 
            
            @Override 
            protected void updateModelValues() throws Exception 
            { 
                setValue("#{house.address}", "123 Main Street"); 
                setValue("#{house.city}", "Columbus"); 
                setValue("#{house.state}", "OH"); 
            } 
            @Override 
            protected void invokeApplication() 
            { 
                assert invokeMethod("#{salesManager.addHouse}").equals("success"); 
            } 
            
            @Override 
            protected void renderResponse() 
            { 
                assert getValue("#{house.address}").equals("123 Main Street"); 
                assert getValue("#{house.city}").equals("Columbus"); 
                assert getValue("#{house.state}").equals("OH"); 
            } 
        }.run(); 
    }
}
