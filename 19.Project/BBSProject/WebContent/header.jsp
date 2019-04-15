<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/font-Awesome-3.2.1/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/style/myStyle.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">绘梦微论坛首页</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="mySendTieList.jsp">我的发帖</a></li>
				<li><a href="myReplyTieList.jsp">我的回帖</a></li>
				 <li><a href="tieView.jsp">查看帖子</a></li>
			</ul>
			<c:if test="${currentUser==null}">
				<form class="navbar-form navbar-right" method="post"
					action="${pageContext.request.contextPath}/userLoginServlet">
					<div class="form-group">
						<input type="text" name="username" placeholder="用户名"
							class="form-control">
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="密码"
							class="form-control">
					</div>
					<button type="submit" class="btn btn-success">登录</button>
				</form>
			</c:if>
			<c:if test="${currentUser!=null}">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">当前用户：&nbsp;${currentUser.nickname}</a></li>
					<li><a href="${pageContext.request.contextPath}/loginOutFzsServlet">注销</a></li>
				</ul>
			</c:if>
		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>
</body>
</html>