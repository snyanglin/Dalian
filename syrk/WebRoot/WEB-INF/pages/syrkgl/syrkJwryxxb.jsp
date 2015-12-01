<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>境外人员信息</title>
</head>

<body>

<form action="<%=basePath%>syrkJwryxxb/${jwry.id}" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value="PUT"/>
  	<input type='hidden' id="pk" name='id' value="${jwry.id}" />
	<input type="hidden" id="ryid" name="ryid" value="${jwry.ryid}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_cyzjdm" name="cyzjdm" value="${jwry.cyzjdm}" style="width:200px;"
				data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zjhm" name="zjhm" value="${jwry.zjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'"/></td>
  	   	</tr>
		<tr class="dialogTr">
   	        <td width="20%" class="dialogTd" align="right">中文姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_xm" name="xm" value="${jwry.xm}" style="width:200px;" maxlength="50"
   	        	data-options="required:false,tipPosition:'right'"/></td>
   	        <td width="20%" class="dialogTd" align="right"></td>
   	        <td width="30%" class="dialogTd"></td>
  	   	</tr>
		<tr class="dialogTr">
   	        <td width="20%" class="dialogTd" align="right">外文姓：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_wwx" name="wwx" value="${jwry.wwx}" style="width:200px;" maxlength="40"
   	        	data-options="validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
   	        <td width="20%" class="dialogTd" align="right">外文名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_wwm" name="wwm" value="${jwry.wwm}" style="width:200px;" maxlength="40"
   	        	data-options="validType:['letter'],charSet:'half',tipPosition:'left'"/></td>
  	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">国籍：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_gjdm" name="gjdm" value="${jwry.gjdm}" style="width:200px;" 
				data-options="required:false,url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">性别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_xbdm" name="xbdm" value="${jwry.xbdm}" style="width:200px;" 
				data-options="required:false,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_csrq" name="csrq" value="${jwry.csrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">联系方式：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lxdh" name="lxdh" value="${jwry.lxdh}" style="width:200px;" maxlength="11"
				data-options="validType:['mobile'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jwry_lxdh','jbxx_id')"/></td>
  	   	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住地：</td>
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
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">签证种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_qzjlxkzldm" name="qzjlxkzldm" value="${jwry.qzjlxkzldm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/ZA_D_QZZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">签证号：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qzjlxkh" name="qzjlxkh" value="${jwry.qzjlxkh}" style="width:200px;" maxlength="30"  
   	        	data-options="required:false,validType:['letterOrNum'],charSet:'half',tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">证件截止日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zj_jzrq" name="zj_jzrq" value="${jwry.zj_jzrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">签证签发机关：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qzjlxkqfjgmc" name="qzjlxkqfjgmc" value="${jwry.qzjlxkqfjgmc}" style="width:200px;" maxlength="50" 
   	        	data-options="required:false,tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">签证截止日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qzjlxk_jzrq" name="qzjlxk_jzrq" value="${jwry.qzjlxk_jzrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">签证停留截止日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qztjl_jzrq" name="qztjl_jzrq" value="${jwry.qztjl_jzrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住事由：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_zjzsydm" name="zjzsydm" value="${jwry.zjzsydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jwry_zjzcsfldm" name="zjzcsfldm" value="${jwry.zjzcsfldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:jwry_zjzcsfldm_onChange"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">住宿日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zsrq" name="zsrq" value="${jwry.zsrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">是否常住：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_jwryczbs" name="jwryczbs" value="${jwry.jwryczbs}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">入境日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_rjrq" name="rjrq" value="${jwry.rjrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">入境口岸：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_rjkadm" name="rjkadm" value="${jwry.rjkadm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/CRJ_D_RCJKADM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">拟离开日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_nlkrq" name="nlkrq" value="${jwry.nlkrq}" style="width:200px;" 
   	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_rjrq\')}'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">来自国家：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_lzgjdqdm" name="lzgjdqdm" value="${jwry.lzgjdqdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">外国人居留事由：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_wgrjlsydm" name="wgrjlsydm" value="${jwry.wgrjlsydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/CRJ_D_WGRJLSYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">境外人员入境事由：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_jwryrjsydm" name="jwryrjsydm" value="${jwry.jwryrjsydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/CRJ_D_JWRYRJSYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">境外人员入境登记身份：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_jwryrjdjsfdm" name="jwryrjdjsfdm" value="${jwry.jwryrjdjsfdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/CRJ_D_JWRYRJDJSFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">工作许可登记：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_gzxkdj" name="gzxkdj" value="${jwry.gzxkdj}" style="width:200px;" maxlength="30"
   	        	data-options="required:false,validType:['letterOrNum'],charSet:'half',tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">工作单位：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type="hidden" id="jwry_gzdw_dwid" name="gzdw_dwid" value="${jwry.gzdw_dwid}"/>
		    	<input type="hidden" id="jwry_gzdw_dwmc" name="gzdw_dwmc" value="${jwry.gzdw_dwmc}"/>
	    		<input class="easyui-combobox" id="jwry_gzdw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.gzdw_dwmc}" maxlength="50" style="width:618px;" /></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">留宿单位：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type="hidden" id="jwry_lsdw_dwid" name="lsdw_dwid" value="${jwry.lsdw_dwid}"/>
		    	<input type="hidden" id="jwry_lsdw_dwmc" name="lsdw_dwmc" value="${jwry.lsdw_dwmc}"/>
	    		<input class="easyui-combobox" id="jwry_lsdw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.lsdw_dwmc}" maxlength="50" style="width:618px;" /></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">接待单位：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type="hidden" id="jwry_jddw_dwid" name="jddw_dwid" value="${jwry.jddw_dwid}"/>
		    	<input type="hidden" id="jwry_jddw_dwmc" name="jddw_dwmc" value="${jwry.jddw_dwmc}"/>
	    		<input class="easyui-combobox" id="jwry_jddw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.jddw_dwmc}" maxlength="50" style="width:618px;" /></td>
  	   	</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">工作单位联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_gzdw_lxdh" name="gzdw_lxdh" value="${jwry.gzdw_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">留宿单位联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lsdw_lxdh" name="lsdw_lxdh" value="${jwry.lsdw_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'"/></td>
  	   	</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">接待单位联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_jddw_lxdh" name="jddw_lxdh" value="${jwry.jddw_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">是否非法就业：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_sfffjy" name="sfffjy" value="${jwry.sfffjy}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'left'"/></td>
  	   	</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">是否非法入境：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_sfffrjdm" name="sfffrjdm" value="${jwry.sfffrjdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">是否非法居留：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_sfffjldm" name="sfffjldm" value="${jwry.sfffjldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'left'"/></td>
  	   	</tr>

  	   	<tr class="dialogTr" id="jwry_fz_tr1" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_fwczqkdm" name="fwczqkdm" value="${jwry.fwczqkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jwry_chzr_yfzgx_rygxdm" name="chzr_yfzgx_rygxdm" value="${jwry.chzr_yfzgx_rygxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
 						<input type="hidden" id="jwry_fz_ryid" name="fz_ryid" value="${jwry.fz_ryid}"/>
			</td>
  	   	</tr>
		<tr class="dialogTr" id="jwry_fz_tr2" style="display: none;">
			<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_fz_cyzjdm" name="fz_cyzjdm" value="${jwry.fz_cyzjdm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:jwry_fz_cyzjdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_zjhm" name="fz_zjhm" value="${jwry.fz_zjhm}" style="width:200px;float:left;" maxlength="30"
   	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="jwry_fz_zjhm_onblur()"/><div class="lodingimg" id="jwry_fzLoadDiv"></div></td>
  	   	</tr>
		<tr class="dialogTr" id="jwry_fz_tr3" style="display: none;">
   	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_xm" name="fz_xm" value="${jwry.fz_xm}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_lxdh" name="fz_lxdh" value="${jwry.fz_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jwry_fz_lxdh','jwry_fz_ryid')"/></td>
  	   	</tr>
  		<tr class="dialogTr" id="jwry_fz_tr4" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="jwry_fz_jzd1" style="width:400px;" value="${jwry.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="jwry_fz_jzd_mlpdm" name="fz_jzd_mlpdm" value="${jwry.fz_jzd_mlpdm}"/>
		    	<input type="hidden" id="jwry_fz_jzd_mlpxz" name="fz_jzd_mlpxz" value="${jwry.fz_jzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="jwry_fz_jzd2" style="width:200px;" value='${fn:replace(jwry.fz_jzd_dzxz, jwry.fz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="jwry_fz_jzd_dzid" name="fz_jzd_dzid" value="${jwry.fz_jzd_dzid}"/>
		    	<input type="hidden" id="jwry_fz_jzd_xzqhdm" name="fz_jzd_xzqhdm" value="${jwry.fz_jzd_xzqhdm}"/>
		    	<input type="hidden" id="jwry_fz_jzd_dzxz" name="fz_jzd_dzxz" value="${jwry.fz_jzd_dzxz}"/>
	    	</td>
   	    </tr>
 		<tr class="dialogTr" id="trBottom" style="display: none;"><td colspan="4" height="102"></td></tr>
 
	</table>
</form>
    
</body>

<script type="text/javascript"> 

var _p;
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";

function doInit(paramArray) {
	_p = paramArray["_p"];

	$("#jwry_fz_zjhm").attr("cyzjdm", "${jwry.fz_cyzjdm}");
	$("#jwry_fz_zjhm").attr("zjhm", "${jwry.fz_zjhm}");

	setInputReadonly("jwry_cyzjdm", true);
	setInputReadonly("jwry_zjhm", true);
	setInputReadonly("jwry_jzd_dzxz", true);

	// 地址选择初始化
	initAddressSearch("jwry_jzd1", {zrqdm:zrqdm}, "jwry_jzd_mlpdm", "jwry_jzd_mlpxz", "jwry_jzd2", {text:"jwry_jzd_dzxz",dzxzqh:"jwry_jzd_xzqhdm",id:"jwry_jzd_dzid",dzzbx:"jwry_jzd_zbx",dzzby:"jwry_jzd_zby"}, null, null);
	initAddressSearch("jwry_fz_jzd1", {}, "jwry_fz_jzd_mlpdm", "jwry_fz_jzd_mlpxz", "jwry_fz_jzd2", {text:"jwry_fz_jzd_dzxz",dzxzqh:"jwry_fz_jzd_xzqhdm",id:"jwry_fz_jzd_dzid"}, null, null);
	
	// 单位选择初始化
	initDepartmentSearch("jwry_gzdw_dwmc_select", {}, "jwry_gzdw_dwid", "jwry_gzdw_dwmc", {});
	initDepartmentSearch("jwry_lsdw_dwmc_select", {}, "jwry_lsdw_dwid", "jwry_lsdw_dwmc", {});
	initDepartmentSearch("jwry_jddw_dwmc_select", {}, "jwry_jddw_dwid", "jwry_jddw_dwmc", {});

	jwry_zjzcsfldm_onChange("${jwry.zjzcsfldm}");
	
	if (IE && IE_VERSION <= 9) {
	}
	else {
		$("#trBottom").show();
		var opts = $("#jwry_fz_jzd1").combobox('options');
		opts.panelOptionsNumber = 6;
		var opts = $("#jwry_fz_jzd2").combobox('options');
		opts.panelOptionsNumber = 6;
	}
}

function beforeSubmit() {
	if ($("#dataForm").form("validate")) {
		if ($("#jwry_jzd_mlpdm").val() == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#jwry_jzd1").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		if ($("#jwry_jzd2").combobox("getValue") == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#jwry_jzd2").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		if ($("#jwry_rjrq").val() != "" && $("#jwry_nlkrq").val() != "" && $("#jwry_rjrq").val() >  $("#jwry_nlkrq").val()) {
			topMessager.alert("", "拟离开日期不能小于入境日期，请重新输入！");
			$("#jwry_nlkrq").focus();
			return false;
		}
		var jwry_zjzcsfldmValue = $("#jwry_zjzcsfldm").combotree("getValue");
		if (jwry_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
			if ($("#jbxx_id").val() != "" && $("#jwry_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#jwry_fz_ryid").val()) {
				topMessager.alert("", "房主不能为本人，请重新输入！");
				$("#jwry_fz_zjhm").focus();
				return false;
			}
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
	var textareaSelector = containObject.find('textarea.edit_input');
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

function jwry_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var jwry_zjzcsfldmValue = $("#jwry_zjzcsfldm").combotree("getValue");
	if (jwry_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#jwry_fz_tr1").show();
		$("#jwry_fz_tr2").show();
		$("#jwry_fz_tr3").show();
		$("#jwry_fz_tr4").show();
	}
	else {
		$("#jwry_fz_tr1").hide();
		$("#jwry_fz_tr2").hide();
		$("#jwry_fz_tr3").hide();
		$("#jwry_fz_tr4").hide();
		$("#jwry_fwczqkdm").combobox("setValue", "");
		$("#jwry_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#jwry_fz_ryid").val("");
		$("#jwry_fz_cyzjdm").combobox("setValue", "");
		$("#jwry_fz_zjhm").val("");
		$("#jwry_fz_xm").val("");
		$("#jwry_fz_lxdh").val("");
		$("#jwry_fz_jzd1").combobox("loadData", []);
		$("#jwry_fz_jzd2").combobox("loadData", []);
		var comboText = $("#jwry_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#jwry_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#jwry_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#jwry_fz_jzd_xzqhdm").val("");
		$("#jwry_fz_jzd_mlpdm").val("");
		$("#jwry_fz_jzd_mlpxz").val("");
		$("#jwry_fz_jzd_dzid").val("");
		$("#jwry_fz_jzd_dzxz").val("");
	}
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
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#jwry_fz_zjhm").val() + "&cyzjdm=" + $("#jwry_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#jwry_fz_ryid").val(data.ryRyjbxxb.id);
				$("#jwry_fz_xm").val(data.ryRyjbxxb.xm);
				$("#jwry_fz_xm").validatebox("validate");
				$("#jwry_fz_lxdh").val(data.ryRyjbxxb.lxdh);
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

</script>

</html>
