package com.integrallis.garagesale.service;

import javax.ejb.Local;

@Local
public interface SaleManager {
    public String addHouse();
    public void destroy();
}
