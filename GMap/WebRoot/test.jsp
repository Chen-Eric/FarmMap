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
<link rel="stylesheet" type="text/css" href="CSS/page.css">

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

<script type="text/javascript" src="JavaScript/jquery.flip.js"></script>
<script type="text/javascript" src="JavaScript/jquery-ui-1.9.1.custom.min.js"></script>

<!-- My JavaScript -->
<script type="text/javascript" src="JavaScript/Control.js"></script>
<script type="text/javascript" src="JavaScript/InfoWindow.js"></script>
<script type="text/javascript" src="JavaScript/Map.js"></script>
<script type="text/javascript" src="JavaScript/Paddock.js"></script>
<script type="text/javascript" src="JavaScript/Navigation.js"></script>





<script type="text/javascript" src="JavaScript/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="JavaScript/grid.locale-en.js"></script>

<script type="text/javascript">
	
</script>

</head>

<body onload="initialize()">
	<div id="PageBody">
		<div id="Sidebar">
			<p align="center">
				<button class="button blue" onclick="forwardPage('manage')">Manage&nbsp;Paddocks</button>
			</p>
			<p align="center">
				<button class="button orange" onclick="completePaddock()">Complete&nbsp;Paddock</button>
			</p>
			<p align="center">
				<button class="button green" onclick="startNewPaddock()">Add&nbsp;Paddock</button>
			</p>
			<p align="center">
				<button class="button red" onclick="deleteSelectedPaddock()">Delete&nbsp;Paddock</button>
			</p>
			<p align="center">
				<button class="button rosy" onclick="undoLastMark()">Remove&nbsp;Last&nbsp;Corner</button>
			</p>
			<p align="center">
				<button class="button green"	onclick="mapManageFlip()">Map&nbsp;Manage</button>
			</p>
			<p align="center">
				<button class="button white"	onclick="stockTypeManageFlip()">Stock&nbsp;Type&nbsp;Manage</button>
			</p>
			<div class='tabular-data'>
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