<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/css.css" />
<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="js/jiaoyan.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript">
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
</script>

<!-- 初始化时默认选中
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".Switch").click(function() {
			$(".left").toggle();
		});
	});
</script> -->
</head>
<body>
	<div class="header">
		<div class="logo">
			<img src="img/logo.png" />
		</div>

		<div class="header-right">
			<i class="icon-question-sign icon-white"></i> 
			<a href="#">帮助</a> 
			<i class="icon-off icon-white"></i>
			<a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
			<i class="icon-user icon-white"></i> 
			<a href="#">开票员的工作平台</a> 
			<i class="icon-envelope icon-white"></i> 
			<a href="#">发送短信</a>
			<div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 300px; margin-left: -150px; top: 30%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">注销系统</h3>
				</div>
				<div class="modal-body">
					<p>您确定要注销退出系统吗？</p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					<a class="btn btn-primary" style="line-height: 20px;" href="登录.html">确定退出</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 顶部 -->

	<div id="middle">
		<script type="text/javascript">
		function pageforward(forward){
			alert(forward);
			$.ajax({
			 	type: "GET",
				url: "pageforward.do",
			    data: {page:forward},
			    success: function(data){
					$("#mainFrame").html(data);
			    }
			})
		}
		</script>
		<div class="left">
			<div id="my_menu" class="sdmenu">
				<c:forEach items="${user.menuitems}" var="menuitem">
				<div><!-- class="collapsed" 把这个class去掉的话 默认全部打开 -->
					<span>${menuitem.name }</span> <!-- ${children.url } -->
					<c:forEach items="${menuitem.childrens }" var="children">
						<a href="javascript:void(0)" onclick="pageforward('${children.url }')">${children.name }</a> 
					</c:forEach>
				</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="Switch"></div>
		
		<div class="right" id="mainFrame">
		
		</div>
		
	</div>
</body>
</html>