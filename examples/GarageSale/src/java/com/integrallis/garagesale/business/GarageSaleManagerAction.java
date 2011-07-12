package com.integrallis.garagesale.business;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Log;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.domain.SaleItem;
import com.integrallis.garagesale.service.GarageSaleManager;

@Stateful
@Name("garageSaleManager")
//@Scope(ScopeType.CONVERSATION)
public class GarageSaleManagerAction implements GarageSaleManager {
    
    @Logger
    Log log;
    
    // choose extended so it can go acrosss multiple things
    @PersistenceContext(type=EXTENDED)
    private EntityManager em;
    
    // list of sale items
    @Out(required = false)
    private List<SaleItem> saleItemList;
    
    // list of houses
    @DataModel
    private List<House> garageSaleList;
    
    @DataModelSelection
    @Out(required=false)
    private House house;
    
    @Factory("garageSaleList")
    @SuppressWarnings("unchecked")
    public void findHomes() {
        log.info("find houses");
        garageSaleList = em.createQuery("From House hs order by hs.address, hs.city").getResultList();        
    }
    
    @SuppressWarnings("unchecked")
    public String findSaleItems() {
        log.info("find Sale Item");        
        Query query = em.createQuery("From SaleItem si where si.houseId = :houseId order by si.item");
        query.setParameter("houseId", house.getHouseId());
        saleItemList = query.getResultList();
        
        return "/details.jsp";
    }
    
    public String deleteHouse() {
        log.info("remove garage sale - #{house}");
        em.remove(house);
        
        // re get the list of houses
        findHomes();
        return "/garageSaleList.jsp";
    }
    
    @Remove
    @Destroy
    public void destroy() {
        
    }

}
