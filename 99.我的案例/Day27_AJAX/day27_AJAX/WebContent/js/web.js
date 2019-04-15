
$().ready(function(){
	
	//$.get(url,data,callback)
	//1.url:要请求的服务器资源,servlet的url;
	//2.data:字符串,xml,json等;最好传递json.
	//xml与json对比:json更好.
	//①.xml格式很规范,但是占用的空间比较大.所以在网上进行传输的时候速度慢;xml解析麻烦.
	//②.json格式相对也规范,但是占用的空间小,网上传输速度快;json解析很简单.
	//3.callback:回调结果,浏览器向服务器传递数据后的结果.
	$("#btn1").click(function(){
		//jQuey中的AJAX的get()方法
		$.get("getServlet",{name:"三胖他媳妇",pass:"222"},function(msg){
			alert(msg);
		});
	});
	
	//$.post(url,data,callback);
	$("#btn2").click(function(){
		$.post("getServlet",{name:"奥黑子",pass:"222"},function(msg){
			alert(msg);
		})
	})
	
	//$.ajax({type:"get|post",url:"getServlet",async:true,
	//data:{name:"奥巴驴",pass:"123"},dataType:json,
	//success:function(msg){...},error:function(){}})
	$("#btn3").click(function(){
		$.ajax({
			type:"get",
			url:"getServlet",
			async:true,
			data:{name:"米线儿",pass:"123"},
			dataType:"json",
			success:function(array){//[{name:米线儿,pass:123},{name:米线儿2,pass:1232}]
				var div=$("#content");
				var msg="";
				for(var i=0;i<array.length;i++){
					var user=array[i];
					var name=user.name;
					var pass=user.pass;
					//alert("name="+name+",pass="+pass);
					msg+="name="+name+i+",pass="+pass+"\n";
				}
				div.text(msg);
			},
			error:function(){
				alert("请求失败!");
			}
		});
	})
	
})