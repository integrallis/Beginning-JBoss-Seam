package com.integrallis.travel.service;

import com.integrallis.travel.domain.Car;

public interface CarReservations {
    void lookupCars();
    Car getSelectedCar();
    
    void destroy();
}
