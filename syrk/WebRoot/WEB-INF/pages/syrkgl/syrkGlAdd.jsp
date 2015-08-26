<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String orglevel = "";
    if(userInfo!=null){
    	orglevel = userInfo.getUserOrgLevel();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实有人口新增</title>
<script type="text/javascript">
   var orglevel = "<%=orglevel%>";
</script>
<script type="text/javascript" src="<%=contextPath%>/js/syrkgl/syrkGlAdd.js"></script>

</head>

<body style="margin-top:20px; margin-bottom:10px" class="bodybg">

<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">

	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
			<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
				<form action="" id="jbxxForm" name="jbxxForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
					<input type="hidden" id="jbxx_id" name="jbxx.id" value="${ryRyjbxxb.id}"/>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">实有人口业务类型：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="syrkywlxdm" name="syrkywlxdm" value="${syrkywlxdm}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/BD_D_SYRKYWLXDM.js',dataFilter: '2|3|4|5',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',required:true,onChange:syrkywlxdm_onChange"/></td> 
						<td width="20%" class="dialogTd" align="right" id="jbxx_zjzlId">证件种类：</td>
						<td width="30%" class="dialogTd"><div id="jbxx_zjzlDiv"><input class="easyui-combobox" type="text" id="jbxx_cyzjdm" name="jbxx.cyzjdm" value="${ryRyjbxxb.cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:jbxx_cyzjdm_onChange"/></div></td> 
					</tr>
					<tbody id="jbxxZjbody">
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jbxx_zjhm" name="jbxx.zjhm" value="${ryRyjbxxb.zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'" onblur="jbxx_zjhm_onblur()"/><div class="lodingimg" id="jbxxLoadDiv"></div></td>
		    	        <td width="20%" class="dialogTd" align="right" id="jbxx_xm_td">姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jbxx_xm" name="jbxx.xm" value="${ryRyjbxxb.xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'left'"/></td>
					</tr>
					</tbody>
					<!-- 基本信息补充 -->		
	    	      	<tbody id="jbxxTbody">
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_xbdm" name="jbxx.xbdm" value="${ryRyjbxxb.xbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jbxx_csrq" name="jbxx.csrq" value="${ryRyjbxxb.csrq}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">民族：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_mzdm" name="jbxx.mzdm" value="${ryRyjbxxb.mzdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jbxx_lxdh" name="jbxx.lxdh" value="${ryRyjbxxb.lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jbxx_lxdh','jbxx_id')"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">出生国家：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_csdgjhdqdm" name="jbxx.csdgjhdqdm" value="${ryRyjbxxb.csdgjhdqdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">出生地：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_csdssxdm" name="jbxx.csdssxdm" value="${ryRyjbxxb.csdssxdm}" style="width:200px;" 
	    	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">籍贯国家：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_jggjdqdm" name="jbxx.jggjdqdm" value="${ryRyjbxxb.jggjdqdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:jbxx_jggjdqdm_onChange"/></td> 
				    	<td width="20%" class="dialogTd" align="right">籍贯：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_jgssxdm" name="jbxx.jgssxdm" value="${ryRyjbxxb.jgssxdm}" style="width:200px;" 
	    	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>
					</tr>
					<tr class="dialogTr">
		    	        <td width="20%" class="dialogTd" align="right">曾用名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jbxx_cym" name="jbxx.cym" value="${ryRyjbxxb.cym}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">学历：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jbxx_xldm" name="jbxx.xldm" value="${ryRyjbxxb.xldm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_XLDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_hyzkdm" name="jbxx.hyzkdm" value="${ryRyjbxxb.hyzkdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">政治面貌：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_zzmmdm" name="jbxx.zzmmdm" value="${ryRyjbxxb.zzmmdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">宗教信仰：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_zjxydm" name="jbxx.zjxydm" value="${ryRyjbxxb.zjxydm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_ZJXYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">兵役状况：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_byzkdm" name="jbxx.byzkdm" value="${ryRyjbxxb.byzkdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_BYQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">血型：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jbxx_xxdm" name="jbxx.xxdm" value="${ryRyjbxxb.xxdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">职业类别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jbxx_zylbdm" name="jbxx.zylbdm" value="${ryRyjbxxb.zylbdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">职业：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jbxx_zy" name="jbxx.zy" value="${ryRyjbxxb.zy}" style="width:595px;" maxlength="60"/></td> 
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">工作单位：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
					    	<input type="hidden" id="gzdwid" name="gzdwid" value="${gzdwid}"/>
					    	<input type="hidden" id="gzdw" name="gzdw" value="${gzdw}"/>
				    		<input class="easyui-combobox" id="gzdw_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${gzdw}" maxlength="50" style="width:595px;" /></td>
					</tr>
					
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">户籍地址描述：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="jbxx.hjd_dzms" id="jbxx_hjd_dzms" value="${ryRyjbxxb.hjd_dzms}" style="width:595px;"/>
							<input type="hidden" id="jbxx_hjd_xzqhdm" name="jbxx.hjd_xzqhdm" value="${ryRyjbxxb.hjd_xzqhdm}"/>
							<input type="hidden" id="jbxx_hjd_mlpdm" name="jbxx.hjd_mlpdm" value="${ryRyjbxxb.hjd_mlpdm}"/>
							<input type="hidden" id="jbxx_hjd_mlpxz" name="jbxx.hjd_mlpxz" value="${ryRyjbxxb.hjd_mlpxz}"/>
							<input type="hidden" id="jbxx_hjd_dzid" name="jbxx.hjd_dzid" value="${ryRyjbxxb.hjd_dzid}"/>
							<input type="hidden" id="jbxx_hjd_dzxz" name="jbxx.hjd_dzxz" value="${ryRyjbxxb.hjd_dzxz}"/>
							<input type="hidden" id="jbxx_hjd_pcsdm" name="jbxx.hjd_pcsdm" value="${ryRyjbxxb.hjd_pcsdm}"/>
				    	</td> 
					</tr>
	    	      	</tbody>
				</table>
   				</form>
    				
   				<!-- 实有人口业务类型分类 -->
   				<form action="<%=basePath%>syrkGl/save" id="czrkForm" name="czrkForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="display: none;" id="czrkTable" delayParse="true">
    				<tbody>
    				<input type="hidden" id="czrk_id" name="czrk.id" value="${czrk.id}"/>
					<input type="hidden" id="czrk_hjd_xzqhdm" name="czrk.hjd_xzqhdm" value="${czrk.hjd_xzqhdm}"/>
					<input type="hidden" id="czrk_hjd_mlpdm" name="czrk.hjd_mlpdm" value="${czrk.hjd_mlpdm}"/>
					<input type="hidden" id="czrk_hjd_mlpxz" name="czrk.hjd_mlpxz" value="${czrk.hjd_mlpxz}"/>
					<input type="hidden" id="czrk_hjd_dzid" name="czrk.hjd_dzid" value="${czrk.hjd_dzid}"/>
					<input type="hidden" id="czrk_hjd_dzxz" name="czrk.hjd_dzxz" value="${czrk.hjd_dzxz}"/>
					<tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">常住人口信息：</td>
	    	      		<td width="80%" class="dialogTd" colspan="3"><div id="czrkDiv" style="display:none;"></div></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">户口性质：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="czrk_hkxzfldm" name="czrk.hkxzfldm" value="${czrk.hkxzfldm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_HKXZFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',dataFilter:'1|2|3|4|5|8|9',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">户号：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_hh" name="czrk.hh" value="${czrk.hh}" style="width:200px;" maxlength="9"
							data-options="required:false,validType:['numeric[\'i\']'],charSet:'half',tipPosition:'left'" onblur="czrk_hh_onblur()"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">与户主关系：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="czrk_yhzgxdm" name="czrk.yhzgxdm" value="${czrk.yhzgxdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_JTGXDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
				    	<td width="20%" class="dialogTd" align="right">是否人户一致：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="czrk_sfrhyzdm" name="czrk.sfrhyzdm" value="${czrk.sfrhyzdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:czrk_sfrhyzdm_onChange"/></td>
					</tr>
	    	      	
					<tr class="dialogTr" id="rhfl_hjd_tr1" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right"><input type="radio" name="hjRadio" id="hjRadio1" checked="checked" onclick="czrk_rhfl_hjd_select(1)">&nbsp;&nbsp;户籍地址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="czrk1_hjd1" style="width:380px;" value="${ryRyjbxxb.hjd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk1_hjd_mlpdm" value="${ryRyjbxxb.hjd_mlpdm}"/>
					    	<input type="hidden" id="czrk1_hjd_mlpxz" value="${ryRyjbxxb.hjd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="czrk1_hjd2" style="width:200px;" value='${fn:replace(ryRyjbxxb.hjd_dzxz, ryRyjbxxb.hjd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk1_hjd_dzid" value="${ryRyjbxxb.hjd_dzid}"/>
					    	<input type="hidden" id="czrk1_hjd_xzqhdm" value="${ryRyjbxxb.hjd_xzqhdm}"/>
					    	<input type="hidden" id="czrk1_hjd_dzxz" value="${ryRyjbxxb.hjd_dzxz}"/>
				    	</td>
					</tr>
					<tr class="dialogTr" id="rhfl_hjd_tr2" style="display: none;">
			    		<td width="20%" class="dialogTd" align="right"><input type="radio" name="hjRadio" id="hjRadio2" onclick="czrk_rhfl_hjd_select(2)">集体空挂户：</td>
			    		<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="czrk2_hjd_dzxz" value="${kgJt.hjd_dzxz}" style="width:595px;" />
				    		<input type="hidden" id="czrk2_hjd_mlpdm" value="${kgJt.hjd_mlpdm}"/>
					    	<input type="hidden" id="czrk2_hjd_mlpxz" value="${kgJt.hjd_mlpxz}"/>
					    	<input type="hidden" id="czrk2_hjd_dzid" value="${kgJt.hjd_dzid}"/>
					    	<input type="hidden" id="czrk2_hjd_xzqhdm" value="${kgJt.hjd_xzqhdm}"/>
				    	</td>
					</tr>
					<tr class="dialogTr" id="rhfl_hjd_tr3" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right"><input type="radio" name="hjRadio" id="hjRadio3" onclick="czrk_rhfl_hjd_select(3)">居民空挂户：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="czrk3_hjd_dzxz" value="${kgJm.hjd_dzxz}" style="width:595px;" />
				    		<input type="hidden" id="czrk3_hjd_mlpdm" value="${kgJm.hjd_mlpdm}"/>
					    	<input type="hidden" id="czrk3_hjd_mlpxz" value="${kgJm.hjd_mlpxz}"/>
					    	<input type="hidden" id="czrk3_hjd_dzid" value="${kgJm.hjd_dzid}"/>
					    	<input type="hidden" id="czrk3_hjd_xzqhdm" value="${kgJm.hjd_xzqhdm}"/>
				    	</td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="czrk_jzd1" style="width:380px;" value="${czrk.jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_jzd_mlpdm" name="czrk.jzd_mlpdm" value="${czrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="czrk_jzd_mlpxz" name="czrk.jzd_mlpxz" value="${czrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="czrk_jzd2" style="width:200px;" value='${fn:replace(czrk.jzd_dzxz, czrk.jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_jzd_dzid" name="czrk.jzd_dzid" value="${czrk.jzd_dzid}"/>
					    	<input type="hidden" id="czrk_jzd_xzqhdm" name="czrk.jzd_xzqhdm" value="${czrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="czrk_jzd_dzxz" name="czrk.jzd_dzxz" value="${czrk.jzd_dzxz}"/>
					    	<input type="hidden" id="czrk_jzd_zbx" name="czrk.jzd_zbx" value="${czrk.jzd_zbx}"/>
					    	<input type="hidden" id="czrk_jzd_zby" name="czrk.jzd_zby" value="${czrk.jzd_zby}"/>
					    	<input type="hidden" id="czrk_zrqdm" value="${zrqdm}"/>
				    	</td>
					</tr>
			
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">迁入日期：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="czrk_lbsqk_qlrrq" name="czrk.lbsqk_qlrrq" value="${czrk.lbsqk_qlrrq}" style="width:200px;" 
		    	 			data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td> 
				    	<td width="20%" class="dialogTd" align="right">迁入原因：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="czrk_lbsqk_qyldyydm" name="czrk.lbsqk_qyldyydm" value="${czrk.lbsqk_qyldyydm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">来自国家：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czrk_lbsqk_lzd_gjhdqdm" name="czrk.lbsqk_lzd_gjhdqdm" value="${czrk.lbsqk_lzd_gjhdqdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right"></td>
				    	<td width="30%" class="dialogTd"></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">来自地址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="czrk_lbsqk_lzd1" style="width:380px;" value="${czrk.lbsqk_lzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_lbsqk_lzd_mlpdm" name="czrk.lbsqk_lzd_mlpdm" value="${czrk.lbsqk_lzd_mlpdm}"/>
					    	<input type="hidden" id="czrk_lbsqk_lzd_mlpxz" name="czrk.lbsqk_lzd_mlpxz" value="${czrk.lbsqk_lzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="czrk_lbsqk_lzd2" style="width:200px;" value='${fn:replace(czrk.lbsqk_lzd_dzxz, czrk.lbsqk_lzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_lbsqk_lzd_dzid" name="czrk.lbsqk_lzd_dzid" value="${czrk.lbsqk_lzd_dzid}"/>
					    	<input type="hidden" id="czrk_lbsqk_lzd_xzqhdm" name="czrk.lbsqk_lzd_xzqhdm" value="${czrk.lbsqk_lzd_xzqhdm}"/>
					    	<input type="hidden" id="czrk_lbsqk_lzd_dzxz" name="czrk.lbsqk_lzd_dzxz" value="${czrk.lbsqk_lzd_dzxz}"/>
				    	</td>
					</tr>
		    	    
    				</tbody>
				</table>
    			</form>

   				<form action="<%=basePath%>syrkGl/save" id="jzrkForm" name="jzrkForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="display: none;" id="jzrkTable" delayParse="true">
    				<tbody>
    				<input type="hidden" id="jzrk_id" name="jzrk.id" value="${jzrk.id}"/>
					<tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">寄住人口信息：</td>
	    	      		<td width="80%" class="dialogTd" colspan="3"><div id="jzrkDiv" style="display:none;"></div></td>
					</tr>
			
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jzrk_jzd1" style="width:380px;" value="${jzrk.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzrk_jzd_mlpdm" name="jzrk.jzd_mlpdm" value="${jzrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="jzrk_jzd_mlpxz" name="jzrk.jzd_mlpxz" value="${jzrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jzrk_jzd2" style="width:200px;" value='${fn:replace(jzrk.jzd_dzxz, jzrk.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzrk_jzd_dzid" name="jzrk.jzd_dzid" value="${jzrk.jzd_dzid}"/>
					    	<input type="hidden" id="jzrk_jzd_xzqhdm" name="jzrk.jzd_xzqhdm" value="${jzrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="jzrk_jzd_dzxz" name="jzrk.jzd_dzxz" value="${jzrk.jzd_dzxz}"/>
					    	<input type="hidden" id="jzrk_jzd_zbx" name="jzrk.jzd_zbx" value="${jzrk.jzd_zbx}"/>
					    	<input type="hidden" id="jzrk_jzd_zby" name="jzrk.jzd_zby" value="${jzrk.jzd_zby}"/>
				    	</td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">寄住类别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jzrk_jzlbdm" name="jzrk.jzlbdm" value="${jzrk.jzlbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/BD_D_JZLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">寄住原因：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jzrk_jzyydm" name="jzrk.jzyydm" value="${jzrk.jzyydm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/BD_D_JZYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">寄住开始时间：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_jz_ksrq01" name="jzrk.jz_ksrq01" value="${jzrk.jz_ksrq01}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
				    	<td width="20%" class="dialogTd" align="right">预计离开时间：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_yj_lksj" name="jzrk.yj_lksj" value="${jzrk.yj_lksj}" style="width:200px;" 
			    			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jzrk_jz_ksrq01\') || \'%y-%M-%d\'}'})"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="jzrk_zjzcsfldm" name="jzrk.zjzcsfldm" value="${jzrk.zjzcsfldm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:jzrk_zjzcsfldm_onChange"/></td>
				    	<td width="20%" class="dialogTd" align="right"></td>
				    	<td width="30%" class="dialogTd"></td>
					</tr>

					<tr class="dialogTr" id="jzrk_fz_tr1" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jzrk_fwczqkdm" name="jzrk.fwczqkdm" value="${jzrk.fwczqkdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="jzrk_chzr_yfzgx_rygxdm" name="jzrk.chzr_yfzgx_rygxdm" value="${jzrk.chzr_yfzgx_rygxdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
					</tr>
					<tr class="dialogTr" id="jzrk_fz_tr2" style="display: none;">
						<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jzrk_fz_cyzjdm" name="jzrk.fz_cyzjdm" value="${jzrk.fz_cyzjdm}" style="width:200px;"
							data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:jzrk_fz_cyzjdm_onChange"/></td> 
				    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_fz_zjhm" name="jzrk.fz_zjhm" value="${jzrk.fz_zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="jzrk_fz_zjhm_onblur()"/><div class="lodingimg" id="jzrk_fzLoadDiv"></div>
		    	        	<input type="hidden" id="jzrk_fz_ryid" name="jzrk.fz_ryid" value="${jzrk.fz_ryid}"/>
		    	        </td>
					</tr>
					<tr class="dialogTr" id="jzrk_fz_tr3" style="display: none;">
		    	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_fz_xm" name="jzrk.fz_xm" value="${jzrk.fz_xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_fz_lxdh" name="jzrk.fz_lxdh" value="${jzrk.fz_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jzrk_fz_lxdh','jzrk_fz_ryid')"/></td>
					</tr>
					<tr class="dialogTr" id="jzrk_fz_tr4" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jzrk_fz_jzd1" style="width:380px;" value="${jzrk.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzrk_fz_jzd_mlpdm" name="jzrk.fz_jzd_mlpdm" value="${jzrk.fz_jzd_mlpdm}"/>
					    	<input type="hidden" id="jzrk_fz_jzd_mlpxz" name="jzrk.fz_jzd_mlpxz" value="${jzrk.fz_jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jzrk_fz_jzd2" style="width:200px;" value='${fn:replace(jzrk.fz_jzd_dzxz, jzrk.fz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzrk_fz_jzd_dzid" name="jzrk.fz_jzd_dzid" value="${jzrk.fz_jzd_dzid}"/>
					    	<input type="hidden" id="jzrk_fz_jzd_xzqhdm" name="jzrk.fz_jzd_xzqhdm" value="${jzrk.fz_jzd_xzqhdm}"/>
					    	<input type="hidden" id="jzrk_fz_jzd_dzxz" name="jzrk.fz_jzd_dzxz" value="${jzrk.fz_jzd_dzxz}"/>
				    	</td>
					</tr>
		    	    
    				</tbody>
				</table>
    			</form>

   				<form action="<%=basePath%>syrkGl/save" id="ldrkForm" name="ldrkForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="display: none;" id="ldrkTable" delayParse="true">
    				<tbody>
    				<input type="hidden" id="ldrk_id" name="ldrk.id" value="${ldrk.id}"/>
					<tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">暂住人口信息：</td>
	    	      		<td width="80%" class="dialogTd" colspan="3"><div id="ldrkDiv" style="display:none;"></div></td>
					</tr>
			
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="ldrk_jzd1" style="width:380px;" value="${ldrk.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_jzd_mlpdm" name="ldrk.jzd_mlpdm" value="${ldrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="ldrk_jzd_mlpxz" name="ldrk.jzd_mlpxz" value="${ldrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="ldrk_jzd2" style="width:200px;" value='${fn:replace(ldrk.jzd_dzxz, ldrk.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_jzd_dzid" name="ldrk.jzd_dzid" value="${ldrk.jzd_dzid}"/>
					    	<input type="hidden" id="ldrk_jzd_xzqhdm" name="ldrk.jzd_xzqhdm" value="${ldrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="ldrk_jzd_dzxz" name="ldrk.jzd_dzxz" value="${ldrk.jzd_dzxz}"/>
					    	<input type="hidden" id="ldrk_jzd_zbx" name="ldrk.jzd_zbx" value="${ldrk.jzd_zbx}"/>
					    	<input type="hidden" id="ldrk_jzd_zby" name="ldrk.jzd_zby" value="${ldrk.jzd_zby}"/>
				    	</td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住事由：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_zjzsydm" name="ldrk.zjzsydm" value="${ldrk.zjzsydm}" style="width:200px;" 
							data-options="required:false,url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">户口所在地类型：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_hkszdlxdm" name="ldrk.hkszdlxdm" value="${ldrk.hkszdlxdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_DYCXSXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">迁入日期：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_lbsqk_qlrrq" name="ldrk.lbsqk_qlrrq" value="${ldrk.lbsqk_qlrrq}" style="width:200px;" 
		    	 			data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',maxDate:'%y-%M-%d'})"/></td>
				    	<td width="20%" class="dialogTd" align="right">迁移原因：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_lbsqk_qyldyydm" name="ldrk.lbsqk_qyldyydm" value="${ldrk.lbsqk_qyldyydm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">来自国家：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_lzd_gjhdqdm" name="ldrk.lzd_gjhdqdm" value="${ldrk.lzd_gjhdqdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">区域范围：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_qyfwdm" name="ldrk.qyfwdm" value="${ldrk.qyfwdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/KX_ZA_RKQYQYFWDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">来自地：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="ldrk_lzd1" style="width:380px;" value="${ldrk.lzd_mlpxz}" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_lzd_mlpdm" name="ldrk.lzd_mlpdm" value="${ldrk.lzd_mlpdm}"/>
					    	<input type="hidden" id="ldrk_lzd_mlpxz" name="ldrk.lzd_mlpxz" value="${ldrk.lzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="ldrk_lzd2" style="width:200px;" value='${fn:replace(ldrk.lzd_dzxz, ldrk.lzd_mlpxz, "")}' data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_lzd_dzid" name="ldrk.lzd_dzid" value="${ldrk.lzd_dzid}"/>
					    	<input type="hidden" id="ldrk_lzd_xzqhdm" name="ldrk.lzd_xzqhdm" value="${ldrk.lzd_xzqhdm}"/>
					    	<input type="hidden" id="ldrk_lzd_dzxz" name="ldrk.lzd_dzxz" value="${ldrk.lzd_dzxz}"/>
				    	</td>
					</tr>
			
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="ldrk_zjzcsfldm" name="ldrk.zjzcsfldm" value="${ldrk.zjzcsfldm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:ldrk_zjzcsfldm_onChange"/></td>
				    	<td width="20%" class="dialogTd" align="right"></td>
				    	<td width="30%" class="dialogTd"></td>
					</tr>

					<tr class="dialogTr" id="ldrk_fz_tr1" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_fwczqkdm" name="ldrk.fwczqkdm" value="${ldrk.fwczqkdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="ldrk_chzr_yfzgx_rygxdm" name="ldrk.chzr_yfzgx_rygxdm" value="${ldrk.chzr_yfzgx_rygxdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
					</tr>
					<tr class="dialogTr" id="ldrk_fz_tr2" style="display: none;">
						<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="ldrk_fz_cyzjdm" name="ldrk.fz_cyzjdm" value="${ldrk.fz_cyzjdm}" style="width:200px;"
							data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:ldrk_fz_cyzjdm_onChange"/></td> 
				    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_fz_zjhm" name="ldrk.fz_zjhm" value="${ldrk.fz_zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="ldrk_fz_zjhm_onblur()"/><div class="lodingimg" id="ldrk_fzLoadDiv"></div>
    						<input type="hidden" id="ldrk_fz_ryid" name="ldrk.fz_ryid" value="${ldrk.fz_ryid}"/>
		    	        </td>
					</tr>
					<tr class="dialogTr" id="ldrk_fz_tr3" style="display: none;">
		    	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_fz_xm" name="ldrk.fz_xm" value="${ldrk.fz_xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_fz_lxdh" name="ldrk.fz_lxdh" value="${ldrk.fz_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('ldrk_fz_lxdh','ldrk_fz_ryid')"/></td>
					</tr>
					<tr class="dialogTr" id="ldrk_fz_tr4" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="ldrk_fz_jzd1" style="width:380px;" value="${ldrk.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_fz_jzd_mlpdm" name="ldrk.fz_jzd_mlpdm" value="${ldrk.fz_jzd_mlpdm}"/>
					    	<input type="hidden" id="ldrk_fz_jzd_mlpxz" name="ldrk.fz_jzd_mlpxz" value="${ldrk.fz_jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="ldrk_fz_jzd2" style="width:200px;" value='${fn:replace(ldrk.fz_jzd_dzxz, ldrk.fz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_fz_jzd_dzid" name="ldrk.fz_jzd_dzid" value="${ldrk.fz_jzd_dzid}"/>
					    	<input type="hidden" id="ldrk_fz_jzd_xzqhdm" name="ldrk.fz_jzd_xzqhdm" value="${ldrk.fz_jzd_xzqhdm}"/>
					    	<input type="hidden" id="ldrk_fz_jzd_dzxz" name="ldrk.fz_jzd_dzxz" value="${ldrk.fz_jzd_dzxz}"/>
				    	</td>
					</tr>

    				</tbody>
				</table>
    			</form>

   				<form action="<%=basePath%>syrkGl/save" id="jwryForm" name="jwryForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="display: none;" id="jwryTable" delayParse="true">
    				<tbody>
    				<input type="hidden" id="jwry_id" name="jwry.id" value="${jwry.id}"/>
    				<tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" style="color: #FF0000;font-weight: bold;" align="right">临住登记：</td>
	    	      		<td width="80%" class="dialogTd" colspan="3"><div id="jwryDiv" style="display:none;"></div></td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">国籍（地区）：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_gjdm" name="jwry.gjdm" value="${jwry.gjdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:jwry_gjdm_onChange"/></td> 
					    <td width="50%" class="dialogTd" rowspan="9" colspan="2" align="center" style="border: 1px solid #dedfe3;">
					       <img src="<%=contextPath%>/common/skin/images/empty_ryzp.jpg" style="width:162px;height:200px;"/>
					    </td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_cyzjdm" name="jwry.cyzjdm" value="${jwry.cyzjdm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zjhm" name="jwry.zjhm" value="${jwry.zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'" onblur="jwry_zjhm_onblur()"/><div class="lodingimg" id="jwryLoadDiv"></div></td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">中文姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_xm" name="jwry.xm" value="${jwry.xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">外文姓：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_wwx" name="jwry.wwx" value="${jwry.wwx}" style="width:200px;" maxlength="40"
		    	        	data-options="required:true,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">外文名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_wwm" name="jwry.wwm" value="${jwry.wwm}" style="width:200px;" maxlength="40"
		    	        	data-options="required:true,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_xbdm" name="jwry.xbdm" value="${jwry.xbdm}" style="width:200px;" 
							data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
					</tr>
					<tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_csrq" name="jwry.csrq" value="${jwry.csrq}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">身份证号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qt_sfzhm" name="jwry.qt_sfzhm" value="${jwry.qt_sfzhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的身份证号码', tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">签证（注）种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_qzjlxkzldm" name="jwry.qzjlxkzldm" value="${jwry.qzjlxkzldm}" style="width:200px;"
							data-options="required:false,url: contextPath + '/common/dict/ZA_D_QZZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right'"/></td> 	
				    	<td width="20%" class="dialogTd" align="right">签证（注）号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qzjlxkh" name="jwry.qzjlxkh" value="${jwry.qzjlxkh}" style="width:200px;" maxlength="30"  
		    	        	data-options="required:false,validType:['letterOrNum'],charSet:'half',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">入境日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_rjrq" name="jwry.rjrq" value="${jwry.rjrq}" style="width:200px;" 
		    	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
				    	<td width="20%" class="dialogTd" align="right">停留有效日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_qztjl_jzrq" name="jwry.qztjl_jzrq" value="${jwry.qztjl_jzrq}" style="width:200px;" 
		    	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_rjrq\')}'})"/></td>
					</tr>
					<tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" style="color: #FF0000;font-weight: bold;" align="right">住址信息：</td>
	    	      		<td width="80%" class="dialogTd" colspan="3"></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">住房种类：</td>
		    	        <td width="80%" class="dialogTd" colspan="3"><input class="easyui-combotree-delay" type="text" id="jwry_zjzcsfldm" name="jwry.zjzcsfldm" value="${jwry.zjzcsfldm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right"><input type="radio" id="jzdzRadio" name="dzRadio" checked="checked" value="0" onclick="onRadioClick(0);">现住址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jwry_jzd1" style="width:380px;" value="${jwry.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jwry_jzd_mlpdm" name="jwry.jzd_mlpdm" value="${jwry.jzd_mlpdm}"/>
					    	<input type="hidden" id="jwry_jzd_mlpxz" name="jwry.jzd_mlpxz" value="${jwry.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jwry_jzd2" style="width:200px;" value='${fn:replace(jwry.jzd_dzxz, jwry.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jwry_jzd_dzid" name="jwry.jzd_dzid" value="${jwry.jzd_dzid}"/>
					    	<input type="hidden" id="jwry_jzd_xzqhdm" name="jwry.jzd_xzqhdm" value="${jwry.jzd_xzqhdm}"/>
					    	<input type="hidden" id="jwry_jzd_dzxz" name="jwry.jzd_dzxz" value="${jwry.jzd_dzxz}"/>
					    	<input type="hidden" id="jwry_jzd_zbx" name="jwry.jzd_zbx" value="${jwry.jzd_zbx}"/>
					    	<input type="hidden" id="jwry_jzd_zby" name="jwry.jzd_zby" value="${jwry.jzd_zby}"/>
				    	</td>
					</tr>
					<tbody id="dzmsbody">
					<tr class="dialogTr">
			       		<td width="20%" class="dialogTd" align="right"><input type="radio" id="dzmsRadio" name="dzRadio" value="1" onclick="onRadioClick(1);">地址描述：</td>
						<td width="50%" class="dialogTd" colspan="2">
							<input class="easyui-combobox" id="dzms_mldzXz" style="width:380px;" value="${jwry.dzms_mldz}" 
								data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" >
							<input type='hidden' id="dzms_mldz" name='jwry.dzms_mldz' value="${jwry.dzms_mldz}"/>
						</td>
						<td width="30%" class="dialogTd">
						    <input class="easyui-validatebox" name='jwry.dzms_chdz' id="dzms_chdz" style="width:200px;" value='${jwry.dzms_chdz}'>
					    </td>	
		    	   </tr>
		    	   <tr class="dialogTr">
		    	   		<td width="20%" class="dialogTd" align="right"></td>
						<td width="50%" class="dialogTd" colspan="2">
							<input class="easyui-validatebox" id="dzms_sspcsmc" name="jwry.dzms_sspcsmc" style="width: 49%;" value="地址描述所属派出所">
							<input class="easyui-validatebox" id="dzms_sszrqmc" name="jwry.dzms_sszrqmc" style="width: 48%;" value="地址描述所属责任区">
							<input type="hidden" id="dzms_sspcsdm" name="jwry.dzms_sspcsdm" value="${jwry.dzms_sspcsdm}">
							<input type="hidden" id="dzms_sszrqdm" name="jwry.dzms_sszrqdm" value="${jwry.dzms_sszrqdm}">
							<input type="hidden" id="entity_zbx" name="jwry.dzms_zbx" value="${jwry.dzms_zbx}">
							<input type="hidden" id="entity_zby" name="jwry.dzms_zby" value="${jwry.dzms_zby}">
						</td>
					    <td class="dialogTd">
							 <a id="dtbdButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" disabled="disabled">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">标点</span>
									<span class="l-btn-icon icon-biaodian"></span>
								</span>
							 </a>
					    </td>
		    	    </tr>
		    	    </tbody>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">入宿日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_zsrq" name="jwry.zsrq" value="${jwry.zsrq}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
		    	 	    <td width="20%" class="dialogTd" align="right">拟离开日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_nlkrq" name="jwry.nlkrq" value="${jwry.nlkrq}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jwry_zsrq\')}'})"/></td>
					</tr>
					<tr class="dialogTr">
		    	        <td width="20%" class="dialogTd" align="right">房主身份类别：</td>
		    	        <td width="80%" class="dialogTd" colspan="3">
                            <input type="radio" id="jnryId" name="jwry.fz_sflb" value="0" onclick="jwry_fzsflb_onClick()" checked="checked">境内人员
                            <input type="radio" id="jwryId" name="jwry.fz_sflb" value="1" onclick="jwry_fzsflb_onClick()">境外人员		    	        
 		    	        </td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_fz_cyzjdm" name="jwry.fz_cyzjdm" value="${jwry.fz_cyzjdm}" style="width:200px;"
							data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:jwry_fz_cyzjdm_onChange"/></td> 
				    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_zjhm" name="jwry.fz_zjhm" value="${jwry.fz_zjhm}" style="width:200px;float:left;" maxlength="30"
		    	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'right'" onblur="jwry_fz_zjhm_onblur()"/><div class="lodingimg" id="jwry_fzLoadDiv"></div></td>
						<input type="hidden" id="jwry_fz_ryid" name="jwry.fz_ryid" value="${jwry.fz_ryid}"/>
					</tr>
					<tr class="dialogTr">
		    	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_xm" name="jwry.fz_xm" value="${jwry.fz_xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_lxdh" name="jwry.fz_lxdh" value="${jwry.fz_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'right'" onblur="checkLxdh('jwry_fz_lxdh','jwry_fz_ryid')"/></td>
					</tr>
					<tr class="dialogTr" id="jwry_fz_tr1" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房主国籍：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_fz_gjdm" name="jwry.fz_gjdm" value="${jwry.fz_gjdm}" style="width:200px;" 
							data-options="required:false,url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">房主性别：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="jwry_fz_xbdm" name="jwry.fz_xbdm" value="${jwry.fz_xbdm}" style="width:200px;" 
							data-options="required:false,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
					</tr>
					<tr class="dialogTr" id="jwry_fz_tr2" style="display: none;">
					    <td width="20%" class="dialogTd" align="right">房主外文姓：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_wwx" name="jwry.fz_wwx" value="${jwry.fz_wwx}" style="width:200px;" maxlength="40"
		    	        	data-options="required:false,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
					 	<td width="20%" class="dialogTd" align="right">房主外文名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_fz_wwm" name="jwry.fz_wwm" value="${jwry.fz_wwm}" style="width:200px;" maxlength="40"
		    	        	data-options="required:false,validType:['letter'],charSet:'half',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr" id="jwry_fz_tr3" style="display: none;">
		    	        <td width="20%" class="dialogTd" align="right">房主出生日期：</td>
		    	        <td width="30%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jwry_fz_csrq" name="jwry.fz_csrq" value="${jwry.fz_csrq}" style="width:200px;" 
		    	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">留宿单位：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
					    	<input type="hidden" id="jwry_lsdw_dwid" name="jwry.lsdw_dwid" value="${jwry.lsdw_dwid}"/>
					    	<input type="hidden" id="jwry_lsdw_dwmc" name="jwry.lsdw_dwmc" value="${jwry.lsdw_dwmc}"/>
				    		<input class="easyui-combobox" id="jwry_lsdw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.lsdw_dwmc}" maxlength="50" style="width:595px;" /></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">接待单位：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
					    	<input type="hidden" id="jwry_jddw_dwid" name="jwry.jddw_dwid" value="${jwry.jddw_dwid}"/>
					    	<input type="hidden" id="jwry_jddw_dwmc" name="jwry.jddw_dwmc" value="${jwry.jddw_dwmc}"/>
				    		<input class="easyui-combobox" id="jwry_jddw_dwmc_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jwry.jddw_dwmc}" maxlength="50" style="width:595px;" /></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">留宿单位联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lsdw_lxdh" name="jwry.lsdw_lxdh" value="${jwry.lsdw_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
						<td width="20%" class="dialogTd" align="right">接待单位联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_jddw_lxdh" name="jwry.jddw_lxdh" value="${jwry.jddw_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">紧急情况联系人：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lxr_xm" name="jwry.lxr_xm" value="${jwry.lxr_xm}" style="width:200px;" maxlength="18"
							data-options="tipPosition:'right'"/></td>
						<td width="20%" class="dialogTd" align="right">紧急情况联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jwry_lxr_lxdh" name="jwry.lxr_lxdh" value="${jwry.lxr_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'right'"/></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">备注：</td>
				    	<td width="80%" class="dialogTd" colspan="3"><textarea id="jwry_bz" name="jwry.bz" class="easyui-validatebox" style="width: 595px; height:48px;overflow: auto;"
							data-options="validType:['maxLength[250]'],invalidMessage:'备注不能超过250个汉字，请重新输入！',tipPosition:'right'">${jwry.bz}</textarea></td>
			    	</tr>
    				</tbody>
				</table>
    			</form>
    			
    			<form action="<%=basePath%>syrkGl/save" id="wlrkForm" name="wlrkForm" method="post">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="display: none;" id="wlrkTable" delayParse="true">
    				<tbody>
    				<input type="hidden" id="wlrk_id" name="wlrk.id" value="${wlrk.id}"/>
					<tr class="dialogTr">
	    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">未落户人员信息：</td>
	    	      		<td width="80%" class="dialogTd" colspan="3"><div id="wlrkDiv" style="display:none;"></div></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">工作单位：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
					    	<input type="hidden" id="wlrk_gzdwid" name="wlrk.gzdwid" value="${wlrk.gzdwid}"/>
					    	<input type="hidden" id="wlrk_gzdw" name="wlrk.gzdw" value="${wlrk.gzdw}"/>
				    		<input class="easyui-combobox" id="wlrk_gzdw_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${wlrk.gzdw}" maxlength="50" style="width:595px;" /></td>
					</tr>
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="wlrk_jzd1" style="width:380px;" value="${wlrk.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="wlrk_jzd_mlpdm" name="wlrk.jzd_mlpdm" value="${wlrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="wlrk_jzd_mlpxz" name="wlrk.jzd_mlpxz" value="${wlrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="wlrk_jzd2" style="width:200px;" value='${fn:replace(wlrk.jzd_dzxz, wlrk.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="wlrk_jzd_dzid" name="wlrk.jzd_dzid" value="${wlrk.jzd_dzid}"/>
					    	<input type="hidden" id="wlrk_jzd_xzqhdm" name="wlrk.jzd_xzqhdm" value="${wlrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="wlrk_jzd_dzxz" name="wlrk.jzd_dzxz" value="${wlrk.jzd_dzxz}"/>
					    	<input type="hidden" id="wlrk_jzd_zbx" name="wlrk.jzd_zbx" value="${wlrk.jzd_zbx}"/>
					    	<input type="hidden" id="wlrk_jzd_zby" name="wlrk.jzd_zby" value="${wlrk.jzd_zby}"/>
				    	</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">其他常用证件：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlrk_qtcyzjdm" name="wlrk.qtcyzjdm" value="${wlrk.qtcyzjdm}" style="width:200px;"
							data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:wlrk_qtcyzjdm_onChange"/></td> 
				    	<td width="20%" class="dialogTd" align="right">其他常用证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_qtzjhm" name="wlrk.qtzjhm" value="${wlrk.qtzjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'"/></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">未落户原因：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlrk_wlhyydm" name="wlrk.wlhyydm" value="${wlrk.wlhyydm}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/ZA_D_WLHYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right'"/></td> 
				    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="wlrk_zjzcsfldm" name="wlrk.zjzcsfldm" value="${wlrk.zjzcsfldm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:wlrk_zjzcsfldm_onChange"/></td>
					</tr>

					<tr class="dialogTr" id="wlrk_fz_tr1" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlrk_fwczqkdm" name="wlrk.fwczqkdm" value="${wlrk.fwczqkdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree-delay" type="text" id="wlrk_chzr_yfzgx_rygxdm" name="wlrk.chzr_yfzgx_rygxdm" value="${wlrk.chzr_yfzgx_rygxdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
					</tr>
					<tr class="dialogTr" id="wlrk_fz_tr2" style="display: none;">
						<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox-delay" type="text" id="wlrk_fz_cyzjdm" name="wlrk.fz_cyzjdm" value="${wlrk.fz_cyzjdm}" style="width:200px;"
							data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:wlrk_fz_cyzjdm_onChange"/></td> 
				    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_fz_zjhm" name="wlrk.fz_zjhm" value="${wlrk.fz_zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="wlrk_fz_zjhm_onblur()"/><div class="lodingimg" id="wlrk_fzLoadDiv"></div>
    						<input type="hidden" id="wlrk_fz_ryid" name="wlrk.fz_ryid" value="${wlrk.fz_ryid}"/>
		    	        </td>
					</tr>
					<tr class="dialogTr" id="wlrk_fz_tr3" style="display: none;">
		    	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
		    	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_fz_xm" name="wlrk.fz_xm" value="${wlrk.fz_xm}" style="width:200px;" maxlength="50"
		    	        	data-options="tipPosition:'right'"/></td>
				    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_fz_lxdh" name="wlrk.fz_lxdh" value="${wlrk.fz_lxdh}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('wlrk_fz_lxdh','wlrk_fz_ryid')"/></td>
					</tr>
					<tr class="dialogTr" id="wlrk_fz_tr4" style="display: none;">
				    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="wlrk_fz_jzd1" style="width:380px;" value="${wlrk.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="wlrk_fz_jzd_mlpdm" name="wlrk.fz_jzd_mlpdm" value="${wlrk.fz_jzd_mlpdm}"/>
					    	<input type="hidden" id="wlrk_fz_jzd_mlpxz" name="wlrk.fz_jzd_mlpxz" value="${wlrk.fz_jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="wlrk_fz_jzd2" style="width:200px;" value='${fn:replace(wlrk.fz_jzd_dzxz, wlrk.fz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="wlrk_fz_jzd_dzid" name="wlrk.fz_jzd_dzid" value="${wlrk.fz_jzd_dzid}"/>
					    	<input type="hidden" id="wlrk_fz_jzd_xzqhdm" name="wlrk.fz_jzd_xzqhdm" value="${wlrk.fz_jzd_xzqhdm}"/>
					    	<input type="hidden" id="wlrk_fz_jzd_dzxz" name="wlrk.fz_jzd_dzxz" value="${wlrk.fz_jzd_dzxz}"/>
				    	</td>
					</tr>
	    	      	
    				</tbody>
				</table>
    			</form>
    		  </div>	
			
		</div>
	    </div>
	    </div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:none;">
			<a id="saveAndPrintButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveForm(1)" style="display: none;">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存并打印</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveForm(0)">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
		</div>
   	</td></tr></table>
</div>
</body>
<script type="text/javascript">
var mainTabID = "${mainTabID}";
var invokeJSMethod = "${invokeJSMethod}";
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";
var cyzjdm = "${ryRyjbxxb.cyzjdm}"; 
var zjhm = "${ryRyjbxxb.zjhm}"; 
function doInit(paramArray) {

}

function beforeSubmit() {
}

function afterSubmit() {
}	
</script>
</html>