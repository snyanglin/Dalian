<!--  

	@备注：功能暂时没有用到，所以不进行修改
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实有单位核实</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
</head>
<body style="margin-top:20px" class="bodybg">
	   <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
    			<form action="<%=basePath%>dwjbxxb/saveDwjbxxbHs" id="jbxxForm" name="jbxxForm" method="post">
   		   		  <input type='hidden' id="pcsdmFilter" value="${pcsdm}"/>
    	   		  <input type='hidden' id="zrqdmFilter" value="${zrqdm}"/>
   		   		  <input type='hidden' name='dwjbxxb.id' id="dwjbxxb_id" value="${dwjbxxb.id}"/>
   		   		  <input type='hidden' id="dwidString" value="${dwidString}"/>
   		   		  <input type='hidden' id="nextDwid" value="${nextDwid}"/>
   		  		  <input type='hidden' id='hslx' name='hslx'/>
	    	      <div class="easyui-accordion" data-options="multiple:true"  >
    		        <div title="基本信息" id="baseInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">   
    			   <table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
	    		    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">单位名称：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	   		 <input class="easyui-validatebox" type="text" id="dwjbxxb_dwmc" name="dwjbxxb.dwmc" value="${dwjbxxb.dwmc}" maxlength="50" style="width:595px;" 
		    	 			 data-options="required:true,tipPosition:'left'"/>
		    	 		</td>
	    	       </tr>	    		   
	    		   <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">单位类型：</td>
				    	<td width="30%" class="dialogTd" >
				    		<input class="easyui-combobox" type="text" id="dwlbdm" name="dwlbdmValue" value="${dwjbxxb.dwlbdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/D_DW_DWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
							<input type='hidden' name='dwlbdm' id="dwjbxxb_dwlbdm" value="${dwjbxxb.dwlbdm}"/>
						</td> 
						<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.lxdh' id="dwjbxxb_lxdh" value="${dwjbxxb.lxdh}" style="width:200px;" maxlength="18" 
			    	    	data-options="required:false,validType:['phone']"/>
			    	    </td>
	    	       </tr>	    	       
	    	       <tr class="dialogTr">
			       		<td width="20%" class="dialogTd" align="right">单位地址：</td>
						<td width="50%" class="dialogTd" colspan="2">
							<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${dwjbxxb.dz_dwdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
							<input type='hidden' name='dwjbxxb.dz_dwdzmlpdm' id="dz_dwdzmlpdm" value="${dwjbxxb.dz_dwdzmlpdm}"/>
							<input type='hidden' name='dwjbxxb.dz_dwdzmlpxz' id="dz_dwdzmlpxz" value="${dwjbxxb.dz_dwdzmlpxz}"/></td>
						<td width="30%" class="dialogTd">
					    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(dwjbxxb.dz_dwdzxz, dwjbxxb.dz_dwdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='dwjbxxb.dz_dwdzdm' id='dz_dwdzdm' value="${dwjbxxb.dz_dwdzdm}" />
					    	<input type='hidden' name='dwjbxxb.dz_dwdzssxdm' id='dz_dwdzssxdm' value="${dwjbxxb.dz_dwdzssxdm}" />
					    	<input type='hidden' name='dwjbxxb.dz_dwdzxz' id='dz_dwdzxz' value="${dwjbxxb.dz_dwdzxz}" /> 
				    	</td>	
		    	   </tr>	    	       
	    	       <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">单位状态：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_dwztdm' name='dwjbxxb.dwztdm' value="${dwjbxxb.dwztdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_DW_DWZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	  <td width="20%" class="dialogTd" align="right">单位编码：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox inputreadonly'  readonly="readonly"  type='text' id='dwjbxxb_zagldwbm' name='dwjbxxb.zagldwbm' value="${dwjbxxb.zagldwbm}" style="width:200px;"/>
			    	    </td>
		    	   </tr>
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">开业日期：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_kyrq' name='dwjbxxb.kyrq' value="${dwjbxxb.kyrq}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
			    	    <td width="20%" class="dialogTd" align="right">营业时间：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_yysj' name='dwjbxxb.yysj' value="${dwjbxxb.yysj}" style="width:200px;"
			    	        data-options="required:false" maxlength="200" title="例如：早09：00~晚21：30"/>
			    	    </td>
			    	</tr>
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营范围（主营）：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="dwjbxxb_jyfwzy" name="dwjbxxb.jyfwzy" class="easyui-validatebox" rows="3" style="width:595px; height:52px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'经营范围（主营）不能超过1000个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.jyfwzy}</textarea>
						</td>
	    	       </tr>	    	       
	    	       <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营面积(平方米)：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_jymj" name="dwjbxxb.jymj_mjpfm" value="${dwjbxxb.jymj_mjpfm}" style="width:200px;" 
		    	 			data-options="validType:['numeric[\'f\',2]'],invalidMessage:'经营面积为两位小数的数字，请重新输入！',tipPosition:'left'"/>
		    	 		</td>
		    	  <td width="20%" class="dialogTd" align="right">重点单位标识：</td>
			    	    <td width="30%" class="dialogTd">
			    	   		<input class='easyui-combobox' type='text' id='dwjbxxb_zddwbs' name='dwjbxxb.zddwbs' value="${dwjbxxb.zddwbs}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	    </td>
		    	   </tr>
	    	       <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">是否外资单位：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfwzdwdm' name='dwjbxxb.sfwzdwdm' value="${dwjbxxb.sfwzdwdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	    </td>
			    	    <td width="20%" class="dialogTd" align="right">是否涉外单位：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfswdwdm' name='dwjbxxb.sfswdwdm' value="${dwjbxxb.sfswdwdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	    </td>			    	    
		    	   </tr>
		    	    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">管理级别：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox' type='text' id="dwjbxxb_gljbdm" name='dwjbxxb.gljbdm' value="${dwjbxxb.gljbdm}" style="width:200px;" 
		    	            data-options="url: contextPath + '/common/dict/D_DW_GLJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:gljbdmOnchange"/>
		    	        </td> 
				    	<td width="20%" class="dialogTd" align="right">管理部门：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox inputreadonly'  readonly="readonly" type='text' id="dwjbxxb_glbm" style="width:200px;" data-options="tipPosition:'left'"/>
		    	            <input type='hidden' name='dwjbxxb.glbmid' id="dwjbxxb_glbmid" value="${dwjbxxb.glbmid}"/>
		    	            <input type='hidden' name='dwjbxxb.glpcsid' id="dwjbxxb_glpcsid" value="${dwjbxxb.glpcsid}"/>
		    	            <input type='hidden' name='dwjbxxb.glfxjid' id="dwjbxxb_glfxjid" value="${dwjbxxb.glfxjid}"/>
		    	        </td> 
	    	       </tr>
	    	       </table>
	    	       </div>
	    	       <div title="补充信息" id="otherInfoTypeDiv"  data-options="selected:true" style="overflow:auto;padding:10px;">   
    				<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
    				<tr class="dialogTr">
			    	  
			    	    <td width="100%" class="dialogTd" colspan="4" valign="top">
			    	    <table border="0" cellpadding="0" cellspacing="0" width="100%" id="dwbmTable">
				    	   	 <c:forEach items="${dwbmxxbArray}" var="dwbmxxb" varStatus="status">
					       			<c:if test="${status.index > 0}">
										<tr id="dwbm1Tr${status.index}">
											<td  height="10"></td>
										</tr>
					       			</c:if>
								<tr  width="100%"  id="dwbm2Tr${status.index}" height="24" class="dialogTr">
										<td width="20%" class="dialogTd"  id="dwbmTd{status.index}" align="right">单位别名：</td>
						    	   		<td width="80%" colspan="3" id="dwbmTd{status.index}" class="dialogTd" > 
						    	   			&nbsp;<input class="easyui-validatebox" type="text" id="dwbm1_${status.index}" name="dwbmxxbArray[${status.index}].dwbm" value="${dwbmxxb.dwbm}" maxlength="50" 
						    	   			style="width:572px;" data-options="tipPosition:'left'"/>			    	    	
				    	    				<c:choose>
									 		    <c:when test="${status.index == 0}"><a class="addLine_btn" href="javascript:void(0);" onclick="addDwbm();" title="增加一个单位别名"></a>
									 		    </c:when>
									   			<c:otherwise><a class="delLine_btn" href="javascript:void(0);" onclick="delDwbm('${status.index}')" title="注销当前单位别名"></a>
									   		    </c:otherwise>
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
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.dwywmc' id="dwjbxxb_dwywmc" value="${dwjbxxb.dwywmc}" style="width:200px;" maxlength="100" 
			    	    	data-options="required:false"/>
			    	    </td>
			    	    <td width="20%" class="dialogTd" align="right">单位英文缩写：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.dwywsx' id="dwjbxxb_dwywsx" value="${dwjbxxb.dwywsx}" style="width:200px;" maxlength="100" 
			    	    	data-options="required:false,tipPosition:'right'"/>
			    	    </td>
		    	    </tr>		    	    
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">行业类别：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_hylbdm' name='dwjbxxb.hylbdm' value="${dwjbxxb.hylbdm}" style="width:200px;"
			    	         data-options="url: contextPath + '/common/dict/D_DW_HYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	    </tr>
    				<tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">是否办理营业执照：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfblyyzzdm' name='dwjbxxb.sfblyyzzdm' value="${dwjbxxb.sfblyyzzdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:sfblyyzzdmOnchange"/></td>
			    	    <td width="20%" class="dialogTd" align="right">营业执照号：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_yyzzdm" name="dwjbxxb.yyzzh" value="${dwjbxxb.yyzzh}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/>
		    	 		</td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">营业执照有效期起始日期：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' id='dwjbxxb_yyzzqsrq' name='dwjbxxb.yyzzyxq_qsrq' value="${dwjbxxb.yyzzyxq_qsrq}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	    </td>
			    	    <td width="20%" class="dialogTd" align="right">营业执照有效期截止日期：</td>
			    	    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id='dwjbxxb_yyzzjzrq' name='dwjbxxb.yyzzyxq_jzrq' value="${dwjbxxb.yyzzyxq_jzrq}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'dwjbxxb_yyzzqsrq\') || \'%y-%M-%d\'}'})"/>
			    	    </td>
		    	   </tr>
    				 <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">营业执照发证机关：</td>
			    	    <td width="30%" class="dialogTd" >
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_yyzzfzjg" name="dwjbxxb.yyzzfzjg" value="${dwjbxxb.yyzzfzjg}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/>
		    	 		</td>
		    	 		<td width="20%" class="dialogTd" align="right">营业执照发证机关Id：</td>
			    	    <td width="30%" class="dialogTd" >
			    	    	<input class="easyui-validatebox" type="text" name='dwjbxxb.yyzzfzjgid' id="dwjbxxb_yyzzfzjgid" value="${dwjbxxb.yyzzfzjgid}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/>
		    	 		</td>
	    	       </tr>
	    	        <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">组织机构证号：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_zzjgzh" name="dwjbxxb.zzjgdm" value="${dwjbxxb.zzjgdm}" maxlength="50" style="width:200px;" 
		    	 			data-options="tipPosition:'left'"/>
		    	 		</td>
		    	 		<td width="20%" class="dialogTd" align="right">税务登记证号：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_swdjzh" name="dwjbxxb.swdjhm" value="${dwjbxxb.swdjhm}" maxlength="50" style="width:200px;" 
		    	 			data-options="charSet:'halfUpper',tipPosition:'right'"/>
		    	 		</td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">注册资金：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_zczj" name="dwjbxxb.zczb" value="${dwjbxxb.zczb}" style="width:200px;" maxlength="12" 
		    	 			data-options="validType:['numeric[\'f\',2]'],invalidMessage:'注册资金为两位小数的金额，请重新输入！',tipPosition:'right'"/>
		    	 		</td>
		    	    <td width="20%" class="dialogTd" align="right">传真号码：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' name='dwjbxxb.czhm' id="dwjbxxb_cz" value="${dwjbxxb.czhm}" style="width:200px;" maxlength="18" 
			    	    	data-options="required:false,validType:['phone'],tipPosition:'right'"/>
			    	    </td>
		    	   </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营范围（兼营）：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="dwjbxxb_jyfwjy" name="dwjbxxb.jyfwjy" class="easyui-validatebox" rows="3" style="width:595px; height:52px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'经营范围（兼营）不能超过1000个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.jyfwjy}</textarea>
						</td>
	    	       </tr>
	    	         <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">经营方式：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_jyfsdm' name='dwjbxxb.jyfsdm' value="${dwjbxxb.jyfsdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_DW_JYFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	    </td>
		    	  	    <td width="20%" class="dialogTd" align="right">经营类型：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_jyxzdm' name='dwjbxxb.jjlxdm' value="${dwjbxxb.jjlxdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_DW_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	    </td>
		    	   
		    	   </tr>
		    	   <tr class="dialogTr">
		    	   <td width="20%" class="dialogTd" align="right">停业日期：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' id='dwjbxx_tyrq01' name='dwjbxxb.tyrq01' value="${dwjbxxb.tyrq01}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	    </td>
			    	    <td width="20%" class="dialogTd" align="right">是否有房屋鉴定：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfyfwjddm' name='dwjbxxb.sfyfwjddm' value="${dwjbxxb.sfyfwjddm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	    </td>			    	    
		    	   </tr>
		    	   <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">是否有消防鉴定：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfyxfjddm' name='dwjbxxb.sfyxfjddm' value="${dwjbxxb.sfyxfjddm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:sfyfwjddmOnchange"/>
			    	    </td>
			    	    <td width="20%" class="dialogTd" align="right">鉴定时间：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-validatebox' type='text' id='dwjbxx_jdsj' name='dwjbxxb.jdsj' value="${dwjbxxb.jdsj}" style="width:200px;"
			    	        data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	    </td>
		    	    </tr>
		    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">是否周期性营业：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class='easyui-combobox' type='text' id='dwjbxxb_sfzqxyydm' name='dwjbxxb.sfzqxyydm' value="${dwjbxxb.sfzqxyydm}" style="width:200px;" 
			    	        data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
			    	     </td>
			    	    <td width="20%" class="dialogTd" align="right">核定容纳人数：</td>
			    	    <td width="30%" class="dialogTd">
			    	    	<input class="easyui-validatebox" type="text" id="dwjbxxb_hdrnrs" name="dwjbxxb.hdrnrs" value="${dwjbxxb.hdrnrs}" style="width:200px;" maxlength="6" 
		    	 			data-options="validType:['naturalNumber'],tipPosition:'left'"/>
		    	 		</td>
		    	   </tr>
		    	     <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">周期性营业规律：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="dwjbxxb_zqxyygl"    name="dwjbxxb.zqxyygl" class="easyui-validatebox" rows="3" style="width:595px; height:52px;"
							data-options="validType:['maxLength[500]'],invalidMessage:'周期性营业规律不能超过500个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.zqxyygl}</textarea>
						</td>
	    	       </tr>
	    		   <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="dwjbxxb_bz" name="dwjbxxb.bz" class="easyui-validatebox" rows="3" style="width:595px; height:52px;"
							data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${dwjbxxb.bz}</textarea>
						</td>
	    	       </tr>   				
    				</table>
	    	       </div>
		</form>
		 <div style="height:6px;font-size:1px;"></div>
		
		 <div style="height:180px;">
			<table id="lxrdg"></table>
		 </div>
		 <div style="height:420px;">
			<table id="cyrydg"></table>
		 </div>
		<div style="height:6px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="save1Botton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="cancel_onclick(this, '1')">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text" id="save1Text">注销</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;
			<a id="save2Botton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="save_onclick(this, '0','0')">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text" id="save2Text">核实</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;
			<a id="save2Botton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="save_onclick(this, '0','1')">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text" id="save3Text">核实并管理</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="exit_onclick()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">退出</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>
 	</td></tr></table>
</div>
</body>

<script type="text/javascript" >
var mainTabID = "${mainTabID}";
var pcsdm = "${pcsdm}";
var pcsmc = "${pcsmc}";
var fsxdm = "${fsxdm}";
var fsxmc = "${fsxmc}";
var dsjdm = "${dsjdm}";
var dsjmc = "${dsjmc}";
var zrqdm = "${zrqdm}";
var dwdzCount = parseInt("${dwdzzbArrayLength}");

$(document).ready(function(){
	$('#dwjbxxb_dwztdm').combobox('setValue','10');
	$('#dwjbxxb_sfzqxyydm').combobox('setValue','1');
	setInputReadonly('dwlbdm', true);
	setInputReadonly('dwjbxxb_dwmc', true);
	setInputReadonly('dwdz1_0', true);
	setInputReadonly('dwdz2_0', true);
	if ($('#nextDwid').val() != "") {
		$('#save1Text').html('注销并下一条');
		$('#save2Text').html('核实并下一条');
	}
	setInputReadonly('dwjbxxb_glbm', true);
	if ($("#dwjbxxb_gljbdm").combobox('getValues') == "") {
		$("#dwjbxxb_gljbdm").combobox('setValue', '3'); // 默认为派出所
	}
	sfblyyzzdmOnchange("");
	sfyfwjddmOnchange("");
	
	<c:forEach items="${dwdzzbArray}" var="dwdzzb" varStatus="status">
	initAddressSearch('dwdz1_${status.index}', {zrqdm:'#zrqdmFilter'}, 'dz_dwdzmlpdm${status.index}', 'dz_dwdzmlpxz${status.index}', 'dwdz2_${status.index}', {text:'dz_dwdzxz${status.index}',dzxzqh:'dz_dwdzssxdm${status.index}',id:'dz_dwdzdm${status.index}'}, 'dwdzOnSelect', 'dwdzOnSelect');
	</c:forEach>
	
	$("#lxrdg").datagrid({
		url:"<%=basePath %>dwfrfzrllyxxb/list",
		title:"法人\负责人\联络员",
		border:false,
		sortOrder:"desc",
		sortName:"xt_zhxgsj",
		queryParams:{dwid:$("#dwjbxxb_id").val()},
		idField:"id",
		fitColumns:false,
		columns:[[
			{field:"dwrylxdm",title:"单位人员类型",width:120,align:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_DWRYLX.js'},
			{field:"cyzjdm",title:"证件种类",align:'center',width:80,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_CYZJ.js'},
			{field:"zjhm",title:"证件号码",align:'center',width:120},
			{field:"xm",title:"姓名",align:'center',width:80},
			{field:"sfzgsrzdm",title:"是否在公司任职",align:'center',width:100,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SF.js'},
			{field:"zw",title:"职务",align:'center',width:100},
			{field:"lxdh",title:"联系电话",align:'center',width:90},
			{field:"true",title:"操作",align:'center',width:105,formatter:function(val,row,index){
				return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="lxrEdit(this,'+index+')">编辑</a>&nbsp;'+
					   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="lxrCancel(this, '+index+')">注销</a>&nbsp;';
			}}
		]],
		toolbar:[{
			text:"新增",
			iconCls:'icon-add',
			handler:function(){
				var editUrl = contextPath + "/dwfrfzrllyxxb/createPage";
				editUrl = editUrl + "?id=&dwid="+ $("#dwjbxxb_id").val();
				infoOpen2(editUrl,"法人\负责人\联络员新增",null,null,"reloadLxr",null,null);
			}
		}]
	});
	
	$("#cyrydg").datagrid({
		url:"<%=basePath %>cyryxxb/list",
		border:false,
		title:"从业人员",
		sortOrder:"desc",
		sortName:"xt_zhxgsj",
		queryParams:{dwid:$("#dwjbxxb_id").val()},
		idField:"id",
		columns:[[
			{field:"cyzjdm",title:"证件种类",align:'center',width:80,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_CYZJ.js'},
			{field:"zjhm",title:"证件号码",align:'center',width:120},
			{field:"xm",title:"姓名",align:'center',width:80},
			{field:"szbmmc",title:"所在部门",align:'center',width:110},
			{field:"zw",title:"职务",align:'center',width:100},
			{field:"pysj",title:"聘用时间",align:'center',width:100},
			{field:"lxdh",title:"联系电话",align:'center',width:100},
			{field:"true",title:"操作",align:'center',width:105,formatter:function(val,row,index){
				return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cyryEdit(this,'+index+')">编辑</a>&nbsp;'+
					   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cyryCancel(this, '+index+')">注销</a>&nbsp;';
			}}
		]],
		toolbar:[{
			iconCls:'icon-add',
			text:"新增",
			handler:function(){
				var editUrl = contextPath + "/cyryxxb/createPage";
				editUrl = editUrl + "?id=&dwid="+ $("#dwjbxxb_id").val();
				infoOpen2(editUrl,"从业人员新增",null,null,"reloadCyry",null,null);
			}
		}]
	});
});
function reloadCyry(){
	$("#cyrydg").datagrid("reload");
}
function reloadLxr(){
	$("#lxrdg").datagrid("reload");
}
function infoOpen2(editUrl,title,paramArray,confirm ,callback,dom,height){
   	openWindowWithSaveNext(false, null, window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		width: 850,
   		height:height?height:500
   		}, 
   		confirm?confirm:null, callback?callback:null,dom?dom:null
   	);
}

//修改单条
function cyryEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/cyryxxb/createPage';
	var opts = $("#cyrydg").datagrid("options");
	var rows = $("#cyrydg").datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit("cyrydg", 'editWindow', 
   		null,
  		{
   		title: '从业人员修改',
   		url: editUrl,
   		width: 850,
   		height: 500,
   		draggable:true
   		},
   		'您是否要保存数据？',"reloadCyry"
   	);
}
//修改单条
function lxrEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/dwfrfzrllyxxb/createPage';
	var opts = $("#lxrdg").datagrid("options");
	var rows = $("#lxrdg").datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField] +"&dwid="+$("#dwjbxxb_id").val();
	datagridEdit("lxrdg", 'editWindow', 
   		null,
  		{
   		title: '法人\负责人\联络员修改',
   		url: editUrl,
   		width: 850,
   		height: 500,
   		draggable:true
   		},
   		'您是否要保存数据？',"reloadLxr"
   	);
}
//删除单条
function cyryCancel(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/cyryxxb/delete';
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			var opts = $("#cyrydg").datagrid("options");
			var rows = $("#cyrydg").datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, "cyrydg");
			});
		}
	});
}
//删除单条
function lxrCancel(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwfrfzrllyxxb/delete';
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			var opts = $("#lxrdg").datagrid("options");
			var rows = $("#lxrdg").datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, "lxrdg");
			});
		}
	});
}
function save_onclick(bottonObject, hslx) {
	if ($("#jbxxForm").form('validate')) {
		for (var i = 0; i < dwdzCount; i++) {
			if ($('#dwdz2Tr' + i).css('display') != "none" && $("#dz_dwdzdm" + i).val() == "") {
				topMessager.alert('', '请先选择有效的单位地址！');
				$("#dwdzTd" + i).find("input.combo-text").first().focus();
				return;
			}
		}
		if ($("#dwjbxxb_yyzzqsrq").val() != "" && $("#dwjbxxb_yyzzjzrq").val() != "" && $("#dwjbxxb_yyzzqsrq").val() >  $("#dwjbxxb_yyzzjzrq").val()) {
			topMessager.alert('', '营业执照截止日期必须大于起始日期，请重新输入！');
			$("#jzrk_jzksrq").focus();
			return;
		}
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}	
		topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
			if (r) {
				$('#dwjbxxb_dwlbdm').val($("#dwlbdm").combobox('getText'));
				$('#hslx').val(hslx);
				var formObject = $("#jbxxForm");
				formObject.form('submit',{
					dataType : 'json',
					onSubmit: function() {
					},
					success: function(result) {
						buttonEnabled(bottonObject);
						result = parseReturn(result);
						if (result.status == 'success') { // 返回成功后执行的方法
						    parent.parent.BuildingInfo.buildShowImag("06");
							exit_onclick();
							 
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
}

function cancel_onclick(bottonObject, hslx) {
	if (buttonDisabled(bottonObject) == false) {
		return false;
	}	
	topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
		if (r) {
			$('#dwjbxxb_dwlbdm').val($("#dwlbdm").combobox('getText'));
			$('#hslx').val(hslx);
			var formObject = $("#jbxxForm");
			formObject.form('submit',{
				dataType : 'json',
				onSubmit: function() {
				},
				success: function(result) {
					buttonEnabled(bottonObject);
					result = parseReturn(result);
					if (result.status == 'success') { // 返回成功后执行的方法
						exit_onclick();
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

function exit_onclick() {
    parent.$('#tt').tabs('close',"单位核实装户"); 
}

function dwdzOnSelect(dwdzComboID) { // 单位选择事件
	if (dwdzComboID) {
		var dwIndex = dwdzComboID.substring(dwdzComboID.indexOf("_") + 1);
		if (dwIndex != "") {
			var dz_dwdzdm = $("#dz_dwdzdm" + dwIndex).val();
			if (dz_dwdzdm != "" && $("#dwjbxxb_dwmc").val() != "") {
				$.ajax({
					type:"POST",
					url:"<%=basePath%>dwjbxxb/queryExistDw",
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

function addDwdz() {
	var tr1 = $('<tr id="dwdz1Tr'+ dwdzCount +'"><td colspan="2" height="10"></td></tr>');
	var tr2 = $('<tr id="dwdz2Tr'+ dwdzCount +'" height="24"></tr>');
	var td1 = $('<td width="572" id="dwdzTd'+ dwdzCount +'"></td>');
	var td1HTML = new StringBuffer();
	td1HTML.append('<input class="easyui-combobox" id="dwdz1_'+ dwdzCount +'" style="width:350px;" data-options="required:true,mode:\'remote\',method:\'post\',panelHeight: 22,valueField:\'id\',textField:\'text\',selectOnNavigation:false,tipPosition:\'left\'"/>');
	td1HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].dz_dwdzmlpdm" id="dz_dwdzmlpdm'+ dwdzCount +'"/>');
	td1HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].dz_dwdzmlpxz" id="dz_dwdzmlpxz'+ dwdzCount +'"/>');
	td1HTML.append('&nbsp;&nbsp;');
	td1HTML.append('<input class="easyui-combobox" id="dwdz2_'+ dwdzCount +'" style="width:200px;" data-options="required:true,mode:\'remote\',method:\'post\',panelHeight: 22,valueField:\'id\',textField:\'text\',selectOnNavigation:false,tipPosition:\'left\'"/>');
	td1.html(td1HTML.toString());	       						
	var td2 = $('<td></td>');
	var td2HTML = new StringBuffer();
	td2HTML.append('<a class="delLine_btn" href="javascript:void(0);" onclick="delDwdz('+ dwdzCount +')" title="注销当前单位地址">&nbsp;&nbsp;&nbsp;</a>');
	td2HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].id" id="id'+ dwdzCount +'"/>');
	td2HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].dz_dwdzssxdm" id="dz_dwdzssxdm'+ dwdzCount +'"/>');
	td2HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].dz_dwdzdm" id="dz_dwdzdm'+ dwdzCount +'"/>');
	td2HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].dz_dwdzxz" id="dz_dwdzxz'+ dwdzCount +'"/>');
	td2HTML.append('<input type="hidden" name="dwdzzbArray['+ dwdzCount +'].xt_zxbz" id="xt_zxbz'+ dwdzCount +'"/>');
	td2.html(td2HTML.toString());
	tr2.append(td1);
	tr2.append(td2);
	$('#dwdzTable').append(tr1);
	$('#dwdzTable').append(tr2);
	$.parser.parse('#dwdzTd' + dwdzCount);
	initAddressSearch('dwdz1_' + dwdzCount, {zrqdm:'#zrqdmFilter'}, 'dz_dwdzmlpdm' + dwdzCount, 'dz_dwdzmlpxz' + dwdzCount, 'dwdz2_' + dwdzCount, {text:'dz_dwdzxz' + dwdzCount,dzxzqh:'dz_dwdzssxdm' + dwdzCount,id:'dz_dwdzdm' + dwdzCount}, 'dwdzOnSelect', 'dwdzOnSelect');
	dwdzCount++;
}


function delDwdz(dzNo) {
	setInputReadonly('dwdz' + dzNo, true);
	$("#xt_zxbz" + dzNo).val("1");
	$("#dwdz1Tr" + dzNo).remove();
	$("#dwdz2Tr" + dzNo).remove();
}

function gljbdmOnchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	if (newVal == "1") {
		$("#dwjbxxb_glbm").val(dsjmc);
		$("#dwjbxxb_glbmid").val(dsjdm);
		$("#dwjbxxb_glpcsid").val("");
		$("#dwjbxxb_glfxjid").val("");
		$("#pcsdmFilter").val("");
		$("#zrqdmFilter").val("");
	}
	else if (newVal == "2") {
		$("#dwjbxxb_glbm").val(fsxmc);
		$("#dwjbxxb_glbmid").val(fsxdm);
		$("#dwjbxxb_glpcsid").val("");
		$("#dwjbxxb_glfxjid").val(fsxdm);
		$("#pcsdmFilter").val("");
		$("#zrqdmFilter").val("");
	}
	else if (newVal == "3") {
		$("#dwjbxxb_glbm").val(pcsmc);
		$("#dwjbxxb_glbmid").val(pcsdm);
		$("#dwjbxxb_glpcsid").val(pcsdm);
		$("#dwjbxxb_glfxjid").val(fsxdm);
		$("#pcsdmFilter").val(pcsdm);
		$("#zrqdmFilter").val(zrqdm);
	}
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
	}
	else {
		setInputReadonly('dwjbxxb_yyzzdm', true);
		setInputReadonly('dwjbxxb_yyzzqsrq', true);
		setInputReadonly('dwjbxxb_yyzzjzrq', true);
		setInputReadonly('dwjbxxb_yyzzfzjg', true);
		setInputReadonly('dwjbxxb_zczj', true);
		setInputReadonly('dwjbxxb_zzjgzh', true);
		setInputReadonly('dwjbxxb_swdjzh', true);
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
	if ($("#dwjbxxb_sfyfwjddm").combobox('getValues') == "1") {
		setInputReadonly('dwjbxx_jdsj', false);
	}
	else {
		setInputReadonly('dwjbxx_jdsj', true);
		$("#dwjbxx_jdsj").val("");
	}
}

function zqxyy(){
	var s = $("#dwjbxxb_sfzqxyydm").combobox("getText");
	if(s=="是"){
		$("#zqyygltr").show();
	}else {
		$("#zqyygltr").hide();
	}
}

function doInit(paramArray) {
	
}
function beforeSubmit() {
}
function afterSubmit() {
}
</script>
</html>