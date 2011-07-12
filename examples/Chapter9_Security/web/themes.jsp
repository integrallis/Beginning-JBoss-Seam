<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>

<h:form>
	
	<h:selectOneMenu value="#{themeSelector.theme}">
	    <f:selectItems value="#{themeSelector.themes}"/>
	</h:selectOneMenu><br/>
	<h:commandButton action="#{themeSelector.select}" value="Select Theme"/>

</h:form>

</f:view>