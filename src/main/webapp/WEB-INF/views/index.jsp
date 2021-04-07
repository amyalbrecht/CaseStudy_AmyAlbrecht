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



				<!--Carousel: figure out later-->
				<!-- <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active" style="background-image:url(../resources/images/excavator.jpg);">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg> 
            <img src="../resources/images/excavator.jpg" class="d-block w-100" alt="image of Max">
            <div class="container">
              
              <div class="carousel-caption text-start">
                 <h1>Example headline.</h1>
                <p>Some representative placeholder content for the first slide of the carousel.</p>
                <p><a class="btn btn-lg btn-primary" href="#">Sign up today</a></p> 
              </div>
            </div> 
          </div>
          <div class="carousel-item">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>
    
            <div class="container">
              <div class="carousel-caption">
                <h1>Another example headline.</h1>
                <p>Some representative placeholder content for the second slide of the carousel.</p>
                <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>
    
            <div class="container">
              <div class="carousel-caption text-end">
                <h1>One more for good measure.</h1>
                <p>Some representative placeholder content for the third slide of this carousel.</p>
                <p><a class="btn btn-lg btn-primary" href="#">Browse gallery</a></p>
              </div>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div> -->

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
								location.href = "#";
							}
						</script>
					</div>
					<div class="indexGoTo">
						<br> <br>
						<button id="goToAlbumsButton">Albums</button>
						<script type="text/javascript">
							document.getElementById("goToAlbumsButton").onclick = function () {
								location.href = "#";
							}
						</script>
					</div>
					<div class="indexGoTo">
						<br> <br>
						<button id="goToAddPhotosButton">Add Photos</button>
						<script type="text/javascript">
							document.getElementById("goToAddPhotosButton").onclick = function () {
								location.href = "addPhoto";
							}
						</script>
					</div>

				</div>





		</main>


	</body>

	</html>