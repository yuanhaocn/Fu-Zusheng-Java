/**
 * 通用的ajax方法
 */

function ajaxRequest(method,url,type,data,callback){
	
	$.ajax({
		type:method,
		url:url,
		dataType:type,
		data:data,
		success:callback,
		error:function(){
			alert("数据请求失败!");
		}
	})
	
}