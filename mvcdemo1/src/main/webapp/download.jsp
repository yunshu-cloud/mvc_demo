<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/23
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>下载</title>
</head>
<body>
<h3>文件下载</h3>
<%-- 遍历文件集合 --%>
<c:forEach items="${files}" var="file">
    <a href="/download?fileName=${file}">${file}</a><br/>
</c:forEach>
</body>
</html>

