<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>受理线索</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
</head>
<body style="margin-top:20px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form action="" id="jbxxForm" name="jbxxForm" method="post">
	    		  <input type='hidden' name='jbxx.id' id="jbxx_id" value="${ryjbxxb.id}"/>
	    		  <input type='hidden' name='hsrwid' id="hsrwid" value="${hsrwid}"/>
	    		  <input type='hidden' name='messageid' id="messageid" value="${messageid}"/>
	    		  <input type='hidden' name='jzdzid' id="jzdzid" value="${jzdzid}"/>
	    		  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_cyzjdm" name="jbxx.cyzjdm" value="${ryjbxxb.cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="jbxx_zjhm" name='jbxx.zjhm' maxlength="30" value="${ryjbxxb.zjhm}" style="width:200px;float:left;" 
		    	        data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="jbxxLoadDiv"></div></td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">姓名：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="jbxx_xm" name='jbxx.xm' value="${ryjbxxb.xm}" style="width:200px;"  maxlength="20"
		    	        data-options="required:true,charSet:'halfUpper'"/></td>
				    	<td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="jbxx_xbdm" name='jbxx.xbdm' value="${ryjbxxb.xbdm}" style="width:200px;" 
		    	                data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td> 
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jbxx_csrq" name="jbxx.csrq" value="${ryjbxxb.csrq}" style="width:200px;" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">出租车牌号：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="jbxx_wwx" name='jbxx.wwx' value="${ryjbxxb.wwx}" style="width:200px;"  maxlength="40"
		    	        data-options="required:false,charSet:'halfUpper'"/></td>
				    	<td width="20%" class="dialogTd" align="right">从业资格证：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="jbxx_wwm" name='jbxx.wwm' value="${ryjbxxb.wwm}" style="width:200px;"  maxlength="40"
		    	        data-options="required:false,charSet:'halfUpper'"/></td> 
	    	      </tr>
	    		  <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">居住地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="jbxx_jzd1" style="width:380px;" value="${ryjbxxb.dz_jzdmlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='jbxx.dz_jzdmlpdm' id="jbxx_dz_jzdmlpdm" value="${ryjbxxb.dz_jzdmlpdm}"/>
				    	<input type='hidden' name='jbxx.dz_jzdmlpxz' id="jbxx_dz_jzdmlpxz" value="${ryjbxxb.dz_jzdmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jbxx_jzd2" style="width:200px;" value='${fn:replace(ryjbxxb.dz_jzdzxz, ryjbxxb.dz_jzdmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='jbxx.dz_jzdzdm' id="jbxx_dz_jzdzdm" value="${ryjbxxb.dz_jzdzdm}"/>
				    	<input type='hidden' name='jbxx.dz_jzdzssxdm' id="jbxx_dz_jzdzssxdm" value="${ryjbxxb.dz_jzdzssxdm}"/>
				    	<input type='hidden' name='jbxx.dz_jzdzxz' id="jbxx_dz_jzdzxz" value="${ryjbxxb.dz_jzdzxz}"/>
			    	</td>
	    	      </tr>
	    	      
    			</form>
	    		</table>
		    </div>
		</div>
	    </div>
	    </div>

		<div style="height:6px;font-size:1px;"></div>
				    
		<div class="pop_conta" id="divgllb" style="display: none;">
		<div class="pop_contb">
		<div class="pop_contc">
    	   <form action="<%=basePath%>syrkgl/saveSyrk" id="czrkForm" name="czrkForm" method="post">
    	   <input type='hidden' name='czrk.id' id="czrk_id" value="${czrk.id}"/>
		   <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;display: none;" id="czrk" delayParse="true">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">人户状态类型：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combobox-delay" type="text" name="czrk.rhztdm" id="czrk_rhztdm" value="${czrk.rhztdm}"  style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_RHZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get',onChange:rhztdmOnchange"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">服务处所：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input type='hidden' name='czrk.fwcsid' id="czrk_fwcsid" value="${czrk.fwcsid}"/>
			    	<input type='hidden' name='czrk.fwcs' id="czrk_fwcs" value="${czrk.fwcs}"/>
			    	<input class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" name="czrk_fwcs-box" id="czrk_fwcs-box" value="${czrk.fwcs}" maxlength="50"  style="width:595px;" /></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职务：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='czrk.zw' id="czrk_zw" maxlength="20" value="${czrk.zw}" style="width:200px;" data-options="required:false,validType:['maxLength[20]']" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='czrk.lxdh' id="czrk_lxdh" value="${czrk.lxdh}" style="width:200px;" maxlength="18" data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" onblur="checkLxdh('czrk_lxdh','jbxx_id')"/></td>
		    	</tr>
		    	</table>
		    	<div id="czrkJbxxDiv" style="display:none;"></div>
		   </div>
    	   </form>
		   
		    <form action="<%=basePath%>syrkgl/saveSyrk" id="jzrkForm" name="jzrkForm" method="post">
    	    <input type='hidden' name='jzrk.id' id="jzrk_id" value="${jzrk.id}"/>
		    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;display: none;" id="jzrk" delayParse="true">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">寄住类别：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combobox-delay" type="text" name="jzrk.jzlbdm" id="jzrk_jzlbdm" value="${jzrk.jzlbdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_JZLB.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get'"/></td>
		    	</tr> 
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">寄住开始日期：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='jzrk.jzksrq' id='jzrk_jzksrq' value="${jzrk.jzksrq}" style="width:200px;"
			    	data-options="required:true,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">预计离开日期：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' id='jzrk_yjlksj' value="${jzrk.yjlksj}" name='jzrk.yjlksj' style="width:200px;"
			    	data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jzrk_jzksrq\') || \'%y-%M-%d\'}'})"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">服务处所：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input type='hidden' name='jzrk.fwcsid' id="jzrk_fwcsid" value="${jzrk.fwcsid}"/>
			    	<input type='hidden' name='jzrk.fwcs' id="jzrk_fwcs" value="${jzrk.fwcs}"/>
			    	<input class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" name="jzrk.fwcs-box" id="jzrk_fwcs-box" value="${jzrk.fwcs}" maxlength="50" style="width:595px;"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职务：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='jzrk.zw' id="jzrk_zw" maxlength="20" value="${jzrk.zw}" style="width:200px;" data-options="required:false,validType:['maxLength[20]']" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='jzrk.lxdh' id="jzrk_lxdh" maxlength="18" value="${jzrk.lxdh}" style="width:200px;" data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" onblur="checkLxdh('jzrk_lxdh','jbxx_id')"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">承租情况：</td>
			    	<td width="30%" class="dialogTd" ><input class='easyui-combobox-delay' type='text' name='jzrk.fwczqkdm' id="jzrk_fwczqkdm" value="${jzrk.fwczqkdm}" style="width:200px;"
			    	        data-options="required:false,url: contextPath + '/common/dict/D_RK_FWCZQK.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
			    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox-delay' type='text' name='jzrk.yfzgx' id="jzrk_yfzgx" value="${jzrk.yfzgx}" style="width:200px;" 
			    	        data-options="required:false,url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox-delay' type='text' name='jzrk.fzcyzjdm' id="jzrk_fzcyzjdm" value="${jzrk.fzcyzjdm}" style="width:200px;"
			    	        data-options="mode:'remote',valueField:'id',textField:'text',selectOnNavigation:false,method:'post',onChange:jzrk_fzcyzjdm_onchange"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='jzrk.fzcyzjhm' id="jzrk_fzcyzjhm" value="${jzrk.fzcyzjhm}" style="width:200px;float:left;" onblur="jzrk_fzcyzjhm_onblur()"
			    	        data-options="required:false,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="jzrkLoadDiv"></div></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主姓名：</td>
			    	<td width="30%" class="dialogTd"><input type='hidden' name='jzrk.fzryid' id='jzrk_fzryid' value="${jzrk.fzryid}"/><input class='easyui-validatebox-delay input_w2' type='text' name='jzrk.fzxm' id="jzrk_fzxm" value="${jzrk.fzxm}" style="width:200px;"
			    	        data-options="required:false,validType:['maxLength[20]']"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='jzrk.fzlxdh' id="jzrk_fzlxdh" maxlength="18" value="${jzrk.fzlxdh}" style="width:200px;" data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" onblur="checkLxdh('jzrk_fzlxdh','jzrk_fzryid')"/></td>
		    	</tr>
    		    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="jzrk_fzdz1" style="width:380px;" value="${jzrk.dz_fzjzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='jzrk.dz_fzjzdzmlpdm' id="jzrk_dz_fzjzdzmlpdm" value="${jzrk.dz_fzjzdzmlpdm}"/>
				    	<input type='hidden' name='jzrk.dz_fzjzdzmlpxz' id="jzrk_dz_fzjzdzmlpxz" value="${jzrk.dz_fzjzdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzrk_fzdz2" style="width:200px;" value='${fn:replace(jzrk.dz_fzjzdzxz, jzrk.dz_fzjzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='jzrk.dz_fzjzdzdm' id='jzrk_dz_fzjzdzdm' value="${jzrk.dz_fzjzdzdm}" />
				    	<input type='hidden' name='jzrk.dz_fzjzdzssxdm' id='jzrk_dz_fzjzdzssxdm' value="${jzrk.dz_fzjzdzssxdm}" />
				    	<input type='hidden' name='jzrk.dz_fzjzdzxz' id='jzrk_dz_fzjzdzxz' value="${jzrk.dz_fzjzdzxz}" /> 
			    	</td>
	    	    </tr>
		    	</table>
		    	<div id="jzrkJbxxDiv" style="display:none;"></div>
		    </div>
	    	</form>
		    
			<form action="<%=basePath%>syrkgl/saveSyrk" id="ldrkForm" name="ldrkForm" method="post">
    	    <input type='hidden' name='ldrk.id' id="ldrk_id" value="${ldrk.id}"/>
    	    <input type='hidden' name='ldrk.xm' id="ldrk_xm" value="${ldrk.xm}"/>
		    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;display: none;" id="ldrk" delayParse="true">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			     <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">来自地区：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.lzdqdm" id="ldrk_lzdqdm" value="${ldrk.lzdqdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_LZDQ.js',valueField:'id',textField:'text',required:true,selectOnNavigation:false,method:'get'"/></td>
		    	    <td width="20%" class="dialogTd" align="right">来本地时间：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="ldrk.lbdsj" id="ldrk_lbdsj" value="${ldrk.lbdsj}" style="width:200px;" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职业类别：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" name="ldrk.zylbdm" id="ldrk_zylbdm" value="${ldrk.zylbdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_ZYLB.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:280,
								method:'get',editable:true,lines:true"></td>
			    	<td width="20%" class="dialogTd" align="right">暂(居)住事由：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.zjzsydm" id="ldrk_zjzsydm" value="${ldrk.zjzsydm}"  style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_ZJZSY.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get',tipPosition:'left'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">服务处所：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input type='hidden' name='ldrk.fwcsid' id="ldrk_fwcsid" value="${ldrk.fwcsid}"/>
			    	<input type='hidden' name='ldrk.fwcs' id="ldrk_fwcs" value="${ldrk.fwcs}"/>
			    	<input class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" name="ldrk.fwcs-box" id="ldrk_fwcs-box" value="${ldrk.fwcs}" maxlength="50" style="width:595px;"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职务：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="ldrk.zw" id="ldrk_zw" value="${ldrk.zw}" style="width:200px;" maxlength="20"/></td>
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="ldrk.lxdh" id="ldrk_lxdh" maxlength="18" value="${ldrk.lxdh}" style="width:200px;" data-options="validType:['phone'],tipPosition:'left'" onblur="checkLxdh('ldrk_lxdh','jbxx_id')"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">户口性质分类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.hkxzfldm" id="ldrk_hkxzfldm" value="${ldrk.hkxzfldm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_HKXZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
			    	<td width="20%" class="dialogTd" align="right">暂(居)住处所分类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.zjzcsfldm" id="ldrk_zjzcsfldm" value="${ldrk.zjzcsfldm}"  style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_ZJZCSFL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.czryfzgxdm" id="ldrk_czryfzgxdm" value="${ldrk.czryfzgxdm}" style="width:200px;"
			    	        data-options="required:false,url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"></td>
			    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.fwczqkdm" id="ldrk_fwczqkdm" value="${ldrk.fwczqkdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_FWCZQK.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
		    	</tr>
		    	<tr class="dialogTr"> 
			    	<td width="20%" class="dialogTd" align="right">房主常用证件种类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="ldrk.fzcyzjdm" id="ldrk_fzcyzjdm" value="${ldrk.fzcyzjdm}" style="width:200px;"
						data-options="mode:'remote',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'post',onChange:ldrk_fzcyzjdm_onchange"/></td>
			    	<td width="20%" class="dialogTd" align="right">房主常用证件号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay " type="text" name="ldrk.fzcyzjhm" id="ldrk_fzcyzjhm" maxlength="18"  value="${ldrk.fzcyzjhm}" onblur="ldrk_fzcyzjhm_onblur()"
			    			data-options="mode:'remote',validType:['sfzh'],required:false,tipPosition:'left',charSet:'halfUpper',tipPosition:'left'" style="width:200px;float:left;" /><div class="lodingimg" id="ldrkLoadDiv"></div></td>
		    	</tr>
		        <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">房主姓名：</td>
			    	<td width="30%" class="dialogTd"><input type='hidden' name='ldrk.fzryid' id='ldrk_fzryid' value="${ldrk.fzryid}"/><input class="easyui-validatebox-delay" type="text" name="ldrk.fzxm" id="ldrk_fzxm" value="${ldrk.fzxm}" maxlength="20" style="width:200px;" /></td>
			    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='ldrk.fzlxdh' id="ldrk_fzlxdh" maxlength="18" value="${ldrk.fzlxdh}" style="width:200px;" data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" onblur="checkLxdh('ldrk_fzlxdh','ldrk_fzryid')"/></td>
			    </tr>
    		    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="ldrk_fzdz1" style="width:380px;" value="${ldrk.dz_fzjzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='ldrk.dz_fzjzdzmlpdm' id="ldrk_dz_fzjzdzmlpdm" value="${ldrk.dz_fzjzdzmlpdm}"/>
				    	<input type='hidden' name='ldrk.dz_fzjzdzmlpxz' id="ldrk_dz_fzjzdzmlpxz" value="${ldrk.dz_fzjzdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="ldrk_fzdz2" style="width:200px;" value='${fn:replace(ldrk.dz_fzjzdzxz, ldrk.dz_fzjzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='ldrk.dz_fzjzdzdm' id='ldrk_dz_fzjzdzdm' value="${ldrk.dz_fzjzdzdm}" />
				    	<input type='hidden' name='ldrk.dz_fzjzdzssxdm' id='ldrk_dz_fzjzdzssxdm' value="${ldrk.dz_fzjzdzssxdm}" />
				    	<input type='hidden' name='ldrk.dz_fzjzdzxz' id='ldrk_dz_fzjzdzxz' value="${ldrk.dz_fzjzdzxz}" /> 
			    	</td>
	    	    </tr>
		    	</table>
		    	<div id="ldrkJbxxDiv" style="display:none;"></div>
		    </div>
			</form>
		    
			<form action="<%=basePath%>syrkgl/saveSyrk" id="jwryForm" name="jwryForm" method="post">
    	    <input type='hidden' name='jwry.id' id="jwry_id" value="${jwry.id}"/>
		    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;display: none;" id="jwry" delayParse="true">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			     <tr class="dialogTr">
        		    <td width="20%" class="dialogTd" align="right">境外人员身份证号：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox-delay " type="text" name="jwry.sfzh" id="jwry_sfzh" maxlength="30" value="${jwry.sfzh}" 
			    	data-options="required:false,charSet:'halfUpper',validType:['letterOrNum'],tipPosition:'left'" style="width:200px;" /></td>
		    	</tr>
			   <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">签证/注(居留许可)种类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_qzjlxkzldm" name="jwry.qzjlxkzldm" value="${jwry.qzjlxkzldm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_QZ.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	<td width="20%" class="dialogTd" align="right">签证/注(居留许可)号：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay " type="text" name="jwry.qzjlxkh" id="jwry_qzjlxkh" maxlength="30"  value="${jwry.qzjlxkh}" data-options="required:false,tipPosition:'left'" style="width:200px;" /></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">签证签发机关：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="jwry.qzjlxkqfjgmc" id="jwry_qzjlxkqfjgmc" value="${jwry.qzjlxkqfjgmc}" style="width:200px;" maxlength="50"/></td>
			    	<td width="20%" class="dialogTd" align="right">入境日期：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_rjrq" name="jwry.rjrq" value="${jwry.rjrq}" style="width:200px;" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">签证有效期起始日期：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' value="${jwry.qzyxqqsrq}" type='text' id='jwry_qzyxqqsrq' name='jwry.qzyxqqsrq' style="width:200px;"
			    	data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'jwry_rjrq\')}'})"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">签证有效期截止日期：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' id='jwry_qzyxqjzrq' value="${jwry.qzyxqjzrq}" name='jwry.qzyxqjzrq' style="width:200px;"
			    	data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_qzyxqqsrq\') || \'%y-%M-%d\'}'})"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">入境口岸：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_rjkadm" name="jwry.rjka" value="${jwry.rjka}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_RJKA.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	<td width="20%" class="dialogTd" align="right">停留有效日期：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_tlyxrq" name="jwry.tlyxrq" value="${jwry.tlyxrq}" style="width:200px;" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">停留事由：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_tlsydm" name="jwry.tlsydm" value="${jwry.tlsydm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_TLSY.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	<td width="20%" class="dialogTd" align="right">来华事由：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_lhsydm" name="jwry.lhsydm" value="${jwry.lhsydm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_LHSY.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">境外人员身份：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="jwry_jwrysfdm" name="jwry.jwrysfdm" value="${jwry.jwrysfdm}" style="width:200px;"
						 data-options="url: contextPath + '/common/dict/D_RK_JWRYSFDM.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,
								method:'get',editable:true,lines:true"></td>
			    	<td width="20%" class="dialogTd" align="right">住房种类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_zfzldm" name="jwry.zfzldm" value="${jwry.zfzldm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_ZFZL.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">入住日期：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' value="${jwry.rzrq}" type='text' id='jwry_ddrq' name='jwry.rzrq' style="width:200px;"
			    	data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_rjrq\')}'})"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">拟离开日期：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' id='jwry_nlkrq' value="${jwry.nlkrq}" name='jwry.nlkrq' style="width:200px;"
			    	data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_ddrq\') || \'%y-%M-%d\'}'})"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">本人联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_brlxdh" name="jwry.brlxdh" maxlength="18" value="${jwry.brlxdh}" style="width:200px;" data-options="validType:['phone']" onblur="checkLxdh('jwry_brlxdh','jbxx_id')"/></td>
		    	    <td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
		    	<tr class="dialogTr">
		    	    <td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_fwczqkdm" name="jwry.fwczqkdm" value="${jwry.fwczqkdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_FWCZQK.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_yfzgx" name="jwry.yfzgx" value="${jwry.yfzgx}" style="width:200px;"
			    	        data-options="required:false,url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主常用证件种类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" name="jwry.fzcyzjdm" id="jwry_fzcyzjdm" value="${jwry.fzcyzjdm}" style="width:200px;"
						data-options="mode:'remote',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'post',onChange:jwry_fzcyzjdm_onchange"/></td>
			    	<td width="20%" class="dialogTd" align="right">房主常用证件号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay " type="text" name="jwry.fzcyzjhm" id="jwry_fzcyzjhm" maxlength="18"  value="${jwry.fzcyzjhm}" onblur="jwry_fzcyzjhm_onblur()"
			    			 data-options="validType:['sfzh'],required:false,tipPosition:'left',charSet:'halfUpper'" style="width:200px;float:left;" /><div class="lodingimg" id="jwryLoadDiv"></div></td>
		    	</tr>
		        <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">房主姓名：</td>
			    	<td width="30%" class="dialogTd"><input type='hidden' name='jwry.fzryid' id='jwry_fzryid' value="${jwry.fzryid}"/><input class="easyui-validatebox-delay" type="text" name="jwry.fzxm" id="jwry_fzxm" value="${jwry.fzxm}" maxlength="20" style="width:200px;" /></td>
			    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_fzlxdh" name="jwry.fzlxdh" maxlength="18" value="${jwry.fzlxdh}" style="width:200px;" data-options="validType:['phone'],tipPosition:'left'" onblur="checkLxdh('jwry_fzlxdh','jwry_fzryid')"/></td>
			    </tr>
    		    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="jwry_fzdz1" style="width:380px;" value="${jwry.dz_fzjzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='jwry.dz_fzjzdzmlpdm' id="jwry_dz_fzjzdzmlpdm" value="${jwry.dz_fzjzdzmlpdm}"/>
				    	<input type='hidden' name='jwry.dz_fzjzdzmlpxz' id="jwry_dz_fzjzdzmlpxz" value="${jwry.dz_fzjzdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jwry_fzdz2" style="width:200px;" value='${fn:replace(jwry.dz_fzjzdzxz, jwry.dz_fzjzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='jwry.dz_fzjzdzdm' id='jwry_dz_fzjzdzdm' value="${jwry.dz_fzjzdzdm}" />
				    	<input type='hidden' name='jwry.dz_fzjzdzssxdm' id='jwry_dz_fzjzdzssxdm' value="${jwry.dz_fzjzdzssxdm}" />
				    	<input type='hidden' name='jwry.dz_fzjzdzxz' id='jwry_dz_fzjzdzxz' value="${jwry.dz_fzjzdzxz}" /> 
			    	</td>
	    	    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">工作许可登记：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="jwry.gzxkdj" id="jwry_gzxkdj" value="${jwry.gzxkdj}" maxlength="30" style="width:200px;" /></td>
			    	<td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">工作单位名称：</td>
			    	<input class="easyui-validatebox-delay" type="hidden" name="jwry.gzdwid" id="jwry_gzdwid" value="${jwry.gzdwid}" />
			    	<input class="easyui-validatebox-delay" type="hidden" name="jwry.gzdwmc" id="jwry_gzdwmc" value="${jwry.gzdwmc}" />
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" name="jwry.gzdwmc-box" id="jwry_gzdwmc-box" value="${jwry.gzdwmc}" maxlength="50" style="width:200px;" /></td>
			    	<td width="20%" class="dialogTd" align="right">工作单位联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_gzdwlxdh" name="jwry.gzdwlxdh" maxlength="18" value="${jwry.gzdwlxdh}" style="width:200px;" data-options="validType:['phone'],tipPosition:'left'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">留宿单位名称：</td>
			    	<input class="easyui-validatebox-delay" type="hidden" name="jwry.lsdwid" id="jwry_lsdwid" value="${jwry.lsdwid}" />
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_lsdwmc" name="jwry.lsdwmc" value="${jwry.lsdwmc}" maxlength="50" style="width:200px;" /></td>
		    	    <td width="20%" class="dialogTd" align="right">留宿单位联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_lsdwlxdh" name="jwry.lsdwlxdh" maxlength="18" value="${jwry.lsdwlxdh}" style="width:200px;" data-options="validType:['phone'],tipPosition:'left'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">接待单位名称：</td>
			    	<input class="easyui-validatebox-delay" type="hidden" name="jwry.jddwid" id="jwry_jddwid" value="${jwry.jddwid}" />
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_jddwmc" name="jwry.jddwmc" value="${jwry.jddwmc}" maxlength="50" style="width:200px;" /></td>
		    	    <td width="20%" class="dialogTd" align="right">接待单位联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="jwry_jddwlxdh" name="jwry.jddwlxdh" maxlength="18" value="${jwry.jddwlxdh}" style="width:200px;" data-options="validType:['phone'],tipPosition:'left'"/></td>
		    	</tr>
		       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">何时来本市：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' value="${jwry.hslbs}" type='text' id='jwry_hslbs' name='jwry.hslbs' style="width:200px;"
			    	data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">何因来本市：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" maxlength="100" type="text" id="jwry_hylbsdm" name="jwry.hylbs" value="${jwry.hylbs}" style="width:200px;"
						data-options="valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">何处来地区是否国外：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox' value="${jwry.hcldqsfgwdm}" type='text' id='jwry_hcldqsfgwdm' name='jwry.hcldqsfgwdm' style="width:200px;"
			    	     data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:jwry_hcldqsfgwdmOnchange"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">来自地国家(地区)代码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_lzdgjdqdm" name="jwry.lzdgjdqdm" value="${jwry.lzdgjdqdm}" style="width:200px;"
						 data-options="mode:'remote',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'post',required:false,tipPosition:'left'"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">来自地省市县：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox-delay' value="${jwry.lzdssxdm}" type='text' id='jwry_lzdssxdm' name='jwry.lzdssxdm' style="width:200px;"
		    	                data-options="mode:'remote',dataFilter:'',required:false,method:'post',valueField:'id',textField:'text',selectOnNavigation:false" /></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">来自地详址：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="jwry.lzdxz" id='jwry_lzdxz' value="${jwry.lzdxz}" maxlength="100" style="width:200px;" /></td>
		    	</tr>
		        <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">何处去地区是否国外：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox' value="${jwry.hcqdqsfgwdm}" type='text' id='jwry_hcqdqsfgwdm' name='jwry.hcqdqsfgwdm' style="width:200px;"
			    	     data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:jwry_hcqdqsfgwdmOnchange"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">去往地国家(地区)：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jwry_qwdgjdqdm" name="jwry.qwdgjdqdm" value="${jwry.qwdgjdqdm}" style="width:200px;"
						 data-options="mode:'remote',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'post',required:false,tipPosition:'left'"></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">去往地省市县：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox-delay' value="${jwry.qwdssxdm}" type='text' id='jwry_qwdssxdm' name='jwry.qwdssxdm' style="width:200px;"
			    	    data-options="mode:'remote',dataFilter:'',required:false,method:'post',valueField:'id',textField:'text',selectOnNavigation:false" /></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">去往地详址：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="jwry.qwdxz" id="jwry_qwdxz" value="${jwry.qwdxz}" maxlength="100" style="width:200px;" /></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">是否非法入境：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox-delay' value="${jwry.sfffrjdm}" type='text' id='jwry_sfffrjdm' name='jwry.sfffrjdm' style="width:200px;"
			    	     data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">是否非法居留：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_sfffjldm" name="jwry.sfffjldm" value="${jwry.sfffjldm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">是否非法就业：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-combobox-delay' value="${jwry.sfffjy}" type='text' id='jwry_sfffjy' name='jwry.sfffjy' style="width:200px;"
			    	     data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/></td>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
		     	</table>
	    		<div id="jwryJbxxDiv" style="display:none;"></div>
		    </div>
		    </form>
		
			<form action="<%=basePath%>syrkgl/saveSyrk" id="wlczrkForm" name="wlczrkForm" method="post">
    	    <input type='hidden' name='wlczrk.id' id="wlczrk_id" value="${wlczrk.id}"/>
		    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;display: none;" id="wlczrk" delayParse="true">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			     <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">未落户原因：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combobox-delay" type="text" id="wlczrk_wlhyydm" name="wlczrk.wlhyydm" value="${wlczrk.wlhyydm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_WLHYY.js',valueField:'id',textField:'text',required:true,selectOnNavigation:false,method:'get'"/></td>
		    	</tr>
			   <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">其它常用证件：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlczrk_qtcyzjdm" name="wlczrk.qtcyzjdm" value="${wlczrk.qtcyzjdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:wlczrk_qtcyzjdm_onchange"/></td>
			    	<td width="20%" class="dialogTd" align="right">其它证件号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay " type="text" name="wlczrk.qtzjhm" id="wlczrk_qtzjhm" maxlength="18"  value="${wlczrk.qtzjhm}" 
			    		data-options="validType:['sfzh'],required:false,tipPosition:'left',charSet:'halfUpper'" style="width:200px;float:left;"  style="width:200px;" /></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">服务处所：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input type='hidden' name='wlczrk.fwcsid' id="wlczrk_fwcsid" value="${wlczrk.fwcsid}"/>
			    	<input type='hidden' name='wlczrk.fwcs' id="wlczrk_fwcs" value="${wlczrk.fwcs}"/>
			    	<input class="easyui-combobox" type="text" id="wlczrk_fwcs-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" name="wlczrk.fwcs-box" value="${wlczrk.fwcs}" maxlength="50" style="width:595px;"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职务：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" name="wlczrk.zw" id="wlczrk_zw" value="${wlczrk.zw}" style="width:200px;" maxlength="20"/></td>
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay" type="text" id="wlczrk_lxdh" name="wlczrk.lxdh" value="${wlczrk.lxdh}" style="width:200px;" data-options="validType:['phone'],tipPosition:'left'" onblur="checkLxdh('jwry_brlxdh','jbxx_id')"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlczrk_yfzgx" name="wlczrk.yfzgx" value="${wlczrk.yfzgx}" style="width:200px;"
			    	        data-options="required:false,url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"></td>
			    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlczrk_fwczqkdm" name="wlczrk.fwczqkdm" value="${wlczrk.fwczqkdm}" style="width:200px;"
						data-options="url: contextPath + '/common/dict/D_RK_FWCZQK.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主常用证件种类：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlczrk_fzcyzjdm" name="wlczrk.fzcyzjdm" value="${wlczrk.fzcyzjdm}" style="width:200px;"
						data-options="mode:'remote',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'post',onChange:wlczrk_fzcyzjdm_onchange"/></td>
			    	<td width="20%" class="dialogTd" align="right">房主常用证件号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox-delay " type="text" name="wlczrk.fzcyzjhm" id="wlczrk_fzcyzjhm" maxlength="18"  value="${wlczrk.fzcyzjhm}" onblur="wlczrk_fzcyzjhm_onblur()"
			    			data-options="validType:['sfzh'],required:false,tipPosition:'left'" style="width:200px;float:left;" /><div class="lodingimg" id="wlczrkLoadDiv"></div></td>
		    	</tr>
		        <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">房主姓名：</td>
			    	<td width="30%" class="dialogTd"><input type='hidden' name='wlczrk.fzryid' id='wlczrk_fzryid' value="${wlczrk.fzryid}"/><input class="easyui-validatebox-delay" type="text" name="wlczrk.fzxm" id="wlczrk_fzxm" value="${wlczrk.fzxm}" maxlength="20" style="width:200px;" /></td>
			    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class='easyui-validatebox-delay' type='text' name='wlczrk.fzlxdh' id="wlczrk_fzlxdh" maxlength="18" value="${wlczrk.fzlxdh}" style="width:200px;" data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" onblur="checkLxdh('wlczrk_fzlxdh','wlczrk_fzryid')"/></td>
			    </tr>
    		    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="wlczrk_fzdz1" style="width:380px;" value="${wlczrk.dz_fzjzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='wlczrk.dz_fzjzdzmlpdm' id="wlczrk_dz_fzjzdzmlpdm" value="${wlczrk.dz_fzjzdzmlpdm}"/>
				    	<input type='hidden' name='wlczrk.dz_fzjzdzmlpxz' id="wlczrk_dz_fzjzdzmlpxz" value="${wlczrk.dz_fzjzdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="wlczrk_fzdz2" style="width:200px;" value='${fn:replace(wlczrk.dz_fzjzdzxz, wlczrk.dz_fzjzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='wlczrk.dz_fzjzdzdm' id='wlczrk_dz_fzjzdzdm' value="${wlczrk.dz_fzjzdzdm}" />
				    	<input type='hidden' name='wlczrk.dz_fzjzdzssxdm' id='wlczrk_dz_fzjzdzssxdm' value="${wlczrk.dz_fzjzdzssxdm}" />
				    	<input type='hidden' name='wlczrk.dz_fzjzdzxz' id='wlczrk_dz_fzjzdzxz' value="${wlczrk.dz_fzjzdzxz}" /> 
			    	</td>
	    	    </tr>
		     	</table>
	    		<div id="wlczrkJbxxDiv" style="display:none;"></div>
		    </div>
		 	</form>
		    
		</div>
		</div>
		</div>
		
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:none;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
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

    	</td></tr></table>
</div>
</body>

<script type="text/javascript" >

initComboBox('jbxx_jgssxdm', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 
initComboBox('jwry_qwdssxdm', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 
initComboBox('jwry_qwdgjdqdm', contextPath + '/common/dict/D_BZ_GJDQLIST.js'); 
initComboBox('jwry_lzdgjdqdm', contextPath + '/common/dict/D_BZ_GJDQLIST.js'); 
initComboBox('jwry_lzdssxdm', contextPath + '/common/dict/D_BZ_GJDQLIST.js'); 
initComboBox('jwry_fzcyzjdm', contextPath + '/common/dict/D_BZ_CYZJ.js'); 
initComboBox('ldrk_fzcyzjdm', contextPath + '/common/dict/D_BZ_CYZJ.js'); 
initComboBox('wlczrk_fzcyzjdm', contextPath + '/common/dict/D_BZ_CYZJ.js');
initComboBox('jzrk_fzcyzjdm', contextPath + '/common/dict/D_BZ_CYZJ.js');



var _jg = "XZQH";
var autoRklb = "";
var autoGllb = true;
var districtXzqh = "${districtXzqh}";
var czrkNO = "0";
var jzrkNO = "0";
var ldrkNO = "0";
var jwryNO = "0";
var wlczrkNO = "0";

$(document).ready(function(){
	//服务处所选择
	initDepartmentSearch('jwry_gzdwmc-box', {glpcsid: ''}, 'jwry_gzdwid', 'jwry_gzdwmc', {});
	
	initDepartmentSearch('czrk_fwcs-box', {glpcsid: ''}, 'czrk_fwcsid', 'czrk_fwcs', {});
	initDepartmentSearch('jzrk_fwcs-box', {glpcsid: ''}, 'jzrk_fwcsid', 'jzrk_fwcs', {});
	initDepartmentSearch('ldrk_fwcs-box', {glpcsid: ''}, 'ldrk_fwcsid', 'ldrk_fwcs', {});
	initDepartmentSearch('wlczrk_fwcs-box', {glpcsid: ''}, 'wlczrk_fwcsid', 'wlczrk_fwcs', {});
	$("#jbxx_cyzjdm").combobox({onChange:cyzjdmOnchange});
	if ($("#jbxx_cyzjdm").combobox('getValues') == "") {
		$("#jbxx_cyzjdm").combobox('setValue', '111'); // 黑认为居民身份证
		$("#jbxx_zjhm").focus();
	}
	if ($("#jbxx_zjhm").val() != "") {
		$("#jbxx_zjhm").attr("zjhm", $("#jbxx_zjhm").val());
	}
	if ($("#syrkgllbdm").val() != "") {
		setInputReadonly('syrkgllbdm', false);
		autoRklb = $("#syrkgllbdm").val();
		divChange($("#syrkgllbdm").val(), "");
		autoGllb = false;
	}
	else {
		setInputReadonly('syrkgllbdm',true);
		$("#divgllb").hide();
		$("#saveDiv").hide();
	}
	$("#jbxx_zjhm").bind("blur",function(e){	
		checkZjhm();
	});
	
	$("#saveBotton").bind("click",function() {
		//alert(document.getElementById("czrk_fwcs").value);
		//alert(document.getElementById("ldrk_fwcs").value);
		//alert(document.getElementById("jzrk_fwcs").value);
		//alert(document.getElementById("jwry_gzdwmc").value);
		//alert(document.getElementById("wlczrk_fwcs").value);
		var gllbdm = $("#syrkgllbdm").val(); 
		if (gllbdm == "01") {
			if ($("#czrk_rhztdm").val() == "1") {
				if ($("#jbxx_dz_hjdzdm").val() == "") {
					topMessager.alert('', '请先选择有效的户籍地！');
					var comboText = $('#jbxx_hjd1').next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
				if ($("#jbxx_dz_jzdzdm").val() == "") {
					topMessager.alert('', '请先选择有效的居住地！');
					var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
				if ($("#jbxx_dz_hjdzdm").val() != $("#jbxx_dz_jzdzdm").val()) {
					topMessager.alert('', '人户一致时户籍地应与居住地一致，请确认！');
					var comboText = $('#jbxx_hjd1').next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
			}
		}
		else {
			if ($("#jbxx_dz_jzdzdm").val() == "") {
				topMessager.alert('', '请先选择有效的居住地！');
				var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
		}
		
		//常口唯一校验
		if('01' == $('#syrkgllbdm').val()){//所选人口类型为'常住人口 '
			//校验证件号码是否已录入 begin
			var ifExist = false;
			$.ajax({
				type:"POST",
				url:"<%=basePath%>syrkgl/getCountByColMultiTable",
				dataType:"json",
				async:false,
				data:{colMap:'{\'colList\':['
					//+'{\'resultColValue\':\'01\', \'resultColName\':\'lbdm\', \'tableName\':\'rk_czrkxxb\', \'colName\':\'gmsfhm\', \'colValue\':\''+$("#jbxx_zjhm").val()+'\'},'
					+'{\'resultColValue\':\'01\', \'resultColName\':\'lbdm\', \'tableName\':\'rk_ryjzdzzb\', \'colName\':\'ryid\', \'colValue\':\''+$("#jbxx_id").val()+'\', \'colName1\':\'syrkgllbdm\', \'colValue1\':\''+ $('#syrkgllbdm').val()+'\'},'
					//+'{\'resultColValue\':\'02\', \'resultColName\':\'lbdm\', \'tableName\':\'rk_jzrkxxb\', \'colName\':\'gmsfhm\', \'colValue\':\''+$("#jbxx_zjhm").val()+'\'},'
					//+'{\'resultColValue\':\'03\', \'resultColName\':\'lbdm\', \'tableName\':\'rk_ldrkxxb\', \'colName\':\'gmsfhm\', \'colValue\':\''+$("#jbxx_zjhm").val()+'\'},'
					//+'{\'resultColValue\':\'04\', \'resultColName\':\'lbdm\', \'tableName\':\'rk_jwryxxb\', \'colName\':\'zjhm\', \'colValue\':\''+$("#jbxx_zjhm").val()+'\'},'
					//+'{\'resultColValue\':\'05\', \'resultColName\':\'lbdm\', \'tableName\':\'rk_wlczrkxxb\', \'colName\':\'gmsfhm\', \'colValue\':\''+$("#jbxx_zjhm").val()+'\'}'
					+']}'
				},
				success:function(data){
					var message = "";
					if(data && data.countList){
						for(i in data.countList){
							if(data.countList[i]['COUNT'] > 0){
								ifExist = true;
								var lb;
								if('01' == data.countList[i].LBDM){
									lb = "常住人口";
								}else if('02' == data.countList[i].LBDM){
									lb = "寄住人口";
								}else if('03' == data.countList[i].LBDM){
									lb = "流动人口";
								}else if('04' == data.countList[i].LBDM){
									lb = "境外人员";
								}else if('05' == data.countList[i].LBDM){
									lb = "未落常住人口";
								}
								$.messager.alert("提示","该证件号已经录入为"+lb+",不能重复录入,请重新输入","",
								function(){
									$("#jbxx_zjhm").val('');
									$("#jbxx_zjhm").focus();
								});
								ifExist = true;
									}
								}
					}
				}
			});
			if(ifExist){
				return false;
			}
			//end
		}
		
		if ($("#jbxxForm").form('validate')) {
			var gllbdm = $("#syrkgllbdm").val();
			var formID = "";
			if (gllbdm == "01") {
				formID = "czrk";
			} 
			else if (gllbdm == "02") {
				formID = "jzrk";
			}
			else if (gllbdm == "03") {
				formID = "ldrk";
			}
			else if (gllbdm == "04") {
				formID = "jwry";
			}
			else if (gllbdm == "05") {
				formID = "wlczrk";
			}
			var formObject = $("#"+ formID +"Form");
			if (formObject.form('validate')) { // 表单的验证
				if (gllbdm == "02")	{
					if ($("#jzrk_jzksrq").val() != "" && $("#jzrk_yjlksj").val() != "" && $("#jzrk_jzksrq").val() >  $("#jzrk_yjlksj").val()) {
						topMessager.alert('', '预计离开时间必须大于寄住开始日期，请重新输入！');
						$("#jzrk_jzksrq").focus();
						return;
					}
				}
				if (gllbdm == "04")	{
					if ($("#jwry_qzyxqqsrq").val() != "" && $("#jwry_rjrq").val() != "" && $("#jwry_qzyxqqsrq").val() > $("#jwry_rjrq").val()) {
						topMessager.alert('', '签证有效期起始日期必须小于入境日期，请重新输入！');
						$("#jwry_rjrq").focus();
						return;
					}
					if ($("#jwry_qzyxqqsrq").val() != "" && $("#jwry_qzyxqjzrq").val() != "" && $("#jwry_qzyxqqsrq").val() >= $("#jwry_qzyxqjzrq").val()) {
						topMessager.alert('', '签证有效期截止日期必须大于起始日期，请重新输入！');
						$("#jwry_qzyxqqsrq").focus();
						return;
					}
					if ($("#jwry_qzyxqjzrq").val() != "" && $("#jwry_qzyxqjzrq").val() < systemDate) {
						topMessager.alert('', '签证有效期截止日期必须大于当前日期，请重新输入！');
						$("#jwry_qzyxqjzrq").focus();
						return;
					}
					if ($("#jwry_rjrq").val() != "" && $("#jwry_ddrq").val() != "" && $("#jwry_ddrq").val() < $("#jwry_rjrq").val()) {
						topMessager.alert('', '入住日期必须大于等于入境日期，请重新输入！');
						$("#jwry_ddrq").focus();
						return;
					}
					if ($("#jwry_ddrq").val() != "" && $("#jwry_nlkrq").val() != "" && $("#jwry_ddrq").val() > $("#jwry_nlkrq").val()) {
						topMessager.alert('', '拟离开日期必须大于入住日期，请重新输入！');
						$("#jwry_ddrq").focus();
						return;
					}
				}
				if (gllbdm == "05")	{//未落常住人口
					if($("#jbxx_zjhm").val() == $("#wlczrk_fzcyzjhm").val()){
						topMessager.alert('', '房主不能为本人，请重新输入！');
						$("#wlczrk_fzcyzjhm").focus();
						return;
					}
				}
				var bottonObject = this;
				if (buttonDisabled(bottonObject) == false) {
					return false;
				}	
				topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
					if (r) {
						var sb = new StringBuffer();
						sb.append("<input type='hidden' name='jbxx.id' value='"+ $("#jbxx_id").val() +"'/>");
						sb.append("<input type='hidden' name='jbxx.cyzjdm' value='"+ $("#jbxx_cyzjdm").combobox('getValues') +"'/>");     
						sb.append("<input type='hidden' name='jbxx.zjhm' value='"+ $("#jbxx_zjhm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.xm' value='"+ $("#jbxx_xm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.xbdm' value='"+ $("#jbxx_xbdm").combobox('getValues') +"'/>");     
						sb.append("<input type='hidden' name='jbxx.csrq' value='"+ $("#jbxx_csrq").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.mzdm' value='"+ $("#jbxx_mzdm").combobox('getValues') +"'/>"); 
						sb.append("<input type='hidden' name='jbxx.jgssxdm' value='"+ $("#jbxx_jgssxdm").combobox('getValues') +"'/>"); 
						sb.append("<input type='hidden' name='jbxx.jggjdqdm' value='"+ $("#jbxx_jggjdqdm").combobox('getValues') +"'/>"); 
						//sb.append("<input type='hidden' name='jbxx.dz_hjdzms' value='"+ $("#jbxx_dz_hjdzms").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_hjdmlpdm' value='"+ $("#jbxx_dz_hjdmlpdm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_hjdmlpxz' value='"+ $("#jbxx_dz_hjdmlpxz").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_hjdzdm' value='"+ $("#jbxx_dz_hjdzdm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_hjdzssxdm' value='"+ $("#jbxx_dz_hjdzssxdm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_hjdzxz' value='"+ $("#jbxx_dz_hjdzxz").val() +"'/>");     
						//sb.append("<input type='hidden' name='jbxx.dz_jzdzms' value='"+ $("#jbxx_dz_jzdzms").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_jzdmlpdm' value='"+ $("#jbxx_dz_jzdmlpdm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_jzdmlpxz' value='"+ $("#jbxx_dz_jzdmlpxz").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_jzdzssxdm' value='"+ $("#jbxx_dz_jzdzssxdm ").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_jzdzdm' value='"+ $("#jbxx_dz_jzdzdm").val() +"'/>");     
						sb.append("<input type='hidden' name='jbxx.dz_jzdzxz' value='"+ $("#jbxx_dz_jzdzxz").val() +"'/>");     
						sb.append("<input type='hidden' name='syrkgllbdm' value='"+ $("#syrkgllbdm").combobox('getValues') +"'/>");
						sb.append("<input type='hidden' name='hsrwid' value='"+ $("#hsrwid").val() +"'/>");   
						sb.append("<input type='hidden' name='messageid' value='"+ $("#messageid").val() +"'/>");   
						sb.append("<input type='hidden' name='jzdzid' value='"+ $("#jzdzid").val() +"'/>");   
						document.getElementById(formID + "JbxxDiv").innerHTML = sb.toString();
						formObject.form('submit',{
							dataType : 'json',
							onSubmit: function() {
							},
							success: function(result) {
								buttonEnabled(bottonObject);
								result = parseReturn(result);
								if (result.status == 'success') { // 返回成功后执行的方法
								     
									var openUrl = "/syrkgl/view";
									openUrl += "?id=" + result.jbxx_id;
									openUrl += "&jzdzdm=" + $("#jbxx_dz_jzdzdm").val();
									openUrl += "&syrkgllbdm=" + gllbdm;
									openUrl += "&ryflid=" + result.ryflid;
									//location.href = openUrl;
									exit_onclick();
									topMessagerAlert(null, "保存成功","success");
									menu_open('实有人口编辑', openUrl);
									
								}
								else {
									topMessager.alert(MESSAGER_TITLE, result.message, 'error');
								}
							}
						});			
					}
					else {
						buttonEnabled(bottonObject);
					}
				});
			}
		}
	});
	$("#resetBotton").click(function(){
		var gllbdm = $("#syrkgllbdm").val();
			if (gllbdm == "01") {
				document.forms["czrkForm"].reset();	
			} 
			else if (gllbdm == "02") {
				document.forms["jzrkForm"].reset();		
			}
			else if (gllbdm == "03") {
				document.forms["ldrkForm"].reset();		
			}
			else if (gllbdm == "04") {
				document.forms["jwryForm"].reset();
			}
			else if (gllbdm == "05") {
				document.forms["wlczrkForm"].reset();
			}
			document.forms["jbxxForm"].reset();	
			$("#jbxx_cyzjdm").combobox('setValue', '111'); // 黑认为居民身份证
			$("#jbxx_jggjdqdm").combobox("setValue", "156");
			
			
	});
	
	initAddressSearch('jbxx_hjd1', {}, 'jbxx_dz_hjdmlpdm', 'jbxx_dz_hjdmlpxz', 'jbxx_hjd2', {text:'jbxx_dz_hjdzxz',dzxzqh:'jbxx_dz_hjdzssxdm',id:'jbxx_dz_hjdzdm'}, null, null);
	initAddressSearch('jbxx_jzd1', {zrqdm:'${zrqdm}'}, 'jbxx_dz_jzdmlpdm', 'jbxx_dz_jzdmlpxz', 'jbxx_jzd2', {text:'jbxx_dz_jzdzxz',dzxzqh:'jbxx_dz_jzdzssxdm',id:'jbxx_dz_jzdzdm'}, 'jbxx_dz_jzdz_onSelected', 'jbxx_dz_jzdz_onSelected');
	initAddressSearch('jzrk_fzdz1', {}, 'jzrk_dz_fzjzdzmlpdm', 'jzrk_dz_fzjzdzmlpxz', 'jzrk_fzdz2', {text:'jzrk_dz_fzjzdzxz',dzxzqh:'jzrk_dz_fzjzdzssxdm',id:'jzrk_dz_fzjzdzdm'}, null, null);
	initAddressSearch('ldrk_fzdz1', {}, 'ldrk_dz_fzjzdzmlpdm', 'ldrk_dz_fzjzdzmlpxz', 'ldrk_fzdz2', {text:'ldrk_dz_fzjzdzxz',dzxzqh:'ldrk_dz_fzjzdzssxdm',id:'ldrk_dz_fzjzdzdm'}, null, null);
	initAddressSearch('jwry_fzdz1', {}, 'jwry_dz_fzjzdzmlpdm', 'jwry_dz_fzjzdzmlpxz', 'jwry_fzdz2', {text:'jwry_dz_fzjzdzxz',dzxzqh:'jwry_dz_fzjzdzssxdm',id:'jwry_dz_fzjzdzdm'}, null, null);
	initAddressSearch('wlczrk_fzdz1', {}, 'wlczrk_dz_fzjzdzmlpdm', 'wlczrk_dz_fzjzdzmlpxz', 'wlczrk_fzdz2', {text:'wlczrk_dz_fzjzdzxz',dzxzqh:'wlczrk_dz_fzjzdzssxdm',id:'wlczrk_dz_fzjzdzdm'}, null, null);
//	$("#jbxx_dz_jzdmlpdm").checkValue();

	//如果国家/地区为空，则默认为中国
	if($("#jbxx_jggjdqdm").val() == "" || $("#jbxx_jggjdqdm").val() == undefined){
		$("#jbxx_jggjdqdm").combobox("setValue", "156");
	}
	if($("#jbxx_jggjdqdm").val() != "156"){
		$("#jbxx_hjd1").combobox("setValue", "");
		$("#jbxx_hjd2").combobox("setValue", "");
		setInputReadonly('jbxx_hjd1', true);  
		setInputReadonly('jbxx_hjd2', true);  
	}else{
		setInputReadonly('jbxx_hjd1', false);  
		setInputReadonly('jbxx_hjd2', false);  
	}
	
});
function exit_onclick() {
	closeSelf();
}
/**根据证件种类 设置证件号码验证 与人员基本信息只读状态*/
function cyzjdmOnchange(newVal, oldVal) {
	var newFirst = "";
	if (!newVal) {
		newVal = "";
	}
	if (newVal != "") {
		newFirst = newVal.substring(0, 1);
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newFirst == "1" || newFirst == "2" || newFirst == "3" || newFirst == "") {
		setInputReadonly('jbxx_jggjdqdm', true);  
		setInputReadonly('jbxx_jgssxdm', false);
		setInputReadonly('jbxx_wwx', true); 
		setInputReadonly('jbxx_wwm', true); 
		_jg = "XZQH";
	}
	else {
		setInputReadonly('jbxx_jggjdqdm', false);
		setInputReadonly('jbxx_jgssxdm', true);
		setInputReadonly('jbxx_wwx', false); 
		setInputReadonly('jbxx_wwm', false); 
		$("#jbxx_jggjdqdm").combobox("setValue","");
		_jg = "GJDQ";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" ) {
		$("#jbxx_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jbxx_zjhm").validatebox({validType:['maxLength[30]']});
	}
	$("#jbxx_zjhm").val("");
}

/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
function checkZjhm() {
	if (!$("#jbxx_cyzjdm").combo("isValid")){
		return;
	}
	if (!$("#jbxx_zjhm").validatebox("isValid")){
		return;
	}
	var _zjhm = $("#jbxx_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if($("#jbxx_zjhm").val() == _zjhm){
		return;
	}
	
	czrkNO = "0";
	jzrkNO = "0";
	ldrkNO = "0";
	wlczrkNO = "0";
	jwryNO = "0";
	autoGllb = true;
	$("#jbxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#jbxx_zjhm").val()+"&cyzjdm="+$("#jbxx_cyzjdm").val(),
		success:function(data) {
			if (data && data.ryjbxxb) {
				$("#jbxx_xm").val(data.ryjbxxb.xm);
				$('#jbxx_xm').validatebox('validate')
				$("#jbxx_xbdm").combobox("setValue",data.ryjbxxb.xbdm);
				$("#jbxx_csrq").val(formatDate(data.ryjbxxb.csrq));
				$("#jbxx_mzdm").combobox("setValue", data.ryjbxxb.mzdm);
				$("#jbxx_jgssxdm").combobox("setValue", data.ryjbxxb.jgssxdm);
				$("#jbxx_jggjdqdm").combobox("setValue", data.ryjbxxb.jggjdqdm);
				$('#jbxx_hjd1').combobox('loadData', []);
				$('#jbxx_hjd2').combobox('loadData', []);
				var comboText = $('#jbxx_hjd1').next(".combo").children(".combo-text");
				comboText.val(data.ryjbxxb.dz_hjdmlpxz);
				var comboText = $('#jbxx_hjd2').next(".combo").children(".combo-text");
				var dz1 = data.ryjbxxb.dz_hjdzxz;
				var dz2 = data.ryjbxxb.dz_hjdmlpxz;
				comboText.val(dz1.replace(dz2, ""));
				var opts = $('#jbxx_hjd2').combobox('options');
				opts.validEnter = false;
				$('#jbxx_dz_hjdzssxdm').val(data.ryjbxxb.dz_hjdzssxdm);
				$('#jbxx_dz_hjdzdm').val(data.ryjbxxb.dz_hjdzdm);
				$('#jbxx_dz_hjdzxz').val(data.ryjbxxb.dz_hjdzxz);
				$('#jbxx_dz_hjdmlpdm').val(data.ryjbxxb.dz_hjdmlpdm);
				$('#jbxx_dz_hjdmlpxz').val(data.ryjbxxb.dz_hjdmlpxz);

				$('#jbxx_jzd1').combobox('loadData', []);
				$('#jbxx_jzd2').combobox('loadData', []);
				var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
				comboText.val("");
				var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
				comboText.val("");
				var opts = $('#jbxx_jzd2').combobox('options');
				opts.validEnter = false;
				$('#jbxx_dz_jzdzssxdm').val("");
				$('#jbxx_dz_jzdzdm').val("");
				$('#jbxx_dz_jzdzxz').val("");
				$('#jbxx_dz_jzdmlpdm').val("");
				$('#jbxx_dz_jzdmlpxz').val("");
				
				/* 居住地不复用
				$('#jbxx_jzd1').combobox('loadData', []);
				$('#jbxx_jzd2').combobox('loadData', []);
				var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
				comboText.val(data.ryjbxxb.dz_jzdmlpxz);
				var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
				var dz1 = data.ryjbxxb.dz_jzdzxz;
				var dz2 = data.ryjbxxb.dz_jzdmlpxz;
				comboText.val(dz1.replace(dz2, ""));
				var opts = $('#jbxx_jzd2').combobox('options');
				opts.validEnter = false;
				$('#jbxx_dz_jzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
				$('#jbxx_dz_jzdzdm').val(data.ryjbxxb.dz_jzdzdm);
				$('#jbxx_dz_jzdzxz').val(data.ryjbxxb.dz_jzdzxz);
				$('#jbxx_dz_jzdmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
				$('#jbxx_dz_jzdmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
				*/
				
				$("#jbxx_id").val(data.ryjbxxb.id);
				$("#jbxxForm").form('validate');
				autoSetRklb();
			}
			else {
				$("#jbxx_xm").val("");
				$("#jbxx_xbdm").combobox("setValue","");
				$("#jbxx_csrq").val("");
				$("#jbxx_mzdm").combobox("setValue", "");
				$("#jbxx_jgssxdm").combobox("setValue", "");
				$("#jbxx_jggjdqdm").combobox("setValue", "");
				
				$('#jbxx_jzd1').combobox('loadData', []);
				$('#jbxx_jzd2').combobox('loadData', []);
				var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
				comboText.val("");
				var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
				comboText.val("");
				var opts = $('#jbxx_jzd2').combobox('options');
				opts.validEnter = false;
				$('#jbxx_dz_jzdzssxdm').val("");
				$('#jbxx_dz_jzdzdm').val("");
				$('#jbxx_dz_jzdzxz').val("");
				$('#jbxx_dz_jzdmlpdm').val("");
				$('#jbxx_dz_jzdmlpxz').val("");
				
				$('#jbxx_jzd1').combobox('loadData', []);
				$('#jbxx_jzd2').combobox('loadData', []);
				var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
				comboText.val("");
				var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
				comboText.val("");
				var opts = $('#jbxx_jzd2').combobox('options');
				opts.validEnter = false;
				$('#jbxx_dz_jzdzssxdm').val("");
				$('#jbxx_dz_jzdzdm').val("");
				$('#jbxx_dz_jzdzxz').val("");
				$('#jbxx_dz_jzdmlpdm').val("");
				$('#jbxx_dz_jzdmlpxz').val("");

				$("#jbxx_id").val("");
				$("#jbxxForm").form('validate');
				
				if ($("#czrk").attr("delayParse") == "false") {
					$("#czrk_id").val("");
					$("#czrk_zw").val("");
					$("#czrk_rhztdm").combobox("setValue","");
					$("#czrk_fwcsid").val("");
					$("#czrk_fwcs").val("");
					$("#czrk_lxdh").val("");
					//$("#czrk_jjqklxr").val("");
					//$("#czrk_jjqklxdh").val("");
					$('#czrkForm').form('validate');
				}

				if ($("#jzrk").attr("delayParse") == "false") {
					$("#jzrk_id").val("");
					$("#jzrk_jzlbdm").combobox("setValue","");
					$("#jzrk_jzksrq").val("");
					$("#jzrk_yjlksj").val("");
					$("#jzrk_fwcsid").val("");
					$("#jzrk_fwcs").val("");
					$("#jzrk_lxdh").val("");
					$("#jzrk_zw").val("");
					//$("#jzrk_jjqklxr").val("");
					//$("#jzrk_jjqklxdh").val("");
					$("#jzrk_fwczqkdm").combobox("setValue","");
					$("#jzrk_fzryid").val("");
					$("#jzrk_fzxm").val("");
					$("#jzrk_fzlxdh").val("");
					$("#jzrk_yfzgx").combobox("setValue","");
					$("#jzrk_fzcyzjdm").combobox("setValue","");
					$("#jzrk_fzcyzjhm").val("");
					
					$('#jzrk_fzdz1').combobox('loadData', []);
					$('#jzrk_fzdz2').combobox('loadData', []);
					var comboText = $('#jzrk_fzdz1').next(".combo").children(".combo-text");
					comboText.val("");
					var comboText = $('#jzrk_fzdz2').next(".combo").children(".combo-text");
					comboText.val("");
					var opts = $('#jzrk_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#jzrk_dz_fzjzdzssxdm').val("");
					$('#jzrk_dz_fzjzdzdm').val("");
					$('#jzrk_dz_fzjzdzxz').val("");
					$('#jzrk_dz_fzjzdzmlpdm').val("");
					$('#jzrk_dz_fzjzdzmlpxz').val("");
					$('#jzrkForm').form('validate');
				}
				
				if ($("#ldrk").attr("delayParse") == "false") {
					$("#ldrk_id").val("");
				    $("#ldrk_lzdqdm").combobox("setValue","");
					$("#ldrk_zylbdm").combotree("setValue","");
					$("#ldrk_zjzsydm").combobox("setValue","");
					$("#ldrk_lbdsj").val(formatDate(""));
					$("#ldrk_zw").val("");
					$("#ldrk_lxdh").val("");
					$("#ldrk_fwcsid").val("");
					$("#ldrk_fwcs").val("");
					$("#ldrk_hkxzfldm").combobox("setValue","");
					$("#ldrk_hkxzfldm").combobox("setValue","");
					$("#ldrk_czryfzgxdm").combobox("setValue","");
					$("#ldrk_fwczqkdm").combobox("setValue","");
					$("#ldrk_fzcyzjdm").combobox("setValue","");
					$("#ldrk_fzcyzjhm").val("");
					$("#ldrk_fzryid").val("");
					$("#ldrk_fzxm").val("");
					$("#ldrk_fzlxdh").val("");
				    //$("#ldrk_jjqklxr").val("");
	               // $("#ldrk_jjqklxrdh").val("");
					
					$('#ldrk_fzdz1').combobox('loadData', []);
					$('#ldrk_fzdz2').combobox('loadData', []);
					var comboText = $('#ldrk_fzdz1').next(".combo").children(".combo-text");
					comboText.val("");
					var comboText = $('#ldrk_fzdz2').next(".combo").children(".combo-text");
					comboText.val("");
					var opts = $('#ldrk_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#ldrk_dz_fzjzdzssxdm').val("");
					$('#ldrk_dz_fzjzdzdm').val("");
					$('#ldrk_dz_fzjzdzxz').val("");
					$('#ldrk_dz_fzjzdzmlpdm').val("");
					$('#ldrk_dz_fzjzdzmlpxz').val("");
					$('#ldrkForm').form('validate');
				}
				
				if ($("#jwry").attr("delayParse") == "false") {
					$("#jwry_id").val("");
		            $("#jwry_sfzh").val("");
		            $("#jwry_qzjlxkzldm").combobox("setValue","");
		            $("#jwry_qzjlxkh").val("");
		            $("#jwry_qzjlxkqfjgmc").val("");
		            $("#jwry_rjrq").val("");
		            $("#jwry_qzyxqqsrq").val("");
		            $("#jwry_qzyxqjzrq").val("");
		            $("#jwry_rjkadm").val("");
		            $("#jwry_tlyxrq").val("");
		            $("#jwry_tlsydm").combobox("setValue","");
		            $("#jwry_lhsydm").combobox("setValue","");
		            $("#jwry_jwrysfdm").combotree("setValue","");
		            $("#jwry_zfzldm").combobox("setValue","");
		            $("#jwry_ddrq").val("");
		            $("#jwry_nlkrq").val("");
		            $("#jwry_brlxdh").val("");
		            $("#jwry_fwczqkdm").combobox("setValue","");
		            $("#jwry_yfzgx").combobox("setValue","");
		            $("#jwry_fzcyzjdm").combobox("setValue","");
		            $("#jwry_fzcyzjhm").val("");
					$("#jwry_fzryid").val("");
		            $("#jwry_fzxm").val("");
		            $("#jwry_fzlxdh").val("");
		            
					$('#jwry_fzdz1').combobox('loadData', []);
					$('#jwry_fzdz2').combobox('loadData', []);
					var comboText = $('#jwry_fzdz1').next(".combo").children(".combo-text");
					comboText.val("");
					var comboText = $('#jwry_fzdz2').next(".combo").children(".combo-text");
					comboText.val("");
					var opts = $('#jwry_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#jwry_dz_fzjzdzssxdm').val("");
					$('#jwry_dz_fzjzdzdm').val("");
					$('#jwry_dz_fzjzdzxz').val("");
					$('#jwry_dz_fzjzdzmlpdm').val("");
					$('#jwry_dz_fzjzdzmlpxz').val("");

		            $("#jwry_gzxkdj").val("");
		            $("#jwry_gzdwid").val("");
		            $("#jwry_gzdwmc").val("");
		            $("#jwry_gzdwlxdh").val("");
		            $("#jwry_lsdwid").val("");
		            $("#jwry_lsdwmc").val("");
		            $("#jwry_lsdwlxdh").val("");
		            $("#jwry_jddwid").val("");
		            $("#jwry_jddwmc").val("");
		            $("#jwry_jddwlxdh").val("");
		            //$("#jwry_jjqklxr").val("");
		            //$("#jwry_jjqklxrdh").val("");
		            $("#jwry_lsdwlxdh").val("");
		            $("#jwry_hslbs").val("");
		            
		            $("#jwry_hylbsdm").val("");
		            $("#jwry_hcldqsfgwdm").combobox("setValue","");
		            $("#jwry_lzdgjdqdm").combobox("setValue","");
		            $("#jwry_lzdssxdm").combobox("setValue","");
		            $("#jwry_hcqdqsfgwdm").combobox("setValue","");
		            $("#jwry_qwdgjdqdm").combobox("setValue","");
		            $("#jwry_qwdssxdm").combobox("setValue","");
		            $("#jwry_sfffrjdm").combobox("setValue","");
		            $("#jwry_sfffjldm").combobox("setValue","");
		            $("#jwry_sfffjy").combobox("setValue","");
		            $("#jwry_lzdxz").val("");
		            $("#jwry_qwdxz").val("");
					$('#jwryForm').form('validate');
				}

				if ($("#wlczrk").attr("delayParse") == "false") {
					$("#wlczrk_id").val("");
					$("#wlczrk_wlhyydm").combobox("setValue","");
					$("#wlczrk_qtcyzjdm").combobox("setValue","");
					$("#wlczrk_qtzjhm").val("");
					$("#wlczrk_zw").val("");
					$("#wlczrk_lxdh").val("");
					$("#wlczrk_fwcsid").val("");
					$("#wlczrk_fwcs").val("");
					$("#wlczrk_fzcyzjhm").val("");
					$("#wlczrk_fzryid").val("");
					$("#wlczrk_fzxm").val("");
					$("#wlczrk_fzlxdh").val("");
					
					$('#wlczrk_fzdz1').combobox('loadData', []);
					$('#wlczrk_fzdz2').combobox('loadData', []);
					var comboText = $('#wlczrk_fzdz1').next(".combo").children(".combo-text");
					comboText.val("");
					var comboText = $('#wlczrk_fzdz2').next(".combo").children(".combo-text");
					comboText.val("");
					var opts = $('#wlczrk_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#wlczrk_dz_fzjzdzssxdm').val("");
					$('#wlczrk_dz_fzjzdzdm').val("");
					$('#wlczrk_dz_fzjzdzxz').val("");
					$('#wlczrk_dz_fzjzdzmlpdm').val("");
					$('#wlczrk_dz_fzjzdzmlpxz').val("");

	 				//$("#wlczrk_jjqklxr").val("");
					//$("#wlczrk_jjqklxdh").val("");
					$("#wlczrk_yfzgx").combobox("setValue","");
					$("#wlczrk_fwczqkdm").combobox("setValue","");
					$("#wlczrk_fzcyzjdm").combobox("setValue","");
					$('#wlczrkForm').form('validate');
				}
				autoSetRklb();
			}
		},
		complete:function() {
			$("#jbxx_zjhm").attr("zjhm", $("#jbxx_zjhm").val());
			$("#jbxxLoadDiv").hide();
		},
		error:function() {
		}
	});	
}

function jbxx_dz_jzdz_onSelected() {
	if (autoRklb == "") {
		autoGllb = true;
		autoSetRklb();
		valiRepeat();
	}
}

function autoSetRklb() {
	autoRklb = "";
	if ($("#jbxx_cyzjdm").combo("isValid") && $("#jbxx_zjhm").validatebox("isValid") && $("#jbxx_dz_jzdzdm").val() != "") {
		setInputReadonly('syrkgllbdm',false);
		if ($("#jbxx_dz_jzdzdm").val() != "" && autoGllb) {
			var jbxx_dz_hjdzssxdm_value = $("#jbxx_dz_hjdzssxdm").val();
			var jbxx_dz_hjdzdm_value = $("#jbxx_dz_hjdzdm").val();
			var jbxx_dz_jzdzssxdm_value = $("#jbxx_dz_jzdzssxdm").val();
			var jbxx_dz_jzdzdm_value = $("#jbxx_dz_jzdzdm").val();
			if (_jg == "GJDQ") { // 境外·
				autoRklb = "04";
			} else if (jbxx_dz_hjdzssxdm_value == "") { // 返还未落
				autoRklb = "03";
			} else if (jbxx_dz_hjdzdm_value != "" && jbxx_dz_jzdzdm_value != "" && jbxx_dz_hjdzdm_value == jbxx_dz_jzdzdm_value) { // 人户一至常口
				autoRklb = "01";
			} else if (jbxx_dz_hjdzssxdm_value == jbxx_dz_jzdzssxdm_value) {// 寄住人口
				autoRklb = "02";
			} else if (districtXzqh.indexOf("," + jbxx_dz_hjdzssxdm_value + ",") != -1) { // 属于市辖区的是也是寄住人口
				autoRklb = "02";
			} else { // 暂住
				autoRklb = "03";
			}
			autoGllb = true;
			 if ($("#jbxx_dz_jzdzdm").val() != "") {
			    $("#syrkgllbdm").combobox("setValue",autoRklb); // onChange事件自动执行
			}
			//divChange(rklb, "");
		}
	}
}

function formatDate(str){
	var newdate;
	if(str.length == 8){
		newdate = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
	}else{
		
	}
	return newdate?newdate:str;
}

function divChange(newValue, oldValue) {
	if (!newValue) {
		return;
	}
	var dz_hjdzssxValue = $("#jbxx_dz_hjdzssxdm").val();
	var systemXzqh = "${systemXzqh}";
	systemXzqh = systemXzqh.substring(0 ,4);
	if (dz_hjdzssxValue != "" && dz_hjdzssxValue.indexOf(systemXzqh) == "0") { // 户籍地为本市的
		if ($("#jbxx_dz_hjdzdm").val() == "") {
			topMessager.alert('', '请先选择有效的户籍地！');
			var comboText = $('#jbxx_hjd1').siblings(".combo").children(".combo-text");
			comboText.focus();
			return;
		}
	}
	if ($("#jbxx_dz_jzdzdm").val() == "") {
		topMessager.alert('', '请先选择有效的居住地！');
		var comboText = $('#jbxx_jzd1').siblings(".combo").children(".combo-text");
		comboText.focus();
		return;
	}
	var syrklxValue = newValue;
	var jbxxID = $("#jbxx_id").val();
	$("#divgllb").show();
	$("#saveDiv").show();
	if ("01" == syrklxValue) {
		if ($("#czrk").attr("delayParse") == "true") {	
			$("#czrk").find('input.easyui-combobox-delay').removeClass('easyui-combobox-delay').addClass('easyui-combobox');
			$("#czrk").find('input.easyui-combotree-delay').removeClass('easyui-combotree-delay').addClass('easyui-combotree');
			$("#czrk").find('input.easyui-validatebox-delay').removeClass('easyui-validatebox-delay').addClass('easyui-validatebox');
			$.parser.parse('#czrk');
			$("#czrk").attr("delayParse", "false");
		}
		$("#czrk").show();
		$("#jzrk").hide();
		$("#ldrk").hide();
		$("#wlczrk").hide();
		$("#jwry").hide();
		if ("0" == czrkNO && jbxxID != "") {
			$.ajax({
				type:"POST",
				url:"<%=basePath%>syrkgl/applyData",
				dataType:"json",
				data:"ryid="+jbxxID+"&syrkgllbdm="+syrklxValue,
				success:function(data){
					if (data) {
						if (data.czrk) {
							$("#czrk_id").val(data.czrk.id);
							$("#czrk_zw").val(data.czrk.zw);
							$("#czrk_rhztdm").combobox("setValue",data.czrk.rhztdm);
							$("#czrk_fwcsid").val(data.czrk.fwcsid);
							$("#czrk_fwcs").val(data.czrk.fwcs);
							$("#czrk_lxdh").val(data.czrk.lxdh);
							//$("#czrk_jjqklxr").val(data.czrk.jjqklxr);
							//$("#czrk_jjqklxdh").val(data.czrk.jjqklxdh);
							$('#czrkForm').form('validate');
						}
						/* 居住地不复用
						if (data.ryjbxxb) {
							$('#jbxx_jzd1').combobox('loadData', []);
							$('#jbxx_jzd2').combobox('loadData', []);
							var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
							comboText.val(data.ryjbxxb.dz_jzdmlpxz);
							var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
							var dz1 = data.ryjbxxb.dz_jzdzxz;
							var dz2 = data.ryjbxxb.dz_jzdmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jbxx_jzd2').combobox('options');
							opts.validEnter = false;
							$('#jbxx_dz_jzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
							$('#jbxx_dz_jzdzdm').val(data.ryjbxxb.dz_jzdzdm);
							$('#jbxx_dz_jzdzxz').val(data.ryjbxxb.dz_jzdzxz);
							$('#jbxx_dz_jzdmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
							$('#jbxx_dz_jzdmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
							$("#jbxxForm").form('validate');
						}
						if (data.jzdzid) {
							$("#jzdzid").val(data.jzdzid);
						}
						*/
					}
					
					czrkNO = "1";
				},
				error: function() {
				}
			});
		}
	} 
	else if ("02" == syrklxValue) {
		if ($("#jzrk").attr("delayParse") == "true") {	
			$("#jzrk").find('input.easyui-combobox-delay').removeClass('easyui-combobox-delay').addClass('easyui-combobox');
			$("#jzrk").find('input.easyui-combotree-delay').removeClass('easyui-combotree-delay').addClass('easyui-combotree');
			$("#jzrk").find('input.easyui-validatebox-delay').removeClass('easyui-validatebox-delay').addClass('easyui-validatebox');
			$.parser.parse('#jzrk');
			$("#jzrk").attr("delayParse", "false");
		}		       
		$("#jzrk").show();
		$("#czrk").hide();
		$("#ldrk").hide();
		$("#wlczrk").hide();
		$("#jwry").hide();
		if ("0" == jzrkNO && jbxxID != "") {
			$.ajax({                
				type:"POST",
				url:"<%=basePath%>syrkgl/applyData",
				dataType:"json",
				data:"ryid="+jbxxID+"&syrkgllbdm="+syrklxValue,
				success:function(data){
					if (data) {
						if (data.jzrk) {
							$("#jzrk_id").val(data.jzrk.id);
							$("#jzrk_jzlbdm").combobox("setValue",data.jzrk.jzlbdm);
							$("#jzrk_jzksrq").val(formatDate(data.jzrk.jzksrq));
							$("#jzrk_yjlksj").val(formatDate(data.jzrk.yjlksj));
							$("#jzrk_fwcsid").val(data.jzrk.fwcsid);
							$("#jzrk_fwcs").val(data.jzrk.fwcs);
							$("#jzrk_lxdh").val(data.jzrk.lxdh);
							$("#jzrk_zw").val(data.jzrk.zw);
							//$("#jzrk_jjqklxr").val(data.jzrk.jjqklxr);
							//$("#jzrk_jjqklxdh").val(data.jzrk.jjqklxdh);
							$("#jzrk_fwczqkdm").combobox("setValue",data.jzrk.fwczqkdm);
							$("#jzrk_fzryid").val(data.jzrk.fzryid);
							$("#jzrk_fzxm").val(data.jzrk.fzxm);
							$("#jzrk_fzlxdh").val(data.jzrk.fzlxdh);
							$("#jzrk_yfzgx").combobox("setValue",data.jzrk.yfzgx);
							$("#jzrk_fzcyzjdm").combobox("setValue",data.jzrk.fzcyzjdm);
							$("#jzrk_fzcyzjhm").val(data.jzrk.fzcyzjhm);
							
							$('#jzrk_fzdz1').combobox('loadData', []);
							$('#jzrk_fzdz2').combobox('loadData', []);
							var comboText = $('#jzrk_fzdz1').next(".combo").children(".combo-text");
							comboText.val(data.jzrk.dz_fzjzdzmlpxz);
							var comboText = $('#jzrk_fzdz2').next(".combo").children(".combo-text");
							var dz1 = data.jzrk.dz_fzjzdzxz;
							var dz2 = data.jzrk.dz_fzjzdzmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jzrk_fzdz2').combobox('options');
							opts.validEnter = false;
							$("#jzrk_dz_fzjzdzdm").val(data.jzrk.dz_fzjzdzdm);
							$("#jzrk_dz_fzjzdzssxdm").val(data.jzrk.dz_fzjzdzssxdm);
							$("#jzrk_dz_fzjzdzxz").val(data.jzrk.dz_fzjzdzxz);
							$('#jzrk_dz_fzjzdzmlpdm').val(data.jzrk.dz_fzjzdzmlpdm);
							$('#jzrk_dz_fzjzdzmlpxz').val(data.jzrk.dz_fzjzdzmlpxz);
							$('#jzrkForm').form('validate');
						}
						/* 居住地不复用
						if (data.ryjbxxb) {
							$('#jbxx_jzd1').combobox('loadData', []);
							$('#jbxx_jzd2').combobox('loadData', []);
							var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
							comboText.val(data.ryjbxxb.dz_jzdmlpxz);
							var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
							var dz1 = data.ryjbxxb.dz_jzdzxz;
							var dz2 = data.ryjbxxb.dz_jzdmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jbxx_jzd2').combobox('options');
							opts.validEnter = false;
							$('#jbxx_dz_jzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
							$('#jbxx_dz_jzdzdm').val(data.ryjbxxb.dz_jzdzdm);
							$('#jbxx_dz_jzdzxz').val(data.ryjbxxb.dz_jzdzxz);
							$('#jbxx_dz_jzdmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
							$('#jbxx_dz_jzdmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
							$("#jbxxForm").form('validate');
						}
						if (data.jzdzid) {
							$("#jzdzid").val(data.jzdzid);
						}
						*/
					}
					jzrkNO = "1";
				},
				error: function() {
				}
			});
		}
	} 
	else if ("03" == syrklxValue) {
		if ($("#ldrk").attr("delayParse") == "true") {
			$("#ldrk").find('input.easyui-combobox-delay').removeClass('easyui-combobox-delay').addClass('easyui-combobox');
			$("#ldrk").find('input.easyui-combotree-delay').removeClass('easyui-combotree-delay').addClass('easyui-combotree');
			$("#ldrk").find('input.easyui-validatebox-delay').removeClass('easyui-validatebox-delay').addClass('easyui-validatebox');
			$.parser.parse('#ldrk');
			$("#ldrk").attr("delayParse", "false");
		}		       
		$("#ldrk").show();
		$("#czrk").hide();
		$("#jzrk").hide();
		$("#wlczrk").hide();
		$("#jwry").hide();
		if ("0" == ldrkNO && jbxxID != "") {
			$.ajax({                
				type:"POST",
				url:"<%=basePath%>syrkgl/applyData",
				dataType:"json",
				data:"ryid="+jbxxID+"&syrkgllbdm="+syrklxValue,
				success:function(data) {
					if (data) {
						if (data.ldrk) {   
							$("#ldrk_id").val(data.ldrk.id);
							$("#ldrk_lzdqdm").combobox("setValue",data.ldrk.lzdqdm);
							$("#ldrk_zylbdm").combotree("setValue",data.ldrk.zylbdm);
							$("#ldrk_zjzsydm").combobox("setValue",data.ldrk.zjzsydm);
							$("#ldrk_lbdsj").val(formatDate(data.ldrk.lbdsj));
							$("#ldrk_zw").val(data.ldrk.zw);
							$("#ldrk_lxdh").val(data.ldrk.lxdh);
							$("#ldrk_fwcsid").val(data.ldrk.fwcsid);
							$("#ldrk_fwcs").val(data.ldrk.fwcs);
							$("#ldrk_hkxzfldm").combobox("setValue",data.ldrk.hkxzfldm);
							$("#ldrk_hkxzfldm").combobox("setValue",data.ldrk.hkxzfldm);
							$("#ldrk_czryfzgxdm").combobox("setValue",data.ldrk.czryfzgxdm);
							$("#ldrk_fwczqkdm").combobox("setValue",data.ldrk.fwczqkdm);
							$("#ldrk_fzcyzjdm").combobox("setValue",data.ldrk.fzcyzjdm);
							$("#ldrk_fzcyzjhm").val(data.ldrk.fzcyzjhm);
							$("#ldrk_fzryid").val(data.ldrk.fzryid);
							$("#ldrk_fzxm").val(data.ldrk.fzxm);
							$("#ldrk_fzlxdh").val(data.ldrk.fzlxdh);
							//$("#ldrk_jjqklxr").val(data.ldrk.jjqklxr);
							//$("#ldrk_jjqklxrdh").val(data.ldrk.jjqklxrdh);
							$('#ldrk_fzdz1').combobox('loadData', []);
							$('#ldrk_fzdz2').combobox('loadData', []);
							var comboText = $('#ldrk_fzdz1').next(".combo").children(".combo-text");
							comboText.val(data.ldrk.dz_fzjzdzmlpxz);
							var comboText = $('#ldrk_fzdz2').next(".combo").children(".combo-text");
							var dz1 = data.ldrk.dz_fzjzdzxz;
							var dz2 = data.ldrk.dz_fzjzdzmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#ldrk_fzdz2').combobox('options');
							opts.validEnter = false;
							$("#ldrk_dz_fzjzdzdm").val(data.ldrk.dz_fzjzdzdm);
							$("#ldrk_dz_fzjzdzssxdm").val(data.ldrk.dz_fzjzdzssxdm);
							$("#ldrk_dz_fzjzdzxz").val(data.ldrk.dz_fzjzdzxz);
							$('#ldrk_dz_fzjzdzmlpdm').val(data.ldrk.dz_fzjzdzmlpdm);
							$('#ldrk_dz_fzjzdzmlpxz').val(data.ldrk.dz_fzjzdzmlpxz);
							$('#ldrkForm').form('validate');
						}
						/* 居住地不复用
						if (data.ryjbxxb) {
							$('#jbxx_jzd1').combobox('loadData', []);
							$('#jbxx_jzd2').combobox('loadData', []);
							var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
							comboText.val(data.ryjbxxb.dz_jzdmlpxz);
							var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
							var dz1 = data.ryjbxxb.dz_jzdzxz;
							var dz2 = data.ryjbxxb.dz_jzdmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jbxx_jzd2').combobox('options');
							opts.validEnter = false;
							$('#jbxx_dz_jzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
							$('#jbxx_dz_jzdzdm').val(data.ryjbxxb.dz_jzdzdm);
							$('#jbxx_dz_jzdzxz').val(data.ryjbxxb.dz_jzdzxz);
							$('#jbxx_dz_jzdmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
							$('#jbxx_dz_jzdmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
							$("#jbxxForm").form('validate');
						}
						if (data.jzdzid) {
							$("#jzdzid").val(data.jzdzid);
						}
						*/
					}
					ldrkNO = "1";
				},
				error: function() {
				}
			});
		}
	}
	else if ("04" == syrklxValue) {
		if ($("#jwry").attr("delayParse") == "true") {
			$("#jwry").find('input.easyui-combobox-delay').removeClass('easyui-combobox-delay').addClass('easyui-combobox');
			$("#jwry").find('input.easyui-combotree-delay').removeClass('easyui-combotree-delay').addClass('easyui-combotree');
			$("#jwry").find('input.easyui-validatebox-delay').removeClass('easyui-validatebox-delay').addClass('easyui-validatebox');
			$.parser.parse('#jwry');
			$("#jwry").attr("delayParse", "false");
		}		       
		$("#jwry").show();
		$("#czrk").hide();
		$("#jzrk").hide();
		$("#wlczrk").hide();
		$("#ldrk").hide();
		if ("0" == jwryNO && jbxxID != "") {
			$.ajax({                
				type:"POST",
				url:"<%=basePath%>syrkgl/applyData",
				dataType:"json",
				data:"ryid="+jbxxID+"&syrkgllbdm="+syrklxValue,
				success:function(data) {
					if (data && data.jwry) {   
						if (data.jwry) {
							$("#jwry_id").val(data.jwry.id);
							$("#jwry_sfzh").val(data.jwry.sfzh);
							$("#jwry_qzjlxkzldm").combobox("setValue",data.jwry.qzjlxkzldm);
							$("#jwry_qzjlxkh").val(data.jwry.qzjlxkh);
							$("#jwry_qzjlxkqfjgmc").val(data.jwry.qzjlxkqfjgmc);
							$("#jwry_rjrq").val(formatDate(data.jwry.rjrq));
							$("#jwry_qzyxqqsrq").val(formatDate(data.jwry.qzyxqqsrq));
							$("#jwry_qzyxqjzrq").val(formatDate(data.jwry.qzyxqjzrq));
							$("#jwry_rjkadm").val(formatDate(data.jwry.rjka));
							$("#jwry_tlyxrq").val(formatDate(data.jwry.tlyxrq));
							$("#jwry_tlsydm").combobox("setValue",data.jwry.tlsydm);
							$("#jwry_lhsydm").combobox("setValue",data.jwry.lhsydm);
							$("#jwry_jwrysfdm").combotree("setValue",data.jwry.jwrysfdm);
							$("#jwry_zfzldm").combobox("setValue",data.jwry.zfzldm);
							$("#jwry_ddrq").val(formatDate(data.jwry.ddrq));
							$("#jwry_nlkrq").val(formatDate(data.jwry.nlkrq));
							$("#jwry_brlxdh").val(data.jwry.qzjlxkqfjgbrlxdhmc);
							$("#jwry_fwczqkdm").combobox("setValue",data.jwry.fwczqkdm);
							$("#jwry_yfzgx").combobox("setValue",data.jwry.czryfzgxdm);
							$("#jwry_fzcyzjdm").combobox("setValue",data.jwry.fzcyzjdm);
							$("#jwry_fzcyzjhm").val(data.jwry.fzcyzjhm);
							$("#jwry_fzryid").val(data.jwry.fzryid);
							$("#jwry_fzxm").val(data.jwry.fzxm);
							$("#jwry_fzlxdh").val(data.jwry.fzlxdh);

							$('#jwry_fzdz1').combobox('loadData', []);
							$('#jwry_fzdz2').combobox('loadData', []);
							var comboText = $('#jwry_fzdz1').next(".combo").children(".combo-text");
							comboText.val(data.jwry.dz_fzjzdzmlpxz);
							var comboText = $('#jwry_fzdz2').next(".combo").children(".combo-text");
							var dz1 = data.jwry.dz_fzjzdzxz;
							var dz2 = data.jwry.dz_fzjzdzmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jwry_fzdz2').combobox('options');
							opts.validEnter = false;
							$("#jwry_dz_fzjzdzdm").val(data.jwry.dz_fzjzdzdm);
							$("#jwry_dz_fzjzdzssxdm").val(data.jwry.dz_fzjzdzssxdm);
							$("#jwry_dz_fzjzdzxz").val(data.jwry.dz_fzjzdzxz);
							$('#jwry_dz_fzjzdzmlpdm').val(data.jwry.dz_fzjzdzmlpdm);
							$('#jwry_dz_fzjzdzmlpxz').val(data.jwry.dz_fzjzdzmlpxz);

							$("#jwry_gzxkdj").val(data.jwry.gzxkdj);
							$("#jwry_gzdwid").val(data.jwry.gzdwid);
							$("#jwry_gzdwmc").val(data.jwry.gzdwmc);
							$("#jwry_gzdwlxdh").val(data.jwry.gzdwlxdh);
							$("#jwry_lsdwid").val(data.jwry.lsdwid);
							$("#jwry_lsdwmc").val(data.jwry.lsdwmc);
							$("#jwry_lsdwlxdh").val(data.jwry.lsdwlxdh);
							$("#jwry_jddwid").val(data.jwry.jddwid);
							$("#jwry_jddwmc").val(data.jwry.jddwmc);
							$("#jwry_jddwlxdh").val(data.jwry.jddwlxdh);
							//$("#jwry_jjqklxr").val(data.jwry.jjqklxr);
							//$("#jwry_jjqklxrdh").val(data.jwry.jjqklxrdh);
							$("#jwry_lsdwlxdh").val(data.jwry.lsdwlxdh);
							$("#jwry_hslbs").val(formatDate(data.jwry.hslbs));
							
							$("#jwry_hylbsdm").val(formatDate(data.jwry.hylbs));
							$("#jwry_hcldqsfgwdm").combobox("setValue",data.jwry.hcldqsfgwdm);
							$("#jwry_lzdgjdqdm").combobox("setValue",data.jwry.lzdgjdqdm);
							$("#jwry_hylbsdm").val(formatDate(data.jwry.hylbs));
							$("#jwry_lzdssxdm").combobox("setValue",data.jwry.lzdssxdm);
							$("#jwry_hcqdqsfgwdm").combobox("setValue",data.jwry.hcqdqsfgwdm);
							$("#jwry_qwdgjdqdm").combobox("setValue",data.jwry.qwdgjdqdm);
							$("#jwry_qwdssxdm").combobox("setValue",data.jwry.qwdssxdm);
							$("#jwry_sfffrjdm").combobox("setValue",data.jwry.sfffrjdm);
							$("#jwry_sfffjldm").combobox("setValue",data.jwry.sfffjldm);
							$("#jwry_sfffjy").combobox("setValue",data.jwry.sfffjy);
							$("#jwry_lzdxz").val(data.jwry.lzdxz);
							$("#jwry_qwdxz").val(data.jwry.qwdxz);
							$('#jwryForm').form('validate');
						}
						/* 居住地不复用
						if (data.ryjbxxb) {
							$('#jbxx_jzd1').combobox('loadData', []);
							$('#jbxx_jzd2').combobox('loadData', []);
							var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
							comboText.val(data.ryjbxxb.dz_jzdmlpxz);
							var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
							var dz1 = data.ryjbxxb.dz_jzdzxz;
							var dz2 = data.ryjbxxb.dz_jzdmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jbxx_jzd2').combobox('options');
							opts.validEnter = false;
							$('#jbxx_dz_jzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
							$('#jbxx_dz_jzdzdm').val(data.ryjbxxb.dz_jzdzdm);
							$('#jbxx_dz_jzdzxz').val(data.ryjbxxb.dz_jzdzxz);
							$('#jbxx_dz_jzdmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
							$('#jbxx_dz_jzdmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
							$("#jbxxForm").form('validate');
						}
						if (data.jzdzid) {
							$("#jzdzid").val(data.jzdzid);
						}
						*/
					}
					jwryNO = "1";
				},
				error: function() {
				}
			});
		}
	}
	else if ("05" == syrklxValue) {
		if ($("#wlczrk").attr("delayParse") == "true") {
			$("#wlczrk").find('input.easyui-combobox-delay').removeClass('easyui-combobox-delay').addClass('easyui-combobox');
			$("#wlczrk").find('input.easyui-combotree-delay').removeClass('easyui-combotree-delay').addClass('easyui-combotree');
			$("#wlczrk").find('input.easyui-validatebox-delay').removeClass('easyui-validatebox-delay').addClass('easyui-validatebox');
			$.parser.parse('#wlczrk');
			$("#wlczrk").attr("delayParse", "false");
		}		       
		$("#wlczrk").show();
		$("#czrk").hide();
		$("#jzrk").hide();
		$("#jwry").hide();
		$("#ldrk").hide();
		if ("0" == wlczrkNO && jbxxID != "") {
			$.ajax({                
				type:"POST",
				url:"<%=basePath%>syrkgl/applyData",
				dataType:"json",
				data:"ryid="+jbxxID+"&syrkgllbdm="+syrklxValue,
				success:function(data){
					if (data) {
						if (data.wlczrk) {         
							$("#wlczrk_id").val(data.wlczrk.id);
							$("#wlczrk_wlhyydm").combobox("setValue",data.wlczrk.wlhyydm);
							$("#wlczrk_qtcyzjdm").combobox("setValue",data.wlczrk.qtcyzjdm);
							$("#wlczrk_qtzjhm").val(data.wlczrk.qtzjhm);
							$("#wlczrk_zw").val(data.wlczrk.zw);
							$("#wlczrk_lxdh").val(data.wlczrk.lxdh);
							$("#wlczrk_fwcsid").val(data.wlczrk.fwcsid);
							$("#wlczrk_fwcs").val(data.wlczrk.fwcs);
							$("#wlczrk_fzcyzjhm").val(data.wlczrk.fzcyzjhm);
							$("#wlczrk_fzryid").val(data.wlczrk.fzryid);
							$("#wlczrk_fzxm").val(data.wlczrk.fzxm);
							$("#wlczrk_fzlxdh").val(data.wlczrk.fzlxdh);

							$('#wlczrk_fzdz1').combobox('loadData', []);
							$('#wlczrk_fzdz2').combobox('loadData', []);
							var comboText = $('#wlczrk_fzdz1').next(".combo").children(".combo-text");
							comboText.val(data.wlczrk.dz_fzjzdzmlpxz);
							var comboText = $('#wlczrk_fzdz2').next(".combo").children(".combo-text");
							var dz1 = data.wlczrk.dz_fzjzdzxz;
							var dz2 = data.wlczrk.dz_fzjzdzmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#wlczrk_fzdz2').combobox('options');
							opts.validEnter = false;
							$("#wlczrk_dz_fzjzdzdm").val(data.wlczrk.dz_fzjzdzdm);
							$("#wlczrk_dz_fzjzdzssxdm").val(data.wlczrk.dz_fzjzdzssxdm);
							$("#wlczrk_dz_fzjzdzxz").val(data.wlczrk.dz_fzjzdzxz);
							$('#wlczrk_dz_fzjzdzmlpdm').val(data.wlczrk.dz_fzjzdzmlpdm);
							$('#wlczrk_dz_fzjzdzmlpxz').val(data.wlczrk.dz_fzjzdzmlpxz);
							
							//$("#wlczrk_jjqklxr").val(data.wlczrk.jjqklxr);
							//$("#wlczrk_jjqklxdh").val(data.wlczrk.jjqklxdh);
							$("#wlczrk_yfzgx").combobox("setValue",data.wlczrk.czryfzgxdm);
							$("#wlczrk_fwczqkdm").combobox("setValue",data.wlczrk.fwczqkdm);
							$("#wlczrk_fzcyzjdm").combobox("setValue",data.wlczrk.fzcyzjdm);
							$('#wlczrkForm').form('validate');
						}
						/* 居住地不复用
						if (data.ryjbxxb) {
							$('#jbxx_jzd1').combobox('loadData', []);
							$('#jbxx_jzd2').combobox('loadData', []);
							var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
							comboText.val(data.ryjbxxb.dz_jzdmlpxz);
							var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
							var dz1 = data.ryjbxxb.dz_jzdzxz;
							var dz2 = data.ryjbxxb.dz_jzdmlpxz;
							comboText.val(dz1.replace(dz2, ""));
							var opts = $('#jbxx_jzd2').combobox('options');
							opts.validEnter = false;
							$('#jbxx_dz_jzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
							$('#jbxx_dz_jzdzdm').val(data.ryjbxxb.dz_jzdzdm);
							$('#jbxx_dz_jzdzxz').val(data.ryjbxxb.dz_jzdzxz);
							$('#jbxx_dz_jzdmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
							$('#jbxx_dz_jzdmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
							$("#jbxxForm").form('validate');
						}
						if (data.jzdzid) {
							$("#jzdzid").val(data.jzdzid);
						}
						*/
					}
					wlczrkNO = "1";
				},
				error: function() {
				}
			});
		}
	}
}


function rhztdmOnchange(newVal, oldVal) {
	if ($("#czrk_rhztdm").combobox("getValues") == "1") {
		$('#jbxx_jzd1').combobox('loadData', []);
		$('#jbxx_jzd2').combobox('loadData', []);
		var comboText = $('#jbxx_jzd1').next(".combo").children(".combo-text");
		comboText.val($('#jbxx_hjd1').combo('getText'));
		var comboText = $('#jbxx_jzd2').next(".combo").children(".combo-text");
		comboText.val($('#jbxx_hjd2').combo('getText'));
		var opts = $('#jbxx_jzd2').combobox('options');
		opts.validEnter = false;
		$('#jbxx_dz_jzdzssxdm').val($('#jbxx_dz_hjdzssxdm').val());
		$('#jbxx_dz_jzdzdm').val($('#jbxx_dz_hjdzdm').val());
		$('#jbxx_dz_jzdzxz').val($('#jbxx_dz_hjdzxz').val());
		$('#jbxx_dz_jzdmlpdm').val($('#jbxx_dz_hjdmlpdm').val());
		$('#jbxx_dz_jzdmlpxz').val($('#jbxx_dz_hjdmlpxz').val());
		setComboRequired('jbxx_jzd1', true);
	}
	else {
		setComboRequired('jbxx_jzd1', false);
	}
}

function jzrk_fzcyzjdm_onchange(newVal, oldVal) {
	var newFirst = "";
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#jzrk_fzcyzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jzrk_fzcyzjhm").validatebox({validType:['maxLength[30]']});
	}
}

function jzrk_fzcyzjhm_onblur() {
	if (!$("#jzrk_fzcyzjhm").validatebox("isValid")){
		return;
	}
	var _zjlx = $("#jzrk_fzcyzjdm").val();
	if (_zjlx == "111" || _zjlx == "112" || _zjlx == "335" || _zjlx == "") {
		var _zjhm = $("#jzrk_fzcyzjhm").attr("zjhm");
		if (!_zjhm) {
			_zjhm = "";
		} 
		if($("#jzrk_fzcyzjhm").val() == _zjhm){
			return;
		}
		$("#jzrkLoadDiv").show();
		$.ajax({
			type:"POST",
			url:"<%=basePath%>syrkgl/getSyrk",
			dataType:"json",
			data:"zjhm="+$("#jzrk_fzcyzjhm").val()+"&cyzjdm="+$("#jzrk_fzcyzjdm").val(),
			success:function(data){
				if (data && data.ryjbxxb) {
					$("#jzrk_fzryid").val(data.ryjbxxb.id);
					$("#jzrk_fzxm").val(data.ryjbxxb.xm);
					$("#jzrk_fzlxdh").val(data.ryjbxxb.lxdh);
					
					$('#jzrk_fzdz1').combobox('loadData', []);
					$('#jzrk_fzdz2').combobox('loadData', []);
					var comboText = $('#jzrk_fzdz1').next(".combo").children(".combo-text");
					comboText.val(data.ryjbxxb.dz_jzdmlpxz);
					var comboText = $('#jzrk_fzdz2').next(".combo").children(".combo-text");
					var dz1 = data.ryjbxxb.dz_jzdzxz;
					var dz2 = data.ryjbxxb.dz_jzdmlpxz;
					comboText.val(dz1.replace(dz2, ""));
					var opts = $('#jzrk_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#jzrk_dz_fzjzdzdm').val(data.ryjbxxb.dz_jzdzdm);
					$('#jzrk_dz_fzjzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
					$('#jzrk_dz_fzjzdzxz').val(data.ryjbxxb.dz_jzdzxz);
					$('#jzrk_dz_fzjzdzmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
					$('#jzrk_dz_fzjzdzmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
				}
				else {
					$("#jzrk_fzryid").val("");
				}
			},
			complete:function(){
				$("#jzrk_fzcyzjhm").attr("zjhm", $("#jzrk_fzcyzjhm").val());
				$("#jzrkLoadDiv").hide();
			}
		});	
	
	}
}

function ldrk_fzcyzjdm_onchange(newVal, oldVal) {
	var newFirst = "";
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#ldrk_fzcyzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#ldrk_fzcyzjhm").validatebox({validType:['maxLength[30]']});
	}
}

function ldrk_fzcyzjhm_onblur() {
	if (!$("#ldrk_fzcyzjhm").validatebox("isValid")){
		return;
	}
	var _zjlx = $("#ldrk_fzcyzjdm").val();
	if (_zjlx == "111" || _zjlx == "112" || _zjlx == "335" || _zjlx == "") {
		var _zjhm = $("#ldrk_fzcyzjhm").attr("zjhm");
		if (!_zjhm) {
			_zjhm = "";
		} 
		if($("#ldrk_fzcyzjhm").val() == _zjhm){
			return;
		}
		$("#ldrkLoadDiv").show();
		$.ajax({
			type:"POST",
			url:"<%=basePath%>syrkgl/getSyrk",
			dataType:"json",
			data:"zjhm="+$("#ldrk_fzcyzjhm").val()+"&cyzjdm="+$("#ldrk_fzcyzjdm").val(),
			success:function(data){
				if (data && data.ryjbxxb) {
					$("#ldrk_fzryid").val(data.ryjbxxb.id);
					$("#ldrk_fzxm").val(data.ryjbxxb.xm);
					$("#ldrk_fzlxdh").val(data.ryjbxxb.lxdh);
					
					$('#ldrk_fzdz1').combobox('loadData', []);
					$('#ldrk_fzdz2').combobox('loadData', []);
					var comboText = $('#ldrk_fzdz1').next(".combo").children(".combo-text");
					comboText.val(data.ryjbxxb.dz_jzdmlpxz);
					var comboText = $('#ldrk_fzdz2').next(".combo").children(".combo-text");
					var dz1 = data.ryjbxxb.dz_jzdzxz;
					var dz2 = data.ryjbxxb.dz_jzdmlpxz;
					comboText.val(dz1.replace(dz2, ""));
					var opts = $('#ldrk_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#ldrk_dz_fzjzdzdm').val(data.ryjbxxb.dz_jzdzdm);
					$('#ldrk_dz_fzjzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
					$('#ldrk_dz_fzjzdzxz').val(data.ryjbxxb.dz_jzdzxz);
					$('#ldrk_dz_fzjzdzmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
					$('#ldrk_dz_fzjzdzmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
				}
				else {
					$("#ldrk_fzryid").val("");
				}
			},
			complete:function(){
				$("#ldrk_fzcyzjhm").attr("zjhm", $("#ldrk_fzcyzjhm").val());
				$("#ldrkLoadDiv").hide();
			}
		});	
	
	}
}

function jwry_fzcyzjdm_onchange(newVal, oldVal) {
	var newFirst = "";
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#jwry_fzcyzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jwry_fzcyzjhm").validatebox({validType:['maxLength[30]']});
	}
}

function jwry_fzcyzjhm_onblur() {
	if (!$("#jwry_fzcyzjhm").validatebox("isValid")){
		return;
	}
	var _zjlx = $("#jwry_fzcyzjdm").val();
	if (_zjlx == "111" || _zjlx == "112" || _zjlx == "335" || _zjlx == "") {
		var _zjhm = $("#jwry_fzcyzjhm").attr("zjhm");
		if (!_zjhm) {
			_zjhm = "";
		} 
		if($("#jwry_fzcyzjhm").val() == _zjhm){
			return;
		}
		$("#jwryLoadDiv").show();
		$.ajax({
			type:"POST",
			url:"<%=basePath%>syrkgl/getSyrk",
			dataType:"json",
			data:"zjhm="+$("#jwry_fzcyzjhm").val()+"&cyzjdm="+$("#jwry_fzcyzjdm").val(),
			success:function(data){
				if (data && data.ryjbxxb) {
					$("#jwry_fzryid").val(data.ryjbxxb.id);
					$("#jwry_fzxm").val(data.ryjbxxb.xm);
					$("#jwry_fzlxdh").val(data.ryjbxxb.lxdh);
					
					$('#jwry_fzdz1').combobox('loadData', []);
					$('#jwry_fzdz2').combobox('loadData', []);
					var comboText = $('#jwry_fzdz1').next(".combo").children(".combo-text");
					comboText.val(data.ryjbxxb.dz_jzdmlpxz);
					var comboText = $('#jwry_fzdz2').next(".combo").children(".combo-text");
					var dz1 = data.ryjbxxb.dz_jzdzxz;
					var dz2 = data.ryjbxxb.dz_jzdmlpxz;
					comboText.val(dz1.replace(dz2, ""));
					var opts = $('#jwry_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#jwry_dz_fzjzdzdm').val(data.ryjbxxb.dz_jzdzdm);
					$('#jwry_dz_fzjzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
					$('#jwry_dz_fzjzdzxz').val(data.ryjbxxb.dz_jzdzxz);
					$('#jwry_dz_fzjzdzmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
					$('#jwry_dz_fzjzdzmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
				}
				else {
					$("#jwry_fzryid").val("");
				}
			},
			complete:function(){
				$("#jwry_fzcyzjhm").attr("zjhm", $("#jwry_fzcyzjhm").val());
				$("#jwryLoadDiv").hide();
			}
		});	
	
	}
}

function wlczrk_qtcyzjdm_onchange(newVal, oldVal) {
	var newFirst = "";
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#wlczrk_qtzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#wlczrk_qtzjhm").validatebox({validType:['maxLength[30]']});
	}
}

function wlczrk_fzcyzjdm_onchange(newVal, oldVal) {
	var newFirst = "";
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#wlczrk_fzcyzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#wlczrk_fzcyzjhm").validatebox({validType:['maxLength[30]']});
	}
}

function wlczrk_fzcyzjhm_onblur() {
	if (!$("#wlczrk_fzcyzjhm").validatebox("isValid")){
		return;
	}
	var _zjlx = $("#wlczrk_fzcyzjdm").val();
	if (_zjlx == "111" || _zjlx == "112" || _zjlx == "335" || _zjlx == "") {
		var _zjhm = $("#wlczrk_fzcyzjhm").attr("zjhm");
		if (!_zjhm) {
			_zjhm = "";
		} 
		if($("#wlczrk_fzcyzjhm").val() == _zjhm){
			return;
		}
		$("#wlczrkLoadDiv").show();
		$.ajax({
			type:"POST",
			url:"<%=basePath%>syrkgl/getSyrk",
			dataType:"json",
			data:"zjhm="+$("#wlczrk_fzcyzjhm").val()+"&cyzjdm="+$("#wlczrk_fzcyzjdm").val(),
			success:function(data){
				if (data && data.ryjbxxb) {
					$("#wlczrk_fzryid").val(data.ryjbxxb.id);
					$("#wlczrk_fzxm").val(data.ryjbxxb.xm);
					$("#wlczrk_fzlxdh").val(data.ryjbxxb.lxdh);
					
					$('#wlczrk_fzdz1').combobox('loadData', []);
					$('#wlczrk_fzdz2').combobox('loadData', []);
					var comboText = $('#wlczrk_fzdz1').next(".combo").children(".combo-text");
					comboText.val(data.ryjbxxb.dz_jzdmlpxz);
					var comboText = $('#wlczrk_fzdz2').next(".combo").children(".combo-text");
					var dz1 = data.ryjbxxb.dz_jzdzxz;
					var dz2 = data.ryjbxxb.dz_jzdmlpxz;
					comboText.val(dz1.replace(dz2, ""));
					var opts = $('#wlczrk_fzdz2').combobox('options');
					opts.validEnter = false;
					$('#wlczrk_dz_fzjzdzdm').val(data.ryjbxxb.dz_jzdzdm);
					$('#wlczrk_dz_fzjzdzssxdm').val(data.ryjbxxb.dz_jzdzssxdm);
					$('#wlczrk_dz_fzjzdzxz').val(data.ryjbxxb.dz_jzdzxz);
					$('#wlczrk_dz_fzjzdzmlpdm').val(data.ryjbxxb.dz_jzdmlpdm);
					$('#wlczrk_dz_fzjzdzmlpxz').val(data.ryjbxxb.dz_jzdmlpxz);
				}
				else {
					$("#wlczrk_fzryid").val("");
				}
			},
			complete:function(){
				$("#wlczrk_fzcyzjhm").attr("zjhm", $("#wlczrk_fzcyzjhm").val());
				$("#wlczrkLoadDiv").hide();
			}
		});	
	
	}
}

function jwry_hcldqsfgwdmOnchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	if ($("#jwry_hcldqsfgwdm").combobox('getValues') == "0") { // 来自国内
		$("#jwry_lzdgjdqdm").combobox('setValue', '');
		setInputReadonly('jwry_lzdgjdqdm', true);
		setInputReadonly('jwry_lzdssxdm', false);
	}
	else {
		$("#jwry_lzdssxdm").combobox('setValue', '');
		setInputReadonly('jwry_lzdgjdqdm', false);
		setInputReadonly('jwry_lzdssxdm', true);
	}
}

function jwry_hcqdqsfgwdmOnchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	if ($("#jwry_hcqdqsfgwdm").combobox('getValues') == "1") { // 去往国外
		$("#jwry_qwdssxdm").combobox('setValue', '');
		setInputReadonly('jwry_qwdgjdqdm', false);
		setInputReadonly('jwry_qwdssxdm', true);
	}
	else {
		$("#jwry_qwdgjdqdm").combotree('setValue', '');
		setInputReadonly('jwry_qwdgjdqdm', true);
		setInputReadonly('jwry_qwdssxdm', false);
	}
}
/**
 * 验证居住地址重复
 */
function valiRepeat(){
	$.ajax({
		type:"POST",
		url:"<%=basePath%>syrkgl/valiRepeat",
		dataType:"json",
		data:"ryid="+$("#jbxx_id").val()+"&jzdzdm="+$("#jbxx_dz_jzdmlpdm").val(),
		success:function(data){
			if(data.repeat){
				topMessagerAlert(null,'该实有人口已经存在!');
			}
		},
		complete:function(){
		}
	});	
}
function doInit(paramArray) {
}
function beforeSubmit() {
}
function afterSubmit() {
}
</script>
</html>