<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String orglevel = "";
    if(userInfo!=null){
    	orglevel = userInfo.getUserOrgLevel();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>境外人员信息</title>
<script type="text/javascript">
   var orglevel = "<%=orglevel%>";
</script>
</head>

<body>

<form action="<%=basePath%>syrkJwryxxb/${jwry.id}" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value="PUT"/>
  	<input type='hidden' id="pk" name='id' value="${jwry.id}" />
	<input type="hidden" id="ryid" name="ryid" value="${jwry.ryid}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
   	    <tr class="dialogTr">
   	       <td width="20%" class="dialogTd" align="right">国籍（地区）：</td>
   	       <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_gjdm" name="gjdm" value="${jwry.gjdm}" style="width:200px;" 
			   data-options="required:true,url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
   	       <td width="20%" class="dialogTd" align="right">证件种类：</td>
   	       <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_cyzjdm" name="cyzjdm" value="${jwry.cyzjdm}" style="width:200px;"
			   data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
   	    </tr>
   	    
   	    <tr class="dialogTr">
   	       <td width="20%" class="dialogTd" align="right">证件号码：</td>
   	       <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zjhm" name="zjhm" value="${jwry.zjhm}" style="width:200px;float:left;" maxlength="30" 
		       data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'"/></td>
   	   	   <td width="20%" class="dialogTd" align="right">中文姓名：</td>
   	   	   <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_xm" name="xm" value="${jwry.xm}" style="width:200px;" maxlength="50"
		       data-options="tipPosition:'left'"/></td>
   	    </tr>
   	    
   	    <tr class="dialogTr">
   	       <td width="20%" class="dialogTd" align="right">外文姓：</td>
   	       <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_wwx" name="wwx" value="${jwry.wwx}" style="width:200px;" maxlength="40"
		       data-options="required:true,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
   	   	   <td width="20%" class="dialogTd" align="right">外文名：</td>
   	   	   <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_wwm" name="wwm" value="${jwry.wwm}" style="width:200px;" maxlength="40"
		       data-options="required:true,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
   	    </tr>
   	    
   	    <tr class="dialogTr">
   	       <td width="20%" class="dialogTd" align="right">性别：</td>
   	       <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_xbdm" name="xbdm" value="${jwry.xbdm}" style="width:200px;" 
			   data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
   	   	   <td width="20%" class="dialogTd" align="right">出生日期：</td>
   	   	   <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_csrq" name="csrq" value="${jwry.csrq}" style="width:200px;" 
		       data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
   	    </tr>
   	    
   	    <tr class="dialogTr">
   	       <td width="20%" class="dialogTd" align="right">身份证号码：</td>
   	       <td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jwry_qt_sfzhm" name="qt_sfzhm" value="${jwry.qt_sfzhm}" style="width:200px;float:left;" maxlength="30" 
		       data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的身份证号码', tipPosition:'right'"/></td>
   	    </tr>
   	    
   	    <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">签证（注）种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_qzjlxkzldm" name="qzjlxkzldm" value="${jwry.qzjlxkzldm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/ZA_D_QZZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right'"/></td> 	
	    	<td width="20%" class="dialogTd" align="right">签证（注）号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qzjlxkh" name="qzjlxkh" value="${jwry.qzjlxkh}" style="width:200px;" maxlength="30"  
   	        	data-options="required:false,validType:['letterOrNum'],charSet:'half',tipPosition:'right'"/></td>
		</tr>
		
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">入境日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_rjrq" name="rjrq" value="${jwry.rjrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">停留有效日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qztjl_jzrq" name="qztjl_jzrq" value="${jwry.qztjl_jzrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_rjrq\')}'})"/></td>
		</tr>
   	    
   	    <tr class="dialogTr">
  	      	<td width="20%" class="dialogTd" style="color: #FF0000;font-weight: bold;" align="right">住址信息：</td>
  	      	<td width="80%" class="dialogTd" colspan="3"></td>
		</tr>
		
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">住房种类：</td>
   	        <td width="80%" class="dialogTd" colspan="3"><input class="easyui-combotree" type="text" id="jwry_zjzcsfldm" name="zjzcsfldm" value="${jwry.zjzcsfldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right"><input type="radio" id="jzdzRadio" name="dzRadio" checked="checked" value="0" onclick="onRadioClick(0);">现住址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="jwry_jzd1" style="width:380px;" value="${jwry.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="jwry_jzd_mlpdm" name="jzd_mlpdm" value="${jwry.jzd_mlpdm}"/>
		    	<input type="hidden" id="jwry_jzd_mlpxz" name="jzd_mlpxz" value="${jwry.jzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="jwry_jzd2" style="width:200px;" value='${fn:replace(jwry.jzd_dzxz, jwry.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="jwry_jzd_dzid" name="jzd_dzid" value="${jwry.jzd_dzid}"/>
		    	<input type="hidden" id="jwry_jzd_xzqhdm" name="jzd_xzqhdm" value="${jwry.jzd_xzqhdm}"/>
		    	<input type="hidden" id="jwry_jzd_dzxz" name="jzd_dzxz" value="${jwry.jzd_dzxz}"/>
		    	<input type="hidden" id="jwry_jzd_zbx" name="jzd_zbx" value="${jwry.jzd_zbx}"/>
		    	<input type="hidden" id="jwry_jzd_zby" name="jzd_zby" value="${jwry.jzd_zby}"/>
	    	</td>
		</tr>
		<tbody id="dzmsbody">
		<tr class="dialogTr">
       		<td width="20%" class="dialogTd" align="right"><input type="radio" id="dzmsRadio" name="dzRadio" value="1" onclick="onRadioClick(1);">地址描述：</td>
			<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="dzms_mldzXz" style="width:380px;" value="${jwry.dzms_mldz}" 
					data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" >
				<input type='hidden' id="dzms_mldz" name='dzms_mldz' value="${jwry.dzms_mldz}"/>
			</td>
			<td width="30%" class="dialogTd">
			    <input class="easyui-validatebox" name='dzms_chdz' id="dzms_chdz" style="width:200px;" value='${jwry.dzms_chdz}'>
		    </td>	
   	   </tr>
   	   <tr class="dialogTr">
   	   		<td width="20%" class="dialogTd" align="right"></td>
			<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-validatebox" id="dzms_sspcsmc" name="dzms_sspcsmc" style="width: 49%;" value="地址描述所属派出所">
				<input class="easyui-validatebox" id="dzms_sszrqmc" name="dzms_sszrqmc" style="width: 48%;" value="地址描述所属责任区">
				<input type="hidden" id="dzms_sspcsdm" name="dzms_sspcsdm" value="${jwry.dzms_sspcsdm}">
				<input type="hidden" id="dzms_sszrqdm" name="dzms_sszrqdm" value="${jwry.dzms_sszrqdm}">
				<input type="hidden" id="entity_zbx" name="dzms_zbx" value="${jwry.dzms_zbx}">
				<input type="hidden" id="entity_zby" name="dzms_zby" value="${jwry.dzms_zby}">
			</td>
		    <td class="dialogTd">
				 <a id="dtbdButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" disabled="disabled">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">标点</span>
						<span class="l-btn-icon icon-biaodian"></span>
					</span>
				 </a>
		    </td>
   	    </tr>
   	    </tbody>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">入宿日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zsrq" name="zsrq" value="${jwry.zsrq}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
   	 	    <td width="20%" class="dialogTd" align="right">拟离开日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_nlkrq" name="nlkrq" value="${jwry.nlkrq}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_zsrq\')}'})"/></td>
		</tr>
		<tr class="dialogTr">
   	        <td width="20%" class="dialogTd" align="right">房主身份类别：</td>
   	        <td width="80%" class="dialogTd" colspan="3">
                <input type="radio" id="jnryId" name="fz_sflb" value="0" onclick="jwry_fzsflb_onClick()">境内人员
                <input type="radio" id="jwryId" name="fz_sflb" value="1" onclick="jwry_fzsflb_onClick()">境外人员		    	        
	        </td>
		</tr>
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_fz_cyzjdm" name="fz_cyzjdm" value="${jwry.fz_cyzjdm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:jwry_fz_cyzjdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_zjhm" name="fz_zjhm" value="${jwry.fz_zjhm}" style="width:200px;float:left;" maxlength="30"
   	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'right'" onblur="jwry_fz_zjhm_onblur()"/><div class="lodingimg" id="jwry_fzLoadDiv"></div></td>
			<input type="hidden" id="jwry_fz_ryid" name="fz_ryid" value="${jwry.fz_ryid}"/>
		</tr>
		<tr class="dialogTr">
   	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_xm" name="fz_xm" value="${jwry.fz_xm}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_lxdh" name="fz_lxdh" value="${jwry.fz_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'right'" onblur="checkLxdh('jwry_fz_lxdh','jwry_fz_ryid')"/></td>
		</tr>
		<tr class="dialogTr" id="jwry_fz_tr1" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房主国籍：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_fz_gjdm" name="fz_gjdm" value="${jwry.fz_gjdm}" style="width:200px;" 
				data-options="required:false,url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">房主性别：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_fz_xbdm" name="fz_xbdm" value="${jwry.fz_xbdm}" style="width:200px;" 
				data-options="required:false,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
		</tr>
		<tr class="dialogTr" id="jwry_fz_tr2" style="display: none;">
		    <td width="20%" class="dialogTd" align="right">房主外文姓：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_wwx" name="fz_wwx" value="${jwry.fz_wwx}" style="width:200px;" maxlength="40"
   	        	data-options="required:false,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
		 	<td width="20%" class="dialogTd" align="right">房主外文名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_wwm" name="fz_wwm" value="${jwry.fz_wwm}" style="width:200px;" maxlength="40"
   	        	data-options="required:false,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
		</tr>
		<tr class="dialogTr" id="jwry_fz_tr3" style="display: none;">
   	        <td width="20%" class="dialogTd" align="right">房主出生日期：</td>
   	        <td width="30%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jwry_fz_csrq" name="fz_csrq" value="${jwry.fz_csrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">留宿单位：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type="hidden" id="jwry_lsdw_dwid" name="lsdw_dwid" value="${jwry.lsdw_dwid}"/>
		    	<input type="hidden" id="jwry_lsdw_dwmc" name="lsdw_dwmc" value="${jwry.lsdw_dwmc}"/>
	    		<input class="easyui-combobox" id="jwry_lsdw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.lsdw_dwmc}" maxlength="50" style="width:595px;" /></td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">接待单位：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type="hidden" id="jwry_jddw_dwid" name="jddw_dwid" value="${jwry.jddw_dwid}"/>
		    	<input type="hidden" id="jwry_jddw_dwmc" name="jddw_dwmc" value="${jwry.jddw_dwmc}"/>
	    		<input class="easyui-combobox" id="jwry_jddw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.jddw_dwmc}" maxlength="50" style="width:595px;" /></td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">留宿单位联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lsdw_lxdh" name="lsdw_lxdh" value="${jwry.lsdw_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
			<td width="20%" class="dialogTd" align="right">接待单位联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_jddw_lxdh" name="jddw_lxdh" value="${jwry.jddw_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">紧急情况联系人：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lxr_xm" name="lxr_xm" value="${jwry.lxr_xm}" style="width:200px;" maxlength="18"
				data-options="tipPosition:'right'"/></td>
			<td width="20%" class="dialogTd" align="right">紧急情况联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lxr_lxdh" name="lxr_lxdh" value="${jwry.lxr_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">备注：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><textarea id="jwry_bz" name="bz" class="easyui-validatebox" style="width: 595px; height:48px;overflow: auto;"
				data-options="validType:['maxLength[250]'],invalidMessage:'备注不能超过250个汉字，请重新输入！',tipPosition:'right'">${jwry.bz}</textarea></td>
    	</tr>
	</table>
</form>
    
</body>

<script type="text/javascript"> 
var _p;
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";
function doInit(paramArray){
	_p = paramArray["_p"];
	$("#jwry_fz_zjhm").attr("cyzjdm", "${jwry.fz_cyzjdm}");
	$("#jwry_fz_zjhm").attr("zjhm", "${jwry.fz_zjhm}");
	setInputReadonly("jwry_gjdm", true);
	setInputReadonly("jwry_cyzjdm", true);
	setInputReadonly("jwry_zjhm", true);
	$("input[name='fz_sflb'][value=${jwry.fz_sflb}]").attr("checked",true);
	jwry_fzsflb_onClick();
	//单位信息选择
	initDepartmentSearch("jwry_lsdw_dwmc_select", {}, "jwry_lsdw_dwid", "jwry_lsdw_dwmc", {});
	initDepartmentSearch("jwry_jddw_dwmc_select", {}, "jwry_jddw_dwid", "jwry_jddw_dwmc", {});
	//权限控制
	if(orglevel == "50"){
		$("#dzmsbody").hide();
		$("#jzdzRadio").hide();
		initAddressSearch("jwry_jzd1", {zrqdm:zrqdm}, "jwry_jzd_mlpdm", "jwry_jzd_mlpxz", "jwry_jzd2", {text:"jwry_jzd_dzxz",dzxzqh:"jwry_jzd_xzqhdm",id:"jwry_jzd_dzid",dzzbx:"jwry_jzd_zbx",dzzby:"jwry_jzd_zby"}, null, null);
	}else{
		initAddressSearch("jwry_jzd1", {pcsdm:zrqdm}, "jwry_jzd_mlpdm", "jwry_jzd_mlpxz", "jwry_jzd2", {text:"jwry_jzd_dzxz",dzxzqh:"jwry_jzd_xzqhdm",id:"jwry_jzd_dzid",dzzbx:"jwry_jzd_zbx",dzzby:"jwry_jzd_zby"}, null, null);
		//地址描述门楼地址选择
		initAddressSearch('dzms_mldzXz',{pcsdm:zrqdm},null,'dzms_mldz',null,null, null, null);
		setInputReadonly('dzms_sspcsmc', true);
		setInputReadonly('dzms_sszrqmc', true);
		onRadioClick(0);
		//地图标点【标识0返回X、Y坐标，1返回X、Y坐标并所属派出所、责任区信息】
		$("#dtbdButton").click(function(){
			var zbx = $("#entity_zbx").val();
			var zby = $("#entity_zby").val();
			var url = contextPath+"/forward/map|mapBz?bz=1&zbx="+zbx+"&zby="+zby;
			var paramArray = [];
			openWindow(false, null, url, 
		   		paramArray, 
		   		{
			   		title:"地图标注（鼠标点击左键标注位置，右键退出标注模式）",
			   		maximizable: false,
			   		width: 700,	
			   		height:400
		   		}
		   	);
		});
	}
}
function beforeSubmit() {
	if ($("#dataForm").form("validate")) {
		var dzredio = $('input[name="fz_sflb"]:checked').val();
		if(dzredio=="0"){
			if ($("#jwry_jzd_mlpdm").val() == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#jwry_jzd1").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			if ($("#jwry_jzd2").combobox("getValue") == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#jwry_jzd2").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
		}
		if ($("#jwry_zsrq").val() != "" && $("#jwry_nlkrq").val() != "" && $("#jwry_zsrq").val() >  $("#jwry_nlkrq").val()) {
			topMessager.alert("", "拟离开日期不能小于入宿日期，请重新输入！");
			$("#jwry_nlkrq").focus();
			return;
		}
	}
}
function afterSubmit(arr) {
	setFormDataToSpan($("body"),_p);
}
function setFormDataToSpan(containObject,_p) {
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text(comboText);
			}
		}
	});
	var textareaSelector = containObject.find('textarea');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = $(_p).find("span[name='"+_name+"']");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}

function jwry_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#jwry_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#jwry_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jwry_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("jwry_fz_zjhm_onblur();", 300);
}

function jwry_fz_zjhm_onblur() {
	if (!$("#jwry_fz_cyzjdm").combo("isValid")) {
		$("#jwry_fz_ryid").val("");
		return;
	}
	if (!$("#jwry_fz_zjhm").validatebox("isValid")) {
		$("#jwry_fz_ryid").val("");
		return;
	}
	if ($("#jwry_fz_zjhm").val() == "") {
		$("#jwry_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#jwry_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#jwry_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#jwry_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#jwry_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#jwry_fzLoadDiv").show();
	var url = contextPath + "/ryRyjbxxb/dataApply";
	if($("#jwryId").is(":checked")){
		url = contextPath + "/syrkJwryxxb/dataApply";
	}
	$.ajax({
		type: "POST",
		url: url,
		dataType: "json",
		data:"zjhm=" + $("#jwry_fz_zjhm").val() + "&cyzjdm=" + $("#jwry_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if($("#jwryId").is(":checked")){
				if (data && data.jwRyjbxxb) {
					$("#jwry_fz_ryid").val(data.jwRyjbxxb.ryid);
					$("#jwry_fz_xm").val(data.jwRyjbxxb.xm);
					$("#jwry_fz_xm").validatebox("validate");
					$("#jwry_fz_lxdh").val(data.jwRyjbxxb.fz_lxdh);
					$("#jwry_fz_gjdm").combobox("setValue",data.jwRyjbxxb.fz_gjdm);
					$("#jwry_fz_xbdm").combobox("setValue",data.jwRyjbxxb.fz_xbdm);
					$("#jwry_fz_wwx").val(data.jwRyjbxxb.fz_wwx);
					$("#jwry_fz_wwx").validatebox("validate");
					$("#jwry_fz_wwm").val(data.jwRyjbxxb.fz_wwm);
					$("#jwry_fz_wwm").validatebox("validate");
					$("#jwry_fz_csrq").val(data.jwRyjbxxb.fz_csrq);
					$("#jwry_fz_csrq").validatebox("validate");
				}
			}else{
				if (data && data.ryRyjbxxb) {
					$("#jwry_fz_ryid").val(data.ryRyjbxxb.id);
					$("#jwry_fz_xm").val(data.ryRyjbxxb.xm);
					$("#jwry_fz_xm").validatebox("validate");
					$("#jwry_fz_lxdh").val(data.ryRyjbxxb.lxdh);
				}
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#jwry_fz_zjhm").attr("cyzjdm", $("#jwry_fz_cyzjdm").combobox("getValue"));
			$("#jwry_fz_zjhm").attr("zjhm", $("#jwry_fz_zjhm").val());
			$("#jwry_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

/**
 * @title:jwry_fzsflb_onClick
 * @description:境外人员_房主身份类别
 * @author: zhang_guoliang@founder.com
 * @param 0境内人员、1境外人员 
 * @date:2015-05-28 09:34:32
 */
function jwry_fzsflb_onClick(){
	var redio = $('input[name="fz_sflb"]:checked').val();
	if(redio=='0'){
		$("#jwry_fz_tr1").hide();
		$("#jwry_fz_tr2").hide();
		$("#jwry_fz_tr3").hide();
		//设置房主的必填项
		setComboRequired("jwry_fz_gjdm", false);
		setComboRequired("jwry_fz_xbdm", false);
		$("#jwry_fz_wwx").validatebox({required:false});
		$("#jwry_fz_wwm").validatebox({required:false});
		$("#jwry_fz_csrq").validatebox({required:false});
	}else if(redio=='1'){
		$("#jwry_fz_tr1").show();
		$("#jwry_fz_tr2").show();
		$("#jwry_fz_tr3").show();
		//设置房主的必填项
		setComboRequired("jwry_fz_gjdm", true);
		setComboRequired("jwry_fz_xbdm", true);
		$("#jwry_fz_wwx").validatebox({required:true});
		$("#jwry_fz_wwm").validatebox({required:true});
		$("#jwry_fz_csrq").validatebox({required:true});
	}
};
/**
 * @title:onRadioClick
 * @description:地址描述是【禁用】还是【启用】
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-02 14:43:31
 */
var radioBz = 0; 
function onRadioClick(bz){
	 radioBz = bz;
	 if(bz==0){
		 setInputReadonly('jwry_jzd1', false);
		 setInputReadonly('jwry_jzd2', false);
		 setInputReadonly('dzms_mldzXz', true);
		 setInputReadonly('dzms_chdz', true);
		 //必填校验
		 setComboRequired('jwry_jzd1', true);
		 setComboRequired('jwry_jzd2', true);
		 setComboRequired('dzms_mldzXz', false);
		 document.getElementById("dtbdButton").disabled = "disabled";
		 //重置单位地址描述
		 $("#dzms_mldzXz").combobox("clear");
		 $("#dzms_mldz").val("");
		 $("#dzms_chdz").val("");
		 $("#dzms_sspcsmc").val("地址描述所属派出所");
		 $("#dzms_sszrqmc").val("地址描述所属责任区");
		 $("#dzms_sspcsdm").val("");
		 $("#dzms_sszrqdm").val("");
		 $("#entity_zbx").val("");
		 $("#entity_zby").val("");
	 }else if(bz==1){
		 setInputReadonly('jwry_jzd1', true);
		 setInputReadonly('jwry_jzd2', true);
		 setInputReadonly('dzms_mldzXz', false);
		 setInputReadonly('dzms_chdz', false);
		 //必填校验
		 setComboRequired('jwry_jzd1', false);
		 setComboRequired('jwry_jzd2', false);
		 setComboRequired('dzms_mldzXz', true);
		 document.getElementById("dtbdButton").disabled = "";
		 //重置单位标准地址
		 $("#jwry_jzd1").combobox("clear");
		 $("#jwry_jzd2").combobox("clear");
		 $("#jwry_jzd_mlpdm").val("");
		 $("#jwry_jzd_mlpxz").val("");
		 $("#jwry_jzd_dzid").val("");
		 $("#jwry_jzd_xzqhdm").val("");
		 $("#jwry_jzd_dzxz").val("");
		 $("#jwry_jzd_zbx").val("");
		 $("#jwry_jzd_zby").val("");
	 }
};
</script>

</html>
