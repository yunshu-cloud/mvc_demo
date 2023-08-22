<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/22
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/fileUpload3" method="post" enctype="multipart/form-data">
        用户名：<input name="username"/>
        文件1：<input type="file" name="files"/>
        文件2：<input type="file" name="files"/>
        <input type="submit" value="上传"/>
    </form>

</body>
</html>
