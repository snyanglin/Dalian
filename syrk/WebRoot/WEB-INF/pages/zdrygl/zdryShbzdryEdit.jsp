<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>涉环保重点人员登记</title>
<script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryShbzdryAdd.js"></script>
<%
	SessionBean userInfo = (SessionBean) session
			.getAttribute("userSession");


	String ssfxj = "";
	String userOrgLevel =userInfo.getUserOrgLevel();
	if("31".equals(userOrgLevel)){
		ssfxj=userInfo.getExtendValue("ssFsxCode");
	}
%>

</head>

<body style="margin-top:20px; margin-bottom:10px" class="bodybg">

<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	<table height="100%" style="margin:0 auto;background-color: #fff;">
	<tr>
	<td valign="top">
		<div>
			<img id="topPhotoid" width="160" height="200" alt="" src="<%=contextPath%>/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=${zdryShbzdryxxb.ryid}&zjhm=${zdryShbzdryxxb.zjhm}&cyzjdm=${zdryShbzdryxxb.cyzjdm}" />
		</div>
	</td>
	<td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		
				
			<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
				<form action="<%=basePath%>zdryzb/shbzdry/update" id="shbUpdateForm" name="shbUpdateForm" method="post" enctype="multipart/form-data">
				
			<input type="hidden" id="id" name="id" value="${zdryShbzdryxxb.id}" />
				
				<table border="0" cellpadding="0" cellspacing="10" width="800px" align="center">
					<input type="hidden" id="ryid" name="ryid" value="${zdryShbzdryxxb.ryid}"/>
					<tr>
						<td width="20%" class="dialogTd" align="right">证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" value="${zdryShbzdryxxb.cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:cyzjdm_onChange"/></td> 
					    <td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" value="${zdryShbzdryxxb.zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'" onblur="zjhm_onblur()"/><div class="lodingimg" id="jbxxLoadDiv"></div></td>
					</tr>
					<tr class="dialogTr">
				    	
		    	        <td width="20%" class="dialogTd" align="right" id="xm_td">姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" value="${zdryShbzdryxxb.xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'left',required:true"/></td>
		    	        <td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" value="${zdryShbzdryxxb.xbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
					</tr>	
						<tr class="dialogTr">
				    	
				    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="csrq" name="csrq" value="${zdryShbzdryxxb.csrq}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
					    <td width="20%" class="dialogTd" align="right">民族：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" value="${zdryShbzdryxxb.mzdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
					</tr>
					 <tr class="dialogTr">
				        <td width="20%" class="dialogTd" align="right">联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" value="${zdryShbzdryxxb.lxdh}" style="width:200px;" maxlength="18"
							data-options="required:true,validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jbxx_lxdh','jbxx_id')"/></td>
					    <td width="20%" class="dialogTd" align="right">是否死亡：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfswdm" name="sfswdm" value="${zdryShbzdryxxb.sfswdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 				 
			       </tr>
				   <tr class="dialogTr">
				        <td width="20%" class="dialogTd" align="right">案件类别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ajlbdm" name="ajlbdm" value="${zdryShbzdryxxb.ajlbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/XZ_D_AJLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	 <td width="20%" class="dialogTd" align="right">作案特点：</td>
				         <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zatddm" name="zatddm" value="${zdryShbzdryxxb.zatddm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/>
		    	        </td>
				    </tr>
				     <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">简要案情：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    	<textarea cols="3" rows="3" class="easyui-validatebox" id="jyaq" name="jyaq" value="${zdryShbzdryxxb.jyaq}" style="width:595px;height:52px" maxlength="1000">${zdryShbzdryxxb.jyaq}</textarea>
				    	</td> 
					</tr>
			    	<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">主要问题及表现：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><textarea cols="3" rows="3" class="easyui-validatebox" id="zywtjxsbx" name="zywtjxsbx" value="${zdryShbzdryxxb.zywtjxsbx}" style="width:595px;height:52px" maxlength="1000">${zdryShbzdryxxb.zywtjxsbx}</textarea></td> 
					</tr>
					
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">处罚结果：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><textarea cols="3" rows="3" class="easyui-validatebox" id="cfjg" name="cfjg" value="${zdryShbzdryxxb.cfjg}" style="width:595px;" maxlength="100">${zdryShbzdryxxb.cfjg}</textarea></td> 
					</tr>
				
					
		 			<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">籍贯省市县(区)：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jgssxdm" name="jgssxdm" value="${zdryShbzdryxxb.jgssxdm}" style="width:200px;" 
	    	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>			
					    
					     <td width="20%" class="dialogTd" align="right">户籍地所属市县(区)：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hjdsssxdm" name="hjdsssxdm" value="${zdryShbzdryxxb.hjdsssxdm}" style="width:200px;" 
							data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td> 
					   
					</tr> 
					<tr class="dialogTr">

						<td width="20%" class="dialogTd" align="right">户籍地所属县级公安机关：</td>
						<td width="30%" class="dialogTd" ><input type="text" name="hjd_ssxjgajgdm" id="hjd_ssxjgajgdm"  value="${zdryShbzdryxxb.hjd_ssxjgajgdm}"
						   class="easyui-combobox" style="width:200px;"data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:hjdfj_onChange"></td>
						<td width="20%" class="dialogTd" align="right">户籍地所属派出所：</td>						
						<td width="30%" class="dialogTd" colspan="3"><input type="text" name="hjd_sspcsdm" id="hjd_sspcsdm" value="${zdryShbzdryxxb.hjd_sspcsdm}"
						   class="easyui-combobox" style="width:200px;" data-options="required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false"></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">户籍地址描述：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="hjd_dzms" id="hjd_dzms" value="${zdryShbzdryxxb.hjd_dzms}" style="width:595px;"/>
							<input type="hidden" id="hjd_xzqhdm" name="hjd_xzqhdm" value="${zdryShbzdryxxb.hjd_xzqhdm}"/>
							<input type="hidden" id="hjd_mlpdm" name="hjd_mlpdm" value="${zdryShbzdryxxb.hjd_mlpdm}"/>
							<input type="hidden" id="hjd_mlpxz" name="hjd_mlpxz" value="${zdryShbzdryxxb.hjd_mlpxz}"/>
							<input type="hidden" id="hjd_dzid" name="hjd_dzid" value="${zdryShbzdryxxb.hjd_dzid}"/>
							<input type="hidden" id="hjd_dzxz" name="hjd_dzxz" value="${zdryShbzdryxxb.hjd_dzxz}"/>
							
				    	</td> 
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">户籍地社区：</td>
					    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hjd_sq" name="hjd_sq" value="${zdryShbzdryxxb.hjd_sq}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/D_BZDZ_SQ3.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	
					</tr>
					<tr class="dialogTr">
					
						<td width="20%" class="dialogTd" align="right">居住地所属县级公安机关：</td>
						<td width="30%" class="dialogTd" ><input type="text" name="ssfxjdm" id="ssfxjdm"  value="${zdryShbzdryxxb.ssfxjdm}" 
						   class="easyui-combobox" style="width:200px;"data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:jzdfj_onChange"></td>
						<td width="20%" class="dialogTd" align="right">居住地所属派出所：</td>						
						<td width="30%" class="dialogTd" colspan="3"><input type="text" name="sspcsdm" id="sspcsdm"  value="${zdryShbzdryxxb.sspcsdm}" 
						   class="easyui-combobox" style="width:200px;" data-options="required:true,method:'get',
						   valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false"></td>
					</tr>
					
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地详址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jzd1" style="width:380px;" value="${zdryShbzdryxxb.dz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="dz_jzdzmlpdm" name="dz_jzdzmlpdm" value="${zdryShbzdryxxb.dz_jzdzmlpdm}"/>
					    	<input type="hidden" id="dz_jzd_mlpxz" name="dz_jzd_mlpxz" value="${zdryShbzdryxxb.dz_jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(zdryShbzdryxxb.dz_jzdzxz, zdryShbzdryxxb.dz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="dz_jzdzdm" name="dz_jzdzdm" value="${zdryShbzdryxxb.dz_jzdzdm}"/>
					    	<input type="hidden" id="dz_jzdzssxdm" name="dz_jzdzssxdm" value="${zdryShbzdryxxb.dz_jzdzssxdm}"/>
					    	<input type="hidden" id="dz_jzdzxz" name="dz_jzdzxz" value="${zdryShbzdryxxb.dz_jzdzxz}"/>
					    	<input type="hidden" id="zrqdm" value="${zrqdm}"/>
				    	</td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地社区：</td>
					    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzd_sq" name="jzd_sq" value="${zdryShbzdryxxb.jzd_sq}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/D_BZDZ_SQ3.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	
					
					</tr>
		
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">经常活动地区：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jchddq" name="jchddq" value="${zdryShbzdryxxb.jchddq}" style="width:595px;" maxlength="100"/></td> 
					</tr>
						<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">简历：</td>
				    	<td width="80%" class="dialogTd" colspan="3">                        
				    	<textarea class="easyui-validatebox" rows="3" cols="3" id="jl" name="jl" value="${zdryShbzdryxxb.jl}" style="width:595px;height:52px;" maxlength="1000">${zdryShbzdryxxb.jl}</textarea></td> 					    
					</tr>			
	
					<tr class="dialogTr">
					
					  	<td width="20%" class="dialogTd" align="right">人口编码：</td>
				    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" id="rkbm" name="rkbm" value="${zdryShbzdryxxb.rkbm}" style="width:200px;" maxlength="40"/></td> 
					
					    <td width="20%" class="dialogTd" align="right">数据密级：</td>
				    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" id="sjmj" name="sjmj" value="${zdryShbzdryxxb.sjmj}" style="width:200px;" maxlength="20"/></td> 
					
					</tr> 
		 	   <tr id="scpjs" style="display:none">
    	        <td>
                <input type="file" name="uploadFile" id="upload1" style="width:560px;" class="easyui-validatebox" data-options="tipPosition:'left',invalidMessage:'请选择要上传的判决书'" /></td>		    	
	    	</tr>  
					</table>
					
					</form>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:display;">
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="save()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="reset()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
			
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

 $(document).ready(function(){ 
	//alert("${zdryShbzdryxxb.ryid}");
	 if("${zdryShbzdryxxb.qx}"=="view"){
			setInputReadonly("cyzjdm", true);
			setInputReadonly("zjhm", true);
			setInputReadonly("xm", true);
			setInputReadonly("xbdm", true);
			setInputReadonly("csrq", true);
			setInputReadonly("mzdm", true);
			setInputReadonly("lxdh", true);
			setInputReadonly("sfswdm", true);
			setInputReadonly("jgssxdm", true);
			setInputReadonly("hjdsssxdm", true);
			setInputReadonly("hjd_ssxjgajgdm", true);
			setInputReadonly("hjd_sspcsdm", true);
			setInputReadonly("hjd_xzqhdm", true);
			setInputReadonly("hjd_mlpdm", true);
			setInputReadonly("hjd_mlpxz", true);
			setInputReadonly("hjd_dzid", true);
			setInputReadonly("hjd_dzxz", true);
			setInputReadonly("hjd_dzms", true);
			setInputReadonly("hjd_sq", true);
			setInputReadonly("ssfxjdm", true);
			setInputReadonly("sspcsdm", true);
			setInputReadonly("jzd1", true);
			setInputReadonly("jzd2", true);
			setInputReadonly("dz_jzd_mlpxz", true);
			setInputReadonly("dz_jzdzmlpdm", true);
			setInputReadonly("dz_jzdzdm", true);
			setInputReadonly("dz_jzdzssxdm", true);
			setInputReadonly("dz_jzdzxz", true);
			setInputReadonly("jzd_sq", true);
			setInputReadonly("ajlbdm", true);
			setInputReadonly("zatddm", true);
			setInputReadonly("zywtjxsbx", true);
			setInputReadonly("jyaq", true);
			setInputReadonly("cfjg", true);
			setInputReadonly("jchddq", true);
			setInputReadonly("jl", true);
			setInputReadonly("zwbh", true);
			setInputReadonly("sjmj", true);
			setInputReadonly("rkbm", true);
			
		 $("#resetButton").hide();
		 $("#saveButton").hide();
	 }else{
		
		 if(<%=userOrgLevel%>=="31"){
			
			    setInputReadonly("ssfxjdm", true);
		 }
		
		 
		 
	 }
	}); 
	
	

//保存按钮
function save() {
	if (!$("#shbUpdateForm").form("validate")) {
		return;
	}
	
		var bottonObject = "#saveButton";
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}
		topMessager.confirm("", "您是否要保存当前的数据？", function(r) {
			if (r) {
				$("#shbUpdateForm").form("submit",{
					dataType : "json",
					onSubmit: function() {
					},
					success: function(result) {
						buttonEnabled(bottonObject);
						result = parseReturn(result);
						if (result.status == "success") { // 返回成功后执行的方法
							if (mainTabID != "" && invokeJSMethod != "") {
								topMessager.show({
									title: MESSAGER_TITLE,
									msg: result.message,
									timeout:1500
								});
								closeSelf();
								executeTabPageMethod(mainTabID, invokeJSMethod);
							}
							else {
								//var openUrl = contextPath + "/syrkEdit/"+ result.ryid + "/" + result.saveID + "/view";
								//location.href = openUrl;
							}
						}
						else {
							topMessager.alert(MESSAGER_TITLE, result.message, "error");
						}
					}
				});			
			}
			else {
				buttonEnabled(bottonObject);
			}
		});		
	
}

//重置按钮
function reset() {
	document.forms["shbUpdateForm"].reset();
}
</script>
</html>