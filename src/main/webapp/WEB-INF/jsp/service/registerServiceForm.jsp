<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Service Form</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
	<!--  navbar start -->
	<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp"></jsp:include>
	<!--  navbar end -->
	<div class="container">
	     <div class="row">
		     	<h2>Add Service</h2>
				<form:form class="row g-3" method="POST" action="/addService" modelAttribute="service">
				  <div class="col-md-3">
				    <label for="inputText4" class="form-label">Name of The Service:</label>
				    <form:input path="title" type="text" class="form-control" id="idTitle" autocomplete="off" required="required" />
				  </div>
				  <div class="col-md-3">
				    <label for="inputText4" class="form-label">Description: </label>
				    <form:input path="description" type="text" class="form-control" id="inputDescription" autocomplete="off" required="required" />
				  </div>
				  
				  <div class="col-md-6">
				    <label for="inputEmail4" class="form-label">Location:</label>
				    <form:input path="location" type="text" class="form-control" id="inputEmail" autocomplete="off" required="required"  />
				  </div>
				  
				  <div class="col-md-6">
				    <form:input path="emailUser" type="hidden"  value="${sessionScope.email}" class="form-control" id="inputEmail" autocomplete="off" required="required" />
				  </div>
		
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Add Service</button>
				  </div>
				</form:form>
			
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>