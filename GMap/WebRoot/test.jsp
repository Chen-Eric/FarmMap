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
<sj:head compressed="false" />

<link rel="stylesheet" type="text/css" href="CSS/button.css">
<link rel="stylesheet" type="text/css" href="CSS/managePage.css">

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
<script type="text/javascript" src="JavaScript/Navigation.js"></script>
<script type="text/javascript" src="JavaScript/StockCount.js"></script>


<script type="text/javascript">
	
</script>

</head>

<body onload="initialize()">
	<div id="PageBody">
		<div id="Sidebar">
			<p align="center">
				<button class="button white" onclick="forwardPage('index')">Stock&nbsp;Type&nbsp;Manage</button>
			</p>
			<p align="center">
				<button class="button blue" onclick="forwardPage('manage')">Manage&nbsp;Paddocks</button>
			</p>
			<fieldset>
				<legend style="font-size: 13px">Paddock</legend>
				<p align="center">
					<button class="button orange" onclick="completePaddock()">Complete</button>
				</p>
				<p align="center">
					<button class="button green" onclick="startNewPaddock()">Add</button>
				</p>
				<p align="center">
					<button class="button red" onclick="deleteSelectedPaddock()">Delete</button>
				</p>
				<p align="center">
					<button class="button rosy" onclick="undoLastMark()">Remove&nbsp;Last&nbsp;Corner</button>
				</p>
			</fieldset>
			<div id="Infowindow">
				<sj:tabbedpanel id="infotabs" spinner="Loading...">
				
					<sj:tab id="Basic" target="tBasic" label="Basic" />
					<sj:tab id="Todo" target="tTodo" label="Todo" />
					<sj:tab id="Grazing" target="tGrazing" label="Grazing" />

					<div id="tBasic">
						<table id="BasicInfos" align="center" title="PaddockBasicInfo" class="tabDivTable">
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
						<jsp:include page="paddockTodo.jsp" />
						<!-- 
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
						
						
						<s:url var="todoGridActionURL" action="showPaddockTodoInGrid"
							namespace="/TodoGrid" />

						<sjg:grid id="todoGrid" caption="Todo Grid Test" dataType="json"
							href="%{todoGridActionURL}" pager="false"
							gridModel="gridModel" rowList="10,15,20" rowNum="10"
							rownumbers="false" viewrecords="true">
							<sjg:gridColumn name="paddockFarmFId" index="paddockFarmFId"
								title="fid" hidden="true" />
							<sjg:gridColumn name="paddockPId" index="paddockPId" title="pid"
								hidden="true" />
							<sjg:gridColumn name="TId" index="TId" title="TodoID"
								formatter="integer" sortable="false" />
							<sjg:gridColumn name="TDateEntered" index="TDateEntered" title="EnterDate" sortable="false"></sjg:gridColumn>
							<sjg:gridColumn name="TDateDue" index="TDateDue" title="DueDate" sortable="false"></sjg:gridColumn>
							<sjg:gridColumn name="TDescription" index="TDescription" title="Note" sortable="false"></sjg:gridColumn>
							<sjg:gridColumn name="TDone" index="TDone" title="State" sortable="false"></sjg:gridColumn>
						</sjg:grid>
						 -->
						
					</div>
				</sj:tabbedpanel>
			</div>

		</div>
		<div id="map_canvas" />
	</div>
	<div>
		<s:debug />
	</div>
</body>
</html>
