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

function passFarmId(value) {
	//alert("FarmId: "+value);
	window.location.href = "Control/showFarmMap?farmId="+value;
}

//reload the paddockinfo forms.
function update_tabular_data(){
	$('.tabular-data').load('paddocInfo.jsp');
}

//for Index page.
