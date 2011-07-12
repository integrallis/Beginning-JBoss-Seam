package com.integrallis.banking.service;

public interface PaymentManager {
    void createPayment();
    boolean isNewAccountType();
    void start();
    void destroy();
}
