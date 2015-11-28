<%@ page import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: 源
  Date: 2015/10/24
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>

    <title></title>
</head>
<script type="text/javascript">
    function updatequestion(form) {
        alert(1);
    $.ajax({
        type : "POST",
        url : "updatequestion.do",
        data : $('#update').serialize(),
        success : function(page){
            alert ("修改成功");
            $('#detailpage').html(page);
        }

    })
    }


</script>

<body>
<div id="detailpage">
    <form action="updatequestion.do" method="post" name="update" id="update">
        <table name="detail" id="detail"></table>
        <div id="img"></div>
        <button type="button" onclick="updatequestion(this.form)">确认修改</button>
    </form>
</div>

</body>
</html>
