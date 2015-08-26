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
		<form action="<%=basePath%>jfjczg/saveJfzlzgtzs" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">责令限期整改通知书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							文号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　　　　　
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="text" id="wh" name="wh"   value="${entity.wh}"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　根据《辽宁省公共安全技术防范条例》，我局（分局）于
								<input type="text"  id="jcrq" name="jcrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>派员对你（单位）进行了公共安全技术防范监督检查，发现下列违反公共安全技术防范法律行为：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<textarea  id="wfnr"  name="wfnr" style="width: 815px;height: 60px;" class="easyui-validatebox">${entity.wfnr}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　请你（单位）在
								<input type="text" id="gzrq" name="gzrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>日前改正，并在期限届满前将整改情况函告
								<input type="text" id="hgnr" name="hgnr"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;"/>：
								逾期不改正的，将依法予以处罚。联系电话：
								<input type="text" id="lxdh"   name="lxdh"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;"/>：
								在此期间你（单位）应当采取措施，确保不发生各类事故。
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　 （公安机关印章）
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<input type="text" name="fsrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
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
		alert(arr["saveID"]);
		if (arr["saveID"]) {
			window.open(contextPath + "/jfjczg/queryJfzlzgtzs?id="+arr["saveID"],"详情","height=554,width=1054,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		}
	}
</script>