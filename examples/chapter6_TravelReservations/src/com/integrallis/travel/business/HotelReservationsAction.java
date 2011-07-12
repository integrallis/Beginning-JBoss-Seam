package com.integrallis.travel.business;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Log;

import com.integrallis.travel.domain.Hotel;
import com.integrallis.travel.service.HotelReservations;

@Stateful
@Name("hotelReservations")
public class HotelReservationsAction implements HotelReservations {

    // choose extended so it can go acrosss multiple things
    @PersistenceContext(type=EXTENDED)
    private EntityManager em;
    
    @DataModel
    List<Hotel> hotelList;
    
    @DataModelSelection
    Hotel hotel;
    
    @Logger
    Log log;
    
    public Hotel getSelectedHotel() {
        return hotel;
    }

    @Factory("hotelList")
    @SuppressWarnings("unchecked")
    public void lookupHotels() {
        log.debug("lookup Hotels");
        hotelList = em.createQuery("From Hotel h order by h.name").getResultList();        
    }
    

    @Destroy
    @Remove
    public void destroy() {
        // destroy
    }


}
