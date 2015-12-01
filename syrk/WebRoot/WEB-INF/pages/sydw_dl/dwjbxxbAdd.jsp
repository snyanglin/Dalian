<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实有单位</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
</head>
<body style="margin-top:20px" class="bodybg">
	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
    			<form action="<%=basePath%>sydw_dl" id="jbxxForm" name="jbxxForm" method="post">
		    	   <input type='hidden' id="pcsdmFilter" value="${pcsdm}"/>
		    	   <input type='hidden' id="_method" name="_method" />
		    	   <input type='hidden' id="zrqdmFilter" value="${zrqdm}"/>
		    	   <input type='hidden' name='dwjbxxb.glbmid' id="dwjbxxb_glbmid" value="${dwjbxxb.glbmid}"/>
		    	   <input type='hidden' name='dwjbxxb.glpcsid' id="dwjbxxb_glpcsid" value="${pcsdm}"/>
		    	   <input type='hidden' name='dwjbxxb.glfxjid' id="dwjbxxb_glfxjid" value="${fsxdm}"/>
		    	   <input type='hidden' name='' id="sfsyzrq" value="${sfsyzrq}"/>
		    	   
    			   <input type='hidden' name='hsrwid' id="hsrwid" value="${hsrwid}"/>
	    		   <input type='hidden' name='dwjbxxb.id' id="dwjbxxb_id" value="${dwjbxxb.id}"/>
	    		   <div class="easyui-accordion" data-options="multiple:true"  >
    			   <div title="基本信息" id="baseInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">   
    			   <table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
	    		   <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">单位名称：</td>
			    	    <td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="dwjbxxb_dwmc" name="dwjbxxb.dwmc" value="${dwjbxxb.dwmc}" maxlength="50" style="width:610px;" 
		    	 			data-options="required:true,tipPosition:'left'"/></td>
	    	       </tr>
	    		   <tr class="dialogTr">
			          <td width="20%" class="dialogTd" align="right">本地上级单位：</td>
			    	  <td width="80%" class="dialogTd" colspan="3">
			    	      <input type="hidden" id="sjdwid" name="dwjbxxb.sjdwid" value="${entity.sjdwid}" />
			    	      <input type="hidden" id="sjdwmc" name="sjdwmc" />
			    	      <input class="easyui-combobox" type="text" id="sjdw-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" name="dw-box" value="${sjdwmc}" maxlength="50" style="width:610px;"/>
			    	  </td>
		    	   </tr>
	    		   <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">单位类别：</td>
				    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" id="dwlbdm" name="dwjbxxb.dwlbdm" value="${dwjbxxb.dwlbdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/D_DW_DWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
							</td> 
							<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='dwjbxxb.lxdh' id="dwjbxxb_lxdh" value="${dwjbxxb.lxdh}" style="width:200px;" maxlength="18" 
			    	    	data-options="required:false,validType:['phone']"/></td>
	    	       </tr>
	    	       
	    	       <tr class="dialogTr">
			       		<td width="20%" class="dialogTd" align="right"><input type="radio" id="dwbzdzRadio" name="dzRadio" checked="checked" value="0" onclick="onRadioClick(0);">单位标准地址：</td>
						<td width="50%" class="dialogTd" colspan="2">
							<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${dwjbxxb.dz_dwdzmlpxz}" 
								data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
							<input type='hidden' name='dwjbxxb.dz_dwdzmlpdm' id="dz_dwdzmlpdm" value="${dwjbxxb.dz_dwdzmlpdm}"/>
							<input type='hidden' name='dwjbxxb.dz_dwdzmlpxz' id="dz_dwdzmlpxz" value="${dwjbxxb.dz_dwdzmlpxz}"/>
						</td>
						<td width="30%" class="dialogTd">
					    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(dwjbxxb.dz_dwdzxz, dwjbxxb.dz_dwdzmlpxz, "")}' 
					    	 	data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='dwjbxxb.dz_dwdzdm' id='dz_dwdzdm' value="${dwjbxxb.dz_dwdzdm}" />
					    	<input type='hidden' name='dwjbxxb.dz_dwdzssxdm' id='dz_dwdzssxdm' value="${dwjbxxb.dz_dwdzssxdm}" />
					    	<input type='hidden' name='dwjbxxb.dz_dwdzxz' id='dz_dwdzxz' value="${dwjbxxb.dz_dwdzxz}" /> 
					    </td>	
		    	   </tr>
		    	   <!-- zhang_guoliang@Founder.com 新增地址描述【开始】-->
		    	   <tr class="dialogTr">
			       		<td width="20%" class="dialogTd" align="right" rowspan="1"><input type="radio" id="dwdzmsRadio" name="dzRadio" value="1" onclick="onRadioClick(1);">单位地址描述：</td>
			       		
						<td width="50%" class="dialogTd" colspan="2">
							<input class="easyui-combobox" id="dzms_mldz" style="width:400px;" value="${dwjbxxb.dzms_dwdzmlpxz}" 
								data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" >
							<input type='hidden' name='dwjbxxb.dzms_dwdzmlpdm' id="dzms_dwdzmlpdm" value="${dwjbxxb.dz_dwdzmlpdm}"/>
							<input type='hidden' name='dwjbxxb.dzms_dwdzmlpxz' id="dzms_dwdzmlpxz" value="${dwjbxxb.dzms_dwdzmlpxz}"/>
						</td>
						<td width="30%" class="dialogTd">
						    <input class="easyui-validatebox" name='dwjbxxb.dzms_chdz' id="dzms_chdz" style="width:200px;" value='${dwjbxxb.dzms_chdz}'>
					    </td>	
		    	   </tr>
		    	   <tr class="dialogTr">
		    	   <td width="20%" class="dialogTd" align="right" rowspan="1"></td>
						<td width="50%" class="dialogTd" colspan="2">
							<input class="easyui-validatebox" id="dzms_sspcsmc" name="dwjbxxb.dzms_sspcsmc" style="width: 49%;" value="地址描述所属派出所">
							<input class="easyui-validatebox" id="dzms_sszrqmc" name="dwjbxxb.dzms_sszrqmc" style="width: 48%;" value="地址描述所属责任区">
							<input type="hidden" id="dzms_sspcsdm" name="dwjbxxb.dzms_sspcsdm" value="${dwjbxxb.dzms_sspcsdm}">
							<input type="hidden" id="dzms_sszrqdm" name="dwjbxxb.dzms_sszrqdm" value="${dwjbxxb.dzms_sszrqdm}">
							<input type="hidden" id="entity_zbx" name="dwjbxxb.dzms_zbx" value="${dwjbxxb.dzms_zbx}">
							<input type="hidden" id="entity_zby" name="dwjbxxb.dzms_zby" value="${dwjbxxb.dzms_zby}">
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
		    	   <!-- zhang_guoliang@Founder.com 新增地址描述【结束】 -->
	    	       <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">单位状态：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_dwztdm' name='dwjbxxb.dwztdm' value="${dwjbxxb.dwztdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_DW_DWZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	        <td width="20%" class="dialogTd" align="right">单位编码：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox inputreadonly'  readonly="readonly"  type='text' id='dwjbxxb_zagldwbm' name='dwjbxxb.zagldwbm' value="${dwjbxxb.zagldwbm}" style="width:200px;"/></td>
		    	    </tr>
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">开业日期：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id='dwjbxxb_kyrq' name='dwjbxxb.kyrq' value="${dwjbxxb.kyrq}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
			    	       <td width="20%" class="dialogTd" align="right">营业时间：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id='dwjbxxb_yysj' name='dwjbxxb.yysj' value="${dwjbxxb.yysj}" style="width:200px;"
			    	        data-options="required:false" maxlength="200" title="例如：早09：00~晚21：30"/></td>
			    	        </tr>
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营范围（主营）：</td>
			    	    <td width="80%" class="dialogTd" colspan="3"><textarea id="dwjbxxb_jyfwzy" name="dwjbxxb.jyfwzy" class="easyui-validatebox" rows="3" style="width:610px; height:52px;overflow: auto;"
							data-options="validType:['maxLength[200]'],invalidMessage:'经营范围（主营）不能超过200个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.jyfwzy}</textarea></td>
	    	       </tr>
	    	       
	    	       <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营面积(平方米)：</td>
			    	    <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dwjbxxb_jymj" name="dwjbxxb.jymj_mjpfm" value="${dwjbxxb.jymj_mjpfm}" style="width:200px;" 
		    	 			data-options="validType:['numeric[\'f\',2]'],invalidMessage:'经营面积为两位小数的数字，请重新输入！',tipPosition:'left'" maxlength="9"/></td>
		    	  <td width="20%" class="dialogTd" align="right">重点单位标识：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_zddwbs' name='dwjbxxb.zddwbs' value="${dwjbxxb.zddwbs}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	   </tr>
	    	       <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">是否外资单位：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_sfwzdwdm' name='dwjbxxb.sfwzdwdm' value="${dwjbxxb.sfwzdwdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	    <td width="20%" class="dialogTd" align="right">是否涉外单位：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_sfswdwdm' name='dwjbxxb.sfswdwdm' value="${dwjbxxb.sfswdwdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	   </tr>
	    	       </table>
	    	       </div>
	    	       <div title="补充信息" id="otherInfoTypeDiv"  data-options="selected:true" style="overflow:auto;padding:10px;">   
    				<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
    				<tr class="dialogTr"">
			    	  
			    	    <td width="100%" class="dialogTd" colspan="4" valign="top">
			    	    <table border="0" cellpadding="0" cellspacing="0" width="100%" id="dwbmTable">
				    	   	 <c:forEach items="${dwbmxxbArray}" var="dwbmxxb" varStatus="status">
					       			<c:if test="${status.index > 0}">
									<tr id="dwbm1Tr${status.index}"><td  height="10"></td></tr>
					       			</c:if>
								<tr  width="100%"  id="dwbm2Tr${status.index}" height="24" class="dialogTr">
										<td width="20%" class="dialogTd"  id="dwbmTd{status.index}" align="right">单位别名：</td>
										
						    	   		<td width="80%" colspan="3" id="dwbmTd{status.index}" class="dialogTd" > 
						    	   		&nbsp;<input class="easyui-validatebox" type="text" id="dwbm1_${status.index}" name="dwbmxxbArray[${status.index}].dwbm" value="${dwbmxxb.dwbm}" maxlength="50" 
						    	   			style="width:560px;" data-options="tipPosition:'left'"/>
				    	    	
				    	    	<c:choose>
									   <c:when test="${status.index == 0}"><a class="addLine_btn" href="javascript:void(0);" onclick="addDwbm();" title="增加一个单位别名"></a></c:when>
									   <c:otherwise><a class="delLine_btn" href="javascript:void(0);" onclick="delDwbm('${status.index}')" title="注销当前单位别名"></a></c:otherwise>
								</c:choose>
								
								<input  type="hidden" id="dwbmid" name="dwbmxxbArray[${status.index}].id" value="${dwbmxxb.id}"/>
								</td>
							</tr>
							</c:forEach>
			       		</table>
			       		</td>
	    	       </tr>
    				 <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">单位英文名称：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='dwjbxxb.dwywmc' id="dwjbxxb_dwywmc" value="${dwjbxxb.dwywmc}" style="width:200px;" maxlength="100" 
			    	    	data-options="required:false,validType:['letter']"/></td>
			    	    <td width="20%" class="dialogTd" align="right">单位英文缩写：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='dwjbxxb.dwywsx' id="dwjbxxb_dwywsx" value="${dwjbxxb.dwywsx}" style="width:200px;" maxlength="100" 
			    	    	data-options="required:false,validType:['letter']"/></td>
		    	   </tr>
		    	    
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">行业类别：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_hylbdm' name='dwjbxxb.hylbdm' value="${dwjbxxb.hylbdm}" style="width:200px;"
			    	         data-options="url: contextPath + '/common/dict/D_DW_HYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	   </tr>
    				<tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">是否办理营业执照：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_sfblyyzzdm' name='dwjbxxb.sfblyyzzdm' value="${dwjbxxb.sfblyyzzdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:sfblyyzzdmOnchange"/></td>
			    	    <td width="20%" class="dialogTd" align="right">营业执照号：</td>
			    	    <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dwjbxxb_yyzzdm" name="dwjbxxb.yyzzh" value="${dwjbxxb.yyzzh}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/></td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">营业执照有效期起始日期：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id='dwjbxxb_yyzzqsrq' name='dwjbxxb.yyzzyxq_qsrq' value="${dwjbxxb.yyzzyxq_qsrq}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
			    	    <td width="20%" class="dialogTd" align="right">营业执照有效期截止日期：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id='dwjbxxb_yyzzjzrq' name='dwjbxxb.yyzzyxq_jzrq' value="${dwjbxxb.yyzzyxq_jzrq}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'dwjbxxb_yyzzqsrq\') || \'%y-%M-%d\'}'})"/></td>
		    	   </tr>
    				 <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">营业执照发证机关：</td>
			    	    <td width="30%"  colspan="3" class="dialogTd" ><input class="easyui-validatebox" type="text" id="dwjbxxb_yyzzfzjg" name="dwjbxxb.yyzzfzjg" value="${dwjbxxb.yyzzfzjg}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/>
		    	 		</td>
		    	 		<!-- 	<td width="20%" class="dialogTd" align="right">营业执照发证机关Id：</td>
			    	    <td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name='dwjbxxb.yyzzfzjgid' id="dwjbxxb_yyzzfzjgid" value="${dwjbxxb.yyzzfzjgid}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/>
		    	 			</td> -->
	    	       </tr>
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">组织机构证号：</td>
			    	    <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dwjbxxb_zzjgzh" name="dwjbxxb.zzjgdm" value="${dwjbxxb.zzjgdm}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/></td>
		    	 			 <td width="20%" class="dialogTd" align="right">税务登记证号：</td>
			    	    <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dwjbxxb_swdjzh" name="dwjbxxb.swdjhm" value="${dwjbxxb.swdjhm}" maxlength="50" style="width:200px;" 
		    	 			data-options="charSet:'halfUpper',tipPosition:'right'"/></td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">注册资金（元）：</td>
			    	    <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dwjbxxb_zczj" name="dwjbxxb.zczb" value="${dwjbxxb.zczb}" style="width:200px;" maxlength="12" 
		    	 			data-options="validType:['numeric[\'f\',2]'],invalidMessage:'注册资金为两位小数的金额，请重新输入！',tipPosition:'right'"/></td>
		    	    <td width="20%" class="dialogTd" align="right">传真号码：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='dwjbxxb.czhm' id="dwjbxxb_cz" value="${dwjbxxb.czhm}" style="width:200px;" maxlength="18" 
			    	    	data-options="required:false,validType:['phone'],tipPosition:'right'"/></td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营范围（兼营）：</td>
			    	    <td width="80%" class="dialogTd" colspan="3"><textarea id="dwjbxxb_jyfwjy" name="dwjbxxb.jyfwjy" class="easyui-validatebox" rows="3" style="width:585px; height:52px;"
							data-options="validType:['maxLength[200]'],invalidMessage:'经营范围（兼营）不能超过200个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.jyfwjy}</textarea></td>
	    	       </tr>
	    	         <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营方式：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_jyfsdm' name='dwjbxxb.jyfsdm' value="${dwjbxxb.jyfsdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_DW_JYFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	   <td width="20%" class="dialogTd" align="right">经济类型：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_jyxzdm' name='dwjbxxb.jjlxdm' value="${dwjbxxb.jjlxdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	   
		    	   </tr>
		    	   <tr class="dialogTr">
		    	   <td width="20%" class="dialogTd" align="right">停业日期：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id='dwjbxx_tyrq01' name='dwjbxxb.tyrq01' value="${dwjbxxb.tyrq01}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
			    	    <td width="20%" class="dialogTd" align="right">是否有房屋鉴定：</td>
			    	    <td width="30%" class="dialogTd">
			    	    <input class='easyui-combobox' type='text' id='dwjbxxb_sfyfwjddm' name='dwjbxxb.sfyfwjddm' value="${dwjbxxb.sfyfwjddm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	        </td>
			    	    
		    	   </tr>
		    	   <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">是否有消防鉴定：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_sfyxfjddm' name='dwjbxxb.sfyxfjddm' value="${dwjbxxb.sfyxfjddm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:sfyfwjddmOnchange"/></td>
			    	    <td width="20%" class="dialogTd" align="right">鉴定时间：</td>
			    	    <td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox' type='text' id='dwjbxx_jdsj' name='dwjbxxb.jdsj' value="${dwjbxxb.jdsj}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">是否周期性营业：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id='dwjbxxb_sfzqxyydm' name='dwjbxxb.sfzqxyydm' value="${dwjbxxb.sfzqxyydm}" style="width:200px;" 
			    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	    <td width="20%" class="dialogTd" align="right">核定容纳人数：</td>
			    	    <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dwjbxxb_hdrnrs" name="dwjbxxb.hdrnrs" value="${dwjbxxb.hdrnrs}" style="width:200px;" maxlength="6" 
		    	 			data-options="validType:['naturalNumber'],tipPosition:'left'"/></td>
		    	   </tr>
		    	     <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">周期性营业规律：</td>
			    	    <td width="80%" class="dialogTd" colspan="3"><textarea id="dwjbxxb_zqxyygl"    name="dwjbxxb.zqxyygl" class="easyui-validatebox" rows="3" style="width:585px; height:52px;"
							data-options="validType:['maxLength[500]'],invalidMessage:'周期性营业规律不能超过500个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.zqxyygl}</textarea></td>
	    	       </tr>
	    		   <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">网址：</td>
			    	    <td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="dwjbxxb_wz" name="dwjbxxb.wz" value="${dwjbxxb.wz}" style="width:585px;" maxlength="50" 
		    	 			data-options="tipPosition:'left'"/></td>
	    	       </tr> 
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3"><textarea id="dwjbxxb_bz" name="dwjbxxb.bz" class="easyui-validatebox" rows="2" style="width:585px; height:52px;"
							data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.bz}</textarea></td>
	    	       </tr>
    				
    				</table>
	    	       </div>
			</div>
			<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
				<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			</div>
</form>
</div>
</div>
</body>

<script type="text/javascript" >

var zrqdm = "${zrqdm}";
var dwbmCount = parseInt("${dwbmxxbArrayLength}");

$(document).ready(function(){
	sfblyyzzdmOnchange($("#dwjbxxb_sfblyyzzdm").val(), "")
	//如从单位入口进入，初始化单位信息
	$("#sjdwmc").val("${sjdwmc}");
	$("#sjdwid").val("${sjdwid}");
	$("#sjdw-box").val("${sjdwmc}");
	//$("#sjdw-box").combobox('disable');
	//单位选择组件
	initDepartmentSearch('sjdw-box', {glpcsid: ''}, 'sjdwid', 'sjdwmc', null, null);
    if($("#sfsyzrq").val()=="1"){
        //责任区只选择辖区内的地址
    	initAddressSearch('jzd1', {fxjdm:'${fxjdm}',pcsdm:'${pcsdm}',zrqdm:'${zrqdm}'}, 'dz_dwdzmlpdm', 'dz_dwdzmlpxz', 'jzd2', {text:'dz_dwdzxz',dzxzqh:'dz_dwdzssxdm',id:'dz_dwdzdm'}, null, null);

     }
    else{
         //不属于责任区的选择所有地址
    	initAddressSearch('jzd1', null, 'dz_dwdzmlpdm', 'dz_dwdzmlpxz', 'jzd2', {text:'dz_dwdzxz',dzxzqh:'dz_dwdzssxdm',id:'dz_dwdzdm'}, null, null);

        
        }
	//单位地址描述门楼地址选中【zhang_gouliang@founder.com】
	initAddressSearch('dzms_mldz', {}, 'dzms_dwdzmlpdm', 'dzms_dwdzmlpxz',null,null, null, null);
	//默认地址描述为只读模式
	setInputReadonly('dzms_mldz', true);
	setInputReadonly('dzms_chdz', true);
	setInputReadonly('dzms_sspcsmc', true);
	setInputReadonly('dzms_sszrqmc', true);
	setInputReadonly('entity_zbx', true);
	setInputReadonly('entity_zby', true);
	//必填验证
	setComboRequired('jzd1', true);
	setComboRequired('jzd2', true);
	//添加判断是新增或者修改页面逻辑
	var pk = $("#dwjbxxb_id").val();
	if(pk!=""){
		setInputReadonly('dwjbxxb_dwmc', true);
		setInputReadonly('jzd1', true);
		setInputReadonly('jzd2', true);
		$("#saveDiv").css("display","none");
		$("#_method").val("put");
		$("#jbxxForm").attr("action","<%=basePath%>sydw_dl/"+pk);
	}
	sfblyyzzdmOnchange("");
	sfyfwjddmOnchange("");
	$("#saveBotton").bind("click",function() {
		if ($("#jbxxForm").form('validate')) {
			if(radioBz==0){
				if($("#dz_dwdzdm").val() == ""){
					topMessager.alert('', '请先选择有效的单位地址！');
					$("#jzd2").find("input.combo-text").first().focus();
					return;
				}
			}else{
				if($("#entity_zbx").val() == ""||$("#dzms_sspcsmc").val()=="地址描述所属派出所"){
					topMessager.alert('', '请进行标点获取地址描述所属派出所、责<br><br>任区、坐标信息！');
					return;
				}
			}
			if ($("#dwjbxxb_yyzzqsrq").val() != "" && $("#dwjbxxb_yyzzjzrq").val() != "" && $("#dwjbxxb_yyzzqsrq").val() >  $("#dwjbxxb_yyzzjzrq").val()) {
				topMessager.alert('', '营业执照截止日期必须大于起始日期，请重新输入！');
				$("#jzrk_jzksrq").focus();
				return;
			}
			var bottonObject = this;
			if (buttonDisabled(bottonObject) == false) {
				return false;
			}	
			topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
				if (r) {
					//$('#dwjbxxb_dwlbdm').val($("#dwlbdm").combobox('getText'));
					var formObject = $("#jbxxForm");
					formObject.form('submit',{
						dataType : 'json',
						onSubmit: function() {
						},
						success: function(result) {
							buttonEnabled(bottonObject);
							result = parseReturn(result);
							if (result.status == 'success') { // 返回成功后执行的方法
								var openUrl =  "/sydwgl_dl/view";
								openUrl += "?id=" + result.saveID;
								//location.href = openUrl;
								exit_onclick();
								menu_open('实有单位编辑', openUrl);
							}
							else {
								topMessager.alert(MESSAGER_TITLE, result.message, 'error');
							}
						}
					});			
				}
				else {
					buttonEnabled(bottonObject);
				}
			});
		}
	});
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
	
	if("${dwjbxxb.dzms_sspcsdm}"!=""&&"${dwjbxxb.dzms_zbx}"!=""){
		onRadioClick(1);
		$("input[name=dzRadio][value=1]").attr("checked",true);
		$("#dzms_sspcsmc").val("${dwjbxxb.dzms_sspcsmc}");
		$("#dzms_sszrqmc").val("${dwjbxxb.dzms_sszrqmc}");
	}else{
		onRadioClick(0);
	}
	//判断
	if("${dwjbxxb.dz_dwdzdm}"!=""){
		document.getElementById("dwbzdzRadio").disabled = "disabled";
		document.getElementById("dwdzmsRadio").disabled = "disabled";
		setInputReadonly('jzd1', true);
		setInputReadonly('jzd2', true);
	}
});
/**
 * @title:onRadioClick
 * @description:单位标准地址输入后判断单位地址描述是【禁用】还是【启用】
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-03-11 11:19:34
 */
var radioBz = 0; 
function onRadioClick(bz){
	 radioBz = bz;
	 if(bz==0){
		 setInputReadonly('jzd1', false);
		 setInputReadonly('jzd2', false);
		 setInputReadonly('dzms_mldz', true);
		 setInputReadonly('dzms_chdz', true);
		 //必填校验
		 setComboRequired('jzd1', true);
		 setComboRequired('jzd2', true);
		 setComboRequired('dzms_mldz', false);
		 document.getElementById("dtbdButton").disabled = "disabled";
		 //重置单位地址描述
		 $("#dzms_mldz").combobox("clear");
		 $("#dzms_dwdzmlpdm").val("");
		 $("#dzms_dwdzmlpxz").val("");
		 $("#dzms_chdz").val("");
		 $("#dzms_sspcsmc").val("地址描述所属派出所");
		 $("#dzms_sszrqmc").val("地址描述所属责任区");
		 $("#dzms_sspcsdm").val("");
		 $("#dzms_sszrqdm").val("");
		 $("#entity_zbx").val("");
		 $("#entity_zby").val("");
	 }else if(bz==1){
		 setInputReadonly('jzd1', true);
		 setInputReadonly('jzd2', true);
		 setInputReadonly('dzms_mldz', false);
		 setInputReadonly('dzms_chdz', false);
		 //必填校验
		 setComboRequired('jzd1', false);
		 setComboRequired('jzd2', false);
		 setComboRequired('dzms_mldz', true);
		 document.getElementById("dtbdButton").disabled = "";
		 //重置单位标准地址
		 $("#jzd1").combobox("clear");
		 $("#dz_dwdzmlpdm").val("");
		 $("#dz_dwdzmlpxz").val("");
		 $("#jzd2").combobox("clear");
		 $("#dz_dwdzdm").val("");
		 $("#dz_dwdzssxdm").val("");
		 $("#dz_dwdzxz").val("");
	 }
};
function dwdzOnSelect(dwdzComboID) { // 单位选择事件
	if (dwdzComboID) {
		var dwIndex = dwdzComboID.substring(dwdzComboID.indexOf("_") + 1);
		if (dwIndex != "") {
			var dz_dwdzdm = $("#dz_dwdzdm" + dwIndex).val();
			if (dz_dwdzdm != "" && $("#dwjbxxb_dwmc").val() != "") {
				$.ajax({
					type:"POST",
					url:"<%=basePath%>dwjbxxb_dl/queryExistDw",
					dataType:"json",
					data:"id="+$('#dwjbxxb_id').val()+"&dz_dwdzdm="+dz_dwdzdm+"&dwmc="+$("#dwjbxxb_dwmc").val(),
					success:function(data){
						if (data && data.isExist) {
							if (data.isExist == "true") {
								topMessager.alert('', '该地址下单位信息已存在，请重新选择！');
							}
						}
					},
					error: function() {
					}
				});
			}
		}
	}
}



function addDwbm(){
	var tr1 = $('<tr id="dwbm1Tr'+ dwbmCount +'"><td  height="10"></td></tr>');
	var tr2 = $('<tr id="dwbm2Tr'+ dwbmCount +'" height="24"></tr>');
	
	var td1 = $('<td width="20%" class="dialogTd" align="right">单位别名：</td>');
	
	var td3 = $('<td width="80%" id="dwbmTd'+ dwbmCount +'" colspan="3" class="dialogTd"></td>');
	var td3HTML = new StringBuffer();
	td3HTML.append('&nbsp;<input class="easyui-validatebox" type="text" name="dwbmxxbArray['+dwbmCount+'].dwbm" id="dwbm1_'+ dwbmCount +'" maxlength="50" style="width:560px;" data-options="tipPosition:\'left\'"/>');
	td3HTML.append('&nbsp;<a class="delLine_btn" href="javascript:void(0);" onclick="delDwbm('+ dwbmCount +')" title="注销当前单位别名"></a>');
	td3.html(td3HTML.toString());
	//var td2 = $('<td></td>');
	//var td2HTML = new StringBuffer();
	//td2HTML.append('');
	//td2.html(td2HTML.toString());
	tr2.append(td1);
	tr2.append(td3);
	//tr2.append(td2);
	$('#dwbmTable').append(tr1);
	$('#dwbmTable').append(tr2);
	$.parser.parse('#dwbmTd' + dwbmCount);
	dwbmCount++;
}

function delDwbm(bmNo){
	setInputReadonly('dwbm' + bmNo, true);
	$("#xt_zxbz" + bmNo).val("1");
	$("#dwbm1Tr" + bmNo).hide();
	$("#dwbm2Tr" + bmNo).hide();
	$("#dwbm1_" + bmNo).val("");
}


function sfblyyzzdmOnchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	if ($("#dwjbxxb_sfblyyzzdm").combobox('getValues') == "1") {
		setInputReadonly('dwjbxxb_yyzzdm', false);
		setInputReadonly('dwjbxxb_yyzzqsrq', false);
		setInputReadonly('dwjbxxb_yyzzjzrq', false);
		setInputReadonly('dwjbxxb_yyzzfzjg', false);
		setInputReadonly('dwjbxxb_zczj', false);
		setInputReadonly('dwjbxxb_zzjgzh', false);
		setInputReadonly('dwjbxxb_swdjzh', false);
		setInputReadonly('dwjbxxb_yyzzfzjgid',false);
	}
	else {
		setInputReadonly('dwjbxxb_yyzzdm', true);
		setInputReadonly('dwjbxxb_yyzzqsrq', true);
		setInputReadonly('dwjbxxb_yyzzjzrq', true);
		setInputReadonly('dwjbxxb_yyzzfzjg', true);
		setInputReadonly('dwjbxxb_zczj', true);
		setInputReadonly('dwjbxxb_zzjgzh', true);
		setInputReadonly('dwjbxxb_swdjzh', true);
		setInputReadonly('dwjbxxb_yyzzfzjgid', true);
		$("#dwjbxxb_yyzzfzjgid").val("");
		$("#dwjbxxb_yyzzdm").val("");
		$("#dwjbxxb_yyzzqsrq").val("");
		$("#dwjbxxb_yyzzjzrq").val("");
		$("#dwjbxxb_yyzzfzjg").val("");
		$("#dwjbxxb_zczj").val("");
		$("#dwjbxxb_zzjgzh").val("");
		$("#dwjbxxb_swdjzh").val("");
	}
}

function sfyfwjddmOnchange(newVal, oldVal) {
	if ($("#dwjbxxb_sfyxfjddm").combobox('getValues') == "1") {
		setInputReadonly('dwjbxx_jdsj', false);
	}
	else {
		setInputReadonly('dwjbxx_jdsj', true);
		$("#dwjbxx_jdsj").val("");
	}
}




function doInit(paramArray) {
}
function beforeSubmit() {
}
function afterSubmit() {
	var pk = $("#dwjbxxb_id").val();
	if(pk!=""){
	parent.location.reload();
	}
	
}
function exit_onclick() {
	closeSelf();
}
</script>
</html>