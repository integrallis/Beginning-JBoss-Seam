package com.integrallis.banking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jboss.seam.annotations.Name;

@Entity
@Name("transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private long transactionid;
}
