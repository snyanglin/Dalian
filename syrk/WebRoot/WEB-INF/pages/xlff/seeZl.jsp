<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String orgcode = "";
    String orgFlag = "";
    if(userInfo!=null){
        orgcode = userInfo.getUserOrgCode();
        String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
		String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		// 登陆者若是公安局则组织机构选择为分局；分局则组织机构选择为派出所； 
		if (zero8.equals("00000000")) {
			orgFlag = "FJ";
		} else if(zero6.equals("000000")){
			orgFlag = "PCS";
		}
    }
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet" type="text/css" />
    <title>指令下发列表</title>
    <script type="text/javascript">
    	//组织机构标志
    	var orgFlag = "<%=orgFlag%>";
    	//组织机构代码
    	var orgcode = "<%=orgcode%>";
    </script>	
    <script type="text/javascript" src="<%=contextPath%>/js/xlff/seeZl.js"></script>
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
            	    url:'<%=basePath%>fkzl/queryZlxfList',
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
			            <th data-options="field:'fkjb',width:50,align:'center', halign:'center', sortable:true, formatter:dictFormatter,dictName:contextPath+'/common/dict/D_XLFF_FKJB.js'"><span class="zao">防控级别</span></th>
			            <th data-options="field:'bt',width:100,align:'center',halign:'center'"><span class="zao">标题</span></th>
			            <th data-options="field:'nr',width:200,align:'center',halign:'center',formatter:nrStyler"><span class="zao">指令内容</span></th>
			            <th data-options="field:'xfdwmc',width:200,align:'center',halign:'center'"><span class="zao">下发单位</span></th>
			            <th data-options="field:'xfsj',width:50,align:'center',halign:'center',formatter:formatDate, sortable:true"><span class="zao">下发时间</span></th>
			            <th data-options="field:'id',width:50,align:'center',halign:'center',hidden:true">id</th>
			        </tr>
			    </thead>
			</table>
  			<div id="datagridToolbar" style="padding:0px;height:20">
	  			<form id ="queryForm">
	   			<table border="0" cellpadding="0" cellspacing="10" align="left">
					<tr>
						<td nowrap="nowrap" align="right">标题：</td>
						<td>
							<input type="text" name="bt" id="bt" class="easyui-validatebox" style="width:100px" 
								value="${entity.bt}" data-options="required:false,tipPosition:'bottom'" maxlength="400"/>
						</td>
						<td nowrap="nowrap" align="right">防控级别：</td>
						<td><input class="easyui-combobox" type="text" id="fkjb" name="fkjb" style="width:100px" value="${entity.fkjb}"
								data-options="url: contextPath + '/common/dict/D_XLFF_FKJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
						</td>
						<td class="dialogTd" align="right">下发单位：</td>
						<td>
						<!-- 登陆者若是公安局则组织机构选择为分局；分局则组织机构选择为派出所； -->
						<c:set var="orgFlag" scope="session" value="<%=orgFlag%>"></c:set>
						<c:choose>
                           <c:when test="${orgFlag == 'FJ'}">
                           		<input id="orgcode1" class="easyui-combobox" method='get'
						         data-options="valueField: 'id',textField: 'text',width:100px, url: '<%=basePath %>gzjk/queryOrg'"/>
                           </c:when>
                           <c:otherwise>
								<input id="orgcode2" class="easyui-combobox" method='get'
								data-options="valueField:'id', width:'100px', textField:'text', url:'<%=basePath %>gzjk/queryOrgLower?orgCode=' + orgcode " />
						   </c:otherwise>
                        </c:choose>
                        </td>
                        </tr>
                        <tr>
						<td nowrap="nowrap" align="right">发送时间起：</td>
						<td>
							<input type="text" name="fssj" id="fssj" class="easyui-validatebox"  style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'right',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.fssj}"/>
						</td>
						<td nowrap="nowrap" align="right">发送时间止：</td>
						<td>
							<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:100px" 
							 	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="required:false,tipPosition:'right',
							 	validType:['date[\'yyyy-MM-dd\']']" style="" value="${entity.rwjssj}"/>
						</td>
						<td nowrap="nowrap" colspan="10" align="right">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						    <a class="easyui-linkbutton" iconCls="icon-save" onclick="saveButton();">新增</a>
						</td>
					</tr>
				</table>
	   		</form>
			</div>
		</div>
      </div>
      <div id="dd">
		<form action="<%=basePath%>fkzl/saveZlxf" id="dataform" name="dataform" method="post">
	    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">防控级别：</td>
				<td width="80%" class="dialogTd" colspan="5">
					<input class="easyui-combobox" type="text" name="fkjb" style="width:550px" value="${entity.fkjb}"
						data-options="required:true,url: contextPath + '/common/dict/D_XLFF_FKJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" maxlength="100"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">标题 ：</td>
				<td width="80%" class="dialogTd" colspan="5">
					<input name="bt" maxlength="200" class="easyui-validatebox" 
					style="width: 550px;" data-options="required:true,validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'">${entity.bt}</input>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">发送内容：</td>
				<td width="80%" class="dialogTd" colspan="5"><textarea name="nr" id="nrs" maxlength="200" class="easyui-validatebox" 
					style="width: 550px; height:96px;" data-options="required:true,validType:['maxLength[200]'],
					invalidMessage:'检查对象不能超过200个汉字，请重新输入！',tipPosition:'right'"></textarea>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">下发单位：</td>
				<td width="80%" class="dialogTd" colspan="5">
					<table border="0" cellpadding="0" cellspacing="0">
	    		<tr>
	    			<td width="500" style="display: none;">
	    				<textarea class="easyui-validatebox" rows="3" id="xfdwdms" name="xfdwdm" maxlength="400" data-options="required:true,validType:['maxLength[400]'], invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'right'"
	    					style="width:500px; height:72px;" readonly="readonly"></textarea>
	    			</td>
	    			<td width="500">
	    				<textarea class="easyui-validatebox" rows="3" id="xfdwmcs" name="xfdwmc" maxlength="400" data-options="required:true,validType:['maxLength[400]'], invalidMessage:'检查对象不能超过400个汉字，请重新输入！',tipPosition:'right'"
	    					style="width:500px; height:72px;" readonly="readonly"></textarea>
	    			</td>
	    			<td>
	    				<!-- 登陆者若是公安局则组织机构选择为分局；分局则组织机构选择为派出所； -->
	    				<c:set var="orgFlag" scope="session" value="<%=orgFlag%>"></c:set>
						<c:choose>
                           <c:when test="${orgFlag == 'FJ'}">
								<input type="button" id="orgbutton23" class="butSelect2" 
					    			onClick="public_multiSelectOrg('', '01', '21', '', 'xfdwdms', 'xfdwmcs', '', false, false, '', window, 'onOrgUserSelected', '')" />
                           </c:when>
                           <c:otherwise>
                           		<input type="button" id="orgbutton34" class="butSelect2" 
					    			onClick="public_multiSelectOrg('210200000000', '01', '32', '01,04', 'xfdwdms', 'xfdwmcs', '', false, false, '', window, 'onOrgUserSelected', '')" />
        				   </c:otherwise>
                        </c:choose>
				    </td>
	    		</tr>
	    		</table>
				</td>
	    	</tr>
	    	<tr>
				<td nowrap="nowrap" colspan="6" align="center">
					<a class="easyui-linkbutton" iconCls="icon-add" onclick="sendButton();" id="send">
						发送
					</a>
					&nbsp;&nbsp;
		    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButtons();" id="resets">
		    			重置
		    		</a>
				</td>
			</tr>
	    </table>
    	</form>
		</div>
	</div>     			
</body>
</html>
