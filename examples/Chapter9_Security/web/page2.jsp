<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<f:view>
	<c:if
		test="${s:hasRole('admin')}">
		
		This is an example of an admin page.
	</c:if>
</f:view>