<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>我的回帖</title>
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/font-Awesome-3.2.1/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/style/myStyle.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function(){
		$.get("${pageContext.request.contextPath}/autoQueryTiesServlet",function(info){
			for(var i in info){
				var outerDiv = $("<div class='row'></div>");
				var themeDiv = $("<div class='row'></div>");
				outerDiv.html("<div class='col-md-12'>发帖主题："+info[i].theme+"</div>");
				var sendTimeDiv = $("<div class='row'></div>");
				sendTimeDiv.html("<div class='col-md-10'>发帖时间："+info[i].sendTime+"</div><div class='col-md-2'>	<button data-toggle='modal' onclick='preUpdateMySendTie("+info[i].tieId+")'  class='btn btn-primary btn-xs' >修改</button>	<button  class='btn btn-danger btn-xs' data-toggle='modal' onclick='preDeleteMySendTie("+info[i].tieId+")' id='delete_"+info[i].tieId+"'>删除</button></div>");
				var sendContentDiv = $("<div class='row'></div>");
				sendContentDiv.html("<div class='col-md-12'>发帖内容："+info[i].sendContent+"</div>");
				//设置OuterDiv
				outerDiv.append(themeDiv);
				outerDiv.append(sendTimeDiv);
				outerDiv.append(sendContentDiv);
				//绑定rootdiv
				$("#rootDiv").append(outerDiv);
			}
		},"json");
	});
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">绘梦微论坛首页</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="mySendTieList.jsp">我的发帖</a></li>
				<li><a href="myReplyTieList.jsp">我的回帖</a></li>
				 <li><a href="tieView.jsp">查看帖子</a></li>
			</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">当前用户：&nbsp;${currentUser.nickname}</a></li>
					<li><a href="${pageContext.request.contextPath}/loginOutFzsServlet">注销</a></li>
				</ul>
		</div>
		<!--/.navbar-collapse -->
	</div>
	</nav>

<div style="margin-top: 60px;"></div>

<div class="container">
  <div class="row">
  
  
  
    <div class="col-md-9" style="padding: 20px;" id="rootDiv">
      <div class="jumbotron">
      	 <!-- 分页操作 -->
      	<div class="row">
      	<div class="col-md-3 col-sm-3">首页</div>
      	<div class="col-md-3 col-sm-3">前一页</div>
      	<div class="col-md-3 col-sm-3">下一页</div>
      	<div class="col-md-3 col-sm-3">尾页</div>
      	</div>
      </div>
			<!-- list后的分页 -->
			<nav aria-label="Page navigation" class="text-center">
					<ul class="pagination">
					${myPageCode}
				</ul>
			</nav> 
    </div>
    
    
    
    <div class="col-md-3" style="margin-top: 20px;">
    	<div>
			  <div class="sidebar-module sidebar-module-inset" style="padding: 35px;">
	            <div>
	            	<img alt="user" src="images/icon2.jpg">
	            	<span>昵称：&nbsp;<font color="blue">${currentUser.nickname }</font></span>
	            </div>
	            <div class="dropdown">
				  <button class="btn btn-info btn-sm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    个人中心
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">修改邮箱</a></li>
				    <li><a href="#">修改密码</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">加入会员</a></li>
				  </ul>
				</div>
				<div style="margin-top: 5px;">发帖数：${currentUser.sendnumber }</div>
				<div style="margin-top: 5px;">回帖数：${currentUser.replynumber }</div>
	          </div>
		</div>
		<div>发帖小王子（按照发帖数量）</div>
		<div>回帖小王子（按照回帖数量）</div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">请输入要修改的帖子(修改后覆盖原贴的标题和内容)：</h4>
      </div>
      <div class="modal-body" id="modal-body1">
		<form name="formUpdate" id="formUpdate" method="post" action="">
          <div class="form-group">
            <label for="recipient-name" class="control-label">主题:</label>
            <input type="text" class="form-control" name="title" id="title">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">内容:</label>
            <textarea class="form-control" rows="8" style="resize:none;" name="context" id=context></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="updateMySendTie()">修改</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">提示：</h4>
      </div>
      <div class="modal-body" id="modal-body2">
		...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="deleteMySendTie()">确认</button>
      </div>
    </div>
  </div>
</div>


</body>
<script type="text/javascript">
	var id;
	function preUpdateMySendTie(x){
		//此处使用模态框传值
		id=x;
		$("#myModal1").modal();
	}
	function updateMySendTie(){
	 	//取表单，提交表单
	    var url = "tieOperate?action=sendUpdate&id="+id;  
	    //更改form的action  
	    $("#formUpdate").attr("action", "${pageContext.request.contextPath}/updateTieFzsServlet?tieId="+id);  
	    //触发submit事件，提交表单   
	    $("#formUpdate").submit();    
	    
		/* JSON数据应该至少包含 tieid theme 和sendcontent  
			获取修改后的theme 和sendcontent内容 */
		/*  
		var theme=$("#title").val();
		var sendContent=$("#context").val();
		 $.get("{pageContext.request.contextPath}/updateTieFzsServlet",
			/* 	updatetie就是一个JSON格式的数据  */
				/* {"tieId":id,"theme":theme,"context":context},
				 function(info){ */
			/*  info 应该包含   
		 }); */
	}
	
	function preDeleteMySendTie(x){
		$("#modal-body2").text("您确认要删除这个帖子吗？");
		id=x;
		$("#myModal2").modal();
	}
	function deleteMySendTie(){
		$.get("${pageContext.request.contextPath}/deleteTieServlet",{"tieId":id},function(){
			$("#delete_"+id).parent().parent().parent().remove();
			/*
			$this.parent.remove();
			*/
		});
	}
</script>
</html>