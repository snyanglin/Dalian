<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<title>消防单位抽样参数配置</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>cyjh/saveXfdwcccsxxb" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
	    	<input type="hidden" name="id" value="${entity.id}" id="id"/>
	    	<input type="hidden" name="nf" value="${entity.nf}" id="nf"/>
			<table border="1"  width="100%" align="center" style="border-collapse: collapse;">
	    	<tr class="dialogTr">
		    	<td width="27%" class="dialogTd" align="right" bgcolor="#eaf2ff">专职监督检查人员数：</td>
		    	<td width="23%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" name="zzjcrs" value="${entity.zzjcrs}" style="width:150px;" maxlength="40" data-options="required:true,validType:['numericRange[\'f\',0,0,10]'],tipPosition:'right'"/>
		    	</td>
		    	<td width="22%" class="dialogTd" align="right" bgcolor="#eaf2ff">兼职监督检查人员数：</td>
		    	<td width="28%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="jzjcrs" name="jzjcrs" value="${entity.jzjcrs}" style="width:150px;" data-options="required:true,validType:['numericRange[\'f\',0,0,10]'],tipPosition:'left'"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="27%" class="dialogTd" align="right" bgcolor="#eaf2ff">重点单位占抽查单位的百分比：</td>
		    	<td width="73%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" name="zddwzccdwdbfb" value="${entity.zddwzccdwdbfb}" style="width: 150px;" maxlength="100" data-options="required:true,validType:['numericRange[\'f\',0,0,100]'],tipPosition:'right'"/>&nbsp;%
		    	</td>
	    	</tr>
	    	<tr class="dialogTr" height="28px">
		    	<td width="27%" class="dialogTd" align="right" bgcolor="#eaf2ff">本辖区现已录入单位数：</td>
		    	<td width="73%" class="dialogTd" colspan="3">
		    		总数<font color="red" id="zs"></font>家,重点<font color="red" id="zddws"></font>家,非重点<font color="red" id="fzddws"></font>家。
		    	</td>
	    	</tr>
	    	</table>
	    	<div style="line-height: 1.5em;">
	    	　 <font style="color: red;">注：</font>根据填写的抽样参数计算本年度应该抽查的单位数，此计算的抽查单位数只提供参考；而实际要抽查单位数，根据每次抽查所需抽查的单位数。
	    	</div>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	$("#nf").val(paramArray["nf"]);
	$("#zs").html(paramArray["zs"]);
	$("#zddws").html(paramArray["zddws"]);
	$("#fzddws").html(paramArray["fzddws"]);
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
	parent.$("#dg").datagrid("reload");
	parent.$("#nf").combobox("reload",contextPath + "/cyjh/querynf");
}
</script>

</body>
</html>