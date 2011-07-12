/*
 * Created on Dec 5, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.integrallis.example.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.integrallis.example.business.LoginService;

/**
 * @author NUSAIRJ
 */
    public class LoginStrutsAction extends Action {
    
        // Business Service
        LoginService service;
    
        public ActionForward execute(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) {
    
            DynaActionForm dynaForm = (DynaActionForm) form;
    
            // get the variables
            String username = (String) dynaForm.get("username");
            String password = (String) dynaForm.get("password");
    
            // get
            boolean successful = service.login(username, password);
    
            if (successful) {
                request.getSession().setAttribute("loggedIn", username);
                return mapping.findForward("success");
            } else {
                return mapping.findForward("failed");
            }
        }
    }
