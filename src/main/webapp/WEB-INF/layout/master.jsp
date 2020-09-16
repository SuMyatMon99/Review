<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>   
<html>
    <head>
        <title>Test</title>
        <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<c:url value='/bootstrap.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/font-awesome.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/themify-icons.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/elegant-icons.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/owl.carousel.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/nice-select.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/jquery-ui.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/slicknav.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/style.css' />" type="text/css">
      <!-- Js Plugins -->
    <script src="<c:url value='/jquery-3.3.1.min.js' />"></script>
    <script src="<c:url value='/bootstrap.min.js' />"></script>
    <script src="<c:url value='/jquery-ui.min.js' />"></script>
    <script src="<c:url value='/jquery.countdown.min.js' />"></script>
    <script src="<c:url value='/jquery.nice-select.min.js' />"></script>
    <script src="<c:url value='/jquery.zoom.min.js' />"></script>
    <script src="<c:url value='/jquery.dd.min.js' />"></script>
    <script src="<c:url value='/jquery.slicknav.js' />"></script>
    <script src="<c:url value='/owl.carousel.min.js' />"></script>
    <script src="<c:url value='/main.js' />"></script>
    </head>
    <body>
    	<div>
    	<tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
    	</div>
        
     
    </body>
</html>