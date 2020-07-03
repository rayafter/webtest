function admininsert(){
    if ($("#dd") != null) {
        $("#dd").remove();
    }
    $("#tab").html("<div id=\"dd\"></div>");
    $('#dd').dialog({
        title: 'My Dialog',
        width: 400,
        height: 200,
        closed: false,
        cache: false,
        modal: true,
        onClose:function () {
            listpage();
        },
        buttons:[{
            text:'保存',
            handler:function(){
                $('#ff').form('submit', {
                    url:"insertSelective",
                    onSubmit: function(){
                        //在这里编写表单字段验证
                    },
                    success:function(data){
                        $('#dd').dialog("close");//关闭当前添加窗口
                        //$('#dg').datagrid("reload");//重新装入表格的内容
                        listpage();
                    }
                });
            }
        },{
            text:'关闭',
            handler:function(){
                $('#dd').dialog("close");//关闭当前添加窗口
                listpage();
            }
        }]
    });
    var str = ' <form id="ff" method="post">\n' +

        '        <table>\n' +

        '            <tr>\n' +

        '                <td>管理员帐号</td>\n' +

        '                <td><input type="text" id="name" name="name" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员密码</td>\n' +

        '                <td><input type="password" id="pass" name="pass" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员电话</td>\n' +

        '                <td><input type="text" id="phone" name="phone" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员邮箱</td>\n' +

        '                <td><input type="text" id="email" name="email" /> </td>\n' +

        '            </tr>\n' +
        '            <tr>\n' +

        '                <td>管理员QQ</td>\n' +

        '                <td><input type="text" id="qq" name="qq" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员类型</td>\n' +

        '                <td><input type="text" id="atype" name="atype" /> </td>\n' +

        '            </tr>\n' +

        '        </table>\n' +

        '    </form>';

    //把表单添加到对话框中

    $("#dd").html(str);
}
function adminupdate(list){
    if ($("#dd") != null) {
        $("#dd").remove();
    }
    $("#tab").html("<div id=\"dd\"></div>");
    $('#dd').dialog({
        title: 'My Dialog',
        width: 400,
        height: 200,
        closed: false,
        cache: false,
        modal: true,
        onClose:function () {
            listpage();
        },
        buttons:[{
            text:'更新',
            handler:function(){
                $('#ff').form('submit', {
                    url:"updateByPrimaryKeySelective",
                    onSubmit: function(){
                        //在这里编写表单字段验证
                    },
                    success:function(data){
                        $('#dd').dialog("close");//关闭当前添加窗口
                        //$('#dg').datagrid("reload");//重新装入表格的内容
                        listpage();
                    }
                });
            }
        },{
            text:'关闭',
            handler:function(){
                $('#dd').dialog("close");//关闭当前添加窗口
                listpage();
            }
        }]
    });
    var str = ' <form id="ff" method="post">\n' +

        '        <table>\n' +
        '            <tr>\n' +

        '                <td><input type="hidden" id="id" name="id" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员帐号</td>\n' +

        '                <td><input type="text" id="name" name="name" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员密码</td>\n' +

        '                <td><input type="password" id="pass" name="pass" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员电话</td>\n' +

        '                <td><input type="text" id="phone" name="phone" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员邮箱</td>\n' +

        '                <td><input type="text" id="email" name="email" /> </td>\n' +

        '            </tr>\n' +
        '            <tr>\n' +

        '                <td>管理员QQ</td>\n' +

        '                <td><input type="text" id="qq" name="qq" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员类型</td>\n' +

        '                <td><input type="text" id="atype" name="atype" /> </td>\n' +

        '            </tr>\n' +

        '        </table>\n' +

        '    </form>';

    //把表单添加到对话框中

    $("#dd").html(str);
    $('#ff').form('load',list[0]);
}
function listpage(){
    if ($("#dg") != null) {
        $("#dg").remove(); //删除id="dg"的元素
    }
    $("#tab").html("<table id=\"dg\"></table>");
    $('#dg').datagrid({
        url : 'selectAll',
        pagination : true,//显示分页工具
        pageNumber : 1,//表示显示第几页，第一页
        pageSize : 10,//表示每页显示的记录个数
        pageList : [ 10, 20, 30, 40, 50 ],//第一页显示记录个数列表
        columns:[[
            {field:'id',title:'编号',width:100},
            {field:'name',title:'管理员账号',width:100},
            {field:'pass',title:'管理员密码',width:100,align:'right'},
            {field:'phone',title:'电话',width:100,align:'right'},
            {field:'email',title:'邮箱',width:100,align:'right'},
            {field:'qq',title:'QQ号',width:100,align:'right'},
            {field:'atype',title:'管理员类型',width:100,align:'right'}
        ]],
        toolbar: [{
            text:"添加",
            iconCls: 'icon-add',
            handler: function(){
                admininsert();
            }
        },'-',{
            text:"更新",
            iconCls: 'icon-edit',
            handler: function(){
                var list=$('#dg').datagrid("getSelections");
                if(list.length>0){
                    if(list.length==1){
                        adminupdate(list);
                    }else{
                        $.messager.alert('警告','一次只能修改一行');
                    }
                }else {
                    $.messager.alert('警告','没有选择要修改的行');
                }
            }
        },'-',{
            text:"删除",
            iconCls: 'icon-remove',
            handler: function(){
                var list=$('#dg').datagrid("getSelections");
                var listid={id:[]};
                if(list.length>0){
                    if ($("#dd") != null) {
                        $("#dd").remove(); //删除id="dg"的元素
                    }
                    $("#tab").html("<div id=\"dd\"></div>");
                    $('#dd').dialog({
                        title: 'My Dialog',
                        width: 400,
                        height: 200,
                        closed: false,
                        cache: false,
                        modal: true,
                        onClose:function () {
                            listpage();
                        },
                        buttons:[{
                            text:'删除',
                            handler:function(){
                                for(var i in list){
                                    listid.id[i]=list[i].id;
                                }
                                $.ajax({url:"deleteAll",
                                    success:function(data){
                                        $("#dd").dialog("close");
                                        listpage();
                                    },
                                    data:JSON.stringify(listid),
                                    contentType:"application/json;charset=UTF-8",
                                    dataType:"json",
                                    type:"POST"
                                });
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#dd").dialog("close");
                                listpage();
                            }
                        }]
                    });
                    $("#dd").html("确定要删除选择的数据吗!!!");
                }else {
                    $.messager.alert('警告','没有选择要删除的行');
                }
            }
        },'-',{
            text:"导入数据",
            iconCls: 'icon-help',
            handler: function(){alert('导入数据')}
        },'-',{
            text:"导出数据",
            iconCls: 'icon-help',
            handler: function(){alert('导出数据')}
        },'-',{
            text:"搜索",
            iconCls: 'icon-search',
            handler: function(){alert('搜索数据')}
        }]

    });
}
