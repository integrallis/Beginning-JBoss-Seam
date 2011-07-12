package com.integrallis.example.list;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.integrallis.example.business.LookupRestaurant;
import com.integrallis.example.domain.Restaurant;

/*
 * Created on Dec 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author NUSAIRJ
 * 
 */
    public class ListOfRestaurantStrutsAction extends Action {
    
        // Business Service
        LookupRestaurant lookup;
    
        public ActionForward execute(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) {
    
            DynaActionForm dynaForm = (DynaActionForm) form;
            long restaurantId = ((Long) dynaForm.get("resterauntId")).longValue();
    
            // means its our first time through look it up
            if (restaurantId == -1) {
                List restaurants = lookup.findAllRestaurants();
                request.setAttribute("listOfRestaurants", restaurants);
            } else {
                // delete it
                Restaurant restaurant = lookup.find(restaurantId);
                request.setAttribute("restaurant", restaurant);
            }
    
            return mapping.findForward("success");
        }
    }
