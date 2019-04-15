
var interval;

//每隔一秒钟自动调用一次changeSecond()函数
function startSecond() {
	interval = window.setInterval("changeSecond()", 1000);
};

//注册成功后,改变span标签的时间值
function changeSecond() {
	var second = document.getElementById("second");

	var svalue = second.innerHTML;
	//文本值减1
	svalue = svalue - 1;

	//当文本值为0的时候,跳转到index.jsp首页面
	if (svalue == 0) {
		window.clearInterval(interval);
		location.href = "index.jsp";
		return;
	}

	second.innerHTML = svalue;
}

//获取XMLHttpRequest对象
function getXMLHttpRequest() {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for all new browsers
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {// code for IE5 and IE6
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	return xmlhttp;
}