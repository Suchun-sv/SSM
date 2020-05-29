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
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h1>我的好友录</h1>
    <hr>
    <div class="modal fade" id="myModal_search" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改好友信息
                    </h4>
                </div>
                <div class="modal-body">
                    <form>
                        <label for="search">模糊搜索名字</label>
                        <input id="search" name="name" type="text">
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" onclick="searchFriendSendForm()">
                        确定
                    </button>
                </div>
            </div>
        </div>
    </div>
<a href="../friend/main">查询所有好友信息</a>
<a href="javascript:void(0)" onclick="show_modal()">按姓名模糊查询好友信息</a>
    <hr>

<script>
    function show_modal() {
        $("#myModal_search").modal('show');
    }
    function searchFriendSendForm() {
        let m = $("#search")[0].value;
        if(m===""){
            alert("请输入名字");
        }else{
            $.ajax({
            type:"POST",
            url:"./post/findByLikeName",
            data:{
                name:m
            },
            success:(data)=>{
                window.location.href = data;
            }
            })
        }


    }
</script>
</body>
</html>
