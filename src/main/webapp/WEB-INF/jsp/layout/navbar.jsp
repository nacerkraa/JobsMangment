<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- create navigation bar -->
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">Brand</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">About us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Other Services</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>

      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      	<c:if test="${sessionScope.User == null}">
      		<li class="nav-item">
	          <button type="button" class="btn btn-primary btn-sm me-3"> <a class="nav-link active" aria-current="page" href="/register">Register</a></button>
	        </li>
	        <li class="nav-item">
	          <button type="button" class="btn btn-outline-primary btn-sm"> <a class="nav-link active" aria-current="page" href="/login">Login</a></button>
	        </li>
	        
        </c:if>
        <c:if test="${sessionScope.User != null}">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            User: ${sessionScope.firstname}
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">Profile</a></li>
	            <li><a class="dropdown-item" href="#">Edit Profile</a></li>
	            <li><a class="dropdown-item" href="addService">Add a New Service</a></li>
	            <li><a class="dropdown-item" href="listServices">Your Services</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="/logout">Logout</a></li>
	          </ul>
	        </li>
	    </c:if>
      </ul>
    </div>
  </div>
</nav>
<br><br/>