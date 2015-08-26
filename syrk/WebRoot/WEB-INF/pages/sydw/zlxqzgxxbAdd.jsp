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
<title>责令改正通知书</title>
<style>
	td{
	  font-size:13px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>dwjczg/saveZlzgtzs" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">责令改正通知书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							编号：<input type="text" name="bh" value="<%=year%>" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 60px;border-color: #333333;"/>
							　<input type="text" id="xh" name="xh" value="${entity.xh}" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 60px;border-color: #333333;" data-options="validType:['numeric[\'i\']', 'minLength[4]'],tipPosition:'left'" maxlength="4"/>&nbsp;&nbsp;　　　　
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="text" id="dwmc" name="dwmc" class="easyui-validatebox" readonly="readonly" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 150px;border-color: #333333;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　根据《中华人民公共和国消防法》第五十三条的规定，我<input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"/>
							于<input type="text" name="jcrq" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>对你单位
						   <input type="text" name="zgnr" value="${entity.zgnr}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>进行消防监督检查，发现你单位有违反消防法律、法规的下列行为：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="hidden" id="zlljzgx_xx" name="zlljzgx_xx"/>
						　　对以下第<input type="text" id="zlljzgx" name="zlljzgx" value="${entity.zlljzgx}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;text-align: center;" readonly="readonly"/>项
							<input type="button" id="orgbutton1" value="消防安全违法行为" onClick="multiSelect('zlljzgx', 'zlljzgx_xx', '', window)" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 110px;font-family:宋体;font-size:9pt;" />
							，责令立即改正。
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="hidden" id="zgx_xx"/>
						　　对以下第<input type="text" id="zgx" name="zgx" value="${entity.zgx}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;text-align: center;" readonly="readonly"/>项
							<input type="button" id="orgbutton1" value="消防安全违法行为" onClick="multiSelect('zgx', 'zgx_xx', '', window)" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 110px;font-family:宋体;font-size:9pt;" />
							，责令于
						   <input type="text" name="zgxzgrq" value="${entity.zgxzgrq}" class="easyui-validatebox" type="text"  style="text-align:center;width:120px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>前改正。
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　对下列火灾隐患，责令于<input type="text" name="hzyhzgrq"  value="${entity.hzyhzgrq}" class="easyui-validatebox" type="text"  style="text-align:center;width:120px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>前消除：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<textarea name="hzyh" style="width: 815px;height: 60px;" class="easyui-validatebox">${entity.hzyh}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　被检查单位负责人（签名）：<input type="text" name="dwfzrqm" value="${entity.dwfzrqm}" class="easyui-validatebox" style="text-align:center;line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>　　
						   <input type="text" name="dwfzrqmrq" value="${entity.dwfzrqmrq}" class="easyui-validatebox" type="text"  style="text-align:center;width:120px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　消防监督检察院（签名）：　<input type="text" name="jcryqm" value="${entity.jcryqm}" class="easyui-validatebox" style="text-align:center;line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;width: 120px;"/>　　
						   <input type="text" name="jcryqmrq" value="${entity.jcryqmrq}" class="easyui-validatebox" type="text"  style="text-align:center;width:120px;border-top: 0px;border-left: 0px;border-right: 0px;border-color: #333333;"
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
			window.open(contextPath + "/dwjczg/queryZlzgtzs?id="+arr["saveID"],"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		}
	}
	
	
	function multiSelect(codeInputID, codeInputID1, windowID, parentWindow) {
		if (!windowID) {
			var myTime = (new Date()).getTime();
			windowID = "win_" + myTime;
		}
		if ("undefined" == typeof onOkMethod || onOkMethod == null) {
			onOkMethod = "";
		}
		var vals = $("#"+codeInputID).val();
		var vals1 = $("#"+codeInputID1).val();
		var openURL = contextPath + "/forward/sydw|xfaqwfxwList?vals="+vals+"&vals1="+vals1;
		var paramArray = [];
		paramArray['parentWindow'] = parentWindow;
		paramArray['codeInputID'] = codeInputID;
		paramArray['codeInputID1'] = codeInputID1;
		var dataOptions = {
			title: '&nbsp;消防安全违法行为',
			width: 800,   
		    height: 400,  
			collapsible: false, 
			minimizable: false, 
			maximizable: false,
			closable: true,
		    closed: false,    
		    cache: false,
		    inline: false,
		    modal: true
		};
		dataOptions.buttons = [
			{
				text: '确定',
				iconCls: 'icon-ok',
				handler: function() {
					var iframeObject = window.frames[windowID + '_iframe'];
					if (iframeObject.contentWindow) {
						iframeObject = iframeObject.contentWindow;
					}
					iframeObject.ok_execute();
					$('#' + windowID).dialog('close');
				}
			},
			{
				text: '清空',
				iconCls: 'icon-remove',
				handler: function() {
					var iframeObject = window.frames[windowID + '_iframe'];
					if (iframeObject.contentWindow) {
						iframeObject = iframeObject.contentWindow;
					}
					iframeObject.clear_execute();
					$('#' + windowID).dialog('close');
				}
			},
			{
				text: '关闭',
				iconCls: 'icon-cancel',
				handler: function() {
					$('#' + windowID).dialog('close');
				}
			}
		];
		openWindow("", windowID, openURL, paramArray, dataOptions);
	}
</script>