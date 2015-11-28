<%@ page import="java.util.*,com.cust.qmsys.dao.paper.*,com.cust.qmsys.domain.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#show{
	margin-top:20px;
	margin-left:20px;
}
#tr1{
	font-weight:blod;
	font-family:"黑体";
	font-size:14px;
}
tr{
	height:30px;
}
td{
	width:60px;
	height:30px;
	text-align:center;
}
a{
	text-decoration:none;
	color:red;
}
a:hover{
	text-decoration:none;
}
</style>
</head>

<body>

<%
	QueryPaper query = new QueryPaper();
	List<Paper> list = query.query();	
	request.setAttribute("list", list);
	
	//out.println("hfiehw");
	//List<Paper> list = (List)request.getAttribute("list");
	
%>

<table border="1" id="show">
	<tr id = "tr1">
		<td>试卷编号</td>
		<td>年级</td>
		<td>科目</td>
		<td>分数</td>
		<td>出题教师</td>
		<td>出题日期</td>
		<td>&nbsp;</td>
	</tr>
	<c:forEach items="${list}" var="paper" >
		<tr>
			<td>${paper.paperNum }</td>
			<td>${paper.grade }</td>
			<td>${paper.subject }</td>
			<td>${paper.score }</td>
			<td>${paper.teacher }</td>
			<td>${paper.date }</td>
			 <td><a href="delpaper.do?paperNum=${paper.paperNum }" target="submitFrame">删除</a></td> 
		</tr>
	</c:forEach>
	
</table>

<form action="delpaper.do" method="post" name="delpaper" id="delpaper" target="submitFrame">
<br/>
<br/>
<!-- 
试卷编号:<input type="text" id="delID" name="delID">
<input type="submit" value = "删除" >
 -->
</form>

</body>
<iframe name="submitFrame" style="display:none" ></iframe>
</html>