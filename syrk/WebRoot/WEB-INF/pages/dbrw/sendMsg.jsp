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
    		document.getElementById("jsr").value = '';
    		document.getElementById("xxnr").value = '';
    		
	    	$("#dataForm").form("reset");
	    }
    
	    //查询按钮
	    function sendButton(){
	    	if($("#dataform").form('validate')){
				topMessager.confirm('操作确认', '您是否发送信息？',  function(r) {
					if (r) {
						//$('#dataform').submit();
						//$(document.body).mask("发送中...");
						$('#dataform').form("submit", {  
				    		url: "<%=basePath%>sysMessage/saveMsg",
				    		dataType: "json",
				    		success: function(data){
				    			var json = $.parseJSON(data);
				    			if(json.e != null && json.e != '0'){
				    				$.messager.alert("系统提示", "消息发送成功!");
				                	document.getElementById("send").style.display = "none";
				                	document.getElementById("back").style.display = "";
				                	document.getElementById("reset").style.display = "none";
				                	document.getElementById("ids").value = json.e;
				                	document.getElementById("xxnr").disabled = true;
				                	document.getElementById("orgSelectButton").disabled = true;
				                } else {
				                	$.messager.alert("系统提示", "消息发送失败!");
				                	topMessager.confirm('操作确认', '您是否取消发送信息？',  function(re) {
				    					if (re) {
				    						closeSelf();
				    					}
				    				}
				                	);
				                }
				    		}
				    	});
					}
				})
			}
	    }
	    
	    function backButton(){
	    	//var sfck = document.getElementById("sfck").value;
	    	var id = document.getElementById("ids").value;
	    	/*
	    	if(sfck != "0"){
	    		alert("该条信息为已查看状态，无法收回！");
	    		return;
	    	} 
	    	*/
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
	    								$.messager.alert("系统提示", "收回成功!");
	    								resetButton();
	    								document.getElementById("send").style.display = "";
					                	document.getElementById("back").style.display = "none";
					                	document.getElementById("reset").style.display = "";
					                	document.getElementById("ids").value = "";
					                	document.getElementById("xxnr").disabled = false;
					                	document.getElementById("orgSelectButton").disabled = false;
	    							}else {
	    						
	    							}
	    						}
	    					}
	    				});
	    			}
	    		});
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
	    
	    function onOrgUserSelected(userIDInputID) {
	    	//alert(userIDInputID);
	    	var context = document.getElementById("jsr").value;
	    	var arr = new Array();
	    	arr = context.split(",");
	    	if(arr.length > 199){
	    		$.messager.alert("系统提示", "选择发送人员不可以超过200人, 请确认！");
	    		document.getElementById("jsr").value = "";
	    	}
	    }
	    
    	-->
    </script>
  </head>
  
  <body class="easyui-layout" data-options="fit:true">
    <div class="easyui-layout" data-options="fit:true,border:false">
  	<div data-options="region:'center',split:true,title:'发送消息',border:false" style="height:80">
     <form action="<%=basePath%>sysMessage/saveMsg" id="dataform" name="dataform" method="post">
   	 
	   	<input type="hidden" id="pk" name="id" value="${id}" />
	   	<input type="hidden" id="ids" name="ids" />
	    
	    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">接收人：</td>
				<td width="80%" class="dialogTd" colspan="5">
					<!-- 
					<textarea name="jsr"  id="jsr"  maxlength="400" class="easyui-validatebox" 
					style="width: 808px; height:48px;" data-options="required:true,validType:['maxLength[400]'],
					invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'left'">${entity.jsr}</textarea>
					-->
					<table border="0" cellpadding="0" cellspacing="0">
	    		<tr>
	    			<td width="500">
	    				<textarea class="easyui-validatebox" rows="3" id="jsr" name="jsr" maxlength="400" data-options="required:true,validType:['maxLength[400]'], invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'left'"
	    					style="width:760px; height:72px;" readonly="readonly"></textarea>
	    			</td>
	    			<td><input type="hidden" id="userid" name="userid" value="" style="width: 100;" />
	   					<input type="hidden" id="usertableid" name="usertableid" value="" style="width: 100;" />
	   					<input type="hidden" id="orgcode" name="orgcode" value="" style="width: 100;" />
	    				<input type="hidden" id="orgname" name="orgname" style="width: 400;" value="" />
	   					<input type="hidden" id="orgid" name="orgid" value="" style="width: 100;" />
	   					<input type="button" id="orgSelectButton" class="butSelect2" 
	    					onclick="public_multiSelectOrgUser('', '', '', '', '', '', 'userid', 'jsr', 'usertableid', 'orgcode', 'orgname', 'orgid', false, '', window, 'onOrgUserSelected', '')"/></td>
	    		</tr>
	    		</table>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">发送内容：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="xxnr"  id="xxnr"  maxlength="200" class="easyui-validatebox" 
					style="width: 808px; height:96px;" data-options="required:true,validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.xxnr}</textarea>
				</td>
	    	</tr>
	    	<tr>
				<td nowrap="nowrap" colspan="6" align="center">
					<a class="easyui-linkbutton" iconCls="icon-add" onclick="sendButton();" id="send">
						发送
					</a>
					&nbsp;&nbsp;
					<a class="easyui-linkbutton" iconCls="icon-add" onclick="backButton();" id="back" style="display:none;">
						收回
					</a>
				    &nbsp;&nbsp;
		    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton();" id="reset">
		    			重置
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