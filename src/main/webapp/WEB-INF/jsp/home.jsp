<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home | Page</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
	
	<!--  navbar start -->
	<jsp:include page="/WEB-INF/jsp/layout/navbar.jsp"></jsp:include>
	<!--  navbar end -->
	
	<!--  content start -->
	<div class="container">
			<c:if test = "${messages.message != null}">
		        <div class="alert alert-success" role="alert">
				  ${messages.message}
				</div>
		 	</c:if>
	     <h2 align="center"> Hello User!</h2>
	    <c:if test="${sessionScope.User != null}">
			<a href="/addService">Add Service</a>
	    </c:if>
	     <p align="center">This is Home page</p>
	   </div>
     <!--  content end -->
    	
     
     <!--  footer start -->
		<jsp:include page="/WEB-INF/jsp/layout/footer.jsp"></jsp:include>
	<!--  footer end -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>