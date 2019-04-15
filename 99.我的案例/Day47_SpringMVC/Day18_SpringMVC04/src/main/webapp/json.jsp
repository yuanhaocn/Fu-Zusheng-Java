<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<title>JSON请求</title>

	<script type="text/javascript">
	
		/* 向后端服务器,传送json数据! */
		function requestJSON(){
			$.ajax({
				type:'post',
				url:'requestJSON.action',
				contentType:'application/json;charset="UTF-8"',
				data:'{"id":"u001","username":"三胖","age":30,"address":"韩国","birthday":"2017-09-09"}',
				success:function(){
					alert("请求成功!");
				},
				error:function(){
					alert("请求失败!");
				}
			});
		}
	
		/* 接收后端服务器的响应信息 */
		function responseJSON(){
			$.ajax({
				type:'post',
				url:'responseJSON.action',
				contentType:'application/json;charset="UTF-8"',
				success:function(data){
					//alert("请求成功!"+data);
					console.log(data.id);
					console.log(data.username);
					console.log(data.age);
					console.log(data.address);
					console.log(data.birthday);
					$("#msg").text(data.id+"---"+data.username+"---"+data.age);
				},
				error:function(){
					alert("请求失败!");
				}
			});	
		}
		
		/* 接收后端服务器的返回的集合响应信息 */
		function responseListJSON(){
			$.ajax({
				type:'post',
				url:'responseJSONS.action',
				contentType:'application/json;charset="UTF-8"',
				success:function(data){
					//alert("请求成功!"+data);
					for(var i in data){
						//data[i].id;
						console.log("id="+data[i].id);
						console.log("name="+data[i].username);
					}
					//$("#msg").text(data.id+"---"+data.username+"---"+data.age);
				},
				error:function(){
					alert("请求失败!");
				}
			});	
		}
		
		/* 接收后端服务器的返回的集合响应信息 */
		function responseMovieJSON(){
			$.ajax({
				type:'post',
				url:'responseMovieJSONS.action',
				contentType:'application/json;charset="UTF-8"',
				success:function(data){
					var retcode=data.retcode;
					var retdesc=data.retdesc;
					console.log("code="+retcode+",desc="+retdesc);
					var list=data.list;
					for(var i in list){
						var id=list[i].id;
						var name=list[i].name;
						var highlight=list[i].highlight;
						console.log("id="+id+",name="+name+",high="+highlight);
					}
					//$("#msg").text(data.id+"---"+data.username+"---"+data.age);
				},
				error:function(){
					alert("请求失败!");
				}
			});	
		}
		
	</script>

</head>
<body>
	<input type="button" value="JSON请求" onclick="requestJSON()"><br><br>
	<input type="button" value="JSON响应" onclick="responseJSON()"><br><br>
	<input type="button" value="JSON响应集合" onclick="responseListJSON()"><br>
	<input type="button" value="复杂的json请求" onclick="responseMovieJSON()"><br>
	
	<hr>
	<p id="msg"/>
</body>
</html>