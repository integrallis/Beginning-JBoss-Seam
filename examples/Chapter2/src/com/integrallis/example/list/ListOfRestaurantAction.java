package com.integrallis.example.list;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;

import com.integrallis.example.domain.Restaurant;

/**
 * 
 * 
 * @author NUSAIRJ
 * 
 */
@Stateless
public class ListOfRestaurantAction implements IListOfRestaurantAction {

    @PersistenceContext(type = EXTENDED)
    EntityManager em;
    @DataModel
    List<Restaurant> restaurantList;


    @DataModelSelection
    Restaurant resteraunt;
    
    @Factory("restaurantList")
    @SuppressWarnings("unchecked")
    public void create() {
        // in reality here is where yo
        restaurantList = em.createQuery("From Restaurant r").getResultList();
    }
}
