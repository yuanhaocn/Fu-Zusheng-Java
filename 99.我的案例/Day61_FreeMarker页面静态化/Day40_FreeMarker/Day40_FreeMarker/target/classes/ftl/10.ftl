<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeMarker模板--字符串格式化</title>
</head>
<body>
	<#-- setting,更改默认的设置 -->
	<#setting number_format="currency">
	
	<#assign msg=100>
	<p>字符串格式:${msg}</p>
	<p>字符串格式:${msg?string}</p>
	<p>数字格式:${msg?string.number}</p>
	<p>货币格式:${msg?string.currency}</p>
	<p>百分比格式:${msg?string.percent}</p>
	
	<#assign info=" 消 息 内 容  ">
	<p>去除空格:${info?trim}</p>
	
	<#assign flag=false>
	<p>布尔型处理:${flag?string("yes","no")}</p>
	
	<#assign name="syc">
	<p>内建函数:${name?upper_case}</p>
	<p>内建函数:${name?lower_case}</p>
	<p>内建函数:${name?cap_first}</p>
</body>
</html>