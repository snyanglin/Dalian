<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>典当业信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ddxxb/saveDdxxb" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
		  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">经营许可证：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="jyxkzh" name="jyxkzh" style="width:200px;" value="${entity.jyxkzh}" maxlength="50"
		    		data-options="required:true,tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">设立申请书编号：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="slsqsbh" name="slsqsbh" style="width:200px;" value="${entity.slsqsbh}" maxlength="50"
		    		data-options="required:true,tipPosition:'left'"/>
		    	</td>
		    </tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">资信证明号：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="zxzmh" name="zxzmh" style="width:200px;" value="${entity.zxzmh}" maxlength="50"
					data-options="required:true,validType:['letterOrNum'],tipPosition:'right'"/>
				</td>
			<td width="20%" class="dialogTd" align="right">有无分支机构：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text" id="ywfzjgdm" name="ywfzjgdm" style="width:200px;" value="${entity.ywfzjgdm}"
					data-options="url:contextPath +'/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr"> 
				<td width="20%" class="dialogTd" align="right">有无收当国家统收：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text" id="ywsdgjtsdm" name="ywsdgjtsdm" style="width:200px;" value="${entity.ywsdgjtsdm}"
					data-options="url:contextPath +'/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">典当建筑物结构：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text" id="dd_jzwjglxdm" name="dd_jzwjglxdm" style="width:200px;" value="${entity.dd_jzwjglxdm}"
					data-options="url:contextPath +'/common/dict/D_BZ_JZWJGLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">专营：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="zy" name="zy" style="width:627px; height:48px;"
					data-options="validType:['maxLength[500]'],invalidMessage:'附属娱乐项目不能超过500个汉字，请重新输入！',required:false,tipPosition:'left'">${entity.zy}</textarea>
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">专卖物品权：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="zmwpq" name="zmwpq" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[500]'],invalidMessage:'专卖物品权不能超过500个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.zmwpq}</textarea>
				</td>
	    	</tr>
    	    <tr class="dialogTr">
	    	    <td width="16%" class="dialogTd" align="right">备注：</td>
	    	    <td width="80%" class="dialogTd" colspan="5">
	    	    	<textarea id="bz" name="bz" class="easyui-validatebox" rows="2" style="width:627px; height:48px;"
					data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
				</td>
   	       </tr>
	     </table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
}
function beforeSubmit(){
}
function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	window.parent.location.reload();
}
</script>