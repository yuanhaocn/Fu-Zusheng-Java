
//默认加载北京的天气信息
$().ready(function(){
	//发起ajax请求
	searchCityAjax("POST","searchWeather.action","weather.city=北京","json");
})

//根据城市名称,查询某个城市的天气信息
function searchCity(){
	var city=$("#search").val();
	if(jQuery.isEmptyObject(city)){
		return alert("请输入要查询的城市名称!");
	}
	
	//发起ajax请求
	searchCityAjax("POST","searchWeather.action","weather.city="+city,"json");
}

//利用ajax发起请求
function searchCityAjax(method,url,data,type){
	$.ajax({
		type:method,
		url:url,
		data:data,
		dataType:type,
		async:true,
		success:function(array){
			if(jQuery.isEmptyObject(array[0])){
				alert("你要查找的城市还没有开通天气服务,敬请期待!");
			}else{
				//console.log(array[0]);
				$("#country").text(array[0].country);
				$("#city").text(array[0].city);
				$("#date").text(array[0].recordDate);
				$("#temperature").text(array[0].temperature+"°C");
				$("#weather").text(array[0].weather);
				$("#wind").text(array[0].wind);
				$("#nineClock").text(array[0].threeClock);
				$("#twelvelClock").text(array[0].twelveClock);
				$("#fifteenClock").text(array[0].nineClock);
				$("#eighteenClock").text(array[0].sixClock);
				
				//判断天气,根据天气显示不同的图片
				var weather=array[0].weather;
				if("晴天"==weather){
					$("#weather-img").attr("src","img/sunshine.png");
				}else if("阴天"==weather){
					$("#weather-img").attr("src","img/cloudy.png");
				}else if("多云"==weather){
					$("#weather-img").attr("src","img/cloudy_yun.png");
				}else if("雨天"==weather){
					$("#weather-img").attr("src","img/rain.png");
				}else if("雪天"==weather){
					$("#weather-img").attr("src","img/rain.png");
				}else{
					$("#weather-img").attr("src","img/sunshine.png");
				}
			}
		},
		error:function(){
			alert("请求失败");
		}
	});
}