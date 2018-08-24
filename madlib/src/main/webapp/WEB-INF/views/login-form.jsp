<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Log-in Form</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body id="LoginForm">

<div class="container">

<h1 class="form-heading">${type eq 'admin' ? 'Admin Login' : 'Member Login'}</h1>
<div class="login-form">
<div class="main-div">
    <div class="panel">
    
    
   <p>Please enter your email and password</p>
   </div>
   <!-- ${type eq 'admin' ? '/admin' : '/verify-login'} was using this to set path, but changed to below -->
    <form action="/verify-login/${type }" id="Login" method="post">

        <div class="form-group">
        <c:if test="${not empty loginFailed }">
				<div class="test">
				${loginFailed }
				</div>
			</c:if>


            <input type="email" class="form-control" name="email" id="email" placeholder="Email Address" value="${email }">

        </div>

        <div class="form-group">

            <input type="password" class="form-control" name="password" id="password" placeholder="Password">

        </div>
        
        <!-- Perhaps add this functionality later! Just create another jsp that will 
        updates password for the user matching the email address?
        -->
        <div class="forgot">
        <a href="/reset">Forgot password?</a>
</div>
        <button type="submit" class="btn btn-primary">Login</button>
        <!--  Gives option to register if not a member -->
        <c:if test="${type ne 'admin'}">
		<a href="redirect:/registration">Not a Member? Register><button type="submit" class="btn btn-secondary"></button></a>
    	</c:if>
    	<!-- Gives option to login as member if on admin view but not admin -->
    	<c:if test="${type eq 'admin'}">
		<a href="redirect:/login-form/member">Not admin? Member login><button type="submit" class="btn btn-secondary"></button></a>
    	</c:if>
    </form>
    </div>
</div></div>


</body>
</html>

