package com.petradesigns.garageSale.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.ListDataModel;

import com.petradesigns.garageSale.domain.House;


public class GarageSaleAction implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2316088692634472159L;

    private static final String SUCCESS = "success";
    
    // for individual house manipulation
    House house = new House();
    
    // For house listing
    List<House> houses = null;
    DataModel houseDataModel = null;
    
    public String addHouse() {
        System.out.println("addHouse - ");        
        System.out.println("The House> " + house);
        
        // Persist it to the database
        // via an injection from EJB                
        
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
              houses = retrieveHouseList();        
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
    
    private List<House> retrieveHouseList() {
        List<House> list = new ArrayList<House>();
        
        House house = new House();
        house.setAddress("123 Main St");
        house.setCity("Columbus");
        house.setState("OH");
        house.setStartTime(new Date());
        house.setEndTime(new Date());
        list.add(house);
        
        house = new House();
        house.setAddress("123 High St");
        house.setCity("Cleveland");
        house.setState("OH");
        house.setStartTime(new Date());
        house.setEndTime(new Date());
        list.add(house);
        
        house = new House();
        house.setAddress("123 Central St");
        house.setCity("Cincinnati");
        house.setState("OH");
        house.setStartTime(new Date());
        house.setEndTime(new Date());
        list.add(house);
        
        return list;
    }
    
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}