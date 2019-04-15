
/*更新时间的js文件*/

//会获取浏览器包含的Date(); date里面有时间（小时、分钟、秒）三个属性
function updateTime(){
	//获取日期时间信息
	var date=new Date();
	var h=date.getHours();
	var m=date.getMinutes();
	var s=date.getSeconds();
	
	//进行日期时间的判断
	if(h<10){
		h="0"+h;
	}else if(m<10){
		m="0"+m;
	}else if(s<10){
		s="0"+s;
	}
	$("#div_time").text(h+":"+m+":"+s);
}

//定时更新,每隔500毫秒来执行一次函数
setInterval(updateTime,500);
