package com.integrallis.garagesale.business;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.validator.Valid;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.service.SaleManager;

@Stateful
@Name("salesManager")
//@Interceptors(SeamInterceptor.class)
//@JndiName("chapter10/SaleManagerAction/local")
public class SaleManagerAction implements SaleManager {

    private EntityManager em;
    
    @Valid
    @In @Out
    private House house;

    @Logger 
    private Log log;
    
    public String addHouse() {
        log.info("House address to add is #{house.address}");
        em.persist(house);
        return "/homeSuccess.jsp";
    }

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
  
    @Remove @Destroy
    public void destroy() {
        System.out.println("SaleManagerAction.destroy()");
    }
    
    public void setHouse(House h) {
        house = h;
    }
}