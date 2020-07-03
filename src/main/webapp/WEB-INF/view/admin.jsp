<%--
  Created by IntelliJ IDEA.
  User: 15060
  Date: 2020/6/30
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">
    <%--下面三个js文件必须是按顺序进行，不能搞乱顺序--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#tt').tree({
                onClick: function(node){
                    if(node.id=="adminlistall"){
                        $(".layout-panel-center .panel-title").text("管理员信息列表");
                        //动态加js文件
                        if(typeof(listpage) !="function"){
                            $.getScript("../js/admin.js",function(){
                                listpage();
                            })
                        }else{
                            listpage();
                        }
                    }
                    if(node.id=="categorylistall"){
                        $(".layout-panel-center .panel-title").text("教材类别信息列表");
                        //动态加js文件
                        if(typeof(listpage) !="function"){
                            $.getScript("../js/category.js",function(){
                                listpage();
                            })
                        }else{
                            listpage();
                        }
                    }
                }
            });
        });
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
        基于ssm教材征订系统设计与应用
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;">

    </div>
    <%--<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;">--%>

    <%--</div>--%>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;">
        <div>
            <ul id="tt" class="easyui-tree">
                <li>
                    <span>管理员管理</span>
                    <ul>
                        <li id="adminlistall">
                            <span>管理员信息列表</span>
                        </li>
                    </ul>
                    <ul>
                        <li id="categorylistall">
                            <span>教材类别信息列表</span>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div data-options="region:'center',title:'工作区域'" style="padding:5px;background:#eee;">
        <div id="tab"></div>
    </div>

</body>
</html>