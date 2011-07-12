
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="/WEB-INF/travel-reservations.tld" prefix="tv" %>

<f:view>

	Credit Card Example - 
	<tv:creditCardInput value="#{creditCardBackingBean.creditCardNumber}"/>
	
</f:view>