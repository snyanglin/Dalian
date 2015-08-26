<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<%
/******************************************************************************
 * @JSPName:      [jhyxswList.jsp]   
 * @Description:  [集会游行示威显示页面]   
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
		<title>集会游行示威查询列表</title>
		<script type="text/javascript" src="<%=contextPath%>/js/jhyxsw/jhyxsw.js"></script>
		<script type="text/javascript">
		//组织机构代码
		var zzjgdm = "<%=userOrgCode%>";
		</script> 
	</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'集会游行示威列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/jhyxswjbxxb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'xt_zhxgsj',sortOrder:'desc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'xm',width:25,align:'center',sortable:true,halign:'center'">姓名</th>
				        	 <th data-options="field:'gmsfhm',width:25,align:'center',sortable:true,halign:'center'">身份证号</th>
				        	  <th data-options="field:'lxdh',width:25,align:'center',sortable:true,halign:'center'">联系电话</th>
				        	 <th data-options="field:'sqsj',width:20,align:'center',sortable:true,halign:'center'">申请时间</th>
				        	 <th data-options="field:'hdfsdm',width:25,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_AQFF_HDFS.js'">活动方式</th>
				        	 <th  data-options="field:'xt_lrrbmid',hidden:true">xt_lrrbmid</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1050" >
							<tbody align="center">
							<tr>
								<td class="toolbarTd" style="width:310px" align="right">
								活动方式：<input type="text" name="hdfsdm" id="hdfsdm"  class="easyui-combobox " style="width:160px;"
								             data-options="required:false,
								                         url: contextPath + '/common/dict/D_AQFF_HDFS.js',
								                         valueField:'id',
								                         textField:'text',
								                         tipPosition:'left',
								                         selectOnNavigation:true,
								                         method:'get'"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:310px" align="right">
								  申请人：<input type="text" name="xm" id ="xm" class="easyui-validatebox" style="width:160px" 
										    data-options="required:false,
										                  validType:'maxLength[20]'" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>																
								</tr>
								<tr>
									<td class="toolbarTd" style="width:310px" align="right">
								 申请时间-开始：<input class="easyui-validatebox" type="text" id="kssj" name="kssj" style="width:160px;" 
													data-options="validType:['date[\'yyyy-MM-dd\']'],
													              tipPosition:'right'" 
													              onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'jssj\') }'})"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:310px" align="right">
								 申请时间-结束 ：<input class="easyui-validatebox" type="text" id="jssj" name="jssj"  style="width:160px;" 
												data-options="validType:['date[\'yyyy-MM-dd\']'],
												              tipPosition:'right'" 
												              onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'kssj\') }'})"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd"   align="right" style="width:500px;">
									    <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="jhyxswAdd();">新增</a>
									    <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-movedown"  onclick="uploadFile();">文书下载</a>
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="fileUpload();" style="display: none"  >文书上传</a>										
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
