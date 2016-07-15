<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
		loadDoc();
		function loadDoc() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					//console.log(xhttp.responseText);
					var jsonObj = JSON.parse(xhttp.responseText);
					console.log(jsonObj);

					for (i = 0; i < jsonObj.length; i++) {
						//console.log(jsonObj[i].eventname + "," + jsonObj[i].eventdesc + "," + jsonObj[i].eventlocation + "," + jsonObj[i].eventdatetime);
						document.getElementById("list").innerHTML = document
								.getElementById("list").innerHTML
								+ "<p>"
								+ jsonObj[i].name
								+ ", "
								+ jsonObj[i].venue.name
								+ ", "
								+ jsonObj[i].time
								+ ", "
								+ jsonObj[i].venue.city + "</p><br>";
						;
					}
				}
			};
			//xhttp.open("GET", "https://www.reddit.com/r/aww/.json", true);
			xhttp
					.open(
							"GET",
							"https://api.meetup.com/scrabble-boardgame/events?photo-host=public&page=20&sig_id=9283563&sig=4ec5b42c06eabd6fcb230021a6424871d3e4f413",
							true);
			xhttp.send();
		}
	</script>
	<section id="list"></section>
</body>
</html>