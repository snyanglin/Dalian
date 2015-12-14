<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社区警务室信息</title>
</head>

<body style="margin-top:20px" class="bodybg">
    <form action="<%=basePath%>sqjwsxxb/saveAddSqjwsxxb" id="dataForm" name="dataForm" method="post">
    	
    	<div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
			<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    		<input type="hidden" name="id" id="pk" value="" />
			    <tr class="dialogTr">
			  			<td width="20%" class="dialogTd" align="right">警务室名称：</td>
					<td width="30%" class="dialogTd">
					<input  type='text' id='jwsmc' name='jwsmc' class="easyui-validatebox" style="width:200px;"
					data-options="required:true,tipPosition:'right'" maxlength="50" value="" />
					</td> 
					<td width="20%" class="dialogTd" align="right">警务室类别：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="jwslb" name="jwslb" style="width:200px;" value=""
						data-options="url: contextPath + '/common/dict/D_ZAFF_JWSLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						required:false,tipPosition:'left'"/></td>
				</tr>
				 <tr class="dialogTr">
				 <td width="20%" class="dialogTd" align="right">警务室电话：</td>
					<td width="30%" class="dialogTd"><input class="easyui-validatebox " type="text" id="jwsdh" name="jwsdh" maxlength="30"
					data-options="validType:['phone'],tipPosition:'right'"
					style="width:200px;" value="" />
					</td>
					<td width="20%" class="dialogTd" align="right">警务室面积（㎡）：</td>
					<td width="30%" class="dialogTd" >
					<input class="easyui-validatebox" type="text" name="jwsmj" id="jwsmj" value="" style="width:200px;"
					data-options="validType:['numericRange[\'f\',2,1,10000]'],tipPosition:'left'" maxlength="100" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否独立：</td>
					<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text"  id="sfdldm" name="sfdldm" style="width:200px;" value=""
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
						required:false,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">民警人数：</td>
					<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mjrs" name="mjrs" style="width:200px;" value="" maxlength="3"
						data-options="required:false,validType:['naturalNumber'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">办公用品配置：</td>
					<td width="80%" class="dialogTd" colspan="3">
					<input  type='text' id='bgyppz' name='bgyppz' class="easyui-validatebox" style="width: 613px; "
					data-options="required:false,tipPosition:'left'" maxlength="1000" value="" />
					</td>
				</tr>
				<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">警务室地址：</td>
				 <td width="50%" class="dialogTd" colspan="2">
					  <input class="easyui-combobox" id="jzd1" style="width:400px;" value="" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='jwsdzmlpdm' id="jwsdzmlpdm" value=""/>
					    	<input type='hidden' name='jwsdzmlpxz' id="jwsdzmlpxz" value=""/>
					  </td>
					<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" id="jzd2" style="width:200px;" value="" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type="hidden" name="jwsdzdm" id="jwsdzdm" value=""/>
					<input type="hidden" name="jwsdzssxdm" id="jwsdzssxdm" value="ssxdm}"/>
				    <input type='hidden' name='jwsdzxz' id="jwsdzxz" value=""/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">计算机台数：</td>
					<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jsjts" name="jsjts" style="width:200px;" value=""
						data-options="validType:['naturalNumber'],required:false,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">连接公安网台数：</td>
					<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ljgawts" name="ljgawts" style="width:200px;" value=""
						data-options="validType:['naturalNumber'],required:false,tipPosition:'left'"/>
					</td>
				</tr>
		    	</table>
			</div>
			
		    <div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
				<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" onclick="save()">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">保存</span>
						<span class="l-btn-icon icon-save"> </span>
					</span>
				</a>
			</div>
		
		</div>
	    </div>
	    </div>
	    

    </form>
</div>

<script type="text/javascript">
function doInit() {
	
}

function beforeSubmit() {

}

function afterSubmit(arr) {

}

function save(){
	if($("#dataForm").form('validate')){
		if(window.confirm("确定要保存信息？")){
			document.getElementById("dataForm").submit();
		}
	}else{
		return;
	}
}

</script>

</html>
