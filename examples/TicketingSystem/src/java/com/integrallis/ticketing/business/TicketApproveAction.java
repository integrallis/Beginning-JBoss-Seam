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
import com.integrallis.ticketing.domain.User;
import com.integrallis.ticketing.service.TicketApproval;
import com.integrallis.ticketing.service.TicketService;

@Stateful
@Name("ticketApprove")
public class TicketApproveAction implements TicketApproval {

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
    
    @In
    User authUser;
    
    @BeginTask
    public String viewTask() {
        log.info("ticket - begin - approve");
        ticket = (Ticket) em.find(Ticket.class, ticketId);
        ticketService.startChange(ticket.getTicketId(), authUser);
               
        return "/ticket_approve.xhtml";
    }

    
    @EndTask(transition="done")
    public String finish() {
        // mark tcket compelte.
        ticket.setTicketComplete(true);
        ticketService.endChange(ticket.getTicketId(), authUser, "Ticket Completed");        
        return "/ticket_list.xhtml";
    }
    
    @EndTask(transition="work")
    public String work() {
        ticketService.endChange(ticket.getTicketId(), authUser, "Return to working mode");
        return "/ticket_list.xhtml";
    }
    
    @EndTask(transition="reject")
    public String cancel() {
        // ticket still gets marked as completed
        ticket.setTicketComplete(true);
        ticketService.endChange(ticket.getTicketId(), authUser, "Reject Ticket");
        return "/ticket_list.xhtml";
    }
    
    @Destroy
    @Remove
    public void destroy() {
        
    }
}
