package com.integrallis.ticketing.business;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.integrallis.ticketing.domain.Ticket;
import com.integrallis.ticketing.domain.TicketChange;
import com.integrallis.ticketing.domain.TicketOwner;
import com.integrallis.ticketing.domain.User;
import com.integrallis.ticketing.service.TicketService;

/**
 * This class is used to handle items directly associated with the ticket.
 * 
 *  Since things like adding description , changing users, are more base concepts
 *  we will have them ran via this class.
 * 
 * @author Joseph F Nusairat
 *
 */
@Stateless
public class TicketServiceAction implements TicketService {

    @PersistenceContext
    EntityManager em;
    
    /**
     * This will start an iteration of the ticket.
     *  
     * 
     * @param ticket
     */
    public void startChange(long ticketId, User user) {
        
        TicketOwner owner = findLastOwner(ticketId);
        // if owner != null close him out first.
        if (owner != null) {
//System.out.println("******************** 1 "+ owner);
            //owner = em.find(TicketOwner.class, ticketId);
            owner.setOwnerEndDt(Calendar.getInstance().getTime());
        }
        
        // then start a new iteration with the current user
        TicketOwner newOwner = new TicketOwner();
        newOwner.setOwnerStartDt(Calendar.getInstance().getTime());
        newOwner.setOwnerEndDt(null);
        newOwner.setTicketId(ticketId);
        newOwner.setUser(user);
        
        em.persist(newOwner);
    }
    
    /**
     * This will commit and the change.
     * 
     * @param ticket
     * @param user
     * @param description
     */
    public void endChange(long ticketId, User user, String description) {
        // find the last person to change it.
        TicketOwner owner = findLastOwner(ticketId);
        
        // end it
//System.out.println("******************** 2 "+ owner);        
        //owner = em.find(TicketOwner.class, ticketId);
        owner.setOwnerEndDt(Calendar.getInstance().getTime());
        
        // and add a description to our change long
        TicketChange change = new TicketChange();
        change.setDescription(description);
        change.setTicketId(ticketId);
        change.setUser(user);
        
        em.persist(change);
    }
    
    /**
     * This will find the last owner of a ticket.
     */
    private TicketOwner findLastOwner(long ticketId) {
        // first end ownership if there is a previous owner.
        // find the last version of the ticket.
        Query query = em.createNamedQuery("TicketOwner.findOpenTicket");
        query.setParameter("ticketId", ticketId);
        TicketOwner owner = null;
        try {
            owner = (TicketOwner) query.getSingleResult();
        } catch (NoResultException e) {
            // absorb, it's acceptable.
        }
        return owner;
    }
}
