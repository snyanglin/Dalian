<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 下午14:31:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>证券/保险业单位特殊信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveZjbxy" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;margin-top:5px;text-align: center;">
		    <fieldset style="width: 90%;">
	  			<legend>证券/保险业单位特殊信息</legend>
	  			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
		    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
		    		<input type="hidden" name="flag" id="flag" value="${flag}" />
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">所属监管机构：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox '  data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='ssjgjg'  style="width:200px;" value="${entity.ssjgjg}" />
						</td>
						<td width="20%" class="dialogTd" align="right">是否独立保卫机构：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="sfdlbwjg" name="sfdlbwjg"  style="width:200px;" value="${entity.sfdlbwjg}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">所在地派出所：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox '  data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='szdpcs'  style="width:200px;" value="${entity.szdpcs}" />
						</td>
						<td width="20%" class="dialogTd" align="right">是否治安保卫重点单位：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="sfzabwzddw" name="sfzabwzddw"  style="width:200px;" value="${entity.sfzabwzddw}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">重要部位数：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['naturalNumberRange[0,1000]'],tipPosition:'left'" 
							type='text' name='zybws'  style="width:200px;" value="${entity.zybws}" />
						</td>
						<td width="20%" class="dialogTd" align="right">在册职工数：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'" 
							type='text' name='zczgs'  style="width:200px;" value="${entity.zczgs}" />
						</td>
				    </tr>
				    <tr class="dialogTr">
				   		<td width="20%" class="dialogTd" align="right">治安保卫重点单位级别：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='zabwzddwjb'  style="width:200px;" value="${entity.zabwzddwjb}" />
						</td>
						<td width="20%" class="dialogTd" align="right">是否平安单位：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="sfpadw" name="sfpadw"  style="width:200px;" value="${entity.sfpadw}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">固定资产（万元）：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['numeric[\'f\',2]'],invalidMessage:'注册资金为两位小数的金额，请重新输入！',tipPosition:'right'" type='text' maxlength="12"
							name='gdzc'  style="width:200px;" value="${entity.gdzc}" />
						</td>
						<td width="20%" class="dialogTd" align="right">是否建立警务工作站：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="sfjljwgzs" name="sfjljwgzs"  style="width:200px;" value="${entity.sfjljwgzs}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
				    <td width="20%" class="dialogTd" align="right">主管保卫负责人姓名：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox '  data-options="validType:['maxLength[50]'],tipPosition:'right'"  type='text' 
							name='zgbwfzrxm'  style="width:200px;" value="${entity.zgbwfzrxm}" />
						</td>
					 	<td width="20%" class="dialogTd" align="right">主管保卫负责人身份证号：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="tipPosition:'left'" type='text' 
							name='zgbwfzrsfzh'  id='zgbwfzrsfzh' style="width:200px;" value="${entity.zgbwfzrsfzh}" />
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">主管保卫负责人职务：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'"  type='text' 
							name='zgbwfzrzw'  style="width:200px;" value="${entity.zgbwfzrzw}" />
						</td>
					 	<td width="20%" class="dialogTd" align="right">主管保卫负责人联系方式：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['phone'],required:false,tipPosition:'left'" type='text' maxlength="30"
							name='zgbwfzrlxfs'  style="width:200px;" value="${entity.zgbwfzrlxfs}" />
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">监督内保部门：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'"  type='text' 
							name='fzzdjdganbbm'  style="width:200px;" value="${entity.fzzdjdganbbm}" />
						</td>
					 	<td width="20%" class="dialogTd" align="right">监督内保部门责任民警：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" type='text' 
							name='fzzdjdganbbmzrmj'  style="width:200px;" value="${entity.fzzdjdganbbmzrmj}" />
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">监督内保部门联系方式：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['phone'],required:false,tipPosition:'left'" type='text'  maxlength="30"
							name='fzzdjdganbbmlxfs'  style="width:200px;" value="${entity.fzzdjdganbbmlxfs}" />
						</td>
						<td width="20%" class="dialogTd" align="right">是否注销：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="sfzx" name="sfzx"  style="width:200px;" value="${entity.sfzx}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">注销日期：</td>
						<td width="30%" class="dialogTd">
							<input type="text" name="zxrq" id="zxrq" class="easyui-validatebox" style="width: 200px;" value="${entity.zxrq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
						</td>
						<td width="20%" class="dialogTd" align="right">注销原因：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[300]'],required:false ,tipPosition:'right'" type='text' 
							name='zxyy'  style="width:200px;" value="${entity.zxyy}" />
						</td>
				    </tr>    
				    <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">备注：</td>
						<td width="80%" class="dialogTd"  colspan="3">
							<textarea class="easyui-validatebox" type="text" data-options="validType:['maxLength[300]'],tipPosition:'right'"  id="bz" name="bz" style="width:580px;height: 30px;">${entity.bz}</textarea>
						</td>
					</tr>
		    	</table>
	  		</fieldset>
	 		<span style="width: 200px;">&nbsp;</span>
			<fieldset style="width: 90%;">
				<legend>重要部位信息</legend>
				<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">部位编号：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='bwbh' style="width:200px;" value="${entity.bwbh}" />
						</td>
						<td width="20%" class="dialogTd" align="right">部位名称：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='bwmc' style="width:200px;" value="${entity.bwmc}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">部位位置：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='bwwz' style="width:200px;" value="${entity.bwwz}" />
						</td>
						<td width="20%" class="dialogTd" align="right">负责人：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='bwfzr' style="width:200px;" value="${entity.bwfzr}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">负责人身份证号：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['naturalNumber'],required:false ,tipPosition:'right'"
							type='text' name='bwfzrsfzh' id='bwfzrsfzh' style="width:200px;" value="${entity.bwfzrsfzh}" />
						</td>
						<td width="20%" class="dialogTd" align="right">负责人职务：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'left'"
							type='text' name='bwfzrzw' id ='bwfzrzw' style="width:200px;" value="${entity.bwfzrzw}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">负责人联系方式：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['phone'],tipPosition:'right'"
							type='text' name='bwfzrlxfs' style="width:200px;" maxlength="30" value="${entity.bwfzrlxfs}" />
						</td>
						<td width="20%" class="dialogTd" align="right">值班电话：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['phone'],tipPosition:'left'"
							type='text' name='bwzbdh' style="width:200px;" maxlength="30" value="${entity.bwzbdh}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">物防设施情况：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],tipPosition:'right'" 
							type='text' name='wfssqk' style="width:200px;" value="${entity.wfssqk}" />
						</td>
						<td width="20%" class="dialogTd" align="right">确定时间：</td>
						<td width="30%" class="dialogTd">
							<input type="text" name="bwqdsj" id="bwqdsj" class="easyui-validatebox" style="width: 200px;" value="${entity.bwqdsj}"
							data-options="required:false,validType:['date[\'yyyy-MM-dd \']']"
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="dialogTd" align="right">确定理由依据：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="validType:['maxLength[100]'],tipPosition:'right'" 
							type='text' name='bwqdlyyj' style="width:200px;"
							value="${entity.bwqdlyyj}" />
						</td>
					</tr>
				</table>
			</fieldset>
		    <span style="width: 200px;">&nbsp;</span>  
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
function doInit(paramArray) {
	_p = paramArray["_p"];
	$("#zgbwfzrsfzh").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	$("#bwfzrsfzh").validatebox({validType:['sfzh'],charSet:'halfUpper'});
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	window.parent.location.reload();
}
</script>