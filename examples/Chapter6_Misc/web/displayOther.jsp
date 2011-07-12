

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>

	Course List - Non Page Context
	<h:dataTable var="other" value="#{courseListNonPage}"> 

		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Course"/> 
			</f:facet> 
			<h:outputText value="#{other.courseId}"/> 
		</h:column> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Course Name"/> 
			</f:facet> 
			<h:outputText value="#{other.name}"/> 
		</h:column> 
	</h:dataTable> 
	<br/>
	
	<s:link action="#{coursesActionNonPage.callBack}" value="Call Back to the Page"/><br/>
</f:view>