<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [tjxxAdd.jsp]   
 * @Description:  [矛盾-调节添加页面]   
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
		<title>调解信息新增</title>
		<script type="text/javascript" src="<%=contextPath%>/js/mdtj/tjxx.js"></script>
	</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>tjxxzb/saveTjxxzb" id="dataForm" name="dataForm" method="post">
	    	<input type="hidden" name="mdjfxxid" id="mdjfxxid" value="${entity.mdjfxxid}" />
	    	<input type="hidden" name="flag" id="flag" value="${flag}" />
	    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">调解单位名称：</td>
						<input class="easyui-validatebox-delay" type="hidden" name="tjdwid" id="jwry_tjdwid" value="${entity.tjdwid}" />
					<td width="80%" class="dialogTd" colspan="3">
						<input type="text" name="dwmc" id="dwmc" class="easyui-combobox" style="width: 613px;" value="${entity.tjdwmc }" maxlength="100"
							 data-options="mode:'remote',method:'post',panelHeight: 22,
							 valueField:'id',textField:'text',selectOnNavigation:false,required:false" />
		    			<input type="hidden" name="tjdwmc" id="tjdwmc" value="${entity.tjdwmc}"/></td>
    			</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">调解时间：</td>
					<td width="30%" class="dialogTd">
						<input  type="text" id="tjsj" name="tjsj" class="easyui-validatebox" style="width:200px;" maxlength="19" value="${entity.tjsj}"
							  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
							  data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/></td>	
					<td width="20%" class="dialogTd" align="right">调解结果：</td>
					<td width="30%" class="dialogTd">
						<input type="text" name="tjjgdm" id="tjjgdm" value="${entity.tjjgdm}" class="easyui-combobox " style="width:200px;"
								data-options="required:true,url: contextPath + '/common/dict/D_FWQZ_TJJG.js',
								valueField:'id',textField:'text',tipPosition:'right',selectOnNavigation:false,method:'get',onSelect: fstj" /></td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">调解地点：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<input  type="text" id="tjdd" name="tjdd" class="easyui-validatebox" style="width:613px;" 
								data-options="required:false,tipPosition:'left'" maxlength="100" value="${entity.tjdd}" /></td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">调解处理信息：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<input  type="text" id="tjclxx" name="tjclxx" class="easyui-validatebox" style="width:613px;" maxlength="200" value="${entity.tjclxx}" /></td>
				</tr>
				<tr class="dialogTr">
				 	<td width="20%" class="dialogTd" align="right">调解人：</td>
					<td width="30%" class="dialogTd">
						<input  type="text" id="tjr" name="tjr" class="easyui-validatebox" style="width:200px;"maxlength="200" value="${entity.tjr}" /></td>
					<td width="20%" class="dialogTd" align="right">未调解工作计划：</td>
					<td width="30%" class="dialogTd">
					<input  type="text" id="wtjgzjh" name="wtjgzjh" class="easyui-validatebox" style="width:200px;"maxlength="200" value="${entity.wtjgzjh}" /></td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</body>
</html>
