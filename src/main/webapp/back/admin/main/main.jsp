<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/admin/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/admin/themes/IconExtension.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/jquery.etree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/admin/js/common.js"></script>
<script type="text/javascript">

    $(function(){
        var name="${sessionScope.admins.name}";
        if(name==""){
            location.href="${pageContext.request.contextPath}/back/admin/login.jsp";
        }
        $.post("${pageContext.request.contextPath}/menu/findAllMenu",function(result){
            //遍历一级菜单
            $.each(result,function(index,menu){
                //遍历二级菜单
                var content="";
                $.each(menu.menus,function(index,me){
                    content+="<a href='javascript:;' onclick=\"addTabs('"+me.title+"','"+me.iconCls+"','"+me.href+"')\" style='width:95%;margin:10px 4px;border: 2px dodgerblue solid' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+me.iconCls+"'\">"+me.title+"</a></br>"
                });
                //增加菜单
                $("#aa").accordion('add',{
                    title:menu.title,
                    iconCls:menu.iconCls,
                    content:content,
                });
            });
        });

    });

    function addTabs(title,iconCls,href){
        //增加以前先判断tabs选项卡里有没有这个选项卡
        if(!$("#tt").tabs('exists',title)){
            $("#tt").tabs('add',{
                title:title,
                iconCls:iconCls,
                //关闭选项卡
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+href,
            });
        }else{
            //有这个选项卡就打开
            $("#tt").tabs('select',title)
        }

    }
    //修改密码
    function pwd(){
        var id="${sessionScope.admins.id}";
        $("#password").dialog({
            width:500,
            height:400,
            title:"修改密码",
            href:'${pageContext.request.contextPath}/back/admin/main/update.jsp',
            buttons:[
                {
                    iconCls:'icon-edit',
                    text:'修改',
                    handler:function(){
                        //提交form表单里面的内容
                        $("#adminUpdate").form('submit',{
                            url:"${pageContext.request.contextPath}/admin/pwd?id="+id,
                            //提交成功之后
                            success:function(result){
                                //提示框
                                var parseJSON = $.parseJSON(result);
                                if(parseJSON.success){
                                    //修改成功
                                    $.messager.show({title:'提示',msg:parseJSON.msg})
                                    //关闭对话框
                                    $("#password").dialog('close')
                                    //增加一个定时器
                                    setTimeout(function () {
                                        location.href="${pageContext.request.contextPath}/back/admin/login.jsp";
                                    },2000)

                                }else{
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
                        $("#password").dialog('close')
                    }
                }
            ]
        })
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admins.name} &nbsp;<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="pwd()">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/remove" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/admin/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
    <%--密码对话框--%>
    <div id="password"></div>
</body> 
</html>