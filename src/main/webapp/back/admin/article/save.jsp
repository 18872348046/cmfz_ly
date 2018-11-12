<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    $(function(){

        $("#gurn").combobox({
            panelHeight:100,
            url:"${pageContext.request.contextPath}/gurn/findAll",
            valueField:'id',
            textField:'name',
            formatter:function(row){
                return "<span style='font-size: 1.2em;'>"+row.name+"<span>";
            }
        });
    });
</script>
<style>
    .zi{
        font-size: 1.2em;
    }
</style>
<div style="text-align: center;" class="zi">
    <form action="" method="post" enctype="multipart/form-data" id="articlesave" class="easyui-form">
        <div style="margin-top: 20px;">
            标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text"  name="title" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：<input type="text" name="date" class="easyui-datebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：<input type="text" name="img" class="easyui-filebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容：<input type="text" name="content" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：<input  id="gurn" name="gurn_id" data-options="required:true,width:200,height:30" /></br>
        </div>
        <div style="margin-top: 20px;">
            状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：<select  class="easyui-combobox" name="status" data-options="required:true,width:200,height:30,panelHeight:50">
            <option value="y">展示</option>
            <option value="n">不展示</option>
        </select></br>
        </div>
        <div style="margin-top: 20px;">
            分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：<select  class="easyui-combobox" name="classift" data-options="required:true,width:200,height:30,panelHeight:50">
            <option value="s">上师文章</option>
            <option value="d">普通文章</option>
        </select></br>
        </div>
    </form>
</div>