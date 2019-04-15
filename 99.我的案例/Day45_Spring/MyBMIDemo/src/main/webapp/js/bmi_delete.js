/**
 * 负责数据的删除
 */

var deleteBySign=function(bmiSign){
	if(confirm("确定要删除该条目吗?")){
		$.ajax({
			type:'POST',
			url:'deleteBMI.action',
			dataType:'json',
			data:'{"bmiSign":"'+bmiSign+'"}',
			success:function(){
				//数据库已经删除成功,此时只需要前端表中对应的行移除即可!
				$("#"+bmiSign).remove();
			},
			error:function(){
				alert("请求失败!");
			}
		})
	}
}

