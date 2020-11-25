var btn = document.getElementById("tp_button");
var tp_id = document.getElementById("tp_id");
var tp_nm = document.getElementById("tp_nm");
btn.onclick=function(){
				window.location='post_questions.do?topic='+tp_nm.value+'&topic_id='+tp_id.value;
			};

