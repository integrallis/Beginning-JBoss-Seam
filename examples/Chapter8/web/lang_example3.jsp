

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
	<h:form>
		<h:selectOneMenu value="#{localeSelector.language}">
		    <f:selectItem itemLabel="English" itemValue="en"/>
		    <f:selectItem itemLabel="Spanish" itemValue="es"/>
		    <f:selectItem itemLabel="French" itemValue="fr"/>
		</h:selectOneMenu>
		<h:commandButton action="#{localeSelector.select}" value="#{messages['ChangeLanguage']}"/><br/>
	</h:form>
	
	<h:outputText value="#{messages.helloPerson}"/>, <h:outputText value="#{messages['howAreYou']}"/><br/>
	
</f:view>

