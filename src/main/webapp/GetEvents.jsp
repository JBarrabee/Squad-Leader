<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meetup Events</title>
</head>
<body>
<script>

var meetupArray = [ 
"https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de",
"https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2",
"https://api.meetup.com/BDPA-Detroit-technology-meetup/events?photo-host=public&page=20&sig_id=209133816&sig=db30a53e119fe9a87011a882d0fb33f1d7120110",		
"https://api.meetup.com/Detroit-java-user-group/events?photo-host=public&page=20&sig_id=209133816&sig=1267a5d24e1aac9d58c5f1648f096629783a9517",
"https://api.meetup.com/girl-develop-it-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=a531894ec6e4a1645afb57e9857d08a782203662"	,	
"https://api.meetup.com/the-iron-yard-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=54e41552a1621655091dd3aab3b543e075b0f0b6"	]//
//var list0 = "list0";
//var list1 = "list1"
//var link0 = getRefreshDetroit;
//var link1 = getITintheD;

for (var i = 0; i<meetupArray.length; i++){
	
	a = "list";
	c = i.toString();
	list = a.concat(c);
	link = meetupArray[i];
	loadDoc(list , link )
}

//loadDoc(list1, link1);
function loadDoc(list, link) {
  var xhttp = new XMLHttpRequest();
  
  //alert (link);
 
  
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
    	//console.log(xhttp.responseText);
    	var xml = xhttp.responseText;
        	
    	var jsonObj = JSON.parse(xml);
    	//console.log(jsonObj);
    	    	    
    	for (i = 0; i < jsonObj.length; i++) {
    		var EVENT_ID = jsonObj[i].id;
    		var GROUP_URL = jsonObj[i].group.urlname;
    		var GROUP_NAME = jsonObj[i].group.name;
			var EVENT_NAME = jsonObj[i].name;
			//Not sure where the new came from
			//var EVENT_DATE = new Date(jsonObj[i].time).customFormat("");
			var EVENT_DATE = jsonObj[i].time;
			var EVENT_VENUE_NAME = jsonObj[i].venue.name;
			var EVENT_STREET = jsonObj[i].venue.address_1;
			var EVENT_CITY= jsonObj[i].venue.city;
			var EVENT_STATE= jsonObj[i].venue.state;
			var EVENT_ZIP = jsonObj[i].venue.zip;
			var EVENT_LATITUDE = jsonObj[i].venue.lat;
			var EVENT_LONGITUDE = jsonObj[i].venue.lon;
			var EVENT_LINK = jsonObj[i].link;
			
			var meetup = { EVENT_ID, GROUP_URL, GROUP_NAME, EVENT_NAME, EVENT_DATE,
					EVENT_VENUE_NAME, EVENT_STREET, EVENT_ZIP, EVENT_LATITUDE, 
					EVENT_LONGITUDE, EVENT_LINK };
					
			var eventArray = [];
			eventArray.push(meetup)

			//this is to test that it is working
			//var list = "list";
			
			document.getElementById(list).innerHTML = document
					.getElementById(list).innerHTML
					+ "<p>"
					+ "Group EVENT = " + eventArray[0].EVENT_ID
					+ ", Group URL = " + eventArray[0].GROUP_URL
					+ "<br>"
					+ "Group Name = " + eventArray[0].GROUP_NAME
					+ ", Event Date =  " + meetup.EVENT_DATE
					+ ", Event Name =  " + meetup.EVENT_NAME
					+ "<br>"
					+ "Event Venue Name = " + eventArray[0].EVENT_VENUE_NAME
					+ "<br>"
					+ ", Event Street =  " + meetup.EVENT_STREET
					+ ", Event City =  " + meetup.EVENT_CITY
					+ ", Event State = " + meetup.EVENT_STATE
					+ ", Event ZIP =  " + meetup.EVENT_ZIP
					+ "<br>"
					+ ", Event LONG = " + meetup.EVENT_LONGITUDE
					+ ", Event LAT =  " + meetup.EVENT_LATITUDE
					+ ", Event Link =  " + meetup.EVENT_LINK
					+ "</p><br>";
    	}
    	
    }
    
  };
  
  xhttp.open("GET",link, true);  
  xhttp.setRequestHeader('Access-Control-Allow-Origin', "*");
  xhttp.send();


  
</script>


<div id="debug"></div>
<div id="list0"></div>
<div id="list1"></div>
<div id="list2"></div>
<div id="list3"></div>
<div id="list4"></div>
<div id="list5"></div>
<div id="list6"></div>
</body>
</html>