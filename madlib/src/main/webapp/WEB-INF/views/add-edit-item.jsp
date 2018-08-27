<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="/style-two.css" />
<title>${action }</title>
</head>

 <button class="btn btn-warning"><a href="/verify-login/admin?email=${user.email }&password=${user.password}">Back to Home Page</a></button>
<body>
 <div class="container">
 <!---heading---->
     <header class="heading"> Administrator ${user.firstName } <br /> ${action } Item</header><hr></hr>
	<!---Form starting----> 
	<form action="${action eq 'Add' ? '/add' : '/edit' }-item/${user.email}/${iceCream.id}" method="post">
	<div class="row ">
	 <!--- For Name---->
         <div class="col-sm-12">
             <div class="row">
			     <div class="col-xs-4">
          	         <label class="firstname">Name :</label> </div>
		         <div class="col-xs-8">
		             <input type="text" name= "name" id="fname" placeholder="Item name" class="form-control " value="${iceCream.name }">
             </div>
		      </div>
		 </div>
		 
		 
         <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
                     <label class="lastname">Description :</label></div>
				<div class ="col-xs-8">	 
		             <input type="text" name= "description" id="lname" placeholder="Description" class="form-control last" value="${iceCream.description }">
                </div>
		     </div>
		 </div>
     <!-----For email---->
		 <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
		             <label class="mail" >Quantity :</label></div>
			     <div class="col-xs-8"	>	 
			          <input type="number" name="quantity"  id="email" placeholder="Enter quantity" class="form-control" value="${iceCream.quantity }">
		         </div>
		     </div>
		 </div>
	 <!-----For Password and confirm password---->
          <div class="col-sm-12">
		         <div class="row">
				     <div class="col-xs-4">
		 	              <label class="pass">Price :</label></div>
				  <div class="col-xs-8">
			             <input type="float" name="price" id="password" placeholder="Enter item price" class="form-control" value="${iceCream.price }">
				 </div>
          </div>
		  </div>
		  
     <!-----------For Image-------->
     <div class="col-sm-12">
		     <div class="row">
			     <div class="col-xs-4">
                     <label class="lastname">Image :</label></div>
				<div class ="col-xs-8">	 
		             <input type="text" name="image" id="lname" placeholder="Image url" class="form-control last" value="${iceCream.image }">
                </div>
		     </div>
		 </div>
		 <!-- For Category -->
		 
         <div class="col-sm-12 mt-4">
		     <div class ="row">
                 <div class="col-xs-3 ">
			       <label class="gender">Category:</label>
				 </div>
			 
			     <div class="col-xs-3 male">	 
				    <label><input type="radio" name="category"  id="gender" value="milkshake"/>Milkshake</label>
				 </div>
				 
				 <div class="col-xs-3 female">
				     <label><input type="radio"  name="category" id="gender" value="icecream" >Ice-cream</label>
			     </div>
			     
			     <div class="col-xs-3 female">
				     <label><input type="radio"  name="category" id="gender" value="sundae" >Sundae</label>
			     </div>
			
		  	 </div>
		     <div class="col-sm-12">
		         <button type="submit" class="btn btn-warning">Submit</button>
		   </div>
		 </div>
	 </div>	 
		 		 
		</form> 
</div>

</body>		
</html>
	 
	 