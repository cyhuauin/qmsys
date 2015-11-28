<%--
  Created by IntelliJ IDEA.
  User: 源
  Date: 2015/11/4
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    
</head>
<body>
题干<input type="text" id="body" name="body"><span id="divbody"></span><br>
<table id="select" >
     <tr><td>A:<input type="text" id="A" name="A"> <span id="diva"></span></td>
            <td>B:<input type="text" id="B" name="B"> <span id="divb"></span></td></tr>
        <tr><td>C:<input type="text" id="C" name="C"> <span id="divc"></span></td>
            <td>D:<input type="text" id="D" name="D"> <span id="divd"></span></td></tr>
        <tr><td>E:<input type="text" id="E" name="E"></td>
            <td>F:<input type="text" id="F" name="F"></td></tr>
        <tr><td>答案:<input type="text" id="answer" name="answer" required onblur="checkanswer()"/>
        <span id="divanswer"></span></td></tr>
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
