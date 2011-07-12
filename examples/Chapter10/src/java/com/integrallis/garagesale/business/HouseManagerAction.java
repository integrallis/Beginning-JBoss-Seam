package com.integrallis.garagesale.business;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.ejb.SeamInterceptor;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.service.HouseManager;

@Stateful
@Name("houseManager")
@JndiName("garage-sale/HouseManagerAction/local")
@Interceptors(SeamInterceptor.class)
public class HouseManagerAction implements HouseManager {
    //private static final long serialVersionUID = 8755330264982060424L;

    @PersistenceContext
    private EntityManager em;

    // lets also get the house list
    // datamodel can be used on the private object or the getter
    @DataModel
    private List<House> houses;

    // this tells seam to create an instance of the bean and invoke
    // find messages
    @Factory("houses")
    public void findHomes() {
        System.out.println("FInd homes");
        List list = em.createQuery("From House hs order by hs.houseId").getResultList();
        System.out.println("Whats the list - " + list.getClass().getName());
        houses = list;
        System.out.println("DOne");
    }


    @Destroy @Remove
    public void destroy() {
        System.out.println("HouseManagerAction.destroy()");
    }

}