<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body> 
<div class="easyui-layout" data-options="fit:true">
    <form action="" id="queryForm" name="queryForm" method="post">
	    <div data-options="region:'center',split:true" style="padding: 6px; border-width: 0px;">
	      <table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="15%" class="dialogTd" align="right">发送时间开始：</td>
		    	<td width="35%" class="dialogTd"><input type="text" name="fssj" id="fssj" class="easyui-validatebox" style="width: 200px;" 
					data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cksj\') || \'%y-%M-%d %H:%m:%s\'}'})"/></td>
		    	<td width="15%" class="dialogTd" align="right">发送时间截止：</td>
		    	<td width="35%" class="dialogTd"><input type="text" name="cksj" id="cksj" class="easyui-validatebox" style="width: 200px;" 
					data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'fssj\')}'})"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="15%" class="dialogTd" align="right">消息标题：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xxbt" name="xxbt" style="width:200px;" />（模糊）</td>
		    	<td width="15%" class="dialogTd" align="right">消息内容：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xxnr" name="xxnr" style="width:200px;" />（模糊）</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="15%" class="dialogTd" align="right">发送人：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-validatebox" type="text" id="fsr" name="fsr" style="width:200px;" />（模糊）</td>
		    	<td width="15%" class="dialogTd" align="right">是否查看：</td>
	    		<td width="35%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfck" name="sfck" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	      </table>
    </form>
</div>
<script type="text/javascript">
function doInit(paramArray) {
}

function beforeSubmit() {
}
</script>

</body>
</html>
