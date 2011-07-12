<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	
<h2>Start Page</h2>


	<h:form>
		<h:commandLink action="#{paymentManager.start}" value="Make a Payment "/><br/>
	</h:form>
	
</f:view>

