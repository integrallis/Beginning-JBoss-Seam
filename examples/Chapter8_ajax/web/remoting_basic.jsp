
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>


<script type="text/javascript" src="seam/remoting/resource/remote.js"></script>
<script type="text/javascript" src="seam/remoting/interface.js?helloAction"></script>

<f:view>

<script type="text/javascript">
    //<![CDATA[

    function sayHello() {
      Seam.Component.getInstance("helloAction").sayHello(callBackMethod);
    }
    
	// result is based on the STring that is returned from the sayHello method
    function callBackMethod(result) {
       	var captionElement = document.getElementById("helloId");
		captionElement.innerHTML = result;
    }

    // ]]>
  </script>
  
  	Click to say hello<br/>
	<button onclick="javascript:sayHello()">Say Hello</button><br/>

	<p>
		Our Test Response: <br/>
	 	<div id="helloId">
	 		
	 	</div>
	 </p>
</f:view>
