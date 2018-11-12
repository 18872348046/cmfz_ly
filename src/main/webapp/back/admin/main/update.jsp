<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<style>
    .zi{
        font-size: 1.2em;
    }
</style>
<script>

</script>
<div class="zi" style="text-align: center">
    <form action="" method="post" id="adminUpdate" class="easyui-from">
        <div style="margin-top: 70px">
            原密码：<input type="text" id="pwd1" name="password1" class="easyui-textbox" data-options="required:true,width:200,height:30">
        </div>
        <div style="margin-top: 30px">
            新密码：<input type="text"  name="password" class="easyui-textbox" data-options="required:true,width:200,height:30,validType:'pwd'">
        </div>
        <div style="margin-top: 30px">
            确认新密码：<input type="text" name="password3" class="easyui-textbox" data-options="required:true,width:200,height:30">
        </div>
    </form>
</div>
