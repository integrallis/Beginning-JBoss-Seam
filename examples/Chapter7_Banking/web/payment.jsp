

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	
<h2>Payment Amount</h2>
	
	<h:form>
		Total Amount Due - <h:outputText value="#{amountDue}"/> <br/>
		
		Amount to Pay - <h:inputText id="paymentAmt" value="#{payment.amount}" required="true"/><br/> 
	
		<h:commandButton action="next" value="#{messages.newCustomerSubmit}" />
	</h:form>
</f:view>