<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<!-- 表单标签 -->
	<s:form action="login.action" method="post" validate="true">
		<!-- 给表单添加s:token标签,用来防止该表单重复提交! -->
		<s:token/>
		<table cellpadding="1px" cellspacing="0px" border="1px" width="50%" align="center">
			<tr>
				<s:textfield name="username" label="用户名"/>
			</tr>			
			<tr>
				<s:password name="password" label="密码"/>
			</tr>			
			<tr>
				<s:submit value="提交"/>
			</tr>				
		</table>
	</s:form>

</body>
</html>