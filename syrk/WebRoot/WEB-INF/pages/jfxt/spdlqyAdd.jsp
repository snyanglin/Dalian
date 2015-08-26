<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增视频区域</title>
<script type="text/javascript">
	var mainTabID = '${mainTabID}';
	var mode = '${mode}';
</script>
</head>
<body style="margin-top:20px" class="bodybg">
   <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    <table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form action="<%=basePath%>spdlqy/save" id="dlqyAddForm" name="dlqyAddForm" method="post">
	    	      <input type='hidden' name='id' id="id" value="${entity.id}"/>  
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">所属分局：</td>
				    	<td width="30%" class="dialogTd"><input type='text' id="fjmc" name='fjmc'    class="inputReadonly" style="width:200px;"  /></td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">区域名称：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="meaning" name="meaning" value="${entity.meaning}" style="width:200px;"  maxlength="50"
		    	        data-options="required:true,charSet:'halfUpper'"/></td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">区域名称简拼：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="spell" name="spell" value="${entity.spell}"  style="width:200px;"  maxlength="25"
		    	        data-options="required:true,charSet:'halfUpper'"/></td>
	    	      </tr>
	    	      
    			</form>
	    		</table>
			</div>
		</div>
	    </div>
	    </div>
	    <div style="height:6px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveButton"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
		</div>
	 </table>	    
</div>
<script type="text/javascript">
$(function(){
	$("#meaning").bind("blur",function(e){	
		checkMC();
	});
	getSsjgdmName();
    //保存前验证，保存成功以后操作事件
	$('#dlqyAddForm').form({  
        onSubmit:function(){
        	var returnVal=checkMC();
        	if(returnVal==-1){//错误
        		return false;//阻止提交
        	}
        	else if(returnVal>0){
        		alert('区域名称重复啦！请重新填写！');
        		return false;
        	}
        
            return $(this).form('validate');  
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到列表列表页面（这里也可以添加一些其他页面流程）
          	    var url = contextPath+"/forward/jfxt|spdlqyList";
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    });
    //保存按钮绑定点击事件【注意：这里保存时候可以添加重复数据，是否要条件验证？】  
	$('#saveButton').click(function(){
		topMessager.confirm('操作确认', '您是否保存视频区域信息？',  function(r) {
			if (r) {
				$('#dlqyAddForm').submit();
			}
		});
	});
});
</script>
<script type="text/javascript">
function getSsjgdmName(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/getSsjgdmName",
		dataType:"json",
		success:function(data) {
		//alert(data.ORGNAME);
			$("#fjmc").val(data.ORGNAME);
		},
		complete:function() {
		},
		error:function() {
		}
	});

}
function checkMC() {
	var mc=$("#meaning").val();
	if(stringTrim(mc)==""){
		alert('区域名称不允许为空');	
		return -1;	
	}

	var mydata="";
	mydata={meaning:mc};
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>spdlqy/checkSameName",
		dataType:"json",
		data:mydata,
		async:false,//强制同步		
		success:function(affectedRow) {
			retVal=affectedRow;
		},
		error:function() {
			retVal= -1;
		}
	});	
	return retVal;
}
</script>
</body>
</html>
