<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>


<nav class="navbar navbar-dark bg-orange"
	aria-label="First navbar example">
	<div class="container-fluid bg-orange">
		<a class="navbar-brand" href="#">Max's Photos</a>
		<div>
			<a href="#">Not (User)?</a> | <a href="#">Login</a> | <a href="#">Register</a>
		</div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarsExample01" aria-controls="navbarsExample01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample01">
			<ul class="navbar-nav me-auto mb-2">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value = "/about"/>">About</a></li>
				<li class="nav-item"><a class="nav-link" href="allAlbums">Albums</a></li>
				<li class="nav-item"><a class="nav-link" href="/addPhoto">Add Photo</a></li>
			</ul>
		</div>
	</div>
</nav>

