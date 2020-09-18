<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>   
<html>
    <head>
        <title>Test</title>
        <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/themify-icons.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/elegant-icons.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/owl.carousel.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/nice-select.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/slicknav.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" type="text/css">
      <!-- Js Plugins -->
    <script src="<c:url value='/resources/js/jquery-3.3.1.min.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/resources/js/jquery-ui.min.js' />"></script>
    <script src="<c:url value='/resources/js/jquery.countdown.min.js' />"></script>
    <script src="<c:url value='/resources/js/jquery.nice-select.min.js' />"></script>
    <script src="<c:url value='/resources/js/jquery.zoom.min.js' />"></script>
    <script src="<c:url value='/resources/js/jquery.dd.min.js' />"></script>
    <script src="<c:url value='/resources/js/jquery.slicknav.js' />"></script>
    <script src="<c:url value='/resources/js/owl.carousel.min.js' />"></script>
    <script src="<c:url value='/resources/js/main.js' />"></script>
    </head>
    <body>
    	<div>
    	<tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
    	</div>
    </body>
</html>