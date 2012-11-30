<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="CSS/button.css">
<link rel="stylesheet" type="text/css" href="CSS/infoPage.css">

<div id="paddockInfo">
	<table>
		<caption>Paddock Basic Information</caption>
		<thead>
			<tr>
				<td id="pid">PID&nbsp;&nbsp;</td>
				<td id="pname">PName&nbsp;</td>
				<td id="note">Note&nbsp;&nbsp;</td>
				<td id="feed">FeedCapicity</td>
			</tr>
		</thead>
		<tbody align="left">
		
			<s:form action="EditPaddock" namespace="/Paddock" method="post">
				<s:hidden name="selectedPId" value="%{#session.singlePaddock.Id.PId}">
				</s:hidden>
				<s:hidden name="selectedPName" value="%{#session.singlePaddock.PName}">
				</s:hidden>
				<s:hidden name="selectedPArea" value="%{#session.singlePaddock.PArea}">
				</s:hidden>
				<tr>
				<td>
					<table>
						<s:textfield name="newPId"
							value="%{#session.singlePaddock.Id.PId}" size="2px"/>
					</table></td>
				<td><table>
						<s:textfield name="newPName"
							value="%{#session.singlePaddock.PName}" size="8px" />
					</table>
				</td>
				<td>
					<table>
						<s:textfield name="PDescription"
							value="%{#session.singlePaddock.PDescription}" size="10px" />
					</table></td>
				<td>
					<table>
						<s:textfield name="PFeedCapacity"
							value="%{#session.singlePaddock.PFeedCapacity}" size="3px" />
					</table></td>
				<td><table>
					<s:submit id="update_button" cssClass="button green"
						value="Update" onmouseup="update_paddockInfo_data()"/>
					</table>
				</td>
				</tr>
			</s:form>

		
			<!-- 
				<s:iterator value="#session.paddocksFromDBonPage" status="paddock"
				var="singlePaddock">
				<s:form action="EditPaddock" namespace="/Paddock" method="post">
				<s:if test="#paddock.odd == true">
					<tr style="background-color: #cccc00">
				</s:if>
				<s:else>
					<tr style="background-color: #eecccc">
				</s:else>
				<s:hidden name="selectedPId" value="%{#singlePaddock.Id.PId}">
				</s:hidden>
				<s:hidden name="selectedPName" value="%{#singlePaddock.PName}">
				</s:hidden>
				<s:hidden name="selectedPArea" value="%{#singlePaddock.PArea}">
				</s:hidden>
				<td>
					<table>
						<s:textfield name="newPId"
							value="%{#singlePaddock.Id.PId}" size="1px" />
					</table></td>
				<td><table>
						<s:textfield name="newPName"
							value="%{#singlePaddock.PName}" size="5px" />
					</table>
				</td>
				<td>
					<table>
						<s:textfield name="PDescription"
							value="%{#singlePaddock.PDescription}" size="6px" />
					</table></td>
				<td>
					<table>
						<s:textfield name="PFeedCapacity"
							value="%{#singlePaddock.PFeedCapacity}" size="3px" />
					</table></td>
				<td><table>
					<s:submit id="update_button" cssClass="button green"
						value="Update" onmouseup="update_tabular_data()"/>
					</table>
				</td>
				</tr>
				</s:form>
			</s:iterator>
			 -->

		</tbody>
	</table>
</div>