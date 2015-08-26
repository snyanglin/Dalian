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
				<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">重大火灾隐患整改通知书</span></div>
			</td>
		</tr>
		<tr class="dialogTr">
			<td style="text-align: right;">
				  <input type="text" name="gwh" value="${entity.gwh}" readonly="readonly" style="width: 60px;"/>
				    消<input type="text" name="xxh" value="${entity.xxh}" readonly="readonly" style="width: 60px;"/>
				  [<input type="text" name="bh" value="${entity.bh}" readonly="readonly" style="width: 60px;"/>]
				    第<input type="text" name="xh" value="${entity.xh}" readonly="readonly" style="width: 60px;"/>号&nbsp;&nbsp;
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
				<input type="text" id="dwmc"   value="${entity.dwmc}" readonly="readonly" style="width: 150px;" readonly="readonly"/>：
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　经消防监督检查，你单位存在下列重大火灾隐患，现责令你单位予以整改消除：
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　<textarea  name="hzyhnr"  style="width: 850px;height: 100px;" readonly="readonly">${entity.hzyhnr}</textarea>
			</td>
		</tr>
		<tr class="dialogTr">
			<td>
			　　火灾隐患消除前，你单位应当采取确保消防安全、防止火灾发生的措施。
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
