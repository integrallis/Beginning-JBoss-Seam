/*
 * Created on Dec 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.integrallis.examples.lookup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.integrallis.example.business.LookupRestaurant;

/**
 * @author NUSAIRJ
 */
public class LookupRestaurantStrutsAction extends Action {

    // Business Service
    LookupRestaurant lookup;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        // 1) Get the zip code
        String zipcode = request.getParameter("zipCode");

        // 2) Look it up
        String resteraunt = lookup.findBestRestaurant(zipcode);

        // 3) save the resteraunt
        request.setAttribute("bestResteraunt", resteraunt);

        return mapping.findForward("success");
    }
}
