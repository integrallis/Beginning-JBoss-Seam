/*
 * Copyright (c) 2007 Integrallis Software, LLC. All rights reserved.
 */
package com.integrallis.garagesale.service;

public interface SellerManager {

    String createGarageSale();
    String addSaleItem();
    void deleteSaleItem();
    
    String finish();
}
