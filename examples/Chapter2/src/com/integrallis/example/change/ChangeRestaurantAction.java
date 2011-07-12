package com.integrallis.example.change;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Out;

/**
 * @author NUSAIRJ
 * 
 */
public class ChangeRestaurantAction {
    
    @In
    String zipCode;

    @In(required = false)
    @Out
    String bestRestaurant;

    /*
     * (non-Javadoc)
     * 
     * @see com.integrallis.example.business.LookupResteraunt#findBestResteraunt(java.lang.String)
     */
    public String findBestRestaurant() {
        // do work here
        String bestResteraunt = "Aladins in " + zipCode;

        return "success";
    }

    public String saveBestRestaurant() {
        // save resteraunt code using bestResteraunt variable
        return "completePage";
    }
}
