<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Services</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<!--  navbar start -->
	<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp"></jsp:include>
	<!--  navbar end -->
	<div class="container">
	<button type="button" class="btn btn-outline-primary btn-sm"> <a class="nav-link active" aria-current="page" href="/addService">Add Service +</a></button>
	<br>
	<h2>List Of Services: </h2>
	
	<table class="table table-striped table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Title</th>
	      <th scope="col">Description</th>
	      <th scope="col">Location</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="service" items="${services}">
	  	
	  	<c:if test = "${sessionScope.email == service.emailUser}">
			<tr>
		      <th scope="row">${service.title}</th>
			  <td>${service.description}</td>
			  <td>${service.location}</td>
		      <td><span class="action ajuter"><a href="editService/${service.id}">Edit</a></span><span class="action suprimer">&nbsp;<a href="deleteService/${service.id}">Suprimer</a></span></td>
		    </tr>
		</c:if>
	   </c:forEach>
	  </tbody>
	</table>
	</div>
	
	 
	</div>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>