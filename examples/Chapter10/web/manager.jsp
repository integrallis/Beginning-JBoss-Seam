
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>


<f:view>

	
	<h:dataTable var="house" value="#{houses}" rendered="#{houses.rowCount>0}"> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Title"/> 
			</f:facet> 
		</h:column> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Date/Time"/> 
			</f:facet> 
			<h:outputText value="#{house.address}"/> 
		</h:column> 
	</h:dataTable> 
	
	
	<h:form>
		Please enter your address:<br/>
		<h:inputText value="#{house.address}" size="15"/><br/>
	
		<h:commandButton type="submit" value="Add House" action="#{manager.addHouse}"/>
	</h:form>    
</f:view>