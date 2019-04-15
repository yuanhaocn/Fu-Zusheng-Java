<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeMarker模板--指令</title>
</head>
<body>
	<#-- #assign:用来定义变量的指令 -->
	<#assign score=90>
	
	<#if score lt 60>
		<h3>不及格!</h3>
	<#elseif score lt 80>
		<h3>一般!</h3>
	<#else>
		<h3>合格!</h3>
	</#if>
																	
</body>
</html>