

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	
	Course List - Page Context
	<h:dataTable var="course" value="#{courseListPage}"> 

		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Course"/> 
			</f:facet> 
			<h:outputText value="#{course.courseId}"/> 
		</h:column> 
		
		<h:column> 
			<f:facet name="header"> 
				<h:outputText value="Course Name"/> 
			</f:facet> 
			<h:outputText value="#{course.name}"/> 
		</h:column> 
	</h:dataTable> 
	<br/>
	
	<s:link action="#{coursesActionPage.callBack}" value="Call Back to the Page"/><br/>
	
	<s:link action="/startPage.jsp" value="Start Page"/><br/>	
</f:view>