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

import com.integrallis.travel.domain.Car;
import com.integrallis.travel.service.CarReservations;

@Stateful
@Name("carReservations")
public class CarReservationsAction implements CarReservations {

    // choose extended so it can go acrosss multiple things
    @PersistenceContext(type=EXTENDED)
    private EntityManager em;
    
    @DataModel
    List<Car> carList;
    
    @DataModelSelection
    Car car;
    
    @Logger
    Log log;
    
    public Car getSelectedCar() {
        return car;
    }

    @Factory("carList")
    @SuppressWarnings("unchecked")
    public void lookupCars() {
        log.info("looking up cars");
        carList = em.createQuery("From Car c order by c.carType").getResultList();
    }
    

    @Destroy
    @Remove
    public void destroy() {
        // destroy
    }
}
