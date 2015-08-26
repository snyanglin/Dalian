<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位检查项新增</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwjctemp/addMultDwjcdata" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="typeid" value="${typeid}">
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="620" align="center" id="lmtextTable">
		    	<tr class="dialogTr">
			    	<td width="70%" class="dialogTd" align="left">检查项内容：</td>
			    	<td width="25%" class="dialogTd" align="left">默认值</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="70%" class="dialogTd" align="left">
			    		<input class="easyui-validatebox" type="text" name="names" style="width: 403px;" maxlength="200" data-options="required:true"/>
					</td>
			    	<td width="25%" class="dialogTd"  align="left">
			    		<input class="easyui-combobox" type="text"  name="defs" style="width:100px;" 
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    		<a class="addLine_btn" href="javascript:void(0);" onclick="addLmtext();" title="增加一个类目内容"></a>
			    	</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}

var lmtextCount = 0;
function addLmtext(){
	var tr1 = $('<tr id="lmtext2Tr'+ lmtextCount +'" class="dialogTr"></tr>');
	var td1 = $('<td width="70%" id="lmtextTd1'+ lmtextCount +'" class="dialogTd" align="left"></td>');
	var td3 = $('<td width="25%" id="lmtextTd2'+ lmtextCount +'" class="dialogTd"  align="left"></td>');
	var td1HTML = new StringBuffer();
	td1HTML.append('<input class="easyui-validatebox" type="text" name="names" id="lmtext1_'+ lmtextCount +'" style="width: 403px;" maxlength="200" data-options="required:true"/>');
	td1.html(td1HTML.toString());
	var td3HTML = new StringBuffer();
	td3HTML.append('<input class="easyui-combobox" type="text" name="defs" id="lmtext2_'+ lmtextCount +'" style="width:100px;"'
				  +'data-options="url: contextPath + \'/common/dict/D_GG_SF.js\',valueField:\'id\',textField:\'text\',selectOnNavigation:false,required:false,method:\'get\'"/>');
	td3HTML.append('&nbsp;<a class="delLine_btn" href="javascript:void(0);" onclick="delLmtext('+ lmtextCount +')" title="注销当前类目 "></a>');
	td3.html(td3HTML.toString());
	tr1.append(td1);
	tr1.append(td3);
	$('#lmtextTable').append(tr1);
	$.parser.parse('#lmtextTd1' + lmtextCount);
	$.parser.parse('#lmtextTd2' + lmtextCount);
	lmtextCount++;
}
function delLmtext(num){
	$("#lmtext2Tr" + num).remove();
	$("#lmtext1_" + num).remove();
	$("#lmtext2_" + num).remove();
}
</script>

</body>
</html>