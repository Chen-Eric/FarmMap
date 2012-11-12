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
<link rel="stylesheet" type="text/css" href="CSS/page.css">
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


<script type="text/javascript" src="JavaScript/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="JavaScript/grid.locale-en.js"></script>

</head>
<body onload="initialize()">
	<div id="PageBody">
		<div id="Sidebar">
			<p align="center">
				<button class="button green" onclick="forwardPage('index')">Index&nbsp;Page</button>
			</p>
			<p align="center">
				<button class="button blue" onclick="forwardPage('map')">Manage&nbsp;Map</button>
			</p>
			<p align="center">
				<button class="button orange" onclick="jqTest()">Paddock&nbsp;Table</button>
			</p>
			<p align="center">
				<button class="button rosy" onclick="paddockBasicInfoManager()">Info&nbsp;Window</button>
			</p>
			<div id="Infowindow">
				<sj:tabbedpanel id="infotabs" spinner="Loading...">

					<sj:tab id="Todo" target="tTodo" label="Todo" />
					<sj:tab id="Grazing" target="tGrazing" label="Grazing" />

					<sj:tab id="Test" target="tTest" label="Test" />

					<div id="tGrazing">
						<table id="Grazings" align="center" title="Grazings"
							class="tabDivTable">
							<thead>
								<tr>
									<th id="tddatein">Date&nbsp;In&nbsp;</th>
									<th id="tddateout">Date&nbsp;Out&nbsp;</th>
									<th id="tdnote">Note</th>
								</tr>
							</thead>
							<tbody id="GrazingData" class="tbody"></tbody>
						</table>
					</div>
					<div id="tTodo">
						<table id="Todos" align="center" title="Todos" class="tabDivTable">
							<thead>
								<tr>
									<th>Date&nbsp;Entered&nbsp;</th>
									<th>Date&nbsp;Due&nbsp;</th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody id="TodoData" class="tbody"></tbody>

						</table>
					</div>
					<div id="tTest">
					
					</div>
				</sj:tabbedpanel>
			</div>
		</div>
		<div id="map_canvas"></div>
	</div>
	<table id="realtest"></table>
	<div id="pager2"></div>
</body>
</html>
