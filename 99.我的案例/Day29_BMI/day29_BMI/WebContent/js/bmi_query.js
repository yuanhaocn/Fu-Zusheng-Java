/**
 * bmi的查询及结果的显示
 */

//页面已加载,就进行一次查询
$().ready(function(){
	var url=localhost+"bmi?method=queryBMI";
	//queryBMI:是查询成功后的回调方法.
	ajaxRequest("GET",url,"json",null,queryBMI);
})

//查询的回调方法
var queryBMI=function(data){
	if(jQuery.isEmptyObject(data)){
		alert("数据为空!");
	}else{
		for(var i in data){
			//显示查询结果
			showHistoryRecord(data[i]);
		}
	}
}

//在右下角的区域显示数据
function showHistoryRecord(data){
	//得到要动态生成行的表格
	var tblHistory=document.getElementById("table_history");
	
	//创建一个元素
	var tr=document.createElement("tr");
	//每一行的id=bmiSign
	tr.id=data.bmiSign;
	tr.className="table_head";

	//在行中动态的创建列
	tr.innerHTML="<td>"+data.id+"</td><td>"+data.recordTime+"</td>" +
			"<td>"+data.height+"</td><td>"+data.weight+"</td><td>"+data.bmi+"</td>" +
			"<td><input type='submit' value='删除' class='submit' onclick='deleteBySign("+data.bmiSign+")'/></td>";
	
	//添加一个子元素
	tblHistory.appendChild(tr);
}