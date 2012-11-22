<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Kwicks Vertical Example</title>

<script src='JavaScript/jQuery1.8.3.js' type='text/javascript'></script>
<script src='JavaScript/jquery.kwicks.js' type='text/javascript'></script>

<link rel='stylesheet' type='text/css' href='CSS/jquery.kwicks.css' />
<style type='text/css'>
.kwicks {
	width: 125px;
	height: 415px;
}

.kwicks>li {
	width: 125px;
	height: 100px;
	/* overridden by kwicks but good for when JavaScript is disabled */
	margin-top: 5px;
}

#panel-1 {
	background-color: #53b388;
}

#panel-2 {
	background-color: #5a69a9;
}

#panel-3 {
	background-color: #c26468;
}

#panel-4 {
	background-color: #bf7cc7;
}
</style>
</head>

<body>
	<ul class='kwicks kwicks-vertical'>
		<li id='panel-1'></li>
		<li id='panel-2'></li>
		<li id='panel-3'></li>
		<li id='panel-4'></li>
	</ul>



	<script type='text/javascript'>
		$(function() {
			$('.kwicks').kwicks({
				size : 100,
				maxSize : 220,
				spacing : 5,
				behavior : 'menu',
				isVertical : true
			});
		});
	</script>
</body>
</html>