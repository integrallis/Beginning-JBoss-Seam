
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	<h1>Add your Garage Sale</h1>
	<div class="entry errors"><h:messages/></div>
	
	<h:form>
	<s:validateAll>
		Address:<br/>
		<h:inputText value="#{house.address}" size="15"/><br/>

		City:<br/>
		<h:inputText value="#{house.city}" size="15"/><br/>


		State:<br/>
		<h:inputText value="#{house.state}" size="2"/><br/>

	
		<h:commandButton type="submit" value="Add House" action="#{sellerManager.createGarageSale}"/>
	</s:validateAll>
	</h:form>    
</f:view>