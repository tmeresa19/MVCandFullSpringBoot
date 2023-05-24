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
<body>
	<div class="container mt-5">

		<div>
			<a href="/">Back to dashboard</a>
		</div>
	
		<h1>Details Page</h1>
		
		<h3> ID: <c:out value="${oneDonation.id }"> </c:out> </h3>
		<h3> Donation Name: <c:out value="${oneDonation.donationName }"> </c:out> </h3>
		<h3> Donor: <c:out value="${oneDonation.donor }"> </c:out> </h3>
		<h3> Amount Spent: <c:out value="${oneDonation.amountSpent }"> </c:out> </h3>
	</div>
</body>
</html>