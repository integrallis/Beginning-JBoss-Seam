package com.integrallis.garagesale.service;

import javax.ejb.Local;

@Local
public interface HouseManagerEdit {
    public String update();
    public void findHomes();
    public void destroy();
}
