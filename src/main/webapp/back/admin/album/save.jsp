<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    .zi{
        font-size: 1.2em;
    }
</style>
<div style="text-align: center;" class="zi">
    <form action="" method="post" enctype="multipart/form-data" id="albumsave" class="easyui-form">
        <div style="margin-top: 20px;">
            标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text"  name="title" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            发布时间：<input type="text" name="publishDate" class="easyui-datebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            集&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：<input type="text" name="count" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>

        <div style="margin-top: 20px;">
            作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：<input type="text" name="author" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：<input type="text" name="img" class="easyui-filebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            播&nbsp;&nbsp;音&nbsp;&nbsp;员：<input type="text" name="broadCast" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            等&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：<select  class="easyui-combobox" name="star" data-options="required:true,width:200,height:30,panelHeight:50">
                                                        <option value="⭐">⭐</option>
                                                        <option value="⭐⭐">⭐⭐</option>
                                                        <option value="⭐⭐⭐">⭐⭐⭐</option>
                                                        <option value="⭐⭐⭐⭐">⭐⭐⭐⭐</option>
                                                         <option value="⭐⭐⭐⭐⭐">⭐⭐⭐⭐⭐</option>
                                                    </select></br>
        </div>
        <div style="margin-top: 20px;">
            简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介：<input type="text" name="brief" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
    </form>
</div>