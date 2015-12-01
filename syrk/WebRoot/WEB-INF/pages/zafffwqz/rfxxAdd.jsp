<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人防信息</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>rfxx/saveRfxx2" id="jbxxForm" name="jbxxForm" method="post">
	    	  <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/>
	    	  <input type='hidden' name='deleted' id="deleted" value=""/>
	    	  <input type='hidden' name='inserted' id="inserted" value=""/>
	    	  <input type="hidden" name="flag" id="flag" value="${flag}"/>
	    	  <input type="hidden" name="sydwid" id="sydwid" value="${sydwid}"/>
	    	  
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	  <tr class="dialogTr"><td width="100%" class="dialogTd" align="right">
		    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						
					<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">防范组织形式：</td>
					    	<td colspan="3" width="100%" class="dialogTd">
					    		<input class="easyui-combobox" id="ffzzxsdm" name="ffzzxsdm" value="${entity.ffzzxsdm}" 
					    		style="width:400px;" data-options="required:true,url: contextPath + '/common/dict/D_ZAFF_ZZXS.js',
					    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onSelect:function(newValue,oldValue){changeDiv(newValue,oldValue)}"/>
							</td> 
		    	      </tr>				
					</table>
				</td></tr>
				
				<tr class="dialogTr"><td width="100%" class="dialogTd" align="right">
				<div id="id_1">   		
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">  
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">负责人常用证件：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-combobox" id="ffzrrcyzjdm" name="ffzrrcyzjdm" value="${entity.ffzrrcyzjdm}" 
				    		style="width:400px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:zjhmCheck"/>
						</td> 
						
				    	<td width="20%" class="dialogTd" align="right">负责人证件号码：</td>
				    	<td width="30%" class="dialogTd">
				    	<input type="hidden" id="fffzrid" name ="fffzrid" value="${entity.fffzrid}">
				    	<input type="text" name="ffzrrzjhm" id ="ffzrrzjhm" value="${entity.ffzrrzjhm}" 
				    	class="easyui-validatebox" data-options="required:true,tipPosition:'left'" maxlength="30"  style="width:400px;float:left;" />
		    	       <div class="lodingimg" id="jbxxLoadDiv"></div>
		    	        </td>
	    	      </tr>
	    	      
	    	      <tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right">负责人姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="ffzrrxm" name="ffzrrxm"
		    	 			value="${entity.ffzrrxm}" maxlength="20" style="width:400px;" data-options="required:true,validType:['maxLength[20]'],tipPosition:'right'"/>
		    	        </td>
	    	      
				    	<td width="20%" class="dialogTd" align="right">负责人联系电话：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="ffzrrlxdh" name="ffzrrlxdh" value="${entity.ffzrrlxdh}"
		    	        	style="width: 400px;" data-options="validType:['phone'],tipPosition:'left'"/>
		    	        </td>
	    	      </tr>
	    	      
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">负责人居住地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_ffzrrjzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffzrrjzdzmlpdm' id="dz_ffzrrjzdzmlpdm" value="${entity.dz_ffzrrjzdzmlpdm}"/>
				    	<input type='hidden' name='dz_ffzrrjzdzmlpxz' id="dz_ffzrrjzdzmlpxz" value="${entity.dz_ffzrrjzdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_ffzrrjzdzxz, entity.dz_ffzrrjzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffzrrjzdzdm' id="dz_ffzrrjzdzdm" value="${entity.dz_ffzrrjzdzdm}"/>
				    	<input type='hidden' name='dz_ffzrrjzdzssxdm' id="dz_ffzrrjzdzssxdm" value="${entity.dz_ffzrrjzdzssxdm}"/>
				    	<input type='hidden' name='dz_ffzrrjzdzxz' id="dz_ffzrrjzdzxz" value="${entity.dz_ffzrrjzdzxz}"/>
			    	</td>
	    	      </tr>
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">负责人所属单位：</td>
		    	 		<td width="30%" class="dialogTd" >
		    	 			<input style="width:400px;" maxlength="50" class="easyui-combobox" id="dwBox" value="${entity.fffzrssdwmc }"
		    						data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
							<input type="hidden" name="fffzrssdwid" id="ffrssdwid" value="${entity.fffzrssdwid }" />
							<input type="hidden" name="fffzrssdwmc" id="fffzrssdwmc" value="${entity.fffzrssdwmc }" />
		    	 		</td>
		    	 		
		    	 		 <td width="20%" class="dialogTd" align="right">负责人传真号码：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="ffzrrczhm" name="ffzrrczhm"
		    	 			value="${entity.ffzrrczhm}" maxlength="50" style="width:400px;" data-options="validType:['phone'],tipPosition:'left'"/>
						</td>
	    	      </tr>
	    	     
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">所属单位地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="fzd1" style="width:400px;" value="${entity.dz_ffzrrssdwdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffzrrssdwdzmlpdm' id="dz_ffzrrssdwdzmlpdm" value="${entity.dz_ffzrrssdwdzmlpdm}"/>
				    	<input type='hidden' name='dz_ffzrrssdwdzmlpxz' id="dz_ffzrrssdwdzmlpxz" value="${entity.dz_ffzrrssdwdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="fzd2" style="width:200px;" value='${fn:replace(entity.dz_ffzrrssdwdzxz, entity.dz_ffzrrssdwdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffzrrssdwdzdm' id="dz_ffzrrssdwdzdm" value="${entity.dz_ffzrrssdwdzdm}"/>
				    	<input type='hidden' name='dz_ffzrrssdwdzssxdm' id="dz_ffzrrssdwdzssxdm" value="${entity.dz_ffzrrssdwdzssxdm}"/>
				    	<input type='hidden' name='dz_ffzrrssdwdzxz' id="dz_ffzrrssdwdzxz" value="${entity.dz_ffzrrssdwdzxz}"/>
			    	</td>
	    	      </tr>
	    	      </table>
	    	      </div> 
	    	      </td></tr>
	    	      <!-- (2) -->
	    	      
	    	       <tr class="dialogTr"><td width="100%" class="dialogTd" align="right">
	    	      <div id="id_2">
	    	      <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">组织名称：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="ffzzmc" name="ffzzmc" value="${entity.ffzzmc}"
		    	        	style="width: 400px;" data-options="validType:['maxLength[100]'],tipPosition:'right'"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">组织类别：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="ffzzlb" name="ffzzlb" value="${entity.ffzzlb}" 
				    		style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_ORG_ORGTYPE.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
						</td> 
	    	      </tr>

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">组织联系电话：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="ffzzlxdh" name="ffzzlxdh" value="${entity.ffzzlxdh}"
		    	        	style="width: 400px;" data-options="validType:['naturalNumber','maxLength[50]'],tipPosition:'right'"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">组织传真号码：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="ffzzczhm" name="ffzzczhm"
		    	 			value="${entity.ffzzczhm}" maxlength="50" style="width:400px;" data-options="validType:['maxLength[50]'],tipPosition:'left'"/>
						</td> 
	    	      </tr>
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">组织地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="fzd3" style="width:400px;" value="${entity.dz_ffzzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffzzdzmlpdm' id=dz_ffzzjzdzmlpdm value="${entity.dz_ffzzdzmlpdm}"/>
				    	<input type='hidden' name='dz_ffzzdzmlpxz' id="dz_ffzzjzdzmlpxz" value="${entity.dz_ffzzdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="fzd4" style="width:200px;" value='${fn:replace(entity.dz_ffzzdzxz, entity.dz_ffzzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffzzdzdm' id="dz_ffzzjzdzdm" value="${entity.dz_ffzzdzdm}"/>
				    	<input type='hidden' name='dz_ffzzdzssxdm' id="dz_ffzzjzdzssxdm" value="${entity.dz_ffzzdzssxdm}"/>
				    	<input type='hidden' name='dz_ffzzdzxz' id="dz_ffzzjzdzxz" value="${entity.dz_ffzzdzxz}"/>
			    	</td>
	    	      </tr>
	    	      </table>
			</div>
			 </td></tr>
			 
			 
			<!-- (3) -->
			<tr class="dialogTr"><td width="100%" class="dialogTd" align="right">
			<div id="id_3">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">组建日期：</td>
				<td width="30%" class="dialogTd"><input type="text" name="zjrq" id="zjrq" class="easyui-validatebox " style="width: 400px;" value="${entity.zjrq}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" /></td>
			    
			    <td width="20%" class="dialogTd" align="right">是否治安承包：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="sfzacbdm" name="sfzacbdm" value="${entity.sfzacbdm}" 
				    		style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>					
	    	 </tr>
	    	 
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">是否定时巡逻：</td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="sfdsxldm" name="sfdsxldm" value="${entity.sfdsxldm}" 
				    		style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
				    		
			    <td width="20%" class="dialogTd" align="right">巡逻类型：</td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="xllxdm" name="xllxdm" value="${entity.xllxdm}" 
				    		style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_XLLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>	
	    	 </tr>
	    	 
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">巡逻路线：</td>
				<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="xllx" name="xllx"
		    	 			value="${entity.xllx}" maxlength="100" style="width:400px;" data-options="validType:['maxLength[100]'],tipPosition:'right'"/>
			    <td width="20%" class="dialogTd" align="right">防范方式：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="fffsdm" name="fffsdm" value="${entity.fffsdm}" 
				    		style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_FFFS.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>	
	    	 </tr>
	    	  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">防范部位：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="ffbw" name="ffbw" value="${entity.ffbw}"
		    	        	style="width: 400px;" maxlength="200" data-options="validType:['maxLength[200]'],tipPosition:'right'"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">携带装备：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="xdsb" name="xdsb"
		    	 			value="${entity.xdsb}" maxlength="200" style="width:400px;" data-options="validType:['maxLength[200]'],tipPosition:'left'"/>
						</td> 
	    	   </tr>
	    	   
	    	  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">装备配置情况：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="zbpzqk" name="zbpzqk" value="${entity.zbpzqk}"
		    	        	style="width: 400px;" maxlength="200" data-options="validType:['maxLength[200]'],tipPosition:'right'"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">责任范围：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="zrfw" name="zrfw"
		    	 			value="${entity.zrfw}" maxlength="200" style="width:400px;" data-options="validType:['maxLength[200]'],tipPosition:'left'"/>
						</td> 
	    	   </tr>

	    	  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">地区类别：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-combobox" id="dylbdm" name="dylbdm" value="${entity.dylbdm}" 
				    			style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_DYLB.js',
				    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>	
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">隶属关系：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-combobox" id="lsgxdm" name="lsgxdm" value="${entity.lsgxdm}" 
				    		style="width:400px;" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_LSGX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>	
						</td> 
	    	   </tr>
	    	  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">经费来源：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="jfly" name="jfly" value="${entity.jfly}"
		    	        	style="width: 400px;" maxlength="50" data-options="validType:['maxLength[50]'],tipPosition:'right'"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">作用情况：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="zyqk" name="zyqk"
		    	 			value="${entity.zyqk}" maxlength="200" style="width:400px;" data-options="validType:['maxLength[200]'],tipPosition:'left'"/>
						</td> 
	    	   </tr>
	    	      
	    	    <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="entity_bz" name="bz"  class="easyui-validatebox" rows="3" style="width:100%; height:52px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
						</td>
	    	       </tr>
	    	       </table>
	    	      </div>
	    	     </td></tr>
	    		</table>
		    </div>
		    </form>
		  <!-- 参与人员列表 -->
	    <div id="rfcyxxListDiv" >
	    	<iframe border="0" frameborder="0" scrolling="no" id="rfcyxxList" src="<%=contextPath%>/forward/zafffwqz|rfcyxxList?rfid=${entity.id}" style="width:100%;height:500px"></iframe>
	    </div>
		    
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
	/*if($("#ffzrrcyzjdm").val() == "111" || $("#ffzrrcyzjdm").val() == "112" || $("#ffzrrcyzjdm").val() == "335"){ 
		alert(2);
		$("#ffzrrzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
		
	}else  {
		$("#ffzrrzjhm").validatebox({validType:['maxLength[30]']});
	}*/

});

function changeDiv(newValue,oldValue){
	var val = $("#ffzzxsdm").combobox("getValue");
	
	if(typeof(val)!="undefined" && val!="" && val!=null){
		if(val==1){
			if(!$("#id_2").is(":hidden")){
				setInputReadonly("xllxdm", true);
				setInputReadonly("xllx", true);
				$("#sfdsxldm").combobox("setValue", "");
				$("#id_2").hide();
			}
		}else{
			if($("#id_2").is(":hidden")){
				$("#sfdsxldm").combobox("setValue", "1");
				setInputReadonly("xllxdm", false);
				setInputReadonly("xllx", false);
				$("#id_2").show();
			}
		}
	}
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
	       '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doChjgZx(this,'+index+')">层户</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this, '+index+')">注销</a>&nbsp;';
}

$(function(){
		//证件号码
		
		initDepartmentSearch('dwBox', {glpcsid: ''}, 'ffrssdwid', 'fffzrssdwmc', {});
		
		initAddressSearch('jzd1', {}, 'dz_ffzrrjzdzmlpdm', 'dz_ffzrrjzdzmlpxz', 'jzd2', {text:'dz_ffzrrjzdzxz',dzxzqh:'dz_ffzrrjzdzssxdm',id:'dz_ffzrrjzdzdm'}, null, null);
		
		initAddressSearch('fzd1', {}, 'dz_ffzrrssdwdzmlpdm', 'dz_ffzrrssdwdzmlpxz', 'fzd2', {text:'dz_ffzrrssdwdzxz',dzxzqh:'dz_ffzrrssdwdzssxdm',id:'dz_ffzrrssdwdzdm'}, null, null);
		
		initAddressSearch('fzd3', {}, 'dz_ffzzjzdzmlpdm', 'dz_ffzzjzdzmlpxz', 'fzd4', {text:'dz_ffzzjzdzxz',dzxzqh:'dz_ffzzjzdzssxdm',id:'dz_ffzzjzdzdm'}, null, null);
		var flag = document.getElementById("flag").value;
		if(flag=="add"){
			$("#ffzrrcyzjdm").combobox('setValue', '111');
		}else if(flag=="see"){
			setInputReadonly("ffzzxsdm", true);
			setInputReadonly("ffzrrcyzjdm", true);
			setInputReadonly("ffzrrzjhm", true);
			setInputReadonly("ffzrrxm", true);
			setInputReadonly("ffzrrlxdh", true);
			setInputReadonly("jzd1", true);
			setInputReadonly("jzd2", true);
			setInputReadonly("fzd1", true);
			setInputReadonly("fzd2", true);
			setInputReadonly("fzd3", true);
			setInputReadonly("fzd4", true);
			setInputReadonly("dwBox",true);
			setInputReadonly("ffzrrczhm",true);
			setInputReadonly("ffzzmc",true);
			setInputReadonly("ffzzlb",true);
			setInputReadonly("ffzzlxdh",true);
			setInputReadonly("ffzzczhm",true);
			setInputReadonly("zjrq",true);
			setInputReadonly("sfzacbdm",true);
			setInputReadonly("sfdsxldm",true);
			setInputReadonly("xllxdm",true);
			setInputReadonly("xllx",true);
			setInputReadonly("fffsdm",true);
			setInputReadonly("ffbw",true);
			setInputReadonly("xdsb",true);
			setInputReadonly("zbpzqk",true);
			setInputReadonly("zrfw",true);
			setInputReadonly("dylbdm",true);
			setInputReadonly("lsgxdm",true);
			setInputReadonly("jfly",true);
			setInputReadonly("zyqk",true);
			setInputReadonly("entity_bz",true);
			$("#saveBotton").hide();
			$("#resetBotton").hide();
		}else {
			
		}
		$("#ffzrrzjhm").bind("blur",function(e){	
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
	            	$("#entity_id").val(json.saveID); 
	            	if($("#sydwid").val() == ""){
		            	executeTabPageMethod(mainTabID, "reloadDg");
	            	}else{
	            		executeTabPageMethod(mainTabID, "child_edit_menu_complete", "${infoUrl}");
	            	}
	            	executeTabPageMethod(mainTabID, "location.reload()");
            		closeSelf();
            		locateMainPage(mainTabID);
	            }
	        }  
	    });   
		$('#saveBotton').click(function(){
			topMessager.confirm('操作确认', '您是否保存人防信息？',  function(r) {
				if (r) {					
					setValueDg();					
					$('#jbxxForm').submit();
				}
			});
		});
		
		$('#backBotton').click(function(){
			closeSelf();
			//var obj = window.frames['rfcyxxList'].contentWindow;
			///alert(obj)
			//var obj1 = obj.$('#cydg');
			//alert("dg"+obj1)
			//var inserted = obj1.datagrid('getChanges',"inserted");
			//var deleted = obj1.datagrid('getChanges',"deleted");
			//inserted = JSON.stringify(inserted);
			//deleted = JSON.stringify(deleted);
			
			//alert(inserted);
			//alert(deleted);
		});
		$('#resetBotton').click(function(){
			//document.forms["jbxxForm"].reset();
			//$("#jbxxForm").form("reset");
			
			$("input").val("");
			$("textarea").val("");
			
			$("#ffzrrcyzjdm").combobox('setValue', '111');
			setInputReadonly("xm", false);
			setInputReadonly("xllxdm", false);
			setInputReadonly("xllx", false);
			//$("#ffzrrlxdh").val("");
		});
		
	});

function setValueDg(){
	var obj;
	if(IE){
		obj= window.frames['rfcyxxList'];
	}else{
		obj= window.frames['rfcyxxList'].contentWindow;
	}
	var obj1 = obj.$('#cydg');
	var inserted = obj1.datagrid('getChanges',"inserted");
	var deleted = obj1.datagrid('getChanges',"deleted");
	inserted = JSON.stringify(inserted);
	deleted = JSON.stringify(deleted);
	
	$("#inserted").val(inserted);
	$("#deleted").val(deleted);
}
	
//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#ffzrrzjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue == "112" || newValue == "335"){
		$("#ffzrrzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else {
		$("#ffzrrzjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearValues();
}

function clearValues(){
	 $("#fffzrid").val("");
	 $("#ffzrrxm").val("");
	 $("#ffzrrzjhm").val("");
	 
	 setInputReadonly("ffzrrxm", false);
}
	
function checkZjhm() {
	if (!$("#ffzrrcyzjdm").combo("isValid")){
		return;
	}
	
	if (!$("#ffzrrzjhm").validatebox("isValid")){
		return;
	}
	var _zjhm = $("#ffzrrzjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if($("#ffzrrzjhm").val() == _zjhm){
		return;
	}
	
	$("#jbxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#ffzrrzjhm").val()+"&cyzjdm="+$("#ffzrrcyzjdm").val(),
		success:function(data) {
			if (data && data.ryjbxxb) {
				var fffzrid = $("#fffzrid").val(data.ryjbxxb.id);
				var ffzrrxm = $("#ffzrrxm").val(data.ryjbxxb.xm);
				var fzrzjhm = $("#ffzrrzjhm").val(data.ryjbxxb.zjhm);
				var fzrcyzjdm = $("#ffzrrcyzjdm").combobox('setValue',data.ryjbxxb.cyzjdm);
				$("#dz_ffzrrjzdzxz").val(data.ryjbxxb.dz_jzdzxz);
				$("#dz_ffzrrjzdzssxdm").val(data.ryjbxxb.dz_jzdzssxdm);
				$("#dz_ffzrrjzdzdm").val(data.ryjbxxb.dz_jzdzdm);
				$("#dz_ffzrrjzdzmlpdm").val(data.ryjbxxb.dz_jzdmlpdm);
				$("#dz_ffzrrjzdzmlpxz").val(data.ryjbxxb.dz_jzdmlpxz);
				$("#jzd1").combobox("setText",data.ryjbxxb.dz_jzdmlpxz);
				$("#jzd2").combobox("setText",data.ryjbxxb.dz_jzdzxz.replace(data.ryjbxxb.dz_jzdmlpxz, ''));
				if(data.ryjbxxb.dz_jzdzxz != ""){
					setInputReadonly("jzd1", true);
					setInputReadonly("jzd2", true);	
				}
				if(data.ryjbxxb.cyzjdm==""){
					$("#fzrcyzjdm").combobox('setValue', '111');
				}
				setInputReadonly("ffzrrxm", true);
			}
		},
		complete:function() {		
			$("#jbxxLoadDiv").hide();
			
		}
	});
	
	
}	

function displayDiv(){
	var val = $("#ffzzxsdm").val();
	if(typeof(val)!="undefined" && val!="" && val!=null){
		if(val==1){
			if(!$("#id_2").is(":hidden")){
				setInputReadonly("xllxdm", true);
				setInputReadonly("xllx", true);
				//$("#sfdsxldm").combobox("setValue", "");
				$("#id_2").hide();
			}
		}else{
			if($("#id_2").is(":hidden")){
				$("#sfdsxldm").combobox("setValue", "1");
				setInputReadonly("xllxdm", false);
				setInputReadonly("xllx", false);
				$("#id_2").show();
			}
		}
	}
	
}

displayDiv();
</script>
</body>
</html>