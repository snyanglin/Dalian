<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实有房屋录入</title>
</head>

<body style="margin-top:20px" class="bodybg">

<div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
		    <form action="<%=basePath%>shhxxcj/saveCzfwhs" id="syfwForm" name="dataForm" method="post">
					<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						<input type="hidden" id="pk" name="fwjbxxb.id" value="${fwjbxxb.id}" />
						<input type="hidden" id="zrqdm" name="zrqdm" value="${zrqdm}" />
						<input type="hidden" id="housesId" name="housesId" value="${housesId}" />
						
						<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋基本信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋地址：</td>
							<td width="50%" class="dialogTd" colspan="2" id="fwdztd">
								<input class="easyui-combobox" id="syfw_fwdz1" style="width:400px;" value="${fwjbxxb.fwdz_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    		<input type='hidden' name='fwjbxxb.fwdz_mlpdm' id="syfw_dz_fwmlpdm" value="${fwjbxxb.fwdz_mlpdm}"/>
					    		<input type='hidden' name='fwjbxxb.fwdz_mlpxz' id="syfw_dz_fwmlpxz" value="${fwjbxxb.fwdz_mlpxz}"/>
					    		<input type='hidden' name='fwjbxxb.fwdz_zby' id="syfw_fwdz_zby" value="${fwjbxxb.fwdz_zby}"/>
					    		<input type='hidden' name='fwjbxxb.fwdz_zbx' id="syfw_fwdz_zbx" value="${fwjbxxb.fwdz_zbx}"/>
				    		</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-combobox" id="syfw_fwdz2" style="width:200px;" value='${fn:replace(fwjbxxb.fwdz_dzxz, fwjbxxb.fwdz_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='fwjbxxb.fwdz_dzid' id='syfw_dz_fwdzid' value="${fwjbxxb.fwdz_dzid}" />
						    	<input type='hidden' name='fwjbxxb.fwdz_xzqhdm' id='syfw_dz_fwdzxzqhdm' value="${fwjbxxb.fwdz_xzqhdm}" />
						    	<input type='hidden' name='fwjbxxb.fwdz_dzxz' id='syfw_dz_fwdzxz' value="${fwjbxxb.fwdz_dzxz}" /> 
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋性质：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-combobox" type="text" id="fwcqxzzldm" name="fwjbxxb.fwcqxzzldm" style="width:200px;" value="${fwjbxxb.fwcqxzzldm}"
								data-options="url:contextPath+'/common/dict/ZA_D_FWCQXZZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
							</td>
							<td width="20%" class="dialogTd" align="right">产权证号：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fwcqzh" name="fwjbxxb.fwcqzh" style="width:200px;" value="${fwjbxxb.fwcqzh}"
								maxlength="30" data-options="tipPosition:'right'"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋类别：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-combobox" type="text" id="fwlbdm" name="fwjbxxb.fwlbdm" style="width:200px;" value="${fwjbxxb.fwlbdm}"
								data-options="url:contextPath +'/common/dict/ZA_D_FWLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
							</td>
							<td width="20%" class="dialogTd" align="right">房屋用途：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-combobox" type="text" id="fwytdm" name="fwjbxxb.fwytdm" style="width:200px;" value="${fwjbxxb.fwytdm}"
								data-options="url:contextPath+'/common/dict/ZA_D_FWYTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋间数：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fwjs" name="fwjbxxb.fwjs" style="width:170px;" value="${fwjbxxb.fwjs}"
								data-options="validType:['naturalNumber'],tipPosition:'right'"  maxlength="5"/>（间）
							</td>
							<td width="20%" class="dialogTd" align="right">房屋面积：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fwmj_mjpfm" name="fwjbxxb.fwmj_mjpfm" style="width:130px;" value="${fwjbxxb.fwmj_mjpfm}"
								data-options="validType:['money'],invalidMessage:'房屋面积为两位小数的数字，请重新输入！',tipPosition:'left'" maxlength="20"/>（平方米）
							</td>
						</tr>
						<tr>
							<td width="20%" class="dialogTd" align="right">是否出租房：</td>
							<td width="30%" class="dialogTd">	
								<input class="easyui-combobox" type="text" id="sfczfw" name="fwjbxxb.sfczfw" style="width:200px;" value="${fwjbxxb.sfczfw}"
								data-options="url:contextPath+'/common/dict/BD_D_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>
							</td>
							<td width="20%" class="dialogTd" align="right"></td>
							<td width="30%" class="dialogTd">	
							</td>						
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">所属单位：</td>
							<td width="80%" class="dialogTd" colspan="3">
							<input type='hidden' name='fwjbxxb.fwssdw_dwid' id="fwssdw_dwid" value="${fwjbxxb.fwssdw_dwid}"/>
							<input type="hidden" id="fwssdw_dwmc" name='fwjbxxb.fwssdw_dwmc'  value=""/>
							<input class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" id="gzdw-box" maxlength="50" style="width:610px;"/>
							
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">备注：</td>
							<td width="80%" class="dialogTd" colspan="3">
								<textarea id="bz"   title="备注" name="fwjbxxb.bz"
					       			class="easyui-validatebox" style="width: 610px; height:50px;" 
									data-options="required:false,charSet:'halfUpper',validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'right'"
					       		>${fwjbxxb.bz }</textarea>
		       				</td>
						</tr>
						<tr class="czfwxx dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋出租信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="czfwxx dialogTr">
							<td width="20%" class="dialogTd" align="right">出租房间数：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-validatebox" type="text" id="cz_fjs" name="czfwxxb.cz_fjs" style="width:170px;" 
								data-options="validType:['naturalNumber'],tipPosition:'right'" maxlength="8"/>（间）
							</td>
							<td width="20%" class="dialogTd" align="right">出租面积：</td>
							<td width="30%" class="dialogTd">	
								<input class="easyui-validatebox" type="text" id="cz_mjpfm" name="czfwxxb.cz_mjpfm" value="" style="width:130px;" 
								data-options="validType:['money'],invalidMessage:'出租面积为两位小数或整数的数字，请重新输入！',tipPosition:'left'" maxlength="10"/>（平方米）
							</td>
						</tr>
						<tr class="czfwxx dialogTr">
							<!-- <td width="20%" class="dialogTd" align="right">出租居住人数：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-validatebox" type="text" id="cz_jzrs" name="czfwxxb.cz_jzrs" style="width:200px;" value=""
								data-options="validType:['naturalNumber'],tipPosition:'right'" maxlength="10"/></td> -->
							<td width="20%" class="dialogTd" align="right">出租日期：</td>
							<td width="30%" class="dialogTd">	
								<input class="easyui-validatebox" type="text" id="cz_rq" name="czfwxxb.cz_rq" value="${czfwxxb.cz_rq}" 
								style="width:200px;" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
							</td>
							<td width="20%" class="dialogTd" align="right">租金(元/月)	：</td>
							<td width="80%" class="dialogTd" colspan="3">
								<input class="easyui-validatebox" type="text" id="zj" name="czfwxxb.zj" style="width:200px;" value="${czfwxxb.zj}"
								data-options="validType:['money'],invalidMessage:'租金为两位小数或整数的数字，请重新输入！',tipPosition:'left'" maxlength="10"/>
							</td>
						</tr>
						<tr class="czfwxx dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋等级：</td>
						    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="fwdjdm" name="czfwxxb.fwdjdm" style="width:200px;" 
									data-options="url: contextPath + '/common/dict/BD_D_FWDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
						    </td>
					    </tr>
						<tr class="czfwxx dialogTr">
							<td width="20%" class="dialogTd" align="right">治安责任人：</td>
							<td width="30%" class="dialogTd" >
								<input type="hidden" id="zazrr_id" name="czfwxxb.zazrr_id" value="${sessionScope.userSession.userId }" style="width: 100;" />
							    <input type="text" class="easyui-validatebox" id="zazrr_xm" name="czfwxxb.zazrr_xm" style="width:150;" value="${sessionScope.userSession.userName }" />
							    <input type="button" id="orgbutton4" value="选择" onClick="public_singleSelectOrgUser('${zrqdm}', '', '', '03,04', '', '', 'zazrr_id', 'zazrr_xm', '', '', '', '', false, '', window, null, '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    
							</td>
							<td width="20%" class="dialogTd" align="right">责任书签订日期：</td>
							<td width="30%" class="dialogTd">	
								<input class="easyui-validatebox" type="text" id="zrs_qd_rq" name="czfwxxb.zrs_qd_rq" style="width:200px;" value="${nowtime }" 
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
							</td>
						</tr>
						<tr class="czfwxx dialogTr">
							<td width="20%" class="dialogTd" align="right">备注：</td>
							<td width="80%" class="dialogTd" colspan="3">
								<textarea id="czfbz"   title="备注" name="czfwxxb.bz"
					       			class="easyui-validatebox" style="width: 610px; height:50px;" 
									data-options="required:false,charSet:'halfUpper',validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'right'"
					       		></textarea>
		       				</td>
						</tr>
						<tr class="czfwxx dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">出租人信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="czfwxx dialogTr">
						    <td width="20%" class="dialogTd" align="right">证件种类：</td>
						    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czur_cyzjdm" name="czfwxxb.czur_cyzjdm" style="width:200px;" value=""
									data-options="url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:cuzrzjdm_onchange" />
						    </td>
						    <td width="20%" class="dialogTd" align="right">证件号码：</td>
							<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="czur_zjhm" name='czfwxxb.czur_zjhm' maxlength="18" value="" style="width:200px;float:left;" 
					    	        data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="czur_LoadDiv"></div></td>		
					    </tr>
				    	<tr class="czfwxx dialogTr">
				    	     <td width="20%" class="dialogTd" align="right">姓名：</td>
							 <td width="30%" class="dialogTd">
							   <input type="hidden" name="czfwxxb.czur_ryid" id="czur_ryid" value=""/>
							   <input class='easyui-validatebox' type='text' id="czur_xm" name='czfwxxb.czur_xm' value="" style="width:200px;"  maxlength="50"
					    	        data-options="required:true,charSet:'halfUpper',validType:['maxLength[50]']"/></td>
				    	    <td width="20%" class="dialogTd" align="right">联系电话：</td>
						    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='czfwxxb.czur_lxdh' id="czur_lxdh" maxlength="18" value="" onblur="checkLxdh('czur_lxdh','czur_ryid')" style="width:200px;" data-options="required:true,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" /></td>
				    	</tr>
					    <tr class="czfwxx dialogTr">
							 <td width="20%" class="dialogTd" align="right">外文姓：</td>
							 <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="czur_wwx" name='czfwxxb.czur_wwx' value="" style="width:200px;"  maxlength="40"
					    	        data-options="required:false,validType:['letterOrSpace']"/></td>
							 <td width="20%" class="dialogTd" align="right">外文名：</td>
							 <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="czur_wwm" name='czfwxxb.czur_wwm' value="" style="width:200px;"  maxlength="40"
					    	        data-options="required:false,validType:['letterOrSpace'],tipPosition:'left'"/>
					    	 </td> 
				    	</tr>
				    	<tr class="czfwxx dialogTr">
						    <td width="20%" class="dialogTd" align="right">与房主关系：</td>
						    <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="czur_yfzgx_rygxdm" name="czfwxxb.czur_yfzgx_rygxdm" style="width:200px;" 
									data-options="url: contextPath + '/common/dict/BD_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true" />
						    </td>
				    	<tr>
				    	<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋房主信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">证件种类：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-combobox" type="text" id="fz_cyzjdm" name="fwjbxxb.fz_cyzjdm" style="width:200px;" value="${fwjbxxb.fz_cyzjdm}" maxlength="100"
								data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:fzzjdm_onchange" />
							</td>
							<td width="20%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="30%" class="dialogTd">
					    	<input class='easyui-validatebox' type='text' id="fz_zjhm" name='fwjbxxb.fz_zjhm' maxlength="30" value="${fwjbxxb.fz_zjhm}" style="width:200px;float:left;" 
			    	        data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="fz_LoadDiv"></div></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">姓名：</td>
							<td width="30%" class="dialogTd"><input type="hidden" id="fz_ryid" name="fwjbxxb.fz_ryid" value="${fwjbxxb.fz_ryid}" />
								<input class="easyui-validatebox" type="text" id="fz_xm" name="fwjbxxb.fz_xm" style="width:200px;" value="${fwjbxxb.fz_xm}" maxlength="50"
								data-options="required:true,charSet:'halfUpper'" />
							</td>
							<td width="20%" class="dialogTd" align="right">联系电话：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="fz_lxdh" name='fwjbxxb.fz_lxdh' maxlength="18" value="${fwjbxxb.fz_lxdh}" style="width:200px;" 
				    	        data-options="required:true,charSet:'halfUpper',validType:['phone'],tipPosition:'left'" onblur="checkLxdh('fz_lxdh','fz_zjhm')"/></td>
						</tr>
						<tr class="dialogTr">  
							<td width="20%" class="dialogTd" align="right">外文姓：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fz_wwx" name="fwjbxxb.fz_wwx" style="width:200px;" value="${fwjbxxb.fz_wwx}" maxlength="40"
								data-options="required:false,validType:['letterOrSpace']" />
							</td>
							<td width="20%" class="dialogTd" align="right">外文名：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="fz_wwm" name='fwjbxxb.fz_wwm' maxlength="40" value="${fwjbxxb.fz_wwm}" style="width:200px;" 
				    	        data-options="required:false,validType:['letterOrSpace'],tipPosition:'left'"/></td>
						</tr>
						<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋托管人信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">  
							<td width="20%" class="dialogTd" align="right">证件种类：</td>
							<td width="30%" class="dialogTd"><input type="hidden" id="tgr_ryid" name="fwjbxxb.tgr_ryid" value="${fwjbxxb.tgr_ryid}" />
								<input class="easyui-combobox" type="text" id="tgr_cyzjdm" name="fwjbxxb.tgr_cyzjdm" style="width:200px;" value="${fwjbxxb.tgr_cyzjdm}" maxlength="100"
								data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:tgrzjdm_onchange" />
							</td>
							<td width="20%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="tgr_zjhm" name='fwjbxxb.tgr_zjhm' maxlength="30" value="${fwjbxxb.tgr_zjhm}" style="width:200px;float:left;" 
				    	        data-options="required:false,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="tgr_LoadDiv"></div></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">姓名：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="tgr_xm" name="fwjbxxb.tgr_xm" style="width:200px;" value="${fwjbxxb.tgr_xm}" maxlength="50"
								data-options="required:false,charSet:'halfUpper'" />
							</td>
							<td width="20%" class="dialogTd" align="right">联系电话：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="tgr_lxdh" name='fwjbxxb.tgr_lxdh' maxlength="18" value="${fwjbxxb.tgr_lxdh}" style="width:200px;" 
				    	        data-options="required:false,charSet:'halfUpper',validType:['phone'],tipPosition:'left'" onblur="checkLxdh('tgr_lxdh','tgr_zjhm')"/></td>
						</tr>
						<tr class="dialogTr">  
							<td width="20%" class="dialogTd" align="right">外文姓：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="tgr_wwx" name="fwjbxxb.tgr_wwx" style="width:200px;" value="${fwjbxxb.tgr_wwx}" maxlength="40"
								data-options="required:false,validType:['letterOrSpace']" />
							</td>
							<td width="20%" class="dialogTd" align="right">外文名：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="tgr_wwm" name='fwjbxxb.tgr_wwm' maxlength="40" value="${fwjbxxb.tgr_wwm}" style="width:200px;" 
				    	        data-options="required:false,validType:['letterOrSpace'],tipPosition:'left'"/></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">与房主关系：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-combotree" type="text" id="tgr_yfzgx_rygxdm" name="fwjbxxb.tgr_yfzgx_rygxdm" style="width:200px;" value="${fwjbxxb.tgr_yfzgx_rygxdm}"
								data-options="url:contextPath+'/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/>
							</td>
						</tr>
						
						<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋录入企业信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">注册名称：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.zcmc } </span>
							</td>
							<td width="20%" class="dialogTd" align="right">实际经营名称：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.sjjymc } </span>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">注册地址：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.zcdz } </span>
							</td>
							<td width="20%" class="dialogTd" align="right">实际经营地址：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.jydz } </span>
							</td>
						</tr>
							<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">负责人：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.sjjyrxm } </span>
							</td>
							<td width="20%" class="dialogTd" align="right">联系电话：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.sjjyrsj} </span>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">办公电话：</td>
							<td width="30%" class="dialogTd">
								<span>${enterprises.lxdh } </span>
							</td>
							
						</tr>
			    	</table>
		    </form>
		</div>
		<div style="height:6px;font-size:1px;"></div>

		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
		</div>
		</div>
	    </div>
	    </div>
    	</td></tr></table>
</div>
</body>

</html>
<script type="text/javascript" >

var mainTabID = "${mainTabID}";
var invokeJSMethod = "${invokeJSMethod}";
$(document).ready(function(){
	
	$("#sfczfw").combobox({onChange:sfczfw});
	setInputReadonly("sfczfw", true);
	
	//人员信息复用人员基本表
	$("#fz_zjhm").bind("blur",function(e){ checkRyxx("fz_",true); });
	$("#czur_zjhm").bind("blur",function(e){ checkRyxx("czur_"); });
	$("#tgr_zjhm").bind("blur",function(e){ checkRyxx("tgr_",true); });
	initAddressSearch('syfw_fwdz1', {zrqdm:'${zrqdm}'}, 'syfw_dz_fwmlpdm', 'syfw_dz_fwmlpxz', 'syfw_fwdz2', {text:'syfw_dz_fwdzxz',dzxzqh:'syfw_dz_fwdzxzqhdm',id:'syfw_dz_fwdzid',dzzbx:'syfw_fwdz_zbx',dzzby:'syfw_fwdz_zby'}, null, 'checkDzcf');
	initDepartmentSearch('gzdw-box', {glpcsid: ''}, 'fwssdw_dwid', 'fwssdw_dwmc', {},'queryFrByDwid');
	
	if('${type}' == '1'){
		$('#syfw_fwdz1').combobox('readonly');
		$('#syfw_fwdz2').combobox('readonly');
	}
	$("#saveBotton").bind("click",function() {
		if ($("#syfwForm").form('validate')) {
			if ($("#syfw_dz_fwdzid").val() == "") {
				topMessager.alert('', '请先选择有效的房屋地址！');
				$("#fwdzTd").find("input.combo-text").first().focus();
				return;
			}
			var bottonObject = this;
			if (buttonDisabled(bottonObject) == false) {
				return false;
			}	
			topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
				if (r) {
					var formObject = $("#syfwForm");
					formObject.form('submit',{
						dataType : 'json',
						onSubmit: function() {
						},
						success: function(result) {
							buttonEnabled(bottonObject);
							result = parseReturn(result);
							if (result.status == 'success') { // 返回成功后执行的方法
								/* var openUrl = "/syfw/"+result.saveID+"/main";
								//location.href = openUrl;
								exit_onclick();
								menu_open('实有房屋编辑', openUrl); */
								if (mainTabID != "" && invokeJSMethod != "") {
									
									executeTabPageMethod(mainTabID, invokeJSMethod);
								}
								closeSelf();
								
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
	$("#sfczfw").combobox("setValue","1");
	sfczfw();
	
});
var _zjhm = "";
function checkRyxx(rylx , isReat){ 
	if(!$("#"+rylx+"zjhm").validatebox("isValid")){
		return;
	}
	if($("#"+rylx+"zjhm").val() == _zjhm){
		//return;
	}
	if(isReat){
		if($("#fz_zjhm").val() == $("#tgr_zjhm").val()){
			topMessager.alert(MESSAGER_TITLE, "房主与托管人不能相同！", "warn");
			return ;
		}
	}
	$("#"+rylx+"LoadDiv").show();//显示加载进度图片
	$.ajax({
		type:"POST",
		url:"<%= basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#"+rylx+"zjhm").val()+"&cyzjdm="+$("#"+rylx+"cyzjdm").val(),
		success:function(data){
			if (data &&data.ryRyjbxxb) {
				if(data.ryRyjbxxb.xm !=null){
					$("#"+rylx+"ryid").val(data.ryRyjbxxb.id);
					$("#"+rylx+"xm").val(data.ryRyjbxxb.xm);
					$("#"+rylx+"xm").validatebox({required:true});
				}
				if(data.ryRyjbxxb.lxdh !=null){
					$("#"+rylx+"lxdh").val(data.ryRyjbxxb.lxdh);
					$("#"+rylx+"lxdh").validatebox({required:true});
				}
				//添加需要复用的值
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete:function(){
			_zjhm = $("#"+rylx+"zjhm").val();
			$("#"+rylx+"LoadDiv").hide();//复用完毕隐藏加载进度图片
		}
	});
}
/**
*出租房屋判读，是则出现出租房信息
*/
function sfczfw(){
	if($("#sfczfw").combobox('getValues')== "1"){
		$(".czfwxx").show();
		$("#zazrr_xm").validatebox({required:true});
		$("#zrs_qd_rq").validatebox({required:true});
		$("#czur_cyzjdm").combobox({required:true});
		$("#czur_yfzgx_rygxdm").combotree({required:true});    
		$("#czur_zjhm").validatebox({required:true});
		$("#czur_xm").validatebox({required:true});
		$("#czur_lxdh").validatebox({required:true});
	}else{
		$("#zazrr_xm").validatebox({required:false});
		$("#zrs_qd_rq").validatebox({required:false});
		$("#czur_zjhm").val("");
		$("#czur_zjhm").validatebox({required:false});
		$("#czur_cyzjdm").combobox({required:false});
		$("#czur_yfzgx_rygxdm").combotree({required:false}); 
		$("#czur_xm").validatebox({required:false});
		$("#czur_lxdh").validatebox({required:false});
		$(".czfwxx").hide(); 
	}
}
/**
 检查一个地址仅可有一个房屋
*/
function checkDzcf(){
	$.ajax({
		type:"GET",
		url:"<%= basePath%>syfw/checkdz/"+$("#syfw_dz_fwdzid").val(),
		dataType:"json",
		success:function(data){
			if (data) {
				$("#syfw_fwdz2").combobox("setValue","");
				topMessager.alert(MESSAGER_TITLE, "该地址下已有房屋！", "warn");
			}
		},
		complete:function(){
		
		}
	});
}
function fzzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#fz_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#fz_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
function tgrzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#tgr_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#tgr_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
function cuzrzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#czur_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#czur_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
function exit_onclick() {
	closeSelf();
}
function doInit(paramArray) {
	
}

function beforeSubmit(){
	
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
function queryFrByDwid(){
	$.ajax({
		type:"GET",
		url:"<%= basePath%>sydw_dl/"+$("#fwssdw_dwid").val()+"/fr",
		dataType:"json",
		success:function(data){
			if (data) {
				$("#fz_cyzjdm").combobox("setValue",data.cyzjdm);
				$("#fz_zjhm").val(data.zjhm);
				$("#fz_ryid").val(data.ryid);
				$("#fz_xm").val(data.xm);
				$("#fz_lxdh").val(data.lxdh);
			}
		},
		complete:function(){
		
		}
	});
}

</script>