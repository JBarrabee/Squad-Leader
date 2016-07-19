<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajax Demo</title>
</head>
<body>
<script>
//Using YQL and JSONP
/* $.ajax({
    url: "http://query.yahooapis.com/v1/public/yql",
 
    // The name of the callback parameter, as specified by the YQL service
    jsonp: "callback",
 
    // Tell jQuery we're expecting JSONP
    dataType: "jsonp",
 
    // Tell YQL what we want and that we want JSON
    data: {
        q: "select title,abstract,url from search.news where query=\"cat\"",
        format: "json"
    },
 
    // Work with the response
    success: function( response ) {
        console.log( response ); // server response
    }
}); */
loadDoc();
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
    	//console.log(xhttp.responseText);
    	var jsonObj = JSON.parse(xhttp.responseText);
    	console.log(jsonObj);
    	    	    
    	for (i = 0; i < jsonObj.length; i++) {
			var eventName = jsonObj[i].name;
			var eventLocation = jsonObj[i].venue.name;
			
			var date = new Date(jsonObj[i].time);
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
					+ date
					+ ", "
					+ "</p><br>";
    	}
    }
  };
  //xhttp.open("GET", "https://www.reddit.com/r/aww/.json", true);
  xhttp.open("GET", "https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2", true);  
  xhttp.send();
}
</script>
<section id="list"></section>
</body>
</html>