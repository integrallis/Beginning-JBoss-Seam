package com.integrallis.garagesale.service;

import javax.ejb.Local;

@Local
public interface HouseManager {
    public void findHomes();
    public void destroy();
}