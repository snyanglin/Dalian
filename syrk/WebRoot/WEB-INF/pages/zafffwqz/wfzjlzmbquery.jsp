<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>无犯罪记录证明</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'无犯罪记录证明',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/wfzjlzmb/queryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'id',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'zmjsdw',width:25,align:'left',sortable:true,halign:'center'">证明接收单位</th>
				        	 <th data-options="field:'gmsfhm',width:25,align:'left',sortable:true,halign:'center'">证明人身份证号</th>
				        	 <th data-options="field:'xm',width:25,align:'left',sortable:true,halign:'center'">证明人姓名</th>
				        	 <th data-options="field:'dz_jzdzxz',width:25,align:'left',sortable:true,halign:'center'">证明人居住地址</th>
				        	 <th data-options="field:'kjrq',width:25,align:'left',sortable:true,halign:'center'">开具日期</th>
				        	  <th data-options="field:'zmkjr',width:25,align:'left',sortable:true,halign:'center'">开具人</th>
				        	  <th data-options="field:'zmkjdw',width:25,align:'left',sortable:true,halign:'center'">开具单位</th>
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
									<td class="toolbarTd" style="width:280px">
										证明人身份证号：<input type="text" name="gmsfhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[18]',validType:['sfzh']"  
										style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:260px">
										    证明人姓名：<input type="text" name="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  
										    style="width:160px" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										    证明人性别：<input type="text" name="xbdm" id ="xbdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"
										style="width:160px"  />
									</td>
								</tr>
								
								<tr>
									<td class="toolbarTd" style="width:280px"  >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开具日期：
										<input type="text" name="startime" id="startime" class="easyui-validatebox " style="width:160px;" 
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endtime\') }'})" /></td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:260px"  >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至
										<input type="text" name="endtime" id="endtime" class="easyui-validatebox " style="width: 160px" 
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startime\') }'})" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="right" >
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add" onclick="addButton(this);" >新增</a>
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
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
}

function clearCase(){
	  $("#queryForm").form("reset");
}
// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
   	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/wfzjlzmb/addWfzjlzmb?id="+rowData.id+"&mainTabID="+getMainTabID();
	openTabPage("无犯罪记录证明编辑－" + rowData.xm,editUrl);
}
//查询按钮
function queryButton(){
  	var gmsfhm = document.getElementById("gmsfhm").value;
  	var xm = document.getElementById("xm").value;
  	var xbdm = document.getElementById("xbdm").value;
  	var startime = document.getElementById("startime").value;
  	var endtime = document.getElementById("endtime").value;
  	$('#dg').datagrid(
  			'reload',
  			{    
  				'gmsfhm':gmsfhm,
  				'xm': xm,   
  				'xbdm': xbdm ,
  				'startime':startime,
  				'endtime':endtime
  			});
  }
 //注销单条
  function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/wfzjlzmb/removeWfzjlzmb';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
		topMessager.confirm('','您确认要注销数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				var postFieldArray = [];
				postFieldArray.push(opts.idField);
				if (submitFields != "") {
					postFieldArray = postFieldArray.concat(submitFields.split(","));
				}
				var postData = {};
				for (var i = 0; i < postFieldArray.length; i++) {
					var postField = postFieldArray[i];
					if (rowData[postField]) {
						postData[postField] = rowData[postField];
					}
				}
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: postData
				}).done(function(result) {
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
  }
  //新增/查看
  function addButton(obj){
	var hsUrl = "/wfzjlzmb/addWfzjlzmb?";
	hsUrl+="mainTabID="+getMainTabID();
	openTabPage("无犯罪记录证明新增",hsUrl);
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
