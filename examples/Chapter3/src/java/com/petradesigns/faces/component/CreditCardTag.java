package com.petradesigns.faces.component;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

public class CreditCardTag extends UIComponentTag {
    
    String size = "5";
    String value = "joseph";
   
    private static final String CCI_COMP_TYPE = "CREDIT_CARD_INPUT";

    private static final String CCI_RENDER_TYPE = "CREDIT_CARD_RENDERER";
    
    // The type of component created
    public String getComponentType() {
        return CCI_COMP_TYPE;
    }

    // the type of renderer to be created 
    public String getRendererType() {
        return CCI_RENDER_TYPE;
    }
    
      /**
       * Set all the properties on the component
       */
    protected void setProperties(UIComponent component) {      
        FacesContext context = FacesContext.getCurrentInstance();
        super.setProperties(component);
        if (null != size) {
            component.getAttributes().put("size", size);
        }
        if (null != value) {
            if (isValueReference(value)) {
                ValueBinding vb = context.getApplication().createValueBinding(value);
                component.setValueBinding("value", vb);
            } else {
                ((UIInput) component).setValue(value);
            }
        }
    }

      
      public String getSize() {
          return size;
      }

    public void setSize(String size) {
        this.size = size;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
      
      
}
