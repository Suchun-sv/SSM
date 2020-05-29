<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>好友录</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>我的好友录</h1>
    <h5>
        <a id="_add" href="">添加新记录</a>
        <a id="_alter" href="">修改选中记录</a>
        <a id="_delete" href="">删除选中记录</a>
    </h5>
    <hr>
    <table class="table table-hover table-bordered border-shadow" style="padding-top: 10rem">
        <thead>
        <tr>
            <th>#</th>
            <%--            <th>id</th>--%>
            <th>姓名</th>
            <th>性别</th>
            <th>手机号码</th>
            <th>生日</th>
            <th>微信号码</th>
            <th>QQ号码</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!--s-->
        <c:forEach items="${user}" var="temp" varStatus="varstatus">
            <tr>
                <th scope="row">${varstatus.index}</th>
                <td>${temp.name}</td>
                <td>${temp.gender}</td>
                <td>${temp.phoneNum}</td>
                <td>${temp.birth}</td>
                <td>${temp.weChat}</td>
                <td>${temp.QQ}</td>
                <td>${temp.address}</td>
                <td>
                    <label>
                        修改<input name="alter" type="radio"  value="${temp.id}">
                    </label>
                    <label>
                        删除<input name="delete" type="checkbox"  value="${temp.id}">
                    </label>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr>

</div>


</body>
</html>
