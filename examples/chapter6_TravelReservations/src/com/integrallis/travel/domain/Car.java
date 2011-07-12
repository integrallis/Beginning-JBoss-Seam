package com.integrallis.travel.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jboss.seam.annotations.Name;

@Entity
@Name("car")
public class Car {

    @Id @GeneratedValue
    private long carId;
    private String carType;
    private String carCompany;
    private BigDecimal cost;
    
    public String getCarCompany() {
        return carCompany;
    }
    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }
    public long getCarId() {
        return carId;
    }
    public void setCarId(long carId) {
        this.carId = carId;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    
    
}
