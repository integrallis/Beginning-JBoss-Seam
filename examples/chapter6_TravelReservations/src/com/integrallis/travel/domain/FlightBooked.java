package com.integrallis.travel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

@Entity
@Name("flightBooked")
public class FlightBooked implements Serializable {

    private static final long serialVersionUID = -502024654448893880L;

    @Id @GeneratedValue
    private long flightBookedId;
    private Date departureDt;
    private Date returnDt;
    
    @ManyToOne()
    @JoinColumn(name="departureFlightId")
    private Flight departureFlight;
    
    @ManyToOne()
    @JoinColumn(name="returnFlightId")
    private Flight returnFlight;
    
    public Date getDepartureDt() {
        return departureDt;
    }
    public void setDepartureDt(Date departureDt) {
        this.departureDt = departureDt;
    }
    public long getFlightBookedId() {
        return flightBookedId;
    }
    public void setFlightBookedId(long flightBookedId) {
        this.flightBookedId = flightBookedId;
    }
    public Date getReturnDt() {
        return returnDt;
    }
    public void setReturnDt(Date returnDt) {
        this.returnDt = returnDt;
    }
    public Flight getDepartureFlight() {
        return departureFlight;
    }
    public void setDepartureFlight(Flight departureFlight) {
        this.departureFlight = departureFlight;
    }
    public Flight getReturnFlight() {
        return returnFlight;
    }
    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }
    
    
    
    
}
