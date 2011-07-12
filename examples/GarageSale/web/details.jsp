
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>

	<h1>Garage Sale Details</h1> 
	<h2>House</h2>
	<b>Address:</b>&nbsp;<h:outputText value="#{house.address}"/><br/> 
	<b>City:</b>&nbsp;<h:outputText value="#{house.city}"/> <br/>
	<b>State:</b>&nbsp;<h:outputText value="#{house.state}"/> <br/>
	<b>Start Time:</b>&nbsp;
		<h:outputText value="#{house.startTime}">
			<f:convertDateTime pattern="MMM dd, yyyy h:mm aa"/>
		</h:outputText><br/>
	<b>End Time:</b>&nbsp;
		<h:outputText value="#{house.endTime}">
			<f:convertDateTime pattern="MMM dd, yyyy h:mm aa"/>
		</h:outputText><br/>
	
	<h2>Sale Items</h2>
	<h:dataTable value="#{saleItemList}" var="saleItem">
		<h:column> 
			<f:facet name="header"><h:outputText value="Item"/></f:facet> 
			<h:outputText value="#{saleItem.item}"> 
				<f:convertNumber pattern="$####.00"/>
			</h:outputText>			
		</h:column> 
		
		<h:column> 
			<f:facet name="header"><h:outputText value="Price"/></f:facet> 
			<h:outputText value="#{saleItem.price}"> 
				<f:convertNumber pattern="$####.00"/>
			</h:outputText>
		</h:column>		
	</h:dataTable>
	
	<s:link view="/garageSaleList.xhtml" value="Garage Sale Lists"/><br/>			
		
</f:view>