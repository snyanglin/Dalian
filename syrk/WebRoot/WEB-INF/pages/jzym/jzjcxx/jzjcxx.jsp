<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
<head>
<title></title>
	<script type="text/javascript">
	var sjOrgcode = "${sjOrgcode}"; 
	var sjOrgname = "${sjOrgname}";
	var bjzbz = "";
	var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
	var addressPrefixArray = addressPrefix.split(",");
	</script>
    <script type="text/javascript" src="<%=contextPath%>/js/jzym/jzjcxx.js"></script>
    
    <script type="text/javascript">
    <!--
	$(function(){
		//加载地图
		//Jzjcxx.onloadMap();
		$("#fsxj").combobox("setValue", "<%=userOrgCode%>");
		//加载统计
		Jzjcxx.queryJcxx();
	});
	    -->
    </script>
    
  </head>
  <body class="easyui-layout">   
    <div data-options="region:'west',title:'',split:false, border:0" style="width:280px; height:auto;">
    	<div id="gridDiv" style="width:100%; height:100%; background-color: #FFFFFF; display: none;">
    		<div class="easyui-layout" data-options="fit:true,border:false">
    		
	    		<div data-options="region:'center',split:false,title:'',border:false" style="height:auto">
	            	<table id="dg" class="easyui-datagrid" data-options="toolbar:'#datagridToolbar',
	            		singleSelect:true,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'id',sortOrder:'asc',fitColumns:true, 
	            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2],onClickRow:datagridOnClickRow,
	            		onLoadSuccess:function(data){ loadPoints(data);}">
	            	</table>
					
					<div id="datagridToolbar" style="padding:5px;height:auto">
						<!-- 表格工具条按钮 -->
						<table cellspacing="0" cellpadding="0" border="0">
						<tbody>
						<tr>
							<td class="toolbarTd" style="display: none;">
						    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery(this, 'queryWindow', 
						    		null,
						    		{
						    		title: '查询条件',
						    		url: contextPath + '/jzjcxx/syrkQueryCondition',
						    		width: 450,
						    		height: 300
						    		})">查询</a>
							</td>
							<td class="toolbarTd" style="display: none;"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd">
						    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="Jzjcxx.backJcxx()">返回</a>
							</td>
						</tr>
						</tbody>
						</table>
					</div>
				</div>

    		</div>
    	</div>
    	<div id="tjxxDiv" style="width:100%; height:100%; ">
	    	<div style="width:100%; background-color: #F4F4F4; border-bottom: 1px solid #95B8E7;">
		    	<table border="0" cellpadding="0" cellspacing="5" align="center">
		    	<tr class="dialogTr">
			    	<td width="70" class="dialogTd" align="right">分市(县)局</td>
			    	<td width="150" class="dialogTd"><input type="text" name="fsxj" id="fsxj" class="easyui-combobox" style="width:150px;" 
						data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:false,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,onChange:Jzjcxx.fsxj_onChange"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="70" class="dialogTd" align="right">所属派出所</td>
			    	<td width="150" class="dialogTd"><input type="text" name="pcs" id="pcs" class="easyui-combobox" style="width:150px;" 
						data-options="required:false,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false"></td>
		    	</tr>
		    	<tr class="dialogTr">
		    		<td colspan="2" align="center">
		    			<a id="queryBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick='$("#fsxj").combobox("setValue", "");'>
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">重置</span>
								<span class="l-btn-icon icon-reset"> </span>
							</span>
						</a>
						&nbsp;
						<a id="queryBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="Jzjcxx.queryJcxx()">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">查询</span>
								<span class="l-btn-icon icon-query"> </span>
							</span>
						</a>
		    		</td>
		    	</tr>
		    	</table>
	    	</div>
	        <ul id="tt" class="easyui-tree" style="padding-top:4px;">   
			    <li>   
			        <span id="orgZzjgmc" style="line-height: 17px;">${sjOrgname}</span>   
			        <ul>   
			            <li>   
			                <span>实有人口<span id='syrkNumId'></span></span>   
			                <ul>   
			                    <li>   
			                        <span>常住人口<span id='czrkNumId'></span></span>   
			                    </li>   
			                    <li>   
			                        <span>寄住人口<span id='jzrkNumId'></span></span>   
			                    </li>   
			                    <li>   
			                        <span>流动人口<span id='ldrkNumId'></span></span>   
			                    </li>  
			                    <li>   
			                        <span>境外人口<span id='jwrkNumId'></span></span>   
			                    </li>
			                    <li>   
			                        <span>未落户人口<span id='wlhrkNumId'></span></span>   
			                    </li>
			                </ul>   
			            </li>
			            <li>   
			                <span>重点人员<span id='zdrkNumId'></span></span>   
			                <ul>   
			                    <li>   
			                        <span>法轮功<span id='flgNumId'></span></span>   
			                    </li>   
			                    <li>   
			                        <span>监管对象<span id='jgdxNumId'></span></span>   
			                    </li>   
			                    <li>   
			                        <span>吸毒人员<span id='xdryNumId'></span></span>   
			                    </li>  
			                    <li>   
			                        <span>上访人员<span id='sfryNumId'></span></span>   
			                    </li>
			                    <li>   
			                        <span>其他<span id='qtgzdxNumId'></span></span>   
			                    </li>
			                </ul>   
			            </li> 
			            <li>   
			                <span>实有单位<span id='dwzsNumId'></span></span>  
			                <ul>   
			                    <li>   
			                        <span>旅店<span id='dwldNumId'></span></span> 
			                    </li>   
			                    <li>   
			                        <span>网吧<span id='dwwbNumId'></span></span> 
			                    </li>   
			                </ul>   
			            </li>  
			            <li>   
			                <span>实有房屋<span id='fwzsNumId'></span></span> 
			                <ul>   
			                    <li>   
			                        <span>出租房<span id='fwczfNumId'></span></span> 
			                    </li>
			                    <li>   
			                        <span>空置房<span id='fwkzfNumId'></span></span> 
			                    </li>   
			                </ul>   
			            </li>  
			            <li>   
			                <span>警情</span>
			                <ul>   
			                    <li>   
			                        <span>本年（<span id='aqbnNumId' style="color: red;font-weight: bold;"></span>）</span> 
			                    </li>   
			                    <li>   
			                        <span>本月（<span id='aqbyNumId' style="color: red;font-weight: bold;"></span>）</span> 
			                    </li>
			                    <li>   
			                        <span>本周（<span id='aqbzNumId' style="color: red;font-weight: bold;"></span>）</span> 
			                    </li>   
			                </ul>    
			            </li>  
			            <li>   
			                <span>案件</span>
			                <ul>   
			                    <li>   
			                        <span>本年（<span id='jqbzNumId' style="color: red;font-weight: bold;"></span>）</span>
			                    </li>   
			                    <li>   
			                        <span>本月（<span id='jqbyNumId' style="color: red;font-weight: bold;"></span>）</span>
			                    </li>
			                    <li>   
			                        <span>未破（<span id='jqwpNumId' style="color: red;font-weight: bold;"></span>）</span>
			                    </li>   
			                </ul>    
			            </li>
			        </ul>   
			    </li>   
			</ul>  
		</div>
    </div>
    <div data-options="region:'center',title:'地图区'" id="tdmapid">
         <div id="mapDiv" ></div>
         <div id="toolDiv" style="position: absolute;filter: alpha(opacity=90);"></div>
    </div>   
  </body>  
</html>