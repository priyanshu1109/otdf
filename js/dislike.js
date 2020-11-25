var post_id = document.getElementById("post_id").value;
var dislike = document.getElementById("dislike")
var tpreq3 = null

window.onload = collectLike;

var tpreq1 = null;
dislike.onclick = saveDislike;

function saveDislike(){
	tpreq1 = new XMLHttpRequest();
	tpreq1.open('get','new_dislike.do?post_id='+post_id)
	tpreq1.onreadystatechange = afterSaveDislike;
	tpreq1.send(null);
}
	
function afterSaveDislike(){
	if(tpreq1.readyState==4 && tpreq1.status==200){
		var res = tpreq1.responseText
		if(res==''){
			disliked= "1";
			collectLike();
		}else if(res=='delete'){
			disliked= "0";
			collectLike();
		}
	}
}