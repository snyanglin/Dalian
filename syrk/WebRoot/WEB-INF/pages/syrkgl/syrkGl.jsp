<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String orglevel = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel = userInfo.getUserOrgLevel();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人口管理</title>
    <script type="text/javascript">
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=orglevel%>";
    </script>
    <style type="text/css">
    	.infoTable{font-size: 15px;font-family: Microsoft YaHei;text-align: left;}
    	.infoTable1{font-size: 16px;font-family: Microsoft YaHei;text-align: left;}
    </style>
    <script type="text/javascript" src="<%=contextPath%>/js/syrkgl/syrkGl.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:540px;">
           <!-- 人口管理列表 -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/syrkGl/queryList',
						onLoadSuccess:function(data){SyrkGl.loadPoint(data,'dg');},
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'xt_zhxgsj',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:true,
		        		fitColumns:false,
		        		nowrap:true,
						toolbar:'#datagridToolbar',
						onClickRow:SyrkGl.onClickRow">
			        <thead>
			          <tr>
			           	<th data-options="field:'syrkywlxdm',width:80,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SYRKYWLXDM.js'">人员类型</th>
			            <th data-options="field:'zjhm',width:120,align:'center',sortable:true,halign:'center'">证件号码</th>
				        <th data-options="field:'xm',width:60,align:'center',sortable:true,halign:'center'">姓名</th>
				        <th data-options="field:'jzd_dzxz',width:150,align:'left',sortable:true,halign:'center',formatter:SyrkGl.subjzddzxz">居住地址</th>
				        <th data-options="field:'process',width:80,align:'center',halign:'center',formatter:SyrkGl.datagridProcessFormater">操作</th>
			          </tr>
			       </thead>
	       </table>
           <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width: 60%;" align="center">
							     <input id="searchbox" class="easyui-searchbox" data-options="height:24,prompt:'请输入人员姓名、证件号码或居住地址',searcher:SyrkGl.doSearch" style="width:340px"></input>
							</td>
							<td class="dialogTd" style="width: 23%;" align="center">
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="SyrkGl.detailSearch()">精确查询</a>
							</td>
							<td class="toolbarTd" style="width: 17%;" align="center">
								<a id="dzaddid" class="easyui-linkbutton" iconCls="icon-add" onclick="SyrkGl.syrkAdd();">新增</a>
							</td>
						</tr>
					</tbody>
				</table>
           </div>
           <div id="win" class="easyui-window" title="实有人口精确查询"  data-options="iconCls:'icon-search',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:380,height:300">
		        <form id ="queryForm" >
			        <table id="jqcxTable" border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
				        <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">人员类型：</td>
						    	<td width="70%" class="dialogTd">
									<input class="easyui-combobox-delay" type="text" id="syrkywlxdm" name="syrkywlxdm" style="width:180px;"
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
					    	<td width="30%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="zjhm" id ="zjhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">性别：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input class="easyui-combobox-delay" type="text" id="xbdm" name="xbdm" style="width:180px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						    </td>
				    	</tr>	  
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">民族：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input class="easyui-combobox-delay" type="text" id="mzdm" name="mzdm" style="width:180px;"
									data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						    </td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">居住地：</td>
					    	<td width="70%" class="dialogTd">
					            <input type="text" name="jzd_dzxz" id ="jzd_dzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					        </td>
				    	</tr>	
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkGl.queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkGl.closeWindow('win');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
		   <div id="cancel_1" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:470,height:380">
		        <form action="<%=basePath%>syrkGl/cancelSyrk" id="cancelform_1" name="cancelform_1" method="post">
		            <input type="hidden" id="id_1" name="czrk.id">
		            <input type="hidden" id="ryid_1" name="czrk.ryid">
		            <input type="hidden" id="syrkywlxdm_1" name="syrkywlxdm">
		            <input type="hidden" id="qcyxm_1" name="qcyxm">
			        <table id="czrkTable" border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
				        <tr class="dialogTr">
						    <td width="30%" class="dialogTd" align="right">迁（流）出日期：</td>
						    <td width="70%" class="dialogTd" colspan="2">
								 <input class="easyui-validatebox-delay" type="text" id="lkbsqk_qlcrq" name="czrk.lkbsqk_qlcrq" style="width:300px;" 
		    	 						 	data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
							</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">迁移（流动）原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="lkbsqk_qyldyydm" name="czrk.lkbsqk_qyldyydm" style="width:300px;" 
									      data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地国家和地区：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="qwd_gjhdqdm" name="czrk.qwd_gjhdqdm" style="width:300px;" 
									  data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地：</td>
					    	<td width="50%" class="dialogTd">
						    	<input class="easyui-combobox" id="czrk_qwd1" style="width:220px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="czrk_qwd_mlpdm" name="czrk.qwd_mlpdm"/>
						    	<input type="hidden" id="czrk_qwd_mlpxz" name="czrk.qwd_mlpxz"/>
					    	</td>
					    	<td width="20%" class="dialogTd" align="left">
						    	<input class="easyui-combobox" id="czrk_qwd2" style="width:70px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="czrk_qwd_dzid" name="czrk.qwd_dzid"/>
						    	<input type="hidden" id="czrk_qwd_xzqhdm" name="czrk.qwd_xzqhdm"/>
						    	<input type="hidden" id="czrk_qwd_dzxz" name="czrk.qwd_dzxz"/>
						    	<input type="hidden" id="czrk_qwd_zrqdm" name="qwd_zrqdm"/>
					    	</td>
				    	</tr>	  
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">死亡日期：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	    <input class="easyui-validatebox-delay" type="text" id="swrq" name="czrk.swrq" style="width:300px;" 
		    	 				 	data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
						    </td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">人口管理死亡原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <input class="easyui-combobox-delay" type="text" id="rkglswyydm" name="czrk.rkglswyydm" style="width:300px;" 
									data-options="url: contextPath + '/common/dict/ZA_D_RKGLSWYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					        </td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="czrk.xt_zxyy" class="easyui-validatebox" style="width: 300px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkGl.cancelButton(1);">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkGl.closeWindow('cancel_1');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
		   <div id="cancel_2" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:470,height:280">
		        <form action="<%=basePath%>syrkGl/cancelSyrk" id="cancelform_2" name="cancelform_2" method="post">
		            <input type="hidden" id="id_2" name="jzrk.id">
		            <input type="hidden" id="ryid_2" name="jzrk.ryid">
		            <input type="hidden" id="syrkywlxdm_2" name="syrkywlxdm">
		            <input type="hidden" id="qcyxm_2" name="qcyxm">
			        <table id="jzrkTable" border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
				        <tr class="dialogTr">
						    <td width="30%" class="dialogTd" align="right">实际离开时间：</td>
						    <td width="70%" class="dialogTd" colspan="2">
								 <input class="easyui-validatebox-delay" type="text" id="sj_lksj" name="jzrk.sj_lksj" style="width:300px;" 
		    	 						 	data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
							</td>
					   	</tr>	
					   	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地国家和地区：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="qwd_gjhdqdm" name="jzrk.qwd_gjhdqdm" style="width:300px;" 
									  data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地：</td>
					    	<td width="50%" class="dialogTd">
						    	<input class="easyui-combobox" id="jzrk_qwd1" style="width:220px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="jzrk_qwd_mlpdm" name="jzrk.qwd_mlpdm"/>
						    	<input type="hidden" id="jzrk_qwd_mlpxz" name="jzrk.qwd_mlpxz"/>
					    	</td>
					    	<td width="20%" class="dialogTd" align="left">
						    	<input class="easyui-combobox" id="jzrk_qwd2" style="width:70px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="jzrk_qwd_dzid" name="jzrk.qwd_dzid"/>
						    	<input type="hidden" id="jzrk_qwd_xzqhdm" name="jzrk.qwd_xzqhdm"/>
						    	<input type="hidden" id="jzrk_qwd_dzxz" name="jzrk.qwd_dzxz"/>
						    	<input type="hidden" id="jzrk_qwd_zrqdm" name="qwd_zrqdm"/>
					    	</td>
				    	</tr>	  
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="jzrk.xt_zxyy" class="easyui-validatebox" style="width: 300px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkGl.cancelButton(2);">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkGl.closeWindow('cancel_2');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
		   <div id="cancel_3" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:470,height:330">
		        <form action="<%=basePath%>syrkGl/cancelSyrk" id="cancelform_3" name="cancelform_3" method="post">
		            <input type="hidden" id="id_3" name="ldrk.id">
		            <input type="hidden" id="ryid_3" name="ldrk.ryid">
		            <input type="hidden" id="syrkywlxdm_3" name="syrkywlxdm">
		            <input type="hidden" id="qcyxm_3" name="qcyxm">
			        <table id="ldrkTable" border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
				        <tr class="dialogTr">
						    <td width="30%" class="dialogTd" align="right">迁（流）出日期：</td>
						    <td width="70%" class="dialogTd" colspan="2">
								 <input class="easyui-validatebox-delay" type="text" id="lkbsqk_qlcrq" name="ldrk.lkbsqk_qlcrq" style="width:300px;" 
		    	 						 	data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
							</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">迁移（流动）原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="lkbsqk_qyldyydm" name="ldrk.lkbsqk_qyldyydm" style="width:300px;" 
									      data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地国家和地区：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="qwd_gjhdqdm" name="ldrk.qwd_gjhdqdm" style="width:300px;" 
									  data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地：</td>
					    	<td width="50%" class="dialogTd">
						    	<input class="easyui-combobox" id="ldrk_qwd1" style="width:220px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="ldrk_qwd_mlpdm" name="ldrk.qwd_mlpdm"/>
						    	<input type="hidden" id="ldrk_qwd_mlpxz" name="ldrk.qwd_mlpxz"/>
					    	</td>
					    	<td width="20%" class="dialogTd" align="left">
						    	<input class="easyui-combobox" id="ldrk_qwd2" style="width:70px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="ldrk_qwd_dzid" name="ldrk.qwd_dzid"/>
						    	<input type="hidden" id="ldrk_qwd_xzqhdm" name="ldrk.qwd_xzqhdm"/>
						    	<input type="hidden" id="ldrk_qwd_dzxz" name="ldrk.qwd_dzxz"/>
						    	<input type="hidden" id="ldrk_qwd_zrqdm" name="qwd_zrqdm"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="ldrk.xt_zxyy" class="easyui-validatebox" style="width: 300px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkGl.cancelButton(3);">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkGl.closeWindow('cancel_3');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
		   <div id="cancel_4" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:470,height:330">
		        <form action="<%=basePath%>syrkGl/cancelSyrk" id="cancelform_4" name="cancelform_4" method="post">
		            <input type="hidden" id="id_4" name="jwry.id">
		            <input type="hidden" id="ryid_4" name="jwry.ryid">
		            <input type="hidden" id="syrkywlxdm_4" name="syrkywlxdm">
		            <input type="hidden" id="qcyxm_4" name="qcyxm">
			        <table id="jwryTable" border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
				        <tr class="dialogTr">
						    <td width="30%" class="dialogTd" align="right">迁（流）出日期：</td>
						    <td width="70%" class="dialogTd" colspan="2">
								 <input class="easyui-validatebox-delay" type="text" id="lkbsqk_qlcrq" name="jwry.lkbsqk_qlcrq" style="width:300px;" 
		    	 						 	data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
							</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">迁移（流动）原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="lkbsqk_qyldyydm" name="jwry.lkbsqk_qyldyydm" style="width:300px;" 
									      data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地国家和地区：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					    	     <input class="easyui-combobox-delay" type="text" id="qwd_gjhdqdm" name="jwry.qwd_gjhdqdm" style="width:300px;" 
									  data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">去往地：</td>
					    	<td width="50%" class="dialogTd">
						    	<input class="easyui-combobox" id="jwry_qwd1" style="width:220px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="jwry_qwd_mlpdm" name="jwry.qwd_mlpdm"/>
						    	<input type="hidden" id="jwry_qwd_mlpdm" name="jwry.qwd_mlpxz"/>
					    	</td>
					    	<td width="20%" class="dialogTd" align="left">
						    	<input class="easyui-combobox" id="jwry_qwd2" style="width:70px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type="hidden" id="jwry_qwd_dzid" name="jwry.qwd_dzid"/>
						    	<input type="hidden" id="jwry_qwd_xzqhdm" name="jwry.qwd_xzqhdm"/>
						    	<input type="hidden" id="jwry_qwd_dzxz" name="jwry.qwd_dzxz"/>
						    	<input type="hidden" id="jwry_qwd_zrqdm" name="qwd_zrqdm"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="jwry.xt_zxyy" class="easyui-validatebox" style="width: 300px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkGl.cancelButton(4);">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkGl.closeWindow('cancel_4');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
		   <div id="cancel_5" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:350,height:180">
		        <form action="<%=basePath%>syrkGl/cancelSyrk" id="cancelform_5" name="cancelform_5" method="post">
		            <input type="hidden" id="id_5" name="wlrk.id">
		            <input type="hidden" id="ryid_5" name="wlrk.ryid">
		            <input type="hidden" id="syrkywlxdm_5" name="syrkywlxdm">
		            <input type="hidden" id="qcyxm_5" name="qcyxm">
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="wlrk.xt_zxyy" class="easyui-validatebox" style="width: 220px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyrkGl.cancelButton(5);">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SyrkGl.closeWindow('cancel_5');">关闭</a>
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