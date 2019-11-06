<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!--引入bootstrap的css样式-->
    <link rel="stylesheet" href="boot/css/bootstrap.css">
    <!--引入JQGRID的主题css样式-->

    <link rel="stylesheet" href="jqgrid/jqgrid/css/css/cupertino/jquery-ui-1.8.16.custom.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/jqgrid/css/css/flick/jquery-ui-1.8.16.custom.css">--%>
    <!--引入的是JQGRID的全局CSS样式-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/jqgrid/css/ui.jqgrid.css">
    <!--引入jquery的js文件-->
    <script src="${pageContext.request.contextPath}/boot/js/jquery-3.3.1.min.js"></script>
    <!--引入BootStrap的js文件-->
    <script src="${pageContext.request.contextPath}/boot/js/bootstrap.js"></script>
    <!--引入jqgrid的国际化js文件-->
    <script src="${pageContext.request.contextPath}/jqgrid/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <!--引入jqgrid的js文件-->
    <script src="${pageContext.request.contextPath}/jqgrid/jqgrid/js/jquery.jqGrid.src.js"></script>

    <script type="application/javascript">
        $(function () {
            $("#table").jqGrid({
                styleUI:"Bootstrap",
                url:"${pageContext.request.contextPath}/user/ShowAll", //获取数据的地址
                datatype:"json",  //自动把后台响应回的json协议串自动转换为jquery的对象或集合
                /* cellEdit:true,*/ //启用或者禁用单元格编辑功能
                caption:"用户信息表",
                autowidth:true,//自动调整表格的宽度
                pager:"#pager", //开启分页功能
                rowNum:"3",   //每页展示的条数
                rowList:["3","6","9"],  //调整每页展示的条数
                viewrecords:true,  //展示总条数
                editurl:"${pageContext.request.contextPath}/user/operation",
                colNames:["用户id","用户名","密码","电话","邮箱","来源","ip地址","状态","身份","操作"],//指定列名
                colModel:[
                    {name:"id"},
                    {name:"username",editable:true},
                    {name:"password",editable:true},
                    {name:"phone",editable:true},
                    {name:"email",editable:true},
                    {name:"source",editable:true},
                    {name:"ip",editable:true},
                    {name:"status",editable:true},
                    {name:"role",editable:true},
                    {name:"aaa",formatter:function (cellvalue,options,rowObject) {
                            return   "<a class='btn btn-danger' onclick=\"del('"+rowObject.id+"')\">删除</a><a class='btn btn-primary' onclick=\"update('"+rowObject.id+"')\">修改</a>";

                        }}
                ]
            }).jqGrid("navGrid","#pager",{edit:true});


            //添加
            $("#add").click(function () {
                $("#table").jqGrid('editGridRow',"new",{
                    height:300,
                    reloadAfterSubmit:true
                });
            });
            //修改
            $("#update").click(function () {
                var gr=$("#table").jqGrid('getGridParam','selrow');
                if(gr!=null)
                    $("#table").jqGrid('editGridRow',gr,{
                        height:300,
                        reloadAfterSubmit: true
                    });
                else
                    alert("请选择单元格");
            });
            //删除
            $("#delete").click(function () {
                var gr=$("#table").jqGrid('getGridParam','selrow');
                if(gr!=null)
                    $("#table").jqGrid('delGridRow',gr,{
                        height:300,
                        reloadAfterSubmit: true
                    });
                else
                    alert("请选择单元格");
            });
        });

        function update(rowid) {
            if(rowid!=null)
                $("#table").jqGrid('editGridRow',rowid,{
                    height:300,
                    reloadAfterSubmit: true
                });
            else
                alert("请选择单元格");
        }

        function del(rowid) {
            if(rowid!=null)
                $("#table").jqGrid('delGridRow',rowid,{
                    height:300,
                    reloadAfterSubmit: true
                });
            else
                alert("请选择单元格");
        }
    </script>


</head>
<body>
<table id="table"></table>
<div id="pager"></div> <br/>
<button id="add" class="btn btn-info">添加</button><button id="update" class="btn btn-danger">修改</button><button id="delete" class="btn btn-danger">删除</button>
</body>
</html>