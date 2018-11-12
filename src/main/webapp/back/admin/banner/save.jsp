<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    .zi{
        font-size: 1.2em;
    }
</style>
<div style="text-align: center;" class="zi">
    <form action="" method="post" enctype="multipart/form-data" id="bannersave" class="easyui-form">
        <div style="margin-top: 20px;">
            标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text"  name="title" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：<input type="text" name="img" class="easyui-filebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：<input type="text" name="date" class="easyui-datebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：<input type="text" name="status" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：<input type="text" name="descs" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
    </form>
</div>