<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#paper{
	margin-top:10px;
	margin-left:20px;
}
tr{
	height:30px;
}

</style>
</head>

<body>
	<div id = "main">
		<form action="addpaper.do" method="post" name="addpaper" id="addpaper" target="submitFrame" >
			<table id = "paper">
			<tr>
				<td>试卷编号:</td>
				<td><input type="text" id="paperID" name="paperID"></td>
			</tr>
			<tr>
				<td align = "center">年级:</td>
				<td> 
					<select id="grade" name="grade">
					<option value="一年级">一年级</option>
					<option value="二年级">二年级</option>
					<option value="三年级">三年级</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align = "center">科目:</td>
				<td>
					<select id="subject" name="subject">
					<option value="语文">语文</option>
					<option value="数学">数学</option>
					<option value="英语">英语</option>
					</select>
				</td>
			</tr>
			<tr>
			<td align = "center">分数:</td>
			<td>
				<input type="text" id="score" name="score">
			</td>
			</tr>
			<tr>
			<td>组卷教师:</td>
			<td>
				<input type="text" id="paperTeacher" name="paperTeacher">
			</td>
			</tr>
			
			<!-- 出题时间:<input type="text" id="paperDate" name="paperDater"><br> -->
			
			<tr>
				<td align = "center" colspan="2">
					<input type="submit" value = "增加">
				</td>
			</tr>
			</table>
		</form>
	</div>
</body>
<iframe name="submitFrame" style="display:none" ></iframe>
</html>