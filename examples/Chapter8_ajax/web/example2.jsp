<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a" %>

<f:view>

<h:form>

<h3>Create a Username and Password.</h3>

<s:validateAll>
	<h:outputLabel for="name">User Name:</h:outputLabel></div>
	<div class="input">
		<s:decorate>
			<h:inputText id="name" value="#{user.name}" required="true">
	           <a:support event="onblur" reRender="userNameErrors"/>
	        </h:inputText>
			<br/>
			<a:outputPanel id="userNameErrors">
	        	<s:message/>
	        </a:outputPanel>
		</s:decorate>		
	</div><br/>

	<h:outputLabel for="password">Password:</h:outputLabel></div>
	<div class="input">
		<s:decorate>
			<h:inputText id="password" value="#{user.password}" required="true">
	           <a:support event="onblur" reRender="passwordErrors"/>
	        </h:inputText>
			<br/>
	        <a:outputPanel id="passwordErrors">
	        	<s:message/><br/>	        	
        	</a:outputPanel>
		</s:decorate>
	</div><br/>
	        
</s:validateAll>

	<input type="button" value="Submit"/>
</h:form>
  
</f:view>
