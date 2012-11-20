//a function for flip box.
function changeIt() {
	
}


//CSS change after click on farm name button.


//for flip box.
function stockTypeManageFlip() {
	$(document).ready(
		$("#map_canvas").flip({
			directories : 'lr',
			onAnimation: function() {
				$("#map_canvas").empty();
				$("#map_canvas").load('stockType.jsp');
			}
		})
	);
}

function mapManageFlip() {
	$(document).ready(
		$("#map_canvas").flip({
			directories : 'lr',
			onAnimation: function() {
				$("#map_canvas").empty();
				initialize();
			}
		})
	);
}