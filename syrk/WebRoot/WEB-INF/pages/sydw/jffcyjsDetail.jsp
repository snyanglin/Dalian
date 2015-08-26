<!--  
	@Author: [xu_haibo@founder.com]
	@CreateDate:   [2015-6-29 上午8:51:54]
-->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>复查意见书</title>
<style>
	td{
	  font-size:13px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjczg/saveJFfcyjs" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;">&nbsp;&nbsp;${entity.zzjgmc}&nbsp;&nbsp;公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">复查意见书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							文号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　　　　　
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							&nbsp;&nbsp;${entity.wh}&nbsp;&nbsp;
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　根据&nbsp;&nbsp;&nbsp;&nbsp;公技防限[
								&nbsp;&nbsp;${entity.xian}&nbsp;&nbsp;
								]第
								&nbsp;&nbsp;${entity.hao}&nbsp;&nbsp;
								号《责令限期整改通知书》，我局（分局）于
								&nbsp;&nbsp;${entity.jcrq}&nbsp;&nbsp;
								派员对你单位整改情况进行了复查。复查意见如下：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<textarea name="fcyj"  id="fcyj"  style="width: 815px;height: 60px;" class="easyui-validatebox">${entity.fcyj}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　（对逾期未改的违法行为，将依法予以处罚。你单位应当继续整改，并确保安全，防止发生事故。）
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　 （公安机关印章）
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							&nbsp;&nbsp;${entity.fsrq}&nbsp;&nbsp;
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　此联交被检查单位
						</td>
					</tr>
				</table>
				<table width="90%" height="147" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td  class="noprint" align="center">
							<a id="printButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">文书打印</span>
								<span class="l-btn-icon icon-save"> </span>
							</span>
							</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	var mainTabID = "${mainTabID}";
	function doInit(paramArray) {
		$("#dwid").val(paramArray["dwid"]);
		$("#jcid").val(paramArray["jcid"]);
		$("#dwmc").val(paramArray["dwmc"]);
		$.ajax({
			type:"POST",
			url: contextPath + "/dwjczg/queryXh",
			dataType:"json",
			success:function(data){
				$("#xh").val(data.xh);
			}
		});
	}
	function beforeSubmit() {
	}
	function afterSubmit(arr) {
	}
	//打印
	$('#printButton').click(function(){
		window.print();
	});
</script>