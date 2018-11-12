<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function(){
            $("#userDg").edatagrid({
                url:"${pageContext.request.contextPath}/user/findAll",
                fitColumns:true,
                singleSelect:false,//批量删除多选
                pagination:true,//展示分页
                pageList:[1,2,4,6,8,10],
                pageSize:2,
                columns:[[
                    {title:'check',field:'cgeck',checkbox:true},
                    {title:'ID',field:'id',width:100,align:'center'},
                    {title:'手机号',field:'telephone',width:100,align:'center'},
                    {title:'用户名',field:'username',width:100,align:'center'},
                    {title:'密码',field:'password',width:100,align:'center'},
                    {title:'盐',field:'salt',width:100,align:'center'},
                    {title:'省',field:'province',width:100,align:'center'},
                    {title:'市',field:'city',width:100,align:'center'},
                    {title:'法名',field:'nickName',width:100,align:'center'},
                    {title:'头像',field:'headPic',width:100,align:'center'},
                    {title:'性别',field:'sex',width:100,align:'center'},
                    {title:'签名',field:'sign',width:100,align:'center'},
                    {title:'注册时间',field:'date',width:100,align:'center'},
                    {title:'状态',field:'state',width:100,align:'center'},
                    {title:'操作',field:'chaozuo',width:120,align:'center',
                        formatter:function(value,rows,index){
                            return "<a href='javascript:;' class='dd' onclick=\"userUpdate('"+rows.id+"','"+rows.state+"')\" data-options=\"iconCls:'icon-edit'\">修改状态</a>"
                        }
                    },
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/back/admin/image/' + rowData.headPic + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '手机号: ' + rowData.telephone + '' +
                        '<span style="margin-left:60px">用户名: ' + rowData.username + '</span>' +
                        '<span style="margin-left:60px">密码: ' + rowData.password + '</span>' +
                        '<span style="margin-left:60px">盐: ' + rowData.salt + '</span></br>' +
                        '省: ' + rowData.province + '' +
                        '<span style="margin-left:60px">市: ' + rowData.city + '</span>' +
                        '<span style="margin-left:60px">法名: ' + rowData.nickName + '</span>' +
                        '<span style="margin-left:60px">性别: ' + rowData.sex + '</span></br>' +
                        '签名: ' + rowData.sign + '' +
                        '<span style="margin-left:60px">注册时间: ' + rowData.date + '</span>' +
                        '<span style="margin-left:60px">状态: ' + rowData.state + '</span>' +
                        '</td>' +
                        '</tr></table>';
                },


                //增加和修改在数据加载完成之后变成easy样式
                onLoadSuccess:function(){
                    $(".dd").linkbutton()
                }
            });

        });

        //修改文章的状态
        function userUpdate(id,state){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/motifyStart",
                type:"post",
                data:{"id":id,"state":state},
                //成功返回
                success:function(result){
                    //刷新table表
                    $("#userDg").datagrid('reload');
                },
                //ajax失败
                error:function(){
                    //刷新table表
                    $("#userDg").datagrid('reload');
                }
            })
        }

    </script>
    <%--表--%>
    <table id="userDg" ></table>