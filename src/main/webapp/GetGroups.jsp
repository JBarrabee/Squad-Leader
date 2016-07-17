<!-- For some reason it brings back 12 documents if I include next event and 
16 docs if I don't.  I suspect it is a matter of timing out, but I can get
200 if I plug it in directly. 200 hundred is a round number but there are 210.
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Database</title>
</head>
<body>
	<script>
		function getGroupArray(callLink) {
			loadDoc(); // how java script creates a function
			function loadDoc() { // this will be the function that other documents will call
				var xhttp = new XMLHttpRequest(); // creating the object
				xhttp.onreadystatechange = function() { //when connection is ready make sure it is good
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						//console.log(xhttp.responseText);
						var jsonObj = JSON.parse(xhttp.responseText); // get the data
						console.log(jsonObj);
						//Data is an array  Need to do a for loop (or a inhanced for loop) to get all information
						for (i = 0; i < 200; i++) {
							var groupName = jsonObj[i].name;
							var groupArray = [];
							groupArray.push(groupName)
						//	var groupURL = jsonObj[i].urlname;
						//	var groupCity = jsonObj[i].city;
						//	var nextEvent = jsonObj[i].next_event.name;
						//	var lastEventDate = jsonObj[i].last_event.time;
							

							//this is to test that it is working
							var list = "list";
							document.getElementById(list).innerHTML = document
									.getElementById(list).innerHTML
									+ "<p>"
									+ groupName
									
									+ "</p><br>";
						}
					}
				};
				xhttp.open("GET", callLink, true);
				xhttp.send(); // Sends the request
			}
		} //end of getGroupArray
		/* function displayArray(array){
			for(var a =0; a<array.length; a++){
				document.getElementById(list).innerHTML = document
				.getElementById(list).innerHTML
				+ "<p>"
				+ a			
				+ "</p><br>";
			} */
		
		var getGroupsLink = "https://api.meetup.com/find/groups?photo-host=public&zip=48226&page=300&sig_id=9283563&radius=50&fields=last_event&category=34&sig=b8276071dad5f5d16a0a77db673fef5cc19fb46b";
		var GroupsUserName25miTechRequest = "https://api.meetup.com/find/groups?upcoming_events=true&photo-host=public&zip=48226&page=50&sig_id=9283563&radius=20&category=34&only=urlname&sig=c8958a837421870938ae2c0681c99058c32cd28b";
			//also only groups that have upcoming events
		getGroupArray(getGroupsUserName25miTechRequest);
		//displayArray(groupArray);
	</script>
	<section id="list"></section>
	<br>
	<!-- what is printed out on the website-->

</body>
</html>