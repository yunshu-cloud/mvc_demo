<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/22
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC方式上传</title>
</head>
<body>
  <form action="/fileUpload2" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
  </form>

</body>
</html>
