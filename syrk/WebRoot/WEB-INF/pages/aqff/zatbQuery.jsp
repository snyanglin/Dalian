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
    String userOrgName = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName=userInfo.getUserOrgName();
    }
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>治安通报-列表</title>
	</head>
	<body class="easyui-layout" data-options="fit:true">  
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'治安通报-列表',border:true" style="height:auto">
	            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/aqffzatb/queryList',
	            		toolbar:'#datagridToolbar',
	            		singleSelect:true,selectOnCheck:true,
	            		checkOnSelect:true,border:false,
	            		sortName:'tbrq',sortOrder:'asc',
	            		idField:'id',pageSize:getAutoPageSize(),
	            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
					    <thead>
					        <tr>
					        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
					        	<th data-options="field:'id',hidden:true"></th>
					        	<th data-options="field:'xt_lrrbmid',hidden:true"></th>
					        	<th data-options="field:'tbrq',width:15,align:'center',sortable:true,halign:'center'">通报日期</th>
					        	<th data-options="field:'tbqh',width:25,align:'center',sortable:true,halign:'center'">通报期号</th>
					        	<th data-options="field:'tbbt',width:25,align:'center',sortable:true,halign:'center'">通报标题</th>
					        	<th data-options="field:'fbdw',width:25,align:'center',sortable:true,halign:'center'">发布单位</th>
					        	<th data-options="field:'fbfs',width:15,align:'center',sortable:true,halign:'center'">发布份数</th>
					        	<th data-options="field:'tbnr',width:30,align:'center',sortable:true,halign:'center'">通报内容</th>
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
											通报日期：<input type="text" class="easyui-validatebox " style="width:200px;" id="qtbrq" 
													      data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
													      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
										<td class="toolbarTd" style="width:300px" align="right">
											通报期号：<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   							id="qtbqh" data-options="required:false,validType:'maxLength[50]'"/>
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
										<td class="toolbarTd" style="width:300px" align="right">
											发布单位：<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   						  id="qfbdw" data-options="required:false,validType:'maxLength[50]'"/>
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									</tr>
									<tr>
										<td class="toolbarTd" style="width:300px" align="right">
											通报标题：<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   						  id="qtbbt" data-options="required:false,validType:'maxLength[50]'"/>
										</td>
										<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
										<td class="toolbarTd" style="width:300px" align="right"></td>
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
			  			<td width="20%" class="dialogTd" align="right">通报日期：</td>
						<td width="30%" class="dialogTd">
							<input type="text" class="easyui-validatebox " style="width:200px;" 
								   name="tbrq" id="etbrq" 
								   data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
								   onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
						</td> 
						<td width="20%" class="dialogTd" align="right">通报期号：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   name="tbqh" id="etbqh" 
			  					   data-options="required:false,validType:['maxLength[50]']"/>
						</td>
					</tr>
    				<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">通报标题：</td>
						<td width="80%" class="dialogTd" colspan="3">
							<input class="easyui-validatebox" type="text" style="width:595px" 
			  					   name="tbbt" id="etbbt" data-options="required:true,validType:'maxLength[50]'"/>
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">通报内容：</td>
						<td width="80%" class="dialogTd" colspan="3" >
							<textarea class="easyui-validatebox" style="width: 595px; height:48px;" 
									  id="etbnr" name="tbnr"
									  data-options="validType:['maxLength[1000]']
									  				,invalidMessage:'通报内容不能超过1000个汉字，请重新输入！'
									  				,tipPosition:'left'" ></textarea>
						</td>
					</tr>
					<tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">发布单位：</td>
						<td width="30%" class="dialogTd">
			  				<input class="easyui-validatebox" type="text" style="width:160px" name="fbdw" id="efbdw" 
			  					   data-options="required:false,validType:['maxLength[50]']"/>
			  				<input type="button" id="efbdw_selbtn" value="选择" 
			  					   onClick="public_singleSelectOrg('<%=userOrgCode%>', '01', '', ''
			  					   			, '', 'efbdw', '', false, false, '', window, '', '')" 
			  					   style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; 
			  					   		  WIDTH: 48px;font-family:宋体;font-size:9pt;" />
						</td> 
						<td width="20%" class="dialogTd" align="right">发布份数：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" style="width:200px" 
			  					   name="fbfs" id="efbfs" 
			  					   data-options="required:false,validType:['naturalNumber','maxLength[10]']"/>
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
		var userOrgName='<%=userOrgName%>';
		var zzjgdmPd = "<%=userOrgCode%>";
	</script>
	<script type="text/javascript" src="<%=contextPath%>/js/aqff/aqtb.js"></script> 
</html>