/**
 * 定义一个公共的方法,获取XMLHttpRequest对象.
 * XMLHttpRequest是AJAX的基础,用来在前端页面和服务器之间进行交互.
 */

function getXMLHttpRequest(){
	var xhr=null;
	if(window.XMLHttpRequest){
		//判断浏览器是否支持XMLHttpRequest
		xhr=new XMLHttpRequest();
	}else{
		//针对IE6及其以前的版本的浏览器
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xhr;
}
