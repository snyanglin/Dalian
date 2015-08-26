<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>承租情况</title>
</head>

<div class="easyui-layout" data-options="fit:true">
     <form action="<%=basePath%>syfw/saveCzqkxxb" id="dataForm" name="dataForm" enctype="multipart/form-data" method="post">
    	
    	<input type="hidden" id="czfwid" name="czfwid" value="${entity.czfwid}" />
    	<input type="hidden" id="id" name="id" value="${entity.id}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
	          <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="chzr_cyzjdm" name="chzr_cyzjdm" style="width:200px;" value="${entity.chzr_cyzjdm }"
						data-options="url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:czzjdm_onchange" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="chzr_zjhm" name='chzr_zjhm' maxlength="30" value="${entity.chzr_zjhm}" style="width:200px;float:left;" 
		    	        data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="czryLoading"></div></td>	
			    		
		    	</tr>
		    	 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">户籍地址：</td>
			    <td width="80%" colspan="3" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="hjd_dzms" style="width:626px;" />
				</td>
			    </tr>
		    	
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    	<input type="hidden" name="chzr_ryid" id="chzr_ryid" value="${entity.chzr_ryid}"/>
			    	<input class="easyui-validatebox" type="text" id="chzr_xm" name="chzr_xm" style="width:200px;" value="${entity.chzr_xm }" maxlength="50" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
			    	
			    	 <td width="20%" class="dialogTd" align="right">联系电话：</td>
				    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='chzr_lxdh' id="chzr_lxdh" onblur="checkLxdh('chzr_lxdh','chzr_ryid')" maxlength="18" value="${entity.chzr_lxdh}" style="width:200px;" data-options="required:true,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" /></td>
			    </tr>
			     <tr class="dialogTr">
				 <td width="20%" class="dialogTd" align="right">外文姓：</td>
				 <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="chzr_wwx" name='chzr_wwx' value="${entity.chzr_wwx}" style="width:200px;"  maxlength="40"
		    	        data-options="required:false"/></td>
				 <td width="20%" class="dialogTd" align="right">外文名：</td>
				 <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="chzr_wwm" name='chzr_wwm' value="${entity.chzr_wwm}" style="width:200px;"  maxlength="40"
		    	        data-options="required:false"/>
		    	 </td> 
	    	    </tr>
			    
			    
			    <tr class="dialogTr">
			    	
			    	<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="chzr_xb" name="chzr_xb" style="width:200px;" value="${entity.chzr_xb }"
						data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    	
					<td width="20%" class="dialogTd" align="right">民族：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="chzr_mzdm" name="chzr_mzdm" style="width:200px;" value="${entity.chzr_mzdm }"
						data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    
			     <tr class="dialogTr">
			        
	    	         <td width="20%" class="dialogTd" align="right">出生日期：</td>
			         <td width="30%" class="dialogTd"><input type="text" name="chzr_csrq" id="chzr_csrq" class="easyui-validatebox" style="width: 200px;" value="${entity.chzr_csrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left',onChange:checkDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
				   </td>
			        <td width="20%" class="dialogTd" align="right">职业：</td>
			    	<td width="30%" class="dialogTd"  >
							<input type="text" id="chzr_zy" name="chzr_zy" value="${entity.chzr_zy}" maxlength="60" style="width:200px;" class="easyui-validatebox" />
						</td>
			        
		    	  </tr>
				    
				  <tr class="dialogTr">
			    		<td width="20%" class="dialogTd" align="right">职业类别：</td>
			    		
						<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="chzr_zylbdm" name="chzr_zylbdm" style="width:200px;" value="${entity.chzr_zylbdm }"
						data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,panelWidth:360,tipPosition:'left'"/>
			    	</td>
			    
		    		<td width="20%" class="dialogTd" align="right">服务处所：</td>
		    		<td width="30%" class="dialogTd" >
		    			<input type="hidden" id="chzr_fwcs" name='chzr_fwcs'  value="${entity.chzr_fwcs}"/>
						<input type="text" id="fwcs-box" value="${entity.chzr_fwcs}"  class="easyui-combobox" 
							data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false"  style="width:200px;"/>
					</td>
			    </tr> 
			    
			    <tr class="dialogTr">
				    <td width="20%" class="dialogTd" align="right">与房主关系：</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="chzr_yfzgx_rygxdm" name="chzr_yfzgx_rygxdm" style="width:200px;" value="${entity.chzr_yfzgx_rygxdm}"
							data-options="url:contextPath+'/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,required:true,tipPosition:'right'" />
				    </td>
				    <td width="20%" class="dialogTd" align="right">与托管人关系：</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="chzr_ytgrgx_rygxdm" name="chzr_ytgrgx_rygxdm" style="width:200px;" value="${entity.chzr_ytgrgx_rygxdm}"
							data-options="url:contextPath+'/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,required:false,tipPosition:'left'" />
				    </td>
		    	  </tr>
	          <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">起租日期：</td>
			   <td width="30%" class="dialogTd"><input type="text" name="qzrq" id="qzrq" class="easyui-validatebox" style="width: 200px;" value="${entity.qzrq }"
						 data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			   </td>
			   
			   <td width="20%" class="dialogTd" align="right">停租日期：</td>
			   <td width="30%" class="dialogTd"><input type="text" name="tzrq" id="tzrq" class="easyui-validatebox" style="width: 200px;" value="${entity.tzrq }"
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qzrq\') || \'%y-%M-%d\'}'})"/>
			   </td>
			   </tr>
			   
			  
			  <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">承租情况：</td>
			    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="fwczqkdm" name="fwczqkdm" style="width:200px;" value="${entity.fwczqkdm }"
						data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			    </tr>
		    </table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
$(document).ready(function(){
    $("#chzr_cyzjdm").combobox("setValue","111");
	$("#chzr_zjhm").bind("blur",function(e){ checkCzryZjhm();});
	initDepartmentSearch('fwcs-box', {glpcsid: ''}, '', 'chzr_fwcs', {},'');

});
var fwdz_dzid ;
function doInit(paramArray) {
	fwdz_dzid = paramArray["fwdz_dzid"];
}

function czzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#chzr_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#chzr_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
 
//承租人员信息复用  
function checkCzryZjhm(){
	if($("#chzr_zjhm").val()=="" ){
		return ;
	}
	$("#czryLoading").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#chzr_zjhm").val()+"&cyzjdm="+$("#chzr_cyzjdm").val(),
		success:function(data) {
			if (data && data.ryRyjbxxb.id!='') {
				$("#chzr_xm").val(data.ryRyjbxxb.xm);//姓名
				$("#chzr_mzdm").combobox("setValue", data.ryRyjbxxb.mzdm);//民族
				$("#chzr_csrq").val(data.ryRyjbxxb.csrq);//出生日期
				$("#chzr_xb").combobox("setValue",data.ryRyjbxxb.xbdm);//性别代码
				$("#chzr_ryid").val(data.ryRyjbxxb.id);
				$("#chzr_lxdh").val(data.ryRyjbxxb.lxdh);
				$("#chzr_xm").validatebox("validate");
				$("#chzr_lxdh").validatebox("validate");
				$("#hjd_dzms").val(data.ryRyjbxxb.hjd_dzms);
				
				$.ajax({
					type:"POST",
					url:"<%=basePath%>syfw/decideCzqkxx",
					dataType:"json",
					data:"fwdz_dzid="+fwdz_dzid+"&ryid="+data.ryRyjbxxb.id,
					success:function(data) {
						if(data.returnValue =="0"){
							$.messager.confirm("提示","该人员信息非本辖区实有人口,请先录入实有人口信息!",function(r){
								if(r){
									menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&cyzjdm='+$("#chzr_cyzjdm").val()+'&zjhm='+$("#chzr_zjhm").val()+'&invokeJSMethod=queryButton');
								}
								clearRyfyxx();
							})
						}else if(data.returnValue =="1"){
							$.messager.confirm("提示","您登记的承租人非本房屋实有人口,是否登记实有人口？",function(r){
								if(r){
									menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&cyzjdm='+$("#chzr_cyzjdm").val()+'&zjhm='+$("#chzr_zjhm").val()+'&invokeJSMethod=queryButton');
								}
								clearRyfyxx();
							});
						}
					}
				});
			}else{
				$.messager.confirm("提示","该人员信息还没有录入系统,请先录入实有人口信息!",function(r){
					if(r){
						menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID());
					}else{
						$("#chzr_zjhm").val("");
						$("#chzr_zjhm").validatebox("validate");
					}
				})
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete:function() {
			$("#chzr_zjhm").attr("zjhm", $("#chzr_zjhm").val());
			$("#czryLoading").hide();
		}
	});	
}
function clearRyfyxx(){
	$("#chzr_zjhm").val("");
	$("#chzr_lxdh").val("");
	$("#chzr_xm").val("");
	$("#chzr_mzdm").combobox("setValue", "");//民族
	$("#chzr_csrq").val("");//出生日期
	$("#chzr_xb").combobox("setValue","");//性别代码
	$("#chzr_xm").validatebox("validate");
	$("#chzr_lxdh").validatebox("validate");
	$("#chzr_zjhm").validatebox("validate");
	$("#hjd_dzms").val("");
}
function beforeSubmit(){
}
function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#id").val(arr["saveID"]);
	}
}
</script>