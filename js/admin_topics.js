var tpReq = null;
var topic_list = document.getElementById("topic_name");

window.onload = collectTopics;
function collectTopics(){
	//alert('hello')
	tpreq = new XMLHttpRequest();
	tpreq.open('get','collectTopics.do',true);
	tpreq.onreadystatechange = showTopics;
	tpreq.send(null);
}

function showTopics(){
	if(tpreq.readyState==4&&tpreq.status==200){
		var result = eval(tpreq.responseText);
		topic_list.innerHTML = '';
		for(i=0;i<result.length;i++){
			var dv = document.createElement("div");
			dv.innerHTML = result[i].topic;
			dv.className = "topics_div";
			topic_list.appendChild(dv);
		}
	}
}



var topics_fld = document.getElementById("topic_fld");
var topics_btn = document.getElementById("topic_btn");

topics_btn.onclick = saveTopic;
var save = null;
function saveTopic(){
	save = new XMLHttpRequest();
	save.open('get','new_topics.do?topic='+topics_fld.value,true);
	save.onreadystatechange = afterSaveTopic;
	save.send(null);
}

function afterSaveTopic(){
	if(save.readyState==4&&save.status==200){
		var res = save.responseText;
		if(res=='success'){
			collectTopics();
			topics_fld.value='';
		}
	}
}
