
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
	
	<h:dataTable var="house" value="#{garageSale.houseDataModel}"> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Address"/> 
			</f:facet> 
			<h:outputText value="#{house.address}"/> 
		</h:column> 

		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="City"/> 
			</f:facet> 
			<h:outputText value="#{house.city}"/> 
		</h:column> 

		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="State"/> 
			</f:facet> 
			<h:outputText value="#{house.state}"/> 
		</h:column> 

		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Start Time"/> 
			</f:facet> 
			<h:outputText value="#{house.startTime}"/> 
		</h:column> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="End Time"/> 
			</f:facet> 
			<h:outputText value="#{house.endTime}"/> 
		</h:column> 
		
        
        <h:column>
         <h:commandLink actionListener="#{garageSale.deleteHouse}">
           <h:outputText value="Delete"/>
         </h:commandLink>
       </h:column>
       
       <h:column>
         <h:commandLink actionListener="#{garageSale.editHouse}">
           <h:outputText value="Edit"/>
         </h:commandLink>
       </h:column>
	</h:dataTable> 

</f:view>