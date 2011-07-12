package com.integrallis.travel.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

@Entity
@Name("carBooked")
public class CarBooked {

    @Id @GeneratedValue
    private long carBookedId;
    private Date pickUpDt;
    private Date dropOffDt;
    
    @ManyToOne()
    @JoinColumn(name="carId")
    private Car car;
    
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
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
