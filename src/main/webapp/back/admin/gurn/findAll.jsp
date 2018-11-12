<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function(){
            $("#gurnDg").edatagrid({
                url:"${pageContext.request.contextPath}/gurn/findAllPage",
                fitColumns:true,
                toolbar:"#gg",//增加工具栏
                pagination:true,//展示分页
                pageList:[2,4,6,8,10],
                pageSize:2,
                singleSelect:false,//批量删除多选
                columns:[[
                    {title:'check',field:'cgeck',checkbox:true},
                    {title:'ID',field:'id',width:120,align:'center'},
                    {title:'姓名',field:'name',width:120,align:'center'},
                    {title:'法名',field:'law_name',width:120,align:'center'},
                    {title:'图像',field:'headPic',width:120,align:'center'},
                    {title:'状态',field:'state',width:120,align:'center'},
                    {title:'时间',field:'date',width:120,align:'center'},
                    {title:'性别',field:'sex',width:120,align:'center'},
                    {title:'操作',field:'chaozuo',width:140,align:'center',
                        formatter:function(value,rows,index){
                            return "<a href='javascript:;' class='dd' onclick=\"gurnDelete('"+rows.id+"','"+rows.headPic+"')\" data-options=\"iconCls:'icon-cancel'\">删除</a>&nbsp;&nbsp;&nbsp;" +
                                   "<a href='javascript:;' class='dd' onclick=\"gurnUpdate('"+rows.id+"','"+rows.state+"')\" data-options=\"iconCls:'icon-edit'\">修改状态</a>"
                        }
                    },
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/back/admin/image/' + rowData.headPic + '" style="height:50px;"></td>' +
                        '<td style="border:0;">' +
                        '姓名: ' + rowData.name + '' +
                        '<span style="margin-left:60px">法名: ' + rowData.law_name + '</span></br>' +
                        '状态: ' + rowData.state + '' +
                        '<span style="margin-left:90px">时间: ' + rowData.date + '</span>' +
                        '<span style="margin-left:60px">性别: ' + rowData.sex + '</span>' +
                        '</td>' +
                        '</tr></table>';
                },


                //增加和修改在数据加载完成之后变成easy样式
                onLoadSuccess:function(){
                    $(".dd").linkbutton()
                }
            });
        });
        //增加
        function gurnadd() {
            $("#saveDialogGurn").dialog({
                buttons:[
                    {
                        iconCls:'icon-book_edit',
                        text:'保存',
                        handler:function(){
                            //提交增加form里的内容
                            $("#gurnsave").form('submit',{
                                url:"${pageContext.request.contextPath}/gurn/add",
                                success:function(result){
                                    //刷新table表
                                    $("#gurnDg").datagrid('reload');
                                    //关闭对话框
                                    $("#saveDialogGurn").dialog('close');
                                    var parseJSON = $.parseJSON(result);
                                    if(parseJSON.success){
                                        //提示用户增加成功
                                        $.messager.show({title:'提示',msg:'增加成功'});
                                    }else{
                                        //提示用户增加成功
                                        $.messager.show({title:'提示',msg:parseJSON.msg});
                                    }
                                }
                            })
                        }
                    },
                    {
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function(){
                            $("#saveDialogGurn").dialog('close');
                        }
                    }
                ]
            })
        }
        //删除
        function gurnDelete(id,img){
            $.ajax({
                url:"${pageContext.request.contextPath}/gurn/removeById",
                type:"Post",
                data:{"id":id,"img":img},
                success:function(result){
                    //刷新页面
                    $("#gurnDg").datagrid('reload');
                    //提示用户删除成功
                    $.messager.show({title:'提示',msg:'删除成功'})
                },
                error:function(){
                    //提示用户删除失败
                    $.messager.show({title:'提示',msg:'删除失败'})
                }
            })
        }
        //批量删除
        function deleteAll(){
            //返回所有被选中的行
            var rows=$("#gurnDg").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({titel:'提示',msg:'至少选中一行'})
            }else{
                var ids=[];
                var img=[];
                for (var i = 0; i <rows.length; i++) {
                    //获取勾选的id，放在ids里
                    ids.push(rows[i].id);
                    img.push(rows[i].headPic);
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/gurn/removeAll",
                    type:"post",
                    traditional:true,//传递数组类型的数据时必须设置这个属性为true
                    data:{"id":ids,"img":img},
                    //成功返回
                    success:function(result){
                        //成功的消息提示
                        $.messager.show({title:'提示',msg:'删除成功'});
                        //刷新table表
                        $("#gurnDg").datagrid('reload');
                    },
                    //ajax失败
                    error:function(){
                        //成功的消息提示
                        $.messager.show({title:'提示',msg:'删除失败'});
                        //刷新table表
                        $("#gurnDg").datagrid('reload');
                    }
                })
            }
        }
        //修改状态
        function gurnUpdate(id,start){
            $.ajax({
                url:"${pageContext.request.contextPath}/gurn/motify",
                type:"post",
                data:{"id":id,"start":start},
                //成功返回
                success:function(result){
                    //刷新table表
                    $("#gurnDg").datagrid('reload');
                },
                //ajax失败
                error:function(){
                    //刷新table表
                    $("#gurnDg").datagrid('reload');
                }
            })
        }
    </script>
    <%--表--%>
    <table id="gurnDg" ></table>
    <%--增加工具栏--%>
    <div id="gg">
        <a href="javascript:;" onclick="gurnadd()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a>
        <a href="javascript:;" onclick="deleteAll()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">批量删除</a>
    </div>
    <%--修改对话框--%>
    <div id="updateDialogGurn" data-options="iconCls:'icon-edit',title:'修改部门',width:500,height:400"></div>
    <%--增加对话框--%>
    <div id="saveDialogGurn" data-options="href:'${pageContext.request.contextPath}/back/admin/gurn/save.jsp',iconCls:'icon-save',title:'轮播图增加',width:500,height:400"></div>