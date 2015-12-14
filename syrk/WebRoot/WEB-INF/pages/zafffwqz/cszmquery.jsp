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

<title>出生证明查询</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'出生证明列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/cszmb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'xt_zhxgsj',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'zmjsdw',width:25,align:'left',sortable:true,halign:'center'">证明接收单位</th>
				        	 <th data-options="field:'gmsfhm',width:25,align:'left',sortable:true,halign:'center'">证明人身份证号</th>
				        	 <th data-options="field:'xm',width:15,align:'left',sortable:true,halign:'center'">证明人姓名</th>
				        	 <th data-options="field:'dz_jzdzxz',width:45,align:'left',sortable:true,halign:'center'">证明人居住地址</th>
				        	 <th data-options="field:'sfxm',width:25,align:'left',sortable:true,halign:'center'">证明人生父</th>
				        	 <th data-options="field:'smxm',width:25,align:'left',sortable:true,halign:'center'">证明人生母</th>
				        	 <th data-options="field:'kjrq',width:20,align:'left',sortable:true,halign:'center'">开具日期</th>
				        	  <th data-options="field:'zmkjr',width:25,align:'left',sortable:true,halign:'center'">开具人</th>
				        	  <th data-options="field:'zmkjdw',width:25,align:'left',sortable:true,halign:'center'">开具单位</th>
				        	  <th  data-options="field:'xt_lrrbmid',hidden:true">xt_lrrbmid</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1100">
							<tbody>
							<tr>
									<td class="toolbarTd" style="width:280px">
										证明人身份证号：<input type="text" name="gmsfhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[18]',validType:['sfzh']"  
										style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										    证明人姓名：<input type="text" name="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  
										    style="width:160px" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										证明人生父：<input type="text" name="sfxm" id ="sfxm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" 
										style="width:160px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									
								</tr>
								<tr>
									<td class="toolbarTd" style="width:280px">
										&nbsp;&nbsp;&nbsp;&nbsp;证明人生母：<input class="easyui-validatebox" type="text" id="smxm" name="smxm"
													data-options="required:false,validType:'maxLength[20]'" 
													style="width:160px"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:260px">
										开具日期：&nbsp;
										<input type="text" name="startime" id="startime" class="easyui-validatebox " style="width:160px;" value="${entity.startime}"
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endtime\') }'})" /></td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">	
										至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="text" name="endtime" id="endtime" class="easyui-validatebox " style="width: 160px" value="${entity.endtime}"
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startime\') }'})" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="right" >
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="cszmAdd(this);">新增</a>
								
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

function cszmAdd(obj){
	var hsUrl = "/cszmb/addCszmb?";
	hsUrl+="mainTabID="+getMainTabID();
	openTabPage("出生证明新增",hsUrl);
		
}
	// 修改单条
	function doCk(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = "/cszmb/addCszmb?id="+rowData.id+"&mainTabID="+getMainTabID();
		openTabPage("出生证明查看－" + rowData.xm,editUrl);
	}
	function doEdit(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = "/cszmb/addCszmb?id="+rowData.id+"&mainTabID="+getMainTabID();
		openTabPage("出生证明编辑－" + rowData.xm,editUrl);
	}
	//查询按钮
	function queryButton() {
		var gmsfhm = document.getElementById("gmsfhm").value;
		var xm = document.getElementById("xm").value;
		var sfxm = document.getElementById("sfxm").value;
		var smxm = document.getElementById("smxm").value;
		var startime = document.getElementById("startime").value;
		var endtime = document.getElementById("endtime").value;
		$('#dg').datagrid('reload', {
			'gmsfhm' : gmsfhm,
			'xm' : xm,
			'sfxm' : sfxm,
			'smxm' : smxm,
			'startime' : startime,
			'endtime' : endtime
		});
	}
	//注销单条
	function doDelete(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/cszmb/delete';
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
