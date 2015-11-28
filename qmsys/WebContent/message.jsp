<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网站全局消息显示页面</title>
</head>
<body>
<p align = "center"><b>${message}</b></p>
<br/>
<br/>
<p align = "center"><b id = "time">5</b>s后回到主页</p>
<p align = "center"><a href = "javascript:rec();">返回上一页</a></p>
<script type="text/javascript">
    //获取显示秒数的元素，通过定时器来更改秒数。
    function count(){
        var time = parseInt(document.getElementById("time").innerHTML);
        if(time > 0){
            document.getElementById("time").innerHTML --;
            setTimeout("count()",1000);
        }else{
            window.history.back();
        }
    }
    setTimeout("count()",500);
    function rec(){
        window.history.back();
    }
</script>
</body>
</html>