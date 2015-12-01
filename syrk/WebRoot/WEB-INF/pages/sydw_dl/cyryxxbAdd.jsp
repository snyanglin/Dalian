<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>从业人员</title>
</head>

<body>
	<div style="width: 98%;height: 100%;" align="center">
    <form action="<%=basePath%>cyryxxb_dl/save" id="dataForm" name="dataForm" method="post" onsubmit="alert('ssss')">
    
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid }"  />
    	<input type="hidden" name="id" id="id" value="${entity.id }" /><!-- 从业人员id -->
    	<input type="hidden" name="ryid" id="ryid" value="" />
    	
    	<input type="hidden" name="jjlxr_ryid" id="jjlxr_ryid" value="${entity.jjlxr_ryid }" /><!-- 紧急情况联系人ID -->
    	
    	<div class="easyui-accordion" data-options="multiple:true" style="width:820px;margin-left: 20px;margin-top: 10px;margin-right: 5px;margin-bottom: 10px;"> 
    		<div title="基本信息" id="baseInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">   
    		<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件类型：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:200px;" value="${entity.cyzjdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zjhmCheck" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
			    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" class="easyui-validatebox" style="width: 200px;" value="${entity.csrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">民族：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${entity.mzdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">文化程度：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="whcddm" id="whcddm" class="easyui-combotree" style="width:200px;" value="${entity.whcddm }"
		    			data-options="url: contextPath + '/common/dict/D_BZ_WHCD.js',onlyLeaf:true,dataFilter:'',multiple:false,required:false,panelWidth:200,method:'get',
		    			editable:true,lines:true,tipPosition:'right'">
					</td>
					<td width="20%" class="dialogTd" align="right">国籍：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="gjdm" id="gjdm" value="" class="easyui-combobox" style="width:200px;" value="${entity.gjdm }"
		    			data-options="url: contextPath + '/common/dict/D_BZ_SJGGHDQMCDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
			    	</td>
			    </tr>
				<!--  dz_hjdmlpxz;dz_hjdmlpdm -->	
				<tr class="dialogTr" id="hjdz">
					<td width="20%" class="dialogTd" align="right" >户籍地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="hjd1" style="width:400px;" value="${entity.dz_hjdmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='dz_hjdmlpdm' id="dz_hjdmlpdm" value="${entity.dz_hjdmlpdm}"/>
					<input type='hidden' name='dz_hjdmlpxz' id="dz_hjdmlpxz" value="${entity.dz_hjdmlpxz}"/>
					</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" id="hjd2" style="width:200px;" value='${fn:replace(entity.dz_hjdxz, entity.dz_hjdmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    <input type='hidden' name='dz_hjddm' id='dz_hjddm' value="${entity.dz_hjddm}" />
					    <input type='hidden' name='dz_hjdxzqhdm' id='dz_hjdxzqhdm' value="${entity.dz_hjdxzqhdm}" />
					    <input type='hidden' name='dz_hjdxz' id='dz_hjdxz' value="${entity.dz_hjdxz}" /> 
					</td>
				</tr>
			   <tr class="dialogTr" id="jzdz">
					<td width="20%" class="dialogTd" align="right">现居地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_xzzdmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='dz_xzzdmlpdm' id="dz_xzzdmlpdm" value="${entity.dz_xzzdmlpdm}"/>
					<input type='hidden' name='dz_xzzdmlpxz' id="dz_xzzdmlpxz" value="${entity.dz_xzzdmlpxz}"/></td>
					<td width="30%" class="dialogTd">
					    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_xzzxz, entity.dz_xzzdmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='dz_xzzdm' id='dz_xzzdm' value="${entity.dz_xzzdm}" />
					    	<input type='hidden' name='dz_xzzxzqhdm' id='dz_xzzxzqhdm' value="${entity.dz_xzzxzqhdm}" />
					    	<input type='hidden' name='dz_xzzxz' id='dz_xzzxz' value="${entity.dz_xzzxz}" /> 
				    </td>	
				</tr>
    		</table>
    		</div>
    		
    		<div title="从业信息" id="cyryInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">  
    		<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
    			<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">简历：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><textarea name="jl" id="jl" class="easyui-validatebox" style="width: 595px; height:48px;"
						data-options="validType:['maxLength[4000]'],invalidMessage:'简历不能超过4000个汉字，请重新输入！',required:false,tipPosition:'left'">${entity.jl }</textarea></td>
	    		</tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">所在部门：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="szbmmc" name="szbmmc" style="width:595px;" value="${entity.szbmmc }" 
			    		maxlength="50" data-options="required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职业类别：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="zylbdm" id="zylbdm"  class="easyui-combotree" style="width:200px;" value="${entity.zylbdm }"
	    			data-options="url: contextPath + '/common/dict/D_BZ_ZYFLYDM.js',onlyLeaf:true,
	    			multiple:false,required:true,panelWidth:613,method:'get',lines:true,tipPosition:'left'" >
		    	   </td>
			    	
					<td width="20%" class="dialogTd" align="right">聘用时间：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="pyrq" id="pyrq" class="easyui-validatebox" style="width: 200px;" value="${entity.pyrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">劳务性质：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lwxz" name="lwxz" style="width:200px;" value="${entity.lwxz }" 
			    		maxlength="50"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">劳务合同签署公司：</td>
		    		<td width="80%" class="dialogTd"  colspan="3">
						<input type="hidden" name="sslwgsid" id="sslwgsid" value="${entity.sslwgsid}"/>
						<input type="hidden" name="sslwgsmc" id="sslwgsmc" value="${entity.sslwgsmc}"/>
						<input type="text" id="gzdw-box" name="gzdw-box" value="${entity.sslwgsmc}" maxlength="50" class="easyui-combobox" 
							style="width:595px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',
							textField:'text',selectOnNavigation:false,required:false"   />
					</td>
			    </tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">是否离职：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sflzdm" name="sflzdm" style="width:200px;" value="${entity.sflzdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:lzCheck"/>
			    	</td>
		    		<td width="20%" class="dialogTd" align="right">离职日期：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="lz_rq" id="lz_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.lz_rq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">离职原因：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="lzyy" name="lzyy" style="width:595px;" value="${entity.lzyy }" 
			    		maxlength="1000" data-options="required:false,tipPosition:'left'"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">离职去向：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="lzqx" name="lzqx" style="width:595px;" value="${entity.lzqx }" 
			    		maxlength="100" data-options="required:false,tipPosition:'left'"/>
			    	</td>
		    	</tr>
    		</table> 
    		</div>
    		
    		<!--  <div title="紧急联系人信息" id="jjlxrInfoTypeDiv" data-options="" style="overflow:auto;padding:10px;">   
    		<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
    			<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件类型：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jjlxr_cyzjdm" name="jjlxr_cyzjdm" style="width:200px;" value="${entity.jjlxr_cyzjdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:jjlxrzjhmCheck"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jjlxr_zjhm" name="jjlxr_zjhm" style="width:200px;float:left;" value="${entity.jjlxr_zjhm }" maxlength="30" 
			    		data-options="required:false,tipPosition:'left'"/><div class="lodingimg" id="jjlxrDiv" ></div>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jjlxr_xm" name="jjlxr_xm" style="width:200px;" value="${entity.jjlxr_xm }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jjlxr_xbdm" name="jjlxr_xbdm" style="width:200px;" value="${entity.jjlxr_xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jjlxr_lxdh" name="jjlxr_lxdh" style="width:200px;" value="${entity.jjlxr_lxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">与从业人员其关系：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ycyrygxdm" name="ycyrygxdm" style="width:200px;" value="${entity.ycyrygxdm}"
						data-options="url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    		</td>
			    </tr>
    		</table>
    		</div>-->
    	</div>

    </form>
    </div>
</body>	

<script type="text/javascript" >
var cyryCount = parseInt("${cyryArrayLength}");
var _p ;
function doInit(paramArray) { 
	_p = paramArray["_p"];

//	sgzCheck("${entity.sfysgzdm }", "");
	lzCheck("${entity.sflzdm }", "");
	$("#gjdm").combobox("setValue","${entity.gjdm}");
	if($("#xm").val() != ""){
		setInputReadonly("xm", true);
	}
	if($("#csrq").val() != ""){
		setInputReadonly("csrq", true);
	}
	if($("#xbdm").val() != ""){
		setInputReadonly("xbdm", true);
	}
	if($("#mzdm").val() != ""){
		setInputReadonly("mzdm", true);
	}
	if($("#hjd1").val() != ""){
		setInputReadonly("hjd1", true);
		setInputReadonly("hjd2", true);
	}
	if($("#jjlxr_xm").val() != ""){
		setInputReadonly("jjlxr_xm", true);
	}
	if($("#jjlxr_xbdm").val() != ""){
		setInputReadonly("jjlxr_xbdm", true);
	}
	var sfzzpx = null;//$("#sfzzpxdm").combobox('getText');
	if(sfzzpx=="是"){
		$("#cyry1").show();
		$("#pxzszl1").show();
		$("#zzpxms1").show();
		
	}else {
		$("#cyry1").hide();
		$("#pxzszl1").hide();
		$("#zzpxms1").hide();
	}
		if($("#cyzjdm").val()  == "111" || $("#cyzjdm").val() =="112" || $("#cyzjdm").val()  == "335"){ 
			$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
		}else{
			$("#zjhm").validatebox({validType:['maxLength[30]']});
		}
	if($("#id").val()&&$("#id").val()!=''){
		setInputReadonly("cyzjdm", true);
		setInputReadonly("zjhm", true);
	}
	setInputReadonly("zylbdm", false);
}
function zzpx(){
	var sfzzpx = null;//$("#sfzzpxdm").combobox('getText');
	if(sfzzpx=="是"){
		$("#cyry1").show();
		$("#pxzszl1").show();
		$("#zzpxms1").show();
		
	}else {
		$("#cyry1").hide();
		$("#pxzszl1").hide();
		$("#zzpxms1").hide();
	}
	
}
function beforeSubmit() { 	

	
	var ryid = $("#ryid").val();
	var jjqklxrid = $("#jjlxr_ryid").val();
	if(ryid != undefined && ryid != "" && jjqklxrid != undefined && jjqklxrid != ""){
		if(ryid == jjqklxrid){
			alert("【从业人员】和【紧急联系人员】不能为同一个人！");
			return false;
		}
	}
/**	紧急联系人不作为必填项录入
	//紧急联系人证件类型不为空
	if($("#jjqklxrcyzjdm").val() != undefined && $("#jjqklxrcyzjdm").val() != ""){
		if($("#jjqklxrzjhm").val() == "" || $("#jjqklxrzjhm").val() == undefined){
			alert("紧急联系人证件号码不为空，请输入紧急联系人证件号码！");
			return false;
		}
		if($("#jjqklxrxm").val() == "" || $("#jjqklxrxm").val() == undefined){
			alert("紧急联系人姓名不为空，请输入紧急联系人姓名！");
			return false;
		}
		if($("#jjqklxrdh").val() == "" || $("#jjqklxrdh").val() == undefined){
			alert("紧急联系人电话不为空，请输入紧急联系人电话！");
			return false;
		}
	}**/

}

function afterSubmit(arr) {
	$("#dataForm")[0].reset();
	
	parent.$(_p).datagrid("reload");
	//是否离职默认设置为0
	setInputReadonly("lz_rq", true);
	setInputReadonly("lzyy", true);
	setInputReadonly("lzqx", true);
		
/**	//是否有上岗证
	setInputReadonly("sgzjzl", true);
	$("#sgzjzl").val("");
	setInputReadonly("sgzjhm", true);
	setInputReadonly("sgzjjb", true);
	setInputReadonly("sgzjqdsj", true);
	setInputReadonly("sgzyxq", true);
	setInputReadonly("sgzfzjg", true);  **/
	
	setInputReadonly("zjhm", false);
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("hjd1", false);
	setInputReadonly("hjd2", false);
	setInputReadonly("jjlxr_xm", false);
	setInputReadonly("jjlxr_xbdm", false);
	setInputReadonly("jjlxr_lxdh", false);
	
}

$(document).ready(function(){
	initDepartmentSearch('gzdw-box', {glpcsid: ''}, 'sslwgsid', 'sslwgsmc', {});
	initAddressSearch('jzd1', {}, 'dz_xzzdmlpdm', 'dz_xzzdmlpxz', 'jzd2', {text:'dz_xzzxz',dzxzqh:'dz_xzzxzqhdm',id:'dz_xzzdm'}, null, null);
	initAddressSearch('hjd1', {}, 'dz_hjdmlpdm', 'dz_hjdmlpxz', 'hjd2', {text:'dz_hjdxz',dzxzqh:'dz_hjdxzqhdm',id:'dz_hjddm'}, null, null);
	
	if($("#cyzjdm").combobox("getValue") == ""){
		$("#cyzjdm").combobox("setValue","111");
	}
	//if($("#jjlxr_cyzjdm").combobox("getValue") == ""){
	//	$("#jjlxr_cyzjdm").combobox("setValue","111");
	//}

	//从业人员信息复用
	$("#zjhm").bind("blur",function(e){ checkRyxx(); });
	//紧急联系人复用人员基本表
	//$("#jjlxr_zjhm").bind("blur",function(e){ checkJjlxRyxx(); });
	
});

var _zjhm = "";
/**
 * 从业人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#mzdm").combobox("setValue",data.ryRyjbxxb.mzdm);
				$("#whcddm").combotree("setValue",data.ryRyjbxxb.xldm);
				$("#gjdm").combobox("setValue",data.ryRyjbxxb.jggjdqdm);
				$("#dz_hjdmlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
				$("#dz_hjdmlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
				$("#dz_hjdxz").val(data.ryRyjbxxb.hjd_dzxz);
				$("#dz_hjddm").val(data.ryRyjbxxb.hjd_dzid);
				$("#dz_hjdxzqhdm").val(data.ryRyjbxxb.hjd_xzqhdm);
				$("#hjd1").combobox('setValue', data.ryRyjbxxb.hjd_mlpxz);
				$("#hjd2").combobox('setValue', data.ryRyjbxxb.hjd_dzxz.replace(data.ryRyjbxxb.hjd_mlpxz, ''));
				
				
				$("#dz_xzzdmlpxz").val(data.ryRyjbxxb.jzd_mlpxz);
				$("#dz_xzzdmlpdm").val(data.ryRyjbxxb.jzd_mlpdm);
				$("#dz_xzzxz").val(data.ryRyjbxxb.jzd_dzxz);
				$("#dz_xzzdm").val(data.ryRyjbxxb.jzd_dzid);
				$("#dz_xzzxzqhdm").val(data.ryRyjbxxb.jzd_xzqhdm);
				$("#jzd1").combobox('setValue', data.ryRyjbxxb.jzd_mlpxz);
				$("#jzd2").combobox('setValue', data.ryRyjbxxb.jzd_dzxz.replace(data.ryRyjbxxb.jzd_mlpxz, ''));
				
				
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
				if(data.ryRyjbxxb.csrq != ""){
					setInputReadonly("csrq", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("xbdm", true);
				}
				if(data.ryRyjbxxb.mzdm != ""){
					setInputReadonly("mzdm", true);
				}
			
			}
			else{
				clearRyjbxx();
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
			
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$("#yrjbxxDiv").hide();
		}
	});
}

var _jjlxrZjhm = "";
/**
 * 紧急联系人复用人员基本信息表
 */
function checkJjlxRyxx(){
	if(!$("#jjlxr_zjhm").validatebox("isValid")){
		return;
	}
	if($("#jjlxr_zjhm").val() == _jjlxrZjhm){
		return;
	}
	$("#jjlxrDiv").show();
	$.ajax({
		type:"POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#jjlxr_zjhm").val()+"&cyzjdm="+$("#jjlxr_cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#jjlxr_ryid").val(data.ryRyjbxxb.id);
				$("#jjlxr_xm").val(data.ryRyjbxxb.xm);
				$("#jjlxr_xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#jjlxr_lxdh").val(data.ryRyjbxxb.lxdh);
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("jjlxr_xm", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("jjlxr_xbdm", true);
				}
			}else{
				clearJjlxryjbxx();
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete:function(){
			_jjlxrZjhm = $("#jjlxr_zjhm").val();
			$("#jjlxrDiv").hide();
		}
	});
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearRyjbxx();
	$("#zjhm").val("");
	_zjhm = "";
}

//紧急联系人-验证证件号码
function jjlxrzjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#jjlxr_zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#jjlxr_zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#jjlxr_zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearJjlxryjbxx();
	$("#jjlxr_zjhm").val("");
	_jjlxrZjhm = "";
}

/**
//是否持有上岗证 判断
function sgzCheck(newValue, oldValue){
	if(newValue == "1"){//是
		setInputReadonly("sgzjzl", false);
		setInputReadonly("sgzjhm", false);
		setInputReadonly("sgzjjb", false);
		setInputReadonly("sgzjqdsj", false);
		setInputReadonly("sgzyxq", false);
		setInputReadonly("sgzfzjg", false);

	}else{//否
		$("#sgzjzl").val("");//上岗证件种类
		$("#sgzjhm").val("");//上岗证件号码
		$("#sgzjjb").val("");//上岗证件级别
		$("#sgzjqdsj").val("");//上岗证件取得时间
		$("#sgzyxq").val("");//上岗证有效期
		$("#sgzfzjg").val("");//上岗证发证机关
		setInputReadonly("sgzjl", true);
		setInputReadonly("sgzjhm", true);
		setInputReadonly("sgzjjb", true);
		setInputReadonly("sgzjqdsj", true);
		setInputReadonly("sgzyxq", true);
		setInputReadonly("sgzfzjg", true);
	}
}**/

//是否离职 判断
function lzCheck(newValue, oldValue){
	if(newValue == "1"){//是
		setInputReadonly("lz_rq", false);
		setInputReadonly("lzyy", false);
		setInputReadonly("lzqx", false);
		
	}else{//否
		$("#lz_rq").val("");//离职日期
		$("#lzyy").val("");//离职原因
		$("#lzqx").val("");//离职去向
		setInputReadonly("lz_rq", true);
		setInputReadonly("lzyy", true);
		setInputReadonly("lzqx", true);
	}
}

//清空复用的人员基本信息
function clearRyjbxx(){
	$("#ryid").val("");
	$("#xm").val("");
	$("#xbdm").combobox("setValue","");
	$("#csrq").val("");
	$("#mzdm").combobox("setValue","");
	$("#whcddm").combotree("setValue","");
	$("#gjdqdm").combobox("setValue","");
	$("#hjd1").combobox('setValue', "");
	$("#hjd2").combobox('setValue', "");
	$("#jzd1").combobox('setValue', "");
	$("#jzd2").combobox('setValue', "");
	
	$("#dz_hjdxz").val("");
	$("#dz_hjdxzqhdm").val("");
	$("#dz_hjddm").val("");
	$("#dz_hjdmlpxz").val("");
	$("#dz_hjdmlpdm").val("");
	$("#dz_xzzdmlpdm").val("");
	$("#dz_xzzdmlpxz").val("");
	$("#dz_xzzxz").val("");
	$("#dz_xzzxzqhdm").val("");
	$("#dz_xzzdm").val("");
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("hjd1", false);
	setInputReadonly("hjd2", false);
}

//清空复用的紧急联系人员信息
function clearJjlxryjbxx(){
	$("#jjlxr_ryid").val("");
	$("#jjlxr_xm").val("");
	$("#jjlxr_xbdm").combobox("setValue","");
	$("#jjlxr_lxdh").val("");
	setInputReadonly("jjlxr_xm", false);
	setInputReadonly("jjlxr_xbdm", false);
	setInputReadonly("jjlxr_dh", false);
}

//清空复用的从业人员信息
function clearCyryxx(){
	$("#pk").val("");
	$("#jl").val("");
	$("#szbmmc").val("");
	$("#zylbdm").val("");
	$("#pyrq").val("");
	$("#lxdh").val("");
	$("#lwxz").val("");
	$("#sslwgsid").val("");
	$("#sslwgsmc").val("");
	//$("#jjlxr_ryid").val(""); 
	//$("#jjlxr_cyzjdm").combobox("setValue","");
	//$("#jjlxr_zjhm").val("");
	//$("#jjlxr_xm").val("");
	//$("#jjlxr_xbdm").combobox("setValue","");
	//$("#jjlxr_lxdh").val("");
	$("#ycyrygxdm").combobox("setValue","");
/**	$("#sfysgzdm").combobox("setValue","0");
	$("#sgzjzl").val("");;//上岗证件种类
	$("#sgzjhm").val("");//上岗证件号码
	$("#sgzjjb").val("");//上岗证件级别
	$("#sgzjqdsj").val("");//上岗证件取得时间
	$("#sgzyxq").val("");//上岗证有效期
	$("#sgzfzjg").val("");//上岗证发证机关
	setInputReadonly("sgzjzl", true);
	setInputReadonly("sgzjhm", true);
	setInputReadonly("sgzjjb", true);
	setInputReadonly("sgzjqdsj", true);
	setInputReadonly("sgzyxq", true);
	setInputReadonly("sgzfzjg", true); **/
}

function resetForm(){
	document.forms["dataForm"].reset();
	//$("#sfysgzdm").combobox("setValue","0");
	$("#sflzdm").combobox("setValue","0");
	$("#cyzjdm").combobox("setValue","111");
	//$("#jjlxr_cyzjdm").combobox("setValue","111");
}

function resetTable(){
	document.forms["dataForm"].reset();
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("hjd1", false);
	setInputReadonly("hjd2", false);
	//setInputReadonly("jjlxr_xm", false);
	//setInputReadonly("jjlxr_xbdm", false);
	setInputReadonly("lz_rq", true);
	setInputReadonly("lzyy", true);
	setInputReadonly("lzqx", true);
	setInputReadonly("sgzjhm", true);
	setInputReadonly("sgzjjb", true);
	setInputReadonly("sgzjqdsj", true);
	setInputReadonly("sgzyxq", true);
	setInputReadonly("sgzfzjg", true);
	//$("#sfysgzdm").combobox("setValue","0");
	$("#sflzdm").combobox("setValue","0");
	$("#cyzjdm").combobox("setValue","111");
	//$("#jjlxr_cyzjdm").combobox("setValue","111");
}
function addCyry(){
	var tr1 = $('<tr id="cyry1Tr'+ cyryCount +'"><td  height="10"></td></tr>');
	var tr2 = $('<tr id="cyry2Tr'+ cyryCount +'" height="24"></tr>');
	var td1 = $('<td width="20%" class="dialogTd" align="right">培训证号：</td>');
	var td3 = $('<td width="80%" id="cyryTd'+ cyryCount +'" colspan="3" class="dialogTd"></td>');
	var td3HTML = new StringBuffer();
	td3HTML.append('&nbsp;<input class="easyui-validatebox" type="text" name="cyryArray['+cyryCount+'].pxzh" id="cyry1_'+ cyryCount +'" maxlength="20" style="width:582px;" data-options="tipPosition:\'left\'"/>');
	td3HTML.append('&nbsp;<a class="delLine_btn" href="javascript:void(0);" onclick="delCyry('+ cyryCount +')" title="注销当前培训经历"></a>');
	td3.html(td3HTML.toString());
	tr2.append(td1);
	tr2.append(td3);
	$('#cyryTable').append(tr1);
	$('#cyryTable').append(tr2);
	
	$.parser.parse('#cyryTd' + cyryCount);
	
	
	//----------------------
	var tr3 = $('<tr id="pxzszl1Tr'+ cyryCount +'"><td  height="10"></td></tr>');
	var tr4 = $('<tr id="pxzszl2Tr'+ cyryCount +'" height="24"></tr>');
	var td2 = $('<td width="20%" class="dialogTd" align="right">培训证书种类：</td>');
	var td4 = $('<td width="80%" id="pxzszlTd'+ cyryCount +'" colspan="3" class="dialogTd"></td>');
	var td4HTML = new StringBuffer();
	td4HTML.append('&nbsp;<input class="easyui-validatebox" type="text" name="cyryArray['+cyryCount+'].pxzszl" id="pxzszl1_'+ cyryCount +'" maxlength="20" style="width:582px;" data-options="tipPosition:\'left\'"/>');

	td4.html(td4HTML.toString());
	tr4.append(td2);
	tr4.append(td4);
	$('#pxzszlTable').append(tr3);
	$('#pxzszlTable').append(tr4);
	$.parser.parse('#pxzszlTd' + cyryCount);
	
	//-----------------
	var tr5 = $('<tr id="zzpxms1Tr'+ cyryCount +'"><td  height="10"></td></tr>');
	var tr6 = $('<tr id="zzpxms2Tr'+ cyryCount +'" height="24"></tr>');
	var td5 = $('<td width="20%" class="dialogTd" align="right">在职培训描述：</td>');
	var td6 = $('<td width="80%" id="zzpxmsTd'+ cyryCount +'" colspan="3" class="dialogTd"></td>');
	var td6HTML = new StringBuffer();
	td6HTML.append('&nbsp;<textarea class="easyui-validatebox"  name="cyryArray['+cyryCount+'].zzpxms" id="zzpxms1_'+ cyryCount +'" maxlength="100" style="width:582px;height:48px;" data-options="tipPosition:\'left\'"></textarea>');
	td6.html(td6HTML.toString());
	tr6.append(td5);
	tr6.append(td6);
	$('#zzpxmsTable').append(tr5);
	$('#zzpxmsTable').append(tr6);
	$.parser.parse('#zzpxmsTd' + cyryCount);
	cyryCount++;
}
function delCyry(cyNo){
	setInputReadonly('cyry' + cyNo, true);
	$("#xt_zxbz" + cyNo).val("1");
	$("#cyry1Tr" + cyNo).hide();
	$("#cyry2Tr" + cyNo).hide();
	$("#pxzszl1Tr" + cyNo).hide();
	$("#pxzszl2Tr" + cyNo).hide();
	$("#zzpxms1Tr" + cyNo).hide();
	$("#zzpxms2Tr" + cyNo).hide();
	
}

</script>
</html>