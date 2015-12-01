<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [jhyxswAdd.jsp]   
 * @Description:  [集会游行示威添加页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 
 
  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */


%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>集会游行示威添加</title>
		<script type="text/javascript" src="<%=contextPath%>/js/jhyxsw/jhyxswAdd.js"></script>
		<script type="text/javascript">
		var mainTabID = "${mainTabID}";
		</script>
	</head>
<body style="margin-top:20px" class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" align="center" class="bodybg">
		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
			<form action="<%=basePath%>/jhyxswjbxxb/saveJhyxswjbxxb" id="dataForm" name="dataForm" method="post">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<input type="hidden" id="flag" value="${flag}">
				<table width="100%" cellpadding="0" cellspacing="3" border="0">
					<tr>
						<td>
							<table width="700" align="center" cellpadding="0" cellspacing="3"border="0" bgcolor="#FFFFFF">
								<tr class="dialogTr">
									<td height="30" colspan="4" align="left" style="border-bottom:#000000 solid 1px;">
										<h1 align="left" style=" font-size:12px; font-weight:bold;color: blue">申请人信息</h1>
									</td>
								</tr>
								<tr>
									<td width="25%" height="37" align="right">公民身份号码：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox" type="text" id="gmsfhm" name="gmsfhm" 
										value="${entity.gmsfhm}" maxlength="19" style="width:240px;"
										data-options="required:true,
									  	validType:['sfzh'],
										tipPosition:'left'" />
									</td>
									<td width="17%" align="right">姓名：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox" type="text" id="xm" name="xm"
										value="${entity.xm}" maxlength="21" style="width:240px;"
										data-options="required:true,
										validType:['maxLength[20]'],
										tipPosition:'left'" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" align="right">性别：</td>
									<td width="50%" align="left">
										<input type="text" name="xbdm" id="xbdm" value="${entity.xbdm}" 
										class="easyui-combobox " style="width:240px;"
										data-options="required:true,
										url: contextPath + '/common/dict/D_BZ_XB.js',
						               	valueField:'id',
						               	textField:'text',
						               	tipPosition:'left',
						               	selectOnNavigation:false,
						               	method:'get'" />
									</td>
									<td width="17%" align="right">年龄：</td>
									<td width="50%" align="left">
										<input class='easyui-validatebox'type='text' name='nl' id="nl" 
										value="${entity.nl}" style="width:240px;" maxlength="18"
										data-options="required:true, validType:['naturalNumber']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" height="36" align="right">民族：</td>
									<td width="50%" align="left">
										<input type="text" name="mzdm" id="mzdm" value="${entity.mzdm}" 
										class="easyui-combobox " style="width:240px;"
										data-options="required:true,
										url: contextPath + '/common/dict/GB_D_MZDM.js',
						              	valueField:'id',
						              	textField:'text',
					              		tipPosition:'left',
						              	selectOnNavigation:false,
						              	method:'get'" />
									</td>
									<td width="17%" align="right">职业：</td>
									<td width="50%"align="left">
										<input class="easyui-validatebox" type="text" id="zy" name="zy" 
										value="${entity.zy}" maxlength="60" style="width:240px;"
										data-options="required:true,
									    validType:['maxLength[60]'],
									    tipPosition:'left'" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" height="36" align="right">联系电话：</td>
									<td width="50%" align="left">
										<input class='easyui-validatebox' type='text' name='lxdh' 
										id="lxdh" value="${entity.lxdh}" style="width:240px;" maxlength="18"
										data-options="required:true,
									    validType:['phone']" />
									</td>
									<td align="right">&nbsp;</td>
									<td align="right">&nbsp;</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%"height="36" align="right">工作单位：</td>
									<td colspan="3">
										<input type="text" id="gzdw1" value="${entity.gzdw}" 
										class="easyui-combobox" maxlength="100" style="width: 590px;"
										data-options="mode:'remote',
								        method:'post',
								        panelHeight: 22,
								        valueField:'id',
								        textField:'text',
								        selectOnNavigation:false,
								        required:true,
								        validType:['maxLength[50]']" />
										<input type="hidden" name="gzdwid" id="gzdwid" value="${entity.gzdwid}" /> 
										<input type="hidden" name="gzdw" id="gzdw" value="${entity.gzdw}" />
									</td>
								</tr>
								<tr class="dialogTr" id="jzdz">
									<td width="17%" height="36" align="right">家庭住址：</td>
									<td colspan="2" align="left" class="dialogTd">
										<input class="easyui-combobox" id="jzd1" style="width:320px;" 
										value="${entity.dz_jzdmlpxz}"
										data-options="required:true,
				                        mode:'remote',
				                        method:'post',
				                        panelHeight: 22,
				                        valueField:'id',
				                        textField:'text',
				                        selectOnNavigation:false">
										<input type='hidden' name='dz_jzdmlpdm' id="dz_jzdmlpdm" value="${entity.dz_jzdmlpdm}" /> 
										<input type='hidden' name='dz_jzdmlpxz' id="dz_jzdmlpxz"value="${entity.dz_jzdmlpxz}" />
									</td>
									<td align="left" class="dialogTd">
										<input class="easyui-combobox" id="jzd2" style="width:240px;" 
										value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdmlpxz, "")}'
										data-options="required:false,
				    	                mode:'remote',
				    	                method:'post',
				    	                panelHeight: 22,
				    	                valueField:'id',
				    	                textField:'text',
				    	                selectOnNavigation:false">
										<input type='hidden' name='dz_jzdzdm' id='dz_jzdzdm' value="${entity.dz_jzdzdm}" /> 
										<input type='hidden' name='dz_jzdzssxdm' id='dz_jzdzssxdm' value="${entity.dz_jzdzssxdm}" /> 
										<input type='hidden' name='dz_jzdzxz' id='dz_jzdzxz' value="${entity.dz_jzdzxz}" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td height="36" colspan="4" style="border-bottom:#000000 solid 1px;">
										<h1 align="left" style=" font-size:12px; font-weight:bold;color: blue">示威游行信息</h1>
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" height="36" align="right">申请时间：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox"
										type="text" id="sqsj" name="sqsj" value="${entity.sqsj}"
										style="width:240px;"
										data-options="required:true,
                                        validType:['date[\'yyyy-MM-dd\']'],
                                        tipPosition:'right'"
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'kssj\') }'})" />
									</td>
									<td width="17%" align="right">活动方式：</td>
									<td width="50%" align="left">
										<input type="text" name="hdfsdm"
										id="hdfsdm" value="${entity.xbdm}" class="easyui-combobox "
										style="width:240px;"
										data-options="required:true,
										url: contextPath + '/common/dict/D_AQFF_HDFS.js',
										valueField:'id',
										textField:'text',
										tipPosition:'left',
										selectOnNavigation:false,
										method:'get'" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%"height="36" align="right">目的：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox"
										type="text" id="md" name="md" value="${entity.md}"
										maxlength="101" style="width:240px;"
										data-options="required:true,
										validType:['maxLength[100]'],
										tipPosition:'left'" />
									</td>
									<td  width="17%" align="right">参加人数：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox"
										type="text" id="cjrs" name="cjrs" value="${entity.cjrs}"
										style="width:240px;"
										data-options="required:true,
						                tipPosition:'left',
						                validType:['numeric[\'i\']']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" height="36" align="right">开始时间：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox"
										type="text" id="kssj" name="kssj" value="${entity.kssj}"
										style="width:240px;"
										data-options="required:true,
                                        validType:['date[\'yyyy-MM-dd\']'],
                                        tipPosition:'right'"
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'jssj\') }',minDate:'#F{$dp.$D(\'sqsj\') }'})" />
									</td>
									<td width="17%" height="36" align="right">结束时间：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox"
										type="text" id="jssj" name="jssj" value="${entity.jssj}"
										style="width:240px;"
										data-options="required:true,
				                        validType:['date[\'yyyy-MM-dd\']'],
				                        tipPosition:'right'"
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'kssj\') }'})" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" height="36" align="right">集合地：</td>
									<td width="50%" align="left">
										<input class="easyui-validatebox"
										type="text" id="jhd" name="jhd" value="${entity.jhd}"
										style="width:240px;" maxlength="101"
										data-options="required:true,
										validType:['maxLength[100]'],
						                onlyLeaf:true,
						                panelWidth:220,
										method:'get',
										editable:true,
										lines:true" />
									</td>
									<td width="17%" height="36" align="right">解散地：</td>
									<td width="50%" align="left">
										<input class='easyui-validatebox'
										type='text' name='jsd' id="jsd" value="${entity.jsd}"
										style="width:240px;" maxlength="101"
										data-options="required:true,
										validType:['maxLength[100]']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%" height="36" align="right">维持秩序人数：</td>
									<td width="50%" colspan="3" align="left">
										<input class='easyui-validatebox' type='text' name='wczxrs'
										id="wczxrs" value="${entity.wczxrs}" style="width:240px;"
										data-options="required:true,
										validType:['numeric[\'i\']']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td width="17%"height="36" align="right">使用音响：</td>
									<td width="50%" colspan="3" align="left">
										<input class='easyui-validatebox' type='text' name='syyx' id="syyx"
										value="${entity.syyx}" style="width:590px;" maxlength="101"
										data-options="required:true,
										validType:['maxLength[100]']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td height="36" align="right">使用车辆：</td>
									<td colspan="3" align="left">
										<input class='easyui-validatebox' type='text' name='sycl' id="sycl"
										value="${entity.sycl}" style="width:590px;" maxlength="201"
										data-options="required:true,
										validType:['maxLength[200]']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td height="36" align="right">游行示威路线：</td>
									<td colspan="3" align="left">
										<input class='easyui-validatebox' type='text' name='yxswlx'
										id="yxswlx" value="${entity.yxswlx}" style="width:590px;"
										maxlength="201" data-options="required:true,
										validType:['maxLength[200]']" />
									</td>
								</tr>
								<tr class="dialogTr">
									<td height="60" align="right">集合示威场所：</td>
									<td colspan="3" align="left">
										<textarea id="jhswcs"
										name="jhswcs" class="easyui-validatebox"
										style="width: 590px; height:48px;"
										data-options="required:true,
						                validType:['maxLength[200]'],
						                invalidMessage:'不能超过200个汉字，请重新输入！',
						                tipPosition:'left'">${entity.jhswcs}</textarea>
									</td>
								</tr>
								<tr class="dialogTr">
									<td height="60" align="right">标语、口号：</td>
									<td colspan="3" align="left">
										<textarea id="bykh"
										name="bykh" class="easyui-validatebox"
										style="width: 590px; height:48px;"
										data-options="required:true,validType:['maxLength[200]'],
										invalidMessage:'不能超过200个汉字，请重新输入！',
										tipPosition:'left'">${entity.bykh}</textarea>
									</td>
								</tr>
								<tr class="dialogTr">
									<td height="60" align="right">备注：</td>
									<td colspan="3" align="left">
										<textarea id="bz" name="bz"
										class="easyui-validatebox" style="width: 590px; height:48px;"
										data-options="required:true,
							            validType:['maxLength[1000]'],
							            invalidMessage:'备注不能超过1000个汉字，请重新输入！',
							            tipPosition:'left'">${entity.bz}</textarea>
									</td>
								</tr>
								<tr class="dialogTr" align="center">
									<td height="40" colspan="4">
										<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
											<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group=""> 
												<span class="l-btn-left l-btn-icon-left"> 
													<span class="l-btn-text">保存</span> 
													<span class="l-btn-icon icon-save"> </span> 
												</span> 
											</a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a id="restBotton" class="l-btn l-btn-small" href="javascript:void(0)" group=""> 
												<span class="l-btn-left l-btn-icon-left"> 
													<span class="l-btn-text">重置</span> 
													<span class="l-btn-icon icon-reload"> </span> 
												</span> 
											</a>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div> 
</body>
</html>
