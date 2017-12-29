/**
 * AJAX for House Bill of Lading
 */
function cleartl() {
	document.getElementById("title").value = "";
}

function saveHBL() {
	var hblno = $("#hblno").val();
	var bookingno = $("#bookingno").val();
	var vvd = $("#vvd").val();
	// var eta=$("#etapicker").val();
	var hbldataset = {
		"hblno" : hblno,
		"bookingno" : bookingno,
		"vvd" : vvd,
	};
	
	$.ajax({
		type : 'POST',
		url : '/housebl?save',
		dataType : 'JSON', // data type expected from server
		contentType : "application/json",
		data : JSON.stringify(hbldataset),
		timeout : 100000,
		success : function(data) {
			alert("House BL: "+$("#hblno").val()+" saved");
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	})

}

function retrieveHBL() {
	var hblno = $("#hblno").val();
	var bookingno = $("#bookingno").val();
	var vvd = $("#vvd").val();
	
	$.ajax({
		type : 'POST',
		url : '/housebl?retrieve',
		dataType : 'JSON', // data type expected from server
		contentType : "application/json",
		data : hblno,
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#bookingno").val(data.bookingno);
			$("#vvd").val(data.vvd);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	})

}

function deleteHBL() {
	var hblno = $("#hblno").val();
	
	$.ajax({
		type : 'POST',
		url : '/housebl?delete',
		dataType : 'JSON', // data type expected from server
		contentType : "application/json",
		data : hblno,
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	})

}
		
function reset() {
    $( "#confirmDelete" ).dialog();
}
