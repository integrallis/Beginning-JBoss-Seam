package com.integrallis.garagesale.business;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.Conversational;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.IfInvalid;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Outcome;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Log;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.domain.SaleItem;
import com.integrallis.garagesale.service.GarageSale;

@Stateless
//@Scope(SESSION)
@Name("garageSale")
// This is what defines where to forward to if Begin method
/// has not started yet.
@Conversational(ifNotBegunOutcome="main")
public class GarageSaleAction implements GarageSale {
 
    // choose extended so it can go acrosss multiple things
    @PersistenceContext(type=EXTENDED)
    private EntityManager em;
    
    @In @Out
    // This your house
    private House house;

    // list of sale Items
    @DataModel
    private List<SaleItem> saleItems;
    
    @DataModelSelection
    private SaleItem saleItem;
    
    @Logger private Log log;
    
    
    @IfInvalid(outcome=Outcome.REDISPLAY)
    public String addHouse() {
        //
        System.out.println("Should have logging right underneath here");
        log.debug("House address to add is #{house.address}");
        //System.out.println("House address to add is - " +house.getAddress());
        em.persist(house);
        return "/homeSuccess.jsp";
    }
    
    // ends the current conversation
    @End
    public String confirm() {
        
        // save sale itmese now
        em.persist(saleItems);
        return null;
    }
  
  
    //@Remove @Destroy
    public void destroy() {
        System.out.println("SaleManagerAction.destroy()");
    }
    
    @PostConstruct
    public void init() {
        
    }
    
    @PreDestroy
    public void noMore() {
        
    }
}