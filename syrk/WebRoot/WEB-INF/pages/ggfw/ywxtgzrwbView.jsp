<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>协同任务处理</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ywxtgzrwb/executeRuleMethod" id="xtrwForm" name="xtrwForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
	    	<input type="hidden" id="operType" name="operType" value="${operType}"/>
	    	<input type="hidden" id="flag" name="flag" value="${flag}"/>
	    	<input type="hidden" id="businessName" name="businessName" value="${businessName}"/>
	    	<input type="hidden" id="methodName" name="methodName" value="${methodName}"/>
	    	<input type="hidden" id="hsrwid" name="hsrwid" value="${hsrwid}"/>
	    	<input type="hidden" id="hslx" name="hslx" value="${hslx}"/>
	    	<input type="hidden" id="ryid" name="ryid" value="${ryid}"/>
	    	<input type="hidden" id="lxfslxdm" name="lxfslxdm" value="${lxfslxdm}"/>
	    	<input type="hidden" id="lxfs" name="lxfs" value="${lxfs}"/>
	    	<input type="hidden" id="dwid" name="dwid" value="${dwid}"/>
	    	<input type="hidden" id="fwcsid" name="fwcsid" value="${fwcsid}"/>
	    	<input type="hidden" id="fwcs" name="fwcs" value="${fwcs}"/>
	    	<input type="hidden" id="userid" name="userid" value="${userid}"/>
	    	<input type="hidden" id="ywxtgzrwbid" name="ywxtgzrwbid" value="${ywxtgzrwbid}"/>
	    	<input type="hidden" id="messageid" name="messageid" value="${messageid}"/>
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    <input type="hidden" id="pk" name="id" value="${entity.id}" />
			    <input type="hidden" id="fsrdm" name="fsrdm" value="${entity.fsrdm}" />
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">协同任务名称：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly"  readonly="readonly" type="text" id="xxbt" name="xxbt" value="${entity.xxbt}" style="width:200px;" maxlength="50"/></td>
		    		<td width="20%" class="dialogTd" align="right">发起部门：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly"  readonly="readonly"  type="text" id="fsrssdw" name="fsrssdw" value="${entity.fsrssdw}" style="width:200px;" maxlength="40" /></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">协同任务描述：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xxnr" id="xxnr" class="easyui-validatebox inputreadonly"  readonly="readonly"  style="width: 613px; height:48px;" >${entity.xxnr}</textarea></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">发起时间：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly"  readonly="readonly"  type="text" id="fssj" name="fssj" value="${entity.fssj}" style="width:200px;" maxlength="40" /></td>
			    	<td width="20%" class="dialogTd" align="right">发起人：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly"  readonly="readonly" type="text" id="fsr" name="fsr" value="${entity.fsr}" style="width:200px;" maxlength="40" /></td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript">
function doInit(paramArray) {
	var iframeObject = window.top.frames['xtrwclWindow_iframe'];
	if (iframeObject.contentWindow) {
		iframeObject = iframeObject.contentWindow;
	}
	//第一次处理任务窗口隐藏【共存】按钮   iframeObject.$('#flag').val() == '0' || (iframeObject.$('#flag').val() == '1' && 
	if(iframeObject.$('#hslx').val() != '1' || iframeObject.$('#flag').val() == '0'){// 不是第二次处理注销类型任务，没有【共存】操作
		window.top.$('#button_conexist').hide();
	}
}

function beforeSubmit() {
}

function afterSubmit() {
}

function setRead(){
}
</script>
</html>