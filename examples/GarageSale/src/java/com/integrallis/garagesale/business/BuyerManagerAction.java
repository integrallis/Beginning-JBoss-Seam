package com.integrallis.garagesale.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.service.BuyerManager;

@Name("buyerManager")
@Stateless
public class BuyerManagerAction implements BuyerManager {

    @PersistenceContext
    EntityManager em;
    
    @In(required = true)
    String city;
    
    @In(required = true)
    String address;
    
    @In(required = true)
    String state;
    
    public List<House> searchGarageSales() {
        em.find(House.class, "From House h where h.");
        return null;
    }
}
