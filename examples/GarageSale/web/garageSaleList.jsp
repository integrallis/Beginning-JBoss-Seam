
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>

	<h1>List of Garage Sales</h1> 
	<h:form>
	<h:dataTable value="#{garageSaleList}" var="house">
		<h:column> 
			<f:facet name="header"><h:outputText value="Address"/></f:facet> 
			<h:outputText value="#{house.address}"/> 
		</h:column> 
		
		<h:column> 
			<f:facet name="header"><h:outputText value="City"/></f:facet> 
			<h:outputText value="#{house.city}"/> 
		</h:column>
		
		<h:column> 
			<f:facet name="header"><h:outputText value="State"/></f:facet> 
			<h:outputText value="#{house.state}"/> 
		</h:column>
		
		<h:column> 
			<f:facet name="header"><h:outputText value="Start Date"/></f:facet> 
			<h:outputText value="#{house.startTime}"> 
				<f:convertDateTime dateStyle="full"/>			
			</h:outputText>
		</h:column>
		
		<h:column> 
			<f:facet name="header"><h:outputText value="End Date"/></f:facet> 
			<h:outputText value="#{house.endTime}"> 
				<f:convertDateTime dateStyle="full"/>
			</h:outputText>
		</h:column>
		
		<h:column> 
			<f:facet name="header"><h:outputText value="Detailed View"/></f:facet>		
			<h:commandLink value="Details" action="#{garageSaleManager.findSaleItems}"/> 			
		</h:column>
		
		<h:column> 
			<f:facet name="header"><h:outputText value="Delete Garage Sale"/></f:facet>		
			<h:commandLink value="Remove" action="#{garageSaleManager.deleteHouse}"/> 			
		</h:column>				
	</h:dataTable>
	</h:form>		
	
	<a href="./index.html">Back Home</a>
</f:view>