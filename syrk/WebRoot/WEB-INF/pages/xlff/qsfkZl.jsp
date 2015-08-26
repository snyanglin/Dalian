<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String username = "";
    String userorg = "";
    String orgcode = "";
    if(userInfo!=null){
        username = userInfo.getUserName();
        userorg = userInfo.getUserOrgNameQc();
        orgcode = userInfo.getUserOrgCode();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet" type="text/css" />
    <title>签收反馈</title>
    <script type="text/javascript">
    <!--
       var username = "<%=username%>"; 
       var userorg = "<%=userorg%>";
       var orgcode = "<%=orgcode%>";
    //-->
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/xlff/qsfkZl.js"></script>
    <style type="text/css">
     #表头样式
     a{text-decoration:none;}
     span.zao{font-size: 12px; color: '#007BE3'; font-weight: bold;}
    </style>
  </head>
  <body class="easyui-layout" data-options="fit:true">
  <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">
  			<div data-options="region:'center',split:true, title:'指令列表',border:false" style="height:auto">
  			<table id="rwlb" class="easyui-datagrid" 
            	data-options="
            	    url:'<%=basePath%>fkzl/queryZlqsfkList',
	           		toolbar:'#datagridToolbar',
	           		border:false,
	           		rownumbers: true,
	           		sortName:'xfsj',
	           		sortOrder:'desc',
	           		pageSize:getAutoPageSize(180),
	           		pageList:[getAutoPageSize(180),
	           		getAutoPageSize(180) * 2],
	           		singleSelect:true,
	           		fitColumns:true">
	           		<!-- onClickRow:doOnClickRow 单击行事件 --> 
			    <thead>
			        <tr>
			            <th data-options="field:'fkjb',width:50,align:'center',halign:'center', sortable:true, formatter:dictFormatter,dictName:contextPath+'/common/dict/D_XLFF_FKJB.js'"><span class="zao">防控级别</span></th>
			            <th data-options="field:'bt',width:100,align:'center',halign:'center'"><span class="zao">标题</span></th>
			            <th data-options="field:'nr',width:200,align:'center',halign:'center',formatter:dbrwStyler"><span class="zao">内容</span></th>
			            <th data-options="field:'xfsj',width:50,align:'center',halign:'center', formatter:formatDate, sortable:true"><span class="zao">下发时间</span></th>
			            <th  data-options="field:'qsfkzt',width:50,align:'center',halign:'center',hidden:true">签收反馈</th>
			            <th  data-options="field:'id',width:50,align:'center',halign:'center',hidden:true">id</th>
			            <th  data-options="field:'qsr',width:50,align:'center',halign:'center',hidden:true">qsr</th>
			            <th  data-options="field:'qssj',width:50,align:'center',halign:'center',hidden:true">qssj</th>
			            <th  data-options="field:'qsdwmc',width:50,align:'center',halign:'center',hidden:true">qsdwmc</th>
			            <th  data-options="field:'true',width:50,align:'center',halign:'center',formatter:zlqsfk"><span class="zao">操作</span></th>
			        </tr>
			    </thead>
			</table>
  			<div id="datagridToolbar" style="padding:5px;height:20">
	  			<form id ="queryForm">
	   			<table border="0" cellpadding="0" cellspacing="10" align="left">
					<tr>
						<td nowrap="nowrap" align="right">标题：</td>
						<td>
							<input type="text" name="bt" id="bt" class="easyui-validatebox" style="width:100px" 
								value="${entity.bt}" data-options="required:false,tipPosition:'bottom'" maxlength="400"/>
						</td>
						<td nowrap="nowrap" align="right">防控级别：</td>
						<td><input class="easyui-combobox" type="text" id="fkjb" name="fkjb" style="width:100px" value="${entity.rwzt}"
								data-options="url: contextPath + '/common/dict/D_XLFF_FKJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
						</td>
						<td nowrap="nowrap" align="right">发送时间起：</td>
						<td>
							<input type="text" name="fssj" id="fssj" class="easyui-validatebox"  style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'right',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.xfsjB}"/>
						</td>
						<td nowrap="nowrap" align="right">发送时间止：</td>
						<td>
							<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'right',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.xfsjE}"/>
						</td>
						<td nowrap="nowrap" colspan="8" align="right">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						</td>
					</tr>
				</table>
	   		</form>
			</div>
		</div>
      </div>
      <!-- 签收 -->
      <div id="dd">
		<form action="<%=basePath%>fkzl/updateZlqsfk" id="dataform" name="dataform" method="post">
		<input id="id" name="id" type="hidden" />
		<input id="qsfkzt" name="qsfkzt" type="hidden" />
		<input id="qsdwdm" name="qsdwdm" type="hidden" />
	    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">防控级别：</td>
				<td width="80%" class="dialogTd" colspan="5"><input class="easyui-combobox" type="text" name="fkjb" id='fkjbs' style="width:550px" 
					readonly="true"	data-options="url: contextPath + '/common/dict/D_XLFF_FKJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">标题 ：</td>
				<td width="80%" class="dialogTd" colspan="5"><input name="bt" id='bts' maxlength="200" class="easyui-validatebox" 
					readonly="true" style="width: 550px;" data-options="validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'">${entity.bt}</input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">指令内容：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="nr" id='nrs' maxlength="200" class="easyui-validatebox" 
					readonly="true" style="width: 550px; height:96px;" data-options="validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'">${entity.xxnr}</textarea>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">签收人：</td>
				<td width="20%" class="dialogTd" colspan="">
					<input name="qsr"  id="qsr"  maxlength="200" class="easyui-validatebox" 
						readonly="true" style="width: 207px;"></input>
				</td>
				<td width="20%" class="dialogTd" align="right">签收时间：</td>
				<td width="20%" class="dialogTd" colspan="">
					<input name="qssj"  id="qssj"  maxlength="200" class="easyui-validatebox" 
					  readonly="true" style="width: 207px;"></input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="10%" class="dialogTd" align="right">签收单位：</td>
				<td width="20%" class="dialogTd" colspan="5">
					<input id="qsdwmc" name="qsdwmc"  maxlength="200" class="easyui-validatebox" 
						readonly="true" style="width: 550px;" data-options="required:false,validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'"></input>
				</td>
	    	</tr>
	    	<tr>
				<td nowrap="nowrap" colspan="6" align="center">
					<a class="easyui-linkbutton" iconCls="icon-add" onclick="sendButton();" id="send">
						签收
					</a>
				    &nbsp;&nbsp;
		    		<a class="easyui-linkbutton" iconCls="icon-no" onclick="$('#dd').dialog('close');" id="resets">
		    			关闭
		    		</a>
				</td>
			</tr>
	    </table>
    	</form>
	</div>
	<!-- 反馈 -->
	<div id="dds">
		<form action="<%=basePath%>fkzl/updateZlqsfk" id="dataforms" name="dataforms" method="post">
	    <input id="idss" name="id" type="hidden" />
		<input id="qsfkztss" name="qsfkzt" type="hidden" />
		<input id="fkdwdm" name="fkdwdm" type="hidden" />
		<input id="fksj" name="fksj" type="hidden" />
		<input id="fkr" name="fkr" type="hidden" />
		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">防控级别：</td>
				<td width="80%" class="dialogTd" colspan="5"><input class="easyui-combobox" type="text" name="fkjb" id='fkjbss' style="width:550px" value=""
						readonly='true' data-options="url: contextPath + '/common/dict/D_XLFF_FKJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">标题 ：</td>
				<td width="80%" class="dialogTd" colspan="5"><input name="bt" id='btss' maxlength="200" class="easyui-validatebox" 
					readonly='true'  style="width: 550px;" data-options="validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'"></input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">发送内容：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="nr" id='nrss' maxlength="200" class="easyui-validatebox" 
					readonly='true' style="width: 550px; height:96px;" data-options="validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'">${entity.xxnr}</textarea>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">签收人：</td>
				<td width="20%" class="dialogTd" colspan="">
					<input name="qsr"  id='qsrss' maxlength="200" class="easyui-validatebox" 
					 readonly='true' style="width: 207px;"></input>
				</td>
				<td width="20%" class="dialogTd" align="right">签收时间：</td>
				<td width="20%" class="dialogTd" colspan="">
					<input name="qssj" id='qssjss' maxlength="200" class="easyui-validatebox" 
					readonly='true' style="width: 207px;"></input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="10%" class="dialogTd" align="right">签收单位：</td>
				<td width="20%" class="dialogTd" colspan="5">
					<input name="qsdwmc" id='qsdwmcss'   maxlength="200" class="easyui-validatebox" 
					readonly='true' style="width: 550px;" data-options="validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'"></input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="10%" class="dialogTd" align="right">反馈单位：</td>
				<td width="20%" class="dialogTd" colspan="5">
					<input name="fkdwmc" id='fkdwmc' maxlength="200" class="easyui-validatebox" 
					readonly='true' style="width: 550px;" data-options="validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'"></input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">反馈意见：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="fkyj"  maxlength="200" class="easyui-validatebox" 
					style="width: 550px; height:96px;" data-options="required:true,validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'"></textarea>
				</td>
	    	</tr>
	    	<tr>
				<td nowrap="nowrap" colspan="6" align="center">
					<a class="easyui-linkbutton" iconCls="icon-add" onclick="sendButtons();" id="sends">
						反馈
					</a>
				    &nbsp;&nbsp;
		    		<a class="easyui-linkbutton" iconCls="icon-no" onclick="$('#dds').dialog('close');" id="resets">
		    			关闭
		    		</a>
				</td>
			</tr>
	    </table>
    	</form>
	</div>
</div>     			
</body>
</html>
