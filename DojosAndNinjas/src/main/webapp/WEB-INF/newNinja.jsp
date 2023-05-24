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
			<a href="dojos">Dashboard</a>
		</div>
		
		<h1>Create New Ninja</h1>
		
		
	<form:form class="form" action="/ninjas" method="POST" modelAttribute="ninja">

	<div class="form-group row"> 
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName" />
		<form:errors path="firstName"/>
	</div>
	
		<div class="form-group row"> 
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" />
		<form:errors path="lastName"/>
	</div>	
	
	<div class="form-group row">
		<form:label path="dojo">Select Dojo</form:label>
		<form:select path="dojo" class="input">
			 <c:forEach var="dojo" items="${dojos}">
				<form:option value="${dojo.id}"><c:out value="${dojo.location}"/></form:option>
			 </c:forEach>
		</form:select>
	</div>
	
	
		<button type="submit" class="btn btn-primary">Create</button>	
	
	</form:form>
		
	</div>
</body>
</html>