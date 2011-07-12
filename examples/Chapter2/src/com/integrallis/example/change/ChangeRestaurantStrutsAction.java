/*
 * Created on Dec 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.integrallis.example.change;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.integrallis.example.business.LookupRestaurant;

/**
 * @author NUSAIRJ
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ChangeRestaurantStrutsAction extends Action {

    // Business Service
    LookupRestaurant lookup;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        DynaActionForm dynaForm = (DynaActionForm) form;
        boolean save = ((Boolean) dynaForm.get("save")).booleanValue();

        if (save) {
            String newBest = (String) dynaForm.get("newBestResteraunt");
            String zipCode = (String) dynaForm.get("zipCode");
            lookup.saveNewBestRestaurant(newBest, zipCode);
            return mapping.findForward("completePage");
        } else {
            String bestRestaurant = lookup.findBestRestaurant((String) dynaForm.get("zipCode"));
            request.setAttribute("bestRestaurant", bestRestaurant);
            return mapping.findForward("success");
        }
    }
}
