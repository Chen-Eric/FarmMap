<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
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

<title>My JSP 'map.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- This line the key point to call the Struts2-jQuery-Plugin -->
<sj:head jqueryui="true" jquerytheme="smoothness" />

<link rel="stylesheet" type="text/css" href="CSS/button.css">
<link rel="stylesheet" type="text/css" href="CSS/mapPage.css">

<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=false">
	
</script>
<script type="text/javascript"
	src="JavaScript/v3_epoly_sphericalArea.js">
	
</script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?libraries=geometry&sensor=false">
	
</script>

<script type="text/javascript" src="JavaScript/maplabel.js"></script>

<!-- My JavaScript -->
<script type="text/javascript" src="JavaScript/Control.js"></script>
<script type="text/javascript" src="JavaScript/InfoWindow.js"></script>
<script type="text/javascript" src="JavaScript/Map.js"></script>
<script type="text/javascript" src="JavaScript/Paddock.js"></script>

<script type="text/javascript">
	
</script>

</head>

<body onload="initialize()">
	<div id="PageBody">
		<div id="Sidebar" align="center">
			<table border="0">
			<tr>
			<td>
			<p align="center">
				<button class="button white" onclick="forwardPage('index')">Home</button>
			</p>
			</td>
			<td>
			<p align="center">
				<button class="button blue" onclick="forwardPage('manage')">Manage&nbsp;Paddocks</button>
			</p>
			</td>
			<td>
			<p align="center">
				<button class="button red" onclick="exit()">Exit</button>
			</p>
			</td>
			</tr>
			</table>
			
			<!-- All web page components for paddock CRUD functionality. -->
			<jsp:include page="paddockEdit.jsp"/>
			
			
			<div class="paddockInfoDIV">
				<jsp:include page="paddockInfo.jsp" />				
			</div>		
		</div>
		<div id="map_canvas" />
	</div>
	<div>
		<s:debug/>
	</div>
</body>
</html>
