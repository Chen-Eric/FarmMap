/**
 * for stock-count functionality.
 */
function labelStockCount(selectedGId) {
	var url = "StockCount/ShowStockCountByPaddock";
	var param = {
			selectedGId : selectedGId,
	};
	$.getJSON(url, param, showPaddockSCs);
}

function showPaddockSCs(stockCountsInDB) {
	console.log(stockCountsInDB);
	var jsonGrazingSCs = eval("(" + stockCountsInDB + ")");
	$("#scData").empty();
	var strHTML = "";
	$.each(jsonGrazingSCs, function() {
		strHTML += "<tr class='gsc' id='" + this.gid + "'>";
		strHTML += "<td class='gid' id='" + this.gid + "'>"+this.gid+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td class='stid' id='" + this.stid + "'>"+this.stid+"&nbsp;&nbsp;&nbsp;</td>";
		strHTML += "<td class='scCount' id='" + this.scCount + "'>"+this.scCount+"&nbsp;&nbsp;&nbsp;</td>";
//		strHTML += "<td>"+"<input class='gscUpdate blue' type='button' value='Update'>"+"</td>";
		strHTML += "<td>"+"<input class='gscDelete red' type='button' value='Delete'>"+"</td>";
//		strHTML += "<td>"+"<input class='gscAdd green' type='button' value='Add...'>"+"</td>";
		strHTML += "</tr>";
	});
	$("#scData").html(strHTML);
	
	// binding event listener to buttons.
//	$(".gscUpdate").click(function() {
//		console.log($(this).parent().parent().attr("id"));
//		updateSC($(this).parent().parent().attr("id"));
//	});

	$(".gscDelete").click(function() {
		deleteSC($(this).parent().parent().find("td.gid").attr("id"), 
				$(this).parent().parent().find("td.stid").attr("id"), 
				$(this).parent().parent().find("td.scCount").attr("id"));
	});
	$(".gscAdd").click(function() {
		console.log($(this).parent().parent().attr("id"));
		addSC($(this).parent().parent().attr("id"));
	});
}

function deleteSC(selectedGId, selectedSCId, selectedscCount) {
	var url = "StockCount/DeleteStockCount";
	var param = {
			selectedGId : selectedGId,
			selectedSCId : selectedSCId,
			selectedscCount : selectedscCount
	}
	$.post(url, param, scAfterModification);
}

function updateSC(selectedSCId) {
	// TODO need?
}

function addSC(selectedGID) {
	$("#scDialogDIVS1").empty();
	var strS1 = $("#map_canvas").data("focusPaddockID") + "&nbsp;";
	$("#scDialogDIVS1").html(strS1);
	
	$("#scDialogDIVS2").empty();
	var strS2 = $("#map_canvas").data("focusedGrazingId");
	$("#scDialogDIVS2").html(strS2);
	
	console.log("openDialogClickEvent");
	$("#scDialog").dialog("open");
}

//For scDialog submit
function scDialogSubmit() {
	var gid = $("#map_canvas").data("focusPaddockID");
	var st = $("#stSelector").attr("value");
	var scCount = $("#stCount").attr("value");
	console.log("New StockCount: " + gid + "-" + st + "-" + scCount);
	if (!(gid=='' || st=='' || scCount=='')) {
		var url = "StockCount/AddStockCount";
		var param = {
				newSCGrazingId : gid,
				newSCStockTypeId : st,
				newSCCount : scCount
		}
		$.post(url, param);
		$("#scResult").empty();
		$("#scDialog").dialog("close");
		scAfterModification();
	} else {
		$("#scResult").empty();
		$("#scResult").html("Cant be null :-(");
	}
	
}

function scAfterModification(){
	var gid = $("#map_canvas").data("focusPaddockID");
	$(document).ready(function() {
		setTimeout(function() {
			labelStockCount(gid);
		}, 1000);
	});
}

//For scDialog calcle
function scDialogCancel() {
	$("#scResult").empty();
	$("#scDialog").dialog("close");
}
