package com.integrallis.ticketing.business;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.BeginTask;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.EndTask;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.ticketing.domain.Ticket;
import com.integrallis.ticketing.domain.TicketChange;
import com.integrallis.ticketing.domain.User;
import com.integrallis.ticketing.service.TicketService;
import com.integrallis.ticketing.service.TicketWorking;


/**
 * This is the action class to handle the working of the ticket.
 * 
 * This will allow the ticket to add description to it, etc.
 * 
 * @author Joseph F Nusairat
 *
 */
// our new ship .... was ticketWorking
@Stateful
@Name("ticketWorking")
public class TicketWorkingAction implements TicketWorking {

    @Logger
    Log log;
    
    @EJB
    TicketService ticketService;
    
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em;
    
    @Out(required=false, scope=ScopeType.CONVERSATION)
    Ticket ticket;
    
    @In(required=false)
    Long ticketId;
    
    @In(required = false)
    String name;
    
    @In(required = false)
    String description;
    
    @In
    User authUser;
    
    /**
     * Views the task to be worked.
     */
    @BeginTask
    public String viewTask() {
        log.info("ticket working - view task - #{ticketId}");
        ticket = (Ticket) em.find(Ticket.class, ticketId);
        // start our change.
        ticketService.startChange(ticket.getTicketId(), authUser);
        log.info("ticket found - #{ticket}");
        return "/ticket_work.xhtml";
    }
 
    /**
     * The task is complete and should be moved onto the next step.
     */
    @EndTask(transition = "next")
    public String finished() {            
        log.info("ticket working - finished");
        // end work on the ticket
        ticketService.endChange(ticket.getTicketId(), authUser, description);        
        return "/ticket_list.xhtml";
    }    

    @EndTask(transition="cancel")
    public String cancel() {            
        log.info("ticket working - cancel");
        // end work on the ticket
        ticketService.endChange(ticket.getTicketId(), authUser, "Cancelled Work");
        return "/ticket_list.xhtml";
    }    
    
    
    @Remove
    @Destroy    
    public void destroy() {
        
    }
}
