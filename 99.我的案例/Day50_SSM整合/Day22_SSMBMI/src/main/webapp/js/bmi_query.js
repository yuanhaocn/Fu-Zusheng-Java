
//默认加载时,进行查询操作
$().ready(function(){
	ajaxRequest("POST","queryBMI.action",null,null,queryBMI);
})

//查询时候的回调函数
function queryBMI(data){
	if(jQuery.isEmptyObject(data)){
		alert("数据为空!");
	}else{
		//注意:需要将Java的json字符串,转为前端的json字符串.
		
		for(var i in data){
			console.log(data[i]);
			//生成动态表格!
			showHistoryRecord(data[i]);
		}
	}
}

//动态生成表格
function showHistoryRecord(data){
	
	var tblHistory=document.getElementById("table_history");
	
	//创建行
	var tr=document.createElement("tr");
	//给每一行分配一个唯一的id
	tr.id=data.bmisign;
	tr.className="table_head";
	
	//在每一行中添加td
	tr.innerHTML="<td>"+data.id+"</td><td>"+data.recordtime+"</td><td>"+data.height+"</td><td>"+data.weight+"</td><td>"+data.bmi+"</td><td><input type='submit' value='删除' class='submit' onclick='deleteBySign("+data.bmisign+")'/></td>"
	
	//表中追加一行
	tblHistory.append(tr);
}