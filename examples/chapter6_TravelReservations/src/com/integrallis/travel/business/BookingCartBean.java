package com.integrallis.travel.business;

import java.util.Date;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Conversational;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.travel.domain.Booking;
import com.integrallis.travel.domain.Car;
import com.integrallis.travel.domain.CarBooked;
import com.integrallis.travel.domain.Flight;
import com.integrallis.travel.domain.FlightBooked;
import com.integrallis.travel.domain.Hotel;
import com.integrallis.travel.domain.HotelBooked;
import com.integrallis.travel.service.AirlineReservations;
import com.integrallis.travel.service.BookingCart;
import com.integrallis.travel.service.CarReservations;
import com.integrallis.travel.service.HotelReservations;

/**
 * This is our cart that is going to be maintained throughout travel
 * arrangements. 
 * 
 * This will allow one to book a return flight and departure flight
 * and hotel and car.
 * 
 * @author online
 *
 */
@Stateful
@Name("bookingCart")
@Conversational()
public class BookingCartBean implements BookingCart {

    @PersistenceContext
    EntityManager em;
    
    @In(create=true)
    private Booking booking = null;
    @In(create=true)
    private FlightBooked flightBooked;
    @In(create=true)
    private HotelBooked hotelBooked;
    @In(create=true)
    private CarBooked carBooked;
    
    @In
    @Out(scope = ScopeType.SESSION)
    Date startDate;
    
    @In
    @Out(scope = ScopeType.SESSION)
    Date endDate;
    
    @Logger
    Log log;
    
    // The following are the search beans
    // to get the selected objects
    @In(required = false, value="airlineReservations")
    AirlineReservations airlineResevations;
    
    @In(required = false)
    CarReservations carReservations;
    
    @In(required = false)
    HotelReservations hotelReservations;
    
    /**
     * Start the travel plans, this just involved initializing the travel bean.
     * 
     */
    @Begin
    public String starTravelPlans() {
        log.info("Start long running conversation for travel plans");  
        return "flights";
    }
    
    // all the interfaces to book the flight
    public String selectHotel() {
        log.info("Book Hotel");
        Hotel hotel = hotelReservations.getSelectedHotel();        
        if (booking.getHotelBooked() == null) {
            booking.setHotelBooked(hotelBooked);
            booking.getHotelBooked().setCheckInDt(startDate);
            booking.getHotelBooked().setCheckOutDt(endDate);
        }
        booking.getHotelBooked().setHotel(hotel);
        
        return "hotels";
    }
    
    public String selectReturnFlight() {
        log.info("Book Return Flight");
        Flight flight = airlineResevations.getSelectedFlight();        
        if (booking.getFlightBooked() == null) {
            booking.setFlightBooked(flightBooked);
            booking.getFlightBooked().setDepartureDt(startDate);
            booking.getFlightBooked().setReturnDt(endDate);            
        }
        booking.getFlightBooked().setReturnFlight(flight);        
        
        // it is necessary to specify a return, if not
        // then the itnerceptor will never switch pages.
        return "flights";
    }
    
    public String selectDepartureFlight() {
        log.info("Book Departure Flight");
        Flight flight = airlineResevations.getSelectedFlight();
        log.info("Flight - #{flight}");        
        if (booking.getFlightBooked() == null) {
            booking.setFlightBooked(flightBooked);
            booking.getFlightBooked().setDepartureDt(startDate);
            booking.getFlightBooked().setReturnDt(endDate);            
        }
        booking.getFlightBooked().setDepartureFlight(flight);
        
        return "flights";
    }

    public String selectCar() {
        log.info("Book Car");
        Car car = carReservations.getSelectedCar();        
        if (booking.getCarBooked() == null) {
            booking.setCarBooked(carBooked);
            booking.getCarBooked().setPickUpDt(startDate);
            booking.getCarBooked().setDropOffDt(endDate);
        }
        booking.getCarBooked().setCar(car);
        
        return "cars";
    }
    
    // get booking
    public Booking getBooking() {
        return booking;
    }
    
    /**
     * Persists our booking example.
     */
    @End
    @Remove
    public void makeReservation() {
        // TODO - persist it. There is a small error there right now
        //em.persist(booking);
    }
        
    @End
    public void cancelReservation() {
        // do nothing allow it to destroy the object
    }
    
    @Remove
    @Destroy
    public void destroy() {
        // do nothing
    }
    
}
