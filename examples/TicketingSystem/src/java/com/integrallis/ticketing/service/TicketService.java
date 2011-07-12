package com.integrallis.ticketing.service;

import com.integrallis.ticketing.domain.User;

/**
 * Interface for the ticketing servicing.
 * 
 * @author Joseph F Nusairat
 *
 */
public interface TicketService {

    void startChange(long ticketId, User user);
    void endChange(long ticketId, User user, String description);
    
}
