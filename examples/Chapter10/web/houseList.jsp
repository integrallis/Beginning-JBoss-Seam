
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>


<f:view>
	
	<h:dataTable var="house" value="#{houses}" rendered="#{houses.rowCount>0}"> 

		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Address"/> 
			</f:facet> 
			<h:outputText value="#{house.address}"/> 
		</h:column> 
	</h:dataTable> 

</f:view>