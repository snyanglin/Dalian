<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>居住证明</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0; width:800px;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>jzzmb/saveJzzmb" id="jbxxForm" name="jbxxForm" method="post">
	    	  <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
	    	  <input type='hidden' name='flag' id="flag" value="${flag}"/>  
			  <input type='hidden' name='ryid' id="ryid" value="${entity.ryid}"/> 
			  <input type='hidden' name='zmkjdwid' id="zmkjdwid" value="${entity.zmkjdwid}"/>  
	    	  <input type='hidden' name='zmkjrid' id="zmkjrid" value="${entity.zmkjrid}"/>   
	    	  <input type='hidden' name='id' id="pk" value="${entity.id}"/>  
	    	  <table border="0" cellpadding="0" cellspacing="10" width="1000px" align="center">
				<tr class="dialogTr"><td width="100%" class="dialogTd" align="right">
				<div id="id_1">   		
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">  
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">证明接收单位：</td>
					<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='zmjsdw' name='zmjsdw' class="easyui-validatebox" style="width:685px;"
						 maxlength="50" value="${entity.zmjsdw}" /></td>
				    	
	    	      </tr>
	    	      <tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right">证明人身份证号：</td>
				    	<td width="30%" class="dialogTd">
				    	<input type="text" name="gmsfhm" id ="zjhm" maxlength='18' value="${entity.gmsfhm}" 
				    	class="easyui-validatebox" data-options="required:true,validType:['sfzh'],tipPosition:'right'"  style="width:200px;float:left;" />
		    	       <div class="lodingimg" id="jbxxLoadDiv"></div>
		    	        </td>
	    	      		<td width="20%" class="dialogTd" align="right">证明人姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="xm" name="xm"
		    	 			value="${entity.xm}" maxlength="20" style="width:200px;" data-options="required:true,validType:['maxLength[20]'],tipPosition:'left'"/>
		    	        </td>
				    	
	    	      </tr>
	    	      <tr class="dialogTr">
	    	      <td width="20%" class="dialogTd" align="right">证明人性别：</td>
						<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
					<td width="20%" class="dialogTd" align="right">证明人出生日期：</td>
					<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" value="${entity.csrq}" class="easyui-validatebox"   style="width:200px;"
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
	    	      </tr>
	    	       <tr class="dialogTr" id="jzdz">
					<td width="20%" class="dialogTd" align="right">证明人居住地址：</td>
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
					<tr class="dialogTr" id="hjdz">
					<td width="20%" class="dialogTd" align="right">证明人户籍地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="hjd1" style="width:400px;" value="${entity.dz_hjdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='dz_hjdzmlpdm' id="dz_hjdzmlpdm" value="${entity.dz_hjdzmlpdm}"/>
						<input type='hidden' name='dz_hjdzmlpxz' id="dz_hjdzmlpxz" value="${entity.dz_hjdzmlpxz}"/></td> 
					<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="hjd2" style="width:200px;" value='${fn:replace(entity.dz_hjdzxz, entity.dz_hjdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_hjdzdm' id='dz_hjdzdm' value="${entity.dz_hjdzdm}" />
				    	<input type='hidden' name='dz_hjdzssxdm' id='dz_hjdzssxdm' value="${entity.dz_hjdzssxdm}" />
				    	<input type='hidden' name='dz_hjdzxz' id='dz_hjdzxz' value="${entity.dz_hjdzxz}" />  
			    	</td>	
					</tr>
	    	    	<tr class="dialogTr" >
	    	    		<td width="20%" class="dialogTd" align="right">实有人口登记时间：</td>
						<td width="30%" class="dialogTd"><input type="text" name="syrkdjsj" id="syrkdjsj" value="${entity.syrkdjsj}" class="easyui-validatebox"   style="width:200px;"
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
						<td width="20%" class="dialogTd" align="right">实有人口登记派出所：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="syrkdjpcs" name="syrkdjpcs"
		    	 			value="${entity.syrkdjpcs}" maxlength="50" style="width:200px;" data-options="required:false,validType:['maxLength[20]'],tipPosition:'left'"/>
		    	        </td>
	    	    	</tr>
	    	    	<tr class="dialogTr" >
	    	    		<td width="20%" class="dialogTd" align="right">实有人口类型：</td>
						<td width="30%" class="dialogTd"><input type="text" name="syrklxdm" id="syrklxdm" value="${entity.syrklxdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_RK_SYRKGLLB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
						<td width="20%" class="dialogTd" align="right">开具日期：</td>
						<td width="30%" class="dialogTd"><input type="text" name="kjrq" id="kjrq" value="${entity.kjrq}" class="easyui-validatebox"   style="width:200px;"
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
	    	    	</tr>
	    	    	<tr class="dialogTr" >
	    	    		<td width="20%" class="dialogTd" align="right">开具人：</td>
						<td width="30%" class="dialogTd"><input  type='text' id="zmkjr" name="zmkjr" class="easyui-validatebox inputreadonly" style="width:200px;" readonly="readonly"
							maxlength="20" value="${entity.zmkjr}"  /></td>	
	    	    	</tr>
	    	    	<tr class="dialogTr" >
	    	    		<td width="20%" class="dialogTd" align="right">开具单位：</td>
						<td width="80%" class="dialogTd" colspan="3"><input  type="text" id="zmkjdw" name="zmkjdw" class="easyui-validatebox inputreadonly" style="width:685px;"  readonly="readonly"
						 maxlength="50" value="${entity.zmkjdw}" /></td>
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
$(function(){
		var flag = document.getElementById("flag").value;
		if(flag=="see"){
			setInputReadonly("xm", true);
			setInputReadonly("csrq", true);
			setInputReadonly("xb", true);
			setInputReadonly("hjd1", true);
			setInputReadonly("hjd2", true);	
			setInputReadonly("jzd1", true);
			setInputReadonly("jzd2", true);	
			setInputReadonly("zmjsdw", true);	
			setInputReadonly("zjhm", true);	
			setInputReadonly("syrkdjsj", true);	
			setInputReadonly("syrkdjpcs", true);	
			setInputReadonly("zmkjdw", true);	
			setInputReadonly("zmkjr", true);	
			setInputReadonly("kjrq", true);	
			setInputReadonly("syrklxdm", true);	
			$("#saveBotton").hide();
			$("#resetBotton").hide();
		}else if(flag=="update"){
		
		}else {
			
		}
		initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
		initAddressSearch('hjd1', {}, 'dz_hjdzmlpdm', 'dz_hjdzmlpxz', 'hjd2', {text:'dz_hjdzxz',dzxzqh:'dz_hjdzssxdm',id:'dz_hjdzdm'}, null, null);
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
				topMessager.confirm('操作确认', '您是否保存居住证明信息？',  function(r) {
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
				 document.forms["jbxxForm"].reset();
			 	 setInputReadonly('xm', false);
				 setInputReadonly('xb', false);
				 setInputReadonly('csrq',false);
				 setInputReadonly('jzd1',false);
			 	 setInputReadonly('jzd2',false);
			 	 setInputReadonly("hjd1", false);
				 setInputReadonly("hjd2", false);	
			
		});
		
	});



	
function checkZjhm() {
	
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
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm=111",
		success:function(data) {
			if (data && data.ryRyjbxxb) {
			$("#xm").val(data.ryRyjbxxb.xm);
			$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
			$("#csrq").val(formatDate(data.ryRyjbxxb.csrq));
			$("#dz_hjdzxz").val(data.ryRyjbxxb.hjd_dzxz);
			$("#ryid").val(data.ryRyjbxxb.id);
			$("#dz_hjdzssxdm").val(data.ryRyjbxxb.hjd_xzqhdm);
			$("#dz_hjdzdm").val(data.ryRyjbxxb.hjd_dzid);
			$("#dz_hjdzmlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
			$("#dz_hjdzmlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
		//	$("#dz_jzdzmlpxz").val(data.ryRyjbxxb.dz_jzdmlpxz);
		//	$("#dz_jzdzmlpdm").val(data.ryRyjbxxb.dz_jzdmlpdm);
		//	$("#dz_jzdzxz").val(data.ryRyjbxxb.dz_jzdzxz);
		//	$("#dz_jzdzssxdm").val(data.ryRyjbxxb.dz_jzdzssxdm);
		//	$("#dz_jzdzdm").val(data.ryRyjbxxb.dz_jzdzdm);
			$("#hjd1").combobox("setValue",data.ryRyjbxxb.hjd_mlpxz);
			$("#hjd2").combobox("setValue",data.ryRyjbxxb.hjd_dzxz.replace(data.ryRyjbxxb.hjd_mlpxz, ''));
		//	$("#jzd1").combobox("setValue",data.ryRyjbxxb.dz_jzdmlpxz);
		//	$("#jzd2").combobox("setValue",data.ryRyjbxxb.dz_jzdzxz.replace(data.ryRyjbxxb.dz_jzdmlpxz, ''));
			if(data.ryRyjbxxb.xm != ""){
				setInputReadonly("xm", true);
			}
			if(data.ryRyjbxxb.csrq != ""){
				setInputReadonly("csrq", true);
			}
			if(data.ryRyjbxxb.xbdm != ""){
				setInputReadonly("xb", true);
			}
			if(data.ryRyjbxxb.hjd_dzxz != ""){
				setInputReadonly("hjd1", true);
				setInputReadonly("hjd2", true);	
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
function formatDate(str){
	var newdate;
	if(str.length == 8){
		newdate = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
	}else{
		
	}
	return newdate?newdate:str;
}


</script>
</body>
</html>