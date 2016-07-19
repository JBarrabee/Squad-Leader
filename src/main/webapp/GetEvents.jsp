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
var MeetupArray = [ 
 "https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2",
"https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de"

]//
//var list0 = "list0";
//var list1 = "list1"
//var link0 = getRefreshDetroit;
//var link1 = getITintheD;

for (var i = 0; i<2; i++){
	
	a = "list";
	//b = "link";
	//i=1;
	c = i.toString();
	//c = "1"
	list = a.concat(c);
	link = MeetupArray[i];
	//link = link;
	loadDoc(list , link )
}

//loadDoc(list1, link1);
function loadDoc(list, link) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
    	//console.log(xhttp.responseText);
    	var jsonObj = JSON.parse(xhttp.responseText);
    	//console.log(jsonObj);
    	    	    
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
			//var list = "list";
			document.getElementById(list).innerHTML = document
					.getElementById(list).innerHTML
					+ "<p>"
					+ eventGroupName
					+ ", "
					+ eventCity
					+ "<br>"
					+ "starts at"
					+ ", "
					+ date
					+ ", "
					+ eventName
					+ ", "
					+ "</p><br>";
    	}
    	
    }
    
  };
  //xhttp.open("GET", "https://www.reddit.com/r/aww/.json", true);
    var getRefreshDetroit= "https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2";
	var getITintheD = "https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de"
  	
  xhttp.open("GET",link, true);  
  xhttp.send();
  
  
}

</script>

<section id="list0"></section>
<section id="list1"></section>
</body>
</html>