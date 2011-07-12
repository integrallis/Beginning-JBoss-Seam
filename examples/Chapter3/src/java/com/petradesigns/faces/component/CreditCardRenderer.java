package com.petradesigns.faces.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

/**
 * The renderer for the display.
 * 
 * @author online
 *
 */
public class CreditCardRenderer extends Renderer {

    public void decode(FacesContext context, UIComponent component) {
        // this should be done at EVER call of decode.
        assertValidInput(context, component);

        // set the data, no validation
        if (component instanceof UIInput) {         
            UIInput input = (UIInput) component;
            String clientId = input.getClientId(context);
            Map requestMap = context.getExternalContext().getRequestParameterMap();
            String newValue = (String) requestMap.get(clientId);
        
            if (newValue != null) {
                input.setSubmittedValue(newValue);
            }
        }
    }

    public void encodeEnd(FacesContext ctx, UIComponent component) throws IOException {
        // this should be done at every include
        assertValidInput(ctx, component);
        
        // write out the resposne
        ResponseWriter writer = ctx.getResponseWriter();
        writer.startElement("input", component);
        writer.writeAttribute("type", "text", "text");
        String id = (String) component.getClientId(ctx);
        writer.writeAttribute("id", id, "id");
        writer.writeAttribute("name", id, "id");
        String size = (String) component.getAttributes().get("size");
        if (null != size) {
            writer.writeAttribute("size", size, "size");
        }
        Object currentValue = getValue(component);
        writer.writeAttribute("value",formatValue(currentValue), "value");
        writer.endElement("input")    ;
    }
    
    protected void encodeColumn(ResponseWriter writer) {
        
    }

    protected Object getValue(UIComponent component) {
      Object value = null;
      if (component instanceof UIInput) {
        value = ((UIInput) component)
            .getSubmittedValue();
      }
      // if its not a UIInput or the submitted value
      // was null then get the value (it should
      // always be a UIInput)
      if (null == value
          && component instanceof ValueHolder) {
        value = ((ValueHolder) component)
            .getValue();
      }

      return value;
    }

    private String formatValue(Object currentValue) {
      // this should be a bit more sophisticated
      // in essence what should happen here is any
      // conversion that needs to take place.
      return currentValue.toString();
    }

    private void assertValidInput(
        FacesContext context, UIComponent component) {
      if (context == null) {
        throw new NullPointerException(
            "context should not be null");
      } else if (component == null) {
        throw new NullPointerException(
            "component should not be null");
      }
    }
}
