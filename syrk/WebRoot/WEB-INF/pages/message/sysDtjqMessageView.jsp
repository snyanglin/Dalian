<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="" id="dataform" name="dataform" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">警情编号：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text"  name="fssj" id="jjbh" class="easyui-validatebox inputreadonly" value="${jcj.jjbh}"  style="width:500px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">报警时间：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="fssj" id="bj_sj" class="easyui-validatebox inputreadonly" value="${jcj.bj_sj}"  style="width:500px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">报警类别：</td>
		    	<td width="30%" class="dialogTd" colspan="3"> <input class="easyui-combobox inputreadonly" type="text"  style="width:500px;"  value="${jcj.jjlxdm}" disabled="disabled"
							data-options="url: contextPath + '/common/dict/D_JCJ_JJLXDM.js',valueField:'id',textField:'text',method:'get',required:true,tipPosition:'left'" /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">案发地址：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="fssj" id="jqdzms" class="easyui-validatebox inputreadonly" value="${jcj.jqdzms}"  style="width:500px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">报警内容：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xxnr" id="xxnr" class="easyui-validatebox inputreadonly" style="width: 500px; height:50px;" >${jcj.bjnr}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">所属辖区：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="fssj" id="gxdwdm" class="easyui-validatebox inputreadonly" value="${jcj.gxdwmc}"  style="width:500px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">报警人：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="fssj" id="fssj" class="easyui-validatebox inputreadonly" value="${jcj.bjr_xm}"  style="width:500px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">报警人性别：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="fssj" id="bjr_xbdm" class="easyui-validatebox inputreadonly" value="${jcj.bjr_xbdm}"  style="width:500px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">报警电话：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="fssj" id="fssj" class="easyui-validatebox inputreadonly" value="${jcj.bj_lxdh}"  style="width:500px;"/></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	setRead();
}

function beforeSubmit() {
}

function afterSubmit() {
}

function setRead(){
   $('#bjr_xbdm').val(window.top.getDictName(contextPath + '/common/dict/D_BZ_XB.js', "${jcj.bjr_xbdm}"));

}


</script>