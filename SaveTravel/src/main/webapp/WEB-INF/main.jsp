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
		<h1>Donation List</h1>
		<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation Name</th>
				<th>Donor</th>
				<th>Quantity</th>
				<th colspan = "2">Actions</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="eachDonation" items="${donationList }">
				<tr>
					<td> <c:out value="${eachDonation.id }" /> </td>
					<td> <a href="/donations/${eachDonation.id }"><c:out value="${eachDonation.donationName }" /></a> </td>
					<td> <c:out value="${eachDonation.donor }" /> </td>
					<td> <c:out value="${eachDonation.quantity }" /> </td>
					<td> <a href="/donations/edit/${eachDonation.id }">Edit</a> </td>
					<!-- to delete, we need to use a normal form(not form:form as we are not doing data binding -->
					<td> 	
						<form action="/donations/${eachDonation.id }" method="POST">
							<input type="hidden" name="_method" value="DELETE" /> <!-- to cast from POST to DELETE method, we use hidden input. -->
							<button type="submit">Delete</button>
						
						</form>
					</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	
	
	<h1>Create a donation</h1>
	
	
		<form:form action="/process" method="POST" modelAttribute="newDonation">

			<p> 
				<form:label path="donationName">Donation Name</form:label>
				<form:input type="text" path="donationName" class="form-control" />
				<form:errors path="donationName"/>
			</p>
			
			<p> 
				<form:label path="donor">Donor</form:label>
				<form:input type="text" path="donor"  class="form-control" />
				<form:errors path="donor"/>
			</p>	
			
			<p> 
				<form:label path="quantity" >Quantity</form:label>
				<form:input type="number" path="quantity"  class="form-control" />
				<form:errors path="quantity"/>
			</p>	
			
			<p> 
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description"  class="form-control" />
				<form:errors path="description"/>
			</p>	
			
				<button type="submit" class="btn btn-primary">Submit</button>	
	
		</form:form>
	
	</div>
   
</body>
</html>

