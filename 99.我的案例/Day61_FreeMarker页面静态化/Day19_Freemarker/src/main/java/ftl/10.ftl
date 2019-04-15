<#--注释部分-->
<#--插值模板的语法-->
<!DOCTYPE html>
<html>
	<head>
		<title>格式化函数</title>
	</head>
	<body>
		<#-- setting用来更改默认的设置 -->
		<#setting number_format="percent">
		
		<#assign num=100>
		
		<p>普通格式:${num}</p>
		<p>普通格式2:${num?string}</p>
		<p>数字格式:${num?string.number}</p>
		<p>货币格式:${num?string.currency}</p>
		<p>百分比格式:${num?string.percent}</p>
		
		<#assign msg=" 带 空 格     的字 符 串    ">
		<p>去除空格:${msg?trim}</p>
		
		<#assign flag=false>
		<p>布尔类型:${flag?string("正确","错误")}</p>
		
		<#assign name="syc">
		<p>字母大小写转换:${name?upper_case}</p>
		<p>字母大小写转换:${name?lower_case}</p>
		<p>字母大小写转换:${name?cap_first}</p>
		
	</body>
</html>

