<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 上午8:51:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-4 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	.imgStyle{
		height:19px;
		width:19px;
	}
</style>
</head>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydwlist.js"></script>
<body class="easyui-layout" data-options="fit:true">  
   <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto;overflow:hidden;">
            	<table id="dg" class="easyui-datagrid" 
            		data-options="url:'<%=basePath %>sydw/list',
            		delayCountUrl:'<%=basePath %>sydwcx/queryCountDw',
            		queryParams:{dwlbdm:'${dwlbdm}'},
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(120),
            		pageList:[getAutoPageSize(120),
            		getAutoPageSize(120) * 2],
            		onLoadSuccess:function(data){ loadpoints1(data);},
            		onSelect:onSelectRow,
            		singleSelect:true,
            		fitColumns:true,
            		rownumbers:true,
            		toolbar:'#datagridToolbar'">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'dwlbdm',	width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWLXDM.js',sortable:true">类别</th>
				            <th data-options="field:'dwmc',		width:120,align:'left',halign:'center',sortable:true">单位名称</th>
				            <th data-options="field:'dz_dwdzxz',	width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
				            <th data-options="field:'process',width:90,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
						<tr>
							<td align="right">
								<input type="text" class="searchText" name="condition"  id="condition" value="请输入单位名称、地址信息" 
										style="color:gray;height:32px;font-size:13px;width:240px"  onclick="setDzqc(this)" onkeydown="passwordOnkeyPress(this)" />
							</td>
							<td align="left">
								<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchMain();"/>
							</td>
							<td>
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-search" onclick="detailSearch()">精确查询</a>
							</td>
							<td>
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="syrkAdd();">新增</a>
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
    <!-- 精确查询框 -->
    <div id="win" class="easyui-window" title="实有单位精确查询" style="width:400px;height:350px;top:20px;display:none;"   
        data-options="iconCls:'icon-search',collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true,top:100,width:400,height:280,left:50">   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
		       <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				       <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位类型：</td>
					    	<td width="70%" class="dialogTd">
								<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
								 style="width:150px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
									method:'get',editable:true,lines:true"/>
							</td>
					   </tr>					      
				       <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位名称：</td>
					    	<td width="70%" class="dialogTd"><!-- data-options="url: contextPath + '/common/dict/D_RK_ZDRYLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
								<input  type="text" id="dwmc" name="dwmc" style="width:150px;"
									class="easyui-validatebox"  data-options="required:false,validType:'maxLength[20]'"/>
							 </td>
					   	</tr>	
				        <!--  <tr class="dialogTr">
						    	<td width="30%" class="dialogTd" align="right">单位别名：</td>
						    	<td width="70%" class="dialogTd"><input type="text" name="dwbm"  id ="dwbm" class="easyui-validatebox" 
						    		data-options="required:false,validType:'maxLength[20]'"  style="width:150px;" /></td>
					    </tr>-->
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位地址：</td>
					    	<td width="70%" class="dialogTd">
					    		<input type="text" id="dz_dwdzxz" name="dz_dwdzxz" class="easyui-validatebox" 
					    			data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" />
					    	</td>
					   </tr>	
					   <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">经营范围(主营)：</td>
					    	<!-- data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
					    	<td width="70%" class="dialogTd">
					    		<input type="text" id="jyfwzy" name="jyfwzy" style="width:150px;" class="easyui-validatebox" 
					    			data-options="required:false,validType:'maxLength[30]'"/>
					    	</td>
					    </tr>
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">经营性质：</td>
					    	<td width="70%" class="dialogTd">
					    		<input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" style="width:150px;"
									data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
							</td>
					    </tr>
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位地址状态：</td>
					    	<td width="70%" class="dialogTd">
						    	<input type='checkbox' id='ybzdz'/>有标准地址 
						    	<input type='checkbox' id='wbzdz'/>无标准地址
					    	</td>
					    </tr>
					    <tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td width="100%" colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
					    	</td>
					    </tr>
			         </table>
			      </form>
	        </div>   
	   </div>   
		</div>  
			<div id="winDel" class="easyui-window" title="实有单位注销" style="width:500px;height:200px"   
		      data-options="iconCls:'icon-save',modal:true,closed:true,collapsible:false,minimizable:false, maximizable:false"> 
		      	<table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
		      		<tr>
			      		<td align="left"> 
				      		 注销原因：
			      		</td>
			      	</tr>
			      	<tr>
			      		<td align="center"> 
				       		<textarea id="xt_zxyy"  title="添加注销原因"
				       			class="easyui-validatebox" style="width: 423px; height:82px;"
								data-options="required:true,validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'right'">
							</textarea>
			      		</td>
			      	</tr>
			      	<tr>
			      		<td align="right">
			      			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="del_div_qd(this, '+index+')">确定</a>
							<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="del_div_qx()">关闭</a>
				       	</td>
				   	</tr>
		   		</table>
			</div> 
</body>
<script type="text/javascript">
var Globalsydwlx = '${dwlbdm}';
//---------------框查-----
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");
</script>  

</html>