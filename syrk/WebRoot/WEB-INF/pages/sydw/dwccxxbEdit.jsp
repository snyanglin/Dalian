<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位仓储</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwccxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<input type="hidden" name="flag" id="flag" value="${flag}"/>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:620px;" readonly="readonly" />
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">仓储名称：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="ccmc" name="ccmc" value="${entity.ccmc }" maxlength="30" style="width:620px;" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'" />
		    	</td>
	    	</tr>
			 <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">仓储地址：</td>
		    	<td width="50%" class="dialogTd" colspan="2">
				  	<input class="easyui-combobox" id="ccd1" style="width:400px;" value="${entity.dz_ccdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    <input type='hidden' name='dz_ccdzmlpdm' id="dz_ccdzmlpdm" value="${entity.dz_ccdzmlpdm}"/>
				    <input type='hidden' name='dz_ccdzmlpxz' id="dz_ccdzmlpxz" value="${entity.dz_ccdzmlpxz}"/>
				  </td>
		    	<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" id="ccd2" style="width:200px;" value='${fn:replace(entity.dz_ccdzxz, entity.dz_ccdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type="hidden" name="dz_ccdzdm" id="dz_ccdzdm" value="${entity.dz_ccdzdm}"/>
					<input type="hidden" name="dz_ccdzxzqhdm" id="dz_ccdzxzqhdm" value="${entity.dz_ccdzxzqhdm}"/>
			    	<input type='hidden' name='dz_ccdzxz' id="dz_ccdzxz" value="${entity.dz_ccdzxz}"/>
				</td>
	    	</tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">占地面积：</td>
				<td width="30%" class="dialogTd">
					<input class='easyui-validatebox ' type='text' name='zdmj' id="zdmj" data-options="validType:['numericRange[\'f\',2,0]'],invalidMessage:'请输入正确的数据格式,确保其包含两位小数!'" maxlength="12" style="width:200px;" value="${entity.zdmj}" />
				</td>
				<td width="20%" class="dialogTd" align="right">建筑面积：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="jzmj" name="jzmj" maxlength="12" style="width:200px;" data-options="validType:['numericRange[\'f\',2,0]'],invalidMessage:'请输入正确的数据格式,确保其包含两位小数!',tipPosition:'left'" value="${entity.jzmj}"/>
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">是否独立仓储：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class='easyui-combobox' type='text' name='sfdlccdm' id="sfdlccdm" value="${entity.sfdlccdm}" style="width:200px;"
		    	    data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">启用时间：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class='easyui-validatebox ' type='text' name='qysj' id="qysj" style="width:200px;" value="${entity.qysj}" 
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
		     </tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">使用期限：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class='easyui-validatebox ' type='text' name='ysqx'  id="ysqx" style="width:200px;" value="${entity.ysqx}" 
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"/>
				</td>
		     </tr>
			 <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">仓储物品：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="ccwp" name="ccwp" value="${entity.ccwp }" maxlength="300" style="width:620px;"  />
		    	</td>
	    	 </tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">仓储面积：</td>
				<td width="30%" class="dialogTd">
					<input class='easyui-validatebox ' type='text' name='ccmj' id="ccmj" data-options="validType:['numericRange[\'f\',2,0]'],invalidMessage:'请输入正确的数据格式,确保其包含两位小数!'" maxlength="12" style="width:200px;" value="${entity.ccmj}" />
				</td>			
				<td width="20%" class="dialogTd" align="right">仓储容积：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="ccrj" name="ccrj" maxlength="12" style="width:200px;" data-options="validType:['numericRange[\'f\',2,0]'],invalidMessage:'请输入正确的数据格式,确保其包含两位小数',tipPosition:'left'" value="${entity.ccrj}"/>
				</td>
			</tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">仓储数量：</td>
				<td width="30%" class="dialogTd">
					<input class='easyui-validatebox ' type='text' name='ccsl' id="ccsl" data-options="validType:['naturalNumber'],required:false,charSet:'halfUpper'" maxlength="12" style="width:200px;" value="${entity.ccsl}" />
				</td>			
				<td width="20%" class="dialogTd" align="right">数量单位：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="sldw" name="sldw" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="${entity.sldw}"/>
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">消防设备情况：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="xfsbqk" name="xfsbqk" style="width: 620px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'消防设备情况不能超过1000个汉字，请重新输入！',tipPosition:'left',required:false">${entity.xfsbqk}</textarea>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">值更人员信息：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="zgryxx" name="zgryxx" value="${entity.zgryxx }" maxlength="2000" data-options="charSet:'halfUpper'" style="width:620px;"  /></td>
	    	 </tr>
	    	<tr class="dialogTr">
			   <td width="20%" class="dialogTd" align="right">仓储值班室电话：</td>
			   <td width="30%" class="dialogTd">
			   		<input class="easyui-validatebox "  type="text" id="cczbsdh" name="cczbsdh" maxlength="18" style="width:200px;"  value="${entity.cczbsdh}" data-options="validType:['phone'],charSet:'halfUpper'" />
			   </td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">库管人员信息：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="kgryxx" name="kgryxx" value="${entity.kgryxx }" maxlength="2000" data-options="charSet:'halfUpper'" style="width:620px;"  />
		    	</td>
	    	 </tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">仓储负责人常用证件：</td>
		    	<input type="hidden" name="ccfzrid" id="ccfzrid" value="${entity.ccfzrid}" />
		    	<td width="30%" class="dialogTd">
		    		<input class='easyui-combobox' type='text' name='ccfzrcyzjdm' id="ccfzrcyzjdm" value="${entity.ccfzrcyzjdm}" style="width:200px;"
		    	    data-options="required:false,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:zrrdm_onchange"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">仓储负责人证件号码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class='easyui-validatebox' type='text' name='ccfzrzjhm' id="ccfzrzjhm" value="${entity.ccfzrzjhm}" style="width:200px;float:left;" onblur="cczgrzjhm_onblur()" maxlength="30"
		    	    data-options="required:false,charSet:'halfUpper',tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div>
		    	</td>
		  </tr>
		  <tr class="dialogTr">
			   <td width="20%" class="dialogTd" align="right">仓储负责人：</td>
			   <td width="30%" class="dialogTd">
			   		<input class="easyui-validatebox "  type="text" id="ccfzr" name="ccfzr" data-options="charSet:'halfUpper'" maxlength="20" style="width:200px;"  value="${entity.ccfzr}" />
			   </td>
			   <td width="20%" class="dialogTd" align="right">仓储负责人职务：</td>
			   <td width="30%" class="dialogTd">
			   		<input class="easyui-validatebox "  type="text" id="ccfzrzw" name="ccfzrzw" data-options="charSet:'halfUpper'" maxlength="20" style="width:200px;"  value="${entity.ccfzrzw}" />
			   </td>
		  </tr>
		  <tr class="dialogTr">
			   <td width="20%" class="dialogTd" align="right">仓储负责人联系电话：</td>
			   <td width="30%" class="dialogTd">
			   		<input class="easyui-validatebox "  type="text" id="ccfzrlxdh" name="ccfzrlxdh" maxlength="18" style="width:200px;"  value="${entity.ccfzrlxdh}" data-options="validType:['mobile'],charSet:'halfUpper'" onblur="checkLxdh('ccfzrlxdh','ccfzrid')"/>
			   </td>
		  </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwccxxbEdit.js"></script>
