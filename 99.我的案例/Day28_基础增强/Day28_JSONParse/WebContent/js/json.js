//json解析基础

//形式一:json对象
var json1 = {
	id: 1,
	name: "Tom"
}

//形式二:json对象中有函数
var json2 = {
	id: 2,
	name: "鲁智深",
	show: function() {
		//this.name引用本json中的name对应的值.
		alert("我是" + this.name);
	}
}

//形式三:json对象中包含对象
var json3 = {
	obj1: {
		id: 3,
		name: "林冲",
		show: function() {
			//this.name引用本json中的name对应的值.
			alert("我是" + this.name);
		}
	},
	obj2: {
		id: 4,
		name: "燕青",
		show: function() {
			//this.name引用本json中的name对应的值.
			alert("我是" + this.name);
		}
	}
}

//形式四:json对象中有函数
var json4 = [
	{
		id: 5,
		name: "李逵",
		show: function() {
			//this.name引用本json中的name对应的值.
			alert("我是" + this.name);
		}
	},
	{
		id: 6,
		name: "卢俊义",
		show: function() {
			//this.name引用本json中的name对应的值.
			alert("我是" + this.name);
		}
	}
]

//JSON5
var json5 = [
	{
		id: 5,
		name: "李逵",
		show: function() {
			alert("李逵");
		}
	},
	{
		id: 6,
		name: "卢俊义",
		show: function() {
			alert("卢俊义");
		}
	}
]


$().ready(function(){
	
	//解析JSON1
	$("#btn1").click(function(){
		var msg="";
		for(var key in json1){
			msg+=key+":"+json1[key]+" ";
		}
		$("#show").html(msg);
	})
	
	$("#btn2").click(function(){
		var msg="";
		
		for(var key in json2){
			if(typeof json2[key] == "function"){
				//typeof:判断一个数据的类型.
				json2[key]();//执行函数
			}else{
				msg+=key+":"+json2[key]+" ";
			}
		}
		
		$("#show").html(msg);
	})
	
	$("#btn3").click(function(){
		var msg="";
		
		for(var i in json3){
			if(typeof i =="object"){
				for(var j in json3[i]){
					if(typeof json3[i][j] =="function"){
						json3[i][j]();
					}else{
						msg+=j+":"+json3[i][j]+" ";
					}
				}
			}else{
				msg="不是JSON对象!";
			}
		}
		
		$("#show").html(msg);
	})
	
	$("#btn4").click(function(){
		var msg="";
		
		for(var i=0;i<json4.length;i++){
			for(var j in json4[i]){
				if(typeof json4[i][j] =="function"){
					json4[i][j]();
				}else{
					msg+=j+":"+json4[i][j]+" ";
				}
			}
		}
		
		$("#show").html(msg);
	})
	
	//$.each():该函数用来遍历数组,
	//$.each(array,function(index,value)):
	//array:要遍历的数组;function中的index是数组的下标;value:是下标对应的值.
	$("#btn5").click(function(){
		var msg="";
		
		$.each(json5,function(index,value){
			//alert(index+":"+value);
			$.each(value,function(k,v){
				if(typeof v == "function"){
					v();
				}else{
					msg+=k+":"+v+" ";
				}
			})
		});
		
		$("#show").html(msg);
	})
	
})
