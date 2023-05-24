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
    <title>Dojo Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
			
		<div>
			<a href="/dojos">Dashboard</a>
		</div>
			<div>
			<a href="/ninjas">Register a new Ninja</a>
		</div>
		
		<h1>New Dojo</h1>
		
		
	<form:form class="form" action="/dojos" method="POST" modelAttribute="dojo">

	<div class="form-group row"> 
		<form:label path="location">Location:</form:label>
		<form:input path="location" />
		<form:errors path="location"/>
	</div>
	
		<button type="submit" class="btn btn-primary">Create</button>	
	
	</form:form>
	
	<table class="table">
		<tr class="table-info">
			<th>Location</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach items="${dojos }" var="dojo">
			<tr>
				<td><c:out value="${dojo.location }" /></td>
				<td><a href="/dojos/<c:out value="${dojo.id }"/>">See Students</a></td>
			</tr>
		
		</c:forEach>
	</table>
		
	</div>
</body>
</html>