<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>吸毒人员吸毒信息</title>
	<style type="text/css">
		.item_title{
			width:100px;
		}
		
		.item_content{
			width:200px;
		}
		
		.text_input{
			width:535px;
		}
	</style>
	
	<script type="text/javascript"> 

	function doInit(paramArray) {
	
		initComboBox('fxchczdwdm', contextPath + '/common/dict/GB_D_XZQHDMLIST.js');
		
		//if ($('#pk').val() != "") {
		//	formReadonly('dataForm', true);
		//}
	}
	
	function beforeSubmit() {
		if ($("#pk").val() == "") {
			$("#_method").val('');
			$("#dataForm").attr('action', contextPath + '/zdryXdryxdxx/save');
		}
		else {
			$("#_method").val('PUT');
			$("#dataForm").attr('action', contextPath + '/zdryXdryxdxx/' + $("#pk").val());
		}
	}
	
	function afterSubmit(arr) {
		if (arr["saveID"]){
			$("#pk").val(arr["saveID"]);
		}
	}

</script>
	
</head>

<body>

	<form action="" id="dataForm" name="dataForm" method="post">
	    
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />
	   
	  	<table border="0" cellpadding="0" cellspacing="10" align="left">
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">毒品种类：</td>
		    	<td class="dialogTd item_content">
		    		<input class="easyui-combobox" type="text" id="dpzldm" name="dpzldm" style="width:200px;" value="${entity.dpzldm }"
						data-options="url: contextPath + '/common/dict/JD_D_DPZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'" />
		    	</td>
		    	<td class="dialogTd item_title" align="right">吸毒方式：</td>
		    	<td class="dialogTd item_content">
		    		<input name="xdfsdm" id="xdfsdm" value="${entity.xdfsdm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_XDFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
		    	</td>
	   		</tr>
			<tr class="dialogTr">
				<td class="dialogTd item_title" align="right">毒品来源：</td>
		    	<td class="dialogTd item_content">
		    		<input name="dplydm" id="dplydm" value="${entity.dplydm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_DPLYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
		    	
		    	<td class="dialogTd item_title" align="right">毒资来源：</td>
		    	<td class="dialogTd item_content">
		    		<input name="dzlydm" id="dzlydm" value="${entity.dzlydm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_DZLYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
			</tr>
			
			<tr class="dialogTr">
				<td class="dialogTd item_title" align="right">吸毒原因：</td>
		    	<td class="dialogTd item_content">
		    		<input name="xdyydm" id="xdyydm" value="${entity.xdyydm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_XDYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left',required:true"/>
		    	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
		    	<td class="dialogTd item_title" align="right">查获机构名称：</td>
		    	<td class="dialogTd item_content" colspan="3">
		    	<textarea name="chjgmc" id="chjgmc" class="easyui-validatebox text_input" style="width:535px; height:24px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'查获机构名称不能超过100个汉字，请重新输入！',tipPosition:'left'">${entity.chjgmc}</textarea></td>
	    	</tr>
	    	
	    	<tr class="dialogTr" >
		    	<td class="dialogTd item_title" align="right">共同吸毒情况：</td>
		    	<td class="dialogTd item_content" >
		    		<textarea name="gtxdqk" id="gtxdqk" class="easyui-validatebox" style="width: 200px; height:60px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'共同吸毒情况不能超过100个汉字，请重新输入！',tipPosition:'left'">${entity.gtxdqk}</textarea>
				</td>
	    	
	    		<td class="dialogTd item_title" align="right">危害社会后果：</td>
		    	<td class="dialogTd item_content" >
		    		<textarea name="whshhg" id="whshhg" class="easyui-validatebox" style="width: 200px; height:62px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'危害社会后果不能超过100个汉字，请重新输入！',tipPosition:'left'">${entity.whshhg}</textarea>
				</td>
					
			</tr>
	    	
	    	<tr><td colspan="4" style="height: 2px"></td></tr>
	    	<tr style="background-color: #95b8e7;"><td colspan="4" style="height: 1px"></td></tr>
	    	<tr><td colspan="4" style="height: 2px"></td></tr>
	    	
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">初次吸毒种类：</td>
		    	<td class="dialogTd item_content">
		    		<input name="ccxdzldm" id="ccxdzldm" value="${entity.ccxdzldm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_DPZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
		    	<td class="dialogTd item_title" align="right">初次吸毒日期：</td>
		    	<td class="dialogTd item_content">
		    		<input type="text" name="ccxd_rq" id="ccxd_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.ccxd_rq}"
				     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'new Date()'})" 
				     		data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
		    	</td>
	   		</tr>
	   		
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">初次查获日期：</td>
		    	<td class="dialogTd item_content">
		    		<input type="text" name="ccch_rq" id="ccch_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.ccch_rq}"
				     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'new Date()'})" 
				     		data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
		    	</td>
		    	<td class="dialogTd item_title" align="right">初次查获处置情况：</td>
		    	<td class="dialogTd item_content">
		    		<input name="ccchczqkdm" id="ccchczqkdm" value="${entity.ccchczqkdm}" class="easyui-combobox" 
		    		style="width:200px;"  data-options="url: contextPath + '/common/dict/BD_D_CHCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
	   		</tr>
	   		
	   		<tr class="dialogTr">
		    	<td class="dialogTd item_title" align="right">初次查获详址：</td>
		    	<td class="dialogTd item_content" colspan="3">
			    	<textarea name="ccchxz" id="ccchxz" class="easyui-validatebox text_input" style="width:535px; height:24px;"
						data-options="validType:['maxLength[100]'],invalidMessage:'初次查获详址不能超过100个汉字，请重新输入！',tipPosition:'left'">${entity.ccchxz}</textarea>
				</td>
	    	</tr>
	    	
	    	<tr><td colspan="4" style="height: 2px"></td></tr>
	    	<tr style="background-color: #95b8e7;"><td colspan="4" style="height: 1px"></td></tr>
	    	<tr><td colspan="4" style="height: 2px"></td></tr>
	    	
	    	<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">吸毒人员现状：</td>
		    	<td class="dialogTd item_content">
		    		<input name="xdryxzdm" id="xdryxzdm" value="${entity.xdryxzdm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/BD_D_XDRYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
		    	
		    	<td class="dialogTd item_title" align="right">戒毒情况：</td>
		    	<td class="dialogTd item_content">
			    	<textarea name="jdqk" id="jdqk" class="easyui-validatebox" style="width: 200px; height:60px;"
						data-options="validType:['maxLength[100]'],invalidMessage:'戒毒情况不能超过100个汉字，请重新输入！',tipPosition:'left'">${entity.jdqk}</textarea>
				</td>
	   		</tr>
	    	
	    	<tr><td colspan="4" style="height: 2px"></td></tr>
	    	<tr style="background-color: #95b8e7;"><td colspan="4" style="height: 1px"></td></tr>
	    	<tr><td colspan="4" style="height: 2px"></td></tr>
	    	
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">复吸次数：</td>
		    	<td class="dialogTd item_content">
		    		<input class="easyui-numberspinner" type="text" 
		    		id="fxcs" name="fxcs" value="${entity.fxcs}" style="width:200px;" data-options="min:0"/>
		    	</td>
		    	<td class="dialogTd item_title" align="right">复吸日期：</td>
		    	<td class="dialogTd item_content">
		    		<input type="text" name="fxrq" id="fxrq" class="easyui-validatebox" style="width: 200px;" value="${entity.fxrq}"
				     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'new Date()'})" 
				     		data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
		    	</td>
	   		</tr>
	   		
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">复吸毒品种类：</td>
		    	<td class="dialogTd item_content">
		    		<input name="fxdpzldm" id="fxdpzldm" value="${entity.fxdpzldm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_DPZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
		    	<td class="dialogTd item_title" align="right">复吸查获处置情况：</td>
		    	<td class="dialogTd item_content">
		    		<input name="fxchczqkdm" id="fxchczqkdm" value="${entity.fxchczqkdm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/BD_D_CHCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						tipPosition:'left'"/>
		    	</td>
	   		</tr>
	   		
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">复吸查获处置单位：</td>
		    	<td class="dialogTd item_content" colspan="3">
		    		<input type="text" name="fxchczdwdm" id="fxchczdwdm" value="${entity.fxchczdwdm}" class="easyui-combobox" style="width:200px;"
		    				data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',
								valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'">
		    	</td>
	   		</tr>
	   		
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">复吸查获详址：</td>
		    	<td class="dialogTd item_content" colspan="3">
		    		<textarea name="fxchxz" id="fxchxz" class="easyui-validatebox text_input" style="width:535px; height:24px;"
						data-options="validType:['maxLength[100]'],invalidMessage:'复吸查获详址不能超过100个汉字，请重新输入！',tipPosition:'left'" > ${entity.fxchxz}</textarea>
		    	</td>
	   		</tr>
	   		
	    </table>
	</form>
    
</body>

</html>
