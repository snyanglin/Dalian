<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    String xzqhdm = "";
    String orglevel = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel = userInfo.getUserOrgLevel();
        bjzbz = userInfo.getBjzbz();
        if(!"".equals(userOrgCode)&&userOrgCode!=null){
        	if(!"31".equals(orglevel)&&!"30".equals(orglevel)){
        		xzqhdm = userOrgCode.substring(0,6);
        	}
        }
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地名管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=orglevel%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dmManage/dmManage.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'west',border:false" style="width:625px;">
        <!-- 地名管理列表 -->
        <table id="dg" class="easyui-datagrid"
           	data-options="url:'<%=contextPath%>/dm/queryDmList',
             	delayCountUrl:'<%=contextPath%>/dm/queryDmCount',
				onLoadSuccess:function(data){beforeTableLoad(data,'dg');},
				selectOnCheck:true,
	       		checkOnSelect:true,
	       		rownumbers:true,
	       		border:false,
	       		sortName:'',
	       		sortOrder:'desc',
	       		onSelect:DmManage.onSelectRow,
	       		pageSize:getAutoPageSize(115),
	       		pageList:[getAutoPageSize(115),
	       		getAutoPageSize(115) * 2],
	       		singleSelect:true,
	       		fitColumns:true,
				toolbar:'#datagridToolbar'">
		    <thead>
		       <tr>
		        <th data-options="field:'dmmc',width:80,halign:'center'">地名名称</th>
		        <th data-options="field:'xzqh',width:160,halign:'center'">行政区划</th>
		        <th data-options="field:'gxdw',width:250,halign:'center'">管辖单位</th>
		       	<th data-options="field:'process',width:80,align:'center',halign:'center',formatter:DmManage.datagridProcessFormater">操作</th>
		       </tr>
		    </thead>
		</table>
		<!-- 查询条件 -->
        <div id="datagridToolbar" style="padding:5px;height:auto;">
			<form id="queryForm">
			<table cellspacing="0" cellpadding="0" border="0" >
				<tbody>
				     <tr class="dialogTr">
						<td class="dialogTd" style="width:85px" align="right">地名名称：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="dmmc" id="dmmc" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" style="width:85px" align="right">行政区划：</td>
						<td class="dialogTd" style="width:140px" align="right">
							 <input type="text" name="xzqh" id="xzqh" class="easyui-combobox" 
							             data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
					                                  method:'get',valueField:'id',textField:'text',selectOnNavigation:false,
					                                  onLoadSuccess:function(){$('#xzqh').combobox('setValue','<%=xzqhdm%>');}" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
					  </tr>
					  <tr class="dialogTr"> 
					    <td class="dialogTd" style="width:85px" align="right">管辖分(县)局：</td>
					    <td class="dialogTd" style="width:140px" align="right">
							<input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox" 
							             data-options="valueField:'id',textField:'text',url:'<%=basePath %>gzjk/queryOrg',
							             onLoadSuccess:function(){$('#gxsxj').combobox('setValue','<%=userOrgCode%>');},
							             onSelect:function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#gxpcs').combobox('reload', url);}" style="width:140px;"/>
					    </td>
					    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
					    <td class="dialogTd" style="width:85px" align="right">管辖派出所：</td>
						<td class="dialogTd" style="width:14px" align="right">
							<input type="text" id="gxpcs" name="gxpcs" class="easyui-combobox"  data-options="valueField:'id',textField:'text'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="DmManage.queryButton();">查询</a>
							<a id="dmaddid" class="easyui-linkbutton" iconCls="icon-add"  onclick="DmManage.dmAdd();">新增</a>
						</td>
					  </tr>
				</tbody>
			  </table>
			</form>
         </div>
    </div>
    <div data-options="region:'center',border:false">
      <div id="mapDiv" ></div>
      <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
    </div> 
    <!-- 新增地名 -->
    <div id="winDmxx" style="display: none;">
	  <iframe id="addDmFrame" style="width: 100%; height: 100%;" frameborder="0" src=""></iframe>
	</div>
	<!-- 注销原因 -->
    <div id="dmzxId" class="easyui-window" data-options="collapsible:false,minimizable:false,maximizable:false,
    	modal:true,closed:true,width:350,height:180">
        <form action="" id="cancelform" name="cancelform" method="post">
	        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
		    	<input type="hidden" id="index" name="index">
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">注销原因：</td>
			    	<td width="80%" class="dialogTd" colspan="2">
			            <textarea id="xt_zxyy" name="xt_zxyy" class="easyui-validatebox" style="width: 240px; height:78px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
			        </td>
		    	</tr>
		    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
			    	<td colspan="3" align="right">
			    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="DmManage.cancelButton();">确定</a>
			    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="DmManage.closeWindow();">关闭</a>
			    	</td>
		    	</tr>
	        </table>
        </form>
 	</div>
  </body>
</html>