<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="GBK">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录</title>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style>
        /*web background*/
        .container{
            display:table;
            height:100%;
        }

        .row{
            display: table-cell;
            vertical-align: middle;
        }
        /* centered columns styles */
        .row-centered {
            text-align:center;
        }
        .col-centered {
            display:inline-block;
            float:none;
            text-align:left;
            margin-right:-4px;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>欢迎登录</h2>
            <%--      <form action="/spring/login" method="post" role="form">--%>
            <form id="fm" role="form" action="user/login" method="post">
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户ID"/>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" ><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                </div>
                <br/>
                <button type="submit" id="Submit" class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<!-- <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<%--<script>--%>
<%--    $("#Submit").click(function () {--%>
<%--        $.ajax({--%>
<%--            type: "POST",   //提交的方法--%>
<%--            url:"/spring/login", //提交的地址--%>
<%--            data:$('#fm').serialize(),// 序列化表单值--%>
<%--            async: true,--%>
<%--            error: function(request) {  //失败的话--%>
<%--                alert("Connection error");--%>
<%--            },--%>
<%--            success: function(data) {  //成功--%>
<%--                alert(data);  //就将返回的数据显示出来--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>