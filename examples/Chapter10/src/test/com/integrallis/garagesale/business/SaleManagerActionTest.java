package com.integrallis.garagesale.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

import com.integrallis.garagesale.domain.House;

public class SaleManagerActionTest {

    @Test
    public void testAddingHouse() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        House h = new House();
        h.setAddress("123 Main St");
        
        SaleManagerAction action = new SaleManagerAction();
        action.setHouse(h);
        action.setEntityManager(em);
        
        assert "success".equals(action.addHouse());
        
        em.getTransaction().rollback();
        em.close();
    }
    
    private EntityManagerFactory emf; 
    
    @Configuration(beforeTestClass=true) 
    public void init() 
    { 
        emf = Persistence.createEntityManagerFactory("userDatabase"); 
    } 
    
    @Configuration(afterTestClass=true) 
    public void destroy() 
    { 
        emf.close(); 
    } 

}
