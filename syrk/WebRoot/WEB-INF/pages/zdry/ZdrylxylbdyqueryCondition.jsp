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
		    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdrylxdm" name="zdrylxdm" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_RK_ZDRYLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3"><input type="text" name="zdrylbdm" id="zdrylbdm"  class="easyui-combotree" style="width:613px;"
	    			data-options="url: contextPath + '/common/dict/D_RK_ZDRYLB.js',onlyLeaf:true,dataFilter:'',
	    			multiple:false,required:false,panelWidth:613,method:'get',editable:true,lines:true" >
		    	</td>
	    	</tr>
	    	</table>
	    </div>
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

