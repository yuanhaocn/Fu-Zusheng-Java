<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>人事管理系统---文档查询</title>
<!-- jq -->
<script src="../js/jquery-3.1.1.min.js"></script>

<!-- bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>

<!-- 分页插件 -->
<link href="../css/bootstrap-table.min.css" rel="stylesheet">
<script src="../js/bootstrap-table.js"></script>
<script src="../js/bootstrap-table-locale-all.min.js"></script>

<!--layer -->
<link href="../js/layer/theme/default/layer.css" rel="stylesheet">
<style type="text/css">
.panel {
	margin-left: -48px;
	width: 1145px;
}

.col-sm-12 {
	margin-left: -60px;
}

thead {
	background: #428bca;
	color: white;
}
</style>
</head>
<body>
	<div class="container" style="margin-top: 5px">
		<div class="row">
			<!--!查询区 -->
			<div class="col-sm-12">
				<div class="panel-heading"
					style="background-color: #428bca; color: white">查询条件</div>
				<div class="panel-body form-group" style="margin-bottom: 0px;">
					<label class="col-sm-2 control-label"
						style="text-align: right; margin-top: 5px">文档标题：</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="name"
							id="search_docname" />
					</div>
					<div class="col-sm-1 col-sm-offset-4">
						<button class="btn btn-primary" class="search" type="button"
							id="search_btn" style="background-color: #0767C8">搜索</button>
					</div>
				</div>
			</div>

			<!-- 工具栏 -->
			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="btn_update" type="button" class="btn btn-primary">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>编辑
				</button>
				<button id="btn_delete" type="button" class="btn btn-danger"
					style="margin-left: 0px">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量删除
				</button>
			</div>

			<!-- 表格 -->
			<div class="col-sm-12">
				<table class="table table-striped table-bordered table-hover"
					id="table"></table>
			</div>
		</div>
	</div>
	<script src="../js/layer/layer.js"></script>
	<script type="text/javascript">

    //获取选中的所有行的id
    function getIds() {
        return $.map($("#table").bootstrapTable('getSelections'), function (row) {
            return row.id;
        })
    }

    //新增文档
    $("#btn_add").click(function () {
        window.location.href = "${ctx}/doc/addDocument";
    })

    //批量删除的方法
    $("#btn_delete").click(function () {
        var ids = getIds();
        if (ids.length < 1) {
            layer.alert('请选择至少一个文档!', {
                skin: 'layui-layer-lan'
                , closeBtn: 0
            })
        } else {
            layer.confirm('确定删除这些文档吗?？', {
                btn: ['是的', '按错了'] //可以无限个按钮
            }, function () {
                //确定按钮的回调函数
                var url = "${ctx}/doc/removeDocument";
                var params = {
                    flag: 2,
                    ids: ids
                }
                $.ajax({
                    url: url,
                    data: params,
                    type: "post",
                    dataType: "json",
                    success:function(data){
                    	if (data == "success") {
                            setTimeout(function () {
                            	//会加载返回的json格式数据
                            	 $("#table").bootstrapTable("refresh", {url: '${ctx}/docJson'});
                            }, 500);
                            //关闭所有dialog
                            layer.closeAll('dialog');
                        }
                    },
                    error: function () {
                        $("#table").bootstrapTable("refresh", {url: '${ctx}/docJson'});
                        layer.closeAll("dialog");
                    }
                })
            })
        }
    })

    //删除单个文档
    function deleteone(id) {
        layer.confirm('确定删除这个文档吗?？', {
            btn: ['是的', '按错了'] //可以无限个按钮
        }, function () {
            //确定按钮的回调函数
            window.location.href = "${ctx}/doc/removeDocument?flag=1&id=" + id;
        })
    }

    //下载文档
    /* function download(fileName) {
        console.log(fileName);
        window.location.href = "${ctx}/doc/downloadDocument?fileName=" + fileName;
    } */

    class BstpTable {
        constructor(obj) {
            this.obj = obj;
        }

        init() {
            //---先销毁表格 ---
            this.obj.bootstrapTable('destroy');
            //---初始化表格,动态从服务器加载数据---
            this.obj.bootstrapTable({
                //【发出请求的基础信息】
                url: '${ctx}/docJson',
                method: 'post',
                contentType: "application/x-www-form-urlencoded",//必须有
                //【查询设置】
                /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                  设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
                queryParamsType: '',
                queryParams: function queryParams(params) {
                    //自定义传递的参数
                    var param = {
                        pageNum: params.pageNumber,
                        pageSize: params.pageSize,
                        title: $("#search_docname").val()
                    };
                    return param;
                },

                //【其它设置】
                locale: 'zh-CN',//中文支持
                pagination: true,//是否开启分页（*）
                striped: true,
                pageNumber: 1,//初始化加载第一页，默认第一页
                pageSize: 5,//每页的记录行数（*）
                pageList: [5, 10, 15],//可供选择的每页的行数（*）
                sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
                showRefresh: true,//刷新按钮
                showToggle: true,//卡片视图
                toolbar: '#toolbar',//工具栏

                //【样式设置】
                height: 384,

                //【设置列】
                columns: [
                    {
                        title: '全选',
                        field: 'select',
                        //复选框
                        checkbox: true,
                        width: 25,
                        align: 'center',
                        valign: 'middle'
                    },
                    {field: 'title', title: '标题'},
                    {field: 'createDate', title: '创建时间'},
                    {field: 'user.username', title: '创建人'},
                    {field: 'remark', title: '描述'},
                    {field: 'fileName', title: '文件名'},
                    {
                        field: 'tool', title: '操作', align: 'center',
                        formatter: function (value, row, index) {
                            var element = "<button  data-id='" + row.id + "' onclick='deleteone(" + row.id + ")' class='btn btn-danger btn-sm'>删除</button> ";
                            return element;
                        }
                    },
                    {
                        field: 'download', title: '下载', align: 'center',
                        formatter: function (value, row, index) {
                        	console.log(row.fileName);
                            var element = "<a href='${ctx}/doc/downloadDocument?fileName="+row.fileName+"'><img class='btn btn-success btn-sm' src='../images/download_icon.png' /></a>";
                            return element;
                        }
                    }
                ]
            })
        }
    }

    //初始化表格
    var bstpTable = new BstpTable($("table"));
    bstpTable.init({})

    //查询按钮的逻辑
    $("#search_btn").click(function () {
        $("#table").bootstrapTable("refresh", {url: '${ctx}/docJson'});
    })

</script>
</body>
</html>