<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    .zi{
        font-size: 1.2em;
    }
</style>
<div style="text-align: center;" class="zi">
    <form action="" method="post" enctype="multipart/form-data" id="gurnsave" class="easyui-form">
        <div style="margin-top: 20px;">
            姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text"  name="name" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            法&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text"  name="law_name" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            头&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像：<input type="text" name="img" class="easyui-filebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：<select  class="easyui-combobox" name="state" data-options="required:true,width:200,height:30,panelHeight:50">
                                                         <option value="y">展示</option>
                                                         <option value="n">不展示</option>
                                                     </select></br>
        </div>
        <div style="margin-top: 20px;">
            时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：<input type="text" name="date" class="easyui-datebox" data-options="required:true,width:200,height:30"></br>
        </div>

        <div style="margin-top: 20px;">
            性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<select  class="easyui-combobox" name="sex" data-options="required:true,width:200,height:30,panelHeight:50">
                                                         <option value="男">男</option>
                                                         <option value="女">女</option>
                                                      </select></br>
        </div>
    </form>
</div>