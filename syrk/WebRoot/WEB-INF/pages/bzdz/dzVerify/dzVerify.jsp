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
    <title>地址审核</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzVerify/dzVerify.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:538px;">
         <!-- 地址审核列表 -->
         <table id="dg" class="easyui-datagrid"
	             data-options="url:'<%=contextPath%>/dz/queryShDzList',
	               	delayCountUrl:'<%=contextPath%>/dz/queryDzCount',
					onLoadSuccess:function(data){DzVerify.loadPoint(data,'dg');},
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
					onClickRow:DzVerify.onClickRow">
		        <thead>
		          <tr>
		            <th data-options="field:'mlphqc',width:120,halign:'center'">地址名称</th>
		            <th data-options="field:'shztdm',width:50,align:'center',halign:'center',dictName:contextPath+'/common/dict/DZ_BZDZ_SHZT.js',formatter:DzVerify.datagridDzzt">地址状态</th>
		            <th data-options="field:'pcsmc',width:90,align:'center'">管辖派出所</th>
		            <th data-options="field:'zrqmc',width:90,align:'center'">管辖责任区</th>
		          	<th data-options="field:'process',width:50,align:'center',halign:'center',formatter:DzVerify.datagridProcessFormater">操作</th>
		          </tr>
		       </thead>
	      </table>
          <!-- 查询条件 -->
          <div id="datagridToolbar" style="padding:5px;height:auto;">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width:217px;" align="right" colspan="2"> 
								<input type="text" name="dzmc" id="dzmc" class="easyui-searchbox" data-options="height:24,prompt:'请输入地址名称、拼音、别名搜索',searcher:DzVerify.queryButton" style="width:217px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width:80px;" align="right">地址状态：</td>
							<td class="dialogTd" style="width:137px" align="right">
								 <input type="text" id="shztdm" name="shztdm" class="easyui-combobox"
								           data-options="url: contextPath + '/common/dict/DZ_BZDZ_SHZT.js',dataFilter:'.*[^00]$',
						                         method:'get',valueField:'id',textField:'text',selectOnNavigation:false,
						                         onLoadSuccess:function(){$('#shztdm').combobox('setValue','01');},
						                         onSelect:function(rec){$('#shztdm').combobox('setValue',rec.id);DzVerify.queryButton();}" style="width:137px"/>
							</td>
							<td class="toolbarTd" colspan="2"><div class="datagrid-btn-separator"></div></td>
						</tr>
						<tr>
						    <td class="dialogTd" style="width:80px;" align="right">管辖派出所：</td>
							<td class="dialogTd" style="width:137px;" align="right"> 
							    <input id="pcsdm" name='pcsdm' class="easyui-combobox" data-options="valueField:'id',textField:'text',url:'<%=contextPath%>/gzjk/queryOrgLower?orgCode=<%=userOrgCode%>',
						         onSelect:function(rec){var url='<%=contextPath%>/gzjk/queryOrgLowest?orgCode='+rec.id;$('#zrqdm').combobox('reload',url);}" style="width:137px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width:80px;" align="right">管辖责任区：</td>
							<td class="dialogTd" style="width:137px;" align="right"> 
								 <input id="zrqdm" name="zrqdm" class="easyui-combobox" data-options="valueField:'id',textField:'text'" style="width:137px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" align="left">
								<a class="easyui-linkbutton" iconCls="icon-search" onclick="DzVerify.queryButton();">查询</a>
							</td>
						</tr>
					</tbody>
				</table>
          </div>
     </div>
     <div data-options="region:'center',border:false">
	     <div id="mapDiv"></div>
	     <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	  </div>
  </body>
</html>