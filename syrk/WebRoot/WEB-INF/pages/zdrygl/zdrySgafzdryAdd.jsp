<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增涉公安访重点人员</title>
<script type="text/javascript"
	src="<%=contextPath%>/js/zdrygl/zdrySgafzdryAdd.js"></script>
</head>

<body style="margin-top: 20px; margin-bottom: 10px" class="bodybg">
	<div data-options="region:'center',split:true" style="border-width: 0px; margin: 0 0 0; text-align: center;"
		class="bodybg">

		<form id="dataForm" action="<%=basePath%>zdrySgafzdryGl/saveAdd" method="post" enctype="multipart/form-data">
			
			<input type="hidden" id="jbxx_hjd_dzms" name="ryRyjbxxb.hjd_dzms"  value="${addVO.ryRyjbxxb.hjd_dzms}"  /> 
			<input type="hidden" id="jbxx_hjd_xzqhdm" name="ryRyjbxxb.hjd_xzqhdm" value="${addVO.ryRyjbxxb.hjd_xzqhdm}" /> 
			<input type="hidden" id="jbxx_hjd_mlpdm" name="ryRyjbxxb.hjd_mlpdm" value="${addVO.ryRyjbxxb.hjd_mlpdm}" /> 
			<input type="hidden" id="jbxx_hjd_mlpxz" name="ryRyjbxxb.hjd_mlpxz" value="${addVO.ryRyjbxxb.hjd_mlpxz}" /> 
			<input type="hidden" id="jbxx_hjd_dzid" name="ryRyjbxxb.hjd_dzid" value="${addVO.ryRyjbxxb.hjd_dzid}" />
			<input type="hidden" id="jbxx_hjd_dzxz" name="ryRyjbxxb.hjd_dzxz" value="${addVO.ryRyjbxxb.hjd_dzxz}" /> 
			<input type="hidden" id="jbxx_hjd_pcsdm" name="ryRyjbxxb.hjd_pcsdm" value="${addVO.ryRyjbxxb.hjd_pcsdm}" />
			<input type="hidden" id="jbxx_cyzjdm" name="ryRyjbxxb.cyzjdm" value="111" />
			<input type="hidden" id="jbxx_id" name="ryRyjbxxb.id" value="${addVO.ryRyjbxxb.id}" />
			
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jbxx_zjhm"
							name="ryRyjbxxb.zjhm" value="${addVO.ryRyjbxxb.zjhm}"
							style="width: 200px; float: left;" maxlength="30"
							data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'"
							onblur="jbxx_zjhm_onblur()" />
						<div class="lodingimg" id="jbxxLoadDiv"></div>
					</td>
					
					<td width="20%" class="dialogTd" align="right" id="jbxx_xm_td">姓名：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jbxx_xm" name="ryRyjbxxb.xm"
							value="${addVO.ryRyjbxxb.xm}" style="width: 200px;" maxlength="50"
							data-options="tipPosition:'left',required:true" />
					</td>
				</tr>
				<!-- 基本信息补充 -->
				<tbody id="jbxxTbody">
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">性别：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="jbxx_xbdm"
							name="ryRyjbxxb.xbdm" value="${addVO.ryRyjbxxb.xbdm}" style="width: 200px;"
							data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'" /></td>
					</tr>
					
					<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">居住地：</td>
				    	<td width="50%" class="dialogTd" colspan="3">
					    	<input class="easyui-combobox" id="czrk_jzd1" style="width:380px;" value="${addVO.ryRyjbxxb.jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_jzd_mlpdm" name="ryRyjbxxb.jzd_mlpdm" value="${addVO.ryRyjbxxb.jzd_mlpdm}"/>
					    	<input type="hidden" id="czrk_jzd_mlpxz" name="ryRyjbxxb.jzd_mlpxz" value="${addVO.ryRyjbxxb.jzd_mlpxz}"/>
					    	&nbsp;&nbsp;
					    	<input class="easyui-combobox" id="czrk_jzd2" style="width:200px;" value='${fn:replace(addVO.ryRyjbxxb.jzd_dzxz, addVO.ryRyjbxxb.jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="czrk_jzd_dzid" name="ryRyjbxxb.jzd_dzid" value="${addVO.ryRyjbxxb.jzd_dzid}"/>
					    	<input type="hidden" id="czrk_jzd_xzqhdm" name="ryRyjbxxb.jzd_xzqhdm" value="${addVO.ryRyjbxxb.jzd_xzqhdm}"/>
					    	<input type="hidden" id="czrk_jzd_dzxz" name="ryRyjbxxb.jzd_dzxz" value="${addVO.ryRyjbxxb.jzd_dzxz}"/>
					    	<input type="hidden" id="czrk_jzd_zbx" name="zdrySgafzdryxxb.jzd_zbx" value="${addVO.zdrySgafzdryxxb.jzd_zbx}"/>
					    	<input type="hidden" id="czrk_jzd_zby" name="zdrySgafzdryxxb.jzd_zby" value="${addVO.zdrySgafzdryxxb.jzd_zby}"/>
				    	</td>
					</tr>
					
					<tr class="dialogTr">
						<td width="100%" colspan="4">
							<div id="saveDiv" style="text-align: center; height: 50px; padding-top: 10px; display: display;">
								<a id="saveButton" class="l-btn l-btn-small"
									href="javascript:void(0)" group="" onclick="saveForm()"> <span
									class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">保存</span>
										<span class="l-btn-icon icon-save"> </span>
								</span>
								</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="resetButton"
									class="l-btn l-btn-small" href="javascript:void(0)" group=""
									onclick="resetForm()"> <span class="l-btn-left l-btn-icon-left">
										<span class="l-btn-text">重置</span> <span
										class="l-btn-icon icon-reset"> </span>
								</span>
								</a>
							</div>
						</td>
					</tr>
				</tbody>
		</form>
	</div>
</body>
</html>