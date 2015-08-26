<!--  
	@Author:       [wu.w@founder.com.cn]
	@CreateDate:   [2015-5-15 上午8:51:54]
	* @review      : tian_chengwei@founder.com.cn
	* @reviewDate  : 20150604
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>大型群众性活动-审批类-列表</title>
	</head>
	<body class="easyui-layout" data-options="fit:true">  
         <div data-options="region:'center',split:true,title:'大型群众性活动-审批类-列表',border:true" style="height:auto">
         	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dxqzxhdspl/queryList',
         		toolbar:'#datagridToolbar',
         		singleSelect:true,selectOnCheck:true,
         		checkOnSelect:true,border:false,
         		sortName:'hdkssj',sortOrder:'asc',
         		idField:'id',pageSize:getAutoPageSize(),
         		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
			    <thead>
			        <tr>
			        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
			        	<th data-options="field:'hdid',hidden:true"></th>
			        	<th data-options="field:'xt_lrrbmid',hidden:true"></th>
			        	<th data-options="field:'hdlxdm',width:20,align:'center',sortable:true,halign:'center'
			        					,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FG_HDLX.js'">活动类型</th>
			        	<th data-options="field:'hdxzdm',width:25,align:'center',sortable:true,halign:'center'
			        					,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FG_HDXZ.js'">活动性质</th>
			        	<th data-options="field:'hdmc',width:30,align:'center',sortable:true,halign:'center'">活动名称</th>
			        	<th data-options="field:'cljgdm',width:15,align:'center',sortable:true,halign:'center'
			        					,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FG_CLJG.js'">处理结果</th>
			        	<th data-options="field:'hdkssj',width:25,align:'center',sortable:true,halign:'center'">活动开始时间</th>
			        	<th data-options="field:'hdjssj',width:25,align:'center',sortable:true,halign:'center'">活动结束时间</th>
			            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
			        </tr>
			    </thead>
			</table>
			<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
				<form id="queryForm">
					<table style="border: 0;width:1100px;" >
						<tbody>
							<tr>
								<td class="toolbarTd" style="width:300px" align="right">
									活动类型：<input type="text" id="hdlxdm" name="hdlxdm" style="width:160px;" class="easyui-combobox" 
												  data-options="required:false
												  				,url: contextPath + '/common/dict/D_FG_HDLX.js'
												  				,valueField:'id'
												  				,textField:'text'
												  				,tipPosition:'left'
												  				,selectOnNavigation:false
												  				,method:'get'" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:300px" align="right">
									活动性质：<input type="text" id="hdxzdm" name="hdxzdm" style="width:160px;" class="easyui-combobox" 
												  data-options="required:false
												  				,url: contextPath + '/common/dict/D_FG_HDXZ.js'
												  				,valueField:'id'
												  				,textField:'text'
												  				,tipPosition:'left'
												  				,selectOnNavigation:false
												  				,method:'get'" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:300px" align="right">
									活动名称：<input type="text" id="hdmc" name="hdmc" class="easyui-validatebox" style="width:160px"
												  data-options="required:false,validType:'maxLength[100]'" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							</tr>
							<tr>
								<td class="toolbarTd" style="width:300px" align="right">
									处理结果：<input type="text" id="cljgdm" name="cljgdm" style="width:160px;" class="easyui-combobox" 
												  data-options="required:false
												  				,url: contextPath + '/common/dict/D_FG_CLJG.js'
												  				,valueField:'id'
												  				,textField:'text'
												  				,tipPosition:'left'
												  				,selectOnNavigation:false
												  				,method:'get'" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:300px" align="right">
									活动开始时间-开始：<input type="text" name="hdkssj" id="hdkssj" 
														class="easyui-validatebox " style="width:160px;"
														data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
														onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'
																,maxDate:'#F{$dp.$D(\'hdkssjjz\') }'})" /></td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:300px" align="right">	
									活动开始时间-截止：<input type="text" name="hdkssjjz" id="hdkssjjz" 
														class="easyui-validatebox " style="width: 160px" 
														data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
														onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'
																,minDate:'#F{$dp.$D(\'hdkssj\') }'})" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							</tr>
							<tr>
								<td class="toolbarTd" style="width:300px" align="right">
									活动结束时间-开始：<input type="text" name="hdjssj" id="hdjssj" 
														class="easyui-validatebox " style="width:160px;"
														data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
														onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'
																,maxDate:'#F{$dp.$D(\'hdjssjjz\') }'})" /></td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:300px" align="right">	
									活动结束时间-截止：<input type="text" name="hdjssjjz" id="hdjssjjz" 
														class="easyui-validatebox " style="width: 160px"
														data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
														onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'
																,minDate:'#F{$dp.$D(\'hdjssj\') }'})" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align=right >
									<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add();">新增</a>
									<a class="easyui-linkbutton" data-options="iconCls:'icon-movedown'" 
									   onclick="fileDownload();">文书下载</a>
									<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query();">查询</a>
									<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="resetQuery();" >重置</a>
									<a class="easyui-linkbutton" data-options="iconCls:'icon-moveup'"  
									   onclick="fileUpload();" style="display: none" >文书上传</a>
								</td>
								<td class="toolbarTd"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		var windowID = null;
		function doInit(paramArray) {
			windowID = paramArray['windowID'];
		}
		var zzjgdmPd = "<%=userOrgCode%>";
	</script>
	<script type="text/javascript" src="<%=contextPath%>/js/zafffwqz/dxqzhdSplQuery.js"></script>
</html>