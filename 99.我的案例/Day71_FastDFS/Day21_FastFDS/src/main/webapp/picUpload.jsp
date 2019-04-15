<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>图片上传到服务器</title>
</head>
<body>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">上传图片到服务器</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" enctype="multipart/form-data"
				method="post" role="form" action="upload/uploadPic">
				<div class="form-group">
					<label for="pic" class="col-sm-2 control-label">图片:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" name="pic"
							id="pic" placeholder="选择要上传的图片">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">上传</button>
					</div>
				</div>
			</form>
		</div>
		
		<hr>
		
		<!-- 上传多张图片 -->
		<div class="panel-heading">
			<h3 class="panel-title">上传多张图片到服务器</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" enctype="multipart/form-data"
				method="post" role="form" action="upload/uploadPics">
				<div class="form-group">
					<label for="pic" class="col-sm-2 control-label">图片1:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" name="pics"
							id="pic" placeholder="选择要上传的图片">
					</div>
				</div>
				<div class="form-group">
					<label for="pic" class="col-sm-2 control-label">图片2:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" name="pics"
							id="pic" placeholder="选择要上传的图片">
					</div>
				</div>
				<div class="form-group">
					<label for="pic" class="col-sm-2 control-label">图片3:</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" name="pics"
							id="pic" placeholder="选择要上传的图片">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">上传</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>