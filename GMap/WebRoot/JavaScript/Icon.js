//the center of the selected paddock on the map.
var selectedPaddockCenterLat;
var selectedPaddockCenterLon;
var iconsOnMap = new google.maps.MVCArray();

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
			getStockTypeBySTID(this.stid);
		});
	});
}

// for stocktype name.
function getStockTypeBySTID(stid) {
	var url = "StockManage/shwoStockType";
	var param = {
		stockTypeID : stid
	};
	$.getJSON(url, param, function(stockType) {
		var jsonStockType = eval("(" + stockType + ")");
		showStockTypeIcon(jsonStockType);
	});
}

// choose the icon image according to the selected Grazing.
function showStockTypeIcon(stockType) {
	var iconImageURL = 'Icon/' + stockType.st + '.png';
	var selectedPaddockCenter = new google.maps.LatLng(selectedPaddockCenterLat
			+ Math.random() / 1000, selectedPaddockCenterLon - Math.random()
			/ 500);
	var iconMarker = new google.maps.Marker({
		position : selectedPaddockCenter,
		icon : iconImageURL,
		map : map,
		// animation: BOUNCD,
		// clickable: true,
		draggable : false,
		visible : true
	});
	iconsOnMap.push(iconMarker);
}

function removeIcons() {
	iconsOnMap.forEach(function(item, index) {
		iconsOnMap.getAt(index).setMap(null);
	});
	iconsOnMap.clear();
}