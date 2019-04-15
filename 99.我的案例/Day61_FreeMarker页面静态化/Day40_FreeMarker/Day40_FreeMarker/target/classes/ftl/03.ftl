<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeMarker模板--对象.属性插值</title>
</head>
<body>
	<#--${....}插值部分-->
	<h1>${"插值内容"}</h1>
	<p>编号:${user.id}</p>
	<p>姓名:${user.name}</p>
	<p>年龄:${user.age}</p>
	<p>身高:${user.height}</p>
</body>
</html>