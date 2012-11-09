<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet" type="text/css" href="CSS/test.css">

<style type="text/css">

</style>

<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=false">
	
</script>

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?libraries=geometry&sensor=false"></script>
<script type="text/javascript" src="scripts/v3_epoly_sphericalArea.js">
	
</script>

<script type="text/javascript" src="scripts/maplabel.js"></script>
<script type="text/javascript" src="JavaScript/Polygon.js"></script>

<script type="text/javascript">
	//for the basic map;
	var map;
	var ZOOM = 5;
	var mapCenter;

	//for polygon
	var newPaddockCoords = new Array();

	function initialize() {
		mapCenter = new google.maps.LatLng(24.886436490787712, -70.2685546875);
		myOptions = {
			zoom : ZOOM,
			center : mapCenter,
			mapTypeId : google.maps.MapTypeId.SATELLITE
		};
		map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);
		drawPaddock();
	}

	function drawPaddock() {
		
		var temp = '${ test }';
		var jsonobj = eval(temp);
		ttt = jsonobj[0];
		
		//i = 0; i < jsonobj.length; i++
		for (i = 0; i < jsonobj.length; i++){
			temp = jsonobj[i];
			var test = new google.maps.MVCArray();
			//alert(temp[1][1]);
			for ( var j = 0; j < temp.length; j++) {
				 
				 test.push(new google.maps.LatLng(temp[j][0],temp[j][1]));
			}
			//draw this paddock
			drawPaddock(test);
		}
		
		//Paddock Drawer
		function drawPaddock(path) {
			bermudaTriangle = new google.maps.Polygon({
				paths : path,
				strokeColor : "#FF0000",
				strokeOpacity : 0.8,
				strokeWeight : 2,
				fillColor : "#FF0000",
				fillOpacity : 0.35
			});
			//put this on the map
			bermudaTriangle.setMap(map);
		}
		
		//place a new marker on the mouse click position
		function placeMarker(location) {
			  var marker = new google.maps.Marker({
				  position: location,
				  map: map
			  });
		}
		
		//activate a new mouse listener
		function startNewPaddock()
		{
			myMouseListener = google.maps.event.addListener(map, 'click', function(e){addLatLng(e.latLng);});		
		}
		
	}
	
	function paddockArrayBuilder(lat,lng) {
		temp.push(new google.maps.LatLng(lat,lng));
	}
</script>
</head>

<body onload="initialize()">
	<!-- Div for buttons -->
	<div id="buttons">
		<s:submit type="button" value="DrawPaddock" action="" align="left" />
		<s:submit type="button" value="SavePaddock" action="" align="left" />
		<s:submit type="button" value="DeletePaddock" action="" align="left" />
	</div>

	<!-- Div for Map_Information_Window -->
	<div id="infowindow">
	</div>

	<!-- Div for Google_Map -->
	<div id="map_canvas" style="width:80%; height: 80%"></div>

	<!-- For test. -->
	<div id="testDiv">
		
		<table width="40%" border="1">
			<tr>
				<td><b>Lat</b></td>
				<td><b>Lng</b></td>
			</tr>
			<tr>
				<c:forEach items="${ cornerList11 }" var="listCorner" >
					<tr>
						<td>${ listCorner.CLat }</td>
						<td>${ listCorner.CLon }</td>
					</tr>
    			</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${ cornerList22 }" var="listCorner" >
					<tr>
						<td>${ listCorner.CLat }</td>
						<td>${ listCorner.CLon }</td>
					</tr>
    			</c:forEach>
			</tr>			
		</table>
	</div>
</body>
</html>
