package com.integrallis.ticketing.service;


public interface TicketApproval {
    
    String viewTask();
    String finish();
    String work();
    String cancel();
    void destroy();
}
