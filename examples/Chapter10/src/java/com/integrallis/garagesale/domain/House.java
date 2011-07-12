package com.integrallis.garagesale.domain;

import static org.jboss.seam.ScopeType.SESSION;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Name("house")
@Scope(SESSION)
public class House implements Serializable {

    private static final long serialVersionUID = -3823531857349759805L;
    
    private long houseId;
    private String address;
    private String city;
    private String state;
    private Date startTime;
    private Date endTime;
    
    @Id @GeneratedValue
    public long getHouseId() {
        return houseId;
    }
    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }
    
    @NotNull(message="Address is required")
    @Length(min=5, max=15, message="Address should be between 5 and 15")
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
        return houseId + ", " +address;
    }
}