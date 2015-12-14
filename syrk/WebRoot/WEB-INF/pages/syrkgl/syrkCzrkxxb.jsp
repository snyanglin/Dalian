<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>常住人口信息</title>
</head>

<body>

<form action="<%=basePath%>syrkCzrkxxb/${czrk.id}" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value="PUT"/>
  	<input type='hidden' id="pk" name='id' value="${czrk.id}" />
	<input type="hidden" id="ryid" name="ryid" value="${czrk.ryid}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_gmsfhm" name="gmsfhm" value="${czrk.gmsfhm}" style="width:200px;" maxlength="30"/></td>
   	        <td width="20%" class="dialogTd" align="right">姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_xm" name="xm" value="${czrk.xm}" style="width:200px;" maxlength="50"
   	        	data-options="required:true,tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">性别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_xbdm" name="xbdm" value="${czrk.xbdm}" style="width:200px;" 
				data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_csrq" name="csrq" value="${czrk.csrq}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">民族：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_mzdm" name="mzdm" value="${czrk.mzdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_lxdh" name="lxdh" value="${czrk.lxdh}" style="width:200px;" maxlength="11"
				data-options="validType:['mobile'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('czrk_lxdh','ryid')"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">出生国家：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_csdgjhdqdm" name="csdgjhdqdm" value="${czrk.csdgjhdqdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">出生地：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_csdssxdm" name="csdssxdm" value="${czrk.csdssxdm}" style="width:200px;" 
  	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">籍贯国家：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_jggjdqdm" name="jggjdqdm" value="${czrk.jggjdqdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:czrk_jggjdqdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">籍贯：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_jgssxdm" name="jgssxdm" value="${czrk.jgssxdm}" style="width:200px;" 
  	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">学历：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="czrk_xldm" name="xldm" value="${czrk.xldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_XLDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
	    	<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_hyzkdm" name="hyzkdm" value="${czrk.hyzkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">政治面貌：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_zzmmdm" name="zzmmdm" value="${czrk.zzmmdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">宗教信仰：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_zjxydm" name="zjxydm" value="${czrk.zjxydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_ZJXYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">兵役状况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_byzkdm" name="byzkdm" value="${czrk.byzkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_BYQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">血型：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_xxdm" name="xxdm" value="${czrk.xxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
      	</tr>
      	<tr>
      	    <td width="20%" class="dialogTd" align="right">职业类别：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="czrk_zylbdm" name="zylbdm" value="${czrk.zylbdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
            <td width="20%" class="dialogTd" align="right">职业：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_zy" name="zy" value="${czrk.zy}" style="width:200px;" maxlength="60"/></td> 
  
      	</tr>
	    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">工作单位：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
					    	<input type="hidden" id="czrk_gzdwid" name="gzdwid" value="${czrk.gzdwid}"/>
					    	<input type="hidden" id="czrk_gzdw" name="gzdw" value="${czrk.gzdw}"/>
				    		<input class="easyui-combobox" id="czrk_gzdw_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${czrk.gzdw}" maxlength="50" style="width:618px;" /></td>
		</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">户口性质：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_hkxzfldm" name="hkxzfldm" value="${czrk.hkxzfldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_HKXZFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',dataFilter:'1|2|3|4|5|8|9',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">户号：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_hh" name="hh" value="${czrk.hh}" style="width:200px;" maxlength="9"
				data-options="required:false,validType:['numeric[\'i\']'],charSet:'half',tipPosition:'left'" onblur="czrk_hh_onblur()"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">与户主关系：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="czrk_yhzgxdm" name="yhzgxdm" value="${czrk.yhzgxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_JTGXDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
	    	<td width="20%" class="dialogTd" align="right">是否人户一致：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_sfrhyzdm" name="sfrhyzdm" value="${czrk.sfrhyzdm}" style="width:200px;" 
				data-options="required:true,url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">户籍地址：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="czrk_hjd_dzxz" value="${czrk.hjd_dzxz}" style="width:618px;" maxlength="60"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住地：</td>
      		<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="czrk_jzd1" style="width:380px;" value="${czrk.jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_jzd_mlpdm" name="jzd_mlpdm" value="${czrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="czrk_jzd_mlpxz" name="jzd_mlpxz" value="${czrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="czrk_jzd2" style="width:200px;" value='${fn:replace(czrk.jzd_dzxz, czrk.jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_jzd_dzid" name="jzd_dzid" value="${czrk.jzd_dzid}"/>
					    	<input type="hidden" id="czrk_jzd_xzqhdm" name="jzd_xzqhdm" value="${czrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="czrk_jzd_dzxz" name="jzd_dzxz" value="${czrk.jzd_dzxz}"/>
					    	<input type="hidden" id="czrk_jzd_zbx" name="jzd_zbx" value="${czrk.jzd_zbx}"/>
					    	<input type="hidden" id="czrk_jzd_zby" name="jzd_zby" value="${czrk.jzd_zby}"/>
					    	<input type="hidden" id="czrk_zrqdm" value="${zrqdm}"/>
				    	</td>
      	
      	
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">迁入日期：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_lbsqk_qlrrq" name="lbsqk_qlrrq" value="${czrk.lbsqk_qlrrq}" style="width:200px;" 
   	 			data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td> 
	    	<td width="20%" class="dialogTd" align="right">迁入原因：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_lbsqk_qyldyydm" name="lbsqk_qyldyydm" value="${czrk.lbsqk_qyldyydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	      	</tr>
  	      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">来自国家：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_lbsqk_lzd_gjhdqdm" name="lbsqk_lzd_gjhdqdm" value="${czrk.lbsqk_lzd_gjhdqdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right"></td>
	    	<td width="30%" class="dialogTd"></td>
      	</tr>
	  	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">来自地址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="czrk_lbsqk_lzd1" style="width:400px;" value="${czrk.lbsqk_lzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="czrk_lbsqk_lzd_mlpdm" name="lbsqk_lzd_mlpdm" value="${czrk.lbsqk_lzd_mlpdm}"/>
		    	<input type="hidden" id="czrk_lbsqk_lzd_mlpxz" name="lbsqk_lzd_mlpxz" value="${czrk.lbsqk_lzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="czrk_lbsqk_lzd2" style="width:200px;" value='${fn:replace(czrk.lbsqk_lzd_dzxz, czrk.lbsqk_lzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="czrk_lbsqk_lzd_dzid" name="lbsqk_lzd_dzid" value="${czrk.lbsqk_lzd_dzid}"/>
		    	<input type="hidden" id="czrk_lbsqk_lzd_xzqhdm" name="lbsqk_lzd_xzqhdm" value="${czrk.lbsqk_lzd_xzqhdm}"/>
		    	<input type="hidden" id="czrk_lbsqk_lzd_dzxz" name="lbsqk_lzd_dzxz" value="${czrk.lbsqk_lzd_dzxz}"/>
	    	</td>
   	    </tr>
   	    
	</table>
</form>
    
</body>

<script type="text/javascript"> 

var _p;
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";

function doInit(paramArray) {
	_p = paramArray["_p"];

	setInputReadonly("czrk_gmsfhm", true);
	//setInputReadonly("czrk_hjd_dzxz", true);
	
	if($("#czrk_jzd_dzid").val()==""&&$("#czrk_jzd2").val()!=""){
		setInputReadonly("czrk_jzd1", false);
		setInputReadonly("czrk_jzd2", false);
	}
	
	setInputReadonly("czrk_hjd_dzxz", true);
	// 大数据的下拉列表初始化
	initComboBox("czrk_csdssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("czrk_jgssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	
	// 地址选择初始化
	initAddressSearch("czrk_lbsqk_lzd1", {}, "czrk_lbsqk_lzd_mlpdm", "czrk_lbsqk_lzd_mlpxz", "czrk_lbsqk_lzd2", {text:"czrk_lbsqk_lzd_dzxz",dzxzqh:"czrk_lbsqk_lzd_xzqhdm",id:"czrk_lbsqk_lzd_dzid"}, null, null);
	initDepartmentSearch("czrk_gzdw_select", {}, "czrk_gzdwid", "czrk_gzdw", {});
	initAddressSearch("czrk_jzd1", {zrqdm:'#czrk_zrqdm'}, "czrk_jzd_mlpdm", "czrk_jzd_mlpxz", "czrk_jzd2", {text:"czrk_jzd_dzxz",dzxzqh:"czrk_jzd_xzqhdm",id:"czrk_jzd_dzid",dzzbx:"czrk_jzd_zbx",dzzby:"czrk_jzd_zby"}, null, null);
	czrk_jggjdqdm_onChange($("#czrk_jggjdqdm").combobox("getValue"));
	
	setInputReadonly("czrk_jzd1", true);
	setInputReadonly("czrk_jzd2", true);
}

function beforeSubmit() {
	if ($("#dataForm").form("validate")) {
		var czrk_sfrhyzdmValue = $("#czrk_sfrhyzdm").combobox("getValue");
		if (czrk_sfrhyzdmValue == "0") { // 人户分离
			if ($("#hjRadio1").is(":checked")) {
				if ($("#czrk1_hjd_mlpdm").val() == "") {
					topMessager.alert("", "户籍地址必须为标准地址，请重新选择！");
					var comboText = $("#czrk1_hjd1").next(".combo").children(".combo-text");
					comboText.focus();
					return false;
				}
				if ($("#czrk1_hjd2").combobox("getValue") == "") {
					topMessager.alert("", "户籍地址必须为标准地址，请重新选择！");
					var comboText = $("#czrk1_hjd2").next(".combo").children(".combo-text");
					comboText.focus();
					return false;
				}
				$("#czrk_hjd_xzqhdm").val($("#czrk1_hjd_xzqhdm").val());
				$("#czrk_hjd_mlpdm").val($("#czrk1_hjd_mlpdm").val());
				$("#czrk_hjd_mlpxz").val($("#czrk1_hjd_mlpxz").val());
				$("#czrk_hjd_dzid").val($("#czrk1_hjd_dzid").val());
				$("#czrk_hjd_dzxz").val($("#czrk1_hjd_dzxz").val());
			}
			else if ($("#hjRadio2").is(":checked")) {
				if ($("#czrk2_hjd_dzxz").val() == "") {
					topMessager.alert("", "户籍集体空挂户不能为空！");
					return false;
				}
				$("#czrk_hjd_xzqhdm").val($("#czrk2_hjd_xzqhdm").val());
				$("#czrk_hjd_mlpdm").val($("#czrk2_hjd_mlpdm").val());
				$("#czrk_hjd_mlpxz").val($("#czrk2_hjd_mlpxz").val());
				$("#czrk_hjd_dzid").val($("#czrk2_hjd_dzid").val());
				$("#czrk_hjd_dzxz").val($("#czrk2_hjd_dzxz").val());
			}
			else if ($("#hjRadio3").is(":checked")) {
				if ($("#czrk3_hjd_dzxz").val() == "") {
					topMessager.alert("", "户籍居民空挂户不能为空！");
					return false;
				}
				$("#czrk_hjd_xzqhdm").val($("#czrk3_hjd_xzqhdm").val());
				$("#czrk_hjd_mlpdm").val($("#czrk3_hjd_mlpdm").val());
				$("#czrk_hjd_mlpxz").val($("#czrk3_hjd_mlpxz").val());
				$("#czrk_hjd_dzid").val($("#czrk3_hjd_dzid").val());
				$("#czrk_hjd_dzxz").val($("#czrk3_hjd_dzxz").val());
			}
		}
		else { // 人户一致
			if ($("#czrk_jzd_mlpdm").val() == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#czrk_jzd1").next(".combo").children(".combo-text");
				comboText.focus();
				return false;
			}
			if ($("#czrk_jzd2").combobox("getValue") == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#czrk_jzd2").next(".combo").children(".combo-text");
				comboText.focus();
				return false;
			}
			$("#czrk_hjd_xzqhdm").val($("#czrk_jzd_xzqhdm").val());
			$("#czrk_hjd_mlpdm").val($("#czrk_jzd_mlpdm").val());
			$("#czrk_hjd_mlpxz").val($("#czrk_jzd_mlpxz").val());
			$("#czrk_hjd_dzid").val($("#czrk_jzd_dzid").val());
			$("#czrk_hjd_dzxz").val($("#czrk_jzd_dzxz").val());
		}
	}
}

function afterSubmit(arr) {
	setFormDataToSpan($("body"),_p);
}

function setFormDataToSpan(containObject,_p) {
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text(comboText);
			}
		}
	});
	var textareaSelector = containObject.find('textarea.edit_input');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = $(_p).find("span[name='"+_name+"']");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}

function czrk_jggjdqdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var czrk_jggjdqdmValue = $("#czrk_jggjdqdm").combobox("getValue");
	if (czrk_jggjdqdmValue == "156") {
		setInputReadonly("czrk_jgssxdm", false);
	}
	else {
		$("#czrk_jgssxdm").combobox("setValue", "");
		setInputReadonly("czrk_jgssxdm", true);
	}
}

function czrk_hh_onblur() {
	var czrk_hhValue = $("#czrk_hh").val();
	if (czrk_hhValue != "" && $("#czrk_hh").validatebox("isValid")) {
		czrk_hhValue = "000000000" + czrk_hhValue;
		czrk_hhValue = czrk_hhValue.substring(czrk_hhValue.length - 9);
		$("#czrk_hh").val(czrk_hhValue);
	}
}

</script>

</html>
