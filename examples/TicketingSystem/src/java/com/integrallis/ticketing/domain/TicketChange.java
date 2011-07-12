package com.integrallis.ticketing.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

/**
 * This is i general used to describe changes to the ticket.
 * 
 * Basically additions of the description.
 * 
 * @author Joseph F Nusairat
 *
 */
@Entity
@Name("ticketChange")
public class TicketChange {

    @Id
    @GeneratedValue
    private int ticketChangeId;
    private long ticketId;
    private String description;    
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    
    
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getTicketChangeId() {
        return ticketChangeId;
    }
    public void setTicketChangeId(int ticketChangeId) {
        this.ticketChangeId = ticketChangeId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
