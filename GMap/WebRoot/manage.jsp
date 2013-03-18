<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
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
<sj:head jqueryui="true" jquerytheme="smoothness" debug="true" compressed="false"/>

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
<script type="text/javascript" src="JavaScript/StockCount.js"></script>

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
						</p>
					</td>
					<td>
						<p align="center">
							<button class="button green" onclick="forwardPage('welcome')">Welcome&nbsp;Page</button>
						</p>
					</td>
					<td>
						<p align="center">
							<button class="button blue" onclick="forwardPage('map')">Manage&nbsp;Map</button>
						</p>
					</td>
					<td>
						<p align="center">
							<button class="button red" onclick="exit()">Exit&nbsp;Farm</button>
						</p>
					</td>
				</tr>
			</table>

			<div id="Infowindow">
				
				<sj:tabbedpanel id="infotabs" title="Paddoc Basic InfoPanel">
				
					<sj:tab id="Basic" target="tBasic" label="Basic" />
					<sj:tab id="Todo" target="tTodo" label="Todo" />
					<sj:tab id="Grazing" target="tGrazing" label="Grazing" />

					<div id="tBasic">
						<table id="BasicInfos" align="center" title="PaddockBasicInfo"
							class="tabDivTable">
							<tbody id="BasicInfoData" class="tbody"></tbody>
						</table>
					</div>

					<div id="tGrazing">
						<table id="Grazings" align="center" title="Grazings"
							class="tabDivTable">
							<thead>
								<tr>
									<th id="tddatein">GID&nbsp;&nbsp;</th>
									<th id="tddatein">Date&nbsp;In&nbsp;</th>
									<th id="tddateout">Date&nbsp;Out&nbsp;</th>
									<th id="tdnote">Note</th>
								</tr>
							</thead>
							<tbody id="GrazingData" class="tbody"></tbody>
						</table>
						<br>
						<table id="sc" align="center" class="tabDivTable">
							<thead>
								<tr>
									<th>Grazing&nbsp;ID&nbsp;</th>
									<th>StockType&nbsp;ID&nbsp;</th>
									<th>SC-count</th>
									<th></th>
								</tr>
							</thead>
							<tbody id="scData" class="tbody"></tbody>
						</table>
						<div id="scDialogDIV">
							<sj:dialog id="scDialog" title="New Stock-Count?"
								autoOpen="false" showEffect="slide" hideEffect="slide"
								modal="true" closeOnEscape="true" width="auto"
								buttons="{'OK':function(){scDialogSubmit();},'Cancel':function(){scDialogCancel();}}">

								<p id="scDialogDIV" style="text-align: center;">
									For Paddock&nbsp;<strong id="scDialogDIVS1">?&nbsp;</strong>Grazing&nbsp;<strong
										id="scDialogDIVS2">?</strong>
								</p>
								<s:select id="stSelector" list="%{#session.stockTypesFromDB}"
									listValue="STypeAndUnit" listKey="SId" required="true">SelectStockType:</s:select>
								<br>
								<s:textfield id="stCount" required="true">StockTypeCount :</s:textfield>
								<div id="scResult" style="color: red"></div>
							</sj:dialog>
						</div>
					</div>
					<div id="tTodo">
						<div class="paddockTodoDIV">
							<jsp:include page="paddockTodo.jsp" />
						</div>
					</div>
				</sj:tabbedpanel>

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
