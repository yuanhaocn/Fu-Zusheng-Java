/**
 * bmi的查询及结果的显示
 */

//页面已加载,就进行一次查询
$().ready(function(){
	ajaxRequest("POST","queryBMI.action",null,null,queryBMI);
})

//添加成功后的回调函数
function queryBMI(data) {
	if (jQuery.isEmptyObject(data)) {
		alert("数据为空!");
	} else {
		//注意:要将json字符串转为json对象
    	var obj=$.parseJSON(data);
		for ( var i in obj) {
			console.log(obj[i]+"----");
			// 取出回调的每一数据元素,进行展示
			showHistoryRecord(obj[i]);
		}
	}
}

// 在页面的右下角,显示查询到数据
function showHistoryRecord(data) {
	var tblHistory = document.getElementById("table_history");
	// 创建一个<tr>标签
	var tr = document.createElement("tr");
	// 将bmiSign赋值给tr的id
	tr.id = data.bmiSign;
	// 给每一行添加样式
	tr.className = "table_head";

	// 给每一个tr里面拼接td
	tr.innerHTML = "<td>" + data.id + "</td><td>" + data.recordTime
			+ "</td><td>" + data.height + "</td><td>" + data.weight
			+ "</td><td>" + data.bmi + "</td><td><input type='submit' value='删除' class='submit' onclick='deleteBySign("+data.bmiSign+")'/></td>"

	// 将tr这一行追加到表中
	tblHistory.appendChild(tr);
}