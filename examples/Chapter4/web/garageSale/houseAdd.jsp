
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>


<f:view>
	<h1>Add a garage sale to your area</h1>
	<div class="entry errors"><h:messages globalOnly="true"/></div>

	<h:messages/>
	
	<h:form>
		<h:panelGrid columns="2" cellpadding="5" border="0">
			<h:outputText value="Address:"/>
			<h:inputText value="#{garageSale.house.address}" size="25"/>
	
			<h:outputText value="City:"/>
			<h:inputText value="#{garageSale.house.city}" size="25"/>
			
			<h:outputText value="State:"/>
			<h:inputText value="#{garageSale.house.state}" size="25"/>
			
			<h:outputText value="Start Time:"/>
			<t:inputDate value="#{garageSale.house.startTime}" type="both"/>
			
			<h:outputText value="End Time:"/>
			<t:inputDate value="#{garageSale.house.endTime}" type="both"/>
			
			<f:facet name="footer">							
				<h:commandButton id="addHouse" value="Add House" actionListener="#{garageSale.addHouse}"/>
			</f:facet>
		</h:panelGrid>
	</h:form>    
	
	<a href="./houseList.faces">List of Garage Sales</a><br/>
</f:view>