<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>

	<h:form>
	
		Login:<br/>
		
		User - 
		<h:inputText id="name" value="#{user.username}" required="true"/><br/>
		
		Password - 
		<h:inputText id="password" value="#{user.password}" required="true"/><br/>
		
		<h:commandButton id="login" action="#{login.login}" value="Login" styleClass="button"/>	
	
	</h:form>  
</f:view>
