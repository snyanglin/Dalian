<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>人口查询</title>
    <script type="text/javascript" src="<%=contextPath%>/js/syfw/syfwQuery.js"></script>
    <script type="text/javascript">
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <style type="text/css">
    	.infoTable{font-size: 15px;font-family: Microsoft YaHei;text-align: left;}
    	.infoTable1{font-size: 16px;font-family: Microsoft YaHei;text-align: left;}
    </style>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:540px;">
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/syfw/querySyfw',
	              		delayCountUrl:'<%=contextPath%>/syfw/querySyfwCount',
						onLoadSuccess:function(data){SyfwQuery.loadPoint(data,'dg');},
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
		        		nowrap:false,
						toolbar:'#datagridToolbar',
						onClickRow:SyfwQuery.onClickRow">
			        <thead>
			          <tr>
			           	<th data-options="field:'fwlbdm',width:70,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_FWLBDM.js'">房屋类别</th>
						<th data-options="field:'fwdz_dzxz',width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">房屋地址</th>
						<th data-options="field:'fz_xm',width:70,align:'center',halign:'center',sortable:true">房主</th>
						<th data-options="field:'sfczfw',width:70,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SF.js'">出租房屋</th>
						<th data-options="field:'process',width:100,align:'center',halign:'center',formatter:SyfwQuery.datagridProcessFormater">操作</th>
					</tr>
			       </thead>
	       </table>
           <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width: 63%;" align="center">
							     <input id="searchbox" class="easyui-searchbox" data-options="height:24,prompt:'请输入房屋地址,房主信息',searcher:SyfwQuery.doSearch" style="width:338px"></input>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 17%;" align="right">
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-preview" data-options="plain:true" onclick="SyfwQuery.detailSearch()">精确查询</a>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 20%;" align="center">
								<a href="javascript:void(0)" class="easyui-menubutton" iconCls="icon-draw" data-options="menu:'#mm'">空间查询</a>
								<div id="mm" style="width:60px;">
									<div data-options="iconCls:'icon-drawRect'" onclick="SyfwQuery.dragModeSpace('drawRect');">拉框查询</div>
								    <div data-options="iconCls:'icon-drawCircle'" onclick="SyfwQuery.dragModeSpace('drawCircle');">圆形查询</div>  
								    <div data-options="iconCls:'icon-drawPolygon'" onclick="SyfwQuery.dragModeSpace('drawPolygon');">多边形查询</div>
								</div>  
							</td>
						</tr>
					</tbody>
				</table>
           </div>
           <div id="win" class="easyui-window" title="实有房屋精确查询"  data-options="iconCls:'icon-search',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:380,height:330">
		        <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				        <tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房主姓名：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-validatebox" type="text" id="fz_xm" name="fz_xm"
								style="width:150px;" /></td>
						</tr>
						<!--   <tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">托管人姓名：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-validatebox" type="text" id="tgr_xm" name="tgr_xm"
								style="width:150px;" /></td>
						</tr>-->
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房屋类别：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="fwlbdm" name="fwlbdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/D_BZ_FWLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房屋地址：</td>
							<td width="70%" class="dialogTd"><input type="text"
								name="fwdz_dzxz" id="fwdz_dzxz" class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[50]'"
								style="width:150px;" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">是否出租房：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="sfczfw" name="sfczfw"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>
						<!--<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房屋用途：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="fwytdm" name="fwytdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/ZA_D_FWYTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>-->
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyfwQuery.queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="SyfwQuery.resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyfwQuery.closeWindow();">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
     </div>
     <div data-options="region:'center',border:false">
	       <div id="mapDiv"></div>
	       <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	  </div>
  </body>
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
 //精确查询
 function detailSearch(){
 	$("#win").show();
 	$("#win").window("open"); 
 }
 //----精确查询框方法---------
 function closeWindow(id){
 	if(id)
 		$("#"+id).window("close"); 
 	else
 		$("#win").window("close"); 
 }
 function setDzqc(obj){
 	   obj.value="";
 }
 //查询按钮
 function queryButton(){
 	var fz_xm = document.getElementById("fz_xm").value;
 	var fwlbdm = document.getElementById("fwlbdm").value;
 	var fwdz_dzxz = document.getElementById("fwdz_dzxz").value;
 	var sfczfw = document.getElementById("sfczfw").value;
 	$('#dg').datagrid(
 			'load',
 			{    
 				'fz_xm':fz_xm,				  
 				'fwlbdm': fwlbdm ,
 				'fwdz_dzxz':fwdz_dzxz,
 				'sfczfw':sfczfw
 			});
 	closeWindow("win");
 }
 //重置按钮
 function resetButton(){
 	$("#queryForm").form("reset");
 }
 </script>
</html>