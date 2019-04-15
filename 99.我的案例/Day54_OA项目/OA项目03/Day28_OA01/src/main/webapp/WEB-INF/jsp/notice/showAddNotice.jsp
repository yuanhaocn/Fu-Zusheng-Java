<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>人事管理系统</title>
    <!--引入bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!--引入layui -->
    <link href="../layui/css/layui.css" rel="stylesheet">
</head>
<body>
<div class="layui-form">

    <!--标题 -->
    <div class="layui-form-item" style="margin-top: 5px;">
        <label class="layui-form-label" style="width: 100px;">公告标题:</label>
        <div class="layui-input-block" style="margin-right: 50px">
            <input class="form-control" name="title" type="text" placeholder="请输入公告标题" lay-verify="title" id="title"/>
        </div>
    </div>

    <!--内容 -->
    <div class="layui-form-item layui-form-text" style="margin-top: 5px;">
        <label class="layui-form-label" style="width: 100px">公告内容:</label>
        <div class="layui-input-block" style="margin-right: 50px">
            <textarea class="form-control" placeholder="请输入内容" type="text" rows="5" cols="15" name="content" id="content"></textarea>
        </div>
    </div>

    <!--按钮 -->
    <div class="form-group" style="margin-left: 50px">
        <button class="btn-sm btn btn-primary" lay-submit="" lay-filter="release">发布</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-sm btn-warning" type="reset">重置</button>
    </div>
</div>

<!--引入jquery -->
<script src="../js/jquery-3.1.1.min.js" charset="UTF-8"></script>
<!--引入layui.js -->
<script src="../layui/layui.js" charset="UTF-8"></script>

<script type="text/javascript">
    layui.use(['form', 'layer'], function () {
        var form = layui.form,
            layer = layui.layer;
        form.verify({
            title: function (value) {
                if (value.length == 0) {
                    return '标题不能为空哦';
                }
            }
        });

        //监听提交
        form.on('submit(release)', function () {
           var url = "${ctx}/notice/addNotice";
           var param = {
               flag:2,
               uid:${sessionScope.user_session.id},
               title:$("#title").val(),
               content:$("#content").val()
           };

           $.ajax({
               url:url,
               data:param,
               type:'post',
               success:function (res) {
                   if (res == "success"){
                       layer.msg('发布成功', {icon: 1});
                       setTimeout(function () {
                           window.location.href = "${ctx}/notice/selectNotice";
                       }, 2000);
                   }
               },
               error:function () {
                   layer.msg("发布失败", {icon: 2});
               }
           })
            return false;
        })
    });
</script>

</body>