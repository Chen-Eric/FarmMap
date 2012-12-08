//the center of the selected paddock on the map.
var selectedPaddockCenterLat;
var selectedPaddockCenterLon;
var iconsOnMap = new google.maps.MVCArray();
var positionCounter = 0;

// receive the PaddockID from google map event listener.
function locateSelectedPaddockCenter(pid) {
	var url = "Paddock/ShowPaddock";
	var param = {
		selectedPId : pid
	};
	$.getJSON(url, param, function(selectedPaddock) {
		var jsonPaddock = eval("(" + selectedPaddock + ")");
		selectedPaddockCenterLat = jsonPaddock.pCenterLat;
		selectedPaddockCenterLon = jsonPaddock.pCenterLon;
		console.log("selectedPaddockCenter: " + selectedPaddockCenterLat);
		console.log("selectedPaddockCenter: " + selectedPaddockCenterLon);
	});
	getGrazing(pid);
	removeIcons();
}

function getGrazing(selectedPaddockId) {
	// window.alert("label grazing worked");
	var url = "ShowInfo/ShowPaddockGrazings";
	var param = {
		paddockId : selectedPaddockId,
	};
	$.post(url, param, function(paddockGrazings) {
		var jsonPaddockGrazings = eval("(" + paddockGrazings + ")");
		$.each(jsonPaddockGrazings, function() {
			console.log("GrazingID: " + this.gid);
			getGrazingSC(this.gid);
		});
	});
}

function getGrazingSC(selectedGId) {
	var url = "StockCount/ShowStockCountByGrazing";
	var param = {
		selectedGId : selectedGId,
	};
	$.get(url, param, function(StockCounts) {
		var jsonStockCounts = eval("(" + StockCounts + ")");
		$.each(jsonStockCounts, function() {
			console.log("StockCountsID: " + this.stid);
			getStockTypeBySTID(this.stid, this.scCount);
		});
	});
}

// for stocktype name.
function getStockTypeBySTID(stid, scCount) {
	var url = "StockManage/shwoStockType";
	var param = {
		stockTypeID : stid
	};
	$.getJSON(url, param, function(stockType) {
		var jsonStockType = eval("(" + stockType + ")");
		showStockTypeIcon(jsonStockType, scCount);
	});
}

// choose the icon image according to the selected Grazing.
function showStockTypeIcon(stockType, scCount) {
	var iconImageURL = 'Icon/' + stockType.st + '.png';
	var stockTypeXUnit = stockType.scUnit + " X " + scCount;
	console.log(stockTypeXUnit);
	positionCounter++;
	var selectedPaddockCenter = positionCalculator(selectedPaddockCenterLat, selectedPaddockCenterLon);
	var iconMarker = new google.maps.Marker({
		position : selectedPaddockCenter,
		icon : iconImageURL,
		map : map,
		clickable: true,
		draggable : false,
		visible : true
	});
	
	var iconText = new MapLabel({
		text: stockTypeXUnit,
		position : selectedPaddockCenter,
		fontsize: 12,
		maxZoom: 18,
		minZoom: 16,
		zIndex: 1,
		strokeColor:'#CCccFF',
		map: map
	});
	
	iconsOnMap.push(iconText);
	iconsOnMap.push(iconMarker);
}

function removeIcons() {
	iconsOnMap.forEach(function(item, index) {
		iconsOnMap.getAt(index).setMap(null);
	});
	iconsOnMap.clear();
	positionCounter = 0;
}

//For stockCount icon positions.
function positionCalculator(lat, lon) {
	
	var position;
	console.log("positionCounter:" + positionCounter);
	switch (positionCounter) {
	case 1:
		position = new google.maps.LatLng(lat, lon + 0.0008); 
		break;
	case 2:
		position = new google.maps.LatLng(lat + 0.0008, lon); 
		break;
	case 3:
		position = new google.maps.LatLng(lat, lon - 0.0008); 
		break;
	case 4:
		position = new google.maps.LatLng(lat - 0.0008, lon); 
		break;
	case 5:
		position = new google.maps.LatLng(lat + 0.00075, lon + 0.00075); 
		break;
	case 6:
		position = new google.maps.LatLng(lat + 0.00075, lon - 0.00075); 
		break;
	case 7:
		position = new google.maps.LatLng(lat - 0.00075, lon - 0.0007); 
		break;
	case 8:
		position = new google.maps.LatLng(lat - 0.00075, lon + 0.0007); 
		break;

	default: 
		break;
	}
	
	return position;
}