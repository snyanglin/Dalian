<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<title>重点人员核实列表</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'重点人员核实列表',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/zdryHsb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		fitColumns:true,
            		idField:'id',pageSize:getAutoPageSize(150),
            		pageList:[getAutoPageSize(150),getAutoPageSize(150) * 2]">
				    <thead>
				        <tr>
				        	<th data-options="field:'xm',width:70,align:'center',sortable:true,halign:'center'">姓名</th>
				        	<th data-options="field:'zjhm',width:180,align:'center',sortable:true,halign:'center'">身份证号码</th>
				            <th data-options="field:'xbdm',width:60,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'">性别</th>
				        	<th data-options="field:'dz_jzdzxz',width:400,align:'left',sortable:true,halign:'center'">现居住地址</th>
				        	<th data-options="field:'dz_hjdzxz',width:400,align:'left',sortable:true,halign:'center'">户籍地址</th>
				        	<th data-options="field:'xfbmdm',width:70,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYHSBXFBM.js'">下发部门</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:50px;width:100%" align="center">
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="4" cellpadding="4" border="0" width="1000">
							<tbody>
								<tr>
									<td class="toolbarTd" style="width:240px">
										 姓名：<input type="text" name="xm" class="easyui-validatebox"   
										    style="width:160px" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										  证件号码：<input type="text" name="zjhm" id="zjhm" class="easyui-validatebox" 
										style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="left" >
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
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
var windowID = null;
function doInit(paramArray) {
	windowID = paramArray['windowID'];
}

function processFormater(val, row, index) { // 自定义操作生成
	var zjhm = row.zjhm;
	
	var hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="syrkAdd(\''+row['zjhm']+'\')">新增实有人口</a>&nbsp;';
	if(row.syrkid){
		hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+')">核实列管</a>&nbsp;'
	}
	
	var xfbmdm = row.xfbmdm;
	if(xfbmdm == '0'){
	//下发部门代码为0，治安下发。
		//+'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHscg(this,'+index+')">核实撤管</a>&nbsp;'+
		//	 	'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHszd(this,'+index+')">转递</a>&nbsp;';
	}
	
	return hsButton;
}

function clearCase(){
	  $("#queryForm").form("reset");
}

function syrkAdd(zjhm){
	menu_open('实有人口新增', '/syrkGl/add?mainTabID='+getMainTabID()+'&cyzjdm=111&zjhm='+zjhm+'&invokeJSMethod=queryButton');
}
	

//核实列管
function doHslg(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = contextPath+"/zdryLcg/createLcg/1?syrkid="+rowData.syrkid+"&ryid="+rowData.ryid+"&zdrygllxdm="+rowData.zdrygllxdm+"&zdryHsbId="+rowData.id;
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	openTabPage('重点人员核实列管', editUrl,datagrid_ID)
}

//核实撤管
function doHscg(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = contextPath+"/zdryHsb/createHsCg?syrkid="+rowData.syrkid+"&ryid="+rowData.ryid+"&zdrygllxdm="+rowData.zdrygllxdm+"&zdryHsbId="+rowData.id;
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	openTabPage('重点人员核实撤管', editUrl,datagrid_ID)
}



//查询按钮
function queryButton() {
	var zjhm = document.getElementById("zjhm").value;
	var xm = document.getElementById("xm").value;
	$('#dg').datagrid('reload', {
		'zjhm' : zjhm,
		'xm' : xm
	});
}

function openTabPage(menuName, openURL,datagrid_ID) {
	datagridEdit(datagrid_ID, 'editWindow', 
	   		null,
	  		{
	   		title: menuName,
	   		url: openURL,
	   		width: 880,
	   		height: 420
	   		},
	   		''
	   	);
	
	
}
function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}

// 核实转递
function doHszd(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = contextPath+"/zdryHsb/hszd?id="+rowData.id;
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	openTabPage('重点人员核实转递', editUrl,datagrid_ID)
	
}

</script>  

</html>

