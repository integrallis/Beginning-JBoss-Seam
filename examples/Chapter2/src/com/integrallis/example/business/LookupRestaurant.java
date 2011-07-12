/*
 * Created on Dec 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.integrallis.example.business;

import java.util.List;

import com.integrallis.example.domain.Restaurant;

/**
 * @author NUSAIRJ
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public interface LookupRestaurant {

    String findBestRestaurant(String zipCode);

    void saveNewBestRestaurant(String s, String zipCode);

    List findAllRestaurants();

    Restaurant find(long restId);
}
