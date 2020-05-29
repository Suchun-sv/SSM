<%--
  Created by IntelliJ IDEA.
  User: X1 Yoga
  Date: 2020/5/2
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <h1>你好啊，在登录吗</h1>
    <c:forEach items="${user}" var="temp" >
        <h3>${temp}</h3>
    </c:forEach>

</head>
<body>

</body>
</html>
