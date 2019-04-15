<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>新薪相赢人事管理 - 登录</title>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/layui/css/layui.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome.css" rel="stylesheet">
    <link href="${ctx}/css/animate.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
    <link href="${ctx}/css/login.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>[ 新薪相赢 ]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>新薪相赢人事管理系统</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 银行级安全</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 多平台覆盖</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 专家专业团队</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 坚实品牌基础</li>
                </ul>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" action="login">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到新薪相赢后台</p>
                <input type="text" class="form-control uname" placeholder="用户名" name="loginname" value="${cookie['loginName'].value}" />
                <input type="password" class="form-control pword m-b" placeholder="密码" name="password" />
                <!-- ${cookie['remeber'].value}=checked="checked" -->
                <input type="checkbox" style="color:red" id="ishave" name="ishave" value="remember" ${cookie['remember'].value}/>&nbsp;记住账号
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2017-2099 新薪相赢 All Rights Reserved.
        </div>
    </div>
</div>
</body>

</html>

