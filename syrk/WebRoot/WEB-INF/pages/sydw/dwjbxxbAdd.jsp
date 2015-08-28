<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/common.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实有单位</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<style type="text/css">
	.pphoto_1{margin:0 0 0 0;width:auto; float:left;text-align:center;}
</style>
</head>
<body style="margin-top:20px" class="bodybg">
	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	    	<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
    			<form action="<%=basePath%>sydw" id="jbxxForm" name="jbxxForm" method="post" enctype="multipart/form-data">
		    	   <input type='hidden' id="pcsdmFilter" value="${pcsdm}"/>
		    	   <input type='hidden' id="_method" name="_method" />
		    	   <input type='hidden' id="zrqdmFilter" value="${zrqdm}"/>
		    	   <input type='hidden' name='dwjbxxb.glbmid' id="dwjbxxb_glbmid" value="${zrqdm}"/>
		    	   <input type='hidden' name='dwjbxxb.glpcsid' id="dwjbxxb_glpcsid" value="${pcsdm}"/>
		    	   <input type='hidden' name='dwjbxxb.glfxjid' id="dwjbxxb_glfxjid" value="${fsxdm}"/>
    			   <input type='hidden' name='hsrwid' id="hsrwid" value="${hsrwid}"/>
	    		   <input type='hidden' name='dwjbxxb.id' id="dwjbxxb_id" value="${dwjbxxb.id}"/>
	    		   <div class="easyui-accordion" data-options="multiple:true"  id="dwjbxx">
	    			   <div title="基本信息" id="baseInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">   
		    			   <table border="0" cellpadding="0" cellspacing="3" style="width: 100%;" align="center">
				    		   <tr class="dialogTr">
						    	    <td width="16%" class="dialogTd" align="right">单位名称：</td>
						    	    <td width="20%" class="dialogTd" >
						    	        <input class="easyui-validatebox" type="text" id="dwjbxxb_dwmc" name="dwjbxxb.dwmc" value="${dwjbxxb.dwmc}" 
						    	        maxlength="50" style="width:150px;" data-options="required:true,tipPosition:'right'"/>
					    	 		</td>
					    	 		<td width="16%" class="dialogTd" align="right">单位编码：</td>
						    	    <td width="20%" class="dialogTd">
						    	        <input class='easyui-validatebox inputreadonly' readonly="readonly"  type='text' id='dwjbxxb_zagldwbm' 
						    	         name='dwjbxxb.zagldwbm' value="${dwjbxxb.zagldwbm}" style="width:150px;"/>
						    	    </td>
						    	    <td width="28%" class="dialogTd" colspan="2" rowspan="11" style="vertical-align: top;">
						    	    	<div class="pphoto_1">
											<div id="topPhotoid" style="width:210px;height:260px;border:solid 1px #e2e2e2;text-align:center;">
												<img id="imgHeadPhoto" src="<%=basePath%>/images/zwtp.jpg" style="width: 208px; height: 258px;" alt="" />
											</div>
											<input onchange="PreviewImage(this,'imgHeadPhoto','topPhotoid');" type="file" name="uploadFile" id="upload" style="width:5px;" 
											style="position:absolute;z-index:10;right:80px;filter:alpha(opacity=0);opacity=0;"
										    class="easyui-validatebox" data-options="validType:['imgFile'],tipPosition:'left',invalidMessage:'请选择图片格式的文件！'" />
			 								<span info="dwid,DW_DWJBXXB,单位基本信息表" style="position:absolute;margin-top: 0px;right:75px;" class="addphoto"></span>
										</div>
						    	    </td>
				    	       </tr>
				    		   <tr class="dialogTr">
							    	<td width="16%" class="dialogTd" align="right">单位类别：</td>
							    	<td width="20%" class="dialogTd" >
							    	    <input class="easyui-combotree" type="text" id="dwlbdm" name="dwjbxxb.dwlbdm" value="${dwjbxxb.dwlbdm}" style="width:150px;"
										data-options="required:true,url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,required:true,panelWidth:250,panelHeight:265,
									    method:'get',editable:true,lines:true"/>
									</td> 
									<td width="16%" class="dialogTd" align="right">联系电话：</td>
						    	    <td width="20%" class="dialogTd">
						    	        <input class='easyui-validatebox' type='text' name='dwjbxxb.lxdh' id="dwjbxxb_lxdh" value="${dwjbxxb.lxdh}" style="width:150px;" maxlength="18" 
						    	    	data-options="required:false,validType:['phone']"/>
						    	    </td>
				    	       </tr> 
				    	       <tr class="dialogTr">
						       		<td width="16%" class="dialogTd" align="right">
						       		<input type="radio" id="dwbzdzRadio" name="dzRadio" checked="checked" value="0" onclick="onRadioClick(0);">单位标准地址：
						       		</td>
									<td width="20%" class="dialogTd" colspan="2">
										<input class="easyui-combobox" id="jzd1" style="width:270px;" value="${dwjbxxb.dz_dwdzmlpxz}" 
											data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
										<input type='hidden' name='dwjbxxb.dz_dwdzmlpdm' id="dz_dwdzmlpdm" value="${dwjbxxb.dz_dwdzmlpdm}"/>
										<input type='hidden' name='dwjbxxb.dz_dwdzmlpxz' id="dz_dwdzmlpxz" value="${dwjbxxb.dz_dwdzmlpxz}"/>
									</td>
									<td width="16%" class="dialogTd">
								    	<input class="easyui-combobox" id="jzd2"  style="width:150px;" value="${fn:replace(dwjbxxb.dz_dwdzxz, dwjbxxb.dz_dwdzmlpxz,'')}"
								    	 	data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								    	<input type='hidden' name='dwjbxxb.dz_dwdzdm' id='dz_dwdzdm' value="${dwjbxxb.dz_dwdzdm}" />
								    	<input type='hidden' name='dwjbxxb.dz_dwdzssxdm' id='dz_dwdzssxdm' value="${dwjbxxb.dz_dwdzssxdm}" />
								    	<input type='hidden' name='dwjbxxb.dz_dwdzxz' id='dz_dwdzxz' value="${dwjbxxb.dz_dwdzxz}" /> 
								    </td>	
					    	   </tr>
					    	   <!-- zhang_guoliang@Founder.com 新增地址描述【开始】-->
					    	   <tr class="dialogTr">
						       		<td width="16%" class="dialogTd" align="right" rowspan="1"><input type="radio" id="dwdzmsRadio" name="dzRadio" value="1" onclick="onRadioClick(1);">单位地址描述：</td>
									<td width="20%" class="dialogTd" colspan="2">
										<input class="easyui-combobox" id="dzms_mldz" style="width:270px;" value="${dwjbxxb.dzms_dwdzmlpxz}" 
											data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" >
										<input type='hidden' name='dwjbxxb.dzms_dwdzmlpdm' id="dzms_dwdzmlpdm" value="${dwjbxxb.dz_dwdzmlpdm}"/>
										<input type='hidden' name='dwjbxxb.dzms_dwdzmlpxz' id="dzms_dwdzmlpxz" value="${dwjbxxb.dzms_dwdzmlpxz}"/>
									</td>
									<td width="16%" class="dialogTd">
									    <input class="easyui-validatebox" name='dwjbxxb.dzms_chdz' id="dzms_chdz"  style="width:150px;"  value='${dwjbxxb.dzms_chdz}'>
								    </td>	
					    	   </tr>
					    	   <tr class="dialogTr">
					    	   		<td width="16%" class="dialogTd" align="right" rowspan="1"></td>
									<td width="20%" class="dialogTd" colspan="2">
										<input class="easyui-validatebox" id="dzms_sspcsmc" name="dwjbxxb.dzms_sspcsmc" style="width: 50%;" value="地址描述所属派出所">
										<input class="easyui-validatebox" id="dzms_sszrqmc" name="dwjbxxb.dzms_sszrqmc" style="width: 45%;" value="地址描述所属责任区">
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
				    	        	<td width="16%" class="dialogTd" align="right">单位状态：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_dwztdm' name='dwjbxxb.dwztdm' value="${dwjbxxb.dwztdm}" style="width:150px;"
						    	        data-options="url: contextPath + '/common/dict/D_DW_DWZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
						    	    </td>
						    	    <td width="16%" class="dialogTd" align="right">开业日期：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_kyrq' name='dwjbxxb.kyrq' value="${dwjbxxb.kyrq}" style="width:150px;"
						    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
						    	     </td>
					    	    </tr>
				    	        <tr class="dialogTr">
						    	    <td width="16%" class="dialogTd" align="right">经营面积(平方米)：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_jymj" name="dwjbxxb.jymj_mjpfm" value="${dwjbxxb.jymj_mjpfm}" style="width:150px;" 
					    	 			data-options="validType:['numeric[\'f\',2]'],invalidMessage:'经营面积为两位小数的数字，请重新输入！',tipPosition:'right'" maxlength="9"/>
					    	 		</td>
						    	    <td width="15%" class="dialogTd" align="right" title="例如：早09：00~晚21：30">营业时间：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_yysj' name='dwjbxxb.yysj' value="${dwjbxxb.yysj}" style="width:150px;"
						    	        data-options="required:false" maxlength="200" title="例如：早09：00~晚21：30"/>
						    	    </td>
						    	</tr>
				    	        <tr class="dialogTr">
						    	    <td width="16%" class="dialogTd" align="right">经营范围（主营）：</td>
						    	    <td width="55%" class="dialogTd" colspan="3">
						    	      <textarea id="dwjbxxb_jyfwzy" name="dwjbxxb.jyfwzy" class="easyui-validatebox" rows="3" style="width:430px; height:32px;"
									  	data-options="validType:['maxLength[200]'],invalidMessage:'经营范围（主营）不能超过200个汉字，请重新输入！',tipPosition:'right'">${dwjbxxb.jyfwzy}
									  </textarea>
									</td>
				    	       </tr>
				    	        <tr class="dialogTr">
						    	    <td width="16%" class="dialogTd" align="right">经营范围（兼营）：</td>
						    	    <td width="55%" class="dialogTd" colspan="3">
						    	    <textarea id="dwjbxxb_jyfwjy" name="dwjbxxb.jyfwjy" class="easyui-validatebox" rows="3" style="width:430px; height:32px;"
										data-options="validType:['maxLength[200]'],invalidMessage:'经营范围（兼营）不能超过200个汉字，请重新输入！',tipPosition:'right'">${dwjbxxb.jyfwjy}</textarea>
									</td>
				    	       </tr>
				    	       <tr class="dialogTr">
					    	  		<td width="16%" class="dialogTd" align="right">是否重点单位：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_zddwbs' name='dwjbxxb.zddwbs' value="${dwjbxxb.zddwbs}" style="width:150px;"
						    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
						    	    </td>
						    	    <td width="16%" class="dialogTd" align="right">是否办理营业执照：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfblyyzzdm' name='dwjbxxb.sfblyyzzdm' value="${dwjbxxb.sfblyyzzdm}" style="width:150px;"
						    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:sfblyyzzdmOnchange"/>
						    	    </td>
					    	   </tr>
				    	       <tr class="dialogTr">
					    	  		<td width="16%" class="dialogTd" align="right">组织机构：</td>
						    	    <td width="20%" class="dialogTd">
							    		<input type="hidden" id="dwjbxxb_zzjgdm" name="dwjbxxb.zzjgdm" value="${dwjbxxb.zzjgdm}"/>
							    		<input class="easyui-validatebox  inputreadonly" type="text" id="dwjbxxb_zzjgmc" name="dwjbxxb.zzjgmc" style="width:150px;" value="${dwjbxxb.zzjgmc}" maxlength="20" 
							    		data-options="required:false,tipPosition:'right'" readonly="readonly"/>
							    		<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'dwjbxxb_zzjgdm', 'dwjbxxb_zzjgmc', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
							    	</td>
	    						    <td width="16%" class="dialogTd" align="right">核定容纳人数：</td>
						    	    <td width="20%" class="dialogTd">
						    	        <input class='easyui-validatebox' type='text' id='dwjbxxb_hdrnrs' 
						    	         name='dwjbxxb.hdrnrs' value="${dwjbxxb.hdrnrs}" style="width:150px;"
						    	        data-options="required:false,validType:['naturalNumberRange[1,9999999999999]'],tipPosition:'left'"/>
						    	    </td>
					    	   </tr>
				    	       <tr class="dialogTr">
				    	       		<td width="16%" class="dialogTd" align="right">是否外资单位：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfwzdwdm' name='dwjbxxb.sfwzdwdm' value="${dwjbxxb.sfwzdwdm}" style="width:150px;"
						    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
						    	    </td>
						    	    <td width="16%" class="dialogTd" align="right">是否涉外单位：</td>
						    	    <td width="20%" class="dialogTd">
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfswdwdm' name='dwjbxxb.sfswdwdm' value="${dwjbxxb.sfswdwdm}" style="width:150px;"
						    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
						    	    </td>
					    	   </tr>
					    	   <tr class="dialogTr">
					    	   		<td  class="dialogTd" align="left" colspan="2" nowrap>是否安装治安管理信息系统：
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfazzaglxxxt' name='dwjbxxb.sfazzaglxxxt' value="${dwjbxxb.sfazzaglxxxt}" style="width:114px;"
						    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
						    	    </td>
						    	    <td class="dialogTd" align="left" colspan="2" nowrap>是否经消防安全验收合格：
						    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfyxfjddm' name='dwjbxxb.sfyxfjddm' value="${dwjbxxb.sfyxfjddm}" style="width:125px;"
						    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
						    	    </td>
					    	   </tr>
			    	       </table>
		    	       </div>
		    	       <div title="补充信息" id="otherInfoTypeDiv"  data-options="selected:true" style="overflow:auto;padding:10px;">   
	    			   <table border="0" cellpadding="0" cellspacing="3" style="width: 100%;" align="center">
		    				<tr class="dialogTr">
					    	    <td width="100%" class="dialogTd" colspan="6" valign="top">
						    	    <table border="0" cellpadding="0" cellspacing="2" width="100%" id="dwbmTable">
							    	   	 <c:forEach items="${dwbmxxbArray}" var="dwbmxxb" varStatus="status">
							       			<c:if test="${status.index > 0}">
												<tr id="dwbm1Tr${status.index}"><td  height="10"></td></tr>
							       			</c:if>
											<tr  width="100%"  id="dwbm2Tr${status.index}" height="24" class="dialogTr">
												<td width="15%" class="dialogTd"  id="dwbmTd{status.index}" align="right">单位别名：</td>
									    	   	<td width="85%" colspan="3" id="dwbmTd{status.index}" class="dialogTd" >
									    	   		<input class="easyui-validatebox" type="text" id="dwbm1_${status.index}" name="dwbmxxbArray[${status.index}].dwbm" value="${dwbmxxb.dwbm}" maxlength="50" 
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
					    	    <td width="15%" class="dialogTd" align="right">单位英文名称：</td>
					    	    <td width="19%" class="dialogTd">
					    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.dwywmc' id="dwjbxxb_dwywmc" value="${dwjbxxb.dwywmc}" style="width:140px;" maxlength="100" 
					    	    	data-options="required:false,validType:['letter']"/>
					    	    </td>
					    	    <td width="16%" class="dialogTd" align="right">单位英文缩写：</td>
					    	    <td width="18%" class="dialogTd">
					    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.dwywsx' id="dwjbxxb_dwywsx" value="${dwjbxxb.dwywsx}" style="width:130px;" maxlength="100" 
					    	    	data-options="required:false,validType:['letter']"/>
					    	    </td>
				    	   </tr>
				    	   <tr class="dialogTr">
					    	    <td width="15%" class="dialogTd" align="right">行业类别：</td>
					    	    <td width="19%" class="dialogTd">
					    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_hylbdm' name='dwjbxxb.hylbdm' value="${dwjbxxb.hylbdm}" style="width:140px;"
					    	        data-options="url: contextPath + '/common/dict/D_DW_HYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					    	    </td>
					    	    <td width="16%" class="dialogTd" align="right">营业执照号：</td>
					    	    <td width="18%" class="dialogTd">
					    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_yyzzdm" name="dwjbxxb.yyzzh" value="${dwjbxxb.yyzzh}" maxlength="50" style="width:130px;" 
				    	 			data-options="tipPosition:'left'"/>
				    	 		</td>
				    	 		<td width="15%" class="dialogTd" align="right">营业执照发证机关：</td>
					    	    <td width="20%" class="dialogTd" >
					    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_yyzzfzjg" name="dwjbxxb.yyzzfzjg" value="${dwjbxxb.yyzzfzjg}" maxlength="50" style="width:140px;" 
				    	 			data-options="tipPosition:'left'"/>
				    	 		</td>
				    	   </tr>
				    	   <tr class="dialogTr">
					    	    <td width="15%" class="dialogTd" align="right">营业执照起始日期：</td>
					    	    <td width="19%" class="dialogTd">
					    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_yyzzqsrq' name='dwjbxxb.yyzzyxq_qsrq' value="${dwjbxxb.yyzzyxq_qsrq}" style="width:140px;"
					    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					    	    </td>
					    	    <td width="16%" class="dialogTd" align="right">营业执照截止日期：</td>
					    	    <td width="18%" class="dialogTd">
					    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_yyzzjzrq' name='dwjbxxb.yyzzyxq_jzrq' value="${dwjbxxb.yyzzyxq_jzrq}" style="width:130px;"
					    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'dwjbxxb_yyzzqsrq\') || \'%y-%M-%d\'}'})"/>
					    	    </td>
					    	    <td width="15%" class="dialogTd" align="right">注册资本：</td>
					    	    <td width="20%" class="dialogTd">
					    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_zczj" name="dwjbxxb.zczb" value="${dwjbxxb.zczb}" style="width:140px;" maxlength="12" 
				    	 			data-options="validType:['numeric[\'f\',2]'],invalidMessage:'注册资金为两位小数的金额，请重新输入！',tipPosition:'right'"/>
				    	 		</td>
				    	   </tr>
			    	       <tr class="dialogTr">
				    	 		<td width="15%" class="dialogTd" align="right">税务登记证号：</td>
					    	    <td width="19%" class="dialogTd">
					    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_swdjzh" name="dwjbxxb.swdjhm" value="${dwjbxxb.swdjhm}" maxlength="50" style="width:140px;" 
				    	 			data-options="charSet:'halfUpper',tipPosition:'right'"/>
				    	 		</td>
				    	 		<td width="16%" class="dialogTd" align="right">经营方式：</td>
					    	    <td width="18%" class="dialogTd">
					    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_jyfsdm' name='dwjbxxb.jyfsdm' value="${dwjbxxb.jyfsdm}" style="width:130px;"
					    	        data-options="url: contextPath + '/common/dict/D_DW_JYFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					    	    </td>
				    	   		<td width="15%" class="dialogTd" align="right">经营性质：</td>
					    	    <td width="20%" class="dialogTd">
					    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_jyxzdm' name='dwjbxxb.jjlxdm' value="${dwjbxxb.jjlxdm}" style="width:140px;"
					    	        data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					    	    </td>
				    	   </tr>
				    	   <tr class="dialogTr">
				    	     	<td width="15%" class="dialogTd" align="right">是否周期性营业：</td>
					    	    <td width="19%" class="dialogTd">
					    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfzqxyydm' name='dwjbxxb.sfzqxyydm' value="${dwjbxxb.sfzqxyydm}" style="width:140px;" 
					    	        data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					    	    </td>
					    	    <td width="16%" class="dialogTd" align="right">周期性营业规律：</td>
					    	    <td width="18%" class="dialogTd">
					    	    	<input id="dwjbxxb_zqxyygl"    name="dwjbxxb.zqxyygl" class="easyui-validatebox" style="width:130px;"
									data-options="validType:['maxLength[500]'],invalidMessage:'周期性营业规律不能超过500个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.zqxyygl}</input>
								</td>
								<td width="15%" class="dialogTd" align="right">停业日期：</td>
					    	    <td width="20%" class="dialogTd">
					    	    	<input class='easyui-validatebox' type='text' id='dwjbxx_tyrq01' name='dwjbxxb.tyrq01' value="${dwjbxxb.tyrq01}" style="width:140px;"
					    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					    	    </td>
			    	       </tr>
			    		   <tr class="dialogTr">
			    		   		<td width="15%" class="dialogTd" align="right">传真号码：</td>
					    	    <td width="19%" class="dialogTd">
					    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.czhm' id="dwjbxxb_cz" value="${dwjbxxb.czhm}" style="width:140px;" maxlength="18" 
					    	    	data-options="required:false,validType:['phone'],tipPosition:'right'"/>
					    	    </td>
					    	    <td width="16%" class="dialogTd" align="right">网址：</td>
					    	    <td width="40%" class="dialogTd" colspan="3">
					    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_wz" name="dwjbxxb.wz" value="${dwjbxxb.wz}" style="width:130px;" maxlength="50" 
				    	 			data-options="tipPosition:'left'"/>
				    	 		</td>
			    	       </tr> 
			    	       <tr class="dialogTr">
					    	    <td width="16%" class="dialogTd" align="right">备注：</td>
					    	    <td width="80%" class="dialogTd" colspan="5">
					    	    	<textarea id="dwjbxxb_bz" name="dwjbxxb.bz" class="easyui-validatebox" rows="2" style="width:650px; height:52px;"
									data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.bz}</textarea>
								</td>
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
	var fxjdm = "${fxjdm}";
	var pcsdm = "${pcsdm}";
	var zrqdm = "${zrqdm}";
	var dwbmCount = parseInt("${dwbmxxbArrayLength}");
	var dzms_sspcsdm = "${dwjbxxb.dzms_sspcsdm}";
	var dzms_zbx = "${dwjbxxb.dzms_zbx}";
	var dzms_sspcsmc = "${dwjbxxb.dzms_sspcsmc}";
	var dzms_sszrqmc = "${dwjbxxb.dzms_sszrqmc}";
	var dz_dwdzdm = "${dwjbxxb.dz_dwdzdm}";
	var id = "${dwjbxxb.id}";
</script>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwjbxxbAdd.js"></script> 
</html>