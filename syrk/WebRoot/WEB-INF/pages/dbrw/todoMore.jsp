<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>信息</title>
  </head>
  
  <body class="easyui-layout" data-options="fit:true">
    <div class="easyui-layout" data-options="fit:true,border:false">
  	<div data-options="region:'center',split:true,title:'协同任务列表',border:false" style="height:auto">
    <form action="" id="dataForm" name="dataForm" method="post">
   
   	<input type="hidden" id="pk" name="id" value="${entity.id}" />
   
    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    	<tr class="dialogTr">
		    <td width="20%" class="dialogTd" align="right">协同内容：</td>
			<td width="80%" class="dialogTd" colspan="5"><textarea name="ywxtgzrwmc"  id="ywxtgzrwmc"  readonly="readonly" maxlength="400" class="easyui-validatebox inputreadonly" 
				style="width: 808px; height:48px;" data-options="required:true,validType:['maxLength[400]'],
				invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'left'">${entity.ywxtgzrwmc}</textarea>
			</td>
    	</tr>
    	<tr class="dialogTr">
			<td width="10%" class="dialogTd" align="right">发起部门：</td>
			<td width="20%" class="dialogTd">
				<input type="text" name="fqrbm" id="fqrbm" class="easyui-validatebox inputreadonly" 
					style="width:227px;" value="${entity.fqrbm}" data-options="required:false,tipPosition:'left'" maxlength="120" readonly="readonly"/>
				&nbsp;&nbsp;发起时间：
				<input type="text" name="cjsj" id="cjsj" class="easyui-validatebox inputreadonly" 
			 		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" readonly="readonly" data-options="required:false,
			 		validType:['date[\'yyyy-MM-dd HH:mm\']']" style="width: 200px;" value="${entity.cjsj}"/>
			 	&nbsp;&nbsp;发起人：
			 	<input type="text" name="fqr" id="fqr" class="easyui-validatebox inputreadonly" readonly="readonly"
					style="width:227px;" value="${entity.fqr}" data-options="required:false,tipPosition:'left'" maxlength="100"/>	
			</td>
    	</tr>
    	<tr class="dialogTr">
			<td width="10%" class="dialogTd" align="right">接收部门：</td>
			<td width="20%" class="dialogTd">
				<input type="text" name="rwclrbm" id="rwclrbm" class="easyui-validatebox inputreadonly" 
					style="width:227px;" value="${entity.rwclrbm}" data-options="required:false,tipPosition:'left'" maxlength="120" readonly="readonly"/>
				&nbsp;&nbsp;处理时间：
				<input type="text" name="rwclsj" id="rwclsj" class="easyui-validatebox  inputreadonly" 
			 		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" readonly="readonly" data-options="required:false,
			 		validType:['date[\'yyyy-MM-dd HH:mm\']']" style="width: 200px;" value="${entity.rwclsj}"/>
			 	&nbsp;&nbsp;接收人：
			 	<input type="text" name="rwclr" id="rwclr" class="easyui-validatebox inputreadonly" readonly="readonly"
					style="width:227px;" value="${entity.rwclr}" data-options="required:false,tipPosition:'left'" maxlength="100"/>	
			</td>
    	</tr>
    	<tr class="dialogTr">
			<td width="10%" class="dialogTd" align="right">裁决部门：</td>
			<td width="20%" class="dialogTd">
				<input type="text" name="cjrbm" id="cjrbm" class="easyui-validatebox inputreadonly" 
					style="width:227px;" value="${entity.cjrbm}" data-options="required:false,tipPosition:'left'" maxlength="120" readonly="true"/>
				&nbsp;&nbsp;裁决时间：
				<input type="text" name="cjsj" id="cjsj" class="easyui-validatebox inputreadonly" 
			 		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" readonly="readonly" data-options="required:false,
			 		validType:['date[\'yyyy-MM-dd HH:mm\']']" style="width: 200px;" value="${entity.cjsj}"/>
			 	&nbsp;&nbsp;裁决人：
			 	<input type="text" name="cjr" id="cjr" class="easyui-validatebox inputreadonly" readonly="readonly"
					style="width:227px;" value="${entity.cjr}" data-options="required:false,tipPosition:'left'" maxlength="100"/>	
			</td>
    	</tr>
    	<tr class="dialogTr">
			<td width="10%" class="dialogTd" align="right">处理结果：</td>
			<td width="20%" class="dialogTd">
				<input type="text" name="cjrbm" id="cjrbm" class="easyui-validatebox inputreadonly" 
					style="width:227px;" value="${entity.cjrbm}" data-options="required:false,tipPosition:'left'" maxlength="120" readonly="readonly"/>
			 	&nbsp;&nbsp;裁决结果：
			 	<input type="text" name="cjjgdm" id="cjjgdm" class="easyui-validatebox inputreadonly" readonly="readonly"
					style="width:200px;" value="${entity.cjjgdm}" data-options="required:false,tipPosition:'left'" maxlength="100"/>	
			</td>
    	</tr>
    </table>
    <a href="javascript:void(0)" onclick="menu_open('发送消息', '/dbrwVL/tMore')">发送消息</a>
    <a href="javascript:void(0)" onclick="menu_open('查看消息', '/dbrwVL/sMore')">查看消息</a>
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
	if(arr["saveID"])
		$("#pk").val(arr["saveID"]);
}

</script>