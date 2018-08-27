<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
<title>Home</title>
</head>

<body class="index">
<div class="container">

<h1 class="center">${greeting}!</h1>

<c:if test="${empty user }">
<p class="center"><a href="/registration">Register Here!</a></p>
<p class="center"><a href="/login-form/member">Member Log-in</a></p>
<p class="center"><a href="/login-form/admin">Admin Log-in</a></p>
</c:if>

<c:if test="${not empty user}">
<a class="btn btn-danger" href ="/">Log-out</a>
</c:if>

<h1 class="center">Parlor Treats
<img src="https://upload.wikimedia.org/wikipedia/commons/3/31/Ice_Cream_dessert_02.jpg">
</h1>
	
	
		
		<table class="table table-hover">
			<thead>
			<tr>
			<td><form class="form-inline" action="/" autocomplete="off">
		  <label class="sr-only" for="inlineFormInputName2">Category</label>
		  
		  
		  <%-- prefill a form input using the value attribute. --%>
		  <input type="text" value="${category}" class="form-control mb-2 mr-sm-2" id="category" name="category" placeholder="Category">
		
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  
		  <c:if test="${not empty category}">
		    <%-- c:if determines whether its contents should show or not --%>
		  	<a href="/" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
	  	  
		</form>
		</td>
		</tr>
				<tr>
					<th>Flavor</th><th>Description</th><th>Quantity</th><th>Price</th><th>Category</th><th>Peek</th><th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="iceCream" items="${iceCreams}">
				<tr>
					<td>${iceCream.name} </td>
					<td>${iceCream.description}</td>
					<td>${iceCream.quantity}</td>
					<td>${iceCream.price}</td>
					<td>${iceCream.category}</td>
					<td><img src="${iceCream.image}"/></td>
					
					<c:if test="${type eq 'admin' }">
					<td><button><a href="/show-edit-item/${user.email }/${iceCream.id }">Edit</a></button></td>
					<td><button><a href="/delete-item/${user.email }/${iceCream.id }">Delete</a></button></td>
					</c:if>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:if test="${type eq 'admin' }">
		<button><a href="/show-add-item/${user.email }">Add a new treat</a></button>
		</c:if>
		
	</div>


</body>
</html>

<!-- 
<td>${iceCream.available ? "Yes" : "No" }</td> So I remember how to show yes/no using ternary operator
<button type="submit" value="submit"><a href="/add-form">Add to Form</a></button> -->
