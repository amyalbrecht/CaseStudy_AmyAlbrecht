<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Photo Album</title>

<!-- BOOTSTRAP 5.0.0-beta3 EXTERNAL LINKS -->


<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="../css/main.css">

<!-- /BOOTSTRAP 5.0.0-beta3 EXTERNAL LINKS -->

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.bg-orange {
	background-color: #ed7d3e !important;
	text-align: left;
}

.bg-blue {
	background-color: #6486c4;
	text-align: center;
}

.navBreadCrumbs {
	text-align: center;
	display: inline-flex;
}

.indexFlexBox {
	display: flex;
}

.indexGoTo {
	margin: 10%;
	padding: 5%;
	background-color: #ed7d3e;
}
</style>



</head>

<body class="bg-blue">

	<main>

		<%@include file="header.jsp"%>

		<p>
		<h2>Album Name: ${album.albumName}</h2>
		</p>



		<div class="album py-5 bg-blue">
			<div class="container">

				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

					<c:forEach items="${photoList}" var="photo">
						<div class="col">
							<div class="card shadow-sm">

								<img src="/resources/images/${photo.photoFileName}">

								<div class="card-body bg-orange">
									<p class="card-text">Caption: ${photo.caption}</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<%-- <button type="button" class="btn btn-sm btn-outline-secondary" id="goToEditPhotoButton">Edit</button>--%>

											<form action="editPhoto" method="POST">
												<input name="id" value="Edit" type="button"
													class="btn btn-sm btn-outline-secondary"
													onClick="window.location.href='editPhoto/${photo.photoId}'">
											</form>


											<%-- 
										<script type="text/javascript">
											document.getElementById("goToEditPhotoButton").onclick = function () {
											location.href = "editPhoto";
											}
											</script>--%>

										</div>
										<small class="text-muted"> Tags: <c:forEach
												items="${photo.pTags}" var="pTag">
										
										${pTag.tagName},
										
										</c:forEach>
										</small>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>



					<%-- 
					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#55595c" />
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
              </svg>

							<div class="card-body bg-orange">
								<p class="card-text">Caption: This is a wider card with
									supporting text below as a natural lead-in to additional
									content. This content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-muted">Tags: tag1, tag2, tag 3 </small>
								</div>
							</div>
						</div>
					</div>
					--%>


				</div>
			</div>
		</div>








	</main>


</body>

</html>