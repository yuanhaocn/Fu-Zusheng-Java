
//封装前端请求的工具方法.

function ajaxRequest(method,url,type,data,callback){
	$.ajax({
		type:method,
		url:url,
		dataType:type,
		data:data,
		success:callback,
		error:function(){
			alert("请求失败!");
		}
	})
}