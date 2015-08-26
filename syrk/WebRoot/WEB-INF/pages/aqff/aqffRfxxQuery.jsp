<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-6-14 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
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
		<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydw.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aqff/rfxx/aqffRfxxQuery.js"></script>
		<script type="text/javascript">
			  var markerArr = new Array();
			  var dz_dwdzdmArr = new Array();
			  var Globalsydwlx = '${dwlbdm}';
		</script>
	</head>
	<body class="easyui-layout" data-options="fit:true">  
		<div data-options="region:'center',border:false">
    		<div class="easyui-layout" data-options="fit:true,border:false">   
            	<div data-options="region:'center',split:true,title:'',border:false" style="height:auto;overflow:hidden;">
	            	<table id="dg" class="easyui-datagrid" 
	            	data-options="url:'<%=basePath %>rfxxb/queryMHRfInfo',
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
	            		onSelect:onSelectRow,
	            		singleSelect:true,
	            		fitColumns:true,
	            		rownumbers:true,
	            		toolbar:'#datagridToolbar'">
	            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    	<thead>
					        <tr>
					            <th data-options="field:'ffzzxsdm',	width:5,	align:'center' ,sortable:true,halign:'center',formatter:dictFormatter,
					            dictName:contextPath+'/common/dict/D_ZAFF_ZZXS.js'">组织形式</th>
					            <th data-options="field:'zzmc', width:10,	align:'left',	halign:'center',sortable:true">组织名称</th>
								<th data-options="field:'xt_lrrbm', width:10,	align:'left',	halign:'center',sortable:true">管辖责任区</th>
					            <th data-options="field:'process',width:5,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
					        </tr>
				    	</thead>
					</table>
					<div id="datagridToolbar" style="padding:5px;height:auto">
						<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
							<tr>
								<td align="right" >
									<input type="text" class="searchText" name="condition"  id="condition" value="请输入人员姓名、身份证号、组织名称" 
											style="color:gray;height:32px;font-size:13px;width:240px"  onclick="setDzqc(this)" onkeydown="passwordOnkeyPress(this)" />
								</td>
								<td align="left">
									<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" 
											style="cursor: pointer;height:32px" onclick="searchMain();"/>
								</td>
								<td>
									<a href="javascript:void(0)" class="easyui-linkbutton" 
										 iconCls="icon-search" onclick="detailSearch()">精确查询</a>
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
    	<div id="win" class="easyui-window" title="人防信息精确查询" style="width:400px;height:1000px;top:20px;display:none;"   
	        data-options="iconCls:'icon-search',
	        collapsible:false,
	        minimizable:false,
	        maximizable:false,
	        modal:true,
	        closed:true,
	        top:100,
	        width:400,
	        height:380,
	        left:50">   
				<div class="easyui-layout" data-options="fit:true">   
	        		<div data-options="region:'left'">  
						<form id ="queryForm" >
			        		<table border="0" cellpadding="0" cellspacing="10" width="100%" height="80%" align="center">
				       			<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">组织名称：</td>
							    	<td width="70%" class="dialogTd">
										<input class="easyui-validatebox" type="text" id="zzmc" name="zzmc"
										 style="width:150px;"
										data-options="required:false,validType:'maxLength[20]'"/>
									</td>
								</tr>					      
			       				<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">组织类别：</td>
							    	<td width="70%" class="dialogTd">
										<input  type="text" id="zzlbdm" name="zzlbdm" style="width:150px;"
										class="easyui-combobox" 
										data-options="required:false,url: contextPath + '/common/dict/BD_D_ZZLB.js',
					    				valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
									</td>
					   			</tr>	
					    		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">组织形式：</td>
							    	<td width="70%" class="dialogTd">
							    		<input type="text" id="ffzzxsdm" name="ffzzxsdm" class="easyui-combobox"  style="width:150px;"
							    		 data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_ZZXS.js',
						    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',
						    			onSelect:function(newValue,oldValue){}"/>
							    	</td>
					    		</tr>	
						   		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">组织人员来源：</td>
							    	<td width="70%" class="dialogTd">
							    		<input type="text" id="ffzrrryly" name="ffzrrryly" style="width:150px;"
							    		class="easyui-combotree" 
							    		data-options="required:false,url: contextPath + '/common/dict/D_AQFF_RYLYDM.js',
										onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:265,
										method:'get',editable:true,lines:true"/>
							    	</td>
						    	</tr>
					    		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">组织地址：</td>
							    	<td width="70%" class="dialogTd">
								    	<input class="easyui-validatebox" type="text" id="dz_zzdzmlpxz" 
								    	name="dz_zzdzmlpxz" style="width:150px;"
										data-options="required:false,validType:'maxLength[20]'"/>
									</td>
					    		</tr>
					    		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">是否治安承包：</td>
							    	<td width="70%" class="dialogTd">
								    	<input class="easyui-combobox" type="text" id="sfzacbdm" 
								    	name="sfzacbdm" style="width:150px;"
										data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',
						    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',
						    			onSelect:function(newValue,oldValue){}"/>
									</td>
					    		</tr>
					    		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">管辖分县局：</td>
							    	<td width="70%" class="dialogTd">
										<input id="cc1" class="easyui-combobox" value="210200000000" style="width:150px;"
							         data-options="valueField: 'id',textField: 'text',url: '<%=basePath %>gzjk/queryOrg',onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
									</td>
					    		</tr>
					    		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">管辖派出所：</td>
							    	<td width="70%" class="dialogTd">
							    	<input id="cc2" class="easyui-combobox" style="width:150px;"
											data-options="valueField:'id', textField:'text',onSelect: function(rec1){var url = '<%=basePath %>gzjk/queryOrgLowest?orgCode='+rec1.id;$('#cc3').combobox('reload',url);}" />
									</td>
					    		</tr>
					    		<tr class="dialogTr">
							    	<td width="30%" class="dialogTd" align="right">管辖责任区：</td>
							    	<td width="70%" class="dialogTd">
										<input id="cc3" class="easyui-combobox" style="width:150px;" data-options="valueField:'id',textField:'text'" />
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
			<div id="del_div" style="width:200px;height:150px">
				<textarea id="xt_zxyy" name="wlrk.xt_zxyy" 
				class="easyui-validatebox" style="width: 160px; 
				height:70px;overflow: auto;" data-options="required:true,validType:['maxLength[100]'],
				invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
				<input type="button" onclick="del_div_qd()" value ="确定"/>
				<input type="button" onclick="del_div_qx()"  value ="取消"/>
			</div>
		</body>
</html>