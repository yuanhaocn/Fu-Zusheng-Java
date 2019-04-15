<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8" />
<title>人事管理系统--签到图表</title>
<!--引入echarts -->

<link href="../layui/css/layui.css" rel="stylesheet" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../laydate/theme/default/laydate.css" rel="stylesheet" />

<style type="text/css">
.mainDiv {
	margin-top: 6px;
}

#main {
	margin-left: 5px;
}

.layui-form {
	margin-left: 100px;
	margin-top: 6px;
}

.col-sm-12 {
	margin-left: 5px;
	border:1px solid #428bca;
	padding:0px 0px;
}

</style>
</head>

<!-- loadChart(),初始化加载图表 -->
<body onload="loadChart()">
	<div class="mainDiv">
		<!--!查询区 -->
		<div class="col-sm-12">
			<div class="panel-heading" style="background-color: #428bca; color: white">查询条件</div>
			<div class="panel-body form-group" style="margin-bottom: 0px;">
				<div class="layui-form-item" style="margin-left: 10px; margin-top: 5px">
					<!--开始日期选择 -->
					<label class="layui-form-label" style="width: 120px">起始日期&nbsp;</label>
					<div class="col-sm-6">
						<input class="form-control" type="text" id="start"
							placeholder="起始日期选择" />
					</div>

					<button class="btn btn-generate" style="background-color: #0767C8; color: white; margin-left: 10px"
						type="button" id="generateCharts">
						生成图表
					</button>
				</div>		
			</div>
		</div>
	</div>
	
	<!-- 为 ECharts,准备一个具备大小（宽高）的 DOM -->
	<div id="main" style="width: 100%; height: 400px;"></div>

	<script src="../js/jquery-3.1.1.min.js" charset="UTF-8"></script>
	<script src="../js/echarts.js" charset="UTF-8"></script>
	<script src="../js/layer/layer.js" charset="UTF-8"></script>
	<script src="../laydate/laydate.js" charset="UTF-8"></script>
	
	<script type="text/javascript">
	
		//获取当前日期并格式化
		function getDate() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var date = date.getDate();
			return year + "-" + month + "-" + date;
		}
		
		//渲染日期
		var begin;
		laydate.render({
			elem : "#start",
			max : getDate(),
			done : function(value) {
				begin = value;
			}
		});
	
		//生成图表按钮的点击事件
		$("#generateCharts").click(function() {
			if (begin != '') {
				generate(begin);
			} else {
				generate('1900-01-01');
			}
		});

		//初始化图表
		var myChart = echarts.init(document.getElementById('main'));
		
		//加载图表
		function loadChart() {
			// 显示标题，图例和空的坐标轴
			myChart.setOption({
				title : {
					text : '签到图表'
				},
				tooltip : {},
				toolbox : {//工具栏
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {//数据视图
							show : true,
							readOnly : false
						},
						magicType : {//柱状图
						   title : { 
                                 	line : '折线图切换', 
                                 	bar : '柱形图切换', 
                                 	stack : '堆积', 
                                 	tiled : '平铺' 
                                 }, 
							show : true,
							type : [ 'line', 'bar' ,'stack','tiled']
						},
						restore : {//还原
							show : true
						},
						saveAsImage : {//保存为图片
							show : true
						}
					}
				},
				legend : {//图例
					data : [ '人数' ]
				},
				xAxis : {//x轴
					data : []
				},
				yAxis : {//y轴
					splitArea : {
						show : true
					}
				},
				series : [ {
					name : '人数',
					type : 'bar',
					data : []
				} ]
			});
			
			generate('1900-01-01');
		}

		//定义两个数组,分别存放日期和打开人数
		var days = []; //日期（实际用来盛放X轴坐标值）
		var nums = []; //人数（实际用来盛放Y坐标值）

		//生成图表
		function generate(begin) {
			$.ajax({
				type : "post",
				async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
				url : "${ctx}/sign/chartJson?beginDay=" + begin, //接口
				dataType : 'json',// 返回数据形式为json
				success : function(result) {
					//console.log(result);
					//请求成功时执行该函数内容，result即为服务器返回的json对象
					if (result) {
						 //挨个取出日期并填入类别数组
						for (var i = 0; i < result.length; i++) {
							days.push(result[i].day);
						}
						
						//挨个取出人数并填入销量数组
						for (var i = 0; i < result.length; i++) {
							nums.push(result[i].num); 
						}
						
						myChart.hideLoading(); //隐藏加载动画
						myChart.setOption({ //加载数据图表
							xAxis : {//x轴
								data : days
							},
							series : [ {//y轴
								// 根据名字对应到相应的系列
								name : '人数',
								data : nums
							} ]
						});
					}
				},
				error : function() {
					//请求失败时执行该函数
					layer.msg("请求数据失败", {
						icon : 2
					});
					myChart.hideLoading();
				}
			});
		}
	</script>
	
</body>
</html>