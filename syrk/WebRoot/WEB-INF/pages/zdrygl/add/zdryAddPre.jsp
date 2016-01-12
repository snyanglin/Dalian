<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重点人员列管</title>
</head>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>zdryzb/saveLg"  id="dataFormZdry" name="dataFormZdry" method="post" enctype="multipart/form-data">
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryZdryzbVO.id}" />   	
    	<input type="hidden" id="zdryShbzdryxxb.id" name="zdryShbzdryxxb.id" value="${zdryZdryzbVO.id}" />
    	<input type="hidden" id="zdryLczywblb.ywblr_id" name="zdryLczywblb.ywblr_id" value="${zdryLczywblb.ywblr_id}" />
    	<input type="hidden" id="zdryHsbId" name="zdryHsbId" value="${zdryHsbId}" />
    	<input type="hidden" id="syrkid" name="zdryZdryzb.syrkid" value="${syrkxxb.id }" />
    	<input type="hidden" id="ryid" name="zdryZdryzb.ryid" value="${syrkxxb.ryid }" />
    	<input type="hidden" id="ky_jzrq" name="zdrySqjzryxxb.ky_jzrq" value="2015-12-30" />
    	
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">		    	
				<td width="20%" class="dialogTd" align="right">证件类型：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-combobox" type="text" id="cyzjdm" name="zdryZdryzb.cyzjdm" value="${syrkxxb.cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',
							selectOnNavigation:false,method:'get',tipPosition:'left',onChange:cyzjdmChange"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" value="${syrkxxb.xm}"/></td>
		    </tr>
		    <tr class="dialogTr">
		    		    	
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="zjhm" name="zdryZdryzb.zjhm" style="width:200px;float:left;" value="${syrkxxb.zjhm}" onblur="checkZjhm()"
		    			data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'" />
		    		<div class="lodingimg" id="ryxxLoadDiv" ></div>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">性别：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-combobox" type="text"  id="xbdm" name="zdryZdryzb.xbdm"   style="width:200px;" value="${syrkxxb.xbdm}" 
					data-options="url: contextPath +'/common/dict/GB_D_XBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>		    		
		    	</td>	
		    </tr>
		    </table>
		    
		    <!-- 隐藏的人员信息 -->
		    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" id="ryxxDiv" style="display:none">		    
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">民族：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-combobox" type="text" id="mzdm" name="zdryZdryzb.mzdm" value="${syrkxxb.mzdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>		    		
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="csrq" name="zdryZdryzb.csrq" style="width:200px;" value="${syrkxxb.csrq}"/>	    		
		    	</td>	
		    </tr>	
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">籍贯省市县代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jgssxdm" name="zdryZdryzb.jgssxdm" style="width:200px;" value="${syrkxxb.jgssxdm}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">户籍地_行政区划代码：</td>
		    	<td width="30%" class="dialogTd">		  
		    		<input class="easyui-combobox" type="text" id="hjd_xzqhdm" name="zdryZdryzb.hjd_xzqhdm" value="${syrkxxb.hjd_xzqhdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>  		
		    	</td>	
		    </tr>
		    
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">户籍地_门楼牌代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="hjd_mlpdm" name="zdryZdryzb.hjd_mlpdm" style="width:200px;" value="${syrkxxb.hjd_mlpdm}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">户籍地_门楼牌详址：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="hjd_mlpxz" name="zdryZdryzb.hjd_mlpxz" style="width:200px;" value="${syrkxxb.hjd_mlpxz}"/>	    		
		    	</td>	
		    </tr>	
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">户籍地_地址ID：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="hjd_dzid" name="zdryZdryzb.hjd_dzid" style="width:200px;" value="${syrkxxb.hjd_dzid}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">户籍地_地址详址：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="hjd_dzxz" name="zdryZdryzb.hjd_dzxz" style="width:200px;" value="${syrkxxb.hjd_dzxz}"/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_行政区划代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-combobox" type="text" id="jzd_xzqhdm" name="zdryZdryzb.jzd_xzqhdm" value="${syrkxxb.jzd_xzqhdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>		    		
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">居住地_门楼牌代码：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="jzd_mlpdm" name="zdryZdryzb.jzd_mlpdm" style="width:200px;" value="${syrkxxb.jzd_mlpdm}"/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_门楼牌详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jzd_mlpxz" name="zdryZdryzb.jzd_mlpxz" style="width:200px;" value="${syrkxxb.jzd_mlpxz}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">居住地_地址ID：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="jzd_dzid" name="zdryZdryzb.jzd_dzid" style="width:200px;" value="${syrkxxb.jzd_dzid}"/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_地址详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jzd_dzxz" name="zdryZdryzb.jzd_dzxz" style="width:200px;" value="${syrkxxb.jzd_dzxz}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">居住地_坐标X：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="jzd_zbx" name="zdryZdryzb.jzd_zbx" style="width:200px;" value="${syrkxxb.jzd_zbx}"/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">居住地_坐标Y：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="jzd_zby" name="zdryZdryzb.jzd_zby" style="width:200px;" value="${syrkxxb.jzd_zby}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">管辖分局代码：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="gxfjdm" name="zdryZdryzb.gxfjdm" style="width:200px;" value="${syrkxxb.gxfjdm}"/>	    		
		    	</td>	
		    </tr>
		    <tr class="dialogTr">		    		    
				<td width="20%" class="dialogTd" align="right">管辖派出所代码：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text"  id="gxpcsdm" name="zdryZdryzb.gxpcsdm" style="width:200px;" value="${syrkxxb.gxpcsdm}"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">管辖责任区代码：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-validatebox" type="text"  id="gxzrqdm" name="zdryZdryzb.gxzrqdm" style="width:200px;" value="${syrkxxb.gxzrqdm}"/>	    		
		    	</td>	
		    </tr>    
		    </table>		  		    		    	    	
		    
		    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    <tr class="dialogTr">
		    	<td colspan="4" align="center">		    		
		    		<a href="javascript:void(0)" class="easyui-linkbutton" id="ryxxShow" onclick="ryxxTag(1)">显示全部</a>
		    		<a href="javascript:void(0)" class="easyui-linkbutton" id="ryxxHide" onclick="ryxxTag(2)"  style="display:none">收起部分</a>		    	
		    	</td>		    	
		    </tr>
		    		     
		    <tr class="dialogTr" style="display:none" id="ylglxTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类型：</td>
	    		<td width="80%" class="dialogTd" colspan="3" id="ylglx">
	    		
		    	</td>
		    </tr>	  

		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
					<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value=""
					data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',  
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdrylxChange"/>

	    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:300px;"
	    			data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    			multiple:false,required:true,panelWidth:400,method:'get',lines:true,tipPosition:'left'" />
	    			<!-- <A href="#" onclick="viewWorkflowDialog();">查看流程图</a>  -->
		    	</td>
		    </tr>
		    </table>
 		<!-- 这里引用公用列管信息模块 -->
		    <%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
		     <!-- 列管公共信息 -->
	    	<table id="ggDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;">
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgrqText">业务办理日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ywclsj" id="ywclsj" class="easyui-validatebox inputreadonly" style="width:200px;" value="${applyDate}" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="lgrText">业务办理人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" style="width:200px;" value="${applyUser}" readonly="readonly" /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="ywfqyy" name="zdryLczywblb.ywfqyy" style="width:628px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>
	    	
	    	</table>
	    		    	
	    </div>
    </form>
</div>
<script type="text/javascript" >
var lcg="lg";//zdryLgLxInc.jsp更改类型的时候使用

var filterStr='${filterStr}';
var filterZdStr='${filterZdStr}';
var mainTabID = "${mainTabID}";
$(document).ready(function(){
    $('#zdrygllxdm').combobox('setValue', '${zdrygllxdm}');
    
	var zdryHsbId = $("#zdryHsbId").val();
	if(zdryHsbId != null && zdryHsbId != ""){
		$('#zdrylbStr').combotree('setValue', '${zdrylbdm}');
		$('#glffdm').combobox('setValue', '${glffdm}');
		$('#lglydm').combobox('setValue', '${lglydm}');
	}
	
	//查询已列管类型和可列管类型
	queryYlglx($("#ryid").val(),$("#syrkid").val());
});


function beforeSubmit() {
	var obj=$("#fzxzdm").combotree("tree");
	var nodes=[];
	 nodes=obj.tree('getChecked');
	 var selectedItemArray=[];
	 if(nodes){
		 var length=0;
		 for(var i=0;i<nodes.length;i++){
			    if(!nodes[i].children){
                     length++;
				 }
			}
         if(length>5){
            alert("犯罪性质最多选择5条！");
            $("#fzxzdm").combotree("clear");
            return false;
          }
	}
	
   
}

function afterSubmit() {
	parent.location.reload();
}

//查询已列管类型
function queryYlglx(ryid,syrkid){	
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryYlglx",
		dataType: "json",
		data:"ryid=" + ryid + "&syrkid=" + syrkid,
		success: function(data) {
			if (data) {				
				var resAry=data.split("/");
				$("#ylglxTr").show();
				$("#ylglx").text(resAry[0]);
				queryKlglx(resAry[1],syrkid);//查询可列管类型				
			}else{
				$("#ylglxTr").hide();
				$("#zdrygllxdm").combobox("setDataFilter", "");
			}
		},		
		error: function() {
			$("#ylglxTr").hide();
			$("#zdrygllxdm").combobox("setDataFilter", "");
		}
	});		
}

//查询可列管类型
function queryKlglx(ylglxStr,syrkid){
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryklglx",
		dataType: "json",
		data:"ylglxStr=" + ylglxStr+"&syrkid="+syrkid,
		success: function(data) {
			if (data) {								
				$("#zdrygllxdm").combobox("setDataFilter", data);	
				$("#zdrygllxdm").combobox("setValue", "");
				$('#zdrylbStr').combotree('tree').tree('loadData', [''])
			}else{
				$("#zdrygllxdm").combobox("setDataFilter", "");					
			}
		},		
		error: function() {
			$("#zdrygllxdm").combobox("setDataFilter", "");	
		}
	});	
}

/**根据证件种类 设置证件号码验证*/
function cyzjdmChange(newVal, oldVal) {	
	if (!newVal) {
		newVal = "";
	}	
	
	if (newVal == "111" || newVal == "112" || newVal == "335" ) {
		$("#zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	$("#zjhm").val("");
}

/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
function checkZjhm() {
	if (!$("#cyzjdm").combo("isValid")){
		return;
	}
	if (!$("#zjhm").validatebox("isValid")){
		return;
	}
	var _zjhm = $("#zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if($("#zjhm").val() == _zjhm){
		return;
	}
	
	czrkNO = "0";
	jzrkNO = "0";
	ldrkNO = "0";
	wlczrkNO = "0";
	jwryNO = "0";
	autoGllb = true;
	$("#ryxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>dataApply/ryxxApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data) {
			if (data) {
				data = $.parseJSON(data);
				$("#xm").val(data.xm);	
				$("#xbdm").combobox("setValue", data.xbdm);
				$("#cyzjdm").val(data.cyzjdm);
				$("#zjhm").val(data.zjhm);
				$("#syrkid").val(data.id);	
				$("#ryid").val(data.ryid);
				
				$("#csrq").val(data.csrq);
				$("#mzdm").combobox("setValue",data.mzdm);
				$("#jgssxdm").val(data.jgssxdm);
				$("#hjd_xzqhdm").combobox("setValue",data.hjd_xzqhdm);				
				$("#hjd_mlpdm").val(data.hjd_mlpdm);
				$("#hjd_mlpxz").val(data.hjd_mlpxz);
				$("#hjd_dzid").val(data.hjd_dzid);
				$("#hjd_dzxz").val(data.hjd_dzxz);
				$("#jzd_xzqhdm").combobox("setValue",data.jzd_xzqhdm);				
				$("#jzd_mlpdm").val(data.jzd_mlpdm);
				$("#jzd_mlpxz").val(data.jzd_mlpxz);
				$("#jzd_dzid").val(data.jzd_dzid);
				$("#jzd_dzxz").val(data.jzd_dzxz);
				$("#jzd_zbx").val(data.jzd_zbx);
				$("#jzd_zby").val(data.jzd_zby);
				$("#gxfjdm").val(data.gxfjdm);
				$("#gxpcsdm").val(data.gxpcsdm);
				$("#gxzrqdm").val(data.gxzrqdm);			
			}
		},
		complete:function() {
			$("#zjhm").attr("zjhm", $("#zjhm").val());
			$("#ryxxLoadDiv").hide();
		},
		error:function() {
		}
	});	
}

function ryxxTag(index){
	
	if(index==1){
		$("#ryxxShow").hide();
		$("#ryxxHide").show();
		$("#ryxxDiv").show();
	}else{
		$("#ryxxShow").show();
		$("#ryxxHide").hide();
		$("#ryxxDiv").hide();
	}
}
function viewWorkflowDialog(){
	var zdrygllxdm = $("#zdrygllxdm").val();
	var processDefinitionKey =null;
	$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>wf/getProcDefId/1/" + zdrygllxdm,
		dataType:"json",
		success:function(data){
			if (data && data.length>0) {
				processDefinitionKey = data;
				var url = '/syrk/diagram/diagram/' + processDefinitionKey;
				var result=window.open(url,'_blank','modal=yes,height=600px,width=900px,resizable=yes,z-look=yes,alwaysRaised=yes'); 
				window.onfocus=function (){result.focus();};
			}else{
				alert("Workflow is not found.");
			}				
		}
	});   
}

</script>