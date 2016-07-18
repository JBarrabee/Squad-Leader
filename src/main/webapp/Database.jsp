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
		function myfuntion(callLink) {
			loadDoc(); // how java script creates a function
			function loadDoc() { // this will be the function that other documents will call
				var xhr = new XMLHttpRequest(); // creating the object
				//I changed the xhttp to xhr as I saw in an example.
				xhr.onreadystatechange = function() { //when connection is ready make sure it is good
					if (this.readyState == 4 && this.status == 200) {
						//console.log(xhttp.responseText);
						var jsonObj = JSON.parse(xhr.responseText); // get the data
						console.log(jsonObj);
						//Data is an array  Need to do a for loop (or a inhanced for loop) to get all information
						for (i = 0; i < jsonObj.length; i++) {
							var eventName = jsonObj[i].name;
							var eventLocation = jsonObj[i].venue.name;
							var eventTime = jsonObj[i].time;
							var eventCity = jsonObj[i].venue.city;
							var eventLongitude = jsonObj[i].venue.lon;
							var eventLatitude = jsonObj[i].venue.lat;
							var eventGroupName = jsonObj[i].group.name;
							var eventLatitude = jsonObj[i].link;

							//this is to test that it is working
							var list = "list";
							document.getElementById(list).innerHTML = document
									.getElementById(list).innerHTML
									+ "<p>"
									+ eventName
									+ ", "
									+ eventCity
									+ "<br>"
									+ "starts at"
									+ ", "
									+ jsonObj[i].time
									+ ", "
									+ jsonObj[i].venue.city + "</p><br>";
						}
					}
				};
				//xhttp.open("GET", callLink, true);
				//xhttp.send(); // Sends the request
				var xhr =createCORSRequest('GET', callLink);
				xhr.send();
			}
		} //end of funtion

	
		var refreshDetroitLink = "https://api.meetup.com/2/events?key=7b746934724f4a84010a3e5968137b&group_urlname=refreshdetroit&sign=true";
		var scrabbleGroupLink = "https://api.meetup.com/scrabble-boardgame/events?photo-host=public&page=20&sig_id=9283563&sig=4ec5b42c06eabd6fcb230021a6424871d3e4f413";
		
	//	myfuntion(scrabbleGroupLink);
		myfuntion(refreshDetroitLink);
	</script>
	<section id="list"></section>
	<br>
	<!-- what is printed out on the website-->

</body>
</html>