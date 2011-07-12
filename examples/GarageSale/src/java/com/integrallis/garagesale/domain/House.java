package com.integrallis.garagesale.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

@Entity
@Name("house")
public class House {
    
    @Id @GeneratedValue
    private long houseId;
    
    @NotNull(message="Address is required")
    @Length(min=5, max=100, message="Address should be between 5 and 100")    
    private String address;
    
    @NotNull(message="City is required")
    @Length(min=1, max=100, message="City should be between 1 and 100")        
    private String city;
    
    @NotNull(message="State is required")
    @Length(min=2, max=2, message="State should be 2 lettes")        
    private String state;
    
    private Date startTime;
    private Date endTime;
        
    @OneToMany(targetEntity=SaleItem.class,mappedBy="houseId") 
    private List<SaleItem> items = new ArrayList<SaleItem>();
        
    public long getHouseId() {
        return houseId;
    }
    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }
       
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
    public List<SaleItem> getItems() {
        return items;
    }
    public void setItems(List<SaleItem> items) {
        this.items = items;
    }
    
    @Transient
    public void addItem(SaleItem saleItem) {
        items.add(saleItem);
    }
    
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
}