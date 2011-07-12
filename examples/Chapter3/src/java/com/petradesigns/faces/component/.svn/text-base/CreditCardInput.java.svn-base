    package com.petradesigns.faces.component;

import javax.faces.component.UIInput;

/**
 * This will be our credit card input.
 * 
 * @author online
 */
public class CreditCardInput extends UIInput {

    public static final String FAMILY = "CreditCardFamily";
    private String column1 = ""; 
    private String column2 = "";
    private String column3 = "";
    private String column4 = "";
    
    public CreditCardInput() {
        super();
        // addValidator();
    }
    
    /**
     * This is used in conjunction with the value of renderType.
     * Can be used to select the appropriate Renderer.
     * 
     */
    public String getFamily() {
        return FAMILY;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }
    
    /**
     * Overwrite the getValue to be hte combination of the 4 boxes.
     * 
     */
    public Object getValue() {
        return column1 + column2 + column3 + column4;
    }
    
    
    
    
}
