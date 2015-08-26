<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>单位处罚信息查询</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'单位处罚信息查询',border:true" style="height:auto">
            	<input type="hidden" id="mode" value="select">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dwcfxxb/queryList',
            		toolbar:'#datagridToolbar',queryParams:{dwid:'${dwid}'},
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'a.xt_zhxgsj',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	<th data-options="field:'ajbh',width:25,align:'center',sortable:true,halign:'center'">案件编号</th>
				        	<th data-options="field:'xzcfjdszh',width:25,align:'center',sortable:true,halign:'center'">行政处罚决定书字号</th>
				        	<th data-options="field:'cflxdm',width:25,align:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_CFLX.js',halign:'center'">处罚类型</th>
				        	<th data-options="field:'cfrq',width:15,align:'center',sortable:true,halign:'center'">处罚日期</th>
				        	<th data-options="field:'jbdw',width:30,align:'left',sortable:true,halign:'center'">经办单位</th>
				        	<th data-options="field:'jbr',width:40,align:'left',sortable:true,halign:'center'">经办人</th>
				        	<th data-options="field:'cfqk',width:40,align:'left',sortable:true,halign:'center'">处罚情况</th>
				        	<th data-options="field:'cfjg',width:40,align:'left',sortable:true,halign:'center'">处罚结果</th>
				        	<th data-options="field:'bz',width:40,align:'left',sortable:true,halign:'center'">备注</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="5" cellpadding="0" border="0" width="100%">
							<tbody>
								<tr id="tr1">
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right">单位名称：</td>
									<td class="toolbarTd" style="width:40%;">
										<input type="text" name="dwmc" id ="dwmc" class="easyui-validatebox" data-options="required:false,tipPosition:'right'" maxlength="50"
										style="width:305px"  />
									</td>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right"> 单位类型：</td>
									<td class="toolbarTd" style="width:40%;">
										<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
										style="width:222px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
										method:'get',editable:true,lines:true"/>
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:10%;" align="right">处罚日期：</td>
									<td class="toolbarTd" style="width:40%;">
										<input type="text" name="cfrq" id="cfrq" class="easyui-validatebox " style="width:140px;"
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'cfrqz\') }'})" />
										至
										<input type="text" name="cfrqz" id="cfrqz" class="easyui-validatebox " style="width:140px;"
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'cfrq\') }'})" />
									</td>
									<td class="toolbarTd" style="width:10%;" align="right">处罚类型：</td>
									<td class="toolbarTd" style="width:40%;">
										<input class="easyui-combobox" type="text" name="cflxdm" id="cflxdm" style="width:222px"
										data-options="url: contextPath + '/common/dict/D_DW_CFLX.js',valueField:'id',textField:'text',dataFilter:'202|208|209|210|212|213|217|315|316|317|318|319|320|321|SFJY|108',selectOnNavigation:false,method:'get',tipPosition:'right'" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:10%;" align="right">案件编号：</td>
									<td class="toolbarTd" style="width:40%;">
										<input type="text" name="ajbh" id ="ajbh" class="easyui-validatebox" data-options="required:false,tipPosition:'right'" maxlength="50"
										style="width:305px"  />
									</td>
									<td class="toolbarTd" style="width:10%;"></td>
									<td class="toolbarTd" style="width:40%;">
										<span style="width: 76px;"></span>
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView('+index+')">查看</a>&nbsp;';
}

/*
 * 查看处罚检查
 * index 行索引 
 */
function doView(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dwcfxxb/edit?id="+rowData.id;
	window.top.openWindowNoSave(false, null, window, 
   		{dwmc:rowData.dwmc,mode:"view"}, 
   		{
   		title: '单位处罚信息',
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, null,null
   	);
}

//查询按钮
function queryButton(){
	var dwlbdm = $("#dwlbdm").combotree("getValue");
	var dwmc = $("#dwmc").val();
	var cfrq = $("#cfrq").val();
	var cfrqz = $("#cfrqz").val();
	var cflxdm = $("#cflxdm").combobox("getValue");
	var ajbh = $("#ajbh").val();
	$('#dg').datagrid('load',{'dwlbdm':dwlbdm,'dwmc':dwmc,'cfrq':cfrq,'cfrqz':cfrqz,'cflxdm':cflxdm,'ajbh':ajbh});
}

function clearCase(){
	  var dwmc="${dwmc}";
	  if(dwmc==""||dwmc==null){
	  	 $("#dwlbdm").combotree("setValue","");
	 	 $("#dwmc").val("");
	  }
	  $("#cfrq").val("");
	  $("#cfrqz").val("");
	  $("#cflxdm").combobox("setValue","");
	  $("#ajbh").val("");
};

$(function(){
	var dwmc="${dwmc}";
	var dwlbdm="${dwlbdm}";
	if(dwmc!=""&&dwmc!=null){
		$("#dwmc").val(decodeURI(dwmc));
		$("#dwlbdm").combotree("setValue",dwlbdm);
		$("#tr1").find('input[type="text"]').each(function(i,o){
			$(o).attr('readonly','readonly');
			$(o).addClass('inputReadonly');
			$(o).next(".combo").addClass("inputReadonly");
		});
		$("#mode").val("");
	}
});
</script>  

</html>
