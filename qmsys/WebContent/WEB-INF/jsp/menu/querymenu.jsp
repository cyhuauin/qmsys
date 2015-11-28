<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<%-- 
		参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
		--%>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>修改菜单</title>
<script type="text/javascript">
	
</script>
</head>

<body>
	<h1 align="center">修改菜单</h1>
	<hr />
	<div align="center">
		<form action = "${pageContext.request.contextPath}/QueryMenuServlet2.do" method = "post"> 
			<table border="1" width="500" height="300">
				<tr align="center">
					<td>菜单编号</td>
					<td><input type="text" name="mid" readonly = "readonly"
						value="${menu.mid}" /><span>不能修改</span></td>
				</tr>
				<tr align="center">
					<td>是否为父节点</td>
					<td><input type="text" name="isparent" readonly = "readonly"
						value="${menu.isparent}" /><span>不能修改</span></td>
				</tr>
				<tr align="center">
					<td>菜单名称</td>
					<td><input type="text" name="name" value="${menu.name}" />${form.map.name }</td>
				</tr>
				<tr align="center">
					<td>父节点</td>
					<td><input type="text" name="parentid"
						value="${menu.parentid}"/>&nbsp;&nbsp;<span>${message}</span>${form.map.parentid }</td>
				</tr>
				<tr align="center">
					<td>菜单icon</td>
					<td><input type="text" name="icon" value="${menu.icon}" /></td>
				</tr>
				<tr align="center">
					<td>菜单url</td>
					<td><input type="text" name="url" value="${menu.url}" /></td>
				</tr>
				</table>
				<table width="450" height="50">
				<tr align="right">
					<td><input type = "submit" value = "修改"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>