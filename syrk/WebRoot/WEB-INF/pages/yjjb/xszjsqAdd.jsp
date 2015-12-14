<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String userId = userInfo.getUserId();
	String userName = userInfo.getUserName();
	String orgCode = userInfo.getUserOrgCode();
	String orgName = userInfo.getUserOrgName();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增线索征集申请</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<style type="text/css">
.colli {
	margin: 0;
	padding: 0;
	margin-left: 10px;
	margin-top: 10px;
	border-left: #0266b7 2px solid;
}

.colli li {
	list-style: none;
	margin: 0;
	pause: 0;
	text-align: left;
	background-repeat: no-repeat;
	background-position: top left;
	background-image: url("<%=contextPath%>/images/edit/timeIco.png");
	padding-left: 20px;
	margin-bottom: 30px;
	margin-left: -8px;
}
</style>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body class="easyui-layout"
	data-options="fit:true">
	<div data-options="region:'center', split:true"
		style="border-width: 0px;margin:0 0 0;text-align:center;"
		class="bodybg">
		<div style="margin:0px auto;width:1200px;">
			<div style="width:880px;float:left;">
				<table height="100%" style="margin:0 auto;">

					<tr>
						<td height="100%" valign="top" align="center">
							<div class="pop_conta">
								<div class="pop_contb">
									<div class="pop_contc">

										<form action="<%=basePath%>xszjxxb/save" id="xszjForm"
											name="xszjForm" method="post">
											<div data-options="region:'center', split:true"
												style="width:880px; border-width: 0px;">

												
												<br> <input type="hidden" id="id" name="id"
													value="${entity.id}" />
												<table border="0" cellpadding="0" cellspacing="10"
													width="100%" align="center">
													<tr class="dialogTr">
														<td width="100" class="dialogTd" align="right">申请人：</td>
														<td width="300" class="dialogTd"><select
															class="easyui-combobox" id="sqr" name="sqr"
															style="width:300px;"
															data-options="required:true, selectOnNavigation:false,method:'get'"
															readonly>
																<!--  <option value="${entity.sqr}" text = "2222222222" selected></option>-->
														</select></td>
														<td width="130"  class="dialogTd" align="right">申请时间：</td>
														<td width="300"  class="dialogTd"><input
															class="easyui-validatebox" type="text" id="sqsj"
															name="sqsj" value="${entity.sqsj}" style="width:300px;"
															data-options="required:true,validType:['date[\'yyyy-MM-dd HH:mm:ss\']'],tipPosition:'right'"
															onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
														</td>
													</tr>
													<tr class="dialogTr">
														<td  class="dialogTd" align="right">案件性质：</td>
														<td  class="dialogTd"><input
															class="easyui-combobox" id="ajxz" name="ajxz"
															value="${entity.ajxz}" style="width:300px;"
															data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
														</td>
														<td  class="dialogTd" align="right">联系方式：</td>
														<td  class="dialogTd"><input
															class="easyui-validatebox" type="text" id="sqrlxfs"
															name="sqrlxfs" value="${entity.sqrlxfs}" maxlength="1000"
															style="width:300px;"
															data-options="required:true,validType:['phone'],tipPosition:'right'" />
														</td>
													</tr>
													<tr class="dialogTr">
														<td class="dialogTd" align="right">申请单位：</td>
														<td  class="dialogTd" colspan="3"><input
															class="easyui-combobox" id="sqdw" name="sqdw"
															value="${entity.sqdw}" maxlength="100"
															style="width:750px;"
															data-options="required:true,
				    		url: contextPath + '/common/queryOrg',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"
															readonly /></td>
													</tr>
													</tr>
													<tr class="dialogTr">
														<td  class="dialogTd" align="right" valign="top">简要案情：</td>
														<td class="dialogTd" colspan="3"><textarea
																class="easyui-validatebox" id="jyaq" name="jyaq"
																maxlength="1000" style="width:750px;height:48px"
																data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'简要案情不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jyaq}</textarea>
														</td>
													</tr>
													<tr class="dialogTr">
														<td  class="dialogTd" align="right" valign="top">征集线索信息：</td>
														<td  class="dialogTd" colspan="3"><textarea
																class="easyui-validatebox" id="zjdxsxx" name="zjdxsxx"
																maxlength="1000" style="width:750px;height:48px"
																data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'征集线索信息不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zjdxsxx}</textarea>
														</td>
													</tr>
													<tr class="dialogTr">
														<td  class="dialogTd" align="right" valign="top">备注：</td>
														<td  class="dialogTd" colspan="3"><textarea
																class="easyui-validatebox" id="bz" name="bz"
																maxlength="1000" style="width:750px;height:48px"
																data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
														</td>
													</tr>
												</table>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div style="height:6px;font-size:1px;"></div>
							<div id="saveDiv"
								style="text-align:center; height:50px; padding-top: 10px; display:block;">
								<a id="saveButton" class="l-btn l-btn-small"
									href="javascript:void(0)" group=""> <span
									class="l-btn-left l-btn-icon-left"> <span
										class="l-btn-text">提交申请</span> <span
										class="l-btn-icon icon-save"> </span> </span> </a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="backButton"
									class="l-btn l-btn-small" href="javascript:void(0)" group="">
									<span class="l-btn-left l-btn-icon-left"> <span
										class="l-btn-text">关闭</span> <span
										class="l-btn-icon icon-cancel"> </span> </span> </a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="resetBotton"
									class="l-btn l-btn-small" href="javascript:void(0)" group="">
									<span class="l-btn-left l-btn-icon-left"> <span
										class="l-btn-text">重置</span> <span
										class="l-btn-icon icon-reset"> </span> </span> </a>
							</div></td>

					</tr>
				</table>
			</div>
			<div
				style="float:left;width:250px;min-height:200px;margin-left:25px;*margin-left:5px;">
				<ul class="colli">
					<c:forEach var="item" items="${list}">
						<li>
							<div style="line-height:20px;">该线索征集信息${item.sjonlist}由${item.bmonlist}${item.sprxmonlist}进行审批处理</div>
							<div>处理状态：${item.spzt}</div>
							<div>审批回复：${item.sphf}</div></li>
					</c:forEach>
					<li>该线索征集信息${sjnew}由<span id="sqdwmcSpan"></span>的<span
						id="sqrxmSpan"></span>发出申请</li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
if("${entity.sqr}"=="") {
	document.getElementById('sqr').add(new Option("<%=userName%>","<%=userId%>"));
	$('#sqdwmcSpan').html("<%=orgName%>");
	$('#sqrxmSpan').html("<%=userName%>");
}
else{
 	document.getElementById('sqr').add(new Option("${entity.sqrxm}","${entity.sqr}"));
	$('#sqdwmcSpan').html("${entity.xt_lrrbm}");
	$('#sqrxmSpan').html("${entity.sqrxm}");
 }
if("${entity.sqdw}"=="") $("#sqdw").val('<%=orgCode%>');
		$(function() {
			$('#xszjForm').form({

				onSubmit : function() {

					return $(this).form('validate');
				},
				success : function(data) {
					var json = $.parseJSON(data);
					if (json.status != 'success') {

						topMessagerAlert(null, json.message);
					} else {

						$("#id").val(json.saveID);
						executeTabPageMethod(mainTabID, "reloadDg");
						topMessagerAlert(null, "保存成功","success");
						closeSelf();
					}
				}
			});
			if ($('#id').val() != '') {
				setInputReadonly('sqr', true);
				setInputReadonly('sqsj', true);
				$('#sqsj').removeAttr("onclick");
				setInputReadonly('ajxz', true);
				setInputReadonly('sqrlxfs', true);
				setInputReadonly('sqdw', true);
				setInputReadonly('jyaq', true);
				setInputReadonly('zjdxsxx', true);
				setInputReadonly('bz', true);
				$('#saveButton').hide();
				$('#resetBotton').hide();
			}
			$('#saveButton').click(function() {

				topMessager.confirm('操作确认', '您是否保存任务信息？', function(r) {

					if (r) {
						$('#xszjForm').submit();
					}
				});
			});

			$('#backButton').click(function() {

				closeSelf();
			});

			$('#resetBotton').click(function() {
				if ('' == $('#id').val()) {
					$('#sqsj').val('');
					$('#ajxz').combobox('setValue', '');
					$('#sqrlxfs').val('');
					$('#jyaq').val('');
					$('#zjdxsxx').val('');
					$('#bz').val('');
				} else {
					$('#sqsj').val('${entity.sqsj}');
					$('#ajxz').combobox('setValue', '${entity.ajxz}');
					$('#sqrlxfs').val('${entity.sqrlxfs}');
					$('#jyaq').val('${entity.jyaq}');
					$('#zjdxsxx').val('${entity.zjdxsxx}');
					$('#bz').val('${entity.bz}');
				}
			});
		});
	</script>
</body>
</html>