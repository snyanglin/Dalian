<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>本人检查任务列表</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'本人检查任务',border:true" style="height:auto">
            	<input type="hidden" id="mode" value="select">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/cyjh/queryDwcyjcrwxxbForPage',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'T3.xt_cjsj',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	<th data-options="field:'dwbm',width:25,align:'center',sortable:true,halign:'center'">单位编码</th>
				        	<th data-options="field:'dwmc',width:35,align:'center',sortable:true,halign:'center'">单位名称</th>
				        	<th data-options="field:'jgdwlb',width:30,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWXFLB.js'">类别</th>
				        	<th data-options="field:'dwdzxz',width:40,align:'center',sortable:true,halign:'center'">地址</th>
				        	<th data-options="field:'xfgx',width:40,align:'center',sortable:true,halign:'center'">管辖单位</th>
				        	<th data-options="field:'ccsjks',width:40,align:'center',halign:'center',formatter:sssjfwFormater">实施时间范围</th>
				            <th data-options="field:'process',align:'center',align:'center',formatter:processFormater">操作</th>
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
									<td class="toolbarTd" style="width:25%;">
										<input type="text" name="dwmc" id ="dwmc" class="easyui-validatebox" data-options="required:false,tipPosition:'right'" maxlength="50"
										style="width:200px;"/>
									</td>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right"> 类别：</td>
									<td class="toolbarTd" style="width:25%;">
										<input class="easyui-combotree" type="text" id="jgdwlb" name="jgdwlb"
										style="width:222px;" data-options="url: contextPath + '/common/dict/BD_D_DWXFLB.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
										method:'get',editable:true,lines:true"/>
									</td>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right">地址：</td>
									<td class="toolbarTd" style="width:25%;">
										<input type="text" name="dwdzxz" id ="dwdzxz" class="easyui-validatebox" data-options="required:false,tipPosition:'right'" maxlength="50"
										style="width:200px;"/>
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:100%;" colspan="6" align="right">
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<span style="width:3px;">&nbsp;</span>
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
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doView(\''+row.dwid+'\')">详情</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="addRcjc(\''+row.dwmc+'\',\''+row.dwid+'\',\''+row.dwlbdm+'\',\''+row.id+'\')">检查</a>';
}

function sssjfwFormater(val, row, index){
	return row.ccsjks+"&nbsp;至&nbsp;"+row.ccsjjs;
}

function addRcjc(dwmc,dwid,dwlbdm,rwid) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = basePath+"dwjcxxb/selCheckTemp?dwid="+dwid+"&dwlbdm="+dwlbdm+"&rwid="+rwid+"&mainTabID="+getMainTabID();
	openWindowWithSave(false, null, window, 
   		{mode:"select",dwmc:dwmc,dwlbdm:dwlbdm}, 
   		{
   		title: '单位检查信息',
   		url: editUrl,
   		width: 880,
   		height:500
   		}, 
   		null, null,null
   	);
}
//查询按钮
function queryButton(){
	var jgdwlb = $("#jgdwlb").combotree("getValue");
	var dwmc = $("#dwmc").val();
	var dwdzxz = $("#dwdzxz").val();
	$('#dg').datagrid('load',{'jgdwlb':jgdwlb,'dwmc':dwmc,'dwdzxz':dwdzxz});
}

function clearCase(){
	$("#jgdwlb").combotree("setValue","");
	$("#dwmc").val("");
	$("#dwdzxz").val("");
};

// 修改单条
function doView(dwid) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = "/sydwgl/view?id="+dwid+"&mode=view";
	menu_open("实有单位详情",editUrl);
}
</script>  

</html>
