<!--  
	@updateAuthor: [yuguangli@founder.com]
	@updateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位检查信息</title>
<style>
.thhead {
	text-align: center;
	background: #e1e1e1;
	border: 1px solid #cccccc;
}

.tdbr {
	border-right: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
}

.tdb {
	border-bottom: 1px solid #cccccc;
}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>dwjcxxb/save" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="dwmc" id="dwmc" value="${entity.dwmc}" />
			<input type="hidden" name="ywlbdm" id="ywlbdm" value="${entity.ywlbdm}"/>
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
					<input type="hidden" name="id" id="pk" value="${entity.id}" />
					<input type="hidden" name="rwid" id="rwid" value="${rwid}" />
					<tr class="dialogTr" id="tr1">
						<td width="20%" class="dialogTd" align="right">单位名称：</td>
						<td width="34%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="dw-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true"
								style="width:200px;" />
						</td>
						<td width="16%" class="dialogTd" align="right">单位类型：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
								style="width:200px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
								method:'get',editable:true,lines:true,required:true,tipPosition:'left'"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">单位负责人：</td>
						<td width="34%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="dwfzr" id="dwfzr"
								data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
								style="width:200px" value="${entity.dwfzr}" />
						</td>
						<td width="16%" class="dialogTd" align="right">单位负责人联系电话：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" name="dwfzrlxdh" id="dwfzrlxdh" data-options="required:false,validType:['phone'],tipPosition:'left'" type="text" style="width:200px;" maxlength="30" value="${entity.dwfzrlxdh}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">检查时间：</td>
						<td width="34%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="jcsj" id="jcsj" style="width:200px;"
								data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" value="${entity.jcsj}"/>
						</td>
						<td width="16%" class="dialogTd" align="right">参检人数：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" name="cjrs" id="cjrs" type="text" style="width:200px;" data-options="required:false,validType:['naturalNumberRange[1,100]'],tipPosition:'left'" value="${entity.cjrs}"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">检查单位：</td>
						<td width="34%" class="dialogTd">
							<input type="hidden" id="jcdwid" name="jcdwid" value="${entity.jcdwid}"/> 
							<input class="easyui-validatebox inputreadonly" type="text" id="jcdw" name="jcdw"  value="${entity.jcdw}" maxlength="50" style="width: 200px;" readonly="readonly" /> 
							<input type="hidden" id="orgid1" name="orgid1" value=""/> 
							<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '', '', 'jcdwid', 'jcdw', 'orgid1', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
						</td>
						<td width="16%" class="dialogTd" align="right">检查人员：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="jcry" id="jcry" data-options="required:false,validType:['maxLength[100]'],tipPosition:'left'" value="${entity.jcry}" style="width:200px" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="dialogTd" align="right">现场负责人：</td>
						<td width="34%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="xcfzr" id="xcfzr" value="${entity.xcfzr}"
								data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"
								style="width:200px;" />
						</td>
						<td width="16%" class="dialogTd" align="right">现场负责人联系电话：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="xcfzrlxdh" id="xcfzrlxdh" value="${entity.xcfzrlxdh}" data-options="required:false,validType:['phone'],tipPosition:'left'" style="width:200px;" maxlength="30"/>
						</td>
					</tr>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right" style="vertical-align: top;">
							<br />检查项信息：
						</td>
						<td width="80%" class="dialogTd" colspan="3">
							<input type="hidden" id="jcxmx" name="jcxmx"/>
							<table style="width:620px;border:  1px solid #cccccc;" cellpadding="0" cellspacing="0">
								<tr style="height: 25px;">
									<td style="width:130px;" class="thhead">类目</td>
									<td style="width:343px;" class="thhead">检查项目</td>
									<td style="width:20px;" class="thhead">是</td>
									<td style="width:20px;" class="thhead">否</td>
									<td style="width:97px;" class="thhead">备注</td>
								</tr>
								<c:choose>
									<c:when test="${list != null and fn:length(list) !=0}">
										<c:forEach items="${list}" var="dwjctype" varStatus="status">
											<tr>
												<td style="width:130px;" class="tdbr">${status.index+1}、${dwjctype.name} 
													<input type="hidden" id="type_${dwjctype.id}" value="${dwjctype.id}" />
												</td>
												<td colspan="4" style="width:490px;">
													<table style="width:100%" cellpadding="0" cellspacing="0">
														<c:forEach items="${dwjctype.list}" var="dwjcdata" varStatus="data">
															<tr>
																<td style="width:400px;" class="tdbr">${data.index+1}）${dwjcdata.name}
																	<input type="hidden" id="data_${dwjctype.id}" value="${dwjcdata.id}" />
																</td>
																<c:choose>
																	<c:when test="${dwjcdata.def == '1'}">
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" checked value="1" />
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="0"/>
																		</td>
																	</c:when>
																	<c:when test="${dwjcdata.def == '0'}">
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="1"/>
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" checked value="0" />
																		</td>
																	</c:when>
																	<c:otherwise>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="1" />
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="0" />
																		</td>
																	</c:otherwise>
																</c:choose>
																<td style="width:100px;height: 100%;" class="tdb">
																	<textarea id="bz_${dwjcdata.id}" class="easyui-validatebox"
																		style="width:100px;height: 100%;">${dwjcdata.bz}</textarea>
																</td>
															</tr>
														</c:forEach>
													</table>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td style="border-left:1px solid #cccccc;height:30px;color: red;text-align: center;font-size: 13px;" class="tdbr" colspan="5">
												无配置检查项信息,请联系管理员...
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</table>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">其他违规情况和安全隐患：</td>
						<td width="80%" class="dialogTd" colspan='3'>
							<textarea id="qtwgqkhaqyh" name="qtwgqkhaqyh" class="easyui-validatebox" style="width: 620px; height:48px;"
								data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'其他违规情况和安全隐患不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.qtwgqkhaqyh}</textarea>
						</td>
					</tr>
					<tr>
						<td width="20%" class="dialogTd" align="right">检查结果：</td>
						<td width="80%" class="dialogTd" colspan='3'>
							<textarea id="jcjg" name="jcjg" class="easyui-validatebox" style="width: 620px;height:48px;"
								data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jcjg}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">整改通知书或裁决书号：</td>
						<td width="34%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="zgtzshcjsh" id="zgtzshcjsh" maxlength="30"
							data-options="validType:['maxLength[30]'],tipPosition:'right'"
							style="width:200px" value="${entity.zgtzshcjsh}" />
						</td>
						<td width="16%" class="dialogTd" align="right">整改通知书名称：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" name="zgtzsmc" id="zgtzsmc"
							data-options="validType:['maxLength[30]'],tipPosition:'left'"
							value="${entity.zgtzsmc}" style="width:200px" />
						</td>
					</tr>
	
					<tr>
						<td width="20%" class="dialogTd" align="right">整改或处罚意见：</td>
						<td width="80%" class="dialogTd" colspan='3'>
							<textarea id="zghcfyj" name="zghcfyj" class="easyui-validatebox" style="width: 620px; height:48px;"
								data-options="validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zghcfyj}</textarea>
						</td>
					</tr>
					<tr>
						<td width="20%" class="dialogTd" align="right">备注：</td>
						<td width="80%" class="dialogTd" colspan='3'>
							<textarea id="bz" name="bz" class="easyui-validatebox" style="width:620px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
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
		$("#dwmc").val(paramArray["dwmc"]);
		$("#dw-box").combobox("setText",paramArray["dwmc"]);
		$("#dwlbdm").combotree("setValue",paramArray["dwlbdm"]);
		$("#ywlbdm").val(paramArray["ywlbdm"]);
		checkboxToRadio();
		if(paramArray["mode"]=='view'){
			$('#dataForm').find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
			$('#dataForm').find('textarea').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
			});
			$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
				$(o).attr('disabled','disabled');
			});
			$('#orgbutton1').hide();
		}else if(paramArray["mode"]=='select'){
			//单位选择组件
			initDepartmentSearch('dw-box', {glpcsid: ''}, 'dwid', 'dwmc', null, null);
		}else{
			$("#tr1").find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
		}
	}
	function beforeSubmit() {
		var jcxparamsMap = "[";
		$("input:hidden[id^='type_']").each(function(index, domEle) {
			var typeid = $(domEle).val();
			jcxparamsMap += "{\"typeid\":\"" + typeid + "\",\"list\":[";
			$("input:hidden[id='data_" + typeid + "']").each(function(index, domEle) {
				var dataid = $(domEle).val();
				var checkboxs = $("input:checkbox[id='ch_" + dataid + "']:checked");
				var def = "";
				if (checkboxs.length == 1) {
					def = checkboxs[0].value;
				};
				var bz = $("#bz_" + dataid).text();
				jcxparamsMap += "{\"dataid\":\""+ dataid + "\",\"def\":\"" + def + "\",\"bz\":\"" + bz + "\"},";
			});
			jcxparamsMap += "],";
			jcxparamsMap = jcxparamsMap.replace("},]", "}]}");
		});
		jcxparamsMap += "]";
		jcxparamsMap = jcxparamsMap.replace("},]", "}]");
		$("#jcxmx").val(jcxparamsMap);
	}

	function afterSubmit(arr) {
		if (arr["saveID"]) {
			$("#pk").val(arr["saveID"]);
		}
		executeTabPageMethod(mainTabID, "queryButton()");
	}
	
	function checkboxToRadio() {
		checkboxs = $("input:checkbox[id^='ch_']");
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
</script>

