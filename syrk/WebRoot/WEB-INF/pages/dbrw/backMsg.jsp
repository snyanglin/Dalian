<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>信息</title>
    <script type="text/javascript">
    	<!--
    	 //重置按钮
	    function resetButton(){
    		closeSelf();
	    }
    
	    //查询按钮
	    function queryButton(){
	    	var sfck = document.getElementById("sfck").value;
	    	var id = document.getElementById("ids").value;
	    	if(sfck != "0"){
	    		$.messager.alert("该条信息为已查看状态，无法收回！");
	    		return;
	    	} else{
		    	$.messager.confirm("系统提示", "是否收回该消息?", function(r){
	    			if(r){
	    				$.ajax({
	    					async:false,
	    					type:"POST",
	    					url: contextPath+"/dbrwVL/backMsg",
	    					dataType:"json",
	    					data: "id=" + id,
	    					success:function(data){
	    					if (data && data.e) {
	    							if(data.e != '0'){
	    								$.messager.alert("收回成功!");
	    								//resetButton();
	    							}else {
	    								$.messager.alert("收回失败!");
	    							}
	    						}
	    					}
	    				});
	    			}
	    		});
	    	}
			
	    }
	    
	    $(function(){
	    	/*
	    	var par = document.getElementById("pk").value;
	    	if(par!=null && par!=''){
	    		alert("发送成功");
	    		document.getElementById("s").innerHTML = '收回';
	    	}
	    	*/
	    }
	    );
    	-->
    </script>
  </head>
  
  <body class="easyui-layout" data-options="fit:true">
    <div class="easyui-layout" data-options="fit:true,border:false">
  	<div data-options="region:'center',split:true,title:'发送消息',border:false" style="height:80">
     <form action="<%=basePath%>sysMessage/saveMsg" id="dataform" name="dataform" method="post">
   	 
	   	<input type="hidden" id="pk" name="id" value="${id}" />
	   	<input type="hidden" id="sfck" name="sfck" value="${entity.sfck}" />
	   	<input type="hidden" id="ids" name="ids" value="${entity.id}" />
	    
	    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">接收人：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="jsr"   readonly="readonly" id="jsr"  maxlength="400" class="easyui-validatebox inputreadonly" 
					style="width: 808px; height:48px;" data-options="required:true,validType:['maxLength[400]'], 
					invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'left'">${entity.jsr}</textarea>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">发送内容：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="xxnr"   readonly="readonly" id="xxnr"  maxlength="400" class="easyui-validatebox inputreadonly" 
					style="width: 808px; height:96px;" data-options="required:false,validType:['maxLength[400]'],
					invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'left'">${entity.xxnr}</textarea>
				</td>
	    	</tr>
	    	<tr>
				<td nowrap="nowrap" colspan="6" align="center">
					<a class="easyui-linkbutton" iconCls="icon-add" onclick="queryButton();" id="send">
						收回
					</a>
				    &nbsp;&nbsp;
		    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton();">
		    			关闭
		    		</a>
				</td>
			</tr>
	    </table>
    </form>
    </div>
    </div>
  </body>
</html>

<script type="text/javascript" >
function doInit(paramArray) {
	
}

function beforeSubmit() {
}

function afterSubmit(arr) {
}

</script>