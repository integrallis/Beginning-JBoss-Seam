package com.integrallis.banking.business;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.validator.Valid;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.banking.domain.Account;
import com.integrallis.banking.domain.Payment;
import com.integrallis.banking.service.PaymentManager;

@Stateful
@Name("paymentManager")
public class PaymentManagerAction implements PaymentManager {

    @PersistenceContext
    EntityManager em;
    
    @In(create = true, value = "account")
    @Out
    Account selectedAccount;
    
    @In(create = true)
    @Out
    Payment payment;
    
    @Out
    double amountDue;
    
    @Logger
    Log log;
    
    @Begin(pageflow="pay-bill") 
    public void start() {
        log.info("start");
        amountDue = 125.43;
    }
    
    /**
     * This will create the payment.
     * 
     */
    @Valid
    public void createPayment() {
        log.info("Create Payment");
        
        // set the account to use
        payment.setAccount(selectedAccount);
        
        // then pay it
        em.persist(payment);
    }
    
    /**
     * Determines if this is a new account.
     * 
     */
    public boolean isNewAccountType() {
        log.info("Is New Account Type");
        
        if (selectedAccount.getAccountId() == 0) {
            return true;
        }
        else {
            return false;
        }    
    }
    
    @Remove
    @Destroy
    public void destroy() {
        log.info("destroy");
    }
}
