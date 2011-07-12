package com.integrallis.garagesale.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jboss.seam.annotations.Name;

@Entity
@Name("saleItem")
public class SaleItem {

    @Id @GeneratedValue
    private long saleItemId;
    private long houseId;
    private String item;
    private double price;    
    
    public long getHouseId() {
        return houseId;
    }
    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public long getSaleItemId() {
        return saleItemId;
    }
    public void setSaleItemId(long saleItemId) {
        this.saleItemId = saleItemId;
    }
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
