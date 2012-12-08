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
<link rel="stylesheet" type="text/css" href="CSS/page.css">

<!-- This line the key point to call the Struts2-jQuery-Plugin -->
<sj:head jqueryui="true" jquerytheme="smoothness" />


<div id="stockTypeInfo">
	<s:action name="show" namespace="/StockManage"/>
	<table id="StockTypeTable">
		<caption>StockType Management</caption>
		<tbody>
		<s:iterator value="#session.stockTypesFromDB" status="stockType" var="singleStockType">
			<s:form action="StockManage" namespace="/StockManage">
				<s:hidden name="stockTypeID" value="%{#singleStockType.SId}"></s:hidden>
				<s:hidden name="selectedStockType" value="%{#singleStockType.SType}"></s:hidden>
				<s:hidden name="selectedStockUnit" value="%{#singleStockType.stockUnits}"></s:hidden>
				
				<td>
					<table>
						<s:textfield name="stockType" value="%{#singleStockType.SType}"/>
					</table>
				</td>
				<td>
					<table>
						<s:textfield name="stockUnit" value="%{#singleStockType.stockUnits}"/>
					</table>
				</td>

				<td>					
					<table><s:submit id="update_button" action="StockManage" value="Update" cssClass="button green" method="updateStockType"/>
					</table>
				</td>
				<td>	
					<table><s:submit id="delete_button" action="StockManage" value="Delete" cssClass="button rosy" method="deleteStockType"/>
					</table>
				</td>

		</s:form>
		</s:iterator>
		</tbody>
		</table>
		<table>
		<!-- A form for add new stock type -->
		<s:form action="StockManage">
				<td>
					<table>
						<s:textfield name="stockType"></s:textfield>
					</table>
				</td>
				<td>
					<table>
						<s:textfield name="stockUnit"></s:textfield>
					</table>
				</td>
				<td>	<table><s:submit id="add_button" action="StockManage" value="Add..." cssClass="button blue" method="addStockType"/></table></td>
				<td><input id="reset_button" class="button rosy" type="reset" value="Reset"/> </td>
		</s:form>
	</table>
	<s:debug></s:debug>
</div>