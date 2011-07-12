package com.petradesigns.backingbean;

import java.sql.ResultSet;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.ResultSetDataModel;

public class DataModelExample {

    HtmlDataTable dataTable = null;
    
    public void createDataModel(ResultSet rs) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HtmlDataTable dataTable = (HtmlDataTable)facesContext.getApplication().createComponent(HtmlDataTable.COMPONENT_TYPE);
        
        DataModel dataModel = new ResultSetDataModel(rs);
        dataModel.addDataModelListener(
                new DataModelListener() {
                    public void rowSelected(DataModelEvent e) {
                        FacesContext.getCurrentInstance().getExternalContext().log("row " + e.getRowIndex());
                    }
                }
        );
        dataTable.setValue(dataModel);
    }
}
