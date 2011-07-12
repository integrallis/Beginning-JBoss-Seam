/*
 * Copyright (c) 2007 Integrallis Software, LLC. All rights reserved.
 */
package com.integrallis.garagesale.service;

import java.util.List;

import com.integrallis.garagesale.domain.House;

public interface BuyerManager {
    
    public List<House> searchGarageSales();
    
}
