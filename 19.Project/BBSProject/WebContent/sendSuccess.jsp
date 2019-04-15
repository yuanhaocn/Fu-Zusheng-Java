<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>状态</title>
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/font-Awesome-3.2.1/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		window.setTimeout("location.href='mySendTieList.jsp'",5000);
	});
</script>
<body>

<div class="container" style="margin-top: 200px;">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="jumbotron" style="font-size: 20px;">
				<div>
					<font style="font-size: 30px;"><i class="icon-spinner icon-spin"></i></font>发帖成功！5秒后跳转发帖界面...
				</div>
				<div>
					您也可以直接点击<a href="${pageContext.request.contextPath}/mySendTieList.jsp"><font style="font-size: 24px;"><i class="icon-reply"></i>返回</a></font>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>

</body>
</html>