<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/23
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>上传</title>
  <script src="/js/jquery-2.1.1.min.js"></script>
  <script src="/js/jquery.form.js"></script>
</head>
<body>
<h3>文件上传</h3>
<form id="ajaxForm" enctype="multipart/form-data" >
  <input type="file" name="file"/>
  <%-- 按钮类型不能是submit，否则会刷新页面  --%>
  <input type="button" value="上传头像" id="btn"/>
</form>
<%-- 上传头像后展示的位置 --%>
<img src="/" width="100" id="header">
<script>
  $(function () {
    $("#btn").click(function () {
      // 异步提交表单
      $("#ajaxForm").ajaxSubmit({
        url:"/fileUpload4",
        type:"post",
        success:function (data) {
          $("#header").attr("src",data);
        }
      })
    })
  })
</script>
</body>
</html>
