<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [wfxxList.jsp]   
 * @Description:  [物防信息显示页面]   
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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<title>物防信息查询</title>
	<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 30px;
	   border: 1px solid #95B8E7;
	   padding-left: 5px;
	   padding-top: 10px;
	   width:200px;
	}
	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	a img{border:0;}
	</style>
	<script type="text/javascript" src="<%=contextPath%>/js/wfxx/wfxxb.js"></script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url:contextPath+'/wfxx/queryWf',
            		toolbar:'#datagridToolbar',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'xt_zhxgsj',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2],
            		onLoadSuccess:function(data){ loadPoints();},
            		onSelect:onSelectRow,
            		fitColumns:true,
            		singleSelect:false
            		 ">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'wflx',width:100,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_ZAFF_WFLX.js'">物防类型</th>
				            <th data-options="field:'wfzl',width:100,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_ZAFF_WFZL.js'">物防种类</th>
				            <th data-options="field:'sl',width:40,align:'center',halign:'center',sortable:true">数量</th>
				            <th data-options="field:'dz_wfdzxz',width:220,align:'left',sortable:true,halign:'center',formatter:subjzdz,sortable:true">物防地址</th>
				            <th data-options="field:'zbx',hidden:true">zbx</th>
				            <th data-options="field:'zby',hidden:true">zby</th>
				            <th data-options="field:'process',width:150,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="right" >
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入物防数量、地址信息" 
									style="color:gray;height:32px;font-size:13px;width:220px" charSet="halfUpper" onclick="setDzqc(this)" onKeyPress="passwordOnkeyPress(this)" />
						</td>
						<td align="left">
							<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" 
									style="cursor: pointer;height:32px" onclick="searchMain();"/>
						</td>
						<td >
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="detailSearch()">精确查询</a>
						</td>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="wfxxbAdd();">新增</a>
						</td>
					</tr>
				</table>
			</div>
        </div>
    </div>   
    </div>
	    <input type="hidden" id ="zbz" value="">
	    <input type="hidden" id ="type" value="">
	    <input type="hidden" id ="mapRadius" value="">  
    <div id="win" class="easyui-window" title="物防精确查询" 
        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
		        closed:true,
		        top:100,
		        width:450,
        		height:280,
        		left:50" >   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
	        <form id ="queryForm" >
		        <table border="0" cellpadding="0" cellspacing="6" width="100%" height="100%" align="center">
	       			<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">物防类型：</td>
				    	<td width="70%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="wflx" name="wflx" style="width:150px;"
							data-options="url:contextPath+'/common/dict/D_ZAFF_WFLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false"/>
						</td>
			   		</tr>
		       		<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">物防种类：</td>
				    	<td width="70%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="wfzl" name="wfzl" style="width:150px;"
							data-options="url:contextPath+'/common/dict/D_ZAFF_WFZL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false"/>
						</td>
			   		</tr>	
		        	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">物防地址：</td>
				    	<td width="70%" class="dialogTd"><input type="text" name="dz_wfdzxz" id="dz_wfdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  style="width:150px;" /></td>
			    	</tr>
			    	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">安装日期：</td>
				    	
				    	<td width="70%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="azrq" name="azrq" style="width:150px;"
							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
				    	</td>
			    	</tr>	
			    	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">描述：</td>
				    	<td width="70%" class="dialogTd"><textarea name="ms" id ="ms" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:220px;height:80px;"></textarea></td>
			    	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    		<td width="100%" colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('win');">关闭</a>
				    		</td>
			    		</tr>
		         	</table>
		        </form>
	        </div>   
	    </div>   
</div>  
</body>
<script type="text/javascript">
//地址拆分
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");
</script>  
</html>