function labelGrazing(selectedPaddockId) {
//	window.alert("label grazing worked");
	var url = "ShowInfo/ShowPaddockGrazings";
	var param = {
			paddockId : selectedPaddockId,
	};
	$.post(url, param, showPaddockGrazings);
}

function labelTodo(selectedPaddockId) {
	var url = "ShowInfo/ShowPaddockTodos";
	var param = {
			paddockId : selectedPaddockId,
	};
	$.post(url, param, showPaddockTodos);
}

function labelBasic(selectedPaddockId) {
	var url = "ShowInfo/ShowPaddockBasicInfo";
	var param = {
			paddockId : selectedPaddockId,
	};
	$.post(url, param, showPaddockBasicInfos);
}

//To unserialize json type PaddockGrazings data.
function showPaddockGrazings(paddockGrazings) {
	console.log(paddockGrazings);
	var jsonPaddockGrazings = eval("(" + paddockGrazings + ")");
//	alert(jsonPaddockGrazings.length);
	$("#GrazingData").empty();
	var strHTML = "";
	$.each(jsonPaddockGrazings, function() {
		strHTML += "<tr class='gid' id='" + this.gid + "'>";
		strHTML += "<td class='tdgid'>"+this.gid+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td>"+this.G_Date_In+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td>"+this.G_Date_Out+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td>"+this.note+"</td>";
		strHTML += "<td>"+"<input class='gtr button blue' type='button' value='StockCount?'>"+"</td>";
		strHTML += "<td>"+"<input class='gscAdd button green' type='button' value='AddStockCount'>"+"</td>";
		strHTML += "</tr>";
	});
	$("#GrazingData").html(strHTML);
	$("#scData").empty();
	$(".gtr").click(function() {
		console.log($(this).parent().parent().attr("id"));
		labelStockCount($(this).parent().parent().attr("id"));
		$("#map_canvas").data("focusedGrazingId", $(this).parent().parent().attr("id"));
		console.log("focusedGrazingId:" + $("#map_canvas").data("focusedGrazingId"));
	});
	$(".gscAdd").click(function() {
		console.log($(this).parent().parent().attr("id"));
		labelStockCount($(this).parent().parent().attr("id"));
		$("#map_canvas").data("focusedGrazingId", $(this).parent().parent().attr("id"));
		console.log("focusedGrazingId:" + $("#map_canvas").data("focusedGrazingId"));
		addSC($(this).parent().parent().attr("id"));
	});
}

//To unserialize json type PaddockTodos data.
function showPaddockTodos(paddockTodos) {
	console.log(paddockTodos);
	var jsonPaddockTodos = eval("(" + paddockTodos + ")");
	$("#TodoData").empty();
	var strHTML = "";
	$.each(jsonPaddockTodos, function() {
		strHTML += "<tr>";
		strHTML += "<td>"+this.T_Date_Entered+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td>"+this.T_Date_Due+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td>"+this.T_Description+"</td>";
		strHTML += "</tr>";
	});
	$("#TodoData").html(strHTML);
}

//To unserialize json type PaddockBasicInfo data.
function showPaddockBasicInfos(paddockBasicInfos) {
	console.log(paddockBasicInfos);
	var jsonPaddockBasicInfos = eval("(" + paddockBasicInfos + ")");
	$("#BasicInfoData").empty();
	var strHTML = "";
	strHTML += "<tr><td class='BasicInfoDataTd'>" + "Paddock ID" + "</td><td>" + jsonPaddockBasicInfos.pid + "</td></tr>";
	strHTML += "<tr><td class='BasicInfoDataTd'>" + "Paddock Name" + "</td><td>" + jsonPaddockBasicInfos.pName + "</td></tr>";
	strHTML += "<tr><td class='BasicInfoDataTd'>" + "Paddock Area" + "</td><td>" + jsonPaddockBasicInfos.pArea + "</td></tr>";
	strHTML += "<tr><td class='BasicInfoDataTd'>" + "Description" + "</td><td>" + jsonPaddockBasicInfos.pDescription + "</td></tr>";
	strHTML += "<tr><td class='BasicInfoDataTd'>" + "FeedCapability&nbsp;&nbsp;" + "</td><td>" + jsonPaddockBasicInfos.pFeedCapability + "</td></tr>";
	$("#BasicInfoData").html(strHTML);
}

//J-Grid Test
function jqTest() {
	$("#realtest").jqGrid({
		height: 200,
		weidth: "auto",
		url : "ShowInfo/ShowPaddockGrazings",
		datatype : "json",
		postData : {paddockId : 1},
		mtype : "POST",
		colNames:['G_Date_In','G_Date_Out','note','Done?'],
		colModel:[{name:'G_Date_In',index:'G_Date_In',width:150},
		          {name:'G_Date_Out',index:'G_Date_Out',width:150},
		          {name:'note',index:'note',width:100},
		          {name:'Done'}],
		rowNum:10,
		rowList:[10,20,30,],
		pager:'#pager2',
		sortname:"gid",
		sortorder:"desc",
		viewrecords:true,
		caption:"jQ-Grid"
	});
	$("#pager2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});
}