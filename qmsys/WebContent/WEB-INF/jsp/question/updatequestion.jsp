<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
<script type="text/javascript">
    function seek(form) {
        alert(1);
        $.ajax({
            type: "POST",
            url: "seekquestion.do",
            data: $('#condition').serialize(),
            dataType: 'json',
            success: function (json) {
                alert("success");

                var obj = eval(json);
                var table_obj = document.getElementById('select');
                var rowNum = table_obj.rows.length;
                for (var i = 1; i < rowNum; i++) {
                    table_obj.deleteRow(i);
                    rowNum = rowNum - 1;
                    i = i - 1;
                }
                for (var i = 0; i < obj.length; i++) {

                    alert("type" + obj[i].type);
                    var str = "<tr><td>" + obj[i].qid;
                    str = str + "</td><td>" + obj[i].body + "</td><td>" + obj[i].score + "</td><td>" + obj[i].score + "</td>";
                    str = str + "<td>" + obj[i].chapter + "</td><td></td><td><a href='javascript:void(0)' onclick='detail(" + obj[i].qid + ")'>详情</a> </td>";
                    str = str + "<td><a href='javascript:void(0)' onclick='deletequestion(" + obj[i].qid + ")'>删除 </a></td></tr> ";
                    $('#select').append(str);
                }

            }
        })

    }
    function detail(qid) {
        alert("    " + qid);

        var type = $('#type option:selected').val();
        alert(type);
        $.ajax({
            type: "POST",
            url: "detailquestion.do",
            data:"type="+type+"&qid="+qid,

            success: function (question) {

              alert(question);
                $.ajax({
                    type: "GET",
                    url: "pageforward.do",
                    data:{page:"/question/detailquestion.jsp"},
                    success: function(data){
                        $('#mainframe2').html(data);
                        $('#detail').append(question);
                        var image = $('#image').val();
                        alert(image);
                        if(image!=null){
                            var img = "<img src='/picture/"+image+"'>";
                            $('#img').append(img);
                        }

                    }
                })




            }
        })
    }
    function deletequestion(qid) {
        alert("    " + qid);
        var type = $("#type option:selected").val();
        alert("  kkk"+type);
        $.ajax({
            type: "POST",
            url: "deletequestion.do",
            data: "type="+type+"&id="+qid,
            dataType: 'json',
            success: function (jieguo) {

                if(jieguo = 1){
                    alert("success");

                }else{
                    alert("error");
                }
                $.ajax({
                    type: "POST",
                    url: "seekquestion.do",
                    data: $('#condition').serialize(),
                    dataType: 'json',
                    success: function (json) {
                        var obj = eval(json);
                        var table_obj = document.getElementById('select');
                        var rowNum = table_obj.rows.length;
                        for (var i = 1; i < rowNum; i++) {
                            table_obj.deleteRow(i);
                            rowNum = rowNum - 1;
                            i = i - 1;
                        }
                        for (var i = 0; i < obj.length; i++) {


                            var str = "<tr><td>" + obj[i].qid;
                            str = str + "</td><td>" + obj[i].body + "</td><td>" + obj[i].score + "</td><td>" + obj[i].score + "</td>";
                            str = str + "<td>" + obj[i].chapter + "</td><td></td><td><a href='javascript:void(0)' onclick='detail(" + obj[i].qid + "," + obj[i].type + ")'>详情</a> </td>";
                            str = str + "<td><a href='javascript:void(0)' onclick='delete(" + obj[i].qid + ")'>删除 </a></td></tr> ";
                            $('#select').append(str);


                        }
                    }
                })
            }
        })
    }

</script>
<div id="mainframe2">

    <form action="seekquestion.do" method="post" name="condition" id="condition">
        科目：<select id="subject" name="subject" onchange="seek(this.form)">

        <%List<Map<String,Object>> subli =(List<Map<String, Object>>)request.getAttribute("sublist");%>

        <% for(int i=0;i<subli.size();i++){%>
        <option value="<%=subli.get(i).get("name")%>"><%=subli.get(i).get("name")%></option>
        <%}%>
    </select>
        题型:<select id="type" name="type" onchange="seek(this.form)">
        <option value="1">选择题</option>
        <option value="2">判断题</option>
        <option value="3">填空题</option>
        <option value="4">简答题</option>
    </select>
        难度：<select id="level" name="level" onchange="seek(this.form)">
        <option value="1">难度</option>
    </select>
        章节<select id="chapter" name="chapter" onchange="seek(this.form)">
        <option value="1">选择题</option>
    </select>
        <button type="button" onclick="seek(this.form)">确定</button>
    </form>
    <br>
    <div id="qu">
        <table border="1" id="select" name="select">
            <tr align="center">
                <td>QID</td>
                <td><a>题干</a></td>
                <td>分数</td>
                <td>难度</td>
                <td>章节</td>
                <td>出题人</td>
                <td>详情</td>
                <td>删除</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>