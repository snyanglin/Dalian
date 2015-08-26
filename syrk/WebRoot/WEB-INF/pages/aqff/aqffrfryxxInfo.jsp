<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-6-14 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript">
			var mainTabID="${mainTabID}";
			var states="${states}";
			var dwmc="${dwmc}";
		</script>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/syrk.css"></link>
		<script type="text/javascript" src="<%=contextPath%>/js/aqff/rfxx/aqffrfryxxInfo.js"></script>
		<title>人防人员信息</title>
		<style>
			.table{
			font-size:12px;
			background: #FFFFFF;
			}
			.td1{ text-align:right;
			width:10%;
			height:auto
			}
			.td2{ text-align:left;
			width:30%;
			height:auto
			}
		</style>
	</head>
	<body style="margin-top:20px">
		<div id="win" data-options="region:'center', split:true" style="border-width: 0px;
		margin:0 0 0 0;text-align:center;" >
		<form id="rfryxxForm" method="post">
			<input type="hidden" id="id" name="id" value="${entity.id}" />
			<input type="hidden" id="rfid" name="rfid" value="${rfid}" />
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<tr>
				    <td class="td1">证件种类：</td>
				    <td class="td2">
					    <script type="text/javascript">
					    	document.write(window.top.getDictName(contextPath + '/common/dict/KX_D_CYZJDM.js', "${entity.zjlxdm}"));
					    </script>
				    </td>
				    <td class="td1">证件号码：</td>
				    <td  class="td2">
				    	${entity.zjhm}
					</td>
				</tr>
				<tr>
				    <td class="td1">姓名：</td>
				    <td class="td2">
				    ${entity.xm}
				    </td>
				    <td class="td1">性别：</td> 
				    <td  class="td2">
				    	<script type="text/javascript">
				    		document.write(window.top.getDictName(contextPath + '/common/dict/D_BZ_XB.js', "${entity.xbdm}"));
				    	</script>
				    </td>
				</tr>
				<tr>
				    <td class="td1">文化程度：</td>
				    <td class="td2">
				    	<script type="text/javascript">
				    		document.write(window.top.getDictName(contextPath + '/common/dict/QBLD_D_WHCD.js', "${entity.whcddm}"));
				    	</script>
				    </td>
				    <td class="td1">政治面貌：</td>
				    <td class="td2">
				    	<script type="text/javascript">
				    		document.write(window.top.getDictName(contextPath + '/common/dict/D_BZ_ZZMM.js', "${entity.zzmmdm}"));
				    	</script>
				    </td>
				</tr>
				<tr>
				   <td class="td1">人员来源：</td>
				    <td class="td2">
							<script type="text/javascript">
								document.write(window.top.getDictName(contextPath + '/common/dict/D_AQFF_RYLYDM.js', "${entity.rylydm}"));
							</script>
				    </td>
				    <td class="td1">组织内职务：</td>
				    <td class="td2">
				    	${entity.zznzw}
				    </td>
				</tr>
				<tr>
				    <td class="td1">联系方式：</td>
				    <td class="td2">
				    	${entity.lxfs}
				    </td>
				    <td class="td1">参加时间：</td>
				    <td class="td2">
				    	${entity.cjsj}
				    </td>
				</tr>
				<tr>
					<td class="td1">居住地址：</td>
				    <td colspan="2"  class="td2">
					    ${entity.dz_jzdzmlpxz}
				    	<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				    	<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/>
				    </td>
				    <td class="td2" align="right">
					    ${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}
				    	<input type='hidden' name='dz_jzdzdm' id="dz_jzdzdm" value="${entity.dz_jzdzdm}"/>
				    	<input type='hidden' name='dz_jzdzssxdm' id="dz_jzdzssxdm" value="${entity.dz_jzdzssxqdm}"/>
				    	<input type='hidden' name='dz_jzdzxz' id="dz_jzdzxz" value="${entity.dz_jzdzxz}"/>
				    </td>
				</tr>
				<tr>
				    <td class="td1">工作单位：</td>
				    <td colspan="3" class="td2" >${entity.gzdw}</td>
				</tr>
				<tr>
				    <td class="td1">成员类别：</td>
				    <td  class="td2">
				    	<script type="text/javascript">
				    		document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_CYLB.js', "${entity.cylbdm}"));
				    	</script>
				    </td>
				</tr>
				<tr>
				    <td class="td1">备注：</td>
				    <td colspan="3" class='td2'>
				    	${entity.bz}
				    </td>
				</tr>
				<tr>
			    	<td colspan="4">&nbsp;</td>
				</tr>
			</table>
		</form>
	</body>
</html>