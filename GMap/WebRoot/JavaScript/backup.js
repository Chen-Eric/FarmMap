//Iterate all the paddocks which come from our DB.
	function PaddockManager() {

		var paddocksFromDB = '${ paddocksFromDB }';
		var jsonobj = eval(paddocksFromDB);

		for (i = 0; i < jsonobj.length; i++) {
			tempLatLng = jsonobj[i];
			var tempPaddock = new google.maps.MVCArray();
			//alert(temp[1][1]);
			for ( var j = 0; j < tempLatLng.length; j++) {

				tempPaddock.push(new google.maps.LatLng(tempLatLng[j][0],
						tempLatLng[j][1]));
			}
			//draw this paddock
			drawPaddock(tempPaddock);
		}
	}