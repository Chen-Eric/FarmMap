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
<link rel="stylesheet" type="text/css" href="CSS/todoPage.css">

<div id="paddockTodo">
	<table>
		<caption>Paddock Todos</caption>
		<thead>
			<tr id="theadTr">
				<td id="EnterDate">EnterDate</td>
				<td id="DueDate">DueDate</td>
				<td id="Note">Note</td>
				<td id="Done">Have Done?</td>
			</tr>
		</thead>
		<tbody>

			<s:iterator value="#session.paddockTodosFromDB" status="paddockTodo"
				var="singlePaddockTodo">
				<s:form action="EditPaddockTodo" namespace="/Todo" method="post">
					<tr style="background-color: #cccc00">
						<s:hidden name="selectedTodoId" value="%{#singlePaddockTodo.TId}">
						</s:hidden>
						<s:hidden name="selectedPId"
							value="%{#session.selectedPId}">
						</s:hidden>
						<s:hidden name="selectedEnterDate"
							value="%{#singlePaddockTodo.TDateEntered}">
						</s:hidden>
						<s:hidden name="selectedDueDate"
							value="%{#singlePaddockTodo.TDateDue}">
						</s:hidden>
						<s:hidden name="selectedDescription"
							value="%{#singlePaddockTodo.TDescription}">
						</s:hidden>
						<s:hidden name="selectedDone" value="%{#singlePaddockTodo.TDone}">
						</s:hidden>
						<td>
							<table>
								<s:textfield name="todoEnterDate"
									value="%{#singlePaddockTodo.TDateEntered}" size="12px" />
							</table>
						</td>
						<td><table>
								<s:textfield name="todoDueDate"
									value="%{#singlePaddockTodo.TDateDue}" size="12px" />
							</table></td>
						<td>
							<table>
								<s:textfield name="todoDescription"
									value="%{#singlePaddockTodo.TDescription}" size="15px" />
							</table>
						</td>
						<td>
							<table>
								<s:if test="#singlePaddockTodo.TDone == true">
									<s:radio name="todoIsDone"
										list="%{#{'true':'Done','false':'Not'}}" value="true"></s:radio>
								</s:if>
								<s:else>
									<s:radio name="todoIsDone"
										list="%{#{'true':'Done','false':'Not'}}" value="false"></s:radio>
								</s:else>
							</table>
						</td>
						<td><table>
								<s:submit id="update_button" cssClass="button red"
									value="Delete" onmouseup="update_paddockTodo_data()" />
							</table></td>
						<td><table>
								<s:submit id="delete_button" cssClass="button green"
									value="Update" onmouseup="update_paddockTodo_data()" />
							</table></td>
					</tr>
				</s:form>
			</s:iterator>
			<s:form action="AddPaddockTodo" namespace="/Todo">
					<s:hidden name="selectedPId"
						value="%{#session.selectedPId}">
					</s:hidden>
				<td>
					<table>
						<s:textfield name="todoEnterDate" size="12px"></s:textfield>
					</table></td>
				<td>
					<table>
						<s:textfield name="todoDueDate" size="12px"></s:textfield>
					</table></td>
				<td>
					<table>
						<s:textfield name="todoDescription" size="15px"></s:textfield>
					</table></td>
				<td>
					<table>
						<s:radio name="todoIsDone"
							list="%{#{'true':'Done','false':'Not'}}" value="false"></s:radio>
					</table></td>
				<td>
					<table>
						<s:submit id="add_button" value="Add..." cssClass="button blue"
							method="addPaddockTodo" onmouseup="update_paddockTodo_data()" />
					</table>
				</td>
				<td><input id="reset_button" class="button rosy" type="reset"
					value="Reset" /></td>
			</s:form>
		</tbody>
	</table>
</div>