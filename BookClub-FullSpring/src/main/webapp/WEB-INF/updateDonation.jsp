<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Donation Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="bg-dark text-light">
	<div class="container mt-5">
	
		<p>Welcome, <c:out value="${userName}" /> </p>
		
		<div>
			<a href="/donations">Back to dashboard</a>
		</div>
		
		<div>
			<a href="/logout">Logout</a>
		</div>
		
		<h1>Edit Donation</h1>
		
		
	<form:form action="/donations/edit/${oneDonation.id }" method="PuT" modelAttribute="oneDonation">
		<form:hidden path="donor" /> <!-- removed the  value="${userId }" since we want the donor to be the same as who created. The person who edits this page can't be the donor. -->
	<div class="form-group mb-3"> 
		<form:label path="donationName">Donation Name</form:label>
		<form:input type="text" path="donationName" />
		<form:errors path="donationName" class="text-danger"/>
	</div>
	
	<div class="form-group mb-3"> 
		<form:label path="quantity" >Quantity</form:label>
		<form:input type="number" path="quantity" />
		<form:errors path="quantity" class="text-danger"/>
	</div>	
	
	<div class="form-group mb-3"> 
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" />
		<form:errors path="description" class="text-danger"/>
	</div>	
	
		<button type="submit" class="btn btn-primary mb-3">Edit</button>	
	
	</form:form>
		
	</div>
</body>
</html>