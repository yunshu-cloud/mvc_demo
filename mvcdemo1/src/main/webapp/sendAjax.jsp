<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/22
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ajax请求</title>
  <script src="/js/jquery-2.1.1.min.js"></script>
  <script>
    $(function () {
      $("#btn").click(function () {
        var name = $("#name").val();
        var sex = $("#sex").val();
        $.post("/student/addStudent",{"name":name,"sex":sex},function (data){
          console.log(data);
        });
      });
    });
  </script>
</head>
<body>
姓名：<input id="name"/><br/>
性别：<input id="sex"/><br/>
<input type="button" value="提交" id="btn"/>
</body>
</html>

