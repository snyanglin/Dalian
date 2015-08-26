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
    <title>境外人员日常走访</title>
    <script type="text/javascript">
   		var orglevel = "<%=orglevel%>";
   		var userOrgCode = "<%=userOrgCode%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/syrkgl/ryJwryrczfb.js"></script>
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
							   <input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:140px;"
							      data-options="url: contextPath + '/common/dict/KX_D_CYZJDM.js',dataFilter:'^4|^5',valueField:'id',textField:'text'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 100px;" align="right">证件号码：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:140px;float:left;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 60px;" align="right">外文姓：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-validatebox" type="text" id="wwx" name="wwx" style="width:140px;float:left;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 60px;" align="right">外文名：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input class="easyui-validatebox" type="text" id="wwm" name="wwm" style="width:138px;float:left;"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td class="dialogTd" style="width: 100px;" align="right">居住地管辖单位：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input type="text" name="jzd_gxdwdm" id ="jzd_gxdwdm" class="easyui-combobox"
					                data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false,
					                      url:contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32'" style="width:140px;"/>
							</td>
						    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 100px;" align="right">工作地管辖单位：</td>
							<td class="dialogTd" style="width: 140px" align="right">
							   <input type="text" name="gzd_gxdwdm" id ="gzd_gxdwdm" class="easyui-combobox"
					                data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false,
					                      url:contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32'" style="width:140px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width: 60px;" align="right">状态：</td>
							<td class="dialogTd" style="width: 140px;" align="right">
							   <input class="easyui-combobox" type="text" id="zt" name="zt" style="width:140px;" 
									data-options="url: contextPath + '/common/dict/D_JWRY_RCZFZT.js',valueField:'id',textField:'text'"/>
							</td>
						    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						    <td class="toolbarTd" align="right" colspan="3">
						       <a class="easyui-linkbutton" iconCls="icon-search" onclick="RyJwryrczfb.queryButton();">查询</a>
						       <a class="easyui-linkbutton" iconCls="icon-reload" onclick="RyJwryrczfb.clearCase();">重置</a>
						    </td>
						</tr>
					</tbody>
				</table>
			  </form>
           </div>
           <!-- 日常走访核实 -->
           <div id="win" class="easyui-window" title="日常走访核实"  data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
                modal:true,closed:true,width:380,height:300">
		        <form action="<%=basePath%>jwryrczf/update" id="bzxxForm" name="bzxxForm" method="post">
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
			         	<input type="hidden" id="id" name="id" value="">
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">走访结果：</td>
					    	<td width="70%" class="dialogTd">
								<input class="easyui-combobox" type="text" id="zfjg" name="zfjg" style="width:180px;"
							    	   data-options="url: contextPath + '/common/dict/D_JWRY_ZFJG.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
							</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">走访时间：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="zfsj" id="zfsj" class="easyui-validatebox" style="width:180px;vertical-align: middle;" value=""
								    onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})" data-options="required:true,tipPosition:'left',
								    validType:['date[\'yyyy-MM-dd\']']"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">走访人</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="zfr" id ="zfr" class="easyui-validatebox" style="width:180px;" value="<%=userInfo.getUserName()%>"/>
					    	    <input type="hidden" name="zfrid" id ="zfrid" class="easyui-validatebox" style="width:180px;" value="<%=userInfo.getUserId()%>"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">走访单位</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="zfdw" id ="zfdw" class="easyui-validatebox" style="width:180px;" value="<%=userInfo.getUserOrgName()%>"/>
					    	    <input type="hidden" name="zfdwid" id ="zfdwid" class="easyui-validatebox" style="width:180px;" value="<%=userInfo.getUserOrgCode()%>"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="RyJwryrczfb.qdbutton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="RyJwryrczfb.closeSh();">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
      </div>
  </body>
</html>