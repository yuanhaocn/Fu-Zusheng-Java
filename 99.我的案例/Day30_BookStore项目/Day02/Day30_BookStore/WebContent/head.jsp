<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 头部视图 -->
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
				<a href="index.jsp">
					<img src="img/logo.png" width="95" height="30" border="0" />
				</a>
			</td>
			<td style="text-align:right">
				<img src="img/cart.gif" width="26" height="23" style="margin-bottom:-4px" />
				&nbsp;<a href="cart.jsp">购物车</a>
				| <a href="#">帮助中心</a> 
				| <a href="${pageContext.request.contextPath}/myAccount">我的帐户</a>
				| <a href="register.jsp">新用户注册</a>
			</td>
		</tr>
	</table>
</div>