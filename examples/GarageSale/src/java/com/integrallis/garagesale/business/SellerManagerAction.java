package com.integrallis.garagesale.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.domain.SaleItem;
import com.integrallis.garagesale.service.SellerManager;

@Stateless
@Name("sellerManager")
public class SellerManagerAction implements SellerManager {

    @PersistenceContext
    EntityManager em;
    
    //@In(create = true)
    @In(required = false) 
    @Out(scope = ScopeType.SESSION)
    House house;
        
    @In(required = false)
    SaleItem saleItem;
    
    @Logger
    Log log;
    
    public String addSaleItem() {
        log.info("Add Sale Item - #{saleItem}");
        //house.addItem(saleItem);
        saleItem.setHouseId(house.getHouseId());
        em.persist(saleItem);
        return "/saleItemAdd.jsp";
    }

    public String createGarageSale() {
        log.info("Add house - #{house}");
        em.persist(house);        
        return "/saleItemAdd.jsp";
    }

    public void deleteSaleItem() {
        
    }
    
    public String finish() {
        return "/finishSaleAdd.jsp";
    }
    
}
