
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	<div class="entry errors"><h:messages globalOnly="true"/></div>

	<h:form>
			<h:messages/><br/>
		
			<s:validateAll>
				Please enter your address:<br/>
				<h:inputText value="#{house.address}" size="15"/><br/>	
				
				Please enter your city:<br/>
				<h:inputText value="#{house.city}" size="15"/><br/>	
				
				Please enter your state:<br/>
				<h:inputText value="#{house.state}" size="2"/><br/>	
				
				<h:commandButton value="Add House" action="#{salesManager.addHouse}"/>
			</s:validateAll>
	</h:form>    
</f:view>