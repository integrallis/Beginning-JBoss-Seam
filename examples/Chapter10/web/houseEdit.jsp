
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	
	<h:dataTable var="house" value="#{houseList}" rendered="#{houseList.rowCount>0}"> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Title"/> 
			</f:facet> 
		</h:column> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Date/Time"/> 
			</f:facet> 
			<h:inputText value="#{house.address}" size="15"/>
		</h:column> 
		<h:column>
           <s:link value="Save" action="#{houseManagerEdit.update}" linkStyle="button"/>
        </h:column>
	</h:dataTable> 

</f:view>