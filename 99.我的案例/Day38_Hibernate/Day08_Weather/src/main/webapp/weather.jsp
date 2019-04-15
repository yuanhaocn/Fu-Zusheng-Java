<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>全国城市天气预报</title>
		<link rel="stylesheet" href="css/weather.css" />
	</head>

	<body>
		<input type="search" class="search" id="search" placeholder="请输入要搜索的城市" />
		<input type="submit" class="submit" value="搜索" onclick="searchCity()" />

		<div class="container">
			<!--左侧区域-->
			<div class="div_left">
				<!--城市信息-->
				<div class="div_msg">
					<h2 id="country">中国</h2>
					<h3 id="city">北京</h3>
					<p id="date">2017-06-15</p>
				</div>
				<!--时间信息-->
				<div class="div_temperature">
					<div class="div_time" id="div_time">09:09:09</div>
					<p class="temperature" id="temperature">24°C</p>
				</div>
			</div>

			<!--右侧区域-->
			<div class="div_right">
				<img class="forecast-icon" src="img/forecast.png" id="weather-img" />
				<div class="today-weather">
					<h3 id="weather">小雨</h3>
					<ul>
						<li>今天<span id="wind"></span></li>
						<li>09:00<span id="nineClock">22°C</span></li>
						<li>12:00<span id="twelvelClock">26°C</span></li>
						<li>15:00<span id="fifteenClock">28°C</span></li>
						<li>18:00<span id="eighteenClock">22°C</span></li>
					</ul>
				</div>
			</div>
			
			<!--clear区域-->
			<!--设置该元素左右不允许出现浮动元素,为了防止前边的浮动元素影响后边元素的存在-->
			<div class="clear"></div>
		</div>
	</body>
	
	<!-- js文件写在body的后面,是为了提高页面加载效率 -->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="js/weather.js" ></script>
	<script type="text/javascript" src="js/updateTime.js" ></script>
</html>
