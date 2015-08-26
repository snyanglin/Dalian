<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-18 上午8:51:54]
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
<title>重大火灾隐患整改通知书</title>
<style>
	td{
	  font-size:13px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>dwjczg/saveZdhzyhzgtzs" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">重大火灾隐患整改通知书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							  <input type="text" name="gwh" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 60px;border-color: #333333;"/>
							    消<input type="text" name="xxh" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 60px;border-color: #333333;"/>
							  [<input type="text" name="bh" value="<%=year%>" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 60px;border-color: #333333;"/>]
							    第<input type="text" id="xh" name="xh" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 60px;border-color: #333333;" data-options="validType:['numeric[\'i\']', 'minLength[4]'],tipPosition:'left'" maxlength="4"/>号&nbsp;&nbsp;
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="text" id="dwmc" name="dwmc" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 150px;border-color: #333333;" readonly="readonly"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　经消防监督检查，你单位存在下列重大火灾隐患，现责令你单位予以整改消除：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<textarea  name="hzyhnr"  style="width: 815px;height: 100px;" class="easyui-validatebox"></textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　火灾隐患消除前，你单位应当采取确保消防安全、防止火灾发生的措施。
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　被检查单位负责人（签名）：<input type="text" name="dwfzrqm" class="easyui-validatebox" style="text-align:center;line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"/>　　
						   <input type="text" name="dwfzrqmrq" class="easyui-validatebox" type="text"  style="text-align:center;width:100px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
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
			window.open(contextPath + "/dwjczg/queryZdhzyhzgtzs?id="+arr["saveID"],"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		}
	}
</script>