<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Details Page</h1>
	
	<h3> ID: <c:out value="${oneDonation.id }"> </c:out> </h3>
	<h3> Donation Name: <c:out value="${oneDonation.donationName }"> </c:out> </h3>
	<h3> Donor: <c:out value="${oneDonation.donor }"> </c:out> </h3>
	<h3> Quantity: <c:out value="${oneDonation.quantity }"> </c:out> </h3>
	
</body>
</html>