<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
	String orglevel = "";
	String userOrgCode = "";
	if(userInfo!=null){
		orglevel = userInfo.getUserOrgLevel();
		userOrgCode = userInfo.getUserOrgCode();
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>境外人员核实下发</title>
    <script type="text/javascript">
   		var orglevel = "<%=orglevel%>";
   		var userOrgCode = "<%=userOrgCode%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/syrkgl/ryJwrybzxxhsb.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'center',split:true,border:false" style="height:auto">
           <!-- 核实列表 -->
           <table id="dg"></table>
	       <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
           	<form id="queryForm">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width: 100px;" align="right">证件种类：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-combobox" type="text" id="paperType" name="paperType" style="width:140px;"
							      data-options="url: contextPath + '/common/dict/D_JWRY_CRJ_ZJZLB.js',valueField:'id',textField:'text'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 100px;" align="right">证件号码：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-validatebox" type="text" id="paperNO" name="paperNO" style="width:140px;float:left;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 60px;" align="right">英文姓：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-validatebox" type="text" id="surnameEN" name="surnameEN" style="width:140px;float:left;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 60px;" align="right">英文名：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-validatebox" type="text" id="firstnameEN" name="firstnameEN" style="width:138px;float:left;"/>
							</td>
						</tr>
						<tr class="dialogTr">
						    <td class="dialogTd" style="width: 100px;" align="right">居住地：</td>
							<td class="dialogTd" style="width: 140px" align="right">
								<input class="easyui-validatebox" type="text" id="inhabiDetailAddr" name="inhabiDetailAddr" style="width:140px;float:left;"/>
							</td>
						    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 100px;" align="right">工作地：</td>
							<td class="dialogTd" style="width: 140px" align="right">
								<input class="easyui-validatebox" type="text" id="workplaceDetailAddr" name="workplaceDetailAddr" style="width:140px;float:left;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 60px;" align="right">状态：</td>
							<td class="dialogTd" style="width: 140px;" align="right">
							   <input class="easyui-combobox" type="text" id="sjzt" name="sjzt" style="width:140px;" 
									data-options="url: contextPath + '/common/dict/D_JWRY_BZHSZT.js',valueField:'id',textField:'text'"/>
							</td>
						    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						    <td class="toolbarTd" align="right" colspan="3">
						       <a class="easyui-linkbutton" iconCls="icon-search" onclick="RyJwryBzxxhsb.queryButton();">查询</a>
						       <a class="easyui-linkbutton" iconCls="icon-reload" onclick="RyJwryBzxxhsb.clearCase();">重置</a>
						    </td>
						</tr>
					</tbody>
				</table>
			  </form>
           </div>
      </div>
  </body>
</html>