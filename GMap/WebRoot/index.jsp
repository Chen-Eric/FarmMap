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
<html>
<head>
<title>Welcome!</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta name="generator" content="HAPedit 3.1">



<link rel="stylesheet" type="text/css" href="CSS/indexPage.css">
<link rel="stylesheet" type="text/css" href="CSS/indexButton.css">

<script type="text/javascript" src="JavaScript/jQuery.js"></script>
<script type="text/javascript" src="JavaScript/jquery.flip.js"></script>
<script type="text/javascript" src="JavaScript/Navigation.js"></script>

<!-- My JavaScript -->
<script type="text/javascript" src="JavaScript/Control.js"></script>

</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Farm View</h1>
		</div>
		<div id="wrapper">
			<div id="content">
				<p></p>
			</div>
		</div>
		<div id="navigation">
			<p>
				<strong>Click Your Farm</strong> 
				<s:action name="ShowFarms" namespace="/ShowInfo" />
					<table border="0.5" width="200" bordercolor="#rr44cc">
					<caption>All The Farms</caption>
					<s:iterator value="#session.farms" status="farm" var="singleFarm">
						<s:if test="#farm.odd == true">
							<tr>
							<td id="farmName">Farm Name:</td>
							<td>
							<input id="farmId" type="button" class="button whiteButton"
								value="<s:property value="FName"/>"
								onclick="passFarmId(<s:property value="FId"/>)"/>
							</td>
							</tr>
						</s:if>
						<s:else>
							<tr>
							<td id="farmName">Farm Name:</td>
							<td><input id="farmId" type="button" class="button whiteButton"
								value="<s:property value="FName"/>"
								onclick="passFarmId(<s:property value="FId"/>)"/> </td>
							</tr>
						</s:else>
					</s:iterator>
				</table>
			</p>
		</div>
		<div id="extra">
			<p>
				<strong>Welcome to FarmView</strong>
			</p>
			<p>
			<h3 style="color: #981793">&nbsp;&nbsp;&nbsp;What's new?</h3>
			</p>
			<p>
				<b>Struts2<br>jQuery</b>
				<b>Stock Count</b>
			</p>
			<p>
			<h3 style="color: #981793">&nbsp;&nbsp;&nbsp;Comming soon...</h3>
			</p>
			<p style="color: #ccffff">jQuery Effect Menu</p>
		</div>
		<div id="footer">
			<p align="right">Russle Johnson, Chen Zheng</p>
		</div>
	</div>
</body>
</html>