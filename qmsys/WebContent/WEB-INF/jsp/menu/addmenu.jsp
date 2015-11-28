<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>删改菜单</title>
</head>
<script type="text/javascript">

</script>
<body>
	<h1 align = "center">添加菜单</h1><hr/>
	<div align = "center">
		<form action = "${pageContext.request.contextPath}/AddMenuServlet.do" method = "post">
		<table width = "500" height = "150" border = "1">
			<tr align = "center">
				<td>菜单名称</td><td><input type = "text" name = "name" value = "${form.name}"/><span><span>${form.map.name}</span></td>
			</tr>
			<tr align = "center">
				<td>是否为父节点</td><td><input type = "radio" name = "isparent" value = "1" />&nbsp;是&nbsp;&nbsp;&nbsp;&nbsp;
				<input type = "radio" name = "isparent" value = "0"/>&nbsp;否</td>
			</tr>
			<tr align = "center">
				<td>父节点编号</td><td><input type = "text" name = "parentid" value = "${form.parentid}"/>&nbsp;&nbsp;<span>${form.map.parentid}</span></td>
			</tr>
			</table>
			<table width = "400" height = "50">
				<tr >
					<td align = "right"><input type = "submit" value = "添加"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type = "reset" name = "重置"/></td>
				</tr>
			</table>
	</form>
	</div>
	
</body>
</html>