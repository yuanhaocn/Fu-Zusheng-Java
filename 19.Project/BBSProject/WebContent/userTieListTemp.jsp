<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>帖子详情</title>
<link
	href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-Awesome-3.2.1/css/font-awesome.min.css">
<link
	href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap3/js/jquery-3.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/style/myStyle.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/tie.css"
	rel="stylesheet">
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

	<div style="margin-top: 60px;"></div>

	<div class="container">
		<div class="row">
			<div class="col-md-9" style="padding: 20px;">
				<!-- Main component for a primary marketing message or call to action -->
				<div class="jumbotron">以下为您发过的帖子</div>
				<!-- 当前用户贴的list -->
				<c:forEach var="userTie" items="${userTieList }">
					<div class="row">
						<div class="col-md-1">
							<a href="#"><img src="images/icon4.jpg" width="50"
								height="50" alt="icon"></a>
						</div>
						<div class="col-md-11">
							<div class="row">
								<div class="col-md-7">回帖人：${replyTie.username }</div>
								<div class="col-md-5">
									回帖时间:『
									<fmt:formatDate value="${replyTie.createTime }" type="date"
										pattern="yyyy-MM-dd HH:mm:ss" />
									』
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">${replyTie.context }</div>
							</div>
						</div>
						<hr style="width: 95%; border: 1px dashed #ccc;" />
					</div>
				</c:forEach>
			</div>

			<div class="col-md-3" style="margin-top: 20px;">
				<div>
					<div class="sidebar-module sidebar-module-inset"
						style="padding: 35px;">
						<div>
							<img alt="user" src="images/icon2.jpg"> <span>昵称：&nbsp;<font
								color="blue">${currentUser.nickname }</font></span>
						</div>
						<div class="dropdown">
							<button class="btn btn-info btn-sm dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								个人中心 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="#">修改邮箱</a></li>
								<li><a href="#">修改密码</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">加入会员</a></li>
							</ul>
						</div>
						<div style="margin-top: 5px;">发帖数：${currentUser.sendnumber}</div>
						<div style="margin-top: 5px;">回帖数：${currentUser.replynumber}</div>
					</div>
				</div>
				<div>发帖小王子（按照发帖数量）</div>
				<div>回帖小王子（按照回帖数量）</div>
			</div>
		</div>
	</div>

	<footer class="blog-footer">
	<p>
		Blog template built for <a href="http://www.bootcss.com/">Bootstrap</a>
		by <a href="#">@稚气未脱</a>.
	</p>
	<p>
		<a href="#">回到顶部</a>
	</p>
	</footer>

</body>
</html>