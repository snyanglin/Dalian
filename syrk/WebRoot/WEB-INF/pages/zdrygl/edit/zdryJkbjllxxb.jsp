<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>物建监控/帮教力量</title>
</head>

<body>
    <form action="" id="dataForm" name="dataForm" method="post">
    	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}"/>
    
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
			<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="xm" style="width:200px;" readonly="readonly"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" style="width:200px;" readonly="readonly"/>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">监控帮教类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jkbjlxdm" name="jkbjlxdm" value="${entity.jkbjlxdm}" style="width:200px;" maxlength="1"
					data-options="url: contextPath + '/common/dict/DL_D_JKBJLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get',tipPosition:'right'"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">与重点人员关系：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jkbjry_ybbjr_rygx" id="jkbjry_ybbjr_rygx" value="${entity.jkbjry_ybbjr_rygx}" class="easyui-combobox" style="width:200px;"
	    			data-options="url: contextPath + '/common/dict/ZA_D_SHGXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get',tipPosition:'left'">
		    	</td>
	    	</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">帮教人公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jkbjry_gmsfhm" id="jkbjry_gmsfhm" value="${entity.jkbjry_gmsfhm}" class="easyui-validatebox" style="width: 200px;float:left;" 
		    		maxlength="18" data-options="required:true,charSet:'halfUpper',validType:['sfzh']" /><div class="lodingimg"></div></td>
		    	<td width="20%" class="dialogTd" align="right">帮教人姓名：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jkbjry_xm" id="jkbjry_xm" value="${entity.jkbjry_xm}" class="easyui-validatebox" style="width: 200px;" 
		    		maxlength="20" data-options="required:true,tipPosition:'left'" />
		    	</td>
	    	</tr>
	    	
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">帮教人性别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jkbjry_xbdm" name="jkbjry_xbdm" value="${entity.jkbjry_xbdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
		    	<td width="20%" class="dialogTd" align="right">帮教人民族：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jkbjry_mzdm" name="jkbjry_mzdm" value="${entity.jkbjry_mzdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">帮教人政治面貌：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jkbjry_zzmmdm" name="jkbjry_zzmmdm" value="${entity.jkbjry_zzmmdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">帮教人联系电话：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jkbjry_lxdh" id="jkbjry_lxdh" value="${entity.jkbjry_lxdh}" class="easyui-validatebox" value="${entity.jkbjry_lxdh}"style="width: 200px;" maxlength="18" 
		    		data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">帮教人现住详址：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" name="dz_jkbjry_xjzdzxz" id="dz_jkbjry_xjzdzxz" value="${entity.dz_jkbjry_xjzdzxz}" class="easyui-validatebox" 
		    		style="width: 618px;" maxlength="20" />
		    		<input type="hidden" name="dz_jkbjry_xjzdzdm" id="dz_jkbjry_xjzdzdm" value="${entity.dz_jkbjry_xjzdzdm}"/>
		    		<input type="hidden" name="dz_jkbjry_xjzdzssxdm" id="dz_jkbjry_xjzdzssxdm" value="${entity.dz_jkbjry_xjzdzssxdm}"  />
		    		<input type="hidden" name="dz_jkbjry_xjzdmlpdm" id="dz_jkbjry_xjzdmlpdm" value="${entity.dz_jkbjry_xjzdzssxdm}"/>
		    		<input type="hidden" name="dz_jkbjry_xjzdmlpxz" id="dz_jkbjry_xjzdmlpxz" value="${entity.dz_jkbjry_xjzdmlpxz}"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">帮教人工作单位：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input type="text" name="jkbjry_gzdwmc-box" id="jkbjry_gzdwmc-box" value="${entity.jkbjry_gzdwmc}" 
		    		class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,
		    		required:false" style="width: 618px;" maxlength="50" data-options="required:false,tipPosition:'right'" />
		    		<input type="hidden" name="jkbjry_gzdwid" id="jkbjry_gzdwid" value="${entity.jkbjry_gzdwid}" />
		    		<input type="hidden" name="jkbjry_gzdwmc" id="jkbjry_gzdwmc" value="${entity.jkbjry_gzdwmc}" />
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">帮教人职务：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jkbjry_zwmc" id="jkbjry_zwmc" value="${entity.jkbjry_zwmc}" class="easyui-validatebox" style="width: 200px;" 
		    		maxlength="20" />
		    	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
		    
	    </table>
    </form>
</body>

<script type="text/javascript" >
$(document).ready(function(){
	initDepartmentSearch('jkbjry_gzdwmc-box', {glpcsid: ''}, 'jkbjry_gzdwid', 'jkbjry_gzdwmc', {});	
	$("#jkbjry_gmsfhm").bind("blur",function(e){ sfHaveAdd(); });
});

var _zjhm = "";
/**
 * 通过身份证号码，判断该帮教人员是否已经添加到该重点人员下
 */
function sfHaveAdd(){
	if(!$("#jkbjry_gmsfhm").validatebox("isValid")){
		$("#jkbjry_gmsfhm").focus();
		return;
	}
	if($("#jkbjry_gmsfhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url: contextPath + "/zdryJkbjllxxb/existBjry",
		dataType:"json",
		data:"jkbjry_gmsfhm="+$("#jkbjry_gmsfhm").val()+"&zdryid="+$("#zdryid").val(),
		success:function(data){
			if (data == "true"){
				alert("该身份证号人员已被关联到该重点人员，请重新输入！");
				$("#jkbjry_gmsfhm").val("");
			} else {
				check();
			}
		},
		complete:function(){
			_zjhm = $("#jkbjry_gmsfhm").val();
			$(".lodingimg").hide();
		}
	});
}

/**
 * 通过身份证号，复用人员信息
 */
function check(){ 
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#jkbjry_gmsfhm").val()+"&cyzjdm=111",
		success:function(data){
			if (data && data.ryjbxxb) {
				$("#jkbjrryid").val(data.ryjbxxb.id);
				$("#jkbjry_xm").val(data.ryjbxxb.xm);
				$("#jkbjry_xbdm").combobox("setValue",data.ryjbxxb.xbdm);
				$("#jkbjry_mzdm").combobox("setValue",data.ryjbxxb.mzdm);
				$("#dz_jkbjry_xjzdzdm").val(data.ryjbxxb.dz_jzdzdm);
				$("#dz_jkbjry_xjzdzssxdm").val(data.ryjbxxb.dz_jzdzssxdm);
				$("#dz_jkbjry_xjzdzxz").val(data.ryjbxxb.dz_jzdzxz);
				$("#dz_jkbjry_xjzdmlpdm").val(data.ryjbxxb.dz_jzdmlpdm);
				$("#dz_jkbjry_xjzdmlpxz").val(data.ryjbxxb.dz_jzdmlpxz);
				$("#jkbjry_lxdh").val(data.ryjbxxb.lxdh);
				$("#jkbjry_zzmmdm").combobox("setValue",data.ryjbxxb.zzmmdm);
				$("#jkbjry_gzdwid").val(data.ryjbxxb.fwcsid);
				$("#jkbjry_gzdwmc").val(data.ryjbxxb.fwcs);
				$("#jkbjry_zwmc").val(data.ryjbxxb.zw);
				
				$("#jkbjry_xm").validatebox('validate');
			}
		},
		complete:function(){
			_zjhm = $("#jkbjry_gmsfhm").val();
			$(".lodingimg").hide();
		}
	});
}

function doInit(paramArray) {
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);

	_p = paramArray["_p"];
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryJkbjllxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryJkbjllxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	parent.location.reload();
}

</script>
</html>
