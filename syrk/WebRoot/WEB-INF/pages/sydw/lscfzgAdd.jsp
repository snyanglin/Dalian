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
<title>临时查封决定书</title>
<style>
	td{
	  font-size:13px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>dwjczg/saveLscftzs" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">临时查封决定书</span></div>
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
							<input type="text" id="dwmc" name="dwmc" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 150px;border-color: #333333;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　我<input type="text" name="zzjgmc" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"/>
						       于<input type="text" name="jcrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 80px;border-color: #333333;"
						    data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>派员对你单位进行了消防监督检查，发现你单位（场所）
							<input type="text" name="hzyh" class="easyui-validatebox" style="text-align:center;line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"/>存在下列火灾隐患，不及时消除将严重威胁公共安全：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>　
							<textarea name="hzyhhg" style="width: 810px;height: 100px;" class="easyui-validatebox"></textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　根据《中华人民共和国消防法》
						</td>
					</tr>
					<tr class="dialogTr">
						<td>　
							<textarea name="xff" style="width: 810px;height: 100px;" class="easyui-validatebox"></textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　查封部位、场所范围：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>　
							<textarea name="cffw" style="width: 810px;height: 100px;" class="easyui-validatebox"></textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　查封期限：<input type="text" name="cf_qsrq" class="easyui-validatebox" type="text"  style="text-align:center;width:100px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'cf_jsrq\') }'})"/>至
								<input type="text" name="cf_jsrq" class="easyui-validatebox" type="text"  style="text-align:center;width:100px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'cf_qsrq\') }'})"/>
							逾期未消除火灾隐患的，不受查封期限的限制。
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　你单位应当立即组织整改火灾隐患，整改后经我<input type="text" name="zzjgmc2" class="easyui-validatebox" style="text-align:center;line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;width: 120px;"/>
						   检查合格方可解除查封。擅自拆封、使用被检查的部位或者场所，将依法予以处罚。
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="height: 40px;">&nbsp;
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
			window.open(contextPath + "/dwjczg/queryLscftzs?id="+arr["saveID"],"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		}
	}
</script>