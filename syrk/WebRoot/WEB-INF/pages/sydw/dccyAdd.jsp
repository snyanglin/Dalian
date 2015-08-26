<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-7-8 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
var mainTabID="${mainTabID}";
function chengescd(obj){
	if(obj=='zs'){
		$('#cd1').show();
		$('#cd2').hide();
		$("#jia").validatebox({required:true});
		$("#bfb").validatebox({required:true});
		$("#zs").validatebox({required:false});
		$("#gjz").validatebox({required:false});
	}
	if(obj=='gjz'){
		$('#cd1').hide();
		$('#cd2').show();
		$("#jia").validatebox({required:false});
		$("#bfb").validatebox({required:false});
		$("#zs").validatebox({required:true});
		$("#gjz").validatebox({required:true});
	}
}
function doInit(paramArray) {
	var bfb = paramArray["bfb"];
	$("#bfb").val(bfb);
	$("#bfb").validatebox({required:true});
}
//原有功能不可删除
function beforeSubmit() {
}
//原有功能不可删除
function afterSubmit(arr) {
	parent.reloadDg();
}
function chengeccfs(fs){
	$('#ccfs').val(fs);
}
</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>抽样</title>
		<style type="text/css">
			.title{
				font-size:12px;color: #0e2d5f;background:#eaf2ff;font-weight: bold;
				border-top: 1px  #95B8E7 solid;border-bottom: 1px  #95B8E7 solid;
			}
			.td-solid{
				border-left:1px  #ccc solid;
				border-bottom: 1px  #ccc solid;
				border-right: 1px  #ccc solid;
				background:#efefef;
				text-align: right;
			}
			.td-bottom{
				border-bottom: 1px  #ccc dotted;
				text-align: left;
			}
				.td-left-bottom{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc solid;
			}
			.td-lb-dotted{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc dotted;
				text-align: center;
				color:blue;
				width:130px;
			}
		</style>
	</head>
<body style="overflow: hidden;">   
<form action="<%=basePath%>cyjh/saveXfdwcyxxb" id="dataForm" name="dataForm" method="post">
	<input name="xfdwcccsxxbid" id="xfdwcccsxxbid"  type="hidden"  value="${entitycs.id}" />
	<table  border="0" cellpadding="0" cellspacing="0"  width="100%" align="center"   style="height: 180px" >
		<tr>
			<td class="td-solid"  width="150px">
				全年应检查单位：
			</td>
			<td class="td-bottom" colspan="3" height="30px">
				&nbsp;总数<font color="red">${entitycs.zs }</font>家,重点<font color="red">${entitycs.zddws }</font>家,一般<font color="red">${entitycs.fzddws }</font>家
			</td>
		</tr>
		<tr>
			<td  class="td-solid" width="150px">
				选择实施时间范围：
			</td>
			<td class="td-bottom" colspan="3">
				&nbsp;<input type="text" id="ccsjks" name="ccsjks" class="easyui-validatebox"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'ccsjjs\') }'})"
				data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'" style="width:120px"/>
				--
				<input type="text" id="ccsjjs" name="ccsjjs" class="easyui-validatebox" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'ccsjks\') }'})"
				data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'" style="width:120px"/>
			</td>
		</tr>
		<tr>
			<td  class="td-solid" width="150px">
				抽查分级范围：
			</td>
			<td class="td-bottom" colspan="3">
				 <input type="radio" name="jbdw" value="1"  checked="checked"/>只在本级单位中抽
			</td>
		</tr>
		<tr>
			<td  class="td-solid" width="150px">
				选择单位抽查方式：
			</td>
			<td  class="td-bottom" colspan="3">
				<input name="ccfs" id="ccfs" value="1"  type="hidden"/>
				<input type="radio" name="ccdwfs" value="1"  checked="checked" onclick="chengeccfs(1)"/>只在未抽单位中抽
				<input type="radio" name="ccdwfs" value="2"  onclick="chengeccfs(2)"/>在全部单位中抽
				<input type="radio" name="ccdwfs" value="3"  onclick="chengeccfs(3)"/>先在未抽单位中抽，再在已抽单位中抽
			</td>
		</tr>
		<tr>
			<td  class="td-solid" width="150px" height="60px">
				<input type="radio" id="cdan" name="cdan" value="0"  onclick="chengescd('zs')" checked="checked"/>按&nbsp;单&nbsp;位&nbsp;总&nbsp;数<br>
				<input type="radio" id="cdan" name="cdan" value="1"  onclick="chengescd('gjz')"  />按&nbsp;照&nbsp;关&nbsp;键&nbsp;字
			</td>
			<td  class="td-bottom" colspan="3"  id="cd1">
				&nbsp;<input type="text" name="jia" id ="jia" class="easyui-validatebox" data-options="required:true,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'" maxlength="50"
										style="width:60px;"/>
										家，本次抽查重点单位抽查比例
				<input type="text" name="bfb" id ="bfb" class="easyui-validatebox" data-options="validType:['numericRange[\'f\',0,0,100]'],tipPosition:'right'" maxlength="50"
										style="width:50px;"/>%
			</td>
			<td  colspan="3"   id="cd2" style="display: none">
				&nbsp;请输入单位名称关键字：
				<input type="text" name="gjz" id ="gjz" class="easyui-validatebox" data-options="required:false,tipPosition:'right'" maxlength="50" style="width:100px;"/>
				（如：网吧，学校等单位名称关键字）<br>
				&nbsp;请输入抽查单位的总数：
				<input type="text" name="zs" id ="zs" class="easyui-validatebox" data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'" maxlength="50" style="width:100px;"/>&nbsp;&nbsp;家
			</td>
		</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center"   style="height: 90px">
		<tr>
			<td colspan="5" class="title">
				&nbsp;辖区现已录入单位数
			</td>
		</tr>
		<tr bgcolor="#efefef"  align="center">
			<td style="border-bottom: 1px  #ccc solid;">
				重点单位
			</td>
			<td class="td-left-bottom">
				一般单位
			</td>
			<td class="td-left-bottom">
				九小类单位
			</td>
			<td class="td-left-bottom">
				其他单位
			</td>
			<td class="td-left-bottom">
				总计
			</td>
		</tr>
		<tr  align="center">
			<td style="color: blue;border-bottom: 1px  #ccc dotted;"  align="center">${entitydws.zddws }
			</td>
			<td class="td-lb-dotted">${entitydws.ybdws }
			</td>
			<td class="td-lb-dotted">${entitydws.jxcss }
			</td>
			<td class="td-lb-dotted">${entitydws.qtdws }
			</td>
			<td class="td-lb-dotted">${entitydws.zddws+entitydws.ybdws+entitydws.jxcss+entitydws.qtdws }
			</td>
		</tr>
	</table>
</form>
</body>  
</html>
