<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>类目管理新增</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwjctemp/addMultDwjctype" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center" id="lmtextTable">
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">单位类别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="hidden" id="ywlbdm" name="ywlbdm"/>
			    		<input type="hidden" id="sydwlx" name="sydwlx"/>
			    		<input class="easyui-combotree" type="text" id="sydwlx-box" name="sydwlx-box" style="width:200px;"
						data-options="required:true,url: contextPath + '/common/dict/BD_D_MDWLXDM.js',onlyLeaf:true,multiple:false,required:true,panelWidth:250,panelHeight:215,
						method:'get',editable:true,lines:true,onSelect:function(record){$('#ywlbdm').val(record.py);var sydwlx = record.id.replace('_'+record.py,'');$('#sydwlx').val(sydwlx);}"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">类目内容：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<input class="easyui-validatebox" type="text" name="names" style="width: 503px;" maxlength="200" data-options="required:true"/>
			    		<a class="addLine_btn" href="javascript:void(0);" onclick="addLmtext();" title="增加一个类目内容"></a>
			    	</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	$("#ywlbdm").val(paramArray["ywlbdm"]);
	$("#sydwlx").val(paramArray["sydwlx"]);
	if(paramArray["ywlbdm"]){
		$("#sydwlx-box").combotree("setValue",paramArray["sydwlx"]+"_"+paramArray["ywlbdm"]);
	}
	
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}

var lmtextCount = 0;
function addLmtext(){
	var tr1 = $('<tr id="lmtext2Tr'+ lmtextCount +'" class="dialogTr"></tr>');
	var td1 = $('<td width="20%" class="dialogTd" align="right">类目内容：</td>');
	var td3 = $('<td width="80%" id="lmtextTd'+ lmtextCount +'" colspan="3" class="dialogTd"></td>');
	var td3HTML = new StringBuffer();
	td3HTML.append('<input class="easyui-validatebox" type="text" name="names" id="lmtext1_'+ lmtextCount +'" style="width: 503px;" maxlength="200" data-options="required:true"/>');
	td3HTML.append('&nbsp;<a class="delLine_btn" href="javascript:void(0);" onclick="delLmtext('+ lmtextCount +')" title="注销当前类目 "></a>');
	td3.html(td3HTML.toString());
	tr1.append(td1);
	tr1.append(td3);
	$('#lmtextTable').append(tr1);
	$.parser.parse('#lmtextTd' + lmtextCount);
	lmtextCount++;
}
function delLmtext(num){
	$("#lmtext2Tr" + num).remove();
	$("#lmtext1_" + num).remove();
}
</script>

</body>
</html>