<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function(){
            $("#albumDg").treegrid({
                url:"${pageContext.request.contextPath}/album/findAll",
                fitColumns:true,
                singleSelect:true,//批量删除多选
                toolbar:"#al",//增加工具栏
                pagination:true,//展示分页
                pageList:[2,4,6,8,10,12,20],
                pageSize:4,
                fit:true,
                idField:'id',
                treeField:'title',
                animate:true,
                columns:[[
                    {title:'标题',field:'title',width:120,align:'center'},
                    {title:'路径',field:'path',width:120,align:'center'},
                    {title:'大小',field:'size',width:120,align:'center'},
                    {title:'发布时间',field:'foundDate',width:120,align:'center'},
                    {title:'时长',field:'duration',width:120,align:'center'},
                ]],
            });
        });
        //下载音频
        function downloadChapter() {
            //返回所有被选中的行
            var rows = $("#albumDg").datagrid('getSelections');
            if (rows.length <= 0) {
                $.messager.show({titel: '提示', msg: '至少选中一行'})
            } else {
                /*children是在album这个实体类里，如果他不等于空，就表示用户选者的是专辑*/
                if(rows[0].children!=null){
                    $.messager.show({titel: '提示', msg: '请选择音频'});
                }else{
                    console.log(rows[0].path);
                    location.href="${pageContext.request.contextPath}/chapter/download1?path="+rows[0].path;
                }
            }
        }





        //增加专辑
        function addAlbum(){
            $("#saveDialogAlbum").dialog({
                buttons:[
                    {
                        iconCls:'icon-book_edit',
                        text:'保存',
                        handler:function(){
                            //提交增加form里的内容
                            $("#albumsave").form('submit',{
                                url:"${pageContext.request.contextPath}/album/add",
                                success:function(result){
                                    //刷新table表
                                    $("#albumDg").datagrid('reload');
                                    //关闭对话框
                                    $("#saveDialogAlbum").dialog('close');
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
                            $("#saveDialogAlbum").dialog('close');
                        }
                    }
                ]
            })
        }
        //增加章节
        function addChapter(){
            $("#saveDialogChapter").dialog({
                buttons:[
                    {
                        iconCls:'icon-book_edit',
                        text:'保存',
                        handler:function(){
                            //提交增加form里的内容
                            $("#chaptersave").form('submit',{
                                url:"${pageContext.request.contextPath}/chapter/add",
                                success:function(result){
                                    //刷新table表
                                    $("#albumDg").datagrid('reload');
                                    //关闭对话框
                                    $("#saveDialogChapter").dialog('close');
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
                            $("#saveDialogChapter").dialog('close');
                        }
                    }
                ]
            })
        }
        //专辑详情
        function albumAll(){
            //返回所有被选中的行
            var rows=$("#albumDg").datagrid('getSelections');
            if(rows.length<=0 || rows.length>=2){
                $.messager.show({titel:'提示',msg:'只能选中一行'})
            }else{
                var ids=[];
                for (var i = 0; i <rows.length; i++) {
                    //获取勾选的id，放在ids里
                    ids.push(rows[i].id);

                }
                $("#albumDetails").dialog({
                    href:"${pageContext.request.contextPath}/back/admin/album/details.jsp?id="+ids,
                    buttons:[
                        {
                            iconCls:'icon-cancel',
                            text:'关闭',
                            handler:function(){
                                $("#albumDetails").dialog('close');
                            }
                        }
                    ]
                });
            }
        }
    </script>
    <%--表--%>
    <table id="albumDg" ></table>
    <%--增加工具栏--%>
    <div id="al">
        <a href="javascript:;" onclick="albumAll()" class="easyui-linkbutton" data-options="iconCls:'icon-book_go'">专辑详情</a>
        <a href="javascript:;" onclick="addAlbum()" class="easyui-linkbutton" data-options="iconCls:'icon-book_addresses'">增加专辑</a>
        <a href="javascript:;" onclick="addChapter()" class="easyui-linkbutton" data-options="iconCls:'icon-application_form_add'">增加章节</a>
        <a href="javascript:;" onclick="downloadChapter()" class="easyui-linkbutton" data-options="iconCls:'icon-book_next'">下载音频</a>
    </div>
    <%--修改对话框--%>
    <div id="updateDialogAlbum" data-options="iconCls:'icon-edit',title:'修改部门',width:500,height:400"></div>
    <%--增加专辑对话框--%>
    <div id="saveDialogAlbum" data-options="href:'${pageContext.request.contextPath}/back/admin/album/save.jsp',iconCls:'icon-save',title:'增加专辑',width:500,height:400"></div>
   <%--增加章节对话框--%>
   <div id="saveDialogChapter" data-options="href:'${pageContext.request.contextPath}/back/admin/chapter/save.jsp',iconCls:'icon-save',title:'增加章节',width:500,height:400"></div>
    <%--专辑详情--%>
    <div id="albumDetails" data-options="iconCls:'icon-save',title:'专辑详情',width:500,height:400"></div>