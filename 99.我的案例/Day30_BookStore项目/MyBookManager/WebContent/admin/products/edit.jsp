<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/admin/css/Style.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/check.js"></script>
</HEAD>
<script type="text/javascript">
	//设置类别的默认值
	function setProductCategory(t) {
		var category = document.getElementById("category");//获取下拉列表框对象
		var ops = category.options;
		for (var i = 0; i < ops.length; i++) {
			//判断书的类别是否和选项的值相同
			if (ops[i].value == t) {
				ops[i].selected = true;//让选项被选中 checked=true
				return;
			}
		}
	};
</script>

<body onload="setProductCategory('${book.category}')">
	<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/updateBookServlet" method="post">
		<table cellSpacing="1px" cellPadding="5px" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26px">
					<strong>
						<strong>编辑商品</strong>
					</strong>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<input type="hidden" value="${book.id}" name="id">
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称: </td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="name" class="bg" value="${book.name }" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格: </td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="price" class="bg" value="${book.price }" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品数量: </td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="pnum" class="bg" value="${book.pnum }" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别: </td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="category" id="category">
						<option value="">--选择商品类加--</option>
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
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片: </td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<input type="file" name="upload" size="30"/>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">商品描述: </td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="description" cols="30" rows="3" style="WIDTH: 96%">${book.description }</textarea>
				</td>
			</tr>
			<tr>
				<td align="center" colSpan="4" class="sep1">
					<img src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定"> 
					<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
					<input type="reset" value="重置" class="button_cancel"> 
					<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font> 
					<input class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span>
				</td>
			</tr>
		</table>
	</form>

</body>
</HTML>