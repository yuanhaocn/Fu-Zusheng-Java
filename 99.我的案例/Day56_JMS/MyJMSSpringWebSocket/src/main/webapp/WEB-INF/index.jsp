<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring-ActiveMQ</title>
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
		<p class="well">ActiveMQ消息服务</p>
		<div class="row">
			<div class="col-md-12">
				<div id="log-container" class="well"
					style="height: 200px; color: #aaa; background: #333; overflow-y: scroll">
					<div>
						控制台输出:<br>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">生产者-向队列生产消息</div>
					<div class="panel-body">
						<form id="f1" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="mailid" class="col-sm-2 control-label">mailid</label>
								<div class="col-sm-10">
									<input type="text" name="mailId" class="form-control"
										id="mailid" placeholder="mailid">
								</div>
							</div>
							<div class="form-group">
								<label for="country" class="col-sm-2 control-label">country</label>
								<div class="col-sm-10">
									<input type="text" name="country" class="form-control"
										id="country" placeholder="country">
								</div>
							</div>
							<div class="form-group">
								<label for="weight" class="col-sm-2 control-label">weight</label>
								<div class="col-sm-10">
									<input type="text" name="weight" class="form-control"
										id="weight" placeholder="weight">
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

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">发布-向话题发布消息</div>
					<div class="panel-body">
						<form id="f2" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="mailid" class="col-sm-2 control-label">mailid</label>
								<div class="col-sm-10">
									<input type="text" name="mailId" class="form-control"
										id="mailid" placeholder="mailid">
								</div>
							</div>
							<div class="form-group">
								<label for="country" class="col-sm-2 control-label">country</label>
								<div class="col-sm-10">
									<input type="text" name="country" class="form-control"
										id="country" placeholder="country">
								</div>
							</div>
							<div class="form-group">
								<label for="weight" class="col-sm-2 control-label">weight</label>
								<div class="col-sm-10">
									<input type="text" name="weight" class="form-control"
										id="weight" placeholder="weight">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="publish" type="button" class="btn btn-default">发布消息</button>
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

			$("#publish").click(function() {
				$.post("topic", $("#f2").serialize(), function() {
					alert("发布成功");
				});
			});
		});
	</script>
	
	<!-- h5中WebSocket的使用:
		 1.创建对象:
			var ws = new WebSocket(url,name);
			url为WebSocket服务器的地址,name为发起握手的协议名称,为可选择项.
		 2.发送文本消息:
		   ws.send(msg);
		   msg为文本消息,对于其他类型的可以通过二进制形式发送。
		 3.接收消息:
		   ws.onmessage = (function(){...})();
		 4.错误处理:
		   ws.onerror = (function(){...})();
		 5.关闭连接:
		   ws.close();
	-->
	<!-- 利用WebSocket向服务端发起请求 -->
	<script>
		$(document).ready(function() {
				// 指定websocket路径
				var websocket = new WebSocket('ws://localhost:8080/MyJMSSpring/ws');
				//websocket.send("客户端消息...");
				websocket.onmessage = function(event) {
					var data = JSON.parse(event.data);
					console.log("data====>"+data);
					// 接收服务端的实时日志并添加到HTML页面中
					$("#log-container div").append(data.text + "<p>"+data.date+"</p>");
					// 滚动条滚动到最低部
					$("#log-container").scrollTop($("#log-container div").height()- $("#log-container").height());
			};
		});
	</script>
</body>
</html>