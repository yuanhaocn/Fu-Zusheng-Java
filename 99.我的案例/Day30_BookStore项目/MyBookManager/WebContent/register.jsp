<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 注册界面 -->
<html>
	<head>
		<title>BookStore--在线注册</title>
		<%--导入css --%>
		<link rel="stylesheet" href="css/main.css" type="text/css" />
		<!-- 刷新验证码 -->
		<script type="text/javascript">
			function changeImage() {
				document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
						+ new Date().getTime();
			}
		</script>
	</head>

	<body class="main">
		<%--导入头部视图 --%>
		<%@include file="head.jsp"%>
		
		<%--导入导航条与搜索 --%>
		<%@include file="menu_search.jsp"%>
	
		<div id="divcontent">
			<!-- 注册表单 -->
			<form action="${pageContext.request.contextPath}/register" method="post">
				<table width="850px" cellspacing="0">
					<tr>
						<td style="padding:30px">
							<!-- 显示注册失败信息 -->
							<h1>新会员注册${msg}</h1>
							<table width="70%" cellspacing="2" class="upline">
								<tr>
									<td style="text-align: right; width: 20%">会员邮箱: </td>
									<td style="width: 40%">
										<input type="text" class="textinput" name="email"/>
									</td>
									<td>
										<font color="#999999">请输入有效的邮箱地址</font>
									</td>
								</tr>
								<tr>
									<td style="text-align: right">会员名: </td>
									<td>
										<input type="text" class="textinput" name="username" />
									</td>
									<td>
										<font color="#999999">用户名设置至少6位</font>
									</td>
								</tr>
								<tr>
									<td style="text-align: right">密码: </td>
									<td>
										<input type="password" class="textinput" name="password" />
									</td>
									<td>
										<font color="#999999">密码设置至少6位</font>
									</td>
								</tr>
								<tr>
									<td style="text-align: right">重复密码: </td>
									<td>
										<input type="password" class="textinput" name="repassword"/>
									</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td style="text-align: right">性别: </td>
									<td colspan="2">
										&nbsp;&nbsp;<input type="radio" name="gender" value="男" checked="checked" /> 男
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="女" /> 女
									</td>
								</tr>
								<tr>
									<td style="text-align:right">联系电话: </td>
									<td colspan="2">
										<input type="text" class="textinput" style="width:350px" name="telephone" />
									</td>
								</tr>
								<tr>
									<td style="text-align:right">个人介绍: </td>
									<td colspan="2">
										<textarea class="textarea" name="introduce"></textarea>
									</td>
								</tr>
							</table>
							<!-- 验证码 -->
							<h1>注册校验</h1>
							<table width="80%" cellspacing="2" class="upline">
								<tr>
									<td style="text-align: right; width: 20%">输入校验码: </td>
									<td style="width: 50%">
										<input type="text" class="textinput" name="imageCode"/>
									</td>
									<!-- 显示校验码错误信息 -->
									<td>&nbsp;<font color='red'>${codemsg}</font></td>
								</tr>
								<tr>
									<td style="text-align: right; width: 20%;">&nbsp;</td>
									<td colspan="2" style="width: 50%">
										<!-- 请求生成验证码 -->
										<img src="${pageContext.request.contextPath}/imageCode" width="180"
											height="30" class="textinput" style="height: 30px;" id="img"/>&nbsp;&nbsp;
										<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
									</td>
								</tr>
							</table>
							<!-- 同意并提交 -->
							<table width="70%" cellspacing="0">
								<tr>
									<td style="padding-top: 20px; text-align: center">
										<input type="image" src="img/signup.gif" name="submit">
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<!-- 引入底部视图 -->
		<%@ include file="foot.jsp" %>
	</body>
</html>
