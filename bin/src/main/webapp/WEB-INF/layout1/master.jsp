<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>   
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/fontawesome-free/css/all.min.css' />" >
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css' />" >
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css' />" >
  <!-- JQVMap -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/jqvmap/jqvmap.min.css' />" >
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value='/resources/dist/css/adminlte.min.css' />" >
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css' />" >
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/daterangepicker/daterangepicker.css' />" >
  <!-- summernote -->
  <link rel="stylesheet" href="<c:url value='/resources/plugins/summernote/summernote-bs4.min.css' />" >
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    	<tiles:insertAttribute name="header" />
    	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
        <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    	</div>
    	<script src="<c:url value='/resources/plugins/jquery/jquery.min.js' />" ></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value='/resources/plugins/jquery-ui/jquery-ui.min.js' />" ></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<c:url value='/resources/plugins/bootstrap/js/bootstrap.bundle.min.js' />" ></script>
<!-- ChartJS -->
<script src="<c:url value='/resources/plugins/chart.js/Chart.min.js' />" ></script>
<!-- Sparkline -->
<script src="<c:url value='/resources/plugins/sparklines/sparkline.js' />" ></script>
<!-- JQVMap -->
<script src="<c:url value='/resources/plugins/jqvmap/jquery.vmap.min.js' />" ></script>
<script src="<c:url value='/resources/plugins/jqvmap/maps/jquery.vmap.usa.js' />" ></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value='/resources/plugins/jquery-knob/jquery.knob.min.js' />" ></script>
<!-- daterangepicker -->
<script src="<c:url value='/resources/plugins/moment/moment.min.js' />" ></script>
<script src="<c:url value='/resources/plugins/daterangepicker/daterangepicker.js' />" ></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<c:url value='/resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js' />"></script>
<!-- Summernote -->
<script src="<c:url value='/resources/plugins/summernote/summernote-bs4.min.js' />" ></script>
<!-- overlayScrollbars -->
<script src="<c:url value='/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js' />" ></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/adminlte.js' />" ></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value='/resources/dist/js/demo.js' />"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value='/resources/dist/js/pages/dashboard.js' />" ></script>
    </body>
</html>