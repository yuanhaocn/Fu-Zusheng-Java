<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>电子书城--管理菜单</title>
		<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
		<link rel="StyleSheet" href="${pageContext.request.contextPath}/admin/css/dtree.css" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>		
	</head>
	<body>
		<table width="100" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td height="12"></td>
		  </tr>
		</table>
		<table width="100%" border="0">
			<tr>
			    <td>
				  <div class="dtree">
					<a href="javascript: d.openAll();">展开所有</a> 
					| <a href="javascript: d.closeAll();">关闭所有</a>
					
					<script type="text/javascript">
						d = new dTree('d');
						d.add(0,-1,'系统菜单树');
						d.add(1,0,'商品管理','${pageContext.request.contextPath}/admin/login/welcome.jsp','','mainFrame');
						//子目录添加---->list.jsp商品列表
						d.add(8,1,'商品查看','${pageContext.request.contextPath}/bookListServlet','','mainFrame');
						document.write(d);
					</script>
				</div>	
			  </td>
			</tr>
		</table>
	</body>
</html>
