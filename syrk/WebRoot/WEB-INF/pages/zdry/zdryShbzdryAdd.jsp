<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>涉环保重点人员登记</title>
<script type="text/javascript" src="<%=contextPath%>/js/zdry/zdryShbzdryAdd.js"></script>


</head>

<body style="margin-top:20px; margin-bottom:10px" class="bodybg">

<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">

	<table height="100%" style="margin:0 auto;">
	<tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
			<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
				<form action="<%=basePath%>shbzdry/save" id="shbForm" name="shbForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="800px" align="center">
					<input type="hidden" id="ryid" name="zdryzb.ryid" value="${zdryzb.ryid}"/>
					<tr>
						<td width="20%" class="dialogTd" align="right">证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cyzjdm" name="zdryzb.cyzjdm" value="${cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:cyzjdm_onChange"/></td> 
					    <td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zjhm" name="zdryzb.zjhm" value="${zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'" onblur="zjhm_onblur()"/><div class="lodingimg" id="jbxxLoadDiv"></div></td>
					</tr>
					<tr class="dialogTr">
				    	
		    	        <td width="20%" class="dialogTd" align="right" id="xm_td">姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="zdryzb.xm" value="${xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'left',required:true"/></td>
		    	        <td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="zdryzb.xbdm" value="${xbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
					</tr>	
						<tr class="dialogTr">
				    	
				    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="csrq" name="zdryzb.csrq" value="${csrq}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
					    <td width="20%" class="dialogTd" align="right">民族：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="zdryzb.mzdm" value="${mzdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
					</tr>
					 <tr class="dialogTr">
				        <td width="20%" class="dialogTd" align="right">联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lxdh" name="zdryzb.lxdh" value="${lxdh}" style="width:200px;" maxlength="18"
							data-options="required:true,validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jbxx_lxdh','jbxx_id')"/></td>
					    <td width="20%" class="dialogTd" align="right">是否死亡：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfswdm" name="shbzdry.sfswdm" value="${sfswdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 				 
			       </tr>
				   <tr class="dialogTr">
				        <td width="20%" class="dialogTd" align="right">案件类别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ajlbdm" name="shbzdry.ajlbdm" value="${ajlbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/XZ_D_AJLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	 <td width="20%" class="dialogTd" align="right">作案特点：</td>
				         <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zatddm" name="shbzdry.zatddm" value="${zatddm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/>
		    	        </td>
				    </tr>
				     <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">简要案情：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    	<textarea cols="3" rows="3" class="easyui-validatebox" id="jyaq" name="shbzdry.jyaq" value="${jyaq}" style="width:595px;height:52px" maxlength="1000"></textarea>
				    	</td> 
					</tr>
			    	<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">主要问题及表现：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><textarea cols="3" rows="3" class="easyui-validatebox" id="zywtjxsbx" name="shbzdry.zywtjxsbx" value="${zywtjxsbx}" style="width:595px;height:52px" maxlength="1000"></textarea></td> 
					</tr>
					
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">处理结果：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><textarea cols="3" rows="3" class="easyui-validatebox" id="cfjg" name="shbzdry.cfjg" value="${cljg}" style="width:595px;" maxlength="100"></textarea></td> 
					</tr>
				
					
		 			<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">籍贯省市县(区)：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jgssxdm" name="zdryzb.jgssxdm" value="${jgssxdm}" style="width:200px;" 
	    	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>			
					    
					     <td width="20%" class="dialogTd" align="right">户籍地所属市县(区)：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hjdsssxdm" name="zdryzb.hjdsssxdm" value="${hjdsssxdm}" style="width:200px;" 
							data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td> 
					   
					</tr> 
					<tr class="dialogTr">

						<td width="20%" class="dialogTd" align="right">户籍地所属县级公安机关：</td>
						<td width="30%" class="dialogTd" ><input type="text" name="zdryzb.hjd_ssxjgajgdm" id="hjd_ssxjgajgdm"
						   class="easyui-combobox" style="width:200px;"data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:hjdfj_onChange"></td>
						<td width="20%" class="dialogTd" align="right">户籍地所属派出所：</td>						
						<td width="30%" class="dialogTd" colspan="3"><input type="text" name="zdryzb.hjd_sspcsdm" id="hjd_sspcsdm"
						   class="easyui-combobox" style="width:200px;" data-options="required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false"></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">户籍地址描述：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="zdryzb.hjd_dzms" id="hjd_dzms" value="${hjd_dzms}" style="width:595px;"/>
							<input type="hidden" id="hjd_xzqhdm" name="zdryzb.hjd_xzqhdm" value="${hjd_xzqhdm}"/>
							<input type="hidden" id="hjd_mlpdm" name="zdryzb.hjd_mlpdm" value="${hjd_mlpdm}"/>
							<input type="hidden" id="hjd_mlpxz" name="zdryzb.hjd_mlpxz" value="${hjd_mlpxz}"/>
							<input type="hidden" id="hjd_dzid" name="zdryzb.hjd_dzid" value="${hjd_dzid}"/>
							<input type="hidden" id="hjd_dzxz" name="zdryzb.hjd_dzxz" value="${hjd_dzxz}"/>
							<input type="hidden" id="hjd_pcsdm" name="zdryzb.hjd_pcsdm" value="${hjd_pcsdm}"/>
				    	</td> 
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">户籍地社区：</td>
					    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hjd_sq" name="zdryzb.hjd_sq" value="${hjd_sq}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/D_BZDZ_SQ3.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	
					</tr>
					<tr class="dialogTr">
					
						<td width="20%" class="dialogTd" align="right">居住地所属县级公安机关：</td>
						<td width="30%" class="dialogTd" ><input type="text" name="zdryzb.ssfxjdm" id="ssfxjdm"
						   class="easyui-combobox" style="width:200px;"data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:jzdfj_onChange"></td>
						<td width="20%" class="dialogTd" align="right">居住地所属派出所：</td>						
						<td width="30%" class="dialogTd" colspan="3"><input type="text" name="zdryzb.sspcsdm" id="sspcsdm"
						   class="easyui-combobox" style="width:200px;" data-options="required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false"></td>
					</tr>
					
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地详址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jzd1" style="width:380px;" value="${dz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="dz_jzdzmlpdm" name="zdryzb.dz_jzdzmlpdm" value="${dz_jzdzmlpdm}"/>
					    	<input type="hidden" id="dz_jzdzmlpxz" name="zdryzb.dz_jzdzmlpxz" value="${dz_jzdzmlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(zdryzb.dz_jzd_dzxz, zdryzb.dz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="dz_jzdzdm" name="zdryzb.dz_jzdzdm" value="${dz_jzdzdm}"/>
					    	<input type="hidden" id="dz_jzdzssxdm" name="zdryzb.dz_jzdzssxdm" value="${dz_jzdzssxdm}"/>
					    	<input type="hidden" id="dz_jzdzxz" name="zdryzb.dz_jzdzxz" value="${dz_jzdzxz}"/>
					    	<input type="hidden" id="zrqdm" value="${zrqdm}"/>
				    	</td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地社区：</td>
					    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzd_sq" name="zdryzb.jzd_sq" value="${jzd_sq}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/D_BZDZ_SQ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	
					
					</tr>
		
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">经常活动地区：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jchddq" name="shbzdry.jchddq" value="${jchddq}" style="width:595px;" maxlength="100"/></td> 
					</tr>
						<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">简历：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    	<textarea class="easyui-validatebox" rows="3" cols="3" id="jl" name="shbzdry.jl" value="${jl}" style="width:595px;height:52px;" maxlength="1000"></textarea></td> 					    
					</tr>			
	
					<tr class="dialogTr">
					
					  	<td width="20%" class="dialogTd" align="right">人口编码：</td>
				    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" id="jbxx_zy" name="shbzdry.rkbm" value="${ryRyjbxxb.zy}" style="width:200px;" maxlength="40"/></td> 
					
					    <td width="20%" class="dialogTd" align="right">数据密级：</td>
				    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" id="jbxx_zy" name="shbzdry.sjmj" value="${ryRyjbxxb.zy}" style="width:200px;" maxlength="20"/></td> 
					
					</tr> 
					
					</table>
					
					</form>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:display;">
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveForm()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="resetForm()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
			
		</div>
			</div>
			
		</div>
	    </div>
	    </div>


		</td>
        </tr>
   	</table>
</div>


</body>
<script type="text/javascript">
/* var mainTabID = "${mainTabID}";
var invokeJSMethod = "${invokeJSMethod}";
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";
var cyzjdm = "${ryRyjbxxb.cyzjdm}"; 
var zjhm = "${ryRyjbxxb.zjhm}"; 
function doInit(paramArray) {

}

function beforeSubmit() {
}

function afterSubmit() {
}	 */
</script>
</html>