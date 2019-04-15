<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>BookManager</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="网购,图书,商城">
<meta http-equiv="description" content="BookManager">

<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">
	<!-- 引入head区域 -->
	<%@ include file="head.jsp"%>
	<%--导入导航条与搜索 --%>
	<%@include file="menu_search.jsp"%>

	<div id="divad">
		<img src="ad/index_ad.jpg" />
	</div>

	<div id="divcontent">
		<table width="900px" cellspacing="0">
			<tr>
				<td width="497">
				<img src="img/billboard.gif" width="497px" height="38px" />
					<table cellspacing="0" class="ctl">
						<tr>
							<td>&middot;
								<a href="news.html" style="color: #000000">图书3折起，支持在线浏览,先看再买不后悔,任何商品免费送货</a>
							</td>
						</tr>
						<tr>
							<td>&middot;
								<a href="news.html" style="color: #000000">Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a>
						 	</td>
						</tr>
						<tr>
							<td>&middot;
								<a href="news.html" style="color: #000000">2007年中旅游图书畅销榜速递.中国游,世界游,旅游图书全部7折封顶</a>
							</td>
						</tr>
						<tr>
							<td>&middot;
								<a href="news.html" style="color: #000000">50万种图书3折,百货团购价热卖.畅销榜新书速递,促销天天有</a>
							</td>
						</tr>
						<tr>
							<td>&middot;
								<a href="news.html" style="color: #000000">50万种图书3折,百货团购价热卖.畅销榜新书速递,促销天天有</a>
							</td>
						</tr>
					</table>
				</td>
				<td style="padding: 5px 15px 10px 40px">
					<table width="100%" cellspacing="0">
						<tr>
							<td>
								<img src="img/hottitle.gif" width="126px" height="29px" />
							</td>
						</tr>
					</table>
					<table width="100%" cellspacing="0">
						<tr>
							<td style="width: 50; text-align: center">
								<a href="info.html">
									<img src="img/travelbook.jpg" width="102px" height="130px" /> 
								</a>
								<br /> 
								<a href="info.html">TravelBook<br /> 作者:Lonley Plant
								</a>
							</td>
							<td style="width: 50; text-align: center">
								<a href="info.html">
									<img src="img/java2.jpg" width="102px" height="130px"/> 
								</a>
								<br />
								<a href="info.html">Java2入门经典(JDK5)
									<br /> 作者:(美)霍顿
								</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<%@ include file="foot.jsp"%>
</body>
</html>
