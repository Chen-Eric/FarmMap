<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<title>Smooth Animated jQuery Menu</title>
	
	<link rel="stylesheet" href="CSS/animated-menu.css"/>
	
	<script src="JavaScript/jQuery.js" type="text/javascript"></script>
	<script src="JavaScript/jquery.easing.1.3.js" type="text/javascript"></script>
	<script src="JavaScript/animated-menu.js" type="text/javascript"></script>
</head>

<body>

	<p>This is your farm!</p>
	
	<ul>
		<li class="green">
			<p><a href="#">Index</a></p>
			<p class="subtext" id="pIndex"><a href="/GMap/index.jsp">Index</a></p>
		</li>
		<li class="yellow">
			<p><a href="#">Map</a></p>
			<p class="subtext" id="pMap"><a onclick="passFarmId()">Map</a></p>
		</li>
		<li class="red">
			<p><a href="#">Paddock</a></p>
			<p class="subtext" id="pPaddock">Get in touch</p>
		</li>
		<li class="blue">
			<p><a href="#">Todo<br>Grazing</a></p>
			<p class="subtext" id="pTodoGrazing">Send us your stuff!</p>
		</li>
		<li class="purple">
			<p><a href="#">Stock</a></p>
			<p class="subtext" id="pStock">Legal things</p>
		</li>
		<li class="green">
			<p><a href="#">Test</a></p>
			<p class="subtext" id="pTest"><a onclick="passFarmIdToTest()">TestPage</a></p>
		</li>
	</ul>
	
</body>
</html>
