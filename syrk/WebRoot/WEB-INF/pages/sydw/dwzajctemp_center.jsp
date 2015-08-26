<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>单位治安管理模板</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'单位治安管理模板',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dwjctemp/queryDwjctype',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'sydwlx,px',sortOrder:'asc',fitColumns:true,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'name',width:18,align:'left',halign:'center'">类目内容</th>
				            <th data-options="field:'sydwlx',width:10,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWLXDM.js'">单位类别</th>
				            <th data-options="field:'ywlbdm',width:15,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_YWLBDM.js'">业务类别</th>
				            <th data-options="field:'process1',align:'center',halign:'center',formatter:processFormater1">操作</th>
				            <th data-options="field:'process3',align:'center',halign:'center',formatter:processFormater3">检查项管理</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="
					    	var ywlbdm = $('#ywlbdm').val();var sydwlx = $('#sydwlx').val();
					    	datagridAdd(this, 'addWindow', 
					    		{ywlbdm:ywlbdm,sydwlx:sydwlx},
					    		{
					    		title: '类目管理新增',
					    		url: contextPath + '/forward/sydw|dwjctypeAdd',
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		)">添加</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-preview" plain="true" onclick="preview();">预览</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'',
					    		{
					    		url: contextPath + '/dwjctemp/deletePatchDwjctype'
					    		})">批量删除</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="toolbarTd">
							<form id="queryForm">
								<table cellspacing="0" cellpadding="0" border="0">
									<tbody>
										<tr class="dialogTr">
											<td width="70" class="dialogTd" align="right">类目内容：</td>
											<td width="120" class="dialogTd"><input class="easyui-validatebox" type="text" id="name" style="width:120px;"/></td>
					    					<td width="75" class="dialogTd">（模糊查询）</td>
											<td width="70" class="dialogTd" align="right">单位类型：</td>
											<td width="160" class="dialogTd">
												<input type="hidden" id="ywlbdm" name="ywlbdm"/>
												<input type="hidden" id="sydwlx" name="sydwlx"/>
												<input class="easyui-combotree" type="text" id="sydwlx-box" style="width:150px;" data-options="url: contextPath + '/common/dict/BD_D_MDWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:265,
										    	method:'get',editable:true,lines:true,onSelect:function(record){$('#ywlbdm').val(record.py);var sydwlx = record.id.replace('_'+record.py,'');$('#sydwlx').val(sydwlx);}"/>
										    </td>
										</tr>
									</tbody>
								</table>
							</form>
						</td>
						<td class="toolbarTd">
							<a class="easyui-linkbutton" href="javascript:void(0)" iconCls="icon-reset" onclick="resetButton()">重置</a>
					    	<a class="easyui-linkbutton" href="javascript:void(0)"  iconCls="icon-query" onclick="queryButton()">查询</a>
						</td>
					</tr>
					</tbody>
					</table>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwzajctemp_center.js"></script>
</html>