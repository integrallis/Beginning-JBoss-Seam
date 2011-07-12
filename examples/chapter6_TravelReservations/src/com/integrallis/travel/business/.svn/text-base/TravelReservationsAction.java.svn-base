package com.integrallis.travel.business;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Conversational;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.integrallis.travel.service.BookingCart;
import com.integrallis.travel.service.TravelReservations;

@Stateless
@Name("travelReservations")
@Conversational(ifNotBegunOutcome="main")
public class TravelReservationsAction implements TravelReservations {

    @In(create=true, value="bookingCart")
    BookingCart cart;
    
    @Begin
    public String startTravelPlanning() {
        // forward ot the flights page
        return "flights";
    }

    @End
    public String checkout() {
        cart.makeReservation();
        return null;
    }

}
