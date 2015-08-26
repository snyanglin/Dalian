<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人防信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'人防信息',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>rfxx/queryRf',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2]">
							    <thead>
							        <tr>
							       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
							            <th data-options="field:'ffzzxsdm',	width:10,	align:'center' ,sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_ZAFF_ZZXS.js'">组织形式</th>
							            <th data-options="field:'ffzrrcyzjdm', 	width:10,	align:'center' ,	halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_CYZJ.js'">证件种类</th>
							            <th data-options="field:'ffzrrzjhm', 	width:20,	align:'center',	halign:'center',sortable:true">证件号码</th>
							            <th data-options="field:'ffzrrxm', 	width:10,	align:'center',	halign:'center'	,sortable:true">姓名</th>
							           	<th data-options="field:'dz_ffzrrjzdzxz', width:25,	align:'left',	halign:'center',sortable:true,formatter:subjzdz">负责人居住地址</th>
							            <th data-options="field:'ffzzmc', width:15,	align:'left',	halign:'center',sortable:true">组织名称</th>
							            <th data-options="field:'ffzzlb', 	width:8,	align:'center' ,	halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_ORG_ORGTYPE.js'">组织类别</th>
							            <th data-options="field:'dz_ffzrrssdwdzxz', width:25,	align:'left',	halign:'center',sortable:true,formatter:subjzdz">组织地址</th>
							            <th  data-options="field:'xt_lrrbmid',hidden:true">xt_lrrbmid</th>
							            <th data-options="field:'process',	 width:10,align:'center',	halign:'center',	formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:auto" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" >
							<tbody>
							<tr>
									<td class="toolbarTd" style="width:220px">
										组织形式：<input class="easyui-combobox" type="text" id="ffzzxsdm" name="ffzzxsdm" 
												data-options="url: contextPath + '/common/dict/D_ZAFF_ZZXS.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" 
												style="width:160px"/>
									</td>
									
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										负责人姓名：<input type="text" name="ffzrrxm" id="ffzrrxm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  
										style="width:160px;" />
									</td>
									
									
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:230px">
										    证件号码：<input type="text" name="ffzrrzjhm" id="ffzrrzjhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  
										    style="width:160px" />
									</td>
									
									
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										负责人常用证件：<input class="easyui-combobox" type="text" id="ffzrrcyzjdm" name="ffzrrcyzjdm"
													data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" 
													style="width:160px"/>
									</td>
								</tr>

								<tr>
									<td class="toolbarTd" style="width:230px">
										组织地址：<input type="text" name="dz_ffzrrssdwdzxz" id ="dz_ffzzjzdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" 
										style="width:160px"  />
									</td>

									
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										组织类别&nbsp;：&nbsp;<input class="easyui-combobox" type="text" id="ffzzlb" name="ffzzlb"
													data-options="url: contextPath + '/common/dict/D_ORG_ORGTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" 
													style="width:160px"/>
									</td>
									
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:230px">
										组织名称：<input type="text" name="ffzzmc" id ="ffzzmc" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" 
										style="width:160px"  />
									</td>
									
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										负责人居住地址：<input type="text" name="dz_ffzrrjzdzxz" id ="dz_ffzrrjzdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" 
										style="width:160px;"  />
									</td>

								</tr>
								
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a class="easyui-linkbutton" iconCls="icon-add" onclick="rfAdd();">新增</a>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
	</div>
	</div>
	</div>
<script type="text/javascript">
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}
var zzjgdmPd = "<%=userOrgCode%>";
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
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

//查询按钮
function queryButton(){
  	var ffzzxsdm = document.getElementById("ffzzxsdm").value;
  	var ffzrrxm = document.getElementById("ffzrrxm").value;
  	var ffzrrzjhm = document.getElementById("ffzrrzjhm").value;
  	var ffzzmc = document.getElementById("ffzzmc").value;
  	var dz_ffzrrjzdzxz = document.getElementById("dz_ffzrrjzdzxz").value;
  	
	var ffzrrcyzjdm = $("#ffzrrcyzjdm").combobox('getValue');
	var ffzzlb = $("#ffzzlb").combobox('getValue');
  	
  	ffzrrxm= $.trim(ffzrrxm);
  	ffzrrzjhm= $.trim(ffzrrzjhm);
  	dz_ffzrrjzdzxz= $.trim(dz_ffzrrjzdzxz);
  	ffzzmc= $.trim(ffzzmc);
  	
  	
  	$('#dg').datagrid(
  			'reload',
  			{    
  				'ffzzxsdm':ffzzxsdm,
  				'ffzrrxm': ffzrrxm,   
  				'ffzrrzjhm': ffzrrzjhm ,
  				'ffzrrcyzjdm':ffzrrcyzjdm,
  				'ffzzlb':ffzzlb,
  				'dz_ffzrrjzdzxz':dz_ffzrrjzdzxz,
  				'ffzzmc':ffzzmc
  			});
  }
  
function doEdit(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/rfxx/addRfxx?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("人防信息编辑－" + rowData.ffzrrxm,hsUrl);
  }
function doCk(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/rfxx/addRfxx?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	menu_open("人防信息查看－" + rowData.ffzrrxm,hsUrl);
}
  
//注销单条
  function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/rfxx/deleteRfxx';
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
	
function dbClickRow(rowIndex,rowData){
		var hsUrl = "/rfxx/addRfxx";
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("人防信息－" + rowData.xm,hsUrl);
}

function rfAdd(){
	var hsUrl = "/rfxx/addRfxx?";
	hsUrl+="&mainTabID="+getMainTabID();
	menu_open("人防信息新增",hsUrl);
}

function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
    </script>
  </body>
</html>
