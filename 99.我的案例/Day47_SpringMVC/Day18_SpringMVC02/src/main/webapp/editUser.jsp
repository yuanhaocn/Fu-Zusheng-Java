<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	td{
		text-align: center;
		margin: 0 auto;
	}
	
	input{
		width: 90%;
	}
	
	/* rgb=6位,argb=8位 */
	.btn{
		width:30%;
		background-color: #aa999999;
	}
</style>
<title>编辑用户信息</title>
</head>
<body>
	<form action="editUser.action" method="post">
		<table border="1px" width="50%" align="center" cellpadding="2px"
			cellspacing="0px">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="user.username"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="user.age" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="user.address" /></td>
			</tr>
			<tr>
				<td>日期</td>
				<td><input type="text" name="user.birthday" /></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn" type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>