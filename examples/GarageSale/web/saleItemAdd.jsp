
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>


<f:view>
	<h1>Add your Sale Items</h1>
	You will be adding sale items. Note they wont appear on here.
	
	This page just keeps refershing for you to keep adding more items.
	
	<h:form>
		Item:<br/>
		<h:inputText value="#{saleItem.item}" size="10"/><br/>	

		Price:<br/>
		<h:inputText value="#{saleItem.price}" size="5"/><br/>	
			
		<h:commandButton type="submit" value="Add Sale Item" action="#{sellerManager.addSaleItem}"/><br/>
		
		<s:link view="/garageSaleList.xhtml" value="Garage Sale Lists"/><br/>		
	</h:form>
	  
</f:view>