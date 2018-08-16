<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<style>

body {
background-color: #4ABDAC;
}

form {
background-color: #FC4A1A;
}

h1 {
margin: 40px;
}

</style>
<body>

<h2>Let's get you registered!</h2>

<form action="/summary" method="post">
<fieldset>
<legend>Registration</legend>

<p>
<label for="firstName">First Name:</label>
<input type="text" name="firstName" id="firstName" required>
</p>

<p>
<label for="lastName">Last Name:</label>
<input type="text" name="lastName" id="lastName" required>
</p>

<p>
<label for="email">Email:</label>
<input type="email" name="email" id="email" placeholder="user@gmail.com" required>
</p>

<p>
<label for="email">PhoneNum:</label>
<input type="text" name="phoneNum" id="phoneNum" placeholder="###-###-####" required>
</p>

<p>
<label for="email">Password:</label>
<input type="password" name="password" id="password" required>
</p>

<p>
<input type="radio" name= "user" id="student" value="student">
<label for="student">Student</label>
</p>

<p>
<input type="radio" name="user" id="admin" value="admin">
<label for="admin">Admin</label>
</p>


<button type="submit" value="Submit">Submit</button>


</fieldset>
</form>

</body>
</html>