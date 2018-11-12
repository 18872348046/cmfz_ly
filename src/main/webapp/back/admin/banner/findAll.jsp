<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function(){
            $("#bannerDg").edatagrid({
                url:"${pageContext.request.contextPath}/banner/findAll",
                fitColumns:true,
                singleSelect:false,//批量删除多选
                toolbar:"#xx",//增加工具栏
                pagination:true,//展示分页
                pageList:[2,4,6,8,10],
                pageSize:2,
                columns:[[
                    {title:'check',field:'cgeck',checkbox:true},
                    {title:'ID',field:'id',width:120,align:'center'},
                    {title:'标题',field:'title',width:120,align:'center'},
                    {title:'图片',field:'imgPoth',width:120,align:'center'},
                    {title:'时间',field:'date',width:120,align:'center'},
                    {title:'状态',field:'status',width:120,align:'center'},
                    {title:'描述',field:'descs',width:120,align:'center'},
                    {title:'操作',field:'chaozuo',width:120,align:'center',
                        formatter:function(value,rows,index){
                            return "<a href='javascript:;' class='dd' onclick=\"bannerDelete('"+rows.id+"','"+rows.imgPoth+"')\" data-options=\"iconCls:'icon-cancel'\">删除</a>&nbsp;&nbsp;&nbsp;" +
                                   "<a href='javascript:;' class='dd' onclick=\"bannerUpdate('"+rows.id+"','"+rows.imgPoth+"')\" data-options=\"iconCls:'icon-edit'\">修改</a>"
                        }
                    },
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/back/admin/image/' + rowData.imgPoth + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>标题: ' + rowData.title + '</p>' +
                        '<p>时间: ' + rowData.date + '</p>' +
                        '<p>状态: ' + rowData.status + '</p>' +
                        '<p>描述: ' + rowData.descs + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },


                //增加和修改在数据加载完成之后变成easy样式
                onLoadSuccess:function(){
                    $(".dd").linkbutton()
                }
            });
        });
        //删除
        function bannerDelete(id,img){

            $.ajax({
                url:"${pageContext.request.contextPath}/banner/removeById",
                type:"Post",
                data:{"id":id,"img":img},
                success:function(result){
                    //刷新页面
                    $("#bannerDg").datagrid('reload');
                    //提示用户删除成功
                    $.messager.show({title:'提示',msg:'删除成功'})
                },
                error:function(){
                    //提示用户删除失败
                    $.messager.show({title:'提示',msg:'删除失败'})
                }
            })
        }
        //增加
        function saveBanner() {
            $("#saveDialog").dialog({
                buttons:[
                    {
                        iconCls:'icon-book_edit',
                        text:'保存',
                        handler:function(){
                            //提交增加form里的内容
                            $("#bannersave").form('submit',{
                                url:"${pageContext.request.contextPath}/banner/add",
                                success:function(result){
                                    //刷新table表
                                    $("#bannerDg").datagrid('reload');
                                    //关闭对话框
                                    $("#saveDialog").dialog('close');
                                    var parseJSON = $.parseJSON(result);
                                    if(parseJSON.success){
                                        //提示用户增加成功
                                        $.messager.show({title:'提示',msg:'增加成功'});
                                    }else{
                                        //提示用户增加失败
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
                            $("#saveDialog").dialog('close');
                        }
                    }
                ]
            })
        }
        //修改
        function bannerUpdate(id,imgPoth){
            $("#updateDialog").dialog({
                href:"${pageContext.request.contextPath}/back/admin/banner/update.jsp?id="+id+"&img="+imgPoth,
                buttons:[
                    {
                        iconCls:'icon-edit',
                        text:'修改',
                        handler:function(){
                            //提交form表单里面的内容
                            $("#bannerUpdate").form('submit',{
                                url:"${pageContext.request.contextPath}/banner/update?imgPoth="+imgPoth,
                                //提交成功之后
                                success:function(result){
                                    //刷新表
                                    $("#bannerDg").datagrid('reload')
                                    //关闭对话框
                                    $("#updateDialog").dialog('close')
                                    //提示框
                                    var parseJSON = $.parseJSON(result);
                                    if(parseJSON.success){
                                        //修改成功
                                        $.messager.show({title:'提示',msg:'修改成功'})
                                    }else{
                                        //修改失败
                                        $.messager.show({title:'提示',msg:parseJSON.msg})
                                    }
                                }
                            });
                        }
                    },
                    //修改的关闭
                    {
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function(){
                            //关闭修改对话框
                            $("#updateDialog").dialog('close')
                        }
                    }
                ]
            })
        }
        //批量删除
        function deleteAll(){
            //返回所有被选中的行
            var rows=$("#bannerDg").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({titel:'提示',msg:'至少选中一行'})
            }else{
                var ids=[];
                var img=[];
                for (var i = 0; i <rows.length; i++) {
                    //获取勾选的id，放在ids里
                    ids.push(rows[i].id);
                    img.push(rows[i].imgPoth);
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/banner/removeAll",
                    type:"post",
                    traditional:true,//传递数组类型的数据时必须设置这个属性为true
                    data:{"id":ids,"img":img},
                    //成功返回
                    success:function(result){
                        //成功的消息提示
                        $.messager.show({title:'提示',msg:'删除成功'});
                        //刷新table表
                        $("#bannerDg").datagrid('reload');
                    },
                    //ajax失败
                    error:function(){
                        //成功的消息提示
                        $.messager.show({title:'提示',msg:'删除失败'});
                        //刷新table表
                        $("#bannerDg").datagrid('reload');
                    }
                })
            }
        }
    </script>
    <%--表--%>
    <table id="bannerDg" ></table>
    <%--增加工具栏--%>
    <div id="xx">
        <a href="javascript:;" onclick="saveBanner()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a>
        <a href="javascript:;" onclick="deleteAll()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">批量删除</a>
    </div>
    <%--修改对话框--%>
    <div id="updateDialog" data-options="iconCls:'icon-edit',title:'修改部门',width:500,height:400"></div>
    <%--增加对话框--%>
    <div id="saveDialog" data-options="href:'${pageContext.request.contextPath}/back/admin/banner/save.jsp',iconCls:'icon-save',title:'轮播图增加',width:500,height:400"></div>