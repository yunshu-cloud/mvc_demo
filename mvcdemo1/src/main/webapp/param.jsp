<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/22
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单提交</title>
</head>
<body>
<form action="/c1/param3" method="post">
    id:<input name="id">
    姓名:<input name="name">
    性别:<input name="sex">
    住址:<input name="address.info">
    邮编:<input name="address.postcode">
    <input type="submit">
</form>
</body>
</html>
