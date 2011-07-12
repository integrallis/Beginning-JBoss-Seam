package com.integrallis.banking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

@Entity
@Name("account")
public class Account {

    @Id
    @GeneratedValue
    private long accountId = 0;
    
    @NotNull
    private String creditCardNumber;
    
    @NotNull
    @Min(value=1)
    @Max(value=12)
    private int experiationMonth;
    
    @NotNull
    @Min(value=2006)
    private int experiationYear;
    
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public int getExperiationMonth() {
        return experiationMonth;
    }
    public void setExperiationMonth(int experiationMonth) {
        this.experiationMonth = experiationMonth;
    }
    public int getExperiationYear() {
        return experiationYear;
    }
    public void setExperiationYear(int experiationYear) {
        this.experiationYear = experiationYear;
    }
    
    
}
