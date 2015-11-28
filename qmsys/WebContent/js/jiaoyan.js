function start(){
	var firstinput = document.getElementsByTagName("input")[0];
	firstinput.select();
}
function checkanswer(){
 if($("#answer").val()==""){
 divanswer.innerHTML = "<font color='RED'>此处为必填项请填写</font>";
 
 }else{
 divanswer.innerHTML = "";
	 return true;
 }
}
function checkscore(){
	var re=new RegExp("^[1-9]\d*$");
	if($('#score').val()==""){
		divscore.innerHTML =  "<font color='RED'>此处为必填项请填写</font>";
	}else if(re.test($('#score').val())){
		divscore.innerHTML = "";
		return true;
	}else{
		divscore.innerHTML = "<font color='RED'>请正确填写分数</font>";
	}
}
function checklevel(){
	var re = new RegExp("^[0-9\-]*$");
    if(re.test($('#level').val())){
    	divlevel.innerHTML = "";
    	return true;
    }else{
    	divlevel.innerHTML = "<font color='RED'>请正确填写难度</font>";
		
    }
}
function checkchapter(){
	var re = new RegExp("^[0-9\-]*$");
    if(re.test($('#level').val())){
    	    	divchapter.innerHTML = "";
    	    	return true;
    }else{
    	divchapter.innerHTML = "<font color='RED'>请正确填写章节</font>";
		
    }
	
	
}
function checkimage(){
	
	var body = $('#body').val();
	var image = $('#imagename').val();
	if(image==""&&body==""){
		
		divbody.innerHTML = "<font color='RED'>请填写题干</font>";
	}else{
		divbody.innerHTML = "";
		return true;
	} 
	
	
}












