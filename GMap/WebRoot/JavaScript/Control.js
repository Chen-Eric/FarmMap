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
	$("#content").data("selectedFarmID", selectedFarmID);
	console.log("setFocusFarmID: " + $("#content").data("selectedFarmID"));
	console.log($(":button").attr("value"));
}

// click the navigation index box, call this function.
function passFarmId() {
	//alert("FarmId: "+value);
	var focusedFarmID = $("#content").data("selectedFarmID")
	if (focusedFarmID != null) {
		window.location.href = "Control/showFarmMap?farmId="+focusedFarmID;
	} else {
		alert("Please select a farm!");
	}
}

function passFarmIdToTest() {
	//alert("FarmId: "+value);
	var focusedFarmID = $("#content").data("selectedFarmID")
	if (focusedFarmID != null) {
		window.location.href = "Control/showFarmMap?farmId="+focusedFarmID;
	} else {
		alert("Please select a farm!");
	}
}

//for navigation bar events.

//reload the paddockinfo forms.
function update_tabular_data(){
	$('.tabular-data').load('paddockInfo.jsp');
}

