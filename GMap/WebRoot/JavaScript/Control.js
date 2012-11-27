$.ajaxSetup({"error":errorManager});

function errorManager(XMLHttpRequest, textStatus, errorThrown) {
	if (XMLHttpRequest.status == 403) {
		window.location  = "index.jsp";
	} else if (XMLHttpRequest.status == 500) {
		window.location  = "index.jsp";			
	}
}

function forwardPage(pageName) {
	window.location.href= pageName+".jsp";
	//alert(pageName+".jsp");
}

// after click farm name button, call this fucntion.
function setFocusFarmID(selectedFarmID) {
	$("#container").data("selectedFarmID", selectedFarmID);
	console.log("setFocusFarmID: " + $("#container").data("selectedFarmID"));
	
	//directly go to welcome page.
	passFarmId()
}

// click the navigation index box, call this function.
function passFarmId(focusedFarmID) {
	//alert("FarmId: "+value);
	if (focusedFarmID != null) {
		window.location.href = "Control/showFarmMap?farmId="+focusedFarmID;
//		var url = "Control/showFarmMap";
//		var param = {
//				farmId : focusedFarmID
//		}
//		$.post(url, param);
	} else {
		alert("Please select a farm!");
	}
}

function passFarmIdToTest() {
	//alert("FarmId: "+value);
	var focusedFarmID = $("#container").data("selectedFarmID")
	if (focusedFarmID != null) {
		window.location.href = "Control/showFarmMap?farmId="+focusedFarmID;
	} else {
		alert("Please select a farm!");
	}
}

//exit function
function exit() {
	var url = "Control/ExitFarm";
	$.post(url);
	console.log("exitFarm");
	forwardPage('index');
}

