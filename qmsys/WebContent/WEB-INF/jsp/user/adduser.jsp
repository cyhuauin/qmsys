<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增出题人</title>
<script type="text/javascript">
function checkMobile(){
         			var sMobile = document.mobileform.mobile.value;
 					if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))){
 						alert("不是完整的11位手机号或者正确的手机号前七位");
 						document.mobileform.mobile.focus(); 
						return false; 
					} 
				}
 if(document.getElementById("uid").value.length == null){  
					alert("您输入的ID不符合要求");
 }
 
 if(document.getElementById("password").value.length (< 0&& >10)){  
		alert("您设置的密码不符合要求");
 }

 </script>
</head>
<body>
这里是添加出题人的页面<br/>
-----------------------------------------------------

<form action="/addUser" method="post">
	<table border = "1">
		<tr>
			<td>姓名：</td>
			<td><input name="username" type="text"/></td>
		</tr>
		<tr>
		    <td>性别:</td>
		    <td><input type="radio" name="usex" value="男" />男
		    <input type="radio" name="usex" value="女" />女</td>
		</tr>
		<tr>
			<td>手机号码：</td>
			<td><input name="phone" type="text" maxlength=11/>
		    </td>
		</tr>
		<tr>
			<td>专业：</td>
			<td><input name="subjects" type="text"></td>
		</tr>
		<tr>
			<td>电子邮箱：</td>
			<td><input name="email"  type="text">
  			 </td>
		</tr>
		<tr>
			<td>出题人ID：</td>
			<td><input name="uid"  type="text">
			</td>
		<tr>
		<tr>
			<td>设置密码：</td>
			<td><input name="password" type="text"></td>
	    </tr>
	    <tr>
			<td></td>
			<td><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>

</body>
</html>
