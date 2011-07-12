package com.integrallis.garagesale.service;

import com.integrallis.garagesale.domain.House;

/**
 * The manager for our lists of grage and sale items.
 * 
 * @author Joseph F Nusairat
 *
 */
public interface GarageSaleManager {

    void findHomes();
    String findSaleItems();
    String deleteHouse();
    void destroy();
    
    //House getHouse();
}
