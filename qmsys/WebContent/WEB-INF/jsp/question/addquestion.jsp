<%@ page import="com.cust.qmsys.domain.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增试题</title>
</head>
<script type="text/javascript" src="js/jiaoyan.js"></script>
<script type="text/javascript">

function enter(form){
	alert(1);
	$.ajax({
	 	type: "POST",
		url: "addquestion.do",
	    data: $('#question').serialize(),
	    success: function(page){
	    	alert("添加成功");
			$("#mainFrame").html(page);
	    }
	})

}
function change(c){
    var pageurl = $("#type option:selected").val();
    alert(pageurl);
    if(pageurl == 1){
        pageurl = "/question/addchoice.jsp";
    }
   else if(pageurl == 2){
        pageurl = "/question/addjudge.jsp";
    }else if(pageurl == 3){
        pageurl = "/question/addcompletion.jsp";
    }else if(pageurl == 4){
        pageurl = "/question/addcompletion.jsp";
    }



    $.ajax({
        type:"GET",
        url:"pageforward.do",
        data:{page:pageurl},
            success:function(page){
        $("#qu").html(page)
    }
    })
}

</script>

<body>
<div id="mainframe">
<form action="addquestion.do" method="post" name="question" id="question">
    <select id   ="subject" name="subject">
    <%List<Map<String,Object>> subli =(List<Map<String, Object>>)request.getAttribute("sublist");%>

        <% for(int i=0;i<subli.size();i++){%>
<option value="<%=subli.get(i).get("name")%>"><%=subli.get(i).get("name")%></option>
        <%}%>
    </select>

<select id="type" name="type" onchange="change()">
<option value="1">选择题</option>
<option value="2">判断题</option>
<option value="3">填空题</option>
<option value="4">简答题</option>
</select>
<br>
<div id="qu">
    题干<input type="text" id="body" name="body"><span id="divbody"></span><br>
    <table id="select" >
        <tr><td>A:<input type="text" id="A" name="A"> <span id="diva"></span></td>
            <td>B:<input type="text" id="B" name="B"> <span id="divb"></span></td></tr>
        <tr><td>C:<input type="text" id="C" name="C"> <span id="divc"></span></td>
            <td>D:<input type="text" id="D" name="D"> <span id="divd"></span></td></tr>
        <tr><td>E:<input type="text" id="E" name="E"></td>
            <td>F:<input type="text" id="F" name="F"></td></tr>
        <tr><td>答案:<input type="text" id="answer" name="answer"  onblur="checkanswer()"/>
        <span id="divanswer"></span></td></tr>
        <tr><td>分数:<input type="text" id="score" name="score"  onblur="checkscore()"/> <span id="divscore"></span></td></tr>
        <tr><td>难度:<input type="text" id="level" name="level" onblur="checklevel()"> <span id="divlevel"></span></td></tr>
        <tr><td>图片名称: <input type="text" id="imagename" name="imagename" onblur="checkimage()"></td></tr>
        <tr><td>章节:<input type="text" id="chapter" name="chapter" onblur="checkchapter()"> <span id="divchapter"></span></td></tr>
        <tr><td>出题人:<input type="text" id="createuser" name="createruse"></td></tr>
    </table>
    <button type="reset" >重置</button>
    <button type="button" onclick="enter(this.form)">确定</button>
</div>
</form>
<form action="uppic.do" method="post" name="upimage" enctype="multipart/form-data" target="respage">
    选择您要上传的图片：<br>
    <input type="file" multiple name = "image" id="image" ><input type="submit" value="上传" ><br>
    <iframe name="respage" id="respage" style="display: none"></iframe>
</form>
    <script type="text/javascript">
   
        function callback(msg){
            document.getElementById("image").outerHTML =document.getElementById("image").outerHTML;
          alert(msg);
        }

    </script>
    </div>
</body>
</html>
