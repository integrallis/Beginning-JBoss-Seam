<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>

Display Hello World<br/>
<h:form>
	Enter your name:<br/>
	<h:inputText value="#{person.name}" size="15"/><br/>
	
	<h:commandButton type="submit" value="Create Hello" action="#{helloWorld.createHello}"/> 
</h:form>	 
</f:view>
