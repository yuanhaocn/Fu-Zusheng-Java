<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
	<head>
		<title>电子书城-我的账户</title>
		<link rel="stylesheet" href="css/main.css" type="text/css" />
	</head>
	
	<body class="main">
		<jsp:include page="head.jsp" />
		<jsp:include page="menu_search.jsp" />
	
		<div id="divpagecontent">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td width="25%">
						<table width="100%" cellspacing="0" style="margin-top:30px">
							<tr>
								<td class="listtitle">我的帐户</td>
							</tr>
							<tr>
								<td class="listtd">
									<img src="images/miniicon.gif" width="9px" height="6px" />&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath }/findUserServlet?id=${user.id}">用户信息修改</a>
								</td>
							</tr>
							<tr>
								<td class="listtd">
									<img src="images/miniicon.gif" width="9px" height="6px" />&nbsp;&nbsp;&nbsp;&nbsp; 
									<a href="${pageContext.request.contextPath }/findOrderServlet">订单查询</a>
								</td>
							</tr>
							<tr>
								<td class="listtd">
									<img src="images/miniicon.gif" width="9px" height="6px" />&nbsp;&nbsp;&nbsp;&nbsp; 
									<a href="${pageContext.request.contextPath }/logout">用戶退出</a>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<div style="text-align: right; margin: 5px 10px 5px 0px">
							<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
							<a href="myAccount.jsp">&nbsp;我的帐户</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;欢迎
						</div>
						<table cellspacing="0" class="infocontent">
							<tr>
								<td style="padding: 20px">
									<p>
									   <img src="ad/myad.jpg" width="631px" height="436px" />
									</p>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	
		<%@ include file="foot.jsp"%>
	</body>
</html>
