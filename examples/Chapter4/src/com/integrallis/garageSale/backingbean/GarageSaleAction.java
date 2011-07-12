package com.integrallis.garageSale.backingbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.ListDataModel;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.integrallis.garageSale.domain.House;
import com.integrallis.garageSale.service.IGarageSale;

/**
 * This class really does nto follow many best practices.
 * 
 * So do not use this as an outline to use JSF - EJB3 strictly. 
 * 
 * There was an injection issue and i had to do some odd manual lookups. Normally the @EJB annotaitons uffices.
 * 
 * @author online
 *
 */
public class GarageSaleAction  {
    
    private static final String SUCCESS = "success";
    
    // house no pointing to an entity bean
    House house = new House();
    
    @EJB
    IGarageSale garageSale;
    
    // For house listing
    List<House> houses = null;
    DataModel houseDataModel = null;
    
    public String addHouse(ActionEvent event) throws NamingException {
        System.out.println("addHouse - ");        
        System.out.println("The House> " + house);
        
        getGarageSale().addHouse(house);
        house = new House();
        return "edit";
    }  
    
    /**
     * This is used to delete a house.
     * 
     * @param e
     * @return
     */
    public String deleteHouse(ActionEvent e) {
        System.out.println("Delete the house - " + houses.size());
        House house = (House)houseDataModel.getRowData();
        System.out.println("House to delete>" +houseDataModel.getRowData());
        houses.remove(house);
        System.out.println("Deleted - down to - " + houses.size());
        // TODO - remove from service
        
        return SUCCESS;
    }
    
    public String editHouse(ActionEvent e) {
        
        System.out.println("Edit House - ");
        House house = (House)houseDataModel.getRowData();
        System.out.println("Edit - " + house);
        this.house = house;
        
        return "edit";
        //return "/garageSale/houseEdit.faces";
        //return SUCCESS;
    }

    public String saveHouse() {
        
        System.out.println("Save House - " + house);
        
        return SUCCESS;
    }
    
    public void setHouseDataModel(DataModel d)
    {
      this.houseDataModel = d;
    }
    
    public DataModel getHouseDataModel()
    {
      System.out.println("Get Data Table");
      if (houseDataModel == null)
      {
          // set the list of houses
          if (houses == null) {
              houses = getGarageSale().findAll();        
          }
          houseDataModel = new ListDataModel(houses);
          houseDataModel.addDataModelListener(new DataModelListener()
          {
              public void rowSelected(DataModelEvent e)
              {
                  FacesContext.getCurrentInstance().getExternalContext().
                         log("phase: " + e.getRowIndex() + "; row seleted:" + e.getRowIndex());
              }              
          });
      }
      return houseDataModel;
    }
    
    private IGarageSale getGarageSale() {
        if (garageSale == null) {
            System.out.println("Manual garage sale lookup");
            try {
                garageSale = (IGarageSale)(new InitialContext()).lookup("chapter4/GarageSaleManagerBean/local");
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return garageSale;
    }
    
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
  
}