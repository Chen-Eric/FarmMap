<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="CSS/button.css">
<link rel="stylesheet" type="text/css" href="CSS/mapPage.css">

<!-- For error message display -->
<strong id="paddockMsgDIV"></strong>

<p align="center">
	<button class="button orange" onclick="openPaddockDialog()">Complete&nbsp;Paddock</button>
</p>
<p align="center">
	<button class="button green" onclick="startNewPaddock()">Add&nbsp;Paddock</button>
</p>
<p align="center">
	<button class="button rosy" onclick="undoLastMark()">Remove&nbsp;Last&nbsp;Corner</button>
</p>
<p align="center">
	<button class="button gray" onclick="deleteSelectedPaddock()">Delete&nbsp;Paddock</button>
</p>

<!-- If click complete button this Struts2-jQuery-Dialog will popup to add  pID, pName & pFeedCapability -->
<sj:dialog id="pDialog" title="New Paddock?" autoOpen="false"
	showEffect="slide" hideEffect="slide" width="auto" closeOnEscape="true"
	modal="true" buttons="{'OK':function(){submitNewPaddock();},'Cancle':function(){closePaddockDialog();}}">
	<p id="existPaddocks"></p>
	<p><strong id="paddockMsgDialog"></strong></p>
	<table id="paddockDialogTable">
		<tr>
			<td align="right">ID: </td>
			<td><table><sj:textfield cssClass="text" id="newPaddockId" size="6" effect="highlight"/></table></td>
			<td><table><s:checkbox name="PIDBOX" id="defaultPFC" fieldValue="true">ByDefault?</s:checkbox></table></td>
		</tr>
		<tr>
			<td align="right">Name:</td>
			<td><table><sj:textfield cssClass="text" id="newPaddockName" size="6"/></table></td>
			<td><table><s:checkbox name="PNBOX" id="defaultPFC" fieldValue="true">ByDefault?</s:checkbox></table></td>
		</tr>
		<tr>
			<td align="right">FeedCapability</td>
			<td><table><sj:textfield cssClass="text" id="newPaddockFC" size="6"/></table></td>
			<td><table><s:checkbox name="PFCBOX" id="defaultPFC" fieldValue="true">ByDefault?</s:checkbox></table></td>
		</tr>
		<tr>
			<td align="right">Paddoc Note</td>
			<td><table><sj:textfield cssClass="text" id="newPaddockDescription" size="6"/></table></td>
			<td><table><s:checkbox name="PDBOX" id="defaultPD" fieldValue="true">ByDefault?</s:checkbox></table></td>
		</tr>
	</table>

</sj:dialog>