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
<body>
<div class="container">
<h1 style = "text-align: center;">${greeting}!</h1>
<p style= "text-align: center;"><a href="/registration">Register Here!</a></p>

<h1>Parlor Treats</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Flavor</th><th>Description</th><th>Quantity</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="iceCream" items="${iceCreams}">
				<tr>
					<td>${iceCream.name} </td>
					<td>${iceCream.description}</td>
					<td>${iceCream.quantity}</td>
					<td>${iceCream.price}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>


</body>
</html>

<!-- 
<td>${iceCream.available ? "Yes" : "No" }</td> So I remember how to show yes/no using ternary operator
<button type="submit" value="submit"><a href="/add-form">Add to Form</a></button> -->
