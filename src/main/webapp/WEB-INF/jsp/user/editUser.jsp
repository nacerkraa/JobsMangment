<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
	<!--  navbar start -->
	<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp"></jsp:include>
	<!--  navbar end -->
	<div class="container">
	     <div class="row">
		     	<h2>Register Form</h2>
				<form:form class="row g-3" method="POST" action="${pageContext.request.contextPath}/editsaveEtab" modelAttribute="user">
				  <div class="col-md-3">
				    <label for="inputText4" class="form-label">First Name:</label>
				    <form:input path="firstName" type="text" class="form-control" id="inputFirstName" autocomplete="off" required="required" />
				  </div>
				  <div class="col-md-3">
				    <label for="inputText4" class="form-label">Last Name</label>
				    <form:input path="lastName" type="text" class="form-control" id="inputLastName" autocomplete="off" required="required" />
				  </div>
				  <div class="col-md-6">
				    <label for="inputEmail4" class="form-label">Email</label>
				    <form:input path="email" type="email" class="form-control" id="inputEmail" autocomplete="off" required="required" />
				  </div>
				  <div class="col-md-4">
				    <label for="inputPassword4" class="form-label">Password</label>
				    <form:input path="password" type="password" class="form-control" id="inputPassword1" required="required" />
				  </div>
				  <div class="col-4">
				    <label for="inputAddress" class="form-label">Address</label>
				    <form:input path="location" type="text" class="form-control" id="inputAddress" autocomplete="off" placeholder="14 Rue ..." required="required" />
				  </div>
				  <div class="col-4">
				    <label for="inputAddress" class="form-label">Phone Number</label>
				    <form:input path="phone" type="text" class="form-control" id="inputPhone" autocomplete="off" required="required" />
				  </div>
				  <div class="col-2">
				    <label for="inputAddress" class="form-label">Age</label>
				    <form:input path="age" type="number" class="form-control" id="inputAge" autocomplete="off" required="required" />
				  </div>
				  <div class="col-md-2">
				    <label for="inputState" class="form-label">Gender</label>
				    <form:select path="sexe" id="inputState" class="form-select">
				      <form:option path="sexe" value="male">Male</form:option>
				      <form:option path="sexe" value="female">Female</form:option>
				    </form:select>
				  </div>
				  <div class="col-4">
				    <label for="inputType" class="form-label">Type</label>
				    <form:input path="type" type="text" class="form-control" id="inputPhone" autocomplete="off" required="required" />
				  </div>
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Sign in</button>
				  </div>
				</form:form>
			
		</div>
	</div>
	
</body>
</html>