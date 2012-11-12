<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>Layout 17</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta name="generator" content="HAPedit 3.1">

<link rel="stylesheet" type="text/css" href="CSS/indexPage.css">
<link rel="stylesheet" type="text/css" href="CSS/button.css">

<script type="text/javascript" src="JavaScript/jQuery.js"></script>

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
				<p>
					<strong>1) Content here.</strong> column long long column very long
					fill fill fill long text text column text silly very make long very
					fill silly make make long make text fill very long text column
					silly silly very column long very column filler fill long make
					filler long silly very long silly silly silly long filler make
					column filler make silly long long fill very.
				</p>
				<p>very make make fill silly long long filler column long make
					silly silly column filler fill fill very filler text fill filler
					column make fill make text very make make very fill fill long make
					very filler column very long very filler silly very make filler
					silly make make column column</p>
				<p>fill long make long text very make long fill column make text
					very silly column filler silly text fill text filler filler filler
					make make make make text filler fill column filler make silly make
					text text fill make very filler column very</p>
				<p>column text long column make silly long text filler silly
					very very very long filler fill very fill silly very make make
					filler text filler text make silly text text long fill fill make
					text fill long text very silly long long filler filler fill silly
					long make column make silly long column long make very</p>
			</div>
		</div>
		<div id="navigation">
			<p>
				<strong>Click Your Farm</strong> 
				<s:action name="ShowFarms" namespace="/ShowInfo" />
					<table border="0.5" width="200" bordercolor="#rr44cc">
					<caption>All The Farms</caption>
					<s:iterator value="#session.farms" status="farm">
						<s:if test="#farm.odd == true">
							<tr>
							<td id="farmName">Farm Name:</td>
							<td><input id="farmId" type="button" class="green"
								value="<s:property value="FName"/>"
								onclick="passFarmId(<s:property value="FId"/>)" /></td>
							</tr>
						</s:if>
						<s:else>
							<tr>
							<td id="farmName">Farm Name:</td>
							<td><input id="farmId" type="button" class="blue"
								value="<s:property value="FName"/>"
								onclick="passFarmId(<s:property value="FId"/>)" /></td>
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
			</p>
			<p>
			<h3 style="color: #981793">&nbsp;&nbsp;&nbsp;Comming soon...</h3>
			</p>
			<p style="color: #ccffff">Stock Management...</p>
		</div>
		<div id="footer">
			<p align="right">Russle Johnson, Chen Zheng</p>
		</div>
	</div>
</body>
</html>