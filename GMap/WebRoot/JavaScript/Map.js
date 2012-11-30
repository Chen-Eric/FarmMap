/**
 * author Chen
 */
// for the basic map;
var map;
var ZOOM = 17;
var mapCenter;

var temp;
var paddocksOnMap = new google.maps.MVCArray();

function initialize() {
	
	mapCenter = new google.maps.LatLng(-39.70671, 174.96760);
	myOptions = {
		zoom : ZOOM,
		center : mapCenter,
		mapTypeId : google.maps.MapTypeId.SATELLITE,
		overviewMapControl : false,
		disableDoubleClickZoom : false,
		disableDefaultUI : true
	};
	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	
	// Pane all paddocks.
	PaddockManager();
	
	//MarkerImage Test
	var iconimage = 'Icon/bull1.png';
	var markerIcon = new google.maps.Marker({
		position: mapCenter,
		icon: iconimage,
//		map:map,
//		animation: BOUNCD,
		clickable: true,
		draggable: false,
		visible: true
	});
	
	$(document).ready(function() {
		paddockBasicInfoManager();
	});
	
}
// Iterate all the corners of a single paddock.
function PaddockManager() {
	var url = "DrawMap/DrawMap";
	// alert(param.farmId);
	$.getJSON(url, function(paddocksFromDB) {
		//alert("data: "+paddocksFromDB);
		console.log(paddocksFromDB);
		var jsonCorners = eval("(" + paddocksFromDB + ")");
		// alert(jsonCorners[0].pid);
		
		var pidFlag = jsonCorners[0].pid;
		var tempPath = new Array();
		var paddockId;

		// alert("Initial pid: " + pidFlag);
		$.each(jsonCorners, function() {
			if (pidFlag == this.pid) {
				tempPath.push(new google.maps.LatLng(this.lat, this.lon));
				paddockId = this.pid;
			} else {
				// alert("else: " + tempPath);
				drawPaddock(tempPath, paddockId);
				tempPath = [];
				tempPath.push(new google.maps.LatLng(this.lat, this.lon));
				pidFlag = this.pid;
			}
		});
		// alert(tempPath);
		drawPaddock(tempPath, paddockId);
	});
}

//Paddock basic info manager.
function paddockBasicInfoManager() {
	var url = "DrawMap/AddPaddockBacisInfo";

	$.post(url, function(paddockInfoFromDB) {
		//console.log(paddockInfoFromDB);
		var jsonPaddocks = eval(paddockInfoFromDB);
		//console.log(jsonPaddocks);
		$.each(jsonPaddocks, function(index) {
			//for paddock name.
			var paddockCenter = new google.maps.LatLng(this.pCenterLat, this.pCenterLon);
			
			var pName = this.pName;
			var paddockInfo = new MapLabel({
				text: pName,
				position: paddockCenter,
				fontsize: 15,
				maxZoom: 20,
				minZoom: 1,
				strokeColor:'#CCFFFF',
				zIndex: 1,
				map: map
			});
//			console.log(paddockInfo);
			
			//for paddock feed capacity.
			var paddockCenter = new google.maps.LatLng(this.pCenterLat+0.00017, this.pCenterLon);
			var pName = this.pid;
			var paddockInfo = new MapLabel({
				text: pName,
				position: paddockCenter,
				fontsize: 12,
				maxZoom: 18,
				minZoom: 16,
				zIndex: 1,
				strokeColor:'#CCccFF',
				map: map
			});
			
			//for paddock feed capacity.
			var paddockArea = new google.maps.LatLng(this.pCenterLat-0.00017, this.pCenterLon);
			var paddockInfo = new MapLabel({
				text: this.pArea,
				position: paddockArea,
				fontsize: 12,
				maxZoom: 18,
				minZoom: 16,
				zIndex: 1,
				strokeColor:'#CCccbb',
				map: map
			});
		});
	});
}


// Paddock Drawer
function drawPaddock(path, paddockId) {
	// alert("Pass Argument: "+pName);
	var tempVariable = new google.maps.Polygon({
		paths : path,
		strokeColor : "#FFcccc",
		strokeOpacity : 0.5,
		strokeWeight : 2,
		fillColor : "",
		editable : false,
		fillOpacity : 0.35,
	});
	// put this on the map
	tempVariable.set("pid", paddockId);
	// alert("Get Method: "+tempVariable.get("pid"));
	paddocksOnMap.push(tempVariable);
	// alert(paddocksOnMap.getLength());
	
	//add listener to each paddock.
	google.maps.event.addListener(tempVariable, 'click', function() {
		//alert(this.get("pid"));
		highLightPaddock(this.get("pid"));
		labelGrazing(this.get("pid"));
		labelTodo(this.get("pid"));
		labelBasic(this.get("pid"));
		
		$("#map_canvas").data("focusPaddockID", this.get("pid"));
		console.log("focusPaddockID:" + $("#map_canvas").data("focusPaddockID"));
		showSelectedPaddockInfo(this.get("pid"));
		
	});
	tempVariable.setMap(map);
}

// Highlighter.
function highLightPaddock(selectedPaddockID) {

	var highLightPaddockOptions = {
		strokeColor : "#ggbbcc",
		strokeOpacity : 0.9,
		strokeWeight : 3.5,
		zIndex : 3
	};

	var normalPaddockOptions = {
		strokeColor : "#FFcccc",
		strokeOpacity : 0.5,
		strokeWeight : 1.8,
		zIndex : 2
	};

	paddocksOnMap.forEach(function(item, index) {
		if (paddocksOnMap.getAt(index).get("pid") == selectedPaddockID) {
			// alert("find it");
			paddocksOnMap.getAt(index).setOptions(highLightPaddockOptions);
		} else {
			// alert("not that one");
			paddocksOnMap.getAt(index).setOptions(normalPaddockOptions);
		}
	});

} 


