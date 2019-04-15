<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- struts框架的标签库 -->
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="title"/></title>
</head>
<body>
	<!-- s:i18n,专门的国际化标签 -->
	<s:i18n name="com.syc.struts.resource">
		<s:text name="title"/>
		<s:text name="username"/>
		<s:text name="password"/>
		<s:text name="login"/>
	</s:i18n>
</body>
</html>