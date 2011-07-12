<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
	
	Main Page<br/>
		
	<h:commandLink action="#{normalPage.go}" value="Normal Page"/><br/>
	
	<h:commandLink action="#{adminPage.go}" value="Admin Page"/><br/>	
	
	<h:commandLink action="#{login.logout}" value="Logout"/><br/>	
</f:view>

