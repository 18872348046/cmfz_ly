<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function(){
        $("#albumdetails").form('load','${pageContext.request.contextPath}/album/findById?id=${param.id}')
    });
</script>
<style>
    .zi{
        font-size: 1.2em;
    }
</style>
<div style="text-align: center;" class="zi">
    <form action="" method="post" enctype="multipart/form-data" id="albumdetails" class="easyui-form">
        <div style="margin-top: 20px;">
            <img  style="text-align: center" name="img" src="${pageContext.request.contextPath}/back/admin/image/${sessionScope.imgName}"  data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text"  name="title" class="easyui-textbox" data-options="width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            发布时间：<input type="text" name="publishDate" class="easyui-datebox" data-options="width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            集&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：<input type="text" name="count" class="easyui-textbox" data-options="width:200,height:30"></br>
        </div>

        <div style="margin-top: 20px;">
            作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：<input type="text" name="author" class="easyui-textbox" data-options="width:200,height:30"></br>
        </div>

        <div style="margin-top: 20px;">
            播&nbsp;&nbsp;音&nbsp;&nbsp;员：<input type="text" name="broadCast" class="easyui-textbox" data-options="width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            等&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：<input type="text" name="star" class="easyui-textbox" data-options="width:200,height:30"></br></br>
        </div>
        <div style="margin-top: 20px;">
            简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介：<input type="text" name="brief" class="easyui-textbox" data-options="width:200,height:30"></br>
        </div>
    </form>
</div>