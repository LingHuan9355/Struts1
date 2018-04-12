var req;

//post请求Ajax验证
function PostJd(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var qxid = document.getElementById("qx").value;
	//alert("qxid=" + qxid);
	
	var url = "fwxxAction.do?method=queryJd";
 
    req.open("post", url, true);    
    //设置请求头
    req.setRequestHeader("content-Type", "application/x-www-form-urlencoded");
    
    req.send("qxid="+qxid+"&"+Math.random());
    
    req.onreadystatechange = callback;
}

/*function getjd(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var qxid = document.getElementById("qx").value;
	alert("qxid=" + qxid);
	var url = "fwxxAction.do?method=queryJd&qxid="+qxid+"&"+Math.random();
	if(qxid!=0){
		req.open("get",url,true);
		req.send(null);
		req.onreadystatechange = callback;
	}
}*/

function callback(){
	if(req.readyState==4){
		if(req.status==200){
			
			var msg = req.responseXML;
		
			var jdObj = msg.getElementsByTagName("jd");
		    //alert(jdObj);
			var jd = document.getElementById("jd");
		    
			jd.length = 1;
			for(var i=0; i<jdObj.length; i++){
				var jdid = jdObj[i].childNodes[0].childNodes[0].nodeValue;
				var jdname = jdObj[i].childNodes[1].childNodes[0].nodeValue;
				//alert(jdid+"--"+jdname);
				jd.add(new Option(jdname,jdid));
			}
		}
	}
}