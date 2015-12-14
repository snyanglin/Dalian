<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
		<title>重点人员违法犯罪记录子表</title>
	</head>

<body>
			
		<form action="" id="dataForm" name="dataForm" method="post" >
    		
    		<input type="hidden" id="_method" name="_method" value=""/>
    		<input type="hidden" id="pk" name="id" value="${entity.id }" />			
			<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid }" />
			
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
		    	<td width="20%" class="dialogTd" align="right">案件编号：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ajbh" id="ajbh" class="easyui-validatebox" style="width:200px;" value="${entity.ajbh}" maxlength="23"
						data-options="required:false"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">案件名称：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ajmc" id="ajmc" class="easyui-validatebox" style="width:200px;" value="${entity.ajmc}" maxlength="50"
						data-options="required:false"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">案件类型：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ajlxdm" id="ajlxdm" class="easyui-combobox" style="width:200px;" value="${entity.ajlxdm}" maxlength="6"
						data-options="required:false,url: contextPath + '/common/dict/DL_D_AJLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:salxdmChange"/>
				</td>
				<td width="20%" class="dialogTd" align="right">人员涉案类型：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="rysalxdm" id="rysalxdm" class="easyui-combobox" style="width:200px;" value="${entity.rysalxdm}" maxlength="1"
						data-options="required:false,url: contextPath + '/common/dict/ZA_D_RYSALXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr" id="sxs_ajlbdm_tr" >
	    	<td width="20%" class="dialogTd" align="right" >涉刑事案件类别：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="sxs_ajlbdm" id="sxs_ajlbdm" class="easyui-combobox" style="width:200px;" value="${entity.sxs_ajlbdm}" maxlength="6"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_SXSAJLB.js',valueField:'id',textField:'text',method:'get',selectOnNavigation:false"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr" id="sxz_ajlbdm_tr">
		    	<td width="20%" class="dialogTd" align="right" >涉行政案件类别：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="sxz_ajlbdm" id="sxz_ajlbdm" class="easyui-combobox" style="width:200px;" value="${entity.sxz_ajlbdm}" maxlength="6"
						data-options="required:false,url: contextPath + '/common/dict/DL_D_AYDM.js',valueField:'id',textField:'text',method:'get',selectOnNavigation:false"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">案发日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="af_rq" id="af_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.af_rq}" maxlength="19"
		     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']']"/>
		     	</td>
				<td width="20%" class="dialogTd" align="right">案发地点行政区划：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="afdd_xzqhdm" id="afdd_xzqhdm" class="easyui-combobox" style="width:200px;"
	    			value="${entity.afdd_xzqhdm}" data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:false,
							valueField:'id',textField:'text',selectOnNavigation:false">
				</td> 	
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">案发地点详址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input name="afddxz" id="afddxz" class="easyui-validatebox" style="width:618px;" value="${entity.afddxz}" maxlength="100"
						data-options="required:false"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">涉案情节及处理结果：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="saqjjcljg" id="saqjjcljg" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[4000]'],invalidMessage:'涉案情节及处理结果不能超过4000个汉字，请重新输入！',tipPosition:'left'">${entity.saqjjcljg}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		     	<td width="20%" class="dialogTd" align="right">处理单位：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input name="cl_dwmc" id="cl_dwmc" class="easyui-validatebox" style="width:618px;" value="${entity.cl_dwmc}" maxlength="50"
						data-options="required:false,validType:['maxLength[50]'],invalidMessage:'处理单位名称不能超过50个汉字，请重新输入！',tipPosition:'left'"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">办案民警：</td>
		    	<td width="30%" class="dialogTd"><input name="bamj" id="bamj" class="easyui-validatebox" style="width:200px;" value="${entity.bamj}" maxlength="300"
						data-options="required:false"/>
				</td>
				<td width="20%" class="dialogTd" align="right">处罚时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="cfsj" id="cfsj" class="easyui-validatebox" style="width: 200px;" value="${entity.cfsj}" maxlength="19"
		     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="validType:['date[\'yyyy-MM-dd\']']"/>
		     	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
		     	<td width="20%" class="dialogTd" align="right">处罚机关：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input name="cfjg" id="cfjg" class="easyui-validatebox" style="width:618px;" value="${entity.cfjg}" maxlength="100"
						data-options="required:false,validType:['maxLength[50]'],invalidMessage:'处罚机关不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		     	<td width="20%" class="dialogTd" align="right">执行机关：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input name="zxjg" id="zxjg" class="easyui-validatebox" style="width:618px;" value="${entity.zxjg}" maxlength="100"
						data-options="required:false,validType:['maxLength[50]'],invalidMessage:'执行机关不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		     	<td width="20%" class="dialogTd" align="right">执行地点：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input name="zxdd" id="zxdd" class="easyui-validatebox" style="width:618px;" value="${entity.zxdd}" maxlength="100"
						data-options="required:false,validType:['maxLength[50]'],invalidMessage:'执行地点不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
				</td>
	    	</tr>
	    	<tr class="dialogTr">
		     	<td width="20%" class="dialogTd" align="right">执行开始时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zx_kssj" id="zx_kssj" class="easyui-validatebox" style="width: 200px;" value="${entity.zx_kssj}" maxlength="19"
		     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="validType:['date[\'yyyy-MM-dd\']']"/>
		     	</td>
		     	<td width="20%" class="dialogTd" align="right">执行结束时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zx_jssj" id="zx_jssj" class="easyui-validatebox" style="width: 200px;" value="${entity.zx_jssj}" maxlength="19"
		     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="validType:['date[\'yyyy-MM-dd\']']"/>
		     	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
	    	</table>
   	</form>
</body>

<script type="text/javascript">
initComboBox('afdd_xzqhdm', contextPath + '/common/dict/GB_D_XZQHDMLIST.js'); 

function doInit(paramArray){
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
	$("#sxs_ajlbdm_tr").hide();
	$("#sxz_ajlbdm_tr").hide();
	 salxdmChange($("#ajlxdm").val(), "");
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryWffzjlxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryWffzjlxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	if($("#ajlxdm").val()=="1"){
		$("#sxs_ajlbdm").combobox("setValue","");
	}else if($("#ajlxdm").val()=="2"){
		$("#sxz_ajlbdm").combobox("setValue","");

	}
}

function salxdmChange(newVal, oldVal){
	if(newVal=="1"){
		$("#sxz_ajlbdm_tr").show();
		$("#sxs_ajlbdm_tr").hide();
	}else if(newVal=="2"){
		$("#sxs_ajlbdm_tr").show();
		$("#sxz_ajlbdm_tr").hide();

	}
	
}

</script>
</html>
