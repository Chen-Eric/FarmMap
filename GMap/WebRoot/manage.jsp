<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Grazing and so on...</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="CSS/button.css">
<link rel="stylesheet" type="text/css" href="CSS/managePage.css">
<link rel="stylesheet" type="text/css" href="CSS/ui.jqgrid.css">

<!-- This line the key point to call the Struts2-jQuery-Plugin -->
<sj:head jqueryui="true" jquerytheme="smoothness" />

<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=false">
	
</script>

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?libraries=geometry&sensor=false">
	
</script>
<script type="text/javascript"
	src="JavaScript/v3_epoly_sphericalArea.js">
	
</script>

<script type="text/javascript" src="JavaScript/maplabel.js"></script>
<script type="text/javascript" src="JavaScript/maplabel-compiled.js"></script>


<!-- My JavaScript -->
<script type="text/javascript" src="JavaScript/Control.js"></script>
<script type="text/javascript" src="JavaScript/InfoWindow.js"></script>
<script type="text/javascript" src="JavaScript/Map.js"></script>
<script type="text/javascript" src="JavaScript/Paddock.js"></script>
<script type="text/javascript" src="JavaScript/Icon.js"></script>

<!-- js library for jqGrid
<script type="text/javascript" src="JavaScript/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="JavaScript/grid.locale-en.js"></script>
 -->

</head>
<body onload="initialize()">
	<div id="PageBody">
		<div id="Sidebar">
			<table align="center">
				<tr>
					<td>
						<p align="center">
							<button class="button white" onclick="forwardPage('index')">Home</button>
						</p></td>
					<td>
						<p align="center">
							<button class="button green" onclick="forwardPage('welcome')">Welcome&nbsp;Page</button>
						</p></td>
					<td>
						<p align="center">
							<button class="button blue" onclick="forwardPage('map')">Manage&nbsp;Map</button>
						</p></td>
					<td>
						<p align="center">
							<button class="button red" onclick="exit()">Exit&nbsp;Farm</button>
						</p></td>
				</tr>
			</table>
			<div class="paddockTodoDIV">
				<jsp:include page="paddockTodo.jsp" />
			</div>
			<!-- 
				
			 -->
		</div>
		<div id="map_canvas"></div>
	</div>
	<table id="realtest"></table>
	<div id="pager2"></div>
</body>
</html>
