var tpReq = null;
var like = document.getElementById("like");
var dislike = document.getElementById("dislike");
var spam = document.getElementById("spam");

var post_id = document.getElementById("post_id").value;
var liked = document.getElementById("liked").value;
var disliked = document.getElementById("disliked").value
var spamed = document.getElementById("spamed").value

window.onload = collectLike;
function collectLike(){
	tpreq = new XMLHttpRequest();
	tpreq.open('get','collectlike.do?post_id='+post_id,true);
	tpreq.onreadystatechange = showLikes;
	tpreq.send(null);
}

function showLikes(){
	var image="images/btn-ic1.png";
	var image1 = "images/rsz_dislike.png"
	var image2 = "images/btn-ic2.png"
	if(tpreq.readyState==4&&tpreq.status==200){
		var result = eval(tpreq.responseText);
		if(liked==1){
			image = "images/like.png"
		}else{
			image="images/btn-ic1.png"
		}
		if(disliked==1){
			image1 = "images/dislike1.png"
		}else{
			image1 = "images/rsz_dislike.png"
		}
		for(i=0;i<result.length;i++){
			like.innerHTML = '<img src="'+image+'" alt="">'+result[i].likeCount;
			dislike.innerHTML = '<img src="'+image1+'" alt="">'+result[i].dislikeCount;
			spam.innerHTML = '<img src="'+image2+'" alt="">'+result[i].spamCount;
		}
	}
}

like.onclick = saveLike;
var save = null;
function saveLike(){
	save = new XMLHttpRequest();
	save.open('get','new_like.do?post_id='+post_id,true);
	save.onreadystatechange = afterSaveLike;
	save.send(null);
}

function afterSaveLike(){
	if(save.readyState==4&&save.status==200){
		var res = save.responseText;
		if(res==''){
			liked= "1";
			collectLike();
		}else if(res=='delete'){
			liked= "0";
			collectLike();
		}
	}
}


spam.onclick = saveSpam;
var save1 = null;
function saveSpam(){
	save1 = new XMLHttpRequest();
	save1.open('get','new_spam.do?post_id='+post_id,true);
	save1.onreadystatechange = afterSaveSpam;
	save1.send(null);
}

function afterSaveSpam(){
	if(save1.readyState==4&&save1.status==200){
		var res = save1.responseText;
		if(res==''){
			spamed= "1";
			collectLike();
		}else if(res=='delete'){
			spamed= "0";
			collectLike();
		}
	}
}
