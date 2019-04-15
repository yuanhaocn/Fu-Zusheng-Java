<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap3/js/jquery-3.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/style/myStyle.css"
	rel="stylesheet">
</head>
<body>
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
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
	

	<div style="margin-top: 10px;"></div>

	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">绘梦微论坛</h1>
			<p class="lead blog-description">hehehehehehehe...呵呵呵，哈哈哈</p>
		</div>

		<div class="row">
			<div class="col-md-9">
				<c:forEach var="sendTie" items="${sendTieList }">
					<div class="row">
						<div class="col-md-1">
							<a href="#"><img src="images/icon3.jpg" width="50"
								height="50" alt="icon"></a>
						</div>
						<div class="col-md-11">
							<div class="row">
								<div class="col-md-7">
									<a href="viewTie?sendTieId=${sendTie.id }">${sendTie.title }</a>
								</div>
								<div class="col-md-5">
									<%-- 时间:『<fmt:formatDate value="${sendTie.createTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>』 --%>
								</div>
							</div>
							<div class="row">
								<div class="col-md-7">
									<%-- ${fn:substring(sendTie.context,0,25) } --%>
								</div>
								<div class="col-md-5">发帖人：${sendTie.nickname }</div>
							</div>
						</div>
						<hr style="width: 95%; border: 1px dashed #ccc;" />
					</div>
				</c:forEach>

				<!-- 分页 -->
				<nav aria-label="Page navigation" class="text-center">
				<ul class="pagination">${pageCode }
				</ul>
				</nav>


				<form class="form-horizontal" id="myForm" method="post"
					action="${pageContext.request.contextPath}/sendTieServlet">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-1 control-label">主题</label>
						<div class="col-sm-11">
							<input type="text" class="form-control" name="theme" id="title"
								placeholder="主题">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-1 control-label">内容</label>
						<div class="col-sm-11">
							<textarea class="form-control" name="sendcontent" id="content"
								rows="8" style="resize: none;" placeholder="内容"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-11">
							<button type="submit" class="btn btn-primary">发新贴</button>
							&nbsp;&nbsp;<font id="error" color="red"></font>
						</div>
					</div>
				</form>

			</div>
			<c:if test="${currentUser!=null}">
				<div class="col-md-3">
					<div>
						<div class="sidebar-module sidebar-module-inset"
							style="padding: 35px;">
							<div>
								<img alt="user" src="images/icon2.jpg"> <span>昵称：&nbsp;<font
									color="blue">${currentUser.nickname}</font></span>
							</div>
							<div class="dropdown">
								<button class="btn btn-info btn-sm dropdown-toggle"
									type="button" id="dropdownMenu1" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="true">
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
			</c:if>
		</div>
	</div>

</body>
</html>