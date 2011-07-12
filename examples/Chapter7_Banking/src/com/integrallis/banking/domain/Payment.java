package com.integrallis.banking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

@Entity
@Name("payment")
public class Payment {

    @Id
    @GeneratedValue
    private long paymentId;
    
    @ManyToOne
    @JoinColumn(name="accountId")
    private Account account;
    
    private double amount;
    
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public long getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }
    
    
}
