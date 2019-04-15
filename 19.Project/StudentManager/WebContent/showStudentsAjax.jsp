<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="${pageContext.request.contextPath}/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		 $("#mybtn").click(function(){
			  $.get("${pageContext.request.contextPath}/selectStudentsAjaxServlet",function(date){
				  for(var i in date){
					  
				  }
				  alert(date);
				  
			  });
		 });
	}); 
</script>
</head>
<body>
	<button id="mybtn">展示所有的数据</button>
	<br />
	<table>
		<thead></thead>
		<tbody id=mytab"></tbody>
	</table>
</body>
</html>