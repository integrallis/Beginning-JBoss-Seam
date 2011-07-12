package com.integrallis.ticketing.domain;

import org.jboss.seam.annotations.Name;

/**
 * These are used to help define role usages for the jBPM processes.
 * 
 * @author Joseph F Nusairat
 *
 */
@Name("ticketRoles")
public class TicketRoles {

    public String[] getAdminRoles()
    {
       return new String[] {"ticket-admin" };
    }
    
    public String[] getWorkerRoles()
    {
       return new String[] { "ticket-worker", "ticket-admin" };
    }
}
