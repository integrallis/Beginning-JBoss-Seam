package com.integrallis.travel.service;

import com.integrallis.travel.domain.Booking;

/**
 * This interface is used to define the car that will
 * hold your booking information.
 * 
 * @author online
 *
 */
public interface BookingCart {

    // start our booking
    String starTravelPlans();
        
    // all the interfaces to book the flight
    String selectHotel();
    String selectDepartureFlight();
    String selectReturnFlight();
    String selectCar();
    
    // get booking
    Booking getBooking();
    
    // makes the reservations
    void makeReservation();
    void cancelReservation();
    
    void destroy ();
}
