package com.integrallis.garageSale.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.integrallis.garageSale.domain.House;
import com.integrallis.garageSale.service.IGarageSale;

@Stateless()
public class GarageSaleManagerBean implements IGarageSale {

    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addHouse(House house) {
        System.out.println("Adding house - " + house);
        em.persist(house);
    }
    
//    @Resource 
//    UserTransaction tx;
    
    public void deleteHouse(long houseId) {        
        House house = em.find(House.class, houseId);
        System.out.println("Delete house - " + house);
        em.remove(house);
    }
    
    public void updateTime(long houseId, Date startTime, Date endTime) {
        House house = em.find(House.class, houseId);
        house.setStartTime(startTime);
        house.setEndTime(endTime);
    }
    
//    HouseDAO dao;
//    
//    public void deleteHouse(House house) throws IOException {
//        try {
//            tx.begin();
//            try {
//                dao.delete(house);
//            } finally {
//                tx.commit();
//            }
//        } catch (Exception e) {
//            tx.rollback();
//        }
//    }
    
    public void updateHouse(House house) {
        em.flush();
    }
    
    @SuppressWarnings("unchecked")
    public List<House> findAll() {
        Query query = em.createQuery("Select h from House h");
        return (List<House>)query.getResultList();
    }
}
