package com.integrallis.travel.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.jboss.seam.annotations.Name;

@Entity
@Name("booking")
public class Booking {

    @Id @GeneratedValue
    private long bookingId;
    private String name;
    private String email;
    
    @OneToOne()
    @JoinColumn(name="flightBookedId")
    private FlightBooked flightBooked;
    @OneToOne()
    @JoinColumn(name="carBookedId")
    private CarBooked carBooked;
    @OneToOne()
    @JoinColumn(name="hotelBookedId")
    private HotelBooked hotelBooked;
    
    public long getBookingId() {
        return bookingId;
    }
    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }
    public CarBooked getCarBooked() {
        return carBooked;
    }
    public void setCarBooked(CarBooked carBooked) {
        this.carBooked = carBooked;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public FlightBooked getFlightBooked() {
        return flightBooked;
    }
    public void setFlightBooked(FlightBooked flightBooked) {
        this.flightBooked = flightBooked;
    }
    public HotelBooked getHotelBooked() {
        return hotelBooked;
    }
    public void setHotelBooked(HotelBooked hotelBooked) {
        this.hotelBooked = hotelBooked;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Add up all the flights of the different sections together.
     * 
     * @return
     */
    @Transient
    public BigDecimal getTotalCost() {
        BigDecimal cost = new BigDecimal(0);
 
        if (flightBooked != null) {
            if (flightBooked.getDepartureFlight() != null) {
                //cost = cost.add(flightBooked.getDepartureFlight().getCost());
            }
            if (flightBooked.getReturnFlight() != null) {
                 //cost = cost.add(flightBooked.getReturnFlight().getCost());
            }
        }
        if (hotelBooked != null) {
            if (hotelBooked.getHotel() != null) {
                BigDecimal hCost = hotelBooked.getHotel().getCost();
                int days = daysInbetween(hotelBooked.getCheckInDt(), hotelBooked.getCheckOutDt());
                cost = cost.add(new BigDecimal(hCost.doubleValue() * days));
            }
        }
        if (carBooked != null) {
            if (carBooked.getCar() != null) {
                BigDecimal cCost = carBooked.getCar().getCost();
                int days = daysInbetween(carBooked.getPickUpDt(), carBooked.getDropOffDt());
                cost = cost.add(new BigDecimal(cCost.doubleValue() * days));
            }
        }
        return cost;
    }
    
    /**
     * This will determine the amount of days between the events for booking.'
     * 
     * @param d1
     * @param d2
     * @return
     */
    private int daysInbetween(Date d1, Date d2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        int i =0;
        do {
            i++;
            cal.add(Calendar.DAY_OF_MONTH, 1);
        } while (cal.getTimeInMillis() < d2.getTime());
        return i;
    }
    
}
