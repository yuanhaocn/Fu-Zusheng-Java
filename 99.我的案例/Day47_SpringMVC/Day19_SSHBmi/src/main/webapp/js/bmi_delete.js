
//根据bmiSign进行删除
function deleteBySign(bmiSign){
	if(confirm("确定要删除该数据吗?")){
		$.ajax({
			type:'POST',
			url:'deleteBMI.action',
			contentType:'application/json;charset="UTF-8"',
			data:'{"bmiSign":"'+bmiSign+'"}',
			success:function(){
				//取出表格中对应的行
				$("#"+bmiSign).remove();
			},
			error:function(){
				alert("请求失败!");
			}
		})
	}
}