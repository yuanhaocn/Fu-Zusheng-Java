<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my.js"></script>

<!-- 处理搜索框 -->
<script type="text/javascript">
	window.onload = function() {
		//得到搜索框对象
		var search = document.getElementById("name");
		//得到显示搜索内容的对象
		var content = document.getElementById("content");

		search.onkeyup = function() {
			//得到用户输入的文本
			var txt = this.value;//

			//判断搜索框是否为空
			if (txt == "") {
				content.style.display = "none";
				return;
			}

			//去数据库中搜索含有用户输入文本的所有书名
			var req = getXMLHttpRequest();

			req.onreadystatechange = function() {
				if (req.readyState == 4 && req.status == 200) {
					//得到返回的字符串
					var ss = eval("(" + req.responseText + ")");// ["水浒", "红楼梦","weiur"]
					//document.write(req.responseText);
					//切割字符串
					//var ss = str.split(",");
					//把数组中的书名放到显示搜索内容的div
					var strdiv = "";
					for (var i = 0; i < ss.length; i++) {
						strdiv += "<div onclick='showTxt(this)' onmouseover='changeBgColor(this)' onmouseout='backToColor(this)'>"
								+ ss[i] + "</div>";
					}
					content.innerHTML = strdiv;
					content.style.display = "block";//让div显示
				}
			};
			//处理中文问题
			/* req.open("get",
					"${pageContext.request.contextPath}/findBookByName?name="
							+ window.encodeURIComponent(txt, "utf-8")
							+ "&time=" + new Date().getTime()); */
			req.send(null);
		};
	};
	
	//鼠标放上去改变背景色事件的处理函数	,参数接收的是被选中的div
	function changeBgColor(div) {
		div.style.backgroundColor = "gray";
	}
	
	function backToColor(div) {
		div.style.backgroundColor = "white";
	}
	
	function showTxt(div) {
		//把div中的文本显示到搜索框中
		var search = document.getElementById("name");
		search.value = div.innerHTML;
		//让显示搜索结果的div隐藏
		div.parentNode.style.display = "none";
	}
</script>

<div id="divmenu">
	<a href="${pageContext.request.contextPath}/bookCategory?category=文学">文学</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=生活">生活</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=计算机">计算机</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=外语">外语</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=经营">经管</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=励志">励志</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=社科">社科</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=学术">学术</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=少儿">少儿</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=艺术">艺术</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=原版">原版</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=科技">科技</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=考试">考试</a>
	<a href="${pageContext.request.contextPath}/bookCategory?category=生活百科">生活百科</a>
	<a href="${pageContext.request.contextPath}/bookCategory" style="color: #FFFF00">全部商品目录</a>
</div>

<div id="divsearch">
	<form action="${pageContext.request.contextPath}/findBookByName" method="post">
		<table width="100%" cellspacing="0">
			<tr>
				<td style="text-align: right; padding-right: 220px">
					Search <input type="text" name="bookName" class="inputtable" id="name" /> 
					<input type="submit" style="width:60px;height:25px;background-repeat:no-repeat;background-image:url('img/serchbutton.gif') ;" value="">
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="content" style="display: none; background-color: white; width: 126px; position: absolute; left: 860px; top: 135px;"></div>