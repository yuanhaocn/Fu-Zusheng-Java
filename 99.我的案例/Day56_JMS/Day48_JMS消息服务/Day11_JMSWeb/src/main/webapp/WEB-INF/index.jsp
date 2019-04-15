<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ActiveMQ-Queue队列</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">生产者-向队列生产消息</div>
					<div class="panel-body">
						<form id="f1" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">QueueId</label>
								<div class="col-sm-10">
									<input type="text" name="id" class="form-control"
										id="id" placeholder="id">
								</div>
							</div>
							<div class="form-group">
								<label for="country" class="col-sm-2 control-label">Title</label>
								<div class="col-sm-10">
									<input type="text" name="title" class="form-control"
										id="title" placeholder="title">
								</div>
							</div>
							<div class="form-group">
								<label for="weight" class="col-sm-2 control-label">Content</label>
								<div class="col-sm-10">
									<input type="text" name="content" class="form-control"
										id="content" placeholder="content">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="produce" type="button" class="btn btn-default">生产消息</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#produce").click(function() {
				//将表单数据序列化为标准URL编码文本字符串
				$.post("produce", $("#f1").serialize(), function() {
					alert("生产成功");
				});
			});
		});
	</script>

</body>
</html>