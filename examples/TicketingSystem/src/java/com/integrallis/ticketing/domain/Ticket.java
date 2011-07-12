package com.integrallis.ticketing.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.jboss.seam.annotations.Name;

/**
 * The main entity object for the ticket. 
 * 
 * This will contain our information about the ticket as well as the list of owners
 * and changes to the ticket.
 * 
 * @author Joseph F Nusairat
 *
 */
@Entity
@Name("ticket")
public class Ticket {
        
    @Id
    @GeneratedValue
    private long ticketId = 0;
    private String name;
    private String description;
    private int severity = 0;
    private boolean ticketComplete = false;
    
    @OneToMany(targetEntity=TicketChange.class, mappedBy="ticketId")
    List<TicketChange> ticketChanges;
    @OneToMany(targetEntity=TicketOwner.class, mappedBy="ticketId")
    List<TicketOwner> ticketOwners;
        
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSeverity() {
        return severity;
    }
    public void setSeverity(int severity) {
        this.severity = severity;
    }
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }
    public boolean isTicketComplete() {
        return ticketComplete;
    }
    public void setTicketComplete(boolean ticketComplete) {
        this.ticketComplete = ticketComplete;
    }     
    public List<TicketChange> getTicketChanges() {
        return ticketChanges;
    }
    public void setTicketChanges(List<TicketChange> ticketChanges) {
        this.ticketChanges = ticketChanges;
    }
    public List<TicketOwner> getTicketOwners() {
        return ticketOwners;
    }
    public void setTicketOwners(List<TicketOwner> ticketOwners) {
        this.ticketOwners = ticketOwners;
    }
    public String toString() {
        return "ticketId - " + ticketId + " / ticketName - " + name + " / description " + description;
    }
}
