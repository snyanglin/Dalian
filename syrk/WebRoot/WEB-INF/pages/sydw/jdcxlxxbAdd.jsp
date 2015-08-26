<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 下午14:31:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-5 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机动车修理信息</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/jdcxlxxbAdd.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jdcxlxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
    	<input type="hidden" name="flag" id="flag" value="${flag}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:628px;" readonly="readonly" /></td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否专修店：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sfzxddm" name="sfzxddm" style="width:200px;" value="${entity.sfzxddm}"
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						required:true,tipPosition:'left'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">是否连锁店：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sflsddm" name="sflsddm" style="width:200px;" value="${entity.sflsddm}"
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						required:true,tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否备案：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sfbadm" name="sfbadm" style="width:200px;" value="${entity.sfbadm}"
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onSelect: sfba,
						required:true,tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">备案单位：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
				    	<input class="easyui-validatebox " type="text" id="ba_dwmc" name="ba_dwmc" style="width:628px;" value="${entity.ba_dwmc}" 
				    	data-options="required:false,validType:['maxLength[100]'],invalidMessage:'备案单位不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
			    	</td>
				</tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">修理范围：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea name="xlfw"  id="xlfw"  maxlength="2000" class="easyui-validatebox" style="width: 628px; height:48px;"
						data-options="required:true,validType:['maxLength[2000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.xlfw}</textarea>
					</td>
				</tr>
	   	   	    <tr class="dialogTr">
		    	    <td width="16%" class="dialogTd" align="right">备注：</td>
		    	    <td width="80%" class="dialogTd" colspan="5">
		    	    	<textarea id="bz" name="bz" class="easyui-validatebox" rows="2" style="width:627px; height:48px;"
						data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
				</td>
   	       </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
