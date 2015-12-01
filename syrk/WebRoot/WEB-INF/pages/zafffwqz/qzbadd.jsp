<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>犬只管理</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0; width:800px;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>qzb/saveQzb" id="jbxxForm" name="jbxxForm" method="post">
	    	  <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
	    	  <input type='hidden' name='ryid' id="ryid" value="${entity.ryid}"/>  
	    	  <input type='hidden' name='flag' id="flag" value="${flag}"/> 
	    	  <input type='hidden' name='id' id="pk" value="${entity.id}"/>  
	    	  <table border="0" cellpadding="0" cellspacing="10" width="1000px" align="center">
				<tr class="dialogTr"><td width="100%" class="dialogTd" align="right">
				<div id="id_1">   		
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">  
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">证件类型：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-combobox" id="cyzjdm" name="cyzjdm" value="${entity.cyzjdm}" 
				    		style="width:200px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:setPassPort"/>
						</td> 
				    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd">
				    	<input type="text" name="zjhm" id ="zjhm" value="${entity.zjhm}" 
				    	class="easyui-validatebox" maxlength="30" data-options="required:true,validType:['sfzh'],tipPosition:'left'"  style="width:200px;float:left;" />
		    	       <div class="lodingimg" id="jbxxLoadDiv"></div>
		    	        </td>
	    	      </tr>
	    	      
	    	      <tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right">姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="xm" name="xm"
		    	 			value="${entity.xm}" maxlength="20" style="width:200px;" data-options="required:true,validType:['maxLength[20]'],tipPosition:'right'"/>
		    	        </td>
	    	      
				    	<td width="20%" class="dialogTd" align="right">性别：</td>
						<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
	    	      </tr>
	    	      <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出生日期：</td>
					<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" value="${entity.csrq}" class="easyui-validatebox"   style="width:200px;"
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
					<td width="20%" class="dialogTd" align="right">民族：</td>
					<td width="30%" class="dialogTd"><input type="text" name="mzdm" id="mzdm" value="${entity.mzdm}" class="easyui-combotree "  style="width:200px;" 
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_MZ.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true,tipPosition:'left'"
					 /></td>
	    	      </tr>
	    	       <tr class="dialogTr" id="jzdz">
					<td width="20%" class="dialogTd" align="right">居住地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
						<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/></td>
					<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jzdzdm' id='dz_jzdzdm' value="${entity.dz_jzdzdm}" />
				    	<input type='hidden' name='dz_jzdzssxdm' id='dz_jzdzssxdm' value="${entity.dz_jzdzssxdm}" />
				    	<input type='hidden' name='dz_jzdzxz' id='dz_jzdzxz' value="${entity.dz_jzdzxz}" /> 
			    </td>	
				</tr>
	    	    	<tr class="dialogTr">
	    	    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" value="${entity.lxdh}"
		    	        	style="width: 200px;" data-options="validType:['phone'],tipPosition:'right'" onblur="checkLxdh('lxdh','ryid')" />
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">是否单独居住：</td>
						<td width="30%" class="dialogTd"><input type="text" name="sfddjzdm" id="sfddjzdm" value="${entity.sfddjzdm}" class="easyui-combobox" style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
		    	   	</tr>
	    	        <tr class="dialogTr">
	    	         	<td width="20%" class="dialogTd" align="right">养犬用途：</td>
						<td width="30%" class="dialogTd"><input type="text" name="yqytdm" id="yqytdm" value="${entity.yqytdm}" class="easyui-combobox" style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_YQYT.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
	    	         		<td width="20%" class="dialogTd" align="right">完全行为能力：</td>
						<td width="30%" class="dialogTd"><input type="text" name="wqxwnldm" id="wqxwnldm" value="${entity.wqxwnldm}" class="easyui-combobox" style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
	    	         </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">犬型：</td>
						<td width="30%" class="dialogTd"><input type="text" name="qxdm" id="qxdm" value="${entity.qxdm}" class="easyui-combobox" style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_QXDM.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
						<td width="20%" class="dialogTd" align="right">犬种：</td>
						<td width="30%" class="dialogTd"><input type="text" name="qzdm" id="qzdm" value="${entity.qzdm}" class="easyui-combobox" style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_QZDM.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
	    	        </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">犬龄：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="qn" name="qn"
		    	 			value="${entity.qn}" maxlength="3" style="width:200px;" data-options="required:false,validType:['naturalNumberRange[1,100]'],tipPosition:'right'"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">体重(公斤)：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="tz" name="tz"
		    	 			value="${entity.tz}" maxlength="3" style="width:200px;" data-options="required:false,validType:['numericRange[\'f\',2,0.00,1000.00]'],tipPosition:'left'"/>
		    	        </td>
	    	        </tr>
	    	         <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">体高(厘米)：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="tg" name="tg"
		    	 			value="${entity.tg}" maxlength="3" style="width:200px;" data-options="required:false,validType:['numericRange[\'f\',2,0.00,300.00]'],tipPosition:'right'"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">毛色：</td>
				    	<td width="30%" class="dialogTd">
				    		<input  type="text" id="msdm" name="msdm"class="easyui-combobox" style="width:200px;" value="${entity.msdm}"
						data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_MS.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
	    	        </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">雌雄：</td>
				    	<td width="30%" class="dialogTd">
				    		<input  type="text" id="cxdm" name="cxdm"class="easyui-combobox" style="width:200px;" value="${entity.cxdm}"
						data-options="required:false,url: contextPath + '/common/dict/D_FWQZ_CX.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
		    	       
		    	        <td width="20%" class="dialogTd" align="right">有无血统证：</td>
				    	<td width="30%" class="dialogTd">
				    		<input  type="text" id="ywxtzdm" name="ywxtzdm"class="easyui-combobox" style="width:200px;" value="${entity.ywxtzdm}"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get',onSelect:fzgx"/></td>
	    	        
	    	        </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">发证机构：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="fzjg" name="fzjg"  maxlength="50"
		    	 			value="${entity.fzjg}" style="width:685px;" data-options="required:false,tipPosition:'left'"/>
		    	        </td>
	    	        	
	    	        </tr>
	    	         <tr class="dialogTr">
	    	         	<td width="20%" class="dialogTd" align="right">血统证编号：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="xtzbh" name="xtzbh"  maxlength="50"
		    	 			value="${entity.xtzbh}" style="width:200px;" data-options="required:false,tipPosition:'right'"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">防疫证号码：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="fyzhm" name="fyzhm" maxlength="50"
		    	 			value="${entity.fyzhm}" style="width:200px;" data-options="required:false,tipPosition:'left'"/>
		    	        </td>
	    	         </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">防疫部门：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="fybm" name="fybm" maxlength="50"
		    	 			value="${entity.fybm}" style="width:685px;" data-options="required:false,tipPosition:'left'"/>
		    	        </td>
	    	        </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">防疫有效截止日期：</td>
					<td width="30%" class="dialogTd"><input type="text" name="fyyxqzrq" id="fyyxqzrq" value="${entity.fyyxqzrq}" class="easyui-validatebox"   style="width:200px;"
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
					<td width="20%" class="dialogTd" align="right">养犬许可证号码：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="yqxkzhm" name="yqxkzhm" maxlength="50"
		    	 			value="${entity.yqxkzhm}" style="width:200px;" data-options="required:false,tipPosition:'left'"/>
		    	        </td>
	    	        </tr>
	    	        <tr class="dialogTr">
	    	        	  <td width="20%" class="dialogTd" align="right">发证日期：</td>
					<td width="30%" class="dialogTd"><input type="text" name="fzrq" id="fzrq" value="${entity.fzrq}" class="easyui-validatebox"   style="width:200px;"
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
					  <td width="20%" class="dialogTd" align="right">养犬许可证有效截止日期：</td>
					<td width="30%" class="dialogTd"><input type="text" name="yqxkzyxqzrq" id="yqxkzyxqzrq" value="${entity.yqxkzyxqzrq}" class="easyui-validatebox"   style="width:200px;"
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
	    	        </tr>
	    	        <tr class="dialogTr">
	    	        	<td width="20%" class="dialogTd" align="right">领取人：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="lqr" name="lqr"
		    	 			value="${entity.lqr}" style="width:200px;" data-options="required:false,tipPosition:'right'" maxlength="20"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">承办人：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="cbr" name="cbr"
		    	 			value="${entity.cbr}" style="width:200px;" data-options="required:false,tipPosition:'right'" maxlength="20" readonly="readonly"/>
		    	        </td>
	    	        </tr>
	    	         <tr class="dialogTr">
	    	         	<td width="20%" class="dialogTd" align="right">承办人意见：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="cbryj" name="cbryj"
		    	 			value="${entity.cbryj}" style="width:685px;" data-options="required:false,tipPosition:'left'" maxlength="100"/>
		    	        </td>
	    	         </tr>
	    	         
	    	      </table>
	    	      </div> 
	    	      </td></tr>
	    	    
	    	      
	    	       
			 
			 
			
	    		</table>
		    </div>
		    </form>
		
		    
		</div>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>
	    	  
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">退出</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
		</div>

</td>
</tr>
</table>
</div>

<script type="text/javascript" >
var mainTabID = "${mainTabID}";
$(document).ready(function(){
	if($('#cyzjdm').val()=="111"||$('#cyzjdm').val()=="112"||$('#cyzjdm').val()=="335"){
		$("#zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}

});
$(function(){
		
		var flag = document.getElementById("flag").value;
		if(flag=="update"){
			setInputReadonly("xm", true);
			setInputReadonly("csrq", true);
			setInputReadonly("xb", true);
			setInputReadonly("mzdm", true);
			//setInputReadonly("jzd1", true);
			//   sasdsd      setInputReadonly("jzd2", true);
			var gx=$("#ywxtzdm").combobox("getText");
			if(gx=="否"){
				setInputReadonly('fzjg',true);
				setInputReadonly('xtzbh',true);
			}else {
				setInputReadonly('fzjg',false);
				setInputReadonly('xtzbh',false);
			}
			
			
		}else if(flag=="add"){
			//证件号码
			$("#cyzjdm").combobox('setValue', '111');
			$('#zjhm').validatebox({validType:['sfzh']});
		}else {
			setInputReadonly("xm", true);
			setInputReadonly("csrq", true);
			setInputReadonly("xb", true);
			setInputReadonly("mzdm", true);
			setInputReadonly("jzd1", true);
			setInputReadonly("jzd2", true);
			setInputReadonly("fzjg",true);
			setInputReadonly("xtzbh",true);
			setInputReadonly("cyzjdm",true);
			setInputReadonly("zjhm",true);
			setInputReadonly("lxdh",true);
			setInputReadonly("sfddjzdm",true);
			setInputReadonly("yqytdm",true);
			setInputReadonly("wqxwnldm",true);
			setInputReadonly("qxdm",true);
			setInputReadonly("qzdm",true);
			setInputReadonly("qn",true);
			setInputReadonly("tz",true);
			setInputReadonly("tg",true);
			setInputReadonly("msdm",true);
			setInputReadonly("cxdm",true);
			setInputReadonly("ywxtzdm",true);
			setInputReadonly("fzjg",true);
			setInputReadonly("xtzbh",true);
			setInputReadonly("fyzhm",true);
			setInputReadonly("fybm",true);
			setInputReadonly("fyyxqzrq",true);
			setInputReadonly("yqxkzhm",true);
			setInputReadonly("fzrq",true);
			setInputReadonly("yqxkzyxqzrq",true);
			setInputReadonly("lqr",true);
			setInputReadonly("cbryj",true);
			
		}
		initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
		$("#zjhm").bind("blur",function(e){	
			checkZjhm();
		});
		
		$('#jbxxForm').form({  
	        onSubmit:function(){
	            return $(this).form('validate');  
	        },  
	        success:function(data){  
	            var json = $.parseJSON(data);
	            if(json.status != 'success'){
	            	topMessagerAlert(null,json.message);
	            }else{
	            	topMessagerShow(null,json.message);
	            	$("#pk").val(json.saveID); 
	            	executeTabPageMethod(mainTabID, "reloadDg");
	            	closeSelf();
	            }
	        }  
	    });   
		$('#saveBotton').click(function(){
			if ($("#jbxxForm").form('validate')){
				topMessager.confirm('操作确认', '您是否保存犬只信息？',  function(r) {
					if (r) {									
						$('#jbxxForm').submit();
					}
				});
			}
		});
		
		$('#backBotton').click(function(){
			closeSelf();
		});
		$('#resetBotton').click(function(){
			var flag = document.getElementById("flag").value;
		if(flag=="update"){
			$("#lxdh").val("");
			$("#sfddjzdm").combobox("clear");
			$("#yqytdm").combobox("clear");
			$("#wqxwnldm").combobox("clear");
			$("#qxdm").combobox("clear");
			$("#qzdm").combobox("clear");
			$("#msdm").combobox("clear");
			$("#cxdm").combobox("clear");
			$("#ywxtzdm").combobox("clear");
			$("#qn").val("");
			$("#tz").val("");
			$("#tg").val("");
			$("#fzjg").val("");
			$("#xtzbh").val("");
			$("#fyzhm").val("");
			$("#fyyxqzrq").val("");
			$("#yqxkzhm").val("");
			$("#fzrq").val("");
			$("#yqxkzyxqzrq").val("");
			$("#lqr").val("");
			$("#cbryj").val("");
			$("#fybm").val("");
			setInputReadonly("fzjg", false);
			setInputReadonly("xtzbh", false);
		}else{
			document.forms["jbxxForm"].reset();
			setInputReadonly("xm", false);
			setInputReadonly("csrq", false);
			setInputReadonly("xb", false);
			setInputReadonly("mzdm", false);
			setInputReadonly("jzd1", false);
			setInputReadonly("jzd2", false);
			setInputReadonly("fzjg",false);
			setInputReadonly("xtzbh",false);
			$("#cyzjdm").combobox('setValue', '111');
		
		
		}
			
			
		});
	});

/**根据证件类型 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if(newVal==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if(oldVal!=""){
		$("#zjhm").val("");
	}
	if(!newVal){
		return;
	}
	
	if(newVal=="111"||newVal=="112"||newVal=="335"){
		$("#zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	//clearTable();
}

	
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
	
	$("#jbxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data) {
			if (data && data.ryRyjbxxb) {
			$("#xm").val(data.ryRyjbxxb.xm);
			$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
			$("#csrq").val(formatDate(data.ryRyjbxxb.csrq));
			$("#mzdm").combotree("setValue",data.ryRyjbxxb.mzdm);
			$("#jggjdqdm").val(data.ryRyjbxxb.jggjdqdm);
			$("#ryid").val(data.ryRyjbxxb.id);
		//	$("#dz_jzdzxz").val(data.ryRyjbxxb.dz_jzdzxz);
			//$("#dz_jzdzssxdm").val(data.ryRyjbxxb.dz_jzdzssxdm);
			//$("#dz_jzdzdm").val(data.ryRyjbxxb.dz_jzdzdm);
			//$("#dz_jzdzmlpdm").val(data.ryRyjbxxb.dz_jzdmlpdm);
			//$("#dz_jzdzmlpxz").val(data.ryRyjbxxb.dz_jzdmlpxz);
			//$("#jzd1").combobox("setText",data.ryRyjbxxb.dz_jzdmlpxz);
			//$("#jzd2").combobox("setText",data.ryjbxxb.dz_jzdzxz.replace(data.ryjbxxb.dz_jzdmlpxz, ''));
			if(data.ryRyjbxxb.xm != ""){
				setInputReadonly("xm", true);
			}
			if(data.ryRyjbxxb.csrq != ""){
				setInputReadonly("csrq", true);
			}
			if(data.ryRyjbxxb.xbdm != ""){
				setInputReadonly("xb", true);
			}
			if(data.ryRyjbxxb.mzdm != ""){
				setInputReadonly("mzdm", true);
			}
		//	if(data.ryRyjbxxb.dz_jzdzxz != ""){
		//		setInputReadonly("jzd1", true);
		//		setInputReadonly("jzd2", true);	
		//	}
			
		}
			
		},
		complete:function() {
			$("#jbxxLoadDiv").hide();
		}
	});
	
}	
function clearTable(){
	$("#xm").val("");
	$("#xb").combobox("setValue","");
	$("#csrq").val("");
	$("#mzdm").combotree("setValue","");
	$("#jggjdqdm").val("");
	$("#ryid").val("");
	$("#dz_jzdzxz").val("");
	$("#dz_jzdzssxdm").val("");
	$("#dz_jzdzdm").val("");
	$("#dz_jzdzmlpdm").val("");
	$("#dz_jzdzmlpxz").val("");
	$("#jzd1").combobox("setValue","");
	$("#jzd2").combobox("setValue","");
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xb", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("jzd1", false);
	setInputReadonly("jzd2", false);	
	
}
function formatDate(str){
	var newdate;
	if(str.length == 8){
		newdate = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
	}else{
		
	}
	return newdate?newdate:str;
}
function fzgx(){
	var gx=$("#ywxtzdm").combobox("getText");
	if(gx=="是"){
		setInputReadonly('fzjg',false);
		setInputReadonly('xtzbh',false);
		
	}else {
		setInputReadonly('fzjg',true);
		setInputReadonly('xtzbh',true);
	}
}

</script>
</body>
</html>