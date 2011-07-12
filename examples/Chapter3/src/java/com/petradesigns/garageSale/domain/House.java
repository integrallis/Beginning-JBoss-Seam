package com.petradesigns.garageSale.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Our domain object to be added to the database.
 * 
 * @author online
 *
 */
public class House implements Serializable {
    
    private static final long serialVersionUID = -589123856728925462L;
    
    private String address;
    private String city;
    private String state;
    private Date startTime;
    private Date endTime;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return address + ", " + city + ", " + state + ", " + startTime + ", " + endTime;
    }
}
