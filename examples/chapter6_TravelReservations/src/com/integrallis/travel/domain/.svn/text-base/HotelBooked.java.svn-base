package com.integrallis.travel.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

@Entity
@Name("hotelBooked")
public class HotelBooked {

    @Id @GeneratedValue
    private long hotelBookedId;
    private Date checkInDt; // TODO change hte db diagram
    private Date checkOutDt;
    
    @ManyToOne()
    @JoinColumn(name="hotelId")
    private Hotel hotel;
    
    public Date getCheckInDt() {
        return checkInDt;
    }
    public void setCheckInDt(Date checkInDt) {
        this.checkInDt = checkInDt;
    }
    public Date getCheckOutDt() {
        return checkOutDt;
    }
    public void setCheckOutDt(Date checkOutDt) {
        this.checkOutDt = checkOutDt;
    }
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public long getHotelBookedId() {
        return hotelBookedId;
    }
    public void setHotelBookedId(long hotelBookedId) {
        this.hotelBookedId = hotelBookedId;
    }
    
    
}
