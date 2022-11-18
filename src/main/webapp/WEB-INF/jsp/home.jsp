<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Name</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
	     <p align="center">This is Home page</p>
	   </div>
     <!--  content end -->
    
     
     <!--  footer start -->
		<jsp:include page="/WEB-INF/jsp/layout/footer.jsp"></jsp:include>
	<!--  footer end -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>