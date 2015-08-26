<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<%
/******************************************************************************
 * @JSPName:      [mdtjQuery.jsp]   
 * @Description:  [矛盾显示页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 
 */


%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>矛盾调解查询</title>
		<script type="text/javascript" src="<%=contextPath%>/js/mdtj/mdtj.js"></script>
		<script type="text/javascript">
		//组织机构代码
		var zzjgdm = "<%=userOrgCode%>";
		</script>
	</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'矛盾调解列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/mdxxb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'xt_zhxgsj',sortOrder:'desc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'mdlydm',width:25,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FWQZ_MDLY.js'">矛盾来源</th>
				        	 <th data-options="field:'mdgxgsdm',width:25,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FWQZ_GXGS.js'">矛盾管辖归属</th>
				        	 <th data-options="field:'mdlx',width:25,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FWQZ_MDLX.js'">矛盾类型</th>
				        	 <th data-options="field:'mdfssj',width:20,align:'center',sortable:true,halign:'center'">矛盾发生时间</th>
				        	 <th data-options="field:'mdfsddmc',width:25,align:'left',sortable:true,halign:'center'">矛盾发生地点</th>
				        	 <th data-options="field:'tjjgdm',width:25,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_FWQZ_TJJG.js'">调解结果</th>
				        	 <th data-options="field:'sfyjdm',width:25,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SF.js'">是否移交</th>
				        	 <th data-options="field:'mdyy',width:25,align:'left',sortable:true,halign:'center'">矛盾原因</th>
				        	 <th  data-options="field:'xt_lrrbmid',hidden:true">xt_lrrbmid</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1100">
							<tbody>
							<tr>
								<td class="toolbarTd" style="width:280px;padding-left:25px">
									矛盾来源：<input type="text" name="mdlydm" id ="mdlydm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_MDLY.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"
										style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:260px" text-align="center" >
										    矛盾管辖归属：<input type="text" name="mdgxgsdm" id ="mdgxgsdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_GXGS.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"
										style="width:160px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										矛盾类型：<input type="text" name="mdlx" id="mdlx" class="easyui-combobox" style="width:160px" 
											   data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_MDLX.js'
											   				,valueField:'id'
											   				,textField:'text'
											   				,tipPosition:'left'
											   				,selectOnNavigation:true
											   				,method:'get'" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								</tr>
								<tr>									
									<td class="toolbarTd" style="width:280px">
										矛盾发生时间：<input class="easyui-validatebox" type="text" id="mdfssj" name="mdfssj" style="width:160px;" value="${entity.startime}"
										          data-options="validType:['date[\'yyyy-MM-dd\']'],
										                        tipPosition:'right'" 
										                        onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:260px">
										矛盾发生地点：<input type="text" name="mdfsddmc" id ="mdfsddmc" class="easyui-validatebox" style="width:160px"
										           data-options="required:false,validType:'maxLength[20]'" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:240px">
										调解结果：<input type="text" name="tjjgdm" id ="tjjgdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_TJJG.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"
										style="width:160px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="right" >
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="mdtjAdd(this);">新增</a>							
									</td>
								</tr>							
							</tbody>
						</table>
					</form>
				</div>
			</div>
        </div>
    </div>   
</body>
</html>
