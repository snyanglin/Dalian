<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午13:15:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>民爆单位信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveMb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">爆破作业单位许可证类型：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="bpzydwxkzlxdm" name="bpzydwxkzlxdm" style="width:200px;" value="${entity.bpzydwxkzlxdm}" 
			    			data-options="url:contextPath+'/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">企业代号：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="qydh" name="qydh" style="width:200px;" value="${entity.qydh}" maxlength="30"
			    			data-options="required:false,validType:['letterOrNum'],tipPosition:'left'"/>
			    	</td>
			    </tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">作业地点：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="zydd" name="zydd" style="width:200px;" value="${entity.zydd}" maxlength="100"
							data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">技术负责人姓名：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jsfzrxm" name="jsfzrxm" style="width:200px;" value="${entity.jsfzrxm}"  
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">技术负责人公民身份号码：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jsfzrgmsfzhm" name="jsfzrgmsfzhm" style="width:200px;" value="${entity.jsfzrgmsfzhm}" maxlength="30"
							data-options="required:false,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">技术负责人联系电话：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jsfzrlxdh" name="jsfzrlxdh" style="width:200px;" value="${entity.jsfzrlxdh}" maxlength="30"
							data-options="required:false,validType:['phone'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">治安保卫负责人姓名：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="sfswdm" name="zabwfzrxm" style="width:200px;" value="${entity.zabwfzrxm}" 
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">治安负责人公民身份号码：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="zabwfzrgmsfzhm" name="zabwfzrgmsfzhm" style="width:200px;" value="${entity.zabwfzrgmsfzhm}" maxlength="30"
							data-options="required:false,tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">治安负责人联系电话：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="zabwfzrlxdh" name="zabwfzrlxdh" style="width:200px;" value="${entity.zabwfzrlxdh}"
							data-options="required:false,validType:['phone'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">净资产：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="jzc" name="jzc" style="width:200px;" value="${entity.jzc}"  maxlength="12"
							data-options="required:false,validType:['numeric[\'f\',2]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">专用设备净值（万元）：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="zysbjz" name="zysbjz" style="width:200px;" value="${entity.zysbjz}" maxlength="12"
							data-options="required:false,validType:['numeric[\'f\',2]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">银行账号：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="yhzh" name="yhzh" style="width:200px;" value="${entity.yhzh}"  maxlength="30"
							data-options="required:false,validType:['letterOrNum'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">申请资质等级：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="sqzzdj" name="sqzzdj" style="width:200px;" value="${entity.sqzzdj}" maxlength="50"
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">申请从业范围：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="sqcyfw" name="sqcyfw" style="width:200px;" value="${entity.sqcyfw}" maxlength="50"
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">申请日期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="sqrq" id="sqrq" class="easyui-validatebox" style="width: 200px;" value="${entity.sqrq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'zjqfrq\') }'})"/>
					</td>
					<td width="20%" class="dialogTd" align="right">证件签发日期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="zjqfrq" id="zjqfrq" class="easyui-validatebox" style="width: 200px;" value="${entity.zjqfrq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sqrq\') }'})"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">采矿许可证编号：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="ckxkzbh" name="ckxkzbh" style="width:200px;" value="${entity.ckxkzbh}"
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">采矿许可证有效期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="ckxkzyxq" id="ckxkzyxq" class="easyui-validatebox" style="width: 200px;" value="${entity.ckxkzyxq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sqrq\') }'})"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">煤炭生产许可证编号：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="mtscxkzbh" name="mtscxkzbh" style="width:200px;" value="${entity.mtscxkzbh}" maxlength="50"
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">煤炭生产许可证有效期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="mtscxkzyxq" id="mtscxkzyxq" class="easyui-validatebox" style="width: 200px;" value="${entity.mtscxkzyxq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sqrq\') }'})"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">安全生产许可证编号：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="aqscxkzbh" name="aqscxkzbh" style="width:200px;" value="${entity.aqscxkzbh}" maxlength="50"
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">安全生产许可证有效期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="aqscxkzyxq" id="aqscxkzyxq" class="easyui-validatebox" style="width: 200px;" value="${entity.aqscxkzyxq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sqrq\') }'})"/>
					</td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	$("#jsfzrgmsfzhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	$("#zabwfzrgmsfzhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
}

function beforeSubmit(){}

function afterSubmit(arr) {
	window.parent.location.reload();
}
</script>