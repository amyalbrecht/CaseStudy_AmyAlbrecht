<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>All Albums</title>

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

        @media (min-width: 768px) {
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



        <p><h2>All Albums</h2></p>
        
        <div class="album py-5 bg-blue">
            <div class="container">

                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    <%-- forEach test --%>
					<c:forEach items="${albumList}" var="album" >
					<div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text">Album Name: ${album.albumName}</p>
                                   	<form action="album1" method="POST">
                                   		<input name="id" value="Go to Album" type="button" onClick="window.location='<%=request.getContextPath()%>/album1/${album.albumId}'">
                                   	</form>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    
                    <%--
                    <!--Album #1-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #1</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #2-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #2</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #3-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #3</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #4-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #4</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #5-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #5</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #6-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #6</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #7-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #7</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #8-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #8</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Album #9-->
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="../resources/images/excavator.jpg">
                            <div class="card-body bg-orange">  
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <p class="card-text"><a href="#">Album #9</a></p>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

--%>






    </main>


</body>

</html>