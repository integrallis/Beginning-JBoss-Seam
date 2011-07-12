
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
	<h:form>
		Please enter your name:<br/>
		<h:inputText value="#{helloWorldInt.name}" size="15"/><br/>
	
		<h:commandButton type="submit" value="Display" action="#{helloWorldInt.display}"/>
	</h:form>  
	
</f:view>