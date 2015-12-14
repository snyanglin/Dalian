<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-6-14 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript">
			var mainTabID="${mainTabID}";
			var states="${states}";
			var dwmc="${dwmc}";
			var zjhms="${zjhms}";
			var zrqdm = "<%=userOrgCode%>";

				var zjhm="${zjhm}";
				var zjlxdm="${zjlxdm}";
				var xm="${xm}";
				var xbdm="${xbdm}";
				var whcddm="${whcddm}";
				var zzmmdm="${zzmmdm}";
				var rylydm="${rylydm}";
				var zznzw="${zznzw}";
				var lxfs="${lxfs}";
				var cjsj="${cjsj}";
				var dz_jzdzmlpdm="${dz_jzdzmlpdm}";
				var dz_jzdzmlpxz="${dz_jzdzmlpxz}";
				var dz_jzdzdm="${dz_jzdzdm}";
				var dz_jzdzssxqdm="${dz_jzdzssxqdm}";
				var dz_jzdzxz="${dz_jzdzxz}";
				var cylbdm="${cylbdm}";
				var bz="${bz}";
				var gzdw="${gzdw}";
				var dwid="${dwid}";
				var id="${id}";
				var index="${index}";
				

		</script>
		<script type="text/javascript" src="<%=contextPath%>/js/aqff/rfxx/aqffrfryxxAdd.js"></script>
		<title>人防信息</title>
		<style>
			.table{
			font-size:12px;
			background: #FFFFFF;
			}
			.td1{ text-align:right;
			width:10%;
			height:auto
			}
			.td2{ text-align:left;
			width:30%;
			height:auto
			}
		</style>
	</head>
	<body style="margin-top:20px">
		<div id="win" data-options="region:'center', split:true" style="border-width: 0px;
		margin:0 0 0 0;text-align:center;" >
		<form id="rfryxxForm" method="post">
			<input type="hidden" id="id" name="id" value="${entity.id}" />
			<input type="hidden" id="index" name="index"  />
			<input type="hidden" id="rfid" name="rfid" value="${rfid}" />
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<tr>
				    <td class="td1">证件类型：</td>
				    <td class="td2">
				    	<input class="easyui-combobox" id="zjlxdm" name="zjlxdm" value="${entity.zjlxdm}" 
						style="width:240px;" data-options="required:true
						,url: contextPath + '/common/dict/D_BZ_CYZJ.js',
						valueField:'id',validType:['maxLength[1]'],textField:'text',selectOnNavigation:false,method:'get'
						,tipPosition:'right',onSelect:function(param){
						validateZjhm(param);
						}"/>
				    </td>
				    <td class="td1">证件号码：</td>
				    <td  class="td2">
				    	<input type="text" name="zjhm" id ="zjhm" 
						class="easyui-validatebox" maxlength="30" 
						data-options="required:true,tipPosition:'left'" style="width:240px;float:left;" />
					</td>
				</tr>
				<tr>
					<td class="td1">姓名：</td>
					<td class="td2">
						<input class="easyui-validatebox" type="text" id="xm" name="xm"
						value="${entity.xm}" maxlength="20" style="width:240px;" 
						data-options="required:true,validType:['maxLength[20]'],tipPosition:'right'"/>
					</td>
					<td class="td1">性别：</td>
					<td  class="td2">
						<input type="text" name="xbdm" id="xbdm" value="${entity.xbdm}" class="easyui-combobox " 
						style="width:240px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js'
						,valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/>
					</td>
				</tr>
				<tr>
					<td class="td1">文化程度：</td>
				    <td class="td2">
					    <input type="text" name="whcddm" id="whcddm" value="${entity.whcddm}" class="easyui-combobox " 
					    style="width:240px;"
						data-options="required:false,url: contextPath + '/common/dict/D_QBLD_WHCD.js'
						,valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/>
				    </td>
				    <td class="td1">政治面貌：</td>
				    <td class="td2">
					    <input type="text" name="zzmmdm" id="zzmmdm" value="${entity.zzmmdm}" 
					    class="easyui-combobox " style="width:240px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_ZZMM.js'
						,valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/>
				    </td>
				</tr>
				<tr>
					<td class="td1">人员来源：</td>
				    <td class="td2">
						<input class="easyui-combotree" type="text" id="rylydm" name="rylydm"
						value="${entity.rylydm}" style="width:240px;"
						data-options="required:false,url: contextPath + '/common/dict/D_AQFF_RYLYDM.js',
						onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:265,
						method:'get',editable:true,lines:true"/>
				    </td>
				    <td class="td1">组织内职务：</td>
				    <td class="td2">
					    <input class="easyui-validatebox" type="text" id="zznzw" name="zznzw"
						value="${entity.zznzw}" maxlength="20" style="width:240px;" 
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
				    </td>
				</tr>
				<tr>
				    <td class="td1">联系方式：</td>
				    <td class="td2">
					    <input class="easyui-validatebox" type="text" id="lxfs" name="lxfs"
						value="${entity.lxfs}" maxlength="20" style="width:240px;" 
						data-options="required:false,validType:['maxLength[20]'],validType:['phone'],tipPosition:'right'"/>
				    </td>
				    <td class="td1">参加时间：</td>
				    <td class="td2">
				    	<input class="easyui-validatebox" type="text" id="cjsj" name="cjsj" 
				    	style="width:240px;" value="${entity.cjsj}"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" 
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
				    </td>
				</tr>
				<tr>
				    <td class="td1">居住地址：</td>
				    <td colspan="2"  class="td2">
					    <input class="easyui-combobox" id="fzd3"  style="width:420px;" 
					    value="${entity.dz_jzdzmlpxz}" 
					    data-options="required:false,mode:'remote'    
					    ,method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,onSelect:function(param){
						yzqk(param);}">
				    	<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				    	<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/>
				    </td>
				    <td class="td2" align="right">
					    <input class="easyui-combobox"  id="fzd4" style="width:240px;" 
					    value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}' 
					    data-options="required:false,mode:'remote',method:'post'
					    ,panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jzdzdm' id="dz_jzdzdm" value="${entity.dz_jzdzdm}"/>
				    	<input type='hidden' name='dz_jzdzssxqdm' id="dz_jzdzssxqdm" value="${entity.dz_jzdzssxqdm}"/>
				    	<input type='hidden' name='dz_jzdzxz' id="dz_jzdzxz" value="${entity.dz_jzdzxz}"/>
				    </td>
				</tr>
				<tr>
				    <td class="td1">工作单位：</td>
				    <td colspan="3" class="td2">
				    	<input class="easyui-combobox"  type="text"  id="gzdws" name="gzdws"  value="${dwmc}"  maxlength="50"  style="width:670px;"
				    	data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',
				    	textField:'text',selectOnNavigation:false,required:false" />
				    	<input type="hidden"  id="dwid" name="dwid"   />
				    	<input type="hidden"  id="gzdw" name="gzdw"   />
				    </td>
				</tr>
				<tr>
				    <td class="td1">成员类别：</td>
				    <td  class="td2">
					    <input type="text" name="cylbdm" id="cylbdm" value="${entity.cylbdm}" 
					    class="easyui-combobox " style="width:240px;" data-options="required:false,url: contextPath + '/common/dict/BD_D_CYLB.js'
						,valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/>
				    </td>
				</tr>
				<tr>
				    <td class="td1">备注：</td>
				    <td colspan="3" class='td2'>
					    <textarea id="bz" name="bz" class="easyui-validatebox" rows="2" 
					    style="width:670px; height:52px;"
						data-options="validType:['maxLength[1000]']
						,invalidMessage:'备注不能超过1000个汉字，请重新输入！'
						,tipPosition:'left'">${entity.bz}</textarea>
				    </td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
			</table>
		</form>
	</body>
</html>