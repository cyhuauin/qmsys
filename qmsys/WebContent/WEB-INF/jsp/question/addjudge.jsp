<%--
  Created by IntelliJ IDEA.
  User: 源
  Date: 2015/11/4
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
题干<input type="text" id="body" name="body"><span id="divbody"></span><br>
<table id="select" onload="start()" >

    <tr><td>答案:<input type=radio id="answer" name="answer" value="1">对<input type=radio id="answer2" name="answer" value="0">错</td></tr>
     <tr><td>分数:<input type="text" id="score" name="score" required onblur="checkscore()"/> <span id="divscore"></span></td></tr>
        <tr><td>难度:<input type="text" id="level" name="level" onblur="checklevel()"> <span id="divlevel"></span></td></tr>
        <tr><td>图片名称: <input type="text" id="imagename" name="imagename" onblur="checkimage()"></td></tr>
        <tr><td>章节:<input type="text" id="chapter" name="chapter" onblur="checkchapter()"> <span id="divchapter"></span></td></tr>
         <tr><td>出题人:<input type="text" id="createuser" name="createruse"></td></tr>
</table>
<button type="reset" >重置</button>
<button type="button" onclick="enter(this.form)">确定</button>
</body>
</html>
