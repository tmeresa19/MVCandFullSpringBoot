<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create a donation</h1>
	
	<form:form action="/donations/new" method="POST" modelAttribute="newDonation">

	<p> 
		<form:label path="donationName">Donation Name</form:label>
		<form:input type="text" path="donationName" />
		<form:errors path="donationName"/>
	</p>
	
	<p> 
		<form:label path="donor">Donor</form:label>
		<form:input type="text" path="donor" />
		<form:errors path="donor"/>
	</p>	
	
	<p> 
		<form:label path="quantity" >Quantity</form:label>
		<form:input type="number" path="quantity" />
		<form:errors path="quantity"/>
	</p>	
	
	<p> 
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" />
		<form:errors path="description"/>
	</p>	
	
		<button type="submit">Submit</button>	
	
	</form:form>

</body>
</html>