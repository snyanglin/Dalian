<!--  
	@updateAuthor: [yuguangli@founder.com]
	@updateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消防安全违法行为</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_1" type="checkbox" value="1" />1.未依法进行<input id="1_1" type="checkbox" value="1_1" />消防设计备案/<input id="1_1" type="checkbox" value="1_2" />竣工验收消防备案；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_2" type="checkbox" value="2" />2.消防设施、器材、消防安全标志<input id="2_1" type="checkbox" value="2_1" />配置、设置不符合标准/<input id="2_1" type="checkbox" value="2_2" />未保持完好有效；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_3" type="checkbox" value="3" />3.<input id="3_1" type="checkbox" value="3_1" />损坏/<input id="3_1" type="checkbox" value="3_2" />挪用/<input id="3_1" type="checkbox" value="3_3" />擅自拆除消防设施、器材；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_4" type="checkbox" value="4" />4.<input id="4_1" type="checkbox" value="4_1" />占用/<input id="4_1" type="checkbox" value="4_2" />堵塞/<input id="4_1" type="checkbox" value="4_3" />封闭疏散通道、安全出口；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_5" type="checkbox" value="5" />5.<input id="5_1" type="checkbox" value="5_1" />埋压/<input id="5_1" type="checkbox" value="5_2" />圈占/<input id="5_1" type="checkbox" value="5_3" />遮挡消火栓/<input id="5_1" type="checkbox" value="5_4" />占用防火间距；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_6" type="checkbox" value="6" />6.<input id="6_1" type="checkbox" value="6_1" />占用/<input id="6_1" type="checkbox" value="6_2" />堵塞/<input id="6_1" type="checkbox" value="6_3" />封闭消防车通道，妨碍消防车通行；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_7" type="checkbox" value="7" />7.人员密集场所外墙门窗上设置影响逃生、灭火救援的障碍物；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_8" type="checkbox" value="8" />8.使用<input id="8_1" type="checkbox" value="8_1" />不符合市场准入/<input id="8_1" type="checkbox" value="8_2" />不合格/<input id="8_1" type="checkbox" value="8_3" />国家明令淘汰的消防产品；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_9" type="checkbox" value="9" />9.<input id="9_1" type="checkbox" value="9_1" />电器产品/<input id="9_1" type="checkbox" value="9_2" />燃气用具的安装、使用及其线路、管路的设计、敷设、维护保养、检测不符合消防技术标准和管理规定；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_10" type="checkbox" value="10" />10.不履行《中华人民共和国消防法》<input id="10_1" type="checkbox" value="10_1" />第十六条/<input id="10_2" type="checkbox" value="10_2" />第十七条/<input id="10_3" type="checkbox" value="10_3" />第十八条/<input id="10_4" type="checkbox" value="10_4" />第二十一条第二款规定的其他消防安全职责；</td>
				</tr>
				<tr class="dialogTr">
					<td width="100%" class="dialogTd" align="left"><input id="ch_11" type="checkbox" value="11" />11.其他消防安全违法行为和火灾隐患。</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	var parentWindow = null;
	var parentWindow = null;
	var windowID = null;
	var codeInputID = null;
	var codeInputID1 = null;
	var vals = "${vals}";
	var vals1 = "${vals1}";
	function doInit(paramArray) {
		parentWindow = null;
		parentWindow = paramArray['parentWindow'];
		windowID = paramArray['windowID'];
		codeInputID = paramArray['codeInputID'];
		codeInputID1 = paramArray['codeInputID1'];
		var valstrs = vals.split(",");
		for(var i=0;i<valstrs.length;i++){
			$("#ch_"+valstrs[i]).attr("checked","checked");
		}
		var valstrs1 = vals1.split(",");
		for(var i=0;i<valstrs1.length;i++){
			var v = valstrs1[i];
			var nv = v.substring(0, v.length-1) + "1";
			$("input[type=checkbox][id='"+nv+"'][value='"+v+"']").attr("checked","checked");
		}
	}
	
	//多选框模拟 单选
	function checkboxToRadio() {
		checkboxs = $("input:checkbox");
		for (i = 0; i < checkboxs.length; i++) {
			checkboxs[i].onclick = function() {
				for (j = 0; j < checkboxs.length; j++) {
					if (this.id == checkboxs[j].id && this.value != checkboxs[j].value && checkboxs[j].checked == true) {
						checkboxs[j].checked = false;
					}
				}
			};
		};
	};
	checkboxToRadio();
	
	function ok_execute() {
		var checkboxs = $("input:checkbox[id^='ch_']:checked");
		var val = "";
		var vals = "";
		checkboxs.each(function(index, domEle) {
			val += $(domEle).val() + ",";
			var boxs = $("input:checkbox[id^='"+$(domEle).val()+"_']:checked");
			boxs.each(function(index, domEle) {
				vals += $(domEle).val() + ",";
			});
		});
		alert(vals)
		if(val!=""){
			val = val.substring(0, val.length-1);
		}
		if(vals!=""){
			vals = vals.substring(0, vals.length-1);
		}
		if(codeInputID){
			parentWindow.document.getElementById(codeInputID).value = val;
		}
		if(codeInputID1){
			parentWindow.document.getElementById(codeInputID1).value = vals;
		}
	}

	function clear_execute() {
		if (codeInputID) {
			parentWindow.document.getElementById(codeInputID).value = "";
		}
		if (codeInputID1) {
			parentWindow.document.getElementById(codeInputID1).value = "";
		}
	}
</script>