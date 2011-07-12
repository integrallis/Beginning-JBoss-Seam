
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

Here we go again on our own :)<br/>

<script type="text/javascript" src="seam/remoting/resource/remote.js"></script>
<script type="text/javascript" src="seam/remoting/interface.js?testAction"></script>

<f:view>

<script type="text/javascript">
    //<![CDATA[

    function sayHello() {
      Seam.Component.getInstance("testAction").sayHello(sayHelloCallback);
    }

	function sayHello2() {
      //var name = prompt("What is your name?");
      var name = "Joseph";
	  var user = Seam.Component.newInstance("person");
	  user.setFirstName(name);
	  user.lastName = "Nusairat";
      Seam.Component.getInstance("testAction").sayHello2("Joseph", sayHelloCallback);
    }
    
	// result is based on the STring that is returned from the sayHello method
    function sayHelloCallback(result) {
      alert(result);
    }

    // ]]>
  </script>
  
  <button onclick="javascript:sayHello()">Say Hello</button><br/>
  <button onclick="javascript:sayHello2()">Say Hello 2</button><br/>  
</f:view>
