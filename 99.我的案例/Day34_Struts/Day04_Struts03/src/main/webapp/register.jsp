<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单验证</title>
</head>
<body>
	<!-- 表单头部标签,在表单的上面显示一些提示信息 -->
	<s:head/>
	<!-- 显示一些错误信息 -->
	<s:actionerror/>
	<!-- 表单标签 -->
	<s:form action="register.action" method="post" validate="true">
		<table cellpadding="1px" cellspacing="0px" border="1px" width="50%" align="center">
			<tr>
				<s:textfield name="username" label="用户名"/>
			</tr>			
			<tr>
				<s:password name="password" label="密码"/>
			</tr>			
			<tr>
				<s:password name="repassword" label="确认密码"/>
			</tr>
			<tr>
				<s:textfield name="age" label="年龄"/>
			</tr>				
			<tr>
				<s:textfield name="email" label="邮箱"/>
			</tr>				
			<tr>
				<s:textfield name="url" label="网址"/>
			</tr>				
			<tr>
				<s:radio list="{'男','女'}" name="gender" label="性别"/>
			</tr>				
			<tr>
				<s:submit value="提交"/>
			</tr>				
			<tr><s:reset value="重置"/></tr>
		</table>
	</s:form>

</body>
</html>