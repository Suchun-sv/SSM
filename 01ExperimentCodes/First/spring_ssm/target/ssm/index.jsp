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
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.0/jquery.js"></script>
<%--    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script> --%>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/md5.js"></script>
<%--    <script src="http://www.gongjuji.net/Content/files/jquery.md5.js"></script>--%>
    <script src="./js/jquery.md5.js"></script>
    <script src="./js/jquery.cookie.js"></script>
    <script>
    $(document).ready(function(){
        // var md5_3 = $.md5("abc");
    var remUsername = $.cookie("remUsername");
    var remPassword = $.cookie("remPassword");
    if(remUsername){
    $("#saveUsername").prop("checked",true);
    $("#username").val($.cookie("username"));
    }
    if(remPassword){
        $("#is_remembered").val(1);
        $("#savePassword").prop("checked",true);
        $("#password").val($.cookie("password"));
    }
    });
    </script>
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
                <input type="hidden" id="is_remembered" name="is_remembered" placeholder="cookie用" value="0">
                <br/>
                <button type="submit" id="Submit" class="btn btn-success btn-block">登录</button>
                <label>
                <input type="checkbox"  id="saveUsername">保存用户名
                </label>
                <label>
                    <input type="checkbox"  id="savePassword">保存密码
                </label>
            </form>
        </div>
    </div>
</div>

<%--a59849d749dae87d9da3e8f0e159febf--%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<!-- <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
<%--<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>--%>
<%--<script src="js/jquery.md5.js"></script>--%>

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
<script>
$("#saveUsername").change(function(){
if($("#saveUsername").prop("checked")){
var username = $("#username").val();

$.cookie("remUsername","true",{expires:7});
$.cookie("username",username,{expires:7 });
}else{
$.cookie("remUsername","false",{expires:-1});
$.cookie("username","",{ expires:-1 });
}
});
</script>
<script>
   $("#savePassword").change(function() {
        if ($("#savePassword").prop("checked")) {
            var password = $("#password").val();
            var userName = $("#username").val();
            var expire_time = 7;
            var web_key = 2745;
            if($("#is_remembered").val() == "0" ) {
                $.cookie("password", $.md5(userName + expire_time + web_key + password), {expires: expire_time});
                $("#password").val($.cookie("password"));
                $("#is_remembered").val(1);
            }
            $.cookie("remPassword", true,{expires:7});
        }
        else
        {
            $("#is_remembered").val(0);
            $.cookie("remPassword","false",{expires:-1});
            $.cookie("password","",{ expires:-1 });
        }
    });
</script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<
</body>
</html>