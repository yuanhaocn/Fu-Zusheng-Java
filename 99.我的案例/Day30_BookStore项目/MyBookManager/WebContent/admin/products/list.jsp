<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/add.jsp";
	}
</script>
<script type="text/javascript">
	//询问用户是否真的要删除某本书
	function DelBook(name, id) {
		if (confirm("你真的要删除" + name + "这本书吗?")) {
			location.href = "${pageContext.request.contextPath}/deleteBook?id="
					+ id;
		}
	}
	//根据全选复选框是否被选中，让下边的复选框选中或不选中
	function CheckAll() {
		var value = document.getElementById("ck").checked;//得到全选复选框对象
		var cks = document.getElementsByName("cki");//得到所有的每个商品前的复选框
		//遍历每个复选框，把每个复选框的checked属性的值设置为全选复选框的checked属性的值
		for (var i = 0; i < cks.length; i++) {
			cks[i].checked = value;
		}
	}
	//实现批量删除
	function DelBooks() {
		//得到所有的每个商品前的复选框对象
		var cks = document.getElementsByName("cki");
		var str = "";
		for (var i = 0; i < cks.length; i++) {
			//判断复选框是否被选中
			if (cks[i].checked) {
				str += "ids=" + cks[i].value + "&";//?ids=0002&ids=0003&
			}
		}
		//删除最后的&符号
		str = str.substring(0, str.length - 1);
		//alert(str);
		//执行servlet
		location.href = "${pageContext.request.contextPath}/deleteBook?" + str;

		//用表单提交处理
		//得到第二个表单
		var form = document.forms[1];
		form.submit();//提交表单
	}
</script>
</HEAD>
<body>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查询条件</strong>
				</td>
			</tr>
			<tr>
				<td>
					<form id="Form1" name="Form1"
						action="${pageContext.request.contextPath}/searchBooksServlet"
						method="post">
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">商品编号</td>
								<td class="ta_01" bgColor="#ffffff">
								<input type="text" name="id" size="15" id="Form1_userName" class="bg" /></td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">类别:</td>
								<td class="ta_01" bgColor="#ffffff">
									<select name="category" id="category">
										<option value="" selected="selected">--选择商品类加--</option>
											<option value="文学">文学</option>
											<option value="生活">生活</option>
											<option value="计算机">计算机</option>
											<option value="外语">外语</option>
											<option value="经营">经营</option>
											<option value="励志">励志</option>
											<option value="社科">社科</option>
											<option value="学术">学术</option>
											<option value="少儿">少儿</option>
											<option value="艺术">艺术</option>
											<option value="原版">原版</option>
											<option value="科技">科技</option>
											<option value="考试">考试</option>
											<option value="生活百科">生活百科</option>	
									</select>
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">商品名称:</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text" name="name" size="15" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">价格区间(元):</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text" name="minprice" size="10"/>- 
									<input type="text" name="maxprice" size="10"/>
								</td>
							</tr>

							<tr>
								<td width="100px" height="22px" align="center" bgColor="#f5fafe" class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff">
									<font face="宋体" color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<br>
									<br>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search" value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;
									</button> 
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" name="reset" value="&#37325;&#32622;" class="button_view" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3">
					<strong>商品列表</strong>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="right">
					<button type="button" id="add" name="add" value="批量删除"
						class="button_view" onclick="DelBooks()">批量删除</button>
					<button type="button" id="add" name="add" value="添加"
						class="button_view" onclick="addProduct()">添加</button>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<form action="${pageContext.request.contextPath}/deleteBook" method="post">
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%">
								<input type="checkbox" name="ckAll" id="ck" onclick="CheckAll()">全选/全不选</td>
								<td align="center" width="24%">商品编号</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">商品数量</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>
								<td width="8%" align="center">删除</td>
							</tr>

							<c:forEach items="${books }" var="book">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="23px">
									<input type="checkbox" name="cki" value="${book.id }"></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="23">${book.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${book.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${book.price }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${book.pnum }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${book.category }</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="${pageContext.request.contextPath}/findBookByID?id=${book.id}">
											<img src="${pageContext.request.contextPath}/admin/images/i_edit.gif" style="CURSOR: hand">
										</a>
									</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="javascript:DelBook('${book.name }','${book.id }')"> 
											<img src="${pageContext.request.contextPath}/admin/images/i_del.gif" width="16px" height="16px" style="CURSOR: hand">
										</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</HTML>

