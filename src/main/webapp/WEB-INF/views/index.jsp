<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Max's Photo Album</title>

		<!-- BOOTSTRAP 5.0.0-beta3 EXTERNAL LINKS -->


		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
			crossorigin="anonymous"></script>

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<!-- Custom styles for this template -->
		<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/">
		<link href="../css/carousel.css" rel="stylesheet">
		<link href="../css/carousel.rtl.css" rel="stylesheet">
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

			@media (min-width : 768px) {
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

			<%@include file="header.jsp" %>



				<!--Bootstrap Carousel: placeholder, to be added later-->

				<p>
				<h1>Max's Photos</h1>
				</p>
				<br>
				<br>

				<h3>Welcome!</h3>
				<br>
				<br>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
					eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
					ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
					aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur.</p>

				<div class="indexFlexBox">
					<div class="indexGoTo">
						<br> <br>
						<button id="goToAboutButton">About</button>
						<script type="text/javascript">
							document.getElementById("goToAboutButton").onclick = function () {
								location.href = "about";
							}
						</script>
					</div>
					<div class="indexGoTo">
						<br> <br>
						<button id="goToAlbumsButton">Albums</button>
						<script type="text/javascript">
							document.getElementById("goToAlbumsButton").onclick = function () {
								location.href = "allAlbums";
							}
						</script>
					</div>
					<div class="indexGoTo">
						<br> <br>
						<button id="goToAddPhotoButton">Add Photo</button>
						<script type="text/javascript">
							document.getElementById("goToAddPhotoButton").onclick = function () {
								location.href = "addPhoto";
							}
						</script>
					</div>

				</div>





		</main>


	</body>

	</html>