<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>其它宠物管理查询</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'其它宠物管理列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/qtcwb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'xt_zhxgsj',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'zjhm',width:25,align:'center',sortable:true,halign:'center'">养宠物人证件号码</th>
				        	 <th data-options="field:'xm',width:25,align:'center',sortable:true,halign:'center'">养宠物人姓名</th>
				        	 <th data-options="field:'dz_jzdzxz',width:40,align:'left',sortable:true,halign:'center'">养宠物人居住地址</th>
				        	 <th data-options="field:'ycwytdm',width:20,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FWQZ_YQYT.js'">养宠物用途</th>
				        	 <th data-options="field:'cwx',width:25,align:'left',sortable:true,halign:'center'">宠物型</th>
				        	 <th data-options="field:'cwz',width:25,align:'left',sortable:true,halign:'center'">宠物种</th>
				           	 <th  data-options="field:'xt_lrrbmid',hidden:true">xt_lrrbmid</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1000">
							<tbody>
							<tr>
									<td class="toolbarTd" style="width:400px">
										养宠物人证件号码：<input type="text" name="zjhm" id ="zjhm" class="easyui-validatebox" data-options="required:false" maxlength="30"
										style="width:160px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:350px">
										   养宠物人姓名：<input type="text" name="xm" id ="xm" class="easyui-validatebox" data-options="required:false" maxlength="20"
										style="width:160px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:300px">
										养宠物人居住地址：<input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" class="easyui-validatebox" data-options="required:false" 
										style="width:160px"  maxlength="100"/>
									</td>
								</tr>
								
								<tr>
									
									<td class="toolbarTd" style="width:400px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;养宠物用途：<input type="text" name="ycwytdm" id ="ycwytdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_YQYT.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'" 
										style="width:160px"  maxlength="1000"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:350px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宠物型：<input type="text" name="cwx" id ="cwx" class="easyui-validatebox" data-options="required:false" 
										style="width:160px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:300px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宠物种：<input type="text" name="cwz" id ="cwz" class="easyui-validatebox" data-options="required:false" 
										style="width:160px"  />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="qtwcbAdd(this);">新增</a>
								
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
var zzjgdmPd = "<%=userOrgCode%>";
function processFormater(val, row, index) { // 自定义操作生成
	if(row.xt_lrrbmid==zzjgdmPd){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
	}else {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCk(this,'+index+')">查看</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
	}
}

function clearCase(){
	  $("#queryForm").form("reset");
}

function qtwcbAdd(obj){
	var hsUrl = "/qtcwb/addQtcwb?";
	hsUrl+="mainTabID="+getMainTabID();
	openTabPage("其它宠物管理新增",hsUrl);
}
// 修改单条
function doCk(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/qtcwb/addQtcwb?id="+rowData.id+"&mainTabID="+getMainTabID();
	openTabPage("其它宠物管理查看",editUrl);
	
}
	// 修改单条
	function doEdit(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = "/qtcwb/addQtcwb?id="+rowData.id+"&mainTabID="+getMainTabID();
		openTabPage("其它宠物管理编辑",editUrl);
		
	}
	//查询按钮
	function queryButton() {
		var zjhm = document.getElementById("zjhm").value;
		var xm = document.getElementById("xm").value;
		var dz_jzdzxz = document.getElementById("dz_jzdzxz").value;
		var ycwytdm = document.getElementById("ycwytdm").value;
		var cwx = document.getElementById("cwx").value;
		var cwz = document.getElementById("cwz").value;
		$('#dg').datagrid('reload', {
			'zjhm' : zjhm,
			'xm' : xm,
			'dz_jzdzxz' : dz_jzdzxz,
			'ycwytdm' : ycwytdm,
			'cwx' : cwx,
			'cwz' : cwz
		});
	}
	//注销单条
	function doDelete(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/qtcwb/delete';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
		topMessager.confirm('', '您确认要注销数据吗？', function(r) {
			if (r) {
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				var postFieldArray = [];
				postFieldArray.push(opts.idField);
				if (submitFields != "") {
					postFieldArray = postFieldArray.concat(submitFields
							.split(","));
				}
				var postData = {};
				for ( var i = 0; i < postFieldArray.length; i++) {
					var postField = postFieldArray[i];
					if (rowData[postField]) {
						postData[postField] = rowData[postField];
					}
				}
				$.ajax( {
					url : deleteUrl,
					type : 'POST',
					data : postData
				}).done( function(result) {
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
	}
	function loadData(){
		
	}
	//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
		var zjhm = document.getElementById("zjhm").value;
		var xm = document.getElementById("xm").value;
		var dz_jzdzxz = document.getElementById("dz_jzdzxz").value;
		var ycwytdm = document.getElementById("ycwytdm").value;
		var cwx = document.getElementById("cwx").value;
		var cwz = document.getElementById("cwz").value;
		var reloadUrl = contextPath + '/qtcwb/queryList';
		var opt = $('#dg').datagrid('options');
		opt.url = reloadUrl;
		$('#dg').datagrid('reload', {
			'zjhm' : zjhm,
			'xm' : xm,
			'dz_jzdzxz' : dz_jzdzxz,
			'ycwytdm' : ycwytdm,
			'cwx' : cwx,
			'cwz' : cwz
		});
}


function openTabPage(menuName, openURL) {
	menu_open(menuName, openURL);
	window.parent.$('#' + windowID).window('close');
}
function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
</script>  

</html>
