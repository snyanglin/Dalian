<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-18 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>临时查封决定书</title>
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
				<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">临时查封决定书</span></div>
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="text-align: right;">
				 <input type="text" name="gwh" value="${entity.gwh}" readonly="readonly" style="width: 60px;"/>
				    消<input type="text" name="xxh" value="${entity.xxh}" readonly="readonly" style="width: 60px;"/>
				  [<input type="text" name="bh" value="${entity.bh}" readonly="readonly" style="width: 60px;"/>]
				    第<input type="text" name="xh" value="${entity.xh}" readonly="readonly" style="width: 60px;" data-options="validType:['numeric[\'i\']', 'minLength[4]'],tipPosition:'left'" maxlength="4"/>号&nbsp;&nbsp;
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
				<input type="text" id="dwmc" value="${entity.dwmc}" readonly="readonly" style="width: 150px;"/>：
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="line-height: 2em;">
			　　我<input type="text" name="zzjgmc" value="${entity.zzjgmc}" readonly="readonly" style="width: 100px;"/>
			       于<input type="text" name="jcrq" value="${entity.jcrq}" readonly="readonly" style="width: 80px;"/>派员对你单位进行了消防监督检查，发现你单位（场所）
				<input type="text" name="hzyh" value="${entity.hzyh}" readonly="readonly" style="width: 100px;"/>存在下列火灾隐患，不及时消除将严重威胁公共安全：
			</td>
		</tr>
		<tr class="dialogTr">
			<td>　
				<textarea name="hzyhhg" style="width: 860px;height: 100px;" readonly="readonly">${entity.hzyhhg}</textarea>
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　根据《中华人民共和国消防法》
			</td>
		</tr>
		<tr class="dialogTr">
			<td>　
				<textarea name="xff" style="width: 860px;height: 100px;" readonly="readonly">${entity.xff}</textarea>
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　查封部位、场所范围：
			</td>
		</tr>
		<tr class="dialogTr">
			<td>　
				<textarea name="cffw" style="width: 860px;height: 100px;" readonly="readonly">${entity.cffw}</textarea>
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　查封期限：<input type="text" name="cf_qsrq" value="${entity.cf_qsrq}" readonly="readonly" type="text"  style="width:100px;"/>至
					<input type="text" name="cf_jsrq" value="${entity.cf_jsrq}" readonly="readonly" type="text"  style="width:100px;"/>
				逾期未消除火灾隐患的，不受查封期限的限制。
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="line-height: 2em;">
			　　你单位应当立即组织整改火灾隐患，整改后经我<input type="text" name="zzjgmc2" value="${entity.zzjgmc2}" readonly="readonly" style="width: 120px;"/>
			   检查合格方可解除查封。擅自拆封、使用被检查的部位或者场所，将依法予以处罚。
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="height: 40px;">&nbsp;
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