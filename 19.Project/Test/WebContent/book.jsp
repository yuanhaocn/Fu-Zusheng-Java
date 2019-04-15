<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
<script type="text/javascript">
/* $(document).ready(function(){
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
}); */
</script>
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div name="#rootDiv">
    <table class="table table-hover text-center" >
      <tr>
        <th width="120">ID</th>
        <th>姓名</th>       
        <th>电话</th>
        <th>邮箱</th>
        <th>其他</th>
        <th width="25%">内容</th>
         <th width="120">留言时间</th>
        <th>操作</th>       
      </tr>    
       <c:forEach var="ties" items="${allTie}">
       <tr>
       <td><input type="checkbox" name="id[]" value="1" />${ties.getTieId()}</td>
       <td>${ties.getSendUser() }</td>
        <td>13420925611</td>
        <td>564379992@qq.com</td>  
        <td>${ties.getTheme() }</td>    
        <td>${ties.getSendContent()}</td>
        <td>${ties.getSendTime() }</td>
 		<td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
       </tr>
       </c:forEach> 
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body>
</html>