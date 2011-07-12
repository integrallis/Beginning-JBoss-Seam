package com.integrallis.travel.service;

import java.util.List;

import com.integrallis.travel.domain.Flight;

/**
 * This will list out and find all the airline reservations.
 * 
 * @author online
 *
 */
public interface AirlineReservations {

    List<Flight> lookupFlights();
    Flight getSelectedFlight();
    
    void destroy();
}
