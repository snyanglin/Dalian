<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>从业人员</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
</head>

<div class="easyui-layout" data-options="fit:true">
	<div class="pphoto">
		<div>
			<img class="topPhoto" id="topPhotoid" width="162" height="200" alt="" />
		</div>
	</div>
	<div class="pinfo">
		<strong><span id="jbxx_xm">${syrk.xm }</span><span
			id="jbxx_cym"><c:if test="${syrk.cym != null}">（曾用名：${syrk.cym}）</c:if>
		</span>
		</strong>
		<ul>
			<li>
			  <span>性别：</span>
			  <span id="jbxx_xbdm">
			      <script type="text/javascript">document.write(window.top.getDictName(contextPath+ '/common/dict/D_BZ_XB.js', "${syrk.xbdm}"));
			     </script>
			  </span>&nbsp;&nbsp;&nbsp;&nbsp; <span>出生日期：</span><span id="jbxx_csrq">${syrk.csrq}</span>&nbsp;&nbsp;&nbsp;&nbsp;
			  <span>民族：</span>
			   <span id="jbxx_mzdm">
			     <script type="text/javascript">
					document.write(window.top.getDictName(contextPath
					+ '/common/dict/D_BZ_MZ.js', "${syrk.mzdm}"));
				</script>
			  </span>
			</li>
			<li>
			  <span>
			  <script type="text/javascript">
					document.write(window.top.getDictName(contextPath
					+ '/common/dict/D_BZ_CYZJ.js', "${syrk.cyzjdm}"));
			  </script>&nbsp;：</span>${syrk.zjhm}
				&nbsp;&nbsp;&nbsp;&nbsp;
				<span>联系电话：</span>
				<span id="jbxx_lxdh">${syrk.lxdh}</span>
			</li>
			<li>
			   <span>居住地址：</span>
			   <span>${syrk.dz_jzdzxz }</span>
			</li>
			<li>
			   <span>服务处所：</span>
			   <span id="jbxx_fwcs">${syrk.fwcs }</span>
			</li>
		</ul>
	</div>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

$(document).ready(function(){
	document.getElementById("topPhotoid").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=${syrk.id}&zjhm=${syrk.zjhm}&cyzjdm=${syrk.cyzjdm}";
});
</script>