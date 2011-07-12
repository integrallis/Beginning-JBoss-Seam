package com.integrallis.garageSale.service;

import java.util.List;

import javax.ejb.Local;

import com.integrallis.garageSale.domain.House;

//@Remote
@Local
public interface IGarageSale {
    void addHouse(House h);
    void deleteHouse(long h);
    void updateHouse(House h);
    List<House> findAll();
}
