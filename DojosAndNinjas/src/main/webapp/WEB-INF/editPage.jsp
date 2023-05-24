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
    <title>Expense Page</title>
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
		<h1>Edit expense</h1>
		<form:form action="/expenses/edit/${oneExpense.id}" method="PUT" modelAttribute="oneExpense">
		<!-- I can also use: action="/expenses/edit/{id}" since I already used @PathVariable -->
	
			<div class="form-group">
				<form:label path="expenseName">Expense Name</form:label>
				<form:input path="expenseName" class="form-control" />
				<form:errors path="expenseName"/>
			</div>
			
			<div class="form-group"> 
				<form:label path="vendor">Vendor</form:label>
				<form:input path="vendor"  class="form-control" />
				<form:errors path="vendor"/>
			</div>	
			
			<div class="form-group"> 
				<form:label path="amountSpent" >Amount</form:label>
				<form:input type="number" path="amountSpent"  class="form-control" />
				<form:errors path="amountSpent"/>
			</div>	
			
			<div class="form-group"> 
				<form:label path="description">Description</form:label>
				<form:textarea path="description"  class="form-control"></form:textarea>
				<form:errors path="description"/>
			</div>	
			<button type="submit" class="btn btn-success">Edit</button>	
		
		</form:form>
	</div>
</body>
</html>