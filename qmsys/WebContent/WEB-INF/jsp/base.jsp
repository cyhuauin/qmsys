<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
function addQuestion(){
	window.location.href = "add.jsp";
}
function menu(){
	
}
</script>
<title>Insert title here</title>
</head>

<body>
	<c:forEach items="${user.menuitems}" var="menuitem">
		<br/>${menuitem.name }<br/>
		<c:forEach items="${menuitem.childrens }" var="children">
		 ${children.name}
		   		      
			</c:forEach>
	</c:forEach>
</body>
</html>