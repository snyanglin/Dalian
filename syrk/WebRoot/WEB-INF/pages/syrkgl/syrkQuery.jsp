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
    <script type="text/javascript">
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <style type="text/css">
    	.infoTable{font-size: 15px;font-family: Microsoft YaHei;text-align: left;}
    	.infoTable1{font-size: 16px;font-family: Microsoft YaHei;text-align: left;}
    </style>
    <script type="text/javascript" src="<%=contextPath%>/js/syrkgl/syrkQuery.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:540px;">
           <!-- 人口查询列表 -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/syrkGl/querySyrk',
	                  	delayCountUrl:'<%=contextPath%>/syrkGl/querySyrkCount',
						onLoadSuccess:function(data){SyrkQuery.loadPoint(data,'dg');},
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
		        		fitColumns:false,
		        		nowrap:true,
						toolbar:'#datagridToolbar',
						onClickRow:SyrkQuery.onClickRow">
			        <thead>
			          <tr>
			           	<th data-options="field:'syrkywlxdm',width:80,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SYRKYWLXDM.js'">人员类型</th>
			            <th data-options="field:'zjhm',width:120,align:'center',sortable:true,halign:'center'">证件号码</th>
				        <th data-options="field:'xm',width:50,align:'center',sortable:true,halign:'center'">姓名</th>
				        <th data-options="field:'jzd_dzxz',width:180,align:'left',sortable:true,halign:'center',formatter:SyrkQuery.subjzddzxz">居住地址</th>
				        <th data-options="field:'process',width:60,align:'center',halign:'center',formatter:SyrkQuery.datagridProcessFormater">操作</th>
			          </tr>
			       </thead>
	       </table>
           <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width: 63%;" align="center">
							     <input id="searchbox" class="easyui-searchbox" data-options="height:24,prompt:'请输入人员姓名、证件号码或居住地址',searcher:SyrkQuery.doSearch" style="width:338px"></input>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 17%;" align="right">
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-preview" data-options="plain:true" onclick="SyrkQuery.detailSearch()">精确查询</a>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 20%;" align="center">
								<a href="javascript:void(0)" class="easyui-menubutton" iconCls="icon-draw" data-options="menu:'#mm'">空间查询</a>
								<div id="mm" style="width:60px;">
									<div data-options="iconCls:'icon-drawRect'" onclick="SyrkQuery.dragModeSpace('drawRect');">拉框查询</div>
								    <div data-options="iconCls:'icon-drawCircle'" onclick="SyrkQuery.dragModeSpace('drawCircle');">圆形查询</div>  
								    <div data-options="iconCls:'icon-drawPolygon'" onclick="SyrkQuery.dragModeSpace('drawPolygon');">多边形查询</div>
								</div>  
							</td>
						</tr>
					</tbody>
				</table>
           </div>
           <div id="win" class="easyui-window" title="实有人口精确查询"  data-options="iconCls:'icon-search',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:380,height:330">
		        <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				        <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">人员类型：</td>
						    	<td width="70%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="syrkywlxdm" name="syrkywlxdm" style="width:180px;"
								    	   data-options="url: contextPath + '/common/dict/BD_D_SYRKYWLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">姓名：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="xm" id="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">证件类型：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:180px;"
							    	   data-options="url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="zjhm" id ="zjhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">性别：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:180px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						    </td>
				    	</tr>	  
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">民族：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:180px;"
									data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						    </td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">居住地址：</td>
					    	<td width="70%" class="dialogTd">
					            <input type="text" name="jzd_dzxz" id ="jzd_dzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					        </td>
				    	</tr>	
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkQuery.queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="SyrkQuery.resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkQuery.closeWindow();">关闭</a>
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
</html>