<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>Welcom!</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="CSS/indexPage.css">
<link rel="stylesheet" type="text/css" href="CSS/button.css">

<script type="text/javascript" src="JavaScript/jQuery.js"></script>
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
					<s:action name="ShowFarms" namespace="/ShowInfo" />
				<table border="0.5" width="200" bordercolor="#rr44cc" >
				<caption>All The Farms</caption>
				<s:iterator value="#session.farms" status="farm">
					<s:if test="#farm.odd == true">
					<tr style="background-color:#cccc00">
					</s:if>
					<s:else>
					<tr>
					</s:else>
					<td>Farm Name:</td>
					<td><input id="farmId" type="button" class="button green"
							value="<s:property value="FName"/>"
							onclick="passFarmId(<s:property value="FId"/>)" />
						</td>
					</tr>
				</s:iterator>
				</table>
				</p>
			</div>
		</div>
		<div id="navigation">
			<p>
				<strong>Welcome to FarmView</strong>
			</p>
			<p>
				Explore more...
			</p>
		</div>
		<div id="extra">
			<p>
				<h3 style="color: #981793">What's new?</h3>
			</p>
			<p>
				<b>Struts2<br>jQuery</b>
			</p>
			<p>
				<h3 style="color: #981793">Comming soon...</h3>
			</p>
			<p style="color: #ccffff">
				jGrid
			</p>
		</div>
		<div id="footer">
			<p align="right">Russle Johnson</p>
			<p align="right">Chen Zheng</p>
		</div>
	</div>
</body>
</html>
