<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwjctemp/updateDwjctype" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    		<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">单位类别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="hidden" id="ywlbdm" name="ywlbdm" value="${entity.ywlbdm}"/>
			    		<input type="hidden" id="sydwlx" name="sydwlx" value="${entity.sydwlx}"/>
			    		<input class="easyui-combotree" type="text" id="sydwlx-box" name="sydwlx-box" style="width:200px;" value="${entity.sydwlx}_${entity.ywlbdm}"
						data-options="required:true,url: contextPath + '/common/dict/BD_D_MDWLXDM.js',onlyLeaf:true,multiple:false,required:true,panelWidth:250,panelHeight:215,
						method:'get',editable:true,lines:true,onSelect:function(record){$('#ywlbdm').val(record.py);var sydwlx = record.id.replace('_'+record.py,'');$('#sydwlx').val(sydwlx);}"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">类目内容：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<input class="easyui-validatebox" type="text" name="name" value="${entity.name}" style="width: 503px;" maxlength="200" data-options="required:true"/>
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
</script>

</body>
</html>