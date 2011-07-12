package com.integrallis.ticketing.business;

import java.util.Date;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.CreateProcess;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.ticketing.domain.Ticket;
import com.integrallis.ticketing.domain.TicketOwner;
import com.integrallis.ticketing.domain.User;
import com.integrallis.ticketing.service.TicketCreation;

/**
 * This class is used for initial creation of the ticket.
 * This will also set the initial owner which will be the person
 * that just created the ticket. 
 * 
 * @author Joseph F Nusairat
 *
 */
@Stateful
@Name("ticketCreation")
public class TicketCreationAction implements TicketCreation {
    
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em;
    
    @Logger
    Log log;
    
    @In(create = true)
    @Out
    private Ticket ticket;
    
    @In(create = true)
    private TicketOwner ticketOwner;
    
    @In(value = "authUser")
    User user;
    
    @Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
    long ticketId;
    @Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
    String ticketName;
    @Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
    String owner;
    @Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
    int severity;
    
    
    //@CreateProcess(definition="TicketingSystem")
    @CreateProcess(definition="TicketingSystem")
    public String createTicket() {
        log.info("ticket - create - #{ticket}");
        log.info("Using actor - #{actor} ");
        
        // ticket is not complete cause we just started it.
        ticket.setTicketComplete(false);
        // save the ticket
        em.persist(ticket);
        
        // also save the original owner of the ticket.
        ticketOwner.setOwnerStartDt(new Date());
        ticketOwner.setOwnerEndDt(null);
        ticketOwner.setTicketId(ticket.getTicketId());
        ticketOwner.setUser(user);
        em.persist(ticketOwner);
        
        // save fields of the ticket for the class.
        ticketId = ticket.getTicketId();
        owner = String.valueOf(user.getUserId());
        ticketName = ticket.getName();
        severity = ticket.getSeverity();
        
        return "/ticket_list.xhtml";
    }
    
    @Destroy
    @Remove
    public void destroy() {
        log.info("destroy");
    }
    
} 