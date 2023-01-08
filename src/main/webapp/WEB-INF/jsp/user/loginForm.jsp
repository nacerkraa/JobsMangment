<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Name</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
	
	<!--  navbar start -->
	<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp"></jsp:include>
	<!--  navbar end -->
	
    <!-- create HTML Form -->
     <div class="container">
	     <div class="row">
		     <div class="col-md-6 col-md-offset-3">
		     	<h2>Submit Form</h2>
		     	<!-- success message -->
		     	<c:if test = "${errors.message != null}">
			        <div class="alert alert-warning" role="alert">
					  ${errors.message}
					</div>
				 </c:if>
				<form:form class="signup" method="POST" action="/signup" modelAttribute="user">
				
				  <div class="row mb-3">
				    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
				    <div class="col-sm-10">
				      <form:input path="email" type="email" class="form-control" id="inputEmail" autocomplete="off" required="required" />	
				    </div>
				  </div>
				  
				  <div class="row mb-3">
				    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
				    <div class="col-sm-10">
				      <form:input path="password" type="password" class="form-control" id="inputPassword" required="required" />
				    </div>
				  </div>
				  
				  <button type="submit" class="btn btn-primary">Sign in</button>
				</form:form>
		     </div>
		 </div>
     </div>
     
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>