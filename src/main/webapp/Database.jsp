<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajax Demo</title>
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
    		document.getElementById("list").innerHTML= document.getElementById("list").innerHTML + "<p>" + jsonObj[i].eventname + ", " + jsonObj[i].eventdesc + ", " + jsonObj[i].eventlocation + ", " + jsonObj[i].eventdatetime + "</p><br>";
    	}
    }
  };
  //xhttp.open("GET", "https://www.reddit.com/r/aww/.json", true);
  xhttp.open("GET", "https://templeeventws.herokuapp.com/templews/listevents", true);  
  xhttp.send();
}
</script>
<section id="list"></section>
</body>
</html>