<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 2020-04-29
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">
  // alert("加载cookie1")

  var cookies=document.cookie.split(';') ;
  function getCK (mkey) {
      for (var i=0;i < cookies.length; i++) {
        var kv = cookies[i].split('=');
        if (kv[0].trim()==mkey) {
            return kv[1].trim();
        }
      }
    return '';
  }
  window.onload=function() {
    var remember = getCK('remember');
    var username = getCK('username');
    var password = getCK('password');
    if (remember =='true') {
      var userNameInput = document.getElementById("username");
      userNameInput.value = username;
      var rememberInput = document.getElementById("remember");
      rememberInput.checked = "checked";
      var passwordInput = document.getElementById("password");
      passwordInput.value = password;
    }
  }

</script>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="#">Link</a>
            </li>
            <li>
              <a href="#">Link</a>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
              <ul class="dropdown-menu">

                <li>
                  <a href="#">One more separated link</a>
                </li>
              </ul>
            </li>
          </ul>
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" />
            </div> <button type="submit" class="btn btn-default">Submit</button>
          </form>

        </div>

      </nav>


      <form role="form" method="post" action="/lab1/LoginServlet">
        <div class="form-group">
          <label >姓名 </label><input type="text" class="form-control" name="username" id="username"/>
        </div>
        <div class="form-group">
          <label>密码</label><input type="password" class="form-control" name="password" id="password"/>
        </div>

        <div class="checkbox">
          <label><input type="checkbox" id="remember"name="remember" value="true" />记住姓名密码</label>
        </div> <button type="submit" class="btn btn-default">提交</button>
      </form>
    </div>
  </div>
</div>
</html>