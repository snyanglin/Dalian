<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-18 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>责令改正通知书</title>
<style>
	td{
	  font-size:13px;
	}
	@media print{
	  .noprint{display:none;color:green}
	}
	input{
		text-align:center;border-top: 1px;border-left: 1px;border-right: 0px;border-bottom: 1px solid #333333;
	}
</style>
</head>
<body>
	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
	<input type="hidden" name="id" id="pk" value="${entity.id}" />
	<table border="0" cellpadding="0" cellspacing="6" width="900px" align="center" style="font-size: 26px;">
		<tr class="dialogTr">
			<td>
				<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">责令改正通知书</span></div>
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="text-align: right;">
				编号：<input type="text" name="bh" value="${entity.bh}"  readonly="readonly" style="width: 60px;"/>
				　<input type="text" name="xh" value="${entity.xh}" readonly="readonly" style="width: 60px;"/>&nbsp;&nbsp;　　　　
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
				<input type="text" id="dwmc" value="${entity.dwmc}" readonly="readonly" style="width: 150px;"/>：
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="line-height: 2em;">
			　　根据《中华人民公共和国消防法》第五十三条的规定，我<input type="text" name="zzjgmc" value="${entity.zzjgmc}" readonly="readonly"/>
			      于<input type="text" name="jcrq" value="${entity.jcrq}" readonly="readonly" style="width: 80px;"/>对你单位(场所)进行消防监督检查，发现存在下列第
			   <input type="text" id="zlljzgx" name="zlljzgx" value="${entity.zlljzgx}" readonly="readonly" style="width: 100px;"/> 项消防安全违法行为：
			   <input type="hidden" id="zlljzgx_xx" value="${entity.zlljzgx_xx}"/>
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
				<table border="0" cellpadding="0" cellspacing="10" width="95%" align="center">
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
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="height: 60px;" valign="top">
			　　具体问题：${entity.hzyh}
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　对上述第<input type="text" name="zgx" value="${entity.zgx}" readonly="readonly" style="width: 100px;"/>项，责令于
			   <input type="text" name="zgxzgrq" value="${entity.zgxzgrq}" readonly="readonly" type="text"  style="width:120px;"/>前改正。
			</td>
		</tr>
		<tr>
			<td style="height: 20px;">
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　被检查单位负责人（签名）：<input type="text" name="dwfzrqm" value="${entity.dwfzrqm}" readonly="readonly" style="width: 120px;"/>　　
			   <input type="text" name="dwfzrqmrq" value="${entity.dwfzrqmrq}" readonly="readonly" type="text"  style="width:150px;"/>
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
</body>
</html>
<script type="text/javascript">
	function doInit(paramArray) {
	}
	function beforeSubmit() {
	}

	function afterSubmit(arr) {
	}
	//打印
	$('#printButton').click(function(){
		window.print();
	});
	$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
		$(o).attr("disabled","disabled");
	});
	var vals = $("#zlljzgx").val();
	var valstrs = vals.split(",");
	for(var i=0;i<valstrs.length;i++){
		$("#ch_"+valstrs[i]).attr("checked","checked");
	}
	var vals1 = $("#zlljzgx_xx").val();
	var valstrs1 = vals1.split(",");
	for(var i=0;i<valstrs1.length;i++){
		var v = valstrs1[i];
		var nv = v.substring(0, v.length-1) + "1";
		$("input[type=checkbox][id='"+nv+"'][value='"+v+"']").attr("checked","checked");
	}
</script>