package com.integrallis.travel.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jboss.seam.annotations.Name;

@Entity
@Name("flight")
public class Flight implements Serializable {
    
    private static final long serialVersionUID = -4482972232562728317L;
    
    @Id @GeneratedValue
    private long flightId;
    private String airline;
    private String fromAirport;
    private String toAirport;
    private Time arrivalTime;
    private Time departureTime;
    private BigDecimal cost;    
    
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public Time getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public long getFlightId() {
        return flightId;
    }
    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }
    public String getFromAirport() {
        return fromAirport;
    }
    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }
    public Time getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
    public String getToAirport() {
        return toAirport;
    }
    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
    
    
}
