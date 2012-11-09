<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

<title>My JSP 'error.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
 
<link rel="stylesheet" type="text/css" href="CSS/page.css">
<link rel="stylesheet" type="text/css" href="CSS/button.css">

<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=false">	
</script>

<script type="text/javascript" src="JavaScript/maplabel.js"></script>

<script type="text/javascript" src="struts/js/base/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="JavaScript/grid.locale-en.js"></script>
<script type="text/javascript" src="JavaScript/jquery.jqGrid.min.js"></script>

<script type="text/javascript" src="JavaScript/InfoWindow.js"></script>
<script type="text/javascript" src="JavaScript/Map.js"></script>
<script type="text/javascript" src="JavaScript/Paddock.js"></script>
<script type="text/javascript" src="JavaScript/Control.js"></script>

<script type="text/javascript">
	function jqTest() {
	$("#TestTable").jqGrid({
		url : "ShowInfo/ShowPaddockGrazings",
		datatype : "json",
		mtype : "GET",
		colNames:['G_Date_In','G_Date_Out','note'],
		colModel:[{name:'G_Date_In',index:'G_Date_In',width:30},
		          {name:'G_Date_Out',index:'G_Date_Out',width:30},
		          {name:'note',index:'note',width:39, align:"center"}],
		rowNum:10,
		rowList:[10,20,30],
		pager:'#pager2',
		sortname:'gid',
		sortorder:'desc',
		viewrecords:true,
		caption:'jqGridDemo',
	});
	}
</script>

</head>

<body onload="initialize()">
	<button onclick="jqTest()" class="button blue">Test</button>
	<table id="TestTable"></table>
	<div id="map_canvas"></div>
	<div id="tTest">
						
						<div id="pager2"></div>
					</div>
</body>
</html>
