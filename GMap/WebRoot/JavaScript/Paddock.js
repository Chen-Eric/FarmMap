//for polygon
var newPaddock = new google.maps.Polygon();
var newPaddockCoords;
var markersArray;

// activate a new mouse listener
function startNewPaddock() {
	newPaddockCoords = new google.maps.MVCArray();
	markersArray = new google.maps.MVCArray();
	myMouseListener = google.maps.event.addListener(map, 'click', function(e) {
		addCorner(e.latLng);
	});
}

// remove the last marker and its position
function undoLastMark() {
	newPaddockCoords.pop();
	markersArray.getAt(markersArray.getLength() - 1).setMap(null);
	markersArray.pop();
}

// complete the newPaddock and show it on map
function completePaddock() {
	// Render the new paddock on the map.
	showNewPaddock(newPaddockCoords);
	// alert(newPaddockCoords.getAt(0).lat());

	// add this paddock to DB.
	addPaddock(newPaddockCoords);

	// clear all that new paddock array.
	newPaddockCoords.clear();
	if (markersArray) {
		for ( var i = 0; i < markersArray.getLength(); i++) {
			// clear all that new paddock markers.
			markersArray.getAt(i).setMap(null);
		}
	}
	markersArray.clear();
	google.maps.event.removeListener(myMouseListener);
	
	//To reload the paddock info jsp.
	$(document).ready(function() {
		update_tabular_data();
	});
}

// place a new marker on the mouse click position
function placeMarker(location) {
	var marker = new google.maps.Marker({
		position : location,
		map : map
	});
	markersArray.push(marker);
	// alert(markersArray.getLength());
}

// Add a new corner to that MVCArray.
function addCorner(location) {
	placeMarker(location);
	newPaddockCoords.push(location);
	if (newPaddockCoords.getLength() > 2) {
		if (newPaddock.getMap != null) {
			newPaddock.setMap(null);
		}
		showNewPaddock(newPaddockCoords);
	}
}

// draw fenceline function
function showNewPaddock(path) {
	newPaddock = new google.maps.Polygon({
		path : path,
		strokeColor : '#ff0000',
		strokeOpacity : 0.8,
		strokeWeight : 2,
		fillColor : "",
		editable : false,
		fillOpacity : 0.35,
	});
	newPaddock.setMap(map);
}

//use ajax to add this paddock to DB and redraw the map_canvas.
function addPaddock(path) {
	
	//calculate the center of this polygon.
	var polyBound = new google.maps.LatLngBounds();
	path.forEach(function(item, index) {
		polyBound.extend(path.getAt(index));
	});
	var polyArea = (google.maps.geometry.spherical.computeArea(path)/10000).toFixed(2);
	console.log(polyArea);
	
	var jsonPath = "[";
	path.forEach(function(item, index) {
		jsonPath += "{"+ "\"" + "CLat" + "\"" + ":" + path.getAt(index).lat() + ",\"CLon\":"
				+ path.getAt(index).lng() + "}" + ",";
	});

	jsonPath = jsonPath.substring(0, jsonPath.lastIndexOf(','));
	jsonPath += "]";

	var url = "Paddock/AddPaddock";
	var param = {
		newPaddockCorners : jsonPath,
		newPaddockCenterLat : polyBound.getCenter().lat(),
		newPaddockCenterLon : polyBound.getCenter().lng(),
		newPadoockArea : polyArea
	};
	$.post(url, param, function() {
		initialize();
	});	
}

function deleteSelectedPaddock() {
	deletePaddock($("#map_canvas").data("focusPaddockID"));
}

//using ajax to delete the selected paddock and redraw the map_canvas.
function deletePaddock(selectedPId) {
	//alert(selectedPId);
	var url = "Paddock/DeletePaddock";
	var param = {
			selectedPId : selectedPId,
	};
	$.post(url, param, function() {
		initialize();
	});
	//To reload the paddock info jsp.
	$(document).ready(function() {
		update_tabular_data();
	});
}

//Show selected paddock basic info in a jsp page, load it into main page.
function showSelectedPaddockInfo() {
	console.log("SelectedPID: " + $("#map_canvas").data("focusPaddockID"));
	var url = "Paddock/ShowPaddock";
	var param = {
			selectedPId: $("#map_canvas").data("focusPaddockID")
	};
	$.getJSON(url, param, function(singlePaddock) {
		console.log(singlePaddock);
		$(document).ready(function() {
			update_tabular_data();
		});
	});
}

//using jQuery-Grid to build up a grid to update the names of those paddocks.
function paddockGridTest() {
	$("#gridTable").jqGrid({
		url: "PaddockGrid/ShowPaddockGrid",
		datatype: "json",
		mtype: "GET",
		height: 150,
		autowidth: true,
		colModel: [
	          {name:"pid",index:"pid",label:"PID",width:40},
		      {name:"pName",index:"pName",label:"pName",width:80,sortable:false},
		      {name:"pCenterLat",index:"pCenterLat",label:"pCenterLat",width:120,sortable:false},
		      {name:"pCenterLon",index:"pCenterLon",label:"pCenterLon",width:120,sortable:false},
		      {name:"pDescription",index:"pDescription",label:"pDescription",width:80,sortable:false},
		      {name:"pFeedCapability",index:"pFeedCapability",label:"pFeedCapability",width:160,sortable:false}
		],
		viewrecords: true,
		rowNum: 15,
		rowList: [15,20,25],
		prmNames: {search: "search"},	//(1)
		jsonReader: {
			root:"gridModel",		// (2)
			records: "record",		// (3)
			repeatitems : false		// (4)
		},
		pager: "#gridPager",
		caption: "Paddock Infomation",
		hidegrid: false
	});
}