package com.integrallis.travel.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CarBooked {
    
    private long carBookedId = 0;
    private Date pickUpDt = null;
    private Date dropOffDt = null;
    Car car = null;
    
    @ManyToOne
    @JoinColumn(name="carId")
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    
    @Id
    @GeneratedValue
    public long getCarBookedId() {
        return carBookedId;
    }
    public void setCarBookedId(long carBookedId) {
        this.carBookedId = carBookedId;
    }
    public Date getDropOffDt() {
        return dropOffDt;
    }
    public void setDropOffDt(Date dropOffDt) {
        this.dropOffDt = dropOffDt;
    }
    public Date getPickUpDt() {
        return pickUpDt;
    }
    public void setPickUpDt(Date pickUpDt) {
        this.pickUpDt = pickUpDt;
    }
    
    

}
