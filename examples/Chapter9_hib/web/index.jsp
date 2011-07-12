<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>

User Input<br/>
<h:form>
	Enter your name:<br/>
	<h:inputText value="#{user.name}" size="15"/><br/>
	
	<h:commandButton type="submit" value="Add User" action="#{userManager.saveUser}"/> <br/>
</h:form>	
 
Display Users<br/>
	<h:dataTable var="user" value="#{users}">
		<h:column> 
			<f:facet name="header">User Name</f:facet> 
			<h:outputText value="#{user.name}"/> 
		</h:column> 
	</h:dataTable> 
</f:view>
