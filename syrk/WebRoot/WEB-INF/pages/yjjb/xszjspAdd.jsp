<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>线索征集审批</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<script type="text/javascript">
	var mainTabID = '${mainTabID}';
	var mode = '${mode}';
</script>
</head>
<body  class="easyui-layout"
	data-options="fit:true">
	<div data-options="region:'center', split:true"
		style="border-width: 0px;margin:0 0 0;text-align:center;"
		class="bodybg">
		<table height="100%" style="margin:0 auto;">
			<tr>
				<td height="100%" valign="top" align="center">
					<div class="pop_conta">
						<div class="pop_contb">
							<div class="pop_contc">

								<form action="<%=basePath%>xszjspb/save" id="xszjspForm"
									name="xszjspForm" method="post">
									<div data-options="region:'center', split:true"
										style="width:1000px; border-width: 0px;">
										<input type="hidden" id="id" name="id" value="${entity.id}" />
										<input type="hidden" id="sqbh" name="sqbh"
											value="${entity.sqbh}" /> <input type="hidden" id="spzt"
											name="spzt" value="${entity.spzt}" /> <input type="hidden"
											id="sphf" name="sphf" value="${entity.sphf}" /> <input
											type="hidden" id="spdw" name="spdw" value="${entity.spdw}" />
									
										
										<table border="0" cellpadding="0" cellspacing="10"
											width="100%" align="center">
											<tr class="dialogTr">
												<td width="100" class="dialogTd" align="right">申请人：</td>
												<td width="300" class="dialogTd"><select
													class="easyui-combobox" id="sqr" name="sqr"
													style="width:300px;"
													data-options="required:true, selectOnNavigation:false,method:'get'"
													readonly>
														<option value="${entity1.sqr}" selected>${entity1.xt_lrrxm}</option>
												</select></td>
												<td width="250" class="dialogTd" align="right">申请时间：</td>
												<td width="300" class="dialogTd"><input
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
													value="${entity1.ajxz}" style="width:300px;"
													data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
												</td>
												<td class="dialogTd" align="right">联系方式：</td>
												<td  class="dialogTd"><input
													class="easyui-validatebox" type="text" id="sqrlxfs"
													name="sqrlxfs" value="${entity1.sqrlxfs}" maxlength="1000"
													style="width:300px;"
													data-options="required:true,validType:['maxLength[1000]'],tipPosition:'right'" />
												</td>
											</tr>
											<tr class="dialogTr">
												<td  class="dialogTd" align="right">申请单位：</td>
												<td  class="dialogTd" colspan="3"><input
													class="easyui-combobox" id="sqdw" name="sqdw"
													value="${entity.sqdw}" maxlength="100" style="width:870px;"
													data-options="required:true,
				    		url: contextPath + '/common/queryOrg',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"
													readonly /></td>
											</tr>
											</tr>
											<tr class="dialogTr">
												<td  class="dialogTd" align="right" valign="top">简要案情：</td>
												<td  class="dialogTd" colspan="3"><textarea
														class="easyui-validatebox" id="jyaq" name="jyaq"
														maxlength="1000" style="width:870px;height:48px"
														data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'简要案情不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity1.jyaq}</textarea>
												</td>
											</tr>
											<tr class="dialogTr">
												<td  class="dialogTd" align="right" valign="top">征集线索信息：</td>
												<td  class="dialogTd" colspan="3"><textarea
														class="easyui-validatebox" id="zjdxsxx" name="zjdxsxx"
														maxlength="1000" style="width:870px;height:48px"
														data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'征集线索信息不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity1.zjdxsxx}</textarea>
												</td>
											</tr>
											<tr class="dialogTr">
												<td class="dialogTd" align="right" valign="top">备注：</td>
												<td class="dialogTd" colspan="3"><textarea
														class="easyui-validatebox" id="bz" name="bz"
														maxlength="1000" style="width:870px;height:48px"
														data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
												</td>
											</tr>
											<c:forEach var="item" items="${list}" varStatus="status">
											
												
												<tr class="dialogTr">
													<td class="dialogTd" align="right">
													<input type="hidden" id="spzt${status.index+1}"
													name="spzt${status.index+1}" value="${item.spzt}" />审批单位：</td>
													<td  class="dialogTd" colspan="3"><input
														class="easyui-combobox" id="spdw${status.index+1}"
														name="spdw${status.index+1}" value="${item.spdw}"
														maxlength="100" style="width:870px;"
														data-options="required:true,
				    		url: contextPath + '/common/queryOrg',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"
														readonly /></td>
												</tr>
												<tr class="dialogTr">
													<td  class="dialogTd" align="right">审批回复：</td>
													<td  class="dialogTd" colspan="3"><textarea
															class="easyui-validatebox" id="sphf${status.index+1}"
															name="sphf${status.index+1}" maxlength="1000"
															style="width:870px;height:48px"
															data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${item.sphf}</textarea>
													</td>
												</tr>
											</c:forEach>

										</table>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div style="height:6px;font-size:1px;"></div> <a id="backButton"
					class="l-btn l-btn-small" href="javascript:void(0)" group=""> <span
						class="l-btn-left l-btn-icon-left"> <span
							class="l-btn-text">关闭</span> <span class="l-btn-icon icon-cancel">
						</span> </span> </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="resetBotton"
					class="l-btn l-btn-small" href="javascript:void(0)" group=""> <span
						class="l-btn-left l-btn-icon-left"> <span
							class="l-btn-text">重置</span> <span class="l-btn-icon icon-reset">
						</span> </span> </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="agreeBotton"
					class="l-btn l-btn-small" href="javascript:void(0)" group=""> <span
						class="l-btn-left l-btn-icon-left"> <span
							class="l-btn-text">同意</span> <span class="l-btn-icon icon-ok">
						</span> </span> </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="refuseBotton"
					class="l-btn l-btn-small" href="javascript:void(0)" group=""> <span
						class="l-btn-left l-btn-icon-left"> <span
							class="l-btn-text">拒绝</span> <span class="l-btn-icon icon-no">
						</span> </span> </a>
					</div></td>

			</tr>
		</table>
	</div>

	<script type="text/javascript">
		$(function() {
			$('#xszjspForm').form({

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
						topMessagerAlert(null, "审批成功","success");
						closeSelf();
					}
				}
			});
			var listcount = 0;
			function setInputReadonlys() {
				setInputReadonly('sqr', true);
				setInputReadonly('sqsj', true);
				$('#sqsj').removeAttr("onclick");
				setInputReadonly('ajxz', true);
				setInputReadonly('sqrlxfs', true);
				setInputReadonly('sqdw', true);
				setInputReadonly('jyaq', true);
				setInputReadonly('zjdxsxx', true);
				setInputReadonly('bz', true);
				while ($("#spzt" + (listcount + 1)).val() != undefined) {
					if ("0" != $("#spzt" + (listcount + 1)).val()) {
						setInputReadonly('spdw' + (listcount + 1), true);
						setInputReadonly('sphf' + (listcount + 1), true);
					}
					listcount++;
				}
				if ("0" != "${entity.spzt}") {
					$('#resetBotton').hide();
					$('#agreeBotton').hide();
					$('#refuseBotton').hide();
				}
			}
			setInputReadonlys();

			$('#backButton').click(function() {

				closeSelf();
			});

			$('#resetBotton').click(function() {
				$("#sphf" + listcount).val('');
			});
			$('#agreeBotton').click(function() {
				topMessager.confirm('操作确认', '您是否同意？', function(r) {
					if (r) {
						$("#spzt").val("1");
						$("#sphf").val($('#sphf' + listcount).val());
						$("#spdw").val($('#spdw' + listcount).val());
						$('#xszjspForm').submit();
					}
				});
			});
			$('#refuseBotton').click(function() {
				topMessager.confirm('操作确认', '您是否拒绝？', function(r) {
					if (r) {
						$("#spzt").val("2");
						$("#sphf").val($('#sphf' + listcount).val());
						$("#spdw").val($('#spdw' + listcount).val());
						$('#xszjspForm').submit();
					}
				});
			});
		});
	</script>
</body>
</html>