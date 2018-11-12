<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function(){
            $("#courseDg").edatagrid({
                url:"${pageContext.request.contextPath}/course/findAll",
                fitColumns:true,
                toolbar:"#course",//增加工具栏
                columns:[[
                    {title:'ID',field:'id',width:120,align:'center'},
                    {title:'标题',field:'title',width:120,align:'center'},
                    {title:'时间',field:'foundDate',width:120,align:'center'},
                    {title:'操作',field:'chaozuo',width:120,align:'center',
                        formatter:function(value,rows,index){
                            return "<a href='javascript:;' class='dd' onclick=\"courseDelete('"+rows.id+"')\" data-options=\"iconCls:'icon-cancel'\">删除</a>"
                        }
                    },
                ]],

                //增加和修改在数据加载完成之后变成easy样式
                onLoadSuccess:function(){
                    $(".dd").linkbutton()
                }
            });

        });
        //增加
        function saveArticle() {
            $("#saveCourse").dialog({
                buttons:[
                    {
                        iconCls:'icon-book_edit',
                        text:'保存',
                        handler:function(){
                            //提交增加form里的内容
                            $("#courseSave").form('submit',{
                                url:"${pageContext.request.contextPath}/course/add",
                                success:function(result){
                                    //刷新table表
                                    $("#courseDg").datagrid('reload');
                                    //关闭对话框
                                    $("#saveCourse").dialog('close');
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
                            $("#saveCourse").dialog('close');
                        }
                    }
                ]
            })
        }
        //删除
        function courseDelete(id){
            $.ajax({
                url:"${pageContext.request.contextPath}/course/remove",
                type:"Post",
                data:{"id":id},
                success:function(result){
                    //刷新页面
                    $("#courseDg").datagrid('reload');
                    //提示用户删除成功
                    $.messager.show({title:'提示',msg:'删除成功'})
                },
                error:function(){
                    //提示用户删除失败
                    $.messager.show({title:'提示',msg:'删除失败'})
                }
            })
        }
    </script>
    <%--表--%>
    <table id="courseDg" ></table>
    <%--增加工具栏--%>
    <div id="course">
        <a href="javascript:;" onclick="saveArticle()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a>
    </div>
    <%--增加对话框--%>
    <div id="saveCourse" data-options="href:'${pageContext.request.contextPath}/back/admin/course/save.jsp',iconCls:'icon-save',title:'轮播图增加',width:500,height:400"></div>