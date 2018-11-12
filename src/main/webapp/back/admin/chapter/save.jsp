<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function(){
        $("#albumAll").combobox({
            panelHeight:100,
            url:"${pageContext.request.contextPath}/album/findAllAlbum",
            valueField:'id',
            textField:'title',
            formatter:function(row){
                return "<span style='font-size: 1.2em;'>"+row.title+"<span>";
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
    <form action="" method="post" enctype="multipart/form-data" id="chaptersave" class="easyui-form">
        <div style="margin-top: 20px;">
            标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text"  name="title" class="easyui-textbox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            音&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;频：<input type="text" name="audio" class="easyui-filebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            发布时间：<input type="text" name="foundDate" class="easyui-datebox" data-options="required:true,width:200,height:30"></br>
        </div>
        <div style="margin-top: 20px;">
            所属专辑：<input type="text" id="albumAll" name="album_id" data-options="required:true,width:200,height:30"></br>
        </div>
    </form>
</div>