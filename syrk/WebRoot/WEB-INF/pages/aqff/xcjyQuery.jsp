<!--  
	@Author:       [wu.w@founder.com.cn]
	@CreateDate:   [2015-5-15 上午8:51:54]
	* @review      : tian_chengwei@founder.com.cn
    * @reviewDate  : 20150604
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
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
		<title>宣传教育-列表</title>
	</head>
	<body class="easyui-layout" data-options="fit:true">  
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'宣传教育-列表',border:true" style="height:auto">
	            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/aqffxcjy/queryList',
	            		toolbar:'#datagridToolbar',
	            		singleSelect:true,selectOnCheck:true,
	            		checkOnSelect:true,border:false,
	            		sortName:'kzrq',sortOrder:'asc',
	            		idField:'id',pageSize:getAutoPageSize(),
	            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
					    <thead>
					        <tr>
					        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
					        	<th data-options="field:'id',hidden:true"></th>
					        	<th data-options="field:'xt_lrrbmid',hidden:true"></th>
					        	<th data-options="field:'xcjyzt',width:25,align:'center',sortable:true,halign:'center'">宣传教育主题</th>
					        	<th data-options="field:'xcjynr',width:25,align:'center',sortable:true,halign:'center'">宣传教育内容</th>
					        	<th data-options="field:'kzrq',width:25,align:'center',sortable:true,halign:'center'">开展日期</th>
					        	<th data-options="field:'xcjyxs',width:15,align:'center',sortable:true,halign:'center'
					        					 ,formatter:dictFormatter
					        					 ,dictName:contextPath+'/common/dict/D_AQFF_XCJYXS.js'">宣传教育形式</th>
					        	<th data-options="field:'trjf',width:15,align:'center',sortable:true,halign:'center'">投入经费</th>
					        	<th data-options="field:'jyqzrs',width:15,align:'center',sortable:true,halign:'center'">教育群众人数</th>
					        	<th data-options="field:'jydwsl',width:15,align:'center',sortable:true,halign:'center'">教育单位数量</th>
					        	<th data-options="field:'dz',width:25,align:'center',sortable:true,halign:'center'">地址</th>
					        	<th data-options="field:'bz',width:25,align:'center',sortable:true,halign:'center'">备注</th>
					            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
					        </tr>
					    </thead>
					</table>
					<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
						<form id="queryForm">
							<table cellspacing="0" cellpadding="0" border="0" width="1100">
								<tbody>
									<tr>
										<td class="toolbarTd" style="width:300px" align="right">
											宣传教育主题：<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   							id="qxcjyzt" data-options="required:false,validType:'maxLength[50]'"/>
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
										<td class="toolbarTd" style="width:300px" align="right">
											开展日期：<input type="text" class="easyui-validatebox " style="width:200px;" id="qkzrq" 
													      data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
													      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
										<td class="toolbarTd" style="width:300px" align="right">
											宣传教育形式：<input type="text" id="qxcjyxs" class="easyui-combobox" 
														    style="width:200px"  
														    data-options="required:false
														   				 ,url: contextPath + '/common/dict/D_AQFF_XCJYXS.js'
														   				 ,valueField:'id'
														   				 ,textField:'text'
														   				 ,tipPosition:'left'
														   				 ,selectOnNavigation:false
														   				 ,method:'get'" />
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									</tr>
									<tr>
										<td class="toolbarTd" style="width:300px" align="right">
											责任民警：<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   						  id="qzrmj" data-options="required:false,validType:'maxLength[50]'"/>
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
										<td class="toolbarTd" style="width:300px" align="right">
										<td class="toolbarTd"></td>
										<td class="toolbarTd" align=right>
											<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" 
											   onclick="openEditWin();">新增</a>
											<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" 
											   onclick="query();">查询</a>
											<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" 
											   onclick="resetQuery();" >重置</a>
										</td>
										<td class="toolbarTd"></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
	        </div>
	    </div>
	    <div id="editDiv">
	    	<form id="editForm" method="post">
	    		<input type="hidden" id="eid" name="id" />
	    		<table border="0" cellpadding="0" cellspacing="10" width="800px" align="center">
    				<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">宣传教育主题：</td>
						<td width="80%" class="dialogTd" colspan="3">
							<input class="easyui-validatebox" type="text" style="width:595px" 
			  					   name="xcjyzt" id="excjyzt" data-options="required:true,validType:'maxLength[50]'"/>
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">宣传教育内容：</td>
						<td width="80%" class="dialogTd" colspan="3" >
							<textarea class="easyui-validatebox" style="width: 595px; height:48px;" 
									  id="excjynr" name="xcjynr"
									  data-options="validType:['maxLength[1000]']
									  				,invalidMessage:'宣传教育内容不能超过1000个汉字，请重新输入！'
									  				,tipPosition:'left'" ></textarea>
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">开展日期：</td>
						<td width="30%" class="dialogTd">
							<input type="text" class="easyui-validatebox " style="width:200px;" 
								   name="kzrq" id="ekzrq" 
								   data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
								   onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
						</td> 
						<td width="20%" class="dialogTd" align="right">宣传教育形式：</td>
						<td width="30%" class="dialogTd">
							<input type="text" name="xcjyxs" id="excjyxs" class="easyui-combobox" 
								   style="width:200px"  
								   data-options="required:false
								   				,url: contextPath + '/common/dict/D_AQFF_XCJYXS.js'
								   				,valueField:'id'
								   				,textField:'text'
								   				,tipPosition:'left'
								   				,selectOnNavigation:false
								   				,method:'get'" />
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">投入经费：</td>
						<td width="30%" class="dialogTd">
			  				<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   name="trjf" id="etrjf" 
			  					   data-options="required:false,validType:['naturalNumber','maxLength[8]']"/>
						</td> 
						<td width="20%" class="dialogTd" align="right"></td>
						<td width="30%" class="dialogTd">
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">教育群众人数：</td>
						<td width="30%" class="dialogTd">
			  				<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   name="jyqzrs" id="ejyqzrs" 
			  					   data-options="required:false,validType:['naturalNumber','maxLength[10]']"/>
						</td> 
						<td width="20%" class="dialogTd" align="right">教育单位数量：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   name="jydwsl" id="ejydwsl" 
			  					   data-options="required:false,validType:['naturalNumber','maxLength[5]']"/>
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">地址：</td>
						<td width="80%" class="dialogTd" colspan="3">
							<input class="easyui-combobox" style="width:595px;" id="edz" 
								   data-options="required:false
								   				,mode:'remote'
								   				,method:'post'
								   				,panelHeight: 22
								   				,valueField:'id'
								   				,validType:'maxLength[100]'
								   				,textField:'text'
								   				,selectOnNavigation:false">
					    	<input type='hidden' name='dz' id="hdz"/>
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">备注：</td>
						<td width="80%" class="dialogTd" colspan="3" >
							<textarea class="easyui-validatebox" style="width: 595px; height:48px;" 
									  id="ebz" name="bz"
									  data-options="validType:['maxLength[1000]']
									  				,invalidMessage:'备注不能超过1000个汉字，请重新输入！'
									  				,tipPosition:'left'" ></textarea>
						</td>
					</tr>
	    		</table>
	    		<div align="center" style="width: 760px;margin: 10px 0 0 0" id="edit_btn_div">
		    		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="save();" >保存</a>
		    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    		<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="resetEdit();" >重置</a>
		    	</div>
	    	</form>
	    </div>
	</body>
	<script type="text/javascript">
		var zzjgdmPd = "<%=userOrgCode%>";
	</script>
	<script type="text/javascript" src="<%=contextPath%>/js/aqff/xcjy.js"></script> 
</html>