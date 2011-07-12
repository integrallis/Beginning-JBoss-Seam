package com.integrallis.ticketing.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.jboss.seam.annotations.Name;

/**
 * This defines the owner of a ticket.
 * 
 * Ticket owning is a temporal process, the current owner will always have 
 * an ownerEndDt of null.
 * 
 * @author Joseph F Nusairat
 *
 */
@Entity
@Name("ticketOwner")
@NamedQuery(name="TicketOwner.findOpenTicket",
        query=  " Select to " +
                " From TicketOwner to " +
                " where to.ticketId = :ticketId " +
                " And to.ownerEndDt is null ")
public class TicketOwner {

    @Id
    @GeneratedValue
    private long ticketOwnerId;
    private Date ownerStartDt;
    private Date ownerEndDt;
    private long ticketId;
    @OneToOne
    @JoinColumn(name="userId")
    private User user;

    public Date getOwnerEndDt() {
        return ownerEndDt;
    }
    public void setOwnerEndDt(Date ownerEndDt) {
        this.ownerEndDt = ownerEndDt;
    }
    public Date getOwnerStartDt() {
        return ownerStartDt;
    }
    public void setOwnerStartDt(Date ownerStartDt) {
        this.ownerStartDt = ownerStartDt;
    }
    public long getTicketOwnerId() {
        return ticketOwnerId;
    }
    public void setTicketOwnerId(long ticketOwnerId) {
        this.ticketOwnerId = ticketOwnerId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }
    
    
}
