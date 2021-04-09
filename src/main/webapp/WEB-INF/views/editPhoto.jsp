<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Photo</title>

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


    <div>
        <p><h2>Edit Photo</h2></p>
        <div>
            <img src="/photos/resources/images/${photo.photoFileName}" width=40% height=40%>
        </div>
        <br><br>
        <form action="saveEditedPhoto" method="POST">
            <input value="${photo.photoId}" type="hidden" name="photoId"/>
             
            <label>Album: </label>
            <form:select path="pAlbum">
						<form:options name="pAlbum" items="${pAlbum}" itemValue="albumId" itemLabel="albumName"/> 
                
            </form:select>
           
            
            <label>Caption: </label><input type="text" name="caption" value="${photo.caption}"><br><br>
            <label>Tags: </label><input type="text" name="tag" 
            						value="<c:forEach items='${photo.pTags}' var='pTag'> ${pTag.tagName}, </c:forEach>"><br><br>
            <input type="submit" value="Submit" name="submit">
        </form>
        <br><br>
        <form method="POST" action="deletePhoto/${photo.photoId}">
        	<input type="submit" value="Delete" name="submit">
        </form>
        
        
        
        
        
    </div>

    <footer></footer>
    

</main>

</body>

</html>