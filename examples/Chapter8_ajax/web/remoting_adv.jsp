
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>


<script type="text/javascript" src="seam/remoting/resource/remote.js"></script>
<script type="text/javascript" src="seam/remoting/interface.js?helloAction"></script>

<f:view>

<script type="text/javascript">
    //<![CDATA[

    function sayHello() {
    	// Run Both Components
		Seam.Component.getInstance("helloAction").sayHelloWithName(document.form.firstName.value,callBackMethod);

		alert("pause");		
		// create a user object
		var user = Seam.Remoting.createType("com.integrallis.ajax.domain.Person"); 		
//		var user = Seam.Component.newInstance("person");
	  	user.setFirstName(document.form.firstName.value);
	    user.lastName = document.form.lastName.value;
      	Seam.Component.getInstance("helloAction").sayHelloWithPerson(user, callBackMethod2);
    }
    
	// result is based on the STring that is returned from the sayHello method
    function callBackMethod(result) {
       	var captionElement = document.getElementById("helloId");
		captionElement.innerHTML = result;
    }

	function callBackMethod2(result) {
       	var captionElement = document.getElementById("helloId2");
		captionElement.innerHTML = result;
    }
    // ]]>
  </script>
  
  	Click to say hello<br/>
  	<form name="form">
  	<input type="text" name="firstName">&nbsp;<input type="text" name="lastName">&nbsp;
	</form>
	
	<button onclick="javascript:sayHello()">Say Hello</button><br/>
	
	<p>
		Response 1: <br/>
	 	<div id="helloId">
	 		test
	 	</div>
	 </p>
	 
	 <p>
		Response 2: <br/>
	 	<div id="helloId2">
	 		test
	 	</div>
	 </p>
</f:view>
