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
<html>
  <head>
    <title>地址管理</title>
    <script type="text/javascript">
   	   var bzdzSh = "<%=SystemConfig.getString("bzdzSh")%>";
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzManage/dzManage.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'west',border:false" style="width:528px;">
           <!-- 地址管理列表 -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/dz/queryDzList',
						onLoadSuccess:function(data){DzManage.loadPoint(data,'dg');},
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
						toolbar:'#datagridToolbar',
						onClickRow:DzManage.onClickRow">
			        <thead>
			          <tr>
			            <th data-options="field:'mlphqc',width:300,halign:'center'">地址名称</th>
			            <th data-options="field:'dzzt',width:90,align:'center',halign:'center',dictName:contextPath+'/common/dict/DZ_BZDZ_DZZT.js',formatter:DzManage.datagridDzzt">地址状态</th>
			          	<th data-options="field:'process',width:90,align:'center',halign:'center',formatter:DzManage.datagridProcessFormater">操作</th>
			          </tr>
			       </thead>
	       </table>
           <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width:208px;" align="right"> 
								<input type="text" name="dzmc" id="dzmc" class="easyui-searchbox" data-options="height:24,prompt:'请输入地址名称、拼音、别名搜索',searcher:DzManage.queryButton" style="width:208px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width:60px;" align="right">地址状态：</td>
							<td class="dialogTd" style="width:80px" align="right">
								 <input type="text" name="dzzt" id="dzzt" class="easyui-combobox"
								           data-options="url: contextPath + '/common/dict/DZ_BZDZ_DZZT.js',dataFilter:'.*[^00]$',
						                         method:'get',valueField:'id',textField:'text',selectOnNavigation:false,
						                         onLoadSuccess:function(){$('#dzzt').combobox('setValue','01');},
						                         onSelect:function(rec){$('#dzzt').combobox('setValue',rec.id);DzManage.queryButton();}" style="width:80px"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" align="center">
								<a class="easyui-linkbutton" iconCls="icon-search" onclick="DzManage.queryButton();">查询</a>
								<a id="dzaddid" class="easyui-linkbutton" iconCls="icon-add" onclick="DzManage.dzAdd();">新增</a>
							</td>
						</tr>
					</tbody>
				</table>
           </div>
           <!-- 注销原因 -->
           <div id="dzzxId" class="easyui-window" data-options="collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:350,height:180">
		        <form action="" id="cancelform" name="cancelform" method="post">
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				    	<input type="hidden" id="index" name="index">
				    	<input type="hidden" id="zxbz" name="zxbz">
				    	<input type="hidden" id="type" name="type">
				    	<tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="80%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="xt_zxyy" class="easyui-validatebox" style="width: 240px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="DzManage.cancelButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="DzManage.closeWindow();">关闭</a>
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