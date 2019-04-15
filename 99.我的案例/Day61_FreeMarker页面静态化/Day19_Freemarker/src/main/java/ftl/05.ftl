<#--注释部分-->
<#--插值模板的语法-->
<!DOCTYPE html>
<html>
	<head>
		<title>判断类型的标签</title>
	</head>
	<body>
	
		<#-- assign标签是定义变量的标签 -->
		<#assign score=10>
		
		<#if score lt 60>
			<h4>不及格</h4>
		<#elseif score lt 80>
			<h4>良好</h4>
		<#else>
			<h4>优秀</h4>
		</#if>
		
	</body>
</html>

