var upload = document.getElementById("upload");

upload.onchange = function(){
	var image = document.getElementById("user_image1");	
	alert(image);
	image.src = upload.value;
}