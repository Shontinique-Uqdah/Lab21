<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Registration</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>


<body>
<div class="container">

<h2>Let's get you registered!</h2>

<form action="/summary" method="post" class="form-inline change-color">

<fieldset class="form-group">
<legend>Who are you?</legend>

<div class="form-group row">
    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
    <div class="col-sm-10">
      <input type="text" name="firstName" class="form-control" id="firstName" required value="${firstName }">
    </div>
    
  </div>
  <div class="form-group row">
    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
    <div class="col-sm-10">
      <input type="text" name ="lastName" class="form-control" id="lastName" required value="${lastName }">
    </div>
  </div>
  </fieldset>

<fieldset class="form-group">
<legend>Contact</legend>
<div class="form-group row mb-2">
    <label for="email" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" name="email" class="form-control" id="email" placeholder="user@gmail.com" required value="${email }">
    </div>
    
  </div>  
<div class="form-group row">
<label for="phoneNum" class="col-sm-2 col-form-label">PhoneNum</label>
<div class="col-sm-10">
<input type="text" name="phoneNum" id="phoneNum" class="form-control" placeholder="###-###-####" pattern="[0-9]{3}-{0,1}[0-9]{3}-{0,1}[0-9]{4}" required value="${phoneNum }">
</div>
</div>
</fieldset>

<fieldset class="form-group">
<legend>Security</legend>


<c:if test="${not empty passwordTest }">
<div class="test">
${passwordTest }
</div>
</c:if>


<div class="form-group row mb-2">
    <label for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name ="password1" class="form-control" id="password1" placeholder="Password" pattern=".{6,}" title="Six or more characters" required>
    </div>
  </div>
  <div class="form-group row mb-2">
    <label for="password" class="col-sm-2 col-form-label">Confirm Password</label>
    <div class="col-sm-10">
      <input type="password" name ="password2" class="form-control" id="password2" placeholder="Re-enter Password" pattern=".{6,}" title="Six or more characters" required>
    </div>
  </div>
  </fieldset>

<fieldset class="form-group mt-4">
<legend>Additional Details</legend>
<div class="row">

<div class="form-group row mb-2">
    <label for="birthdate" class="col-sm-2 col-form-label">Birthdate</label>
    <div class="col-sm-10">
      <input type="date" name="birthdate" class="form-control" id="birthdate" required value="${birthdate }">
    </div>
    </div>
    </div>
    
    <div class="row">

      <div class="col-sm-10 mt-4">
      <p class="col-form-label col-sm-2">Gender</p>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gender" id="female" value="female" checked>
          <label class="form-check-label" for="female">
            Female
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gender" id="male" value="male">
          <label class="form-check-label" for="male">
            Male
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gender" id="nonbinary" value="nonbinary">
          <label class="form-check-label" for="nonbinary">
            Non-binary
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gender" id="private" value="private">
          <label class="form-check-label" for="private">
            Prefer Not to Say
          </label>
        </div>
      </div>
    </div>
    </fieldset>
     

<fieldset class="form-group ml-5">
<legend>Dietary Concerns</legend>

<div class="form-group row">
    <div class="col-sm-2">Allergies</div>
    <div class="col-sm-10">
      <div class="form-check">
        <input class="form-check-input" name= "allergies" type="checkbox" id="chocolate" value="chocolate">
        <label class="form-check-label" for="chocolate">
          Chocolate
        </label>
        </div>
        <div class="form-check">
         <input class="form-check-input" name= "allergies" type="checkbox" id="soy" value="soy">
        <label class="form-check-label" for="soy">
          Soy
        </label>
        </div>
        
        <div class="form-check">
         <input class="form-check-input" name= "allergies" type="checkbox" id="nuts" value="nuts">
        <label class="form-check-label" for="nuts">
          Nuts
        </label>
        </div>
        
        <div class="form-check">
         <input class="form-check-input" name= "allergies" type="checkbox" id="gluten" value="gluten">
        <label class="form-check-label" for="gluten">
          Gluten
        </label>
      </div>
    </div>
  </div>
  </fieldset>
 
  
  <div class="form-group row ml-2">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Register</button>
    </div>
  </div>

</form>
</div>

</body>

</html>

<!-- 


 -->