

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<f:view>
	
	
	<s:link action="#{coursesActionPage.createCourseList}" value="Create the Course List"/><br/>
	
	<s:link action="#{coursesActionNonPage.createCourseList}" value="Create the Course List (non-page type)"/><br/>
</f:view>