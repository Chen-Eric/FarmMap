<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- Script Libraries -->
<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?libraries=geometry&sensor=false"></script>
<script type="text/javascript" src="scripts/v3_epoly_sphericalArea.js"></script>
<script type="text/javascript" src="scripts/maplabel.js"></script>

<!-- JavaScript For Google Map -->
<script type="text/javascript">
	//Fro the basic map canvas.
	var map;
	var mapCenter;
	var ZOOM = 18;

	var newPaddockCorners;
	var myMouseListener;

	function initialize() {
		mapCenter = new google.maps.LatLng(-39.70671, 174.96760);
		myOptions = {
			zoom : MY_ZOOM,
			center : myLatlng,
			mapTypeId : google.maps.MapTypeId.SATELLITE
		};
		map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);
	}
</script>
</head>

<body onload="initialise()">

</body>
</html>
