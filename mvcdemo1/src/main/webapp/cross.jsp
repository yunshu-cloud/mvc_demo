<%--
  Created by IntelliJ IDEA.
  User: wangzhixiong
  Date: 2023/8/23
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>跨域请求</title>
  <script src="/js/jquery-2.1.1.min.js"></script>
  <script>
    $(function (){
      $("#btn").click(function () {
        // $.get("http://localhost:8080/m3",function (data) {
        //   console.log(data);
        // })
        $.get("http://127.0.0.1:8888/cross",function (data) {
          console.log(data);
        })
      })
    })
  </script>
</head>
<body>
<button id="btn">异步请求</button>
</body>
</html>
