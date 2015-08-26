<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 下午14:31:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>保安员信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwxyaqxxbBay/save"  id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<input type="hidden" id="bayid" name="bayid"/>
				<input type="hidden" id="xt_zxbz" name="xt_zxbz"/>
				<input type="hidden" id="zjhmsx" name="zjhmsx"/>
				<input type="hidden" id="zjhmys" name="zjhmys" value="${entity.zjhm}"/>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="zjlxdm" name="zjlxdm" style="width:200px;" value="${entity.zjlxdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:zjhmCheck" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left">
			    		<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm}" maxlength="30" 
			    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div>
			    	</td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">曾用名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="cym" name="cym" style="width:200px;" value="${entity.cym }" maxlength="20" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">民族：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${entity.mzdm }"
						data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="csrq" name="csrq" style="width:200px;" value="${entity.csrq }" maxlength="20" 
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">文化程度：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combotree" type="text" id="xldm" name="xldm" value="${entity.xldm}" style="width:200px;"
						data-options="required:true,url: contextPath + '/common/dict/D_BZ_WHCD.js',onlyLeaf:true,multiple:false,required:false,panelWidth:220,
						method:'get',editable:true,lines:true"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">兵役状况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="byzkdm" name="byzkdm" style="width:200px;" value="${entity.byzkdm }" maxlength="20" 
			    		data-options="url: contextPath + '/common/dict/ZA_D_BYQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="hyzkdm" name="hyzkdm" style="width:200px;" value="${entity.hyzkdm }" maxlength="20" 
						data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">身高（CM）：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="sg" name="sg" style="width:200px;" value="${entity.sg }" maxlength="20" 
			    		data-options="required:false,validType:['naturalNumberRange[1,300]'],tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">血型：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xxdm" name="xxdm" style="width:200px;" value="${entity.xxdm }" maxlength="20" 
						data-options="url: contextPath + '/common/dict/ZA_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">健康状况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="jkzkdm" name="jkzkdm" style="width:200px;" value="${entity.jkzkdm }" maxlength="20" 
			    		data-options="url: contextPath + '/common/dict/D_RK_JKZK.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">政治面貌：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="zzmmdm" name="zzmmdm" style="width:200px;" value="${entity.zzmmdm }" maxlength="20" 
						data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">户籍地省市县：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="hjdssxdm" name="hjdssxdm" style="width:200px;" value="${entity.hjdssxdm }" maxlength="20" 
			    		data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:false,valueField:'id',textField:'text',selectOnNavigation:false"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">户籍地详址：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="hjdxz" name="hjdxz" style="width:200px;" value="${entity.hjdxz }" maxlength="40" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">现住址省市县：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xzzssxdm" name="xzzssxdm" style="width:200px;" value="${entity.xzzssxdm }" maxlength="20" 
			    		data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:false,valueField:'id',textField:'text',selectOnNavigation:false"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">现住址详址：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xzzxz" name="xzzxz" style="width:200px;" value="${entity.xzzxz }" maxlength="40" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">报名日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bmrq" name="bmrq" style="width:200px;" value="${entity.bmrq }" maxlength="20" 
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">准考证号：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zkzh" name="zkzh" style="width:200px;" value="${entity.zkzh }" maxlength="20" 
						data-options="required:false,validType:['letterOrNum'],tipPosition:'left'"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right">考试地点：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="ksdd" name="ksdd" style="width:200px;" value="${entity.ksdd }" maxlength="40" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">考试时间：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="kssj" name="kssj" style="width:200px;" value="${entity.kssj }" maxlength="20" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right">考试成绩：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="kscj" name="kscj" style="width:200px;" value="${entity.kscj }" maxlength="20" 
			    		data-options="required:false,validType:['naturalNumberRange[1,100000]'],tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">审查公安机关：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
			    		<input type="hidden" id="scgajgid" name="scgajgid" value="${entity.scgajgid }"/>
			    		<input class="easyui-validatebox  inputreadonly" type="text" id="scgajg" name="scgajg" style="width:200px;" value="${entity.scgajg }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'" readonly="readonly"/>
			    		<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'scgajgid', 'scgajg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
			    		　　　　　　&nbsp;&nbsp;审查结果：
			    	</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="scjg" name="scjg" style="width:200px;" value="${entity.scjg }" maxlength="20" 
						data-options="url: contextPath + '/common/dict/BD_D_SCJGDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">审查不通过原因：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<input class="easyui-combobox" type="text" id="scbtgyy" name="scbtgyy" style="width:200px;" maxlength="20"  value="${entity.scbtgyy}"
						data-options="url: contextPath + '/common/dict/BD_D_SCBTGYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">十指指纹捺印卡号：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="szzwaykh" name="szzwaykh" style="width:200px;" value="${entity.szzwaykh }" maxlength="20" 
			    		data-options="required:false,validType:['letterOrNum'],tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">指纹采集公安机关：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="hidden" id="zwcjgajgid" name="zwcjgajgid" value="${entity.zwcjgajgid }"/>
			    		<input class="easyui-validatebox  inputreadonly" type="text" id="zwcjgajg" name="zwcjgajg" style="width:150px;" value="${entity.zwcjgajg }" maxlength="12" 
						data-options="required:false,tipPosition:'left'" readonly="readonly"/>
						<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'zwcjgajgid', 'zwcjgajg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 40px;font-family:宋体;font-size:9pt;" />
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">指纹采集日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zwcjrq" name="zwcjrq" style="width:200px;" value="${entity.zwcjrq }" maxlength="20" 
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">保安员证编码：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bayzbh" name="bayzbh" style="width:200px;" value="${entity.bayzbh }" maxlength="20" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">发证机关：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
			    		<input type="hidden" id="fzjgid" name="fzjgid" value="${entity.fzjgid }"/>
			    		<input class="easyui-validatebox  inputreadonly" type="text" id="fzjg" name="fzjg" style="width:200px;" value="${entity.fzjg }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'" readonly="readonly"/>
			    		<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'fzjgid', 'fzjg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
			    		　　　　　　&nbsp;&nbsp;发证日期：
			    	</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="fzrq" name="fzrq" style="width:200px;" value="${entity.fzrq }" maxlength="20" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">保安员证撤销决定机关：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
			    		<input type="hidden" id="bayzcxjdjgid" name="bayzcxjdjgid" value="${entity.bayzcxjdjgid }"/>
			    		<input class="easyui-validatebox  inputreadonly" type="text" id="bayzcxjdjg" name="bayzcxjdjg" style="width:200px;" value="${entity.bayzcxjdjg }" maxlength="20" 
						data-options="required:false,tipPosition:'left'" readonly="readonly"/>
						<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'bayzcxjdjgid', 'bayzcxjdjg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
						　　　保安员证撤销日期：
					</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bayzcxrq" name="bayzcxrq" style="width:200px;" value="${entity.bayzcxrq }" maxlength="20" 
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">保安员证撤销原因：</td>
	 			    <td width="30%" class="dialogTd">
	 			    	<input class="easyui-combobox" type="text" id="bayzcxyy" name="bayzcxyy" style="width:200px;" maxlength="20"  value="${entity.bayzcxyy}"
						data-options="url: contextPath + '/common/dict/BD_D_BAYZCXYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">保安员证吊销决定机关：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="hidden" id="bayzdxjdjgid" name="bayzdxjdjgid" value="${entity.bayzdxjdjgid }"/>
			    		<input class="easyui-validatebox  inputreadonly" type="text" id="bayzdxjdjg" name="bayzdxjdjg" style="width:150px;" value="${entity.bayzdxjdjg }" maxlength="10" 
			    		data-options="required:false,tipPosition:'right'" readonly="readonly"/>
			    		<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'bayzdxjdjgid', 'bayzdxjdjg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 40px;font-family:宋体;font-size:9pt;" />
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">保安员证吊销日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bayzdxrq" name="bayzdxrq" style="width:200px;" value="${entity.bayzdxrq }" maxlength="20" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
					<td width="20%" class="dialogTd" align="right">保安员证吊销原因：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="bayzdxyy" name="bayzdxyy" style="width:200px;" maxlength="20"  value="${entity.bayzdxyy}"
						data-options="url: contextPath + '/common/dict/BD_D_BAYZDXYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">其他专业资格证名称：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="qtzyzgzmc" name="qtzyzgzmc" style="width:200px;" value="${entity.qtzyzgzmc }" maxlength="70" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">其他专业资格证号码：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="qtzyzgzhm" name="qtzyzgzhm" style="width:200px;" value="${entity.qtzyzgzhm }" maxlength="30" 
						data-options="required:false,validType:['letterOrNum'],tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">保安员职业技能等级：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="bayzyjndjdm" name="bayzyjndjdm" style="width:200px;" value="${entity.bayzyjndjdm }" maxlength="20" 
						data-options="url: contextPath + '/common/dict/BD_D_BAYZYJNDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">职业等级证书编码：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zydjzsbh" name="zydjzsbh" style="width:200px;" value="${entity.zydjzsbh }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">取得职业等级证书时间：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="qdzydjzssj" name="qdzydjzssj" style="width:200px;" value="${entity.qdzydjzssj }" maxlength="20" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
					<td width="20%" class="dialogTd" align="right">是否是信息员：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="sfsxxydm" name="sfsxxydm" style="width:200px;" value="${entity.sfsxxydm }"
			    		data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:sfsxxyOnchange"/>
					</td>
			    </tr>
			     <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">信息员批准公安机关：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
			    		<input type="hidden" id="xxypzgajgid" name="xxypzgajgid" value="${entity.xxypzgajgid}"/>
			    		<c:choose>
			    			<c:when test="${entity.sfsxxydm == '0'}">
			    				<table cellpadding="0" cellspacing="0" border="0">
			    					<tr>
			    						<td style="width: 200px;">
			    							<input class="easyui-validatebox  inputreadonly" type="text" id="xxypzgajg" name="xxypzgajg" style="width:200px;" value="${entity.xxypzgajg }" readonly="readonly"/>
			    						</td>
			    						<td style="width: 90px;">
			    							&nbsp;<input type="button" id="orgbutton12" style="display: none;" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'xxypzgajgid', 'xxypzgajg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 50px;font-family:宋体;font-size:9pt;" />
			    						</td>
			    						<td align="right">
			    							信息员批准日期：
			    						</td>
			    					</tr>
			    				</table>
			    			</c:when>
			    			<c:otherwise>
			    				<table cellpadding="0" cellspacing="0" border="0" width="100%">
			    					<tr>
			    						<td style="width: 200px;">
			    							<input class="easyui-validatebox  inputreadonly" type="text" id="xxypzgajg" name="xxypzgajg" style="width:200px;" value="${entity.xxypzgajg }" readonly="readonly"/>
			    						</td>
			    						<td style="width: 90px;">
			    							&nbsp;<input type="button" id="orgbutton12" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'xxypzgajgid', 'xxypzgajg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 50px;font-family:宋体;font-size:9pt;" />
			    						</td>
			    						<td align="right">
			    							信息员批准日期：
			    						</td>
			    					</tr>
			    				</table>
			    			</c:otherwise>
			    		</c:choose>
					</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xxypzrq" name="xxypzrq" style="width:200px;" value="${entity.xxypzrq }" maxlength="20" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >

var _p ;
var _zjhm = "";
function doInit(paramArray) {
	_p = paramArray["_p"];
	
	if($("#zjlxdm").combobox("getValue") == ""){
		$("#zjlxdm").combobox("setValue","111");
	}

	//人员信息复用
	$("#zjhm").bind("blur",function(e){ checkRyxx(); });
	initComboBox('hjdssxdm', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 
	initComboBox('xzzssxdm', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 
}

//保存之前查看该条保安员信息状态，注销标识为1则直接添加、0则通知管理员进行注销
function beforeSubmit(){
	var xt_zxbz = $("#xt_zxbz").val();
	var bayid = $("#bayid").val();
	var zjhmsx = $("#zjhmsx").val();
	var zjhmys = $("#zjhmys").val();
	if (bayid !="" && zjhmsx!=zjhmys && xt_zxbz == "0"){
		topMessager.confirm('操作确认', '已存在该保安员信息！是否通知管理员进行注销！',function(r) {
			if (r) {
				$.ajax({
					type:"POST",
					url: contextPath + "/dwxyaqxxbBay/savemessage",
					dataType:"json",
					data:"xm=" + $("#xm").val() + "&id=" + $("#bayid").val(),
					success:function(data) {
						alert("通知成功！");
					}
				});
			}
		});
		return false;
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.$("#bayxxb_datagrid").datagrid("reload");
	//$("#dataForm")[0].reset();
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearRyxx();
	$("#zjhm").val("");
	_zjhm = "";
}

/**
 * 人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dwxyaqxxbBay/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#zjlxdm").val(),
		success:function(data){
			if (data.entity!=null){
				$("#xm").val(data.entity.xm);
				$("#xbdm").combobox("setValue",data.entity.xbdm);
				$("#cym").val(data.entity.cym);
				$("#mzdm").combobox("setValue",data.entity.mzdm);
				$("#csrq").val(data.entity.csrq);
				$("#xldm").combotree("setValue",data.entity.xldm);
				$("#byzkdm").combobox("setValue",data.entity.byzkdm);
				$("#hyzkdm").combobox("setValue",data.entity.hyzkdm);
				$("#sg").val(data.entity.sg);
				$("#xxdm").combobox("setValue",data.entity.xxdm);
				$("#jkzkdm").combobox("setValue",data.entity.jkzkdm);
				$("#zzmmdm").combobox("setValue",data.entity.zzmmdm);
				$("#hjdssxdm").combobox("setValue",data.entity.hjdssxdm);
				$("#hjdxz").val(data.entity.hjdxz);
				$("#xzzssxdm").combobox("setValue",data.entity.xzzssxdm);
				$("#xzzxz").val(data.entity.xzzxz);
				$("#lxdh").val(data.entity.lxdh);
				$("#bmrq").val(data.entity.bmrq);
				$("#zkzh").val(data.entity.zkzh);
				$("#ksdd").val(data.entity.ksdd);
				$("#kssj").val(data.entity.kssj);
				$("#kscj").val(data.entity.kscj);
				$("#scgajg").val(data.entity.scgajg);
				$("#scjg").combobox("setValue",data.entity.scjg);
				$("#scbtgyy").combobox("setValue",data.entity.scbtgyy);
				$("#szzwaykh").val(data.entity.szzwaykh);
				$("#zwcjgajg").val(data.entity.zwcjgajg);
				$("#zwcjrq").val(data.entity.zwcjrq);
				$("#bayzbh").val(data.entity.bayzbh);
				$("#fzjg").val(data.entity.fzjg);
				$("#fzrq").val(data.entity.fzrq);
				$("#bayzcxjdjg").val(data.entity.bayzcxjdjg);
				$("#bayzcxrq").val(data.entity.bayzcxrq);
				$("#bayzcxyy").combobox("setValue",data.entity.bayzcxyy);
				$("#bayzdxjdjg").val(data.entity.bayzdxjdjg);
				$("#bayzdxrq").val(data.entity.bayzdxrq);
				$("#bayzdxyy").combobox("setValue",data.entity.bayzdxyy);
				$("#qtzyzgzmc").val(data.entity.qtzyzgzmc);
				$("#qtzyzgzhm").val(data.entity.qtzyzgzhm);
				$("#bayzyjndjdm").combobox("setValue",data.entity.bayzyjndjdm);
				$("#zydjzsbh").val(data.entity.zydjzsbh);
				$("#qdzydjzssj").val(data.entity.qdzydjzssj);
				$("#sfsxxydm").combobox("setValue",data.entity.sfsxxydm);
				$("#xxypzgajg").val(data.entity.xxypzgajg);
				$("#xxypzrq").val(data.entity.xxypzrq);
				$("#xt_zxbz").val(data.entity.xt_zxbz);
				$("#xt_zhxgrxm").val(data.entity.xt_zhxgrxm);
				$("#bayid").val(data.entity.id);
				$("#zjhmsx").val(data.entity.zjhm);
			}else if (data && data.ryRyjbxxb) {
				$("#xt_zxbz").val("");
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#mzdm").combobox("setValue",data.ryRyjbxxb.mzdm);
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
				if(data.ryRyjbxxb.csrq != ""){
					setInputReadonly("csrq", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("xbdm", true);
				}
				if(data.ryRyjbxxb.mzdm != ""){
					setInputReadonly("mzdm", true);
				}
			
			else{
				clearRyxx();
			}
		}},
		complete:function(){
			$("#yrjbxxDiv").hide();
		}
	});
}

//清空复用的人员基本信息
function clearRyxx(){
	$("#ryid").val("");
	$("#xm").val("");
	$("#xbdm").combobox("setValue","");
	$("#lxdh").val("");
}


//是否是信息员 隐藏或者显示相关项
function sfsxxyOnchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	if ($("#sfsxxydm").combobox('getValues') == "1") {
		setInputReadonly('xxypzrq', false);
		$("#orgbutton12").show();
	}else {
		setInputReadonly('xxypzrq', true);
		$("#xxypzrq").val("");
		$("#xxypzgajgid").val("");
		$("#xxypzgajg").val("");
		$("#orgbutton12").hide();
	}
}

</script>