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
<title>责令限期整改通知书</title>
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
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" id="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>公安（分）局</span></div>
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
							<input type="text" id="wh"  name="wh"  value="${entity.wh}"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　根据&nbsp;&nbsp;&nbsp;&nbsp;公技防限[
								<input type="text" id="xian"   name="xian"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"/>]第
								<input type="text" id="hao"   name="hao"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"/>号《责令限期整改通知书》，我局（分局）于
								<input type="text" id="jcrq"  name="jcrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>派员对你单位整改情况进行了复查。复查意见如下：
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
						　　<input type="text" name="fsrq" id="fsrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　此联交被检查单位
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
		executeTabPageMethod(mainTabID, "queryButton()");
		if (arr["saveID"]) {
			window.open(contextPath + "/jfjczg/queryJFfcyjs?id="+arr["saveID"],"详情","height=554,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		}
	}
</script>