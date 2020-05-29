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
    <div class="modal fade" id="myModal_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                    <form role="form" id="add_form" method="post" action="/post">
                        <div class="form-group form-inline">
                            <label for="name1">姓名</label>
                            <input type="text" class="form-control" id="name" placeholder="请输入姓名" name="friend_name">
                            <label for="friend_birth1" class="control-label">生日</label>
                            <input type="date"  class="form-control" id="friend_birth" name="friend_birth">
                        </div>
                        <div class="form-group-sm">
                            <label>性别</label>
                            <div class="form-group form-inline">
                                <label for="gender_11">男</label>
                                <input type="radio" name="gender" id="gender_21" value="男">
                                <label for="gender_12">女</label>
                                <input type="radio" name="gender" id="gender_22" value="女">
                            </div>
                            <label for="phoneNum1">手机号码</label>
                            <input type="text" class="form-control" id="phoneNum" name="phoneNum" placeholder="请输入手机号码">
                            <label for="friend_wechat1">微信</label>
                            <input type="text" class="form-control" id="friend_wechat" name="friend_wechat" placeholder="请输入微信号">
                            <label for="friend_QQ1">QQ</label>
                            <input type="text" class="form-control" id="friend_QQ" name="friend_QQ" placeholder="请输入QQ号">
                            <label for="friend_address1">地址</label>
                            <input type="text" class="form-control" id="friend_address" name="friend_address" placeholder="请输入地址">
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" onclick="addFriendSendForm()">
                        确定
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal_alter" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel2">
                        修改好友信息
                    </h4>
                </div>
                <div class="modal-body">
                    <form role="form" id="alter_form" method="post" action="/post">
                        <div class="form-group form-inline">
                            <label for="name1">姓名</label>
                            <input type="text" class="form-control" id="name1" placeholder="请输入姓名" name="friend_name">
                            <label for="friend_birth1" class="control-label">生日</label>
                            <input type="date"  class="form-control" id="friend_birth1" name="friend_birth">
                        </div>
                        <div class="form-group-sm">
                            <label>性别</label>
                            <div class="form-group form-inline">
                                <label for="gender_11">男</label>
                                <input type="radio" name="gender" id="gender_11" value="男">
                                <label for="gender_12">女</label>
                                <input type="radio" name="gender" id="gender_12" value="女">
                            </div>
                            <label for="phoneNum1">手机号码</label>
                            <input type="text" class="form-control" id="phoneNum1" name="phoneNum" placeholder="请输入手机号码">
                            <label for="friend_wechat1">微信</label>
                            <input type="text" class="form-control" id="friend_wechat1" name="friend_wechat" placeholder="请输入微信号">
                            <label for="friend_QQ1">QQ</label>
                            <input type="text" class="form-control" id="friend_QQ1" name="friend_QQ" placeholder="请输入QQ号">
                            <label for="friend_address1">地址</label>
                            <input type="text" class="form-control" id="friend_address1" name="friend_address" placeholder="请输入地址">
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" onclick="alterFriendSendForm()">
                        确定
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <h1>我的好友录</h1>
    <h5>
        <a id="_add" href="javascript:void(0);" onclick="addFriend()" >添加新记录</a>
        <a id="_alter" href="javascript:void(0); "onclick="alterFriend()">修改选中记录</a>
        <a id="_delete" href="javascript:void(0);" onclick="deleteFriend()">删除选中记录</a>
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

<script>
    var url = "./post";
    function addFriend() {
        $('#myModal_add').modal('show')
    }
    function alterFriend() {
        let m = $(":checked[name='alter']");
        if(m.length===0){
            alert('请选择需要更改的friend')
            return
        }
        let _alterFriend = m.parents('tr').find('td')
        ab = [];
        for(i=0;i<_alterFriend.length-1;i++)
        {
            ab.push(_alterFriend[i].innerText);
        }
        // ["锁语梦", "男", "13985904612", "2008-06-26", "18948576903", "18525917840", "青岛市"]
        $('#name1')[0].value = ab[0];
        $("#phoneNum1")[0].value = ab[2];
        if(ab[1]=='男'){
            $("#gender_11").prop("checked", true)
        }
        else{
            $("#gender_12").prop("checked", true)
        }

        $("#friend_birth1")[0].value = ab[3];
        $("#friend_wechat1")[0].value = ab[4];
        $('#friend_QQ1')[0].value = ab[5];
        $("#friend_address1")[0].value = ab[6];
        $('#myModal_alter').modal('show')

    }
    function alterFriendSendForm(){
        let m = $(":checked[name='alter']");
        $.ajax({
                type: "POST",
                url: url+'/alter',
                data:$("#alter_form").serialize()+'&id='+m[0].value,

                async:true,
                success:function (data) {
                    alert(data);
                    window.location.reload();
                },
                error:function (data) {
                    alert(data)
                }
            }
        )
    }
    function addFriendSendForm(){
        $.ajax({
                type: "POST",
                url: url+'/add',
                data:$("#add_form").serialize(),
                async:true,
                success:(data)=>{alert(data);window.location.reload()},
                error:(data)=>{alert(data)}
            }
        )
    }

    function deleteFriend() {
        let friend_id = [];
        let m = $(":checked[name='delete']");
        if(m.length<1){
            alert("请至少选择一个需要删除的行");
            return;
        }
        else {
            alert("确定删除？删除后无法通过任何方式复原！");
        }

        for(i=0;i<m.length;i++){
            friend_id.push(m[i].value)
        }
        let ab = [];
        for(i=0;i<m.length;i++)
        {
            ab.push(m[i].value)
        }

        $.ajax({
            type: "POST",
            url: url+"/delete",
            traditional:true,
            data:{
                post:ab,
                type:"delete"
            },
            async:false,
        success:(data)=>{
            alert(data)
            window.location.reload();},
        error:(data)=>{
            alert(data);
        }});
    }


</script>
</body>
</html>
