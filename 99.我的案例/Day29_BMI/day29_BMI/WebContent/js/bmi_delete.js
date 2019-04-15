/**
 * 负责数据的删除
 */

var deleteBySign=function(bmiSign){
	if(confirm("确定要删除该条目吗?")){
		var url=localhost+"bmi?method=deleteBMI&bmiSign="+bmiSign;
		//数据类型需要是text类型
		ajaxRequest("GET",url,"text",null,function(){
			//移除指定id的行.
			$("#"+bmiSign).remove();
		});
	}
}