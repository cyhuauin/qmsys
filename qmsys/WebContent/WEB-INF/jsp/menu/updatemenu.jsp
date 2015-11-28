<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.*,java.sql.*,com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl,com.cust.qmsys.domain.Menuitem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>删改菜单</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<h1 align="center">删改菜单</h1>
	<hr />
	<%
		List<Menuitem> list = new MenuitemDaoImpl().getAllMenuitem();
		request.setAttribute("list", list);
	%>
	<div align="center">
		<form>
			<table border="1" width="500" height="200">
				<tr align="center">
					<th>菜单编号</th>
					<th>菜单名称</th>
					<th>操作</th>
				</tr>
				<c:forEach var="menu" items="${list }">
					<tr align="center">
						<td align="center">${menu.mid}</td>
						<td align="center">${menu.name}</td>
						<td align="center">
						<a href = "javascript:if(confirm('确认删除吗？'))location = '${pageContext.request.contextPath}/DeleteMenuServlet.do?mid=${menu.mid}'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/QueryMenuServlet.do?menu=${menu}">修改</a></td>
					</tr>

				</c:forEach>
			</table>
		</form>
	</div>


</body>
</html>