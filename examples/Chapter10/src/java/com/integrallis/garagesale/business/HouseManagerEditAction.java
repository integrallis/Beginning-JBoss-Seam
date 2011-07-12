package com.integrallis.garagesale.business;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.ejb.SeamInterceptor;

import com.integrallis.garagesale.domain.House;
import com.integrallis.garagesale.service.HouseManagerEdit;


@Stateful
@Name("houseManagerEdit")
@JndiName("garage-sale/HouseManagerEditAction/local")
@Interceptors(SeamInterceptor.class)
// without this the house will come back null cause the data model is not persisted
@Scope(ScopeType.SESSION)               ///necessary to keep the object in scope
public class HouseManagerEditAction implements HouseManagerEdit {
    //private static final long serialVersionUID = 8755330264982060424L;

    // required to be stateful session bean for an extended context
    @PersistenceContext(type=EXTENDED)
    private EntityManager em;

    @DataModelSelection
    @Out(required=false)
    private House house;
    
    
    // lets also get the house list
    // datamodel can be used on the private object or the getter
    // can only be scopeType unspecified or page
    @DataModel
    private List<House> houseList;

    // this tells seam to create an instance of the bean and invoke
    // find messages
    @Factory("houseList")
    public void findHomes() {
        System.out.println("HouseManagerEditAction.findHomes()");
        houseList = em.createQuery("From House hs order by hs.houseId").getResultList();
    }


    public String update() {
        System.out.println("Update House - " + house);
        // update it.
        em.persist(house);
        //em.remove(house);
        
        // return back to the same page.
        return null;
    }
    
    @Destroy @Remove
    public void destroy() {
        System.out.println("HouseManagerAction.destroy()");
    }

}
