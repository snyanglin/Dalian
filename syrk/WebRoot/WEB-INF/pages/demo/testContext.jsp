<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body style="margin-top: 20px;">
	
	<table cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td align="left" valign="top">
			地址一：<input style="width:360px;" class="easyui-combobox" id="comboMlph1" value="辽宁省大连市沙河口区拥政街美丽巷9号"
					data-options="mode:'remote',method:'post',panelHeight: 22,
						valueField:'id',textField:'text',selectOnNavigation:false">
			<input style="width:200px;" class="easyui-combobox" id="comboMlphXz1" value="3单元4层4-3"
					data-options="mode:'remote',method:'post',panelHeight: 22,
						valueField:'id',textField:'text',selectOnNavigation:false">
			<input type="button" value="设值" onclick="setSearchValue()"/>
			<input type="button" value="清空" onclick="clearSearch()"/>
		</td>		
		<td>
			动态过滤的派出所代码：<input type="text" name="pcsdm1" id="pcsdm1" value="210204410000"/><br/>
			<br/>
			
			门楼牌号地址ID：<input type="text" name="mlphdm1" id="mlphdm1" value="210204129865"/><br/>
			门楼牌号名称：<input type="text" name="mlphmc1" id="mlphmc1" style="width:300px;" value="辽宁省大连市沙河口区拥政街美丽巷9号"/><br/>
			<br/>
		
			地址表ID：<input type="text" name="dzid1" id="dzid1" value="210204131598"/><br/>
			地址全称：<input type="text" name="dzqc1" id="dzqc1" style="width:300px;" value="辽宁省大连市沙河口区拥政街美丽巷9号3单元4层4-3"/><br/>
			地址分县局代码：<input type="text" name="dzfxjdm1" id="dzfxjdm1" value="210204000000"/><br/>
			地址派出所代码：<input type="text" name="dzpcsdm1" id="dzpcsdm1" value="210204410000"/><br/>
			地址责任区代码：<input type="text" name="dzzrqdm1" id="dzzrqdm1" value="210204411000"/><br/>
			地址行政区划：<input type="text" name="dzxzqh1" id="dzxzqh1" value="210204"/><br/>
			地址街路巷代码：<input type="text" name="dzjlxdm1" id="dzjlxdm1" value="040432"/><br/>
			地址街路巷名称：<input type="text" name="dzjlxmc1" id="dzjlxmc1" value="拥政街美丽巷"/><br/>
		</td>		
	</tr>
	
	<tr><td colspan="2" height="50"></td></tr>

	<tr>
		<td align="left" valign="top">
			地址二：<input style="width:360px;" class="easyui-combobox" id="comboMlph2" 
					data-options="mode:'remote',method:'post',panelHeight: 22,
						valueField:'id',textField:'text',selectOnNavigation:false">
			<input style="width:200px;" class="easyui-combobox" id="comboMlphXz2" 
					data-options="mode:'remote',method:'post',panelHeight: 22,
						valueField:'id',textField:'text',selectOnNavigation:false">
			<input type="button" value="取上面的值" onclick="setOtherValue()"/>
		</td>		
		<td>
			动态过滤的派出所代码：<input type="text" name="pcsdm2" id="pcsdm2"/><br/>
			<br/>
			
			门楼牌号地址ID：<input type="text" name="mlphdm2" id="mlphdm2"/><br/>
			门楼牌号名称：<input type="text" name="mlphmc2" id="mlphmc2" style="width:300px;"/><br/>
			<br/>
		
			地址表ID：<input type="text" name="dzid2" id="dzid2" /><br/>
			地址全称：<input type="text" name="dzqc2" id="dzqc2" style="width:300px;"/><br/>
			地址分县局代码：<input type="text" name="dzfxjdm2" id="dzfxjdm2"/><br/>
			地址派出所代码：<input type="text" name="dzpcsdm2" id="dzpcsdm2"/><br/>
			地址责任区代码：<input type="text" name="dzzrqdm2" id="dzzrqdm2"/><br/>
			地址行政区划：<input type="text" name="dzxzqh2" id="dzxzqh2"/><br/>
			地址街路巷代码：<input type="text" name="dzjlxdm2" id="dzjlxdm2"/><br/>
			地址街路巷名称：<input type="text" name="dzjlxmc2" id="dzjlxmc2"/><br/>
		</td>		
	</tr>

	<tr><td colspan="2" height="50"></td></tr>

	<tr>
		<td align="left" valign="top">
			单位一：<input style="width:570px;" class="easyui-combobox" id="comboDw1" 
					data-options="mode:'remote',method:'post',panelHeight: 22,
						valueField:'id',textField:'text',selectOnNavigation:false">
		</td>		
		<td>
			动态过滤的派出所代码：<input type="text" name="dwpcsdm1" id="dwpcsdm1"/><br/>
			<br/>
			
			单位ID：<input type="text" name="dwid1" id="dwid1" style="width:300px;"/><br/>
			单位名称：<input type="text" name="dwmc1" id="dwmc1" style="width:300px;"/><br/>
			<br/>
			管理部门ID：<input type="text" name="glbmid1" id="glbmid1" /><br/>
			管理派出所ID：<input type="text" name="glpcsid1" id="glpcsid1" style="width:300px;"/><br/>
			管理分县局ID：<input type="text" name="glfxjid1" id="glfxjid1" style="width:300px;"/><br/>
			单位编号：<input type="text" name="dwbh1" id="dwbh1"/><br/>
			单位地址：<input type="text" name="dwdz1" id="dwdz1" style="width:300px;"/><br/>
			注销标志：<input type="text" name="xt_zxbz1" id="xt_zxbz1"/><br/>
		</td>		
	</tr>

</table>

<br/><br/>

<script type="text/javascript">

initAddressSearch('comboMlph1', {pcsdm: '#pcsdm1'}, 'mlphdm1', 'mlphmc1', 'comboMlphXz1', {id:'dzid1',text:'dzqc1',dzfxjdm:'dzfxjdm1',dzpcsdm:'dzpcsdm1',dzzrqdm:'dzzrqdm1',dzxzqh:'dzxzqh1',dzjlxdm:'dzjlxdm1',dzjlxmc:'dzjlxmc1'}, 'onSelectAfterMlph1', 'onSelectAfterMlphXz1');
initAddressSearch('comboMlph2', {pcsdm: '#pcsdm2'}, 'mlphdm2', 'mlphmc2', 'comboMlphXz2', {id:'dzid2',text:'dzqc2',dzfxjdm:'dzfxjdm2',dzpcsdm:'dzpcsdm2',dzzrqdm:'dzzrqdm2',dzxzqh:'dzxzqh2',dzjlxdm:'dzjlxdm2',dzjlxmc:'dzjlxmc2'}, 'onSelectAfterMlph1', 'onSelectAfterMlphXz1');
initDepartmentSearch('comboDw1', {glpcsid: '#dwpcsdm1'}, 'dwid1', 'dwmc1', {glbmid:'glbmid1',glpcsid:'glpcsid1',glfxjid:'glfxjid1',dwbh:'dwbh1',dwdz:'dwdz1',xt_zxbz:'xt_zxbz1'}, 'onSelectAfterDw1');
	
function onSelectAfterMlph1(mlphComboID) {
	alert(mlphComboID);
}

function onSelectAfterMlphXz1(mlphXzComboID) {
	alert(mlphXzComboID);
}

function onSelectAfterDw1(dwComboID) {
	alert(dwComboID);
}

function setSearchValue() {
	$('#comboMlph1').combobox('setValue','asdfasdfasdfasdf');
}

function clearSearch() {
	$('#comboMlph1').combobox('loadData', []);
	var comboText = $('#comboMlph1').next(".combo").children(".combo-text");
	comboText.val("");
	$('#comboMlphXz1').combobox('loadData', []);
	var comboText = $('#comboMlphXz1').next(".combo").children(".combo-text");
	comboText.val("");
	var opts = $('#comboMlphXz1').combobox('options');
	opts.validEnter = false;
	$('#mlphdm1').val("");
	$('#mlphmc1').val("");
	$('#dzid1').val("");
	$('#dzqc1').val("");
	$('#dzfxjdm1').val("");
	$('#dzpcsdm1').val("");
	$('#dzzrqdm1').val("");
	$('#dzxzqh1').val("");
	$('#dzjlxdm1').val("");
	$('#dzjlxmc1').val("");
}

function setOtherValue() {
	$('#comboMlph2').combobox('loadData', []);
	$('#comboMlphXz2').combobox('loadData', []);
	var comboText1 = $('#comboMlph2').next(".combo").children(".combo-text").first();
	comboText1.val($('#comboMlph1').combo('getText'));
	var comboText2 = $('#comboMlphXz2').next(".combo").children(".combo-text").first();
	comboText2.val($('#comboMlphXz1').combo('getText'));
	var opts = $('#comboMlphXz2').combobox('options');
	opts.validEnter = false;
	$('#mlphdm2').val($('#mlphdm1').val());
	$('#mlphmc2').val($('#mlphmc1').val());
	$('#dzid2').val($('#dzid1').val());
	$('#dzqc2').val($('#dzqc1').val());
	$('#dzfxjdm2').val($('#dzfxjdm1').val());
	$('#dzpcsdm2').val($('#dzpcsdm1').val());
	$('#dzzrqdm2').val($('#dzzrqdm1').val());
	$('#dzxzqh2').val($('#dzxzqh1').val());
	$('#dzjlxdm2').val($('#dzjlxdm1').val());
	$('#dzjlxmc2').val($('#dzjlxmc1').val());
}

</script>
  
</body>
</html>