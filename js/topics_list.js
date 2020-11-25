window.onload = initAll;
var topic_table = document.getElementById("topic_table");
function initAll(){
	collectTopics();

}

var tpReq = null;
function collectTopics(){
	tpReq = new XMLHttpRequest();
	tpReq.open('get','admin/collectTopics.do',true);
	tpReq.onreadystatechange = showTopics;
	tpReq.send(null);
}

function showTopics(){
	if(tpReq.status==200 && tpReq.readyState==4){
		//alert(tpReq.responseText);
		var res = eval(tpReq.responseText);
		for(i=0;i<res.length;i++){
			var row = topic_table.insertRow(i+1);
			var c1 = row.insertCell(0);c1.innerHTML = res[i].topicId;
			var c2 = row.insertCell(1);
			c2.innerHTML = '<a href="topics_question.do?topic_id='+res[i].topicId+'&topic='+res[i].topic+'">'+res[i].topic+'</a';
			var c3 = row.insertCell(2);c3.innerHTML = res[i].questionCount;
			var c4 = row.insertCell(3);c4.innerHTML = res[i].openQuestion;
			var c5 = row.insertCell(4);c5.innerHTML = res[i].lastUpdate;
			c1.style.textAlign="center";
			c2.style.textAlign="center";
			c3.style.textAlign="center";
			c4.style.textAlign="center";
			c5.style.textAlign="center";
		}
	}
}