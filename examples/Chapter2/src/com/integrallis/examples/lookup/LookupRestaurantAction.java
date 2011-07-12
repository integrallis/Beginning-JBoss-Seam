package com.integrallis.examples.lookup;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Out;

/**
 * @author NUSAIRJ
 * 
 */
@Stateless
public class LookupRestaurantAction implements ILookupRestaurantAction {

    @In
    String zipCode;

    @Out
    String bestRestaurant;

    /*
     * (non-Javadoc)
     * 
     * @see com.integrallis.example.business.LookupResteraunt#findBestResteraunt(java.lang.String)
     */
    public String findBestResteraunt() {
        // do work here
        bestRestaurant = "Aladins in " + zipCode;

        return "success";
    }
}
