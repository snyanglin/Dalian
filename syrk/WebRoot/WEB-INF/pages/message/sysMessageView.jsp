<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sysMessage/viewNext" id="dataform" name="dataform" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    <input type="hidden" name="id" value="${entity.id}" />
			    <input type="hidden" name="prevID" id="prevID" value="${prevID}"/>
			    <input type="hidden" name="nextID" id="nextID" value="${nextID}"/>
			    <input type="hidden" name="direction" id="direction"/>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">消息类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xxlb" name="xxlb" style="width:200px;" maxlength="40"/></td>
		    	<td width="20%" class="dialogTd" align="right">消息发送时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="fssj" id="fssj" class="easyui-validatebox inputreadonly" value="${entity.fssj}"  style="width:200px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">发送人单位：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="fsrssdw" name="fsrssdw" value="${entity.fsrssdw}" style="width:200px;" maxlength="40" /></td>
		    	<td width="20%" class="dialogTd" align="right">发送人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="fsr" name="fsr" value="${entity.fsr}" style="width:200px;" maxlength="40" /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">接收人单位：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jsrssdw" name="jsrssdw" value="${entity.jsrssdw}" style="width:200px;" maxlength="40" /></td>
		    	<td width="20%" class="dialogTd" align="right">接收人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jsr" name="jsr" value="${entity.jsr}" style="width:200px;" maxlength="40" /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">是否已查看：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="sfck" name="sfck" style="width:200px;" maxlength="40" data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		    	<td width="20%" class="dialogTd" align="right">查看时间：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox " type="text" id="cksj" name="cksj" value="${entity.cksj}" style="width:200px;" maxlength="40" /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">消息内容：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xxnr" id="xxnr" class="easyui-validatebox " style="width: 613px; height:86px;overflow: auto;" >${entity.xxnr}</textarea></td>
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
   $('#xxlb').val(window.top.getDictName(contextPath + '/common/dict/D_SYS_XXLB.js', "${entity.xxlb}"));
   $('#sfck').val(window.top.getDictName(contextPath + '/common/dict/D_BZ_SF.js', "${entity.sfck}"));
   setInputReadonly("xxlb", true);
   setInputReadonly("sfck", true);
   setInputReadonly("xxnr", true);
   setInputReadonly("fssj", true);
   setInputReadonly("fsrssdw", true);
   setInputReadonly("fsr", true);
   setInputReadonly("jsrssdw", true);
   setInputReadonly("jsr", true);
   setInputReadonly("cksj", true);
}

function viewPrev() {
   var prevIDvalue = document.forms["dataform"].elements["prevID"].value;
   if(0 == prevIDvalue){
     topMessagerAlert(null,"已到第一条!","info");
      return;
   }else{
      document.forms["dataform"].elements["direction"].value = "prev";
      document.forms["dataform"].submit();
   }
}

function viewNext() {
  var nextIDvalue = document.forms["dataform"].elements["nextID"].value;
   if(0 == nextIDvalue){
	   topMessagerAlert(null,"已到最后一条!","info");
	   return;
   }else{
       document.forms["dataform"].elements["direction"].value = "next";
	   document.forms["dataform"].submit();
   }
}
</script>